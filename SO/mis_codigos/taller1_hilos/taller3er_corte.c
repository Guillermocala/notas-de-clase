/*
INTEGRANTES: GUILLERMO CALA - SEBASTIAN AHUMADA
EN ORDEN DE EJECUTAR ES: ./a.out archivo.in num_hilos max_size
*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>
#include <math.h>

struct hilo {
    int inicio;
    int final;
    float resultado;
};

int *dispositivo1 = NULL;
int *dispositivo2 = NULL;
// Crear dinámicamente la lista de elementos de la estructura
struct hilo *lista_hilos = NULL;

void* funcion_hilo(void*);

int main(int argc, char *argv[]){
    int resultado = 0;
	int threads = atoi(argv[2]);    //se extrae la cant de hilos
    int maxSize = atoi(argv[3]);    //se extrae la cant de datos
	pthread_t tid[threads];
    lista_hilos = (struct hilo *)malloc(threads * sizeof(struct hilo));
    int temp_index = 0;
    /*aca se hace la asignacion de particio para cada hilo*/
    for (int i = 0; i < threads; ++i) {
        lista_hilos[i].inicio = temp_index;
        temp_index += (maxSize / threads);
        if (i == (threads - 1)) {
            if (maxSize % threads != 0) {
                lista_hilos[i].final = maxSize;
            }
            else {
                lista_hilos[i].final = temp_index;
            }
        }
        else{
            lista_hilos[i].final = temp_index;
        }
        lista_hilos[i].resultado = 0.0;
    }

    // lectura de archivos
	FILE *file;
	file = fopen(argv[1], "r");
	if(file == NULL) {
		printf("Error al abrir el archivo\n");
		exit(1);
	}
	printf("Archivo abierto es: %s\n", argv[1]);

    //aca sacamos la cantidad de datos de los vectores
    int cant_datos;
    fscanf(file, "%d", &cant_datos);

    if(maxSize > cant_datos) {
        printf("la cantidad de datos pedidos excede los del documento!\n");
        exit(1);
    }

    // Asignación dinámica de memoria para evitar problemas con arrays grandes
    dispositivo1 = (int *)malloc(maxSize * sizeof(int));
    dispositivo2 = (int *)malloc(maxSize * sizeof(int));

    //guardamos los datos en los vectores
    for(int i = 0; i < maxSize; i++) {
        fscanf(file, "%d", &dispositivo1[i]);
    }
    for(int i = 0; i < maxSize; i++) {
        fscanf(file, "%d", &dispositivo2[i]);
    }
    fclose(file);

    //validacion de particion que no sea valores decimales, sino partes pares
    //int termina = verificar(threads, maxSize);
    //if (termina) { exit(1); }
    /*for (int i = 0; i < threads; ++i) {
        printf("Elemento %d:\n", i);
        printf("  Índice inicial: %d\n", lista_hilos[i].inicio);
        printf("  Índice final: %d\n", lista_hilos[i].final);
        printf("  Resultado: %f\n", lista_hilos[i].resultado);
    }*/

    //toma de tiempo inicial
    struct timespec tic, toc;
    double Elapsed;
    clock_gettime( CLOCK_REALTIME, &tic);
	for(int i = 0; i < threads; i++) {
		pthread_create(&tid[i], NULL, funcion_hilo, (void*)&lista_hilos[i]);
	}

    //espera por los hilos
	for(int i = 0; i < threads; i++) {
		pthread_join(tid[i], NULL);
    }
    // Acceder a los elementos de la lista
    for (int i = 0; i < threads; ++i) {
        resultado += lista_hilos[i].resultado;
    }
    resultado /= maxSize;
	printf("MSE=[%d]\n", resultado);
    //toma de tiempo final
    clock_gettime( CLOCK_REALTIME, &toc);
    Elapsed = (toc.tv_sec-tic.tv_sec)+((toc.tv_nsec-tic.tv_nsec)/(double)1E9);
    printf("Tiempo: %.6lf\n", Elapsed );
	return EXIT_SUCCESS;
}

void* funcion_hilo(void* arg){
    /*aca se usa punteros para no trabajar con una copia local de ese struct ya que debo escribir
    y no solo leer*/
    struct hilo *hilo = (struct hilo*)arg;
    int inicio = hilo->inicio;
    int final = hilo->final;
    int res = 0;
	for (int i = inicio; i < final; ++i) {
        res += pow((dispositivo1[i] - dispositivo2[i]), 2);
	}
    hilo->resultado = res;
	pthread_exit(0);
}