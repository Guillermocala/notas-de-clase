/*creamos una estructura como la que hace referencia la imagen anexa a esta
carpeta y con ello vamos a imprimir en un orden especifico, aquí bajo
mi razonamiento el nodo 'A' va a ser el padre, por ende solo crear el resto
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
    int i, j, id;
    pid_t hijos[3], raiz = getpid();

    id = 1;
    
    for(i = 0; i < 3; i++) {
        hijos[i] = fork();
        if (hijos[i] == 0){
            id = (id * 10) + i;
            int cant_hijos = (i != 1) ? 2 : 1;
            for(j = 0; j < cant_hijos; j++) {
                hijos[0] = fork();
                if(hijos[0] != 0) 
                {
                    break;
                }
                else{
                    id = (id * 10) + j;
                }
            }
            break;
        }
    }

    if(getpid() == raiz) {
        char b[500];
        sprintf(b,"pstree -lp %d", getpid());
        system(b);
    }
    else {
        sleep(1);
    }

    if (id == 1) { // padre
        printf("Proceso padre %d\n", getpid());
        for(i = 0; i < 3; i++){
            waitpid(hijos[i], NULL, 0);
        }
    }
    else { // procesos hijos
        if (i == 0){ // hijo 1 y sus decendientes
            if(id == 10) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
            else if(id == 100) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
            else if(id == 1001) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
        }
        else if(i == 1) { // hijo 2 y sus decendientes
            if(id == 11) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
            else if(id == 110) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }

        }
        else if(i == 2){ // hijo 3 y sus decendientes
            if(id == 12) {
                printf("Proceso %d [%d]\n", getpid(), getppid());
                
            }
            else if(id == 120) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
            else if(id == 1201) {
                printf("Proceso %d [%d]\n", getpid(), getppid());

            }
        }
    }
    return 0;
}