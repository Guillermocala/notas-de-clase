//elabore un programa para encontrar el promedio de edad de un grupo de estudiantes
/*=================================ANALISIS===========================
	salida: promedio estudiantes
	
	proceso: solicitar al usuario el numero de estudiantes(NE)
			 NE controla el ciclo al compararlo con un controlador de edades procesadas (EP)
			 leer dato
			 sumar las edades (SE)
			 despues de terminar el ciclo hallar el promedio de edad e imprimirlo. promedio = suma edades / numero estudiantes
	entradas: NE numero de estudiantes
			  edad edad de cada estudiante
*/

#include <iostream>

using namespace std;

int main(){
	int numero_estudiantes;
	int edades;
	float promedio;
	int contador_edades = 0;
	float suma_edades = 0;
	cout << "ingrese el numero de estudiantes: ";
	cin >> numero_estudiantes;
	while(numero_estudiantes > contador_edades){
		cout << "ingrese edad: ";
		cin >> edades;
		suma_edades = suma_edades + edades;
		contador_edades = contador_edades + 1;
	}
	promedio = suma_edades / numero_estudiantes;
	cout<< "el promedio de la edad de "<< numero_estudiantes << " estudiantes es: " << promedio << endl;

system("pause");
return 0;
}

