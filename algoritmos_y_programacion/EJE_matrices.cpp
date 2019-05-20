/*
*elaborar un programa que permita guardar las unidades producidas por cinco maquinas en 30 dias
*el analisis de matrices se hace graficamente, el ejercicio no limita a llenar columnas o filas asi que se llena como mejor parezca el dev
*/
#include <iostream>
using namespace std;
int i, k;
int produccion[5][30];
int main()
{
	/*coloco 4 porque no voy a probar el algoritmo con 30 columnas, pero en vez del 4 va 30*/
	for (k = 0; k < 4; k++) /*para crear la matriz por columnas (dias)*/
	{
		for (i = 0; i < 5; i++) /*se mueven mas rapido las filas (maquinas)*/
		{
			cout << "Entre la cantidad producida para la maquina " << i + 1 << " en el dia " << k + 1 << " : ";
			cin >> produccion[i][k];
		}
	}
	for (i = 0; i < 5; i++) /*para mostrar los datos de la matriz por fila (maquina)*/
	{
		for (k = 0; k < 4; k++)
		{
			cout << "La cantidad producida por [" << i + 1 << "] [" << k + 1 << "] es: " << produccion[i][k] << endl;
		}
	}
	cout << "\n";
	system("pause");
	return 0;
}
