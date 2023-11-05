/*este codigo crea un hijo y usando una tuberia, se lo envía al hijo para que
haga una sumatoria y le envie el resultado al padre mediante una butería
el ejercicio esquema es comunicación de dos vías entre dos procesos
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
	int tub[2][2];
    pipe(tub[0]);
    pipe(tub[1]);

	pid_t child = fork(); 
	if(!child){         //hijo
        close(tub[0][1]);
        close(tub[1][0]);
        
        ssize_t bytes_escritos;
        float suma = 0;
        int size;
        read(tub[0][0], &size, sizeof(size)); //recibimos el tamaño del array
        int array[size];
        read(tub[0][0], &array, sizeof(array)); //recibimos el array
        printf("Datos desde el hijo\n");
        for(int i = 0; i < size; i++){
            suma += array[i];
            printf("%i - %i\n", i, array[i]);
        }
        close(tub[0][0]);

        bytes_escritos = write(tub[1][1], &suma, sizeof(suma));
        if(bytes_escritos == sizeof(suma)) {
            printf("Suma del array escrito en tuberia!\n");
        }
        else {
            printf("Problema al escribir suma del array en la tubería!\n");
        }
        close(tub[1][1]);
	}
	else{               //padre
		close(tub[1][1]);
		close(tub[0][0]);
        ssize_t bytes_escritos;
        FILE *file;
        file = fopen(argv[1], "r");
        if(file == NULL) {
            printf("Error al abrir el archivo\n");
            exit(1);
        }
        printf("El archivo abierto es: %s\n", argv[1]);
        int size;
        fscanf(file, "%d", &size);

        bytes_escritos = write(tub[0][1], &size, sizeof(size));
        if(bytes_escritos == sizeof(size)) {
            printf("Tamaño del array escrito en tuberia!\n");
        }
        else {
            printf("Problema al escribir tamaño del array en la tubería!\n");
        }

        int array[size];
        for(int i = 0; i < size; i++){
            fscanf(file, "%d", &array[i]);
        }

        bytes_escritos = write(tub[0][1], &array, sizeof(array));
        if(bytes_escritos == sizeof(array)) {
            printf("Array escrito en la tubería!\n");
        }
        else {
            printf("Problema al escribir el array en la tubería!\n");
        }
        close(tub[0][1]);
        wait(NULL);

        float suma;
        read(tub[1][0], &suma, sizeof(suma)); //recibimos la suma
        printf("Desde el padre la suma es: %f\n", suma);
        close(tub[1][0]);
	}
	return EXIT_SUCCESS;
}