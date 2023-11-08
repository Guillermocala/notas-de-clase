/*este es derivado del base pero en vez de acceder a la memoria dinamica como array
lo haremos con punteros y aritmetica de punteros*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/shm.h>
#include <sys/stat.h>

// tamaño del hash table para hallar los repetidos
#define HASH_SIZE 1000

struct Data {
	//datos con los que va a trabajar
	int datos[100];
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

	//con esto sacamos el total de lineas en el documento leido
	fseek(file, 0, SEEK_END);
	int cantidad = ftell(file);
	int longitud = (cantidad/sizeof(int)) + 1;
	fseek(file, 1, SEEK_SET);

	//aca se guarda la info del archivo en el array
	int array[longitud];
	for(int i = 0; i < longitud; i++) {
		fscanf(file, "%d", &array[i]);
	}

    /*aqui se asigna cada particion a una posicion de la memoria compartida
    que es secuencial a los hijos, shm[0] para el hijo 0 y así sucesivamente*/
	int temp = 0;
	int array_temp[100];
	int partition = array[0];
	for(int i = 1; i <= longitud; i++) {
		if(temp == partition) {
			struct Data temp_data;
			temp_data.size = partition;
			for(int j = 0; j < partition; j++){
				temp_data.datos[j] = array_temp[j];
			}
            // guardamos y movemos el apuntador una posicion
			*shared_array = temp_data;
            shared_array++;
			temp = 0;
			partition = array[i];
		}
		else{
			array_temp[temp] = array[i];
			temp++;
		}
	}

    //colocamos el apuntador en la posicion inicial
    shared_array -= cant_hijos;

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
			struct Data temporal = *shared_array;
			shared_array++;
			imprimirDatos(temporal);
    	}
	}
	else{
        // seccion de los hijos
		for(int i = 0; i < cant_hijos; i++) {
			if(!hijos[i]) {
                /*se crea una estructura temporal para almacenar lo que esta en la memoria
                compartida y luego se hacen las operaciones*/
				struct Data temporal = *shared_array;
				temporal.sumatoria = calcularSumatoria(temporal.datos, temporal.size);
				temporal.promedio = calcularPromedio(temporal.datos, temporal.size);
				int valor = 0, cantidad = 0;
				calcularOcurrencias(temporal.datos, temporal.size, &valor, &cantidad);
				temporal.repetido = valor;
				temporal.cant_repetido = cantidad;
                /*como temporal solo recibe y no crea enlace con la memoria compartida, entonces
                tenemos que guardar lo que hicimos sobreescribiendo dicha posicion de memoria compartida*/
				*shared_array = temporal;
			}
            // con esto posicionamos el apuntador en el hijo correspondiente
            shared_array++;
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