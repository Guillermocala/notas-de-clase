/*este codigo es para documentar las siguientes funciones de una matriz cuadrada
-diagonal principal
-matriz triangular superior
-matriz triangular inferior
*/

#include <stdio.h>

//definimos el num de dimensiones
#define DIMENSION 8

void imprimirTriangularSuperior(int matriz[][DIMENSION], int N);
void imprimirTriangularInferior(int matriz[][DIMENSION], int N);
void imprimirDiagonalPrincipal(int matriz[][DIMENSION], int N);

int main() {
    int matriz[DIMENSION][DIMENSION] = {
        {1, 2, 3, 4, 5, 6, 7, 8},
        {9, 10, 11, 12, 13, 14, 15, 16},
        {17, 18, 19, 20, 21, 22, 23, 24},
        {25, 26, 27, 28, 29, 30, 31, 32},
        {33, 34, 35, 36, 37, 38, 39, 40},
        {41, 42, 43, 44, 45, 46, 47, 48},
        {49, 50, 51, 52, 53, 54, 55, 56},
        {57, 58, 59, 60, 61, 62, 63, 64}
    };
    imprimirDiagonalPrincipal(matriz, DIMENSION);
    imprimirTriangularSuperior(matriz, DIMENSION);
    imprimirTriangularInferior(matriz, DIMENSION);

    return 0;
}

void imprimirTriangularSuperior(int matriz[][DIMENSION], int N) {
    printf("Matriz Triangular Superior:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (j < i) {
                printf("%d ", matriz[i][j]);
            } else {
                printf("  ");
            }
        }
        printf("\n");
    }
}

void imprimirTriangularInferior(int matriz[][DIMENSION], int N) {
    printf("Matriz Triangular Inferior:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (j > i) {
                printf("%d ", matriz[i][j]);
            } else {
                printf("  ");
            }
        }
        printf("\n");
    }
}

void imprimirDiagonalPrincipal(int matriz[][DIMENSION], int N) {
    printf("Diagonal Principal:\n");
    for (int i = 0; i < N; i++) {
        printf("%d ", matriz[i][i]);
    }
    printf("\n");
}