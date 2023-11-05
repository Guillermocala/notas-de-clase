#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <stdbool.h>

#define NUM_PIPES 8
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
			close(tub[i][1]);
			if(i != 0) { close(tub[i][0]); } 
		}
		
	}
	else if(!hijos[1]) { //hijo 2
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 1) { close(tub[i][0]); } 
		}
		
	}
	else if(!hijos[2]) { //hijo 3
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 2) { close(tub[i][0]); } 
		}
		
	}
	else if(!hijos[3]) { //hijo 4
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][1]);
			if(i != 3) { close(tub[i][0]); } 
		}
		
	}
	else{  //padre
		for (int i = 0; i < NUM_PIPES; ++i) {
			close(tub[i][0]);
		}
		
		wait(NULL);wait(NULL);wait(NULL);wait(NULL);
	}
	return EXIT_SUCCESS;
}