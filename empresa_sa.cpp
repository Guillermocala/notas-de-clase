/*
*guillermo cala; sep/ 23/ 18
*Elaborar un algoritmo que obtenga el salario neto de cada uno de los 20 trabajadores de la Empresa S.A. y el total quedebe pagar la empresa. 
*Se debe leer en cada registro: El nombre del trabajador, su salario básico por hora, el número de horas trabajadas y 
*el porcentaje de retención en la fuente. Se debe obtener e imprimir de cada trabajador: su nombre, el valor de su retención y su salario neto.
*/
#include<iostream>
using namespace std;

int main()
{
	string nombre;
	int cont = 0, sal, horas, i = 1;
	float salario, retencion, ValorReten, salarioTotal, TotalEmpresa, SalarioNeto, impuesto; 
	cout << "Este prorama le permite obtener el salario neto de los trabajadores de la Empresa S. A." << "\n\n";
	while (cont < 20)
	{
		cout << "\t" << "Ingrese el nombre del trabajador #" << i << ": ";
		cin >> nombre;
		i++;
		cout << "\t" << "ingrese el salario basico por hora: ";
		cin >> sal;
		cout << "\t" << "ingrese el numero de horas trabajadas: ";
		cin >> horas;
		cout << "\t" << "ingrese el porcentaje de retencion en la fuente: ";
		cin >> impuesto;
		cout << endl;
		salario = (sal * horas);
		retencion = (impuesto / 100);
		ValorReten = (retencion * salario);
		SalarioNeto = (salario - ValorReten);
		cout << "\t" << "El trabajador " << nombre << " tiene una retencion de: " << ValorReten << " y un salario de total de: " << SalarioNeto << "\n\n";
		cont++;
		TotalEmpresa += SalarioNeto;
	}
    cout << "\t" << "La empresa debe pagar un total de: " << TotalEmpresa << endl;
	system("pause");
	return 0;	
}
