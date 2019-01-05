/*
*elaborar un programa que sume los elementos de cada una de las filas y de cada una de las columnas de una matriz; 
*el resultado de cada suma se almacenara en la ultuma posicion de la fila o columna correspondiente
*ademas la suma total de todos los elementos de la matriz se almacenara en el elemento de la esquina inferior derecha de la matriz
*	1	7	0	=== 1	7	8
*	5	6	0	=== 5	6	11
*	6	4	0	=== 6	4	10
*	7	3	0	=== 7	3	10
*	0	0	0	=== 19	20	39
*	
*	C = C + 1
*	F = F + 1
*/
#include <iostream>
using namespace std;
int filas, columnas;
const int NFilas = 10;
const int NColumnas = 10;
float Matriz[NFilas][NColumnas];
void LeerMatriz (float Tabla[][NColumnas], int CFilas, int CColumnas);
void SumaFilas (float Tabla[][NColumnas], int *CFilas, int *CColumnas); 
void SumaColumnas (float Tabla[][10], int *CFilas, int *CColumnas); 
void MostrarMatriz (float Tabla[][10], int CFilas, int CColumnas);

int main ()
{
	cout << "Ingrese el numero de las filas (maximo 9): ";
	cin >> filas;
	cout << "Ingrese el numero de columnas (maximo 9): ";
	cin >> columnas;
	LeerMatriz (Matriz, filas, columnas);
	SumaFilas (Matriz, &filas, &columnas);
	SumaColumnas (Matriz, &filas, &columnas);
	MostrarMatriz (Matriz, filas, columnas);
	system ("pause");
	return 0;
}
void LeerMatriz (float Tabla[][NColumnas], int CFilas, int CColumnas)
{
	int i, j;
	for (i = 0; i < CFilas; i++) /*leer las matrices*/
	{
		for (j = 0; j < CColumnas; j++)
		{
			cout << "Ingrese el valor en la posicion [" << i + 1 << "] [" << j + 1 << "]: ";
			cin >> Tabla[i][j];
		}
	}
}
void SumaFilas (float Tabla[][NColumnas], int *CFilas, int *CColumnas)
{
	int i, j;
	for (i = 0; i < *CFilas; i++)
	{
		float suma = 0;
		for (j = 0; j < *CColumnas; j++)
		{
			suma = suma + Tabla[i][j];
		}
		Tabla[i][j] = suma; /*guarda en la ultima columna de esa fila*/
		suma = 0;
	}
	*CColumnas = *CColumnas + 1;
}
void SumaColumnas (float Tabla[][10], int *CFilas, int *CColumnas)
{
	int i, j;
	for (i = 0; i < *CColumnas; i++)
	{
		float suma = 0;
		for (j = 0; j < *CFilas; j++)
		{
			suma = suma + Tabla[j][i];
		}
		Tabla[j][i] = suma; /*guarda en la ultima fila de esa columna*/
		suma = 0;
	}
	*CFilas = *CFilas + 1;
}
void MostrarMatriz (float Tabla[][10], int CFilas, int CColumnas)
{
	int i, j;
	for (i = 0; i < CFilas; i++)
	{
		for (j = 0; j < CColumnas; j++)
		{
			cout << "[" << i + 1 << "][" << j + 1 << "]" << Tabla[i][j] << "\t";
		}
		cout << endl;
	}
}
