#include "iostream"
#include "conio.h"
using namespace std;

struct Nodo
{
    int info;
    Nodo *sig;
};
Nodo *ptr = NULL;
Nodo *InicPila(Nodo *tope);
Nodo *InsertaPila(Nodo *tope, int elem);
int InfoPila(Nodo *tope);
Nodo *ElimPila(Nodo *tope);
bool PilaVacia(Nodo *tope);
void Mostrar(Nodo *tope);
int menu();

int main()
{
   int sw = 1, dato;
   do {
      switch(menu())
      {
         case 1:
            system("CLS");
            cout << "Ingrese el dato: ";
            cin >> dato;
            ptr = InsertaPila(ptr, dato);
            break;
         case 2:
            system("CLS");
            if(PilaVacia(ptr))
            {
               cout << "La pila esta vacia..." << endl;
            }
            else
            {
               ptr = ElimPila(ptr);
               cout << "Dato eliminado con exito!";
            }
            getch();
            break;
         case 3:
            Mostrar(ptr);
            break;
         case 4:
            cout << "En construccion..." << endl;
            getch();
            break;
         case 0:
            sw = 0;
            cout << "El programa se cerrara..." << endl;
            getch();
            break;
         default:
            break;
      }
   } while(sw);
   return 0;
}
int menu()
{
   int opcion;
   system("CLS");
   printf ("\n\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#       MENU  LISTA SIMPLE       #\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 1  ->  Insertar Pila           #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 2  ->  Eliminar Tope           #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 3  ->  Mostrar                 #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 4  ->  Ejercicio               #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 0  ->  Salir                   #\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#    Elija una opcion...         #\n");
   printf("\t\t\t##################################\n");
   int sw = 1;
   /*se valida mediante el codigo ASCII de el caracter ingresado*/
   do{
      opcion = getch();
      if(opcion >= 48 && opcion <= 52)
      {
         sw = 0;
      }
      else
      cout << "Se debe ingresar un entero entre 1-4" << endl;
   }while(sw);
   opcion = opcion-48;
   return opcion;
}
Nodo *InicPila(Nodo *tope)
{
    tope = NULL;
    return tope;
}
Nodo *InsertaPila(Nodo *tope, int elem)
{
    Nodo *p;
    p = (struct Nodo*) malloc (sizeof (Nodo));
    p->info = elem;
    if(tope == NULL)
    {
        tope = p;
        p->sig = NULL;
    }
    else
    {
        p->sig = tope;
        tope = p;
    }
    return tope;
}
int InfoPila(Nodo *tope)
{
    int value;
    value = tope->info;
    return value;
}
Nodo *ElimPila(Nodo *tope)
{
    Nodo *j = tope;
    tope = tope->sig;
    free(j);
    return tope;
}
bool PilaVacia(Nodo *tope)
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
void Mostrar(Nodo *tope)
{
   system("CLS");
   Nodo *r = tope;
	if(tope == NULL)
	{
		cout << "La Pila esta Vacia..." << endl;
	}
	else
	{
      cout << "TOPE" << endl;
		while(r!=NULL)
		{
			cout << r->info << "\n";
			r = r->sig;
		}
	}
	getch();
}
