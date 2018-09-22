/*pedir una clave hasta que se entre la clave correcta que es j*/

#include <iostream>

using namespace std;

int main(){
	char clave;
	cout<< "ingrese la clave de un caracter: ";
	cin >> clave;
	while (clave != 'j' && clave != 'J'){
		cout << "la clave es incorrecta!" << endl;
		cout << "ingrese de nuevo la clave: ";
		cin >> clave;
	}
	cout << "su clave es correcta!" << endl;
return 0;	
};

