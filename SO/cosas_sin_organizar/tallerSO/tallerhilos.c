#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <math.h>
#include <sys/types.h>
#include <time.h>
#include <sys/time.h>


int MAX_SIZE, CANT_HILOS;
int *a, *b;
double *resultados;

void *funcion(void *arg);

int main(int argc, char *argv[]){
    printf("Ingrese el numero de hilos: ");
    scanf("%d", &CANT_HILOS);
    printf("Ingrese MAX_SIZE: ");
    scanf("%d", &MAX_SIZE);
    
    double mse = 0;
    int values[CANT_HILOS];
    pthread_t threads[CANT_HILOS];

    resultados = (double*)malloc(CANT_HILOS*sizeof(double));
    a = (int*)malloc(MAX_SIZE*sizeof(int));
    b = (int*)malloc(MAX_SIZE*sizeof(int));

    // lectura de archivos
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);

    //aca sacamos la cantidad de datos de los vectores
    int datos_vector;
    fscanf(file, "%d", &datos_vector);

    //guardamos los datos en los vectores
    for(int i = 0; i < MAX_SIZE; i++) { fscanf(file, "%d", &a[i]); }
    for(int i = 0; i < MAX_SIZE; i++) { fscanf(file, "%d", &b[i]); }
    fclose(file);

    struct timespec tic,toc;
    double Elapsed;
    clock_gettime(CLOCK_REALTIME,&tic);

    for (int i=0; i<CANT_HILOS; i++){
        values[i] = i;
        pthread_create(&threads[i], NULL, funcion, (void*)&values[i]);
    }

    for (int i=0; i<CANT_HILOS; i++) pthread_join(threads[i], NULL);

    for (int i=0; i<CANT_HILOS; i++) mse += resultados[i];

    mse = mse/MAX_SIZE;
    
    clock_gettime(CLOCK_REALTIME,&toc);
    Elapsed = (toc.tv_sec-tic.tv_sec)+((toc.tv_nsec-tic.tv_nsec)/(double)1E9);
    printf("\nEl tiempo es %.61f\n",Elapsed);

    printf("MSE = %.4f\n", mse);

    return 0;
}

void *funcion(void *arg){
    int *value = (int*)arg;
    int segmento = MAX_SIZE / CANT_HILOS;
    int inicio = segmento * value[0];
    int fin = segmento * (value[0]+1);

    if (MAX_SIZE % CANT_HILOS != 0){
        if ((CANT_HILOS-1) == *value && fin < MAX_SIZE){
            int faltante = MAX_SIZE - fin;
            fin += faltante;
        }
    }

    //printf("Hilo %d va desde %d hasta %d\n", value[0]+1, inicio, fin-1);
    resultados[*value] = 0;
    for (int i=inicio; i<fin; i++) {
        resultados[*value] +=  pow((a[i] - b[i]), 2);
    }

}