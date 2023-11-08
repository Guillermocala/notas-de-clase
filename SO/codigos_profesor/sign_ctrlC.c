#include <signal.h>
#include <stdio.h>
#include <unistd.h>

void manejador(int sig){
    printf("senal capturada [%d]\n", sig);
}
int main(){
    signal(SIGINT, manejador);
    while(1) {
        printf("Hello World!\n");
        sleep(1);
        
    }  
}
