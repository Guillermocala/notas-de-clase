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
bool modificador = true;
char salida_bucle;

int main(){
		cout << "INGRESE NUMEROS ENTEROS DISTINTOS" << endl;
		cout << "ingrese el primer numero: ";
		cin >> num1;
		cout << "ingrese el segundo numero: ";
		cin >> num2;
		cout << "ingrese el tercer numero: ";
		cin >> num3;
		
		calculo(num1, num2, num3);
	
system("pause");
return 0;
}

int calculo(int a, int b, int c){
		if(num1 > num2 && num1 > num3){
		cout << "el mayor es: " << num1 << endl;
			if(num2>num3){
				cout << "el medio es: " << num2 << endl;
				cout << "el menor es: " << num3 << endl;
			}
			else
				cout << "el medio es: " << num3 << endl;
				cout << "el menor es: " << num2 << endl;
		}
		else if(num2 > num1 && num2 > num3){
		cout << "el mayor es: " << num2 << endl;
			if(num1>num3){
				cout << "el medio es: " << num1 << endl;
				cout << "el menor es: " << num3 << endl;
			}
			else
				cout << "el medio es: " << num3 << endl;
				cout << "el menor es: " << num1 << endl;
		}
		else if(num3>num1 && num3>num2){
		cout << "el mayor es: " << num3 << endl;
			if(num1>num2){
				cout << "el medio es: " << num1 << endl;
				cout << "el menor es: " << num2 << endl;
			}
			else
				cout << "el medio es: " << num2 << endl;
				cout << "el menor es: " << num1 << endl; 
		}
		else
			cout << "usted ha ingresado valores invalidos!" << endl;
}





