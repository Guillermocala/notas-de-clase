#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/shm.h>
#include <sys/stat.h>

int main(int argc, char *argv[]){
	int *ptr = NULL, *indice = NULL;
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);
	int total_size;
	fscanf(file, "%d", &total_size);
	pid_t padre = getpid();
	pid_t hijos[total_size];

	fseek(file, 0, SEEK_END);
	int cantidad = ftell(file);
	int longitud = cantidad/sizeof(int);
	fseek(file, 1, SEEK_SET);

	int array[longitud];

	for (int i = 0; i <= longitud; i++) {
		fscanf(file, "%d", &array[i]);
	}
	for (int i = 0; i <= longitud; i++) {
		printf("%i - %i\n", i, array[i]);
	}

	int shmid = shmget(IPC_PRIVATE, (sizeof(int) + sizeof(array) + (total_size * sizeof(float))), IPC_CREAT|0600);
	ptr = (int *) shmat(shmid, NULL, 0);
	indice = (int *) shmat(shmid, NULL, 0);
	//acá se monta el primer indice que sería el indice de la primera partición
	*indice = 0;
	ptr = ptr + 1;

	for (int i = 0; i < longitud; i++) {
		*ptr = array[i];
		ptr = ptr + 1;
	}
	ptr = ptr - longitud;

	for (int i = 0; i < total_size; i++) {
		hijos[i] = fork();
		if(!hijos[i]) {
			printf("hijo %i - indice: %i\n", i, *indice);
			for (int i = 0; i < *indice; i++){ ptr++;}
			printf("hijo %i - valor: %i\n", i, *ptr);
			*indice = *ptr + 1;
            
			break;
		}
	}
    for (int i = 0; i < total_size; i++) {
        wait(NULL);
    }


float suma = 0;
			for (int i = 0; i < *indice; i++){
                if (i != 0) { suma += *ptr}
                ptr++;
            }
            float promedio = suma / *indice;
			printf("Suma hijo %i - valor: %f\n", i, suma);
			printf("Promedio hijo %i - valor: %f\n", i, suma);
			*indice = *ptr + 1;
			break;
	// Desadjuntar la memoria compartida
    shmdt(ptr);
    shmdt(indice);

    // Eliminar la memoria compartida
    shmctl(shmid, IPC_RMID, NULL);

	return EXIT_SUCCESS;
}


