/*este codigo solo funcionará bajo matrices cuadradas NxN, debido a que
la operacion que pide realizar(diagonal principal) es posible solo 
para este criterio
Usar el archivo: test.in para las pruebas, ese es el formato indicado
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/shm.h>
#include <sys/stat.h>

#define CANT_HIJOS 2
#define LIMIT_DIM 100

struct Data {
	//datos con los que va a trabajar
	int datos[LIMIT_DIM][LIMIT_DIM];
	int filas;
	int columnas;
	int finaliza1;
	int finaliza2;
};

void imprimir_datos(struct Data datos);
int calcular_vecindario(struct Data datos, int x, int y, int tipo);

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
	int cant_anios;
	fscanf(file, "%d", &cant_anios);

	int filas, columnas;
	fscanf(file, "%d", &filas);
	fscanf(file, "%d", &columnas);

	// almacenadores del id del padre y el array de id's de los hijos
	pid_t padre = getpid();
	pid_t hijos[CANT_HIJOS];

    // se crea la memoria compartida y se enlaza con el ptr shared_array
	int shmid = shmget(IPC_PRIVATE, sizeof(struct Data) * CANT_HIJOS, IPC_CREAT|0600);
	shared_array = (struct Data*) shmat(shmid, 0, 0);

	//aca se guarda la info del archivo en el array
	struct Data asd;
	asd.finaliza1 = 0;
	asd.finaliza2 = 0;
	asd.filas = filas;
	asd.columnas = columnas;
	int matriz[filas][columnas];
	int temp;

	//leer matriz
	for(int i = 0; i < filas; i++){
		for(int j = 0; j < columnas; j++){
			int temp;
			fscanf(file, "%d", &temp);
			asd.datos[i][j] = temp;
		}
	}

	//cargamos datos a memoria, original 0 y copia 1
	shared_array[0] = asd;
	shared_array[1] = asd;

    // creacion de hijos
	for(int i = 0; i < CANT_HIJOS; i++) {
		hijos[i] = fork();
		break;
	}

	if(getpid() == padre){
		printf("\t\t\tPadre\n");
		struct Data datos_recibidos = shared_array[0];
		while (datos_recibidos.finaliza1 == 0 && datos_recibidos.finaliza2 == 0) {
			datos_recibidos = shared_array[0];
			sleep(1);
		}
	}
	else{
        // seccion de los hijos
		for(int i = 0; i < CANT_HIJOS; i++) {
			if(!hijos[i]) {
				printf("\t\t\tHijo %d\n", i);
				struct Data info = shared_array[0];
				struct Data info2 = shared_array[1];
				for(int j = 0; j < 10; j++) {
					for (int k = 0; k < info2.filas; k++) {
						for (int l = 0; l < info2.columnas; l++) {
							int temp;
							if(i == 0){ //esto lo hace el hijo1
								if(info2.datos[i][j] == 1) {
									//solo hace esto si la celda es estado "bosque"
									temp = calcular_vecindario(info2, k, l, i);
									if(temp >= 4) {
										info2.datos[i][j] = 0;
									}
								}
							}
							else{ //esto lo hace el hijo2
								if(info2.datos[i][j] == 0) {
									//solo hace esto si la celda es estado "deforestado"
									temp = calcular_vecindario(info2, k, l, i);
									if(temp >= 5) {
										info2.datos[i][j] = 2;
									}
								}
							}
							
						}
					}
					printf("Hijo %i, anio %i\n", i, j);
					imprimir_datos(info2);
				}
				if(i == 0){
					info2.finaliza1 = 1;
				}
				else{
					info2.finaliza2 = 1;
				}
				info = info2;
				shared_array[0] = info;
			}
		}
	}

    // se desenlaza y borra el segmento de memoria
	shmdt(shared_array);
	shmctl(shmid, IPC_RMID, NULL);

	return EXIT_SUCCESS;
}

void imprimir_datos(struct Data datos) {
	// Imprime los datos de la matriz
	for (int i = 0; i < datos.filas; i++) {
		for (int j = 0; j < datos.columnas; j++) {
			printf("%d ", datos.datos[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

int calcular_vecindario(struct Data datos, int x, int y, int tipo) {
	int cont = 0;
	for (int i = x - 1; i < x + 1; i++) {
		for (int j = y - 1; j < y + 1; j++) {
			if(i < 0 || j < 0 || i > datos.columnas || j > datos.filas) {
				//posicion que vale 1
				//como el valor 1 no afecta, entonces no hace nada
			}
			else{
				if(tipo == 0) { //si es hijo 1
					if(datos.datos[i][j] == 0) {
						cont++;
					}
				}
				else if(tipo == 1) { //si es hijo 2
					if(datos.datos[i][j] == 2) {
						cont++;
					}
				}
				
			}
		}
	}
	return cont;
}