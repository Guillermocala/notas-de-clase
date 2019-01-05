/*
*guillermo cala; jan/ 3/ 19
*elaborar un algoritmo que reciba una matriz(cuadrada) y rellene con ceros la diagonal principal y secundaria
*/
#include <iostream>
using namespace std;

int main()
{
	int dimension;
	int matriz[10][10], matriz2[10][10];
	cout << "Ingrese el numero de dimensiones del vector: ";
	cin >> dimension;
	for (int i = 0; i < dimension; i++)/*lee matriz*/
	{
		for (int j = 0; j < dimension; j++)
		{
			cout << "ingrese el valor para la posicion [" << i +1 << "][" << j + 1 << "]: ";
			cin >> matriz[i][j];
		}
	}
	cout << endl;
	for (int i = 0; i < dimension; i++)/*imprime matriz*/
	{
		cout << "[\t";
		for (int j = 0; j < dimension; j++)
		{
			cout << matriz[i][j] << "\t";
		}
		cout << "]\n";
	}
	for (int i = 0; i < dimension; i++)/*hace una copia para no modificar el original*/
	{
		for (int j = 0; j < dimension; j++)
		{
			matriz2[i][j] = matriz[i][j];
		}
	}
	for (int i = 0; i < dimension; i++)/*diagonal principal*/
	{
		matriz2[i][i] = 0;
	}
	for (int i = 0; i < dimension; i++)/*diagonal secundaria*/
	{
		int indice, diagSec;
		diagSec = dimension - 1;
		for (int j = 0; j < dimension; j++)
		{
			indice = i + j;
			if (indice == diagSec)
			{
				matriz2[i][j] = 0;
			}
			else
			{
				/*unexpected function*/
			}
		}
	}
	cout << "\nla matriz modificada queda asi..." << "\n\n";
	for (int i = 0; i < dimension; i++)/*imprime la copia modificada*/
	{
		cout << "[\t";
		for (int j = 0; j < dimension; j++)
		{
			cout << matriz2[i][j] << "\t";
		}
		cout << "]\n";
	}
	system("pause");
	return 0;
}