#include <iostream>

using namespace std;

int datos;
float vector[20];
void entra_datos(float vector[], int n);
void mostrar_datosinv(float alimprimir[], int n);

int main(){
	cout << "entre el numero de datos que va a tener el vector: (maximo 20): ";
	cin >> datos;//define el tamaño del vector para el ciclo de entrada de datos
	entra_datos(vector, datos);//funcion que crea arreglo
	cout << endl;
	mostrar_datosinv(vector, datos);//funcion que muetra el arreglo
	cout << endl;
		
system("pause");
return 0;
}
void entra_datos(float vector[], int n){
	float valor;
	for(int i=0; i<n; i++){ //para lectura del vector a partir de la posicion 0
		cout << "entra el valor de la posicion " << i << " del vector: ";
		cin >> valor;
		vector[i] = valor; //se entran datos al vector
	}
}
void mostrar_datosinv(float alimprimir[], int n){
	for(int i=n-1; i>=0; i--){//para mostrar el vector
		cout << "el elemento " << i << " del vector es: " << alimprimir[i] << endl;//se muestran en orden inverso
	}
}
