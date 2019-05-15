#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;
int lista[50], lista2[50];
int Tope = -1, Tope2 = -1;
int InicPila(int tope);
int InsertaPila(int tope,int v[], int info);
int InfoPila(int v[], int tope);
int ElimPila(int tope);
bool PilaVacia(int tope);
void mostrar(int v[], int tope);


int menu (void);

int main(int argc, char*argv[])
{
	system("clear");
	int sw = 1, xinfo;
	long opcion;
	do{
		switch (menu())
		{
			case 1:
				system("clear");
				cout << "Ingrese el dato: ";
				cin >> xinfo;
				Tope = InsertaPila(Tope, lista ,xinfo);
				break;
			case 2:
				system("clear");
				cout << "Ingrese el dato: ";
				cin >> xinfo;
				Tope2 = InsertaPila(Tope2, lista2, xinfo);
				break;
			case 3:
				if(!PilaVacia(Tope))
				{
					Tope = ElimPila(Tope);
				}
				else
				{
					cout << "Lista vacia..." << endl;
					cin.ignore();
					cin.get();
				}
				break;
			case 4:
				system("clear");
				int i, j;
				i = InfoPila(lista, Tope);
				j = InfoPila(lista2, Tope2);
				cout << "Tope 1: " << i << endl;
				cout << "Tope 2: " << j << endl;
				cin.ignore();
				cin.get();
				break;
			case 5:
				system("clear");
				mostrar(lista, Tope);
				cout << endl;
				mostrar(lista2, Tope2);
				break;
			case 6:
				system("clear");
				printf("Press any key to exit...");
				sw = 0;
				break;
			case 7:
				system("clear");
				if(!PilaVacia(Tope))
				{
					/*UNEXPECTED FUNCTION*/
				}
				else
				{
					cout << "Lista vacia" << endl;
				}
				cin.ignore();
				cin.get();
				break;
			default:
				system("clear");
				printf("opcion no valida...por favor intente nuevamente\n");
				break;
		}
	}while(sw);
	cin.ignore();
	cin.get();
}
int menu(void)
{
	int opcion;
	system("clear");
	printf("\n\n");
	printf("\t\t\t����������������������������������\n");
	printf("\t\t\t�     ESTRUCTURA DE DATOS        �\n");
	printf("\t\t\t����������������������������������\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 1  ->  Insertar Pila           �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 2  ->  Insertar Pila 2         �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 3  ->  Eliminar Tope           �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 4  ->  Info Pila               �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 5  ->  Mostrar                 �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 6  ->  Salir                   �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t� 7  ->  ejercicio               �\n");
	printf("\t\t\t�                                �\n");
	printf("\t\t\t����������������������������������\n");
	printf("\t\t\t�    Elija una opcion...         �\n");
	printf("\t\t\t����������������������������������\n");
	cin >> opcion;
	return opcion;
}
int InicPila(int tope)
{
   tope = -1;
   return tope;
}
int InsertaPila(int tope,int v[], int info)
{
   tope++;
	v[tope] = info;
	return tope;
}
int InfoPila(int v[], int tope)
{
   return v[tope];
}
int ElimPila(int tope)
{
	if(!PilaVacia(tope))
	{
		tope--;
		printf("\n Registro Eliminado con Exito\n");
		return tope;
	}
	else
	{
		printf("\n La Pila esta Vacia....\n");
	}
	cin.ignore();
	cin.get(); /* completar con el algoritmo de insertar cabeza */
}
bool PilaVacia(int tope)
{
	if(tope < 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}
void mostrar(int v[], int tope)
{
	if(tope < 0)
	{
		printf("\n La Pila esta Vacia....\n");
	}
	else
	{
		for(int i = 0; i <= tope; i++)
      {
         cout << v[i] << " -> " ;
      }
	}
	cin.ignore();
	cin.get();
}
/*lista *ElimRep(lista *tope, int elem)
{
	lista *tope2;
	tope2 = InicPila(tope2);
	while(!PilaVacia(tope))
	{
		if(InfoPila(tope) != elem)
		{
			tope2 = InsertaPila(tope2, InfoPila(tope));
		}
		tope = ElimPila(tope);
	}
	while(!PilaVacia(tope2))
	{
		tope = InsertaPila(tope, InfoPila(tope2));
		tope2 = ElimPila(tope2);
	}
	return tope;
}
*/
