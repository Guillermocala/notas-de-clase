#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;
struct lista
{
	int info;
	lista *sig;
};

lista *ptr = NULL, *Tope = NULL, *r, *Tope1 = NULL;
lista *InsertaPila(lista *tope, char info);
bool PilaVacia(lista *tope);
lista *ElimPila(lista *tope);
char InfoPila(lista * tope);
void mostrar(lista *tope);
lista *InicPila(lista *tope);
lista *ElimRep(lista *tope, int elem);
lista *Reemplazar(lista *tope);
lista *ElimMayor(lista *tope, int elem);
int menu (void);

int main(int argc, char*argv[])
{
	system("clear");
	int sw = 1, i, j, xinfo;
	long opcion;
	do{
		switch (menu())
		{
			case 1:
				system("clear");
				cout << "Ingrese el dato: ";
				cin >> xinfo;
				Tope = InsertaPila(Tope, xinfo);
				break;
			case 2:
				system("clear");
				cout << "Ingrese el dato: ";
				cin >> xinfo;
				Tope1 = InsertaPila(Tope1, xinfo);
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
				cout << "Ingrese el elemento a eliminar";
				cin >> xinfo;
				Tope = ElimRep(Tope, xinfo);
				/*
				printf ("Ingrese un numero...");
				scanf ("%d", &xinfo);
				Tope1=InsertaPila(Tope1,xinfo);
				mostrar(Tope1);
				// para ejercicios*/
				break;
			case 5:
				system("clear");
				mostrar(Tope);
				cout << endl;
				mostrar(Tope1);
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
	printf("\t\t\t� 4  ->  Eliminar Unica Ocu      �\n");
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
lista *InsertaPila(lista *tope, char info)
{
	lista *r = (struct lista*) malloc (sizeof(lista));
	r->info = info;
	/* completar con el algoritmo de insertar cabeza */
	if(tope == NULL)
	{
		tope = r;
		r->sig = NULL;
	}
	else
	{
		r->sig = tope;
		tope = r;
	}
	return tope;
}
lista *ElimPila(lista *tope)
{
	if(!PilaVacia(tope))
	{
		r=tope;
		tope = tope->sig;
		free(r);
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
bool PilaVacia(lista *tope)
{
	if(tope == NULL)
	{
		return true;
	}
	else
	{
		return false;
	}
}
char InfoPila(lista *tope)
{
	return tope->info;
}
void mostrar(lista *tope)
{
	r = tope;
	if(tope == NULL)
	{
		printf("\n La Pila esta Vacia....\n");
	}
	else
	{
		while(r!=NULL)
		{
			cout << r->info << " -> " ;
			r = r->sig;
		}
	}
	cin.ignore();
	cin.get();
}
lista *ElimRep(lista *tope, int elem)
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
lista *InicPila(lista *tope)
{
	tope = NULL;
	return tope;
}
