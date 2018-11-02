/*elaborar un programa para encontrar los productos de un grupo  de parejas de valores, 
si se sabe que estos son positivos y no se conoce, el numero de parejas, previamente*/
#include <iostream>

using namespace std;

int main(){
	int num1, num2, producto;
	
	bool activador=true;

	while(activador=true){
		cout << "\tPRODUCTO DE PAREJAS\npara salir del programa ingrese un numero negativo" << endl;
		cout << "ingrese el primer numero positivo: ";
		cin >> num1;
		cout << "ingrese el segundo numero positivo: ";
		cin >> num2;
		if(num1<0 || num2<0){
			break;
		}
		else{
			producto=num1*num2;
			cout << "el producto de " << num1 << " y " << num2 << " es: " << producto << endl; 
		}
	system("pause");
	system("cls");
	}

system("pause");
return 0;
}

