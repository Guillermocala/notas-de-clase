#include <iostream>

using namespace std;

int cuantos;
char valor;
char vector[20];
int cuenta_caracteres(char acontar[]);
void mostrardatos(char alimprimir[], int n);

int main(){
	cout << "ingrese la palabra(maximo 20 caracteres): ";
	cin >> vector;
	cuantos=cuenta_caracteres(vector); //funcion que cuenta # de caracteres de la palabra
	cout << endl;
	mostrardatos(vector, cuantos); //funcion que muestra el arreglo que contiene la palabra
	cout << "\n\n";
	
system("pause");
return 0;
}

int cuenta_caracteres(char acontar[]){
	int i = 0;
	while(acontar[i] != '\0'){
		i++;
	}
	return i;
}
void mostrardatos(char alimprimir[], int n){
	cout << "la palabra clave al reves es: ";
	for(int i=n-1; i>=0; i-=1){ //para mostrar el vector
		cout << alimprimir[i]; //se muestran los datos desde el vector
	}
}
