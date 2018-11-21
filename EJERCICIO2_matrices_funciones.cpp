/*
*elaborar un programa que sume los elementos de cada una de las filas y de cada una de las columnas de una matriz; 
*el resultado de cada suma se almacenara en la ultima posicion de la fila o columna correspondiente
*ademas la suma total de todos los elementos de la matriz se almacenara en el elemento de la esquina inferior derecha de la matriz
1	7	0
5	6	0
6	4	0
7	3	0
0	0	0
*/
#include <iostream>
using namespace std;
void insertaVector (int vector, int Nfilas);
void imprimeVector (int vector, int Nfilas);

int main ()
{
	cout << "Ingrese el numero de filas: ";
	cin >> filas;
	int numeros[filas][10];
	insertaVector(numeros, filas);
	imprimeVector()
	
	
	
	system ("pause");
	return 0;
}
void insertaVector (int vector, int Nfilas)
{
	for (int j = 0; j < Nfilas; j++)
	{
		for (int k = 0; k < 10; k++)
		{
			cout << "Ingrese el valor para la posicion: [" << j + 1 << "] [" << k + 1 << "] :";
			cin >> vector[j][k];
		}
	}
}
void imprimeVector (int vector, int Nfilas)
{
	for (int i = 0; i < Nfilas; i++)
	{
		cout << "El elemento [" << i + 1 << "] es: " << vector[i] << endl;
		
	}
}
