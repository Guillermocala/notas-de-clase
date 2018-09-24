/*elaborar un programa que obtenga el salario neto de cada uno de los 20 trabajadores de la empresa S.A y el total que debe para la empresa. se debe leer en cada resitro:
el nombre del trabajador, su salario basico por hora, el numero de horas trabajadas y el porcentaje de retencion en la fuente. 
se debe obtener e imprimir de cada trabajador: su nombre, el valor de su retencion y su salario neto
*/


#include <iostream>

using namespace std;

int iniciador = 0, n_trabajador = 1;

int main(){
	while(iniciador<20){
		string nombre_trabajador;
		int porcent, salario_hora, num_horas, salario_bruto;
		float retencion, salario_neto;
		cout << "ingrese el nombre del trabajador: ";
		cin >> nombre_trabajador;
		cout << "ingrese su salario basico po hora: ";
		cin >> salario_hora;
		cout << "ingrese el numero de horas trabajadas: ";
		cin >> num_horas;
		cout << "ingrese el porcentaje de retencion: ";
		cin >> porcent;
		salario_bruto = salario_hora * num_horas;
		retencion = porcent * salario_bruto / 100;
		salario_neto = salario_bruto - retencion;
		cout << "trabajador n- " << n_trabajador << endl << "el trabajador " << nombre_trabajador << endl;
		cout << "su salario bruto es: " << salario_bruto << "\nel valor de su retencion es: " << retencion << "\ny su valor neto es: " << salario_neto << endl;
		iniciador = iniciador +1;
		n_trabajador = n_trabajador + 1;
	}
system("pause");
return 0;
}

