#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <signal.h>

int main(int argc, char *argv[]){
    int array[5] = {1, 2, 3, 4, 5};
    int cantidad = 0;
    bool es_par;
    for (int i = 0; i < 5; i++) {
        printf("valor: %i\n", array[i]);
        es_par = array[i] % 2 == 0;
        if (es_par) { cantidad += 1;}
    }
    printf("cantidad pares: %i\n", cantidad);
    return 0;
}