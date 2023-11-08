/*debe imprimir desde cada proceso usando señales para congelar y reanudar
procesos y debe hacerlo en el siguiente orden:
soy el padre
soy el hijo 2
soy el hijo 1
es esta variante hacemos uso de SIGUSR1 y un manejador
*/
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>
#include <sys/wait.h>

//creamos un manejador para sobreescribir y enviar una señal
void handler(){}

int main(int argc, char *argv[]){
    pid_t hijo1, hijo2;
    signal(SIGUSR1, handler);
    hijo1 = fork();
    if(hijo1 != 0){
        hijo2 = fork();
        if(hijo2 == 0){ //este es el hijo2
            //congelamos el proceso
            pause();
            printf("Soy el hijo2\n");
            //despertamos el hijo 1
            kill(hijo1, SIGUSR1);
            //esperamos al hijo 1
            waitpid(hijo1, NULL, 0);
        }
        else{ // si es el padre
            printf("Soy el padre\n");
            //despertamos el hijo 2
            kill(hijo2, SIGUSR1);
            //esperamos al hijo 2
            waitpid(hijo2, NULL, 0);
        }
    }
    else { //este es hijo1
        //congelamos el proceso
        pause();
        printf("Soy el hijo1\n");
    }
    return 0;
}