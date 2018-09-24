/*elaborar un programa que obtenga el salario neto de cada uno de los 20 trabajadores de la empresa S.A y el total que debe para la empresa. se debe leer en cada resitro:
el nombre del trabajador, su salario basico por hora, el numero de horas trabajadas y el porcentaje de retencion en la fuente. 
se debe obtener e imprimir de cada trabajador: su nombre, el valor de su retencion y su salario neto
*/
/*============================================ANALISIS==========================================
salida: 4 datos: nombre trabajador
				 salario bruto
				 retencion
				 salario neto
proceso: salario bruto = salario basico * horas trabajadas
		 retencion = valor de retencion * salario bruto / 100
		 salario neto = salario bruto - retencion
entrada: nombre del trabajador, salario basico, numero horas trabajadas y valor de retencion(prestanciones, salud, etc)
*/
#include <iostream>

using namespace std;
//con iniciador limito activo el bucle y n_trabajador indicará en el programa en numero de trabajador que se esta procesando
int iniciador = 0, n_trabajador = 1;

int main(){
	while(iniciador<21){
		string nombre_trabajador;
		int porcent, salario_hora, num_horas, salario_bruto;
		float retencion, salario_neto;
		cout << "ingrese el nombre del trabajador: ";
		cin >> nombre_trabajador;
		cout << "ingrese su salario basico por hora: ";
		cin >> salario_hora;
		cout << "ingrese el numero de horas trabajadas: ";
		cin >> num_horas;
		cout << "ingrese el porcentaje de retencion: ";
		cin >> porcent;
		//un calculo normal de salario en el cual se multiplica el valor de la hora de trabajo por el numero de horas trabajadas
		salario_bruto = salario_hora * num_horas;
		/*la retencion se consigue extrayendo el pocentaje del salario bruto: 
		multiplica la cantidad porcentual que da el ususario por el salario bruto y se divide entre 100*/
		retencion = porcent * salario_bruto / 100;
		//salario neto solo se calcula restandole al salario bruto el valor de retencion 
		salario_neto = salario_bruto - retencion;
	//se limpia la pantalla antes de imprimir los datos para que no se acumule en la consola los datos y los muestre de forma ordenada
	system("cls");
		cout << "trabajador n- " << n_trabajador << endl << "trabajador: " << nombre_trabajador << endl;
		cout << "su salario bruto es: " << salario_bruto << "\nel valor de su retencion es: " << retencion << "\nsu valor neto es: " << salario_neto << "\n\n";
		//aqui se modifica la var de activacion del bucle para que se ejecute en este caso 20 veces
		iniciador = iniciador +1;
		/*esto nos permite incrementar una unidad la var numero trabajador que se mostrara en el programa
		para indicar al usuario por cual trabajador se lleva el proceso*/
		n_trabajador = n_trabajador + 1;
	}
system("pause");
return 0;
}

