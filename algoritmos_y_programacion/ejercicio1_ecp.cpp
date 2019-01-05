//encuentre y muestre la suma de los 5 primeros numeros naturales

#include <iostream>

using namespace std;

int main(){
	int suma = 0;
	int numero = 0;
	while (numero < 5){
		numero=numero+1;
		suma=suma+numero;
	}
	cout << suma<<endl;
system("pause");
return 0;
}

