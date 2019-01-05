/*elaborar un algoritmo que muestre la suma de dos matrices (con funciones)*/
#include <iostream>
using namespace std;
void EntraMatrizNca(float matriz[][4], int Nfilas);
void SumaMatrices (float matriz1[][4], float matriz2 [][4], float matrizs[][4], int Nfilas);


int main()
{
	int filas;
	cout << "Ingrese el numero de filas (maximo 10)";
	cin >> filas;
	float primera[filas][4];
	float segunda[filas][4];
	float Msuma[filas][4];
	
	cout << "\nIngrese los datos a la primera matriz " << endl;
	EntraMatrizNca (primera, filas);
	
	cout << "\nIngrese los datos a la segunda matriz " << endl;
	EntraMatrizNca (segunda, filas);
	
	cout << "\nA continuacion se suman las matrices y se muestra la matriz suma " << endl;
	SumaMatrices (primera, segunda, Msuma, filas);
	cout << endl;
	
	
	system("pause");
	return 0;
}
void EntraMatrizNca(float matriz[][4], int Nfilas)
{
	int i, j;
	for (i = 0; i < Nfilas; i++) /*leer las matrices*/
	{
		for (j = 0; j < 4; j++)
		{
			cout << "Ingrese la posicion " << "[" << i+1 << "] [" << j+1 << "] : ";
			cin >> matriz [i][j];
		}
	}
}
void SumaMatrices (float matriz1[][4], float matriz2 [][4], float matrizs[][4], int Nfilas)
{
	int i, j;
	for (i = 0; i < Nfilas; i++)
	{
		for (j = 0; j < 4; j++)
		{
			matrizs[i][j] = matriz1[i][j] + matriz2[i][j];
			cout << "Valor posicion [" << i + 1 << "] [" << j + 1 << "] " << matrizs[i][j] << endl; 
		}
	}
}
