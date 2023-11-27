#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
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

struct coordenada {
    int x;
    int y;
};

int **datos = NULL, **patron = NULL;
int fil_datos, col_datos;
int fil_patron, col_patron;
int cant_coordenadas = 0;

struct hilo *lista_hilos = NULL;
struct coordenada *lista_coordenadas = NULL;

pthread_mutex_t mt = PTHREAD_MUTEX_INITIALIZER;

void *funcion(void *arg);
void calcular_vecindario(int x, int y);
void extract_data(char *argv[], int indice);
void imprime_matriz(int **matriz, int filas, int columnas);

int main(int argc, char *argv[]){
    extract_data(argv, 1);
    extract_data(argv, 2);
    printf("Patron a hallar...\n");
    imprime_matriz(patron, fil_patron, col_patron);
    //imprime_matriz(datos, fil_datos, col_datos);
    int cant_hilos = 1;

    lista_hilos = (struct hilo *)malloc(cant_hilos * sizeof(struct hilo));

    int temp_index = 0;
    for (int i = 0; i < cant_hilos; ++i) {
        lista_hilos[i].inicio = temp_index;
        temp_index += (fil_datos / cant_hilos);
        lista_hilos[i].final = temp_index;
        lista_hilos[i].profundidad = fil_datos;
    }

    pthread_t threads[cant_hilos];
    for (int i = 0; i < cant_hilos; i++) {
        pthread_create(&threads[i], NULL, funcion, (void*)&lista_hilos[i]);
    }

    for (int i = 0; i < cant_hilos; i++) { 
        pthread_join(threads[i], NULL);
    }

    printf("La cantidad de encontrados es: %i\n", cant_coordenadas);
    for (int i = 0; i < cant_coordenadas; i++) {
        int x = lista_coordenadas[i].x;
        int y = lista_coordenadas[i].y;
        printf("Coordenada [%i]: (%i, %i)\n", (i + 1), x, y);
    }

    return 0;
}

void *funcion(void *arg) {
    //acá recibimos y hacemos el casting de la estructura correspondiente para este hijo
    struct hilo hilo = *(struct hilo*)arg;
    //printf("Hilo: [%lu]\n", pthread_self()); //solo para mostrar el hilo y el dia
    for (int i = hilo.inicio; i < hilo.final; i++) {
        for (int j = 0; j < hilo.profundidad; j++){
            calcular_vecindario(i, j);
        }
    }
    pthread_exit(0);
}

void calcular_vecindario(int x, int y) {
    bool encontrado = true;
    int a = 0, b = 0;
    for (int i = x - 1; i <= x + 1; i++) {
        for (int j = y - 1; j <= y + 1; j++) {
            if (i < 0 || j < 0 || i >= fil_datos || j >= col_datos) {
                // Datos con los cuales no me interesa trabajar
                encontrado = false;
            } else {
                if (patron[a][b] != datos[i][j]) {
                    encontrado = false;
                }
            }
            b++;
        }
        a++;
        b = 0;
    }
    if(encontrado) {
        pthread_mutex_lock(&mt);
        cant_coordenadas++;
        // Reasignar memoria dinámica para el arreglo de coordenadas
        lista_coordenadas = (struct coordenada *)realloc(lista_coordenadas, cant_coordenadas * sizeof(struct coordenada));
        lista_coordenadas[cant_coordenadas - 1].x = x;
        lista_coordenadas[cant_coordenadas - 1].y = y;
        pthread_mutex_unlock(&mt);
    }
}


void imprime_matriz(int **matriz, int filas, int columnas) { //acá no hay nada que explicar
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }
}

void extract_data(char *argv[], int indice) {
    //lectura de archivo
	FILE *file;
	file = fopen(argv[indice], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[indice]);
    
    //extraemos variables del archivo
    if(indice == 1) {
        fscanf(file, "%d", &fil_patron);
        fscanf(file, "%d", &col_patron);
    }
    else {
        fscanf(file, "%d", &fil_datos);
        fscanf(file, "%d", &col_datos);
    }

    //ahora viene la operacion para una matriz dinamica
    //asignamos memoria dinámica para la matriz entorno a filas
    if(indice == 1) {
        patron = (int **)malloc(fil_patron * sizeof(int *));
        if (patron == NULL) {
            printf("Error al asignar memoria para las filas\n");
            fclose(file);
            exit(EXIT_FAILURE);
        }
        //asignamos memoria dinámica para la matriz entorno a columnas
        for (int i = 0; i < fil_patron; i++) {
            patron[i] = (int *)malloc(col_patron * sizeof(int));
            if (patron[i] == NULL) {
                printf("Error al asignar memoria para las columnas\n");
                // Liberar memoria previamente asignada
                for (int j = 0; j < i; j++) {
                    free(patron[j]);
                }
                free(patron);
                fclose(file);
                exit(EXIT_FAILURE);
            }
        }
        //alimentamos la matriz
        for (int i = 0; i < fil_patron; i++) {
            for (int j = 0; j < col_patron; j++) {
                int temp;
                fscanf(file, "%d", &temp);
                patron[i][j] = temp;
            }
        }
    }else {
        datos = (int **)malloc(fil_datos * sizeof(int *));
        if (datos == NULL) {
            printf("Error al asignar memoria para las filas\n");
            fclose(file);
            exit(EXIT_FAILURE);
        }
        //asignamos memoria dinámica para la matriz entorno a columnas
        for (int i = 0; i < fil_datos; i++) {
            datos[i] = (int *)malloc(col_datos * sizeof(int));
            if (datos[i] == NULL) {
                printf("Error al asignar memoria para las columnas\n");
                // Liberar memoria previamente asignada
                for (int j = 0; j < i; j++) {
                    free(datos[j]);
                }
                free(datos);
                fclose(file);
                exit(EXIT_FAILURE);
            }
        }
        //alimentamos la matriz
        for (int i = 0; i < fil_datos; i++) {
            for (int j = 0; j < col_datos; j++) {
                int temp;
                fscanf(file, "%d", &temp);
                datos[i][j] = temp;
            }
        }
    }
    fclose(file);
}