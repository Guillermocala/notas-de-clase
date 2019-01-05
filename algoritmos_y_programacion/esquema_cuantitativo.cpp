/*escribir un programa que encuentre en un conjunto de n numero:
		1-cuantos son menores que 15
		2-cuantos son mayores de 50
		3-cuantos estan comprendidos entre 25 y 45
*/

#include <iostream>

using namespace std;

int n, menores15=0, mayores50=0, entre25y45=0, cuantos=0, indicador=1;
float numero;

int main(){

	cout << "ingrese el numero de datos a procesar: ";
	cin >> n;
	while(cuantos < n){
		cout << indicador << " - " << "ingrese el dato a procesar: ";
		cin >> numero;
		cuantos +=1;
		indicador +=1;
		if(numero < 15){
			menores15 +=1;
		}
		else if(numero > 50){
			mayores50+=1;
		}
		else if(numero >= 25 && numero <= 45){
			entre25y45+=1;
		}
	}
	cout << "la cantidad de numeros menores que 15 son: " << menores15 << endl;
	cout << "la cantidad de numeros mayores a 50 son: " << mayores50 << endl;
	cout << "la cantidad de numeros entre 25 y 45 son: " << entre25y45 << endl;

system("pause");
return 0;
}

