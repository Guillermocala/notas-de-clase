/*este codigo esta hecho para una matriz de NxM, solo la estructura
basica haciendo una sumatoria de los elementos.
este fichero tiene una forma simplificada para hacer el tratamiento
de los datos del archivo
Usar el archivo: test2.in el cual tiene el formato indicado
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
	//campos en los que va a escribir
	int sumatoria;
};

int calcular_sumatoria(int matriz[100][100], int filas, int columnas);
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
	de particiones o de hijos con las que trabajaremos*/
	int cant_hijos;
	fscanf(file, "%d", &cant_hijos);

	// almacenadores del id del padre y el array de id's de los hijos
	pid_t padre = getpid();
	pid_t hijos[cant_hijos];

    // se crea la memoria compartida y se enlaza con el ptr shared_array
	int shmid = shmget(IPC_PRIVATE, sizeof(struct Data) * cant_hijos, IPC_CREAT|0600);
	shared_array = (struct Data*) shmat(shmid, 0, 0);

	// con esto leemos el archivo y almacenamos segun cada particion(hijo)
	for(int i = 0; i < cant_hijos; i++) {
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

    // creacion de hijos
	for(int i = 0; i < cant_hijos; i++) {
		hijos[i] = fork();
		if(!hijos[i]) { break; }
	}

	if(getpid() == padre){
		// Esperar a que los hijos terminen
		printf("\t\t\tPadre\n");
		for (int i = 0; i < cant_hijos; i++) {
			waitpid(hijos[i], NULL, 0);
			printf("Hijo %d termino su ejecucion.\n", i);
		}
        // se recupera los datos de la memoria compartida de cada hijo y se imprime
		for(int i = 0; i < cant_hijos; i++) {
			printf("\t\tHijo %d\n", i);
			struct Data temporal = shared_array[i];
			imprimir_datos(temporal);
    	}
	}
	else{
        // seccion de los hijos
		for(int i = 0; i < cant_hijos; i++) {
			if(!hijos[i]) {
                /*se crea una estructura temporal para almacenar lo que esta en la memoria
                compartida y luego se hacen las operaciones*/
				struct Data temporal = shared_array[i];
				temporal.sumatoria = calcular_sumatoria(temporal.datos, temporal.filas, temporal.columnas);
                /*como temporal solo recibe y no crea enlace con la memoria compartida, entonces
                tenemos que guardar lo que hicimos sobreescribiendo dicha posicion de memoria compartida*/
				shared_array[i] = temporal;
			}
		}
	}

    // se desenlaza y borra el segmento de memoria
	shmdt(shared_array);
	shmctl(shmid, IPC_RMID, NULL);

	return EXIT_SUCCESS;
}

int calcular_sumatoria(int matriz[100][100], int filas, int columnas) {
	int suma = 0;
	for(int i = 0; i < filas; i++) {
        for(int j = 0; j < columnas; j++) {
		    suma += matriz[i][j];
        }
	}
	return suma;
}

void imprimir_datos(struct Data datos) {
    // Imprime los datos de la matriz
    for (int i = 0; i < datos.filas; i++) {
        for (int j = 0; j < datos.columnas; j++) {
            printf("%d ", datos.datos[i][j]);
        }
        printf("\n");
    }

    // Imprime la sumatoria
    printf("Sumatoria de la matriz: %i\n", datos.sumatoria);
}