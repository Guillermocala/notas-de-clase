//realizar un programa que reciba tres numeros enteros diferentes y muestre esos numeros en forma ascendente
/*===============================ANALISIS================================
salida: numero mayor
		numero medio
		numero menor

proceso: num1 > num2 && num1 >num3... num1 es el numero mayor
		 num2 > num3... num2 es el numero mediano
		 num3 es el numero menor

entrada: num1, num2, num3
*/

#include <iostream>

using namespace std;

int num1, num2, num3, calculo(int a, int b, int c);
bool entrada_bucle = true;
int salida_bucle;

int main(){
	while(entrada_bucle == true){
		cout << "INGRESE NUMEROS ENTEROS DISTINTOS" << endl;
		cout << "ingrese el primer numero: ";
		cin >> num1;
		cout << "ingrese el segundo numero: ";
		cin >> num2;
		cout << "ingrese el tercer numero: ";
		cin >> num3;
		
		calculo(num1, num2, num3);
		cout << "digite (0) para salir del programa\no cualquier otro numero para permanecer en el: ";
		cin >> salida_bucle;
		if(salida_bucle == 0){
			entrada_bucle = false;
		}
		else{
			entrada_bucle = true;
			system("cls");
		}
	}
system("pause");
return 0;
}

int calculo(int a, int b, int c){
	if(num1 > num2 || num1 > num3){
	cout << "el mayor es: " << num1 << endl;
		if(num2>num3){
			cout << "el medio es: " << num2 << endl;
			cout << "el menor es: " << num3 << endl;
		}
		else if(num3>num2){
			cout << "el medio es: " << num3 << endl;
			cout << "el menor es: " << num2 << endl;
		}
		else{
			cout << "ha ingresado valores invalidos!" << endl;
		}
	}
	else if(num2 > num1 || num2 > num3){
	cout << "el mayor es: " << num2 << endl;
		if(num1>num3){
			cout << "el medio es: " << num1 << endl;
			cout << "el menor es: " << num3 << endl;
		}
		else if(num3>num1){
			cout << "el medio es: " << num3 << endl;
			cout << "el menor es: " << num1 << endl;
		}
		else{
			cout << "ha ingresado valores invalidos!" << endl;
		}
	}
	else if(num3>num1 || num3>num2){
	cout << "el mayor es: " << num3 << endl;
		if(num1>num2){
			cout << "el medio es: " << num1 << endl;
			cout << "el menor es: " << num2 << endl;
		}
		else if(num2>num1){
			cout << "el medio es: " << num2 << endl;
			cout << "el menor es: " << num1 << endl; 
		}
		else{
			cout << "ha ingresado valores invalidos!" << endl;
		}
	}
	else{
		cout << "usted ha ingresado valores invalidos!" << endl;
	}
}





