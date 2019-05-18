#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;
struct lista
{
	char info;
	lista *sig;
};
lista *ptr = NULL, *Tope = NULL, *r, *Tope1 = NULL;
lista *InsertaPila(lista *tope, int info);
bool PilaVacia(lista *tope);
lista *ElimPila(lista *tope);
char InfoPila(lista * tope);
void Mostrar(lista *tope);
lista *InicPila(lista *tope);
lista *ElimRep(lista *tope, int elem);
lista *Reemplazar(lista *tope);
lista *ElimMayor(lista *tope, int elem);
lista *Binario(lista *tope, int num);
lista *UnicaOcu(lista *tope);
bool Parentesis(lista *tope);
int menu (void);

int main(int argc, char*argv[])
{
	system("clear");
	string a1;
	char xinfo2[50];
	int sw = 1, i, j, xinfo, limit;
	long opcion;
	do{
		switch (menu())
		{
			case 1:
				system("clear");
				cin.ignore();
				cout << "Ingrese el dato: ";
				getline(cin, a1);
				strcpy(xinfo2, a1.c_str());
			   limit = strlen(xinfo2);
				for(int i = 0; i < limit; i++)
				{
					Tope = InsertaPila(Tope, xinfo2[i]);
				}
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
				Mostrar(Tope);
				cout << endl;
				Mostrar(Tope1);
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
					if(Parentesis(Tope))
			      {
			         cout << "Parentesis apareados correctamente" << endl;
			      }
			      else
			      {
			         cout << "Parentesis no apareados correctamente" << endl;
			      }
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
lista *InsertaPila(lista *tope, int info)
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
void Mostrar(lista *tope)
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
bool Parentesis(lista *tope)
{
	lista *tope2, *tope3, *tope4;
	tope2 = InicPila(tope2);
	tope3 = InicPila(tope3);
	tope4 = InicPila(tope4);
	char dato;
	while(!PilaVacia(tope))
	{
		dato = InfoPila(tope);
      /*si evaluamos con != no funciona y pasa todo a tope3*/
		if(dato == '(' || dato == ')')
		{
			tope3 = InsertaPila(tope3, InfoPila(tope));
		}
		else
		{
			tope2 = InsertaPila(tope2, InfoPila(tope));
		}
		tope = ElimPila(tope);
	}
   /*si no hay parentesis*/
	if(PilaVacia(tope3))
	{
		return false;
	}
	else
	{
		while(!PilaVacia(tope3))
		{
			dato = InfoPila(tope3);
         /*como quedan en orden inverso preguntamos por el contrario*/
			if(dato == '(')
			{
				tope4 = InsertaPila(tope4, dato);
			}
			else
			{
				if(PilaVacia(tope4))
				{
					return false;
				}
				else
				{
					tope4 = ElimPila(tope4);
				}
			}
			tope3 = ElimPila(tope3);
		}
		if(!PilaVacia(tope4))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
