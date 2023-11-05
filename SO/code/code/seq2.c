#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<pthread.h>


struct datos{
	int id;
};
void error(char *);
void *f_hilo(void*);
int turno_global = 0;

pthread_cond_t cond = PTHREAD_COND_INITIALIZER;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

int main(){
	clock_t tini, tfin; 
	int nhilos;
	pthread_t *tid;
	struct datos *dato;

	printf("No. Hilos? \n");
	scanf("%d",&nhilos);
	tid =  (pthread_t *)calloc(nhilos, sizeof(pthread_t));
    if(!tid) error("no memoria dinamica\n");

    tini = clock();
	for (int i = 0; i < nhilos; ++i){		
		dato = (struct datos *)malloc(sizeof(struct datos));
		dato->id = i;
		pthread_create(&tid[i], NULL, f_hilo, (void*)dato);				
	}

	for (int i = 0; i < nhilos; ++i){
		pthread_join(tid[i], NULL);
	}
	tfin = clock();
	printf("%f \n", (double)(tfin - tini)/CLOCKS_PER_SEC );

	return EXIT_SUCCESS;
}







void *f_hilo(void* dato){
 int myturno = ((struct datos*)dato)->id;

 //while(myturno!=turno_global);

 pthread_mutex_lock(&mutex);
 while(myturno!=turno_global)
 	pthread_cond_wait(&cond, &mutex);

		 printf("Hilo #%d\n", myturno);
		 turno_global = turno_global+1;

 pthread_mutex_unlock(&mutex);
 pthread_cond_broadcast(&cond);// pthread_cond_signal
 


 free(dato);
 pthread_exit(0); 
}






void error(char *msg){
	perror(msg);
	exit(1);
}