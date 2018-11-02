<<<<<<< HEAD
/*ENUNCIADO: realice un programa haciendo uso de dev c++ que lea un grupo de datos y haciendo uso de una funcion 
encuentre si cada uno de los valores entrados pertenecen o no a un rango y lo comunique al programa principal, 
quien lo debe informar al usuario, recuerde usar variables locales y globales.
====================================ANALISIS===============================
	salidas: candena 2 opciones:
		pertenecen al rango
		no pertenece al rango
	proceso: ingrese cuantos datos se va a procesar = num_datos
			 ingrese el rango inicial = rango_inicial
			 ingrese el rango final = rango_final
			 mientras que activador sea menor que num_datos entonces
			 	ingrese un valor entero = datos_usuario
			 	segun la funcion calculo, procesa los datos (datos_usuario,rango_inicial, rango_final)
			 		si datos_usuario >=rango inicial y datos_usuario <=rango_final entonces
			 			el numero datos_usuario pertenece al rango
			 		sino
			 			el numero datos_usuario no pertenece al rango
			 activador= activador +1
			 contador_secuencia = contador_secuencia + 1
			 
	entradas:de tipo entero: datos_usuario, rango, num_datos.
		constantes usadas en el programa: activador, contador_secuencia
*/

#include <iostream>

using namespace std;

int calculo(int a, int b, int c );

int main(){
	int num_datos, datos_usuario, rango_inicial, rango_final, activador=0, contador_secuencia=1;
	
	cout << "ingrese la cantidad de datos a procesar: ";
	cin >> num_datos;
	cout << "ingrese el rango inicial: ";
	cin >> rango_inicial;
	cout << "ingrese el rango final: ";
	cin >> rango_final;
	while(activador < num_datos){
		cout << contador_secuencia << "-" "ingrese un valor entero: ";
		cin >> datos_usuario;
		calculo(datos_usuario, rango_inicial, rango_final);
		activador +=1;
		contador_secuencia +=1;
	}
system("pause");
return 0; 
}
int calculo(int a, int b, int c ){
	if (a>=b && a<=c){
		cout << "el numero " << a << " pertenece al rango." << endl;
	}
	else 
		cout << "el numero " << a << " no pertenece al rango." << endl;	
}

=======
/*ENUNCIADO: realice un programa haciendo uso de dev c++ que lea un grupo de datos y haciendo uso de una funcion 
encuentre si cada uno de los valores entrados pertenecen o no a un rango y lo comunique al programa principal, 
quien lo debe informar al usuario, recuerde usar variables locales y globales.
====================================ANALISIS===============================
	salidas: candena 2 opciones:
		pertenecen al rango
		no pertenece al rango
	proceso: ingrese cuantos datos se va a procesar = num_datos
			 ingrese el rango inicial = rango_inicial
			 ingrese el rango final = rango_final
			 mientras que activador sea menor que num_datos entonces
			 	ingrese un valor entero = datos_usuario
			 	segun la funcion calculo, procesa los datos (datos_usuario,rango_inicial, rango_final)
			 		si datos_usuario >=rango inicial y datos_usuario <=rango_final entonces
			 			el numero datos_usuario pertenece al rango
			 		sino
			 			el numero datos_usuario no pertenece al rango
			 activador= activador +1
			 contador_secuencia = contador_secuencia + 1
			 
	entradas:de tipo entero: datos_usuario, rango, num_datos.
		constantes usadas en el programa: activador, contador_secuencia
*/

#include <iostream>

using namespace std;

int calculo(int a, int b, int c );

int main(){
	int num_datos, datos_usuario, rango_inicial, rango_final, activador=0, contador_secuencia=1;
	
	cout << "ingrese la cantidad de datos a procesar: ";
	cin >> num_datos;
	cout << "ingrese el rango inicial: ";
	cin >> rango_inicial;
	cout << "ingrese el rango final: ";
	cin >> rango_final;
	while(activador < num_datos){
		cout << contador_secuencia << "-" "ingrese un valor entero: ";
		cin >> datos_usuario;
		calculo(datos_usuario, rango_inicial, rango_final);
		activador +=1;
		contador_secuencia +=1;
	}
system("pause");
return 0; 
}
int calculo(int a, int b, int c ){
	if (a>=b && a<=c){
		cout << "el numero " << a << " pertenece al rango." << endl;
	}
	else 
		cout << "el numero " << a << " no pertenece al rango." << endl;	
}

>>>>>>> bb388430e6c2d693c7dd3e6f42952d858bb7a10e
