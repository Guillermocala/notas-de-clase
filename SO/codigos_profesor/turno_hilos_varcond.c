#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

struct DatoHilo{int dato;};

void * funhilos(void *);
int turno = 0;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t  cond  = PTHREAD_COND_INITIALIZER;


int main(){
	clock_t t_ini, t_fin;
    double secs;
	int nhilos = 0, i=0;
	pthread_t *pidhilos = NULL;
	struct DatoHilo *datohilo;
	
	printf("Numero de hilos\n");
	scanf("%d", &nhilos);
		
	//creacion de hilos
	pidhilos = (pthread_t *) calloc(nhilos, sizeof(pthread_t));
	for(i=0; i<nhilos; i++){	
	    datohilo = (struct DatoHilo*)malloc(sizeof(struct DatoHilo));
		datohilo->dato = i;
		pthread_create(&pidhilos[i], NULL, funhilos, (void*)datohilo);
	}
	t_ini = clock();
	for(i=0; i<nhilos; i++)
		pthread_join(pidhilos[i], NULL);
    t_fin = clock();
	secs = (double)(t_fin - t_ini) / CLOCKS_PER_SEC;
    printf("%.16g milisegundos\n", secs * 1000.0);
    
	
	free(pidhilos);
	return 0;
}

void * funhilos( void *arg){
	int myturno = ((struct DatoHilo *)arg)->dato;
	
	
	pthread_mutex_lock(&mutex);
	while(turno != myturno) pthread_cond_wait(&cond, &mutex);	

	printf("Hilo turno %d\t[%u]\n", myturno, (unsigned int)pthread_self());
	turno ++;

	pthread_cond_broadcast(&cond);
	pthread_mutex_unlock(&mutex);
    
	free(arg);
	pthread_exit(0);
}
