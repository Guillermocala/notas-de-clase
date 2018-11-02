#include <iostream>
#include <string.h>

using namespace std;

char datos;

int main(){
	char nombre[100]; //define el tamaño del vector
	cout << "\tINVERTIRDOR DE TEXTO"<< endl;
	cout << "Ingrese una texto(que no exceda 100 caracteres): ";
	gets(nombre);
	datos = strlen(nombre);
	cout << endl;
	cout << "La sentencia invertida es: ";
	for(int i=datos-1; i>=0; i--){ //para mostrar el valor invertido
		cout << nombre[i];
	}
	cout << endl;
return 0;
}
