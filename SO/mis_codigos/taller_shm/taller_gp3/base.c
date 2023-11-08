/*este codigo va a cargar en memoria 2 matrices y el hijo las multiplicara
para subir el resultado a la memoria que luego el padre leerá
Usar el archivo: test.in el cual tiene el formato indicado
psdt: la operacion es lo de menos así que ahi hay cosas que no están del todo
faciles de ver, cualquier cosa es un copia y pega de chatgpt
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/shm.h>
#include <sys/stat.h>

struct Data {
	//datos con los que va a trabajar
	int datos[100][100];
	int filas;
    int columnas;
};

struct Data multiplicar_matrices(struct Data matriz1, struct Data matriz2);
void imprimir_datos(struct Data datos);

int main(int argc, char *argv[]){
	struct Data *shared_array = NULL;

    // lectura de archivos
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);

	/*extraemos el primer dato del archivo que es la cantidad
	de matrices con las que trabajaremos*/
	int cant_matrices;
	fscanf(file, "%d", &cant_matrices);

	// almacenadores del id del padre y del hijo
	pid_t padre = getpid();
    pid_t hijo;

    // se crea la memoria compartida y se enlaza con el ptr shared_array
    // se le suma 1 porque el otro espacio es donde se escribirá el resultado
	int shmid = shmget(IPC_PRIVATE, sizeof(struct Data) * (cant_matrices + 1), IPC_CREAT|0600);
	shared_array = (struct Data*) shmat(shmid, 0, 0);

	// con esto leemos el archivo y almacenamos segun cada particion(hijo)
	for(int i = 0; i < cant_matrices; i++) {
		struct Data temp_data;
		int filas, columnas;
		fscanf(file, "%d", &filas);
		fscanf(file, "%d", &columnas);
		temp_data.filas = filas;
		temp_data.columnas = columnas;
		for (int j = 0; j < filas; j++) {
			for (int k = 0; k < columnas; k++) {
				int dato;
				fscanf(file, "%d", &dato);
				temp_data.datos[j][k] = dato;
			}
		}
		shared_array[i] = temp_data;
	}

    //se crea el hijo
    hijo = fork();

	if(getpid() == padre){
		// Esperar a que el hijo termine
		printf("\t\t\tPadre\n");
		waitpid(hijo, NULL, 0);
        // se recupera los datos de la memoria compartida y se imprime
		for(int i = 0; i <= cant_matrices; i++) {
			printf("\tMatriz %d\n", i);
			struct Data temporal = shared_array[i];
			imprimir_datos(temporal);
    	}
	}
	else{
        // seccion de los hijos
        /*se crea una estructura temporal para almacenar lo que esta en la memoria
        compartida y luego se hacen las operaciones*/
        struct Data matriz1, matriz2, matriz_resultado;
        matriz1 = shared_array[0];
        matriz2 = shared_array[1];
        matriz_resultado = multiplicar_matrices(matriz1, matriz2);   
        /*como temporal solo recibe y no crea enlace con la memoria compartida, entonces
        tenemos que guardar lo que hicimos sobreescribiendo dicha posicion de memoria compartida*/
        shared_array[2] = matriz_resultado;
	}

    // se desenlaza y borra el segmento de memoria
	shmdt(shared_array);
	shmctl(shmid, IPC_RMID, NULL);

	return EXIT_SUCCESS;
}

struct Data multiplicar_matrices(struct Data matriz1, struct Data matriz2) {
    // Verificar si las matrices se pueden multiplicar
    if (matriz1.columnas != matriz2.filas) {
        printf("Error: No se pueden multiplicar las matrices. El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.\n");
    }
    struct Data res;
    res.filas = matriz1.filas;
    res.columnas = matriz2.columnas;
    for(int i = 0; i < matriz1.filas; i++) {
        for(int j = 0; j < matriz2.columnas; j++) {
            res.datos[i][j] = 0;
            for(int k = 0; k < matriz1.columnas; k++) {
                res.datos[i][j] += matriz1.datos[i][k] * matriz2.datos[k][j];
            }
        }
    }
    return res;
}

void imprimir_datos(struct Data datos) {
    // Imprime los datos de la matriz
    for (int i = 0; i < datos.filas; i++) {
        for (int j = 0; j < datos.columnas; j++) {
            printf("%d ", datos.datos[i][j]);
        }
        printf("\n");
    }
    printf("Filas: %i\n", datos.filas);
    printf("Columnas: %i\n", datos.columnas);
}