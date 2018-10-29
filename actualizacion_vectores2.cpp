/*elaborar un programa que forme un vector de n elementos, luego lea un valor y lo elimine tantas veces como aparezca en el arreglo*/
#include <iostream>

using namespace std;

int cantidad, i, j, k,l;
float valor;
float vector[20];

int main(){
	cout << "Entre el numero de elementos del vector(maximo 20): ";
	cin >> cantidad;
	cout << "\nEntrar los datos del vector" << endl;
	for(i=0; i<cantidad; i++){
		cout << "Entre el dato para la posicion " << i+1 << " : ";
		cin >> vector[i];
	}
	cout << "\nEntre el dato a borrar del vector: ";
	cin >> valor;
	j = 0;
	while(j < cantidad){ // se hace con todos porque pueden haber repetidos
		if(valor==vector[j]){ //si el valor a borrar se encontro
			for(k=j; k<cantidad-1; k++){ //se debe mover empezando en esa posicion
				vector[k] = vector[k+1]; // se mueven los elementos del vector de la posicion anterior
			}
			cantidad -= 1; // no avanza en j, porque se debe revisar de nuevo
		}
		else{
			j+=1; // se avanza porque este valor no es igual al buscado
		}
	} // se cierra el while
	cout << "\nEl nuevo vector: "; //se imprime el vector
	for(i=0; i<cantidad; i++){
		cout << "\nEn la posicion " << i+1 << " : " << vector[i];
	}
	cout << endl;
system("pause");
return 0;
}
