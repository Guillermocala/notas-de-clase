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
int **matriz = NULL, **resultado = NULL;
int filas, columnas;
//el vector de estructuras que dice que segmento de la matriz le pertenece a cada hilo
struct hilo *lista_hilos = NULL;

/*como la matriz es pequeña se usa mutex para evitar conflicto al cambiar los datos de la matriz
ya sea porque un sano pasa a infectado o un infectado a recuperado*/
pthread_mutex_t mt = PTHREAD_MUTEX_INITIALIZER;

void *funcion(void *arg);
void calcular_vecindario(int x, int y); //cuenta los datos de un tipo(tipo) para el rango (x, y)
void imprime_matriz(int **matriz, int filas, int columnas);

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
    fscanf(file, "%d", &filas);
    fscanf(file, "%d", &columnas);

    //ahora viene la operacion para una matriz dinamica
    //asignamos memoria dinámica para la matriz entorno a filas
    matriz = (int **)malloc(filas * sizeof(int *));
    resultado = (int **)malloc(filas * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al asignar memoria para las filas\n");
        fclose(file);
        exit(EXIT_FAILURE);
    }
    //asignamos memoria dinámica para la matriz entorno a columnas
    for (int i = 0; i < filas; i++) {
        matriz[i] = (int *)malloc(columnas * sizeof(int));
        resultado[i] = (int *)malloc(columnas * sizeof(int));
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
            resultado[i][j] = 0;
        }
    }
    fclose(file);
    //fin de operacion con la matriz

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
    imprime_matriz(matriz, filas, columnas);

    //asignamos la lista de los identificadores de los hijos
    pthread_t threads[CANT_HILOS];
    for (int i = 0; i < CANT_HILOS; i++) {
        pthread_create(&threads[i], NULL, funcion, (void*)&lista_hilos[i]);
    }

    //espera por la terminacion de hilos
    for (int i = 0; i < CANT_HILOS; i++) { 
        pthread_join(threads[i], NULL);
    }

    //aca hacemos otro control imprimiendo la matriz después de que se hicieron todas las operaciones
    printf("Matriz final...\n");
    imprime_matriz(resultado, filas, columnas);
    return 0;
}

void *funcion(void *arg) {
    //acá recibimos y hacemos el casting de la estructura correspondiente para este hijo
    struct hilo hilo = *(struct hilo*)arg;
    //sacamos los limites de la seccion de matriz que le toca
    printf("Hilo: [%lu]\n", pthread_self()); //solo para mostrar el hilo y el dia
    for (int i = hilo.inicio; i < hilo.final; i++) {
        for (int j = 0; j < hilo.profundidad; j++){
            calcular_vecindario(i, j);
        }
    }
    pthread_exit(0);
}

void calcular_vecindario(int x, int y) {
    /*funcion de calculo de vecindario normal, propuesta y explicada por el profesor en el segundo parcial
    como en la rubrica de este ejercicio no se especifica que suceden con los limites, entonces se ignora*/
    int cont = 0, suma = 0;
	for (int i = x - 1; i <= x + 1; i++) {
		for (int j = y - 1; j <= y + 1; j++) {
			if(i < 0 || j < 0 || i >= filas || j >= columnas) {
                //esto es para los bordes, como no dice la rubrica entonces no hace nada
			}
			else{
                cont++;
                suma += matriz[i][j];
			}
		}
	}
    
    suma /= cont;
    resultado[x][y] = suma;
}

void imprime_matriz(int **matriz, int filas, int columnas) { //acá no hay nada que explicar
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
}