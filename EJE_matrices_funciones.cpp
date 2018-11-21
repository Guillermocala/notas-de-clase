/*
*elaborar un algoritmo que lea una matriz de n filas y n columnas y calcule la suma de las filas y de las columnas, dejando 
*los resultados en dos vectores, uno con la suma de las filas y otro con la suma de las columnas
*/
#include <iostream>
using namespace std;
int filas;
void EntrarMatrizNca (float matriz[][10], int NFilas); /*solo se van a aceptar datos NUMERICOS*/
void SumaFilas (float matriz[][10], int NFilas, float Sfila[]);
void SumaColumnas (float matriz[][10], int NFilas, float SCol[]);
void imprimeVector (float vector[], int NElem); /*nos sirve para imprimir cualquier vector*/

int main()
{
	cout << "Entre la cantidad de filas: ";
	cin >> filas;
	float Datos[filas][10];
	float fila[filas];
	float columna[10];
	EntrarMatrizNca (Datos, filas);
	SumaFilas (Datos, filas, fila);
	SumaColumnas (Datos, filas, columna);
	cout << "\nEl vector que contiene la suma por filas es: " << endl;
	imprimeVector(fila, filas);
	cout << "\nEl vector que contiene la suma por columnas es: " << endl;
	imprimeVector (columna, 10);
	
	system ("pause");
	return 0;
}
void EntrarMatrizNca (float matriz[][10], int NFilas)
{
	int i, j;
	for (i = 0; i < NFilas; i++) /*leer las matrices*/
	{
		for (j = 0; j < 10; j++)
		{
			cout << "Ingrese la posicion " << "[" << i+1 << "] [" << j+1 << "] : ";
			cin >> matriz[i][j];
		}
	}
}
void SumaFilas (float matriz[][10], int NFilas, float SFila[])
{
	float suma = 0;
	for (int i = 0; i < NFilas; i++)
	{
		for (int k = 0; k < 10; k++)
		{
			suma = suma + matriz[i][k];
		}
		SFila[i] = suma; /*guarda en el vector la suma de esa fila*/
		suma = 0;
	}
}
void SumaColumnas (float matriz[][10], int NFilas, float SCol[])
{
	float suma = 0;
	for (int m = 0; m < 10; m++)
	{
		for (int p = 0; p < NFilas; p++)
		{
			suma = suma + matriz[p][m];
		}
		SCol[m] = suma; /*guarda en el vector la suma de esa columna*/
		suma = 0;
	}	
}
void imprimeVector (float vector[], int NElem)
{
	for (int i = 0; i < NElem; i++)
	{
		cout << "Elemento [" << i + 1 << "] del vector es: " << vector [i] << endl;	
	}
}
