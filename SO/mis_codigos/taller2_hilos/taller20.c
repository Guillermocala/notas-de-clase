/*INTEGRANTES
GUILLERMO CALA
SEBASTIAN AHUMADA
JUAN BERMUDES
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <math.h>
#include <sys/types.h>
#include <time.h>
#include <sys/time.h>

//inicio y final son los limites de una dimension (fila o columna)
//y profundidad hace referencia a cuantas filas o columnas voy a tener
struct hilo {
    int inicio;
    int final;
    int profundidad;
};

//estos valores quedan globales porque facilita mucho el proceso en varias areas del codigo
int **matriz = NULL;
int cant_dias, filas, columnas;
//el vector de estructuras que dice que segmento de la matriz le pertenece a cada hilo
struct hilo *lista_hilos = NULL;

/*como la matriz es pequeña se usa mutex para evitar conflicto al cambiar los datos de la matriz
ya sea porque un sano pasa a infectado o un infectado a recuperado*/
pthread_mutex_t mt = PTHREAD_MUTEX_INITIALIZER;

void *funcion(void *arg);
int calcular_vecindario(int x, int y, int tipo); //cuenta los datos de un tipo(tipo) para el rango (x, y)
void imprime_matriz();

int main(int argc, char *argv[]){
    int CANT_HILOS;

    //lectura de archivo
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);
    
    //extraemos variables del archivo
    fscanf(file, "%d", &cant_dias);
    fscanf(file, "%d", &filas);
    fscanf(file, "%d", &columnas);

    //ahora viene la operacion para una matriz dinamica
    //asignamos memoria dinámica para la matriz entorno a filas
    matriz = (int **)malloc(filas * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al asignar memoria para las filas\n");
        fclose(file);
        exit(EXIT_FAILURE);
    }
    //asignamos memoria dinámica para la matriz entorno a columnas
    for (int i = 0; i < filas; i++) {
        matriz[i] = (int *)malloc(columnas * sizeof(int));
        if (matriz[i] == NULL) {
            printf("Error al asignar memoria para las columnas\n");
            // Liberar memoria previamente asignada
            for (int j = 0; j < i; j++) {
                free(matriz[j]);
            }
            free(matriz);
            fclose(file);
            exit(EXIT_FAILURE);
        }
    }
    //alimentamos la matriz
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            int temp;
            fscanf(file, "%d", &temp);
            matriz[i][j] = temp;
        }
    }
    fclose(file);
    //fin de operacion con la matriz
    /*aca asignamos que se va a trabajar con una asignacion de hijos par asi que
    en caso contrario el programa se termina*/
    if(filas != columnas || filas % 2 != 0) {
        printf("Error la matriz debe ser cuadrada y de orden par\n");
        exit(1);
    }
    //asignacion simple de hijos, solo hacemos que los hijos sean igual a dimension de la matriz / 2
    CANT_HILOS = filas / 2;

    //con la cantidad de hilos definida, repartimos memoria para la lista de hilos
    lista_hilos = (struct hilo *)malloc(CANT_HILOS * sizeof(struct hilo));

    //operacion para establecer las particiones de matriz para los hijos
    int temp_index = 0;
    for (int i = 0; i < CANT_HILOS; ++i) {
        lista_hilos[i].inicio = temp_index;
        temp_index += (filas / CANT_HILOS);
        lista_hilos[i].final = temp_index;
        lista_hilos[i].profundidad = filas;
    }

    //aca hacemos un control imprimiendo la matriz antes de hacer operaciones
    printf("Matriz inicial...\n");
    imprime_matriz();

    //asignamos la lista de los identificadores de los hijos
    pthread_t threads[CANT_HILOS];
    for (int i = 0; i < CANT_HILOS; i++) {
        /*como en el create no se puede pasar el identificador i ya que da problemas de concurrencia
        debido a que se da como una direccion de memoria local e innacesible para los hilos, entonces
        se envia por parametro la estructura del correspondiente hilo: lista_hilos[i]*/
        pthread_create(&threads[i], NULL, funcion, (void*)&lista_hilos[i]);
    }

    //espera por la terminacion de hilos
    for (int i = 0; i < CANT_HILOS; i++) { 
        pthread_join(threads[i], NULL);
    }

    //aca hacemos otro control imprimiendo la matriz después de que se hicieron todas las operaciones
    printf("Matriz final...\n");
    imprime_matriz();

    return 0;
}

void *funcion(void *arg) {
    //acá recibimos y hacemos el casting de la estructura correspondiente para este hijo
    struct hilo hilo = *(struct hilo*)arg;
    //sacamos los limites de la seccion de matriz que le toca
    int inicio = hilo.inicio;
    int final = hilo.final;
    int temp; //esto solo para hacer el conteo de los vecinos en el caso requerido
    for (int dia = 0; dia < cant_dias; dia++) { //acá se hace el ciclo para la cantidad de dias asignados
        printf("Hilo: [%lu]. Dia: [%d]\n", pthread_self(), dia); //solo para mostrar el hilo y el dia
        for (int i = inicio; i < final; i++) {
            for (int j = 0; j < hilo.profundidad; j++){
                /*se manejan 2 transiciones las cuales hay que operar: de SANO a INFECTADO y
                de INFECTADO a RECUPERADO*/
                if(matriz[i][j] == 0) { //si el individuo es SANO
                    temp = calcular_vecindario(inicio, final, 1); //calculamos la cantida de infectados
                    if(temp > 1) { //si al menoso tiene 2 infectados, se infecta
                        /*aca el mutex es por si acaso, para que no se genere conflictos*/
                        pthread_mutex_lock(&mt);
                        matriz[i][j] = 1; //el individuo para de SANO a INFECTADO
                        pthread_mutex_unlock(&mt);
                    }
                }
                else if(matriz[i][j] == 1){ //si el individuo es INFECTADO
                    temp = calcular_vecindario(inicio, final, 2); //calculamos la cantidad de recuperados
                    //calculamos la prob de que el individuo se recupere, y está relacionado a la cantidad de recuperados de su vecindario
                    float prob_recuperacion = 0.2 + (temp * 0.05);
                    //tal cual la rubrica, generamos un valor aleatorio(de 0 a 1) para confirmar si ese dato se recupera o no
                    float numero_aleatorio = (float)rand() / RAND_MAX;
                    if(prob_recuperacion > numero_aleatorio) { //si la prob recuperacionn supera al dato aleatorio
                        /*aca el mutex es por si acaso, para que no se genere conflictos*/
                        pthread_mutex_lock(&mt);
                        matriz[i][j] = 2; //el individuo pasa de IFECTADO a RECUPERADO
                        pthread_mutex_unlock(&mt);
                    }
                }
            }
        }
        //al final del dia imprimimos la matriz
        imprime_matriz();
    }
    pthread_exit(0);
}

int calcular_vecindario(int x, int y, int tipo) {
    /*funcion de calculo de vecindario normal, propuesta y explicada por el profesor en el segundo parcial
    como en la rubrica de este ejercicio no se especifica que suceden con los limites, entonces se ignora*/
	int cont = 0;
	for (int i = x - 1; i < x + 1; i++) {
		for (int j = y - 1; j < y + 1; j++) {
			if(i < 0 || j < 0 || i >= filas || j >= columnas) {
				/*por si el vecino excede los limites establecidos, pero como
                en este caso no se especifica nada, entonces se omite*/
			}
			else{
                //si el dato vecino es del tipo buscado, aumenta el contador
				if(matriz[i][j] == tipo) { cont++; }
			}
		}
	}
	return cont;
}

void imprime_matriz() { //acá no hay nada que explicar
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
}