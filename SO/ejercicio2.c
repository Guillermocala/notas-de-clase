#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>

int main(int argc, char *argv[]){
    pid_t hijo1, hijo2;
    hijo1 = fork();
    if(hijo1 != 0){
        hijo2 = fork();
        if(hijo2 == 0){ //este es el hijo2
            printf("kill stop hijo2: %i\n", kill(getpid(), SIGSTOP));
            printf("Soy el hijo2\n");
            printf("kill cont hijo2: %i\n", kill(hijo1, SIGCONT));
        }
        else{ // si es el padre
            printf("Soy el padre\n");
            printf("kill cont padre: %i\n", kill(hijo2, SIGCONT));
        }
    }
    else { //este es hijo1
        printf("kill stop hijo1: %i\n", kill(getpid(), SIGSTOP));
        printf("Soy el hijo1\n");
    }
    return 0;
}