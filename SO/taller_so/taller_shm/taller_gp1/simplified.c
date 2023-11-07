/*el mismo codigo pero la version mas simplificada posible*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/shm.h>
#include <sys/stat.h>

// tamaño del hash table para hallar los repetidos
#define HASH_SIZE 1000
// tamaño estatico del array
#define N 100

struct Data {
	//datos con los que va a trabajar
	int datos[N];
	int size;
	//campos en los que va a escribir
	float sumatoria;
	float promedio;
	int repetido;
	int cant_repetido;
};

float calcularSumatoria(int array[], int size);
float calcularPromedio(int array[], int size);
void calcularOcurrencias(int array[], int size, int *valor, int *cantidad);
void imprimirDatos(struct Data datos);

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

    /*aca se guarda en cada estructura correspondiente al hijo*/
    for(int i = 0; i < cant_hijos; i++) {
		struct Data temp_data;
        //se extrae el dato correspondiente a la dimension del array
		fscanf(file, "%d", &temp_data.size);
		for (int j = 0; j < temp_data.size; j++) {
            //se inserta uno por uno
            fscanf(file, "%d", &temp_data.datos[j]);
		}
        //se guarda en la memoria compartida
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
			imprimirDatos(temporal);
    	}
	}
	else{
        // seccion de los hijos
		for(int i = 0; i < cant_hijos; i++) {
			if(!hijos[i]) {
                /*se crea una estructura temporal para almacenar lo que esta en la memoria
                compartida y luego se hacen las operaciones*/
				struct Data temporal = shared_array[i];
				temporal.sumatoria = calcularSumatoria(temporal.datos, temporal.size);
				temporal.promedio = calcularPromedio(temporal.datos, temporal.size);
				int valor = 0, cantidad = 0;
				calcularOcurrencias(temporal.datos, temporal.size, &valor, &cantidad);
				temporal.repetido = valor;
				temporal.cant_repetido = cantidad;
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

float calcularSumatoria(int array[], int size) {
    float suma = 0;
    for (int i = 0; i < size; ++i) {
        suma += array[i];
    }
    return suma;
}

float calcularPromedio(int array[], int size) {
    int suma = 0;
    for (int i = 0; i < size; ++i) {
        suma += array[i];
    }
    return (float) suma / size;
}

void calcularOcurrencias(int array[], int size, int *valor, int *cantidad) {
	int hash_table[HASH_SIZE] = {0};
	int mas_repetido = -1;          // Valor mas frecuente
	int ocurrencias = 0;            // cantidad de veces del mas frecuente
	int actual;
	for (int i = 0; i < size; i++) {
		actual = array[i];
		hash_table[actual]++;
		if (hash_table[actual] > ocurrencias) {
			mas_repetido = actual;
			ocurrencias = hash_table[actual];
		}
	}
	if(ocurrencias > 1) {
		*valor = mas_repetido;
		*cantidad = ocurrencias;
	}
}

void imprimirDatos(struct Data datos) {
    printf("Datos:\n");
    printf("Size: %d\n", datos.size);
    printf("Sumatoria: %f\n", datos.sumatoria);
    printf("Promedio: %f\n", datos.promedio);
    printf("Repetido: %d\n", datos.repetido);
    printf("Cantidad de Repeticiones: %d\n", datos.cant_repetido);
    printf("Datos Array: ");
    for (int i = 0; i < datos.size; ++i) {
        printf("%d ", datos.datos[i]);
    }
    printf("\n");
}