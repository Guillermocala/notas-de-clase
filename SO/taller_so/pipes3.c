/*este codigo crea 4 hijos, el padre le envia un array de datos a cada hijo y realiza:
hijo1: cuenta los nums impares
hijo2: cuenta los nums pares
hijo3: saca el promedio
hijo4: mira si hay repetidos e indica cuantas veces se repite
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <stdbool.h>

#define NUM_PIPES 4
#define NUM_CHILD 4
#define HASH_SIZE 10000

int main(int argc, char *argv[]){
	int tub[NUM_PIPES][2];

	pid_t hijos[NUM_CHILD];
	for (int i = 0; i < NUM_PIPES; ++i) { pipe(tub[i]); }
	for (int i = 0; i < NUM_CHILD; ++i) {
		hijos[i] = fork();
		if(!hijos[i]) {break;}
	}

	if(!hijos[0]){ //hijo 1
        for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 0) { close(tub[i][0]); } 
		}
		int size;
        read(tub[0][0], &size, sizeof(size)); //recibimos el tamaño del array
        int array[size];
        read(tub[0][0], &array, sizeof(array)); //recibimos el array
		close(tub[0][0]);
		//operacion1
		int cant_impares = 0;
		bool es_impar;
		for (int i = 0; i < size; i++) {
			es_impar = array[i] % 2 != 0;
			if (es_impar) { cant_impares++; }
		}
		printf("Cantidad impares: %i\n", cant_impares);
	}
	else if(!hijos[1]) { //hijo 2
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 1) { close(tub[i][0]); } 
		}
		int size;
        read(tub[1][0], &size, sizeof(size)); //recibimos el tamaño del array
        int array[size];
        read(tub[1][0], &array, sizeof(array)); //recibimos el array
		close(tub[1][0]);
		//operacion 2
		int cant_pares = 0;
		bool es_par;
		for (int i = 0; i < size; i++) {
			es_par = array[i] % 2 == 0;
			if (es_par) { cant_pares++; }
		}
		printf("Cantidad pares: %i\n", cant_pares);
	}
	else if(!hijos[2]) { //hijo 3
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 2) { close(tub[i][0]); } 
		}
		int size;
        read(tub[2][0], &size, sizeof(size)); //recibimos el tamaño del array
        int array[size];
        read(tub[2][0], &array, sizeof(array)); //recibimos el array
		close(tub[2][0]);
		//operacion 3
		//formula: 1/n(sum(i=1, N, xi))
		float suma = 0;
		float promedio;
		for (int i = 0; i < size; i++) {
			suma += array[i];
		}
		//promedio = (1 / size) * suma;
		promedio = suma / size;
		printf("Promedio: %f\n", promedio);
	}
	else if(!hijos[3]) { //hijo 4
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 3) { close(tub[i][0]); } 
		}
		int size;
        read(tub[3][0], &size, sizeof(size)); //recibimos el tamaño del array
        int array[size];
        read(tub[3][0], &array, sizeof(array)); //recibimos el array
		close(tub[3][0]);
		//operacion 4

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
			printf("El valor mas frecuente es: %d y se repite %d veces\n", mas_repetido, ocurrencias);
		}
		else {
			printf("No hay valores repetidos\n");
		}
	}
	else{  //padre
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][0]);
		}
		FILE *file;
        file = fopen(argv[1], "r");
        if(file == NULL) {
            printf("Error al abrir el archivo\n");
            exit(1);
        }
        printf("El archivo abierto es: %s\n", argv[1]);
		int size;
        fscanf(file, "%d", &size);
		int array[size];
		for(int i = 0; i < size; i++){
            fscanf(file, "%d", &array[i]);
        }
		for (int i = 0; i < NUM_PIPES; ++i) {
			write(tub[i][1], &size, sizeof(size));
			write(tub[i][1], &array, sizeof(array));
		}
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
		}
		wait(NULL);wait(NULL);wait(NULL);wait(NULL);
	}
	return EXIT_SUCCESS;
}