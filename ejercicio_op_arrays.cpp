//elaborar un programa que permita obtener el listado de un grupo de datos numericos en orden inverso a su orden de lectura
#include <iostream>

using namespace std;

int datos;
float valor;
float vector[20];//este es el numero de datos

int main(){
	cout << "entre el numero de datos que va a tener el vector, maximo 20: ";
	cin >> datos;//define el tamaño del vector para el ciclo de entrada de datos
	for(int i=0; i<datos; i++){//para lectura del vector a partir de la posicion 0
		cout << "entre el valor de la posicion " << i << " del vector: ";
		cin >> valor;
		vector[i] = valor;//se entran datos al vector
	}
	cout << "\n";
	for(int i=datos-1; i>=0; i--){//para mostrar el vector
		cout << "el elemento " << i << " del vector es: " << vector[i] << "\n";//se muestran los detos desde el vector
	}
	cout << "\n";
	
system("pause");
return 0;
}

