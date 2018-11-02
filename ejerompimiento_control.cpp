<<<<<<< HEAD
//se tiene una serie de N numeros, se desea saber si dentro de ellos existe al menos un 0(cero)
#include <iostream>

using namespace std;

int main(){
	int gp_num, num, activador=1, guia=1, cont=0;
	cout << "\tSERIE DE NUMEROS ENTEROS\nno ingrese numeros de mas de 10 digitos!\nel programa calculara cuantos ceros hay en la serie" << endl;
	cout << "ingrese la cantidad de numeros a procesar: ";
	cin >> gp_num;
	while(activador <= gp_num){
		cout << guia <<"-ingrese un numero: ";
		cin >> num;
		if(num==0){
			cont++;
		}
		guia++;
		activador++;
	}
	if(cont>0){
		cout << "hay " << cont << " ceros en la serie" << endl;
	}
	else{
		cout << "no hay valores ceros en la serie" << endl;
	}

system("pause");
return 0;
}

=======
//se tiene una serie de N numeros, se desea saber si dentro de ellos existe al menos un 0(cero)
#include <iostream>

using namespace std;

int main(){
	int gp_num, num, activador=1, guia=1, cont=0;
	cout << "\tSERIE DE NUMEROS ENTEROS\nno ingrese numeros de mas de 10 digitos!\nel programa calculara cuantos ceros hay en la serie" << endl;
	cout << "ingrese la cantidad de numeros a procesar: ";
	cin >> gp_num;
	while(activador <= gp_num){
		cout << guia <<"-ingrese un numero: ";
		cin >> num;
		if(num==0){
			cont++;
		}
		guia++;
		activador++;
	}
	if(cont>0){
		cout << "hay " << cont << " ceros en la serie" << endl;
	}
	else{
		cout << "no hay valores ceros en la serie" << endl;
	}

system("pause");
return 0;
}

>>>>>>> bb388430e6c2d693c7dd3e6f42952d858bb7a10e
