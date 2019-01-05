/*escriba un programa que permita leer numeros hasta que se digite 0 y determinar a cuanto es igual el promedio de los numeros leidos*/
#include <iostream>

using namespace std;

int main(){
	int num, contador_rep=1, suma;
	float promedio;
	cout <<"ingrese un numero: ";
	cin >> num;
	
	while(num>0){
		cout << "ingrese un numero: ";
		cin >> num;
		if(num!=0){
			suma+=num;
			promedio=suma/contador_rep;
			contador_rep+=1;
		}
		else{
			cout << "el programa se cerrara." << endl;
		}
	}
	cout << "el promedio es: " << promedio << endl; 



system("pause");
return 0;
}

