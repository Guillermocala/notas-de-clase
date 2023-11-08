#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <pthread.h>

void *f_hilo(void *);
void error(char *);

struct dato{
	int id;
};

int t_global = 0;
clock_t t_ini, t_fin;
int main(){
	pthread_t *tid=NULL;
	struct dato *data=NULL;
	int nhilos;

	printf("# hilos?");
	scanf("%d", &nhilos);
	tid = (pthread_t *)calloc(nhilos, sizeof(pthread_t));
	if(!tid)error("No dm\n");
    
    t_ini = clock();
	for (int i = 0; i < nhilos; ++i){
		data = (struct dato *) malloc(sizeof(struct dato));
		data->id = i;
		pthread_create(&tid[i], NULL, f_hilo, (void*)data);		
	}

	for (int i = 0; i < nhilos; ++i){
		pthread_join(tid[i], NULL);
	}
	t_fin = clock();
	printf("%f seg\n", (double)(t_fin-t_ini)/CLOCKS_PER_SEC);

	return EXIT_SUCCESS;
}


void *f_hilo(void *id){
	int mid = ((struct dato*)id)->id;
	while(mid != t_global);	//espera activa - busy wait
  	printf("soy hilo :%d\n", mid);
  	t_global = t_global+1;
  	pthread_exit(0);
}


void error(char *msg){ perror(msg); exit(1);}