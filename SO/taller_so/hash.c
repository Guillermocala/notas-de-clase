#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <math.h>

#define HASH_SIZE 1000000       // Tamaño maximo tabla de hash

int main(int argc, char *argv[]){
    struct timespec start, end;
    double elapsed;

    clock_gettime(CLOCK_REALTIME, &start);
    //      SECCION DE LECTURA
    FILE *file;
    file = fopen(argv[1], "r");
    if(file == NULL) {
        printf("Error al abrir el archivo\n");
        exit(1);
    }

    printf("El archivo abierto es: %s\n", argv[1]);

    int size;
    int *array = NULL;
    fscanf(file, "%d",&size);
    array = (int *)malloc(size * sizeof(int));
    if (array == NULL) {
        printf("Error al reservar memoria\n");
        exit(1);
    }

    clock_gettime(CLOCK_REALTIME, &end);
    elapsed = (end.tv_sec - start.tv_sec) + (double)(end.tv_nsec - start.tv_nsec) / 1000000000.0;
    printf("Tiempo de lectura: %.6f segundos\n", elapsed);

    //      SECCION DE SUMA
    clock_gettime(CLOCK_REALTIME, &start);

    float sum = 0;
    for (int i = 0; i < size; i++){
        fscanf(file, "%d", &array[i]);
        
    }

    clock_gettime(CLOCK_REALTIME, &end);
    elapsed = (end.tv_sec - start.tv_sec) + (double)(end.tv_nsec - start.tv_nsec) / 1000000000.0;
    printf("Tiempo de suma: %.6f segundos\n", elapsed);

    printf("Suma de los elementos: %f\n", sum);

    //      CALCULO DE ESTADISTICAS: MEDIA, VARIANZA Y DESVIACION ESTANDAR
    clock_gettime(CLOCK_REALTIME, &start);
    // Calcular la media
    double media = sum / size;

    // Calcular la varianza
    double varianza = 0.0;
    for (int i = 0; i < size; i++) {
        varianza += pow(array[i] - media, 2);
    }
    varianza /= size;

    // Calcular la desviación estándar
    double standard_deviation = sqrt(varianza);

    printf("Media: %.6f\n", media);
    printf("Varianza: %.6f\n", varianza);
    printf("Desviacion Estandar: %.6f\n", standard_deviation);

    clock_gettime(CLOCK_REALTIME, &end);
    elapsed = (end.tv_sec - start.tv_sec) + (double)(end.tv_nsec - start.tv_nsec) / 1000000000.0;
    printf("Tiempo calculo de estadisticas: %.6f segundos\n", elapsed);

    //      CALCULO DE OCURRENCIA
    clock_gettime(CLOCK_REALTIME, &start);

    int hash_table[HASH_SIZE] = {0};
    int mas_repetido = -1;          // Valor mas frecuente
    int ocurrencias = 0;            // cantidad de veces del mas frecuente

    for (int i = 0; i < size; i++) {
        int actual = array[i];
        hash_table[actual]++;

        if (hash_table[actual] > ocurrencias) {
            mas_repetido = actual;
            ocurrencias = hash_table[actual];
        }
    }
    clock_gettime(CLOCK_REALTIME, &end);

    printf("El valor mas frecuente es: %d y se repite %d veces\n", mas_repetido, ocurrencias);
    elapsed = (end.tv_sec - start.tv_sec) + (double)(end.tv_nsec - start.tv_nsec) / 1000000000.0;
    printf("Tiempo calculo de ocurrencias: %.6f segundos\n", elapsed);

    fclose (file);
    free(array);
    
    return 0;
}