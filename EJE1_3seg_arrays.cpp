/*elaborar un programa que entre n datos y forme un vector, se sabe que estos datos 
deben estar ordenados y despues se debe insertar un dato e ingresarlo al vector de forma ordenada*/
#include <iostream>
using namespace std;
void insertardato(float datos[], float vinsertar, int *n);
void leerdato(float datos[], float indicador);
void imprimevector(float datos[], float indicador);
int cantidad, i;
float valor;
float vector[20];

int main(){
	cout << "Entre el numero de elementos del vector(maximo 20): ";
	cin >> cantidad;
	cout << "\nRecuerde que debe entrar los datos del vector ordenados ascendentemente "<< endl;
	leerdato(vector, cantidad);
	cout << "\nEntre el dato a insertar en el vector ordenado: ";
	cin >> valor;
	cout << "\nEste es el valor de cantidad antes de llamar la funcion: " << cantidad << endl;
	insertardato(vector, valor, &cantidad); //paso por valor y por referencia
	cout << "\nEste es el valor de cantidad despues de llamar la funcion: " << cantidad << endl;
	cout << "\nEl nuevo vector ordenado es: ";
	imprimevector(vector, cantidad);
	cout << endl;
system("pause");
return 0;
}
void imprimevector(float datos[], float indicador){// para imprimir el vector
	for(i=0; i<indicador; i++){
		cout << "\nEn la posicion " << i+1 << " : " << datos[i];
	}
}
void leerdato(float datos[], float indicador){//funcion que anade los datos al vector
	for(i=0;i<indicador;i++){
		cout << "Entre el dato para la posicion " << i+1 << " : ";
		cin >> datos[i];//añade los datos en orden creciente
	}
}
void insertardato(float datos[], float vinsertar, int *n){
	if(datos[*n - 1] <= vinsertar){ //si es el mayor de todos
		datos[*n] = vinsertar; //queda en la ultima posicion
		*n += 1;
	}
	else{ //si esta dentro de los datos ordenados
		int j = 0;
		while(j < *n){
			if(vinsertar < datos[j]){ // encontro el puesto del elemento
				for(int k=*n;k>j;k--){ //mueve de atras hacia adelante hasta el puesto encontrado
					datos[k] = datos[k-1];
				}
				datos[j] = vinsertar; //coloca el nuevo elemento en su puesto
				*n += 1; //ahora el arreglo tiene un elemento mas
				j += *n; //para salir del ciclo forzado
			} //termina de mover cuando encontro uno mayor
			else{
				j+=1;
			}
		} //se cierra el while
	} //se cierra el else
}
