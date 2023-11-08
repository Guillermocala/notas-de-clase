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
    //sacamos el dato de 'A' que vendría siendo el padre
    pid_t childs[9],padre=getpid();
    char buffer[100];
    for(int i=0;i<3;i++){
        if(!(childs[i]=fork())){
            if(i==0){
                if(!(childs[3]=fork())){
                    if(!(childs[6]=fork())){
                    }
                }
            }else if(i==1){
                if(!(childs[4]=fork())){
                }
            }else if(i==2){
                if(!(childs[5]=fork())){
                    if(!(childs[7]=fork())){
                    }
                }
            }
            break;
        }
    }

    if(getpid()==padre){
        char b[50];
        sprintf(b,"pstree -lp %d",getpid());
        system(b);
    }else{
        sleep(1);
    }


    return 0;
}