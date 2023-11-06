#include <stdio.h>
#include <stdlib.h>

int main() {
    // Crea un arreglo dinámico vacío
    int *arreglo = malloc(sizeof(int));

    // Variable para almacenar el valor ingresado por el usuario
    int valor;
    int size = 0;
    // Bucle para leer los números del usuario
    while (1) {
        // Solicita un número al usuario
        printf("Ingrese un número (-1 para terminar): ");
        scanf("%d", &valor);

        // Si el usuario ingresó -1, termina el bucle
        if (valor == -1) { break; }

        // Agrega el número al arreglo
        arreglo[size] = valor;
        // Se reasigna la memoria
        arreglo = realloc(arreglo, sizeof(int) * (size + 1));
        // Aumenta el contador
        size++;
    }

    // Imprime los elementos del arreglo
    for (int i = 0; i < size; i++) {
        printf("%d\n", arreglo[i]);
    }

    // Libera la memoria asignada al arreglo
    free(arreglo);

    return 0;
}
