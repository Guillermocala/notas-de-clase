/*este codigo es para generalizar la forma de anillo de una matriz, debe cumplir:
-matriz de dimensiones iguales(matriz cuadrada)
-matriz de dimensiones par
-matriz de dimensiones mayor o igual a 4*/

#include <stdio.h>

//definimos el num de dimensiones
#define DIMENSION 8

void imprimeAnillo(int matriz[][DIMENSION], int N);

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
    imprimeAnillo(matriz, DIMENSION);
    

    return 0;
}

void imprimeAnillo(int matriz[][DIMENSION], int N) {
    for (int capa = 0; capa < N / 2; capa++) {
        printf("capa%d:\n", capa + 1);
        for (int i = capa; i < N - capa; i++) {
            for (int j = capa; j < N - capa; j++) {
                if (i == capa || i == N - capa - 1 || j == capa || j == N - capa - 1) {
                    /*cuando vayamos a hacer la operación aqui es donde
                    nos interesa este codigo, tomamos la posicion [i][j]
                    de aqui que es con la que vamos a operar*/
                    printf("%d ", matriz[i][j]);
                } else {
                    printf("  ");
                }
            }
            printf("\n");
        }
        printf("\n");
    }
}