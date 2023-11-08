/*debe imprimir desde cada proceso usando señales para congelar y reanudar
procesos y debe hacerlo en el siguiente orden:
soy el padre
soy el hijo 2
soy el hijo 1*/

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
    pid_t hijo1, hijo2;
    hijo1 = fork();
    if(hijo1 != 0){
        hijo2 = fork();
        if(hijo2 == 0){ //este es el hijo 2
            //autocongelamos este proceso
            kill(getpid(), SIGSTOP);
            printf("Soy el hijo2\n");
            //aca despertamos el hijo 1
            kill(hijo1, SIGCONT);
            //esperamos al hijo 1
            waitpid(hijo1, NULL, 0);
        }
        else{ // si es el padre
            printf("Soy el padre\n");
            //detenemos el hijo 2
            kill(hijo2, SIGCONT);
            //esperamos al hijo 2
            waitpid(hijo2, NULL, 0);
        }
    }
    else { //este es hijo 1
        //autocongelamos este proceso
        kill(getpid(), SIGSTOP);
        printf("Soy el hijo1\n");
    }
    return 0;
}