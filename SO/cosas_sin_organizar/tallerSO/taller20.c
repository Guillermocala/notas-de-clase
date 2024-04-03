#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <math.h>
#include <sys/types.h>
#include <time.h>
#include <sys/time.h>

struct hilo {
    int inicio;
    int final;
    int profundidad;
};

int **matriz = NULL;

pthread_mutex_t mt = PTHREAD_MUTEX_INITIALIZER;
// Crear dinámicamente la lista de elementos de la estructura
struct hilo *lista_hilos = NULL;
//pthread_mutex_lock(&mt);
//pthread_mutex_unlock(&mt);

void *funcion(void *arg);
void *funcion2(void *arg);

int main(int argc, char *argv[]){
    int cant_dias;
    int CANT_HILOS, filas, columnas;
    // lectura de archivos
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);
    
    fscanf(file, "%d", &cant_dias);
    fscanf(file, "%d", &filas);
    fscanf(file, "%d", &columnas);

    // Asignar memoria dinámica para la matriz
    matriz = (int **)malloc(filas * sizeof(int *));
    if (matriz == NULL) {
        printf("Error al asignar memoria para las filas\n");
        fclose(file);
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < filas; i++) {
        matriz[i] = (int *)malloc(columnas * sizeof(int));
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

    // Leer y llenar la matriz
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            int temp;
            fscanf(file, "%d", &temp);
            matriz[i][j] = temp;
        }
    }

    printf("datos de la matriz\n");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
    fclose(file);
    exit(1);
    CANT_HILOS = filas / 2;

    pthread_t threads[CANT_HILOS];
    lista_hilos = (struct hilo *)malloc(CANT_HILOS * sizeof(struct hilo));

    int temp_index = 0;
    for (int i = 0; i < CANT_HILOS; ++i) {
        lista_hilos[i].indice_inicial = temp_index;
        temp_index += (DIMENSIONES / CANT_HILOS);
        lista_hilos[i].indice_final = temp_index;
        lista_hilos[i].profundidad = DIMENSIONES;
    }
    
    /*for (int i=0; i<CANT_HILOS; i++){
        pthread_create(&threads[i], NULL, funcion, NULL);
    }*/
    pthread_create(&threads[0], NULL, funcion, NULL);
    pthread_create(&threads[1], NULL, funcion2, NULL);
    //espera por la terminacion de hilos
    for (int i=0; i<CANT_HILOS; i++) { 
        pthread_join(threads[i], NULL);
    }

    return 0;
}

void *funcion(void *arg){
    printf("Hilo: [%lu]\n", pthread_self());
    int inicial = lista_hilos[0].indice_inicial;
    int final = lista_hilos[0].indice_final;
    printf("inicial %i\n", inicial);
    printf("final %i\n", final);
    for (int i=inicial; i < final; i++){
        for (int j=0; j < lista_hilos[0].profundidad; j++){
            printf("%i ", matriz[i][j]);
        }
        printf("\n");
    }
    pthread_exit(0);
}
void *funcion2(void *arg){
    printf("Hilo: [%lu]\n", pthread_self());
    int inicial = lista_hilos[1].indice_inicial;
    int final = lista_hilos[1].indice_final;
    printf("inicial %i\n", inicial);
    printf("final %i\n", final);
    for (int i=inicial; i < final; i++){
        for (int j=0; j < lista_hilos[1].profundidad; j++){
            printf("%i ", matriz[i][j]);
        }
        printf("\n");
    }
    pthread_exit(0);
}