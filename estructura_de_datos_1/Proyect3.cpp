/*Implemente un algoritmo para evaluar una expresion en notacion infija, sin convertirla a notacion postfija.
Utilice dos pilas, una para operandos y otra para operadores.*/
#include "iostream"
#include "cstring"
using namespace std;

struct lista
{
	char info;
	lista *sig;
};
lista *ptr = NULL, *Tope = NULL, *Tope2 = NULL;
lista *InsertaPila(lista *tope, char info);
lista *ElimPila(lista *tope);
bool PilaVacia(lista *tope);
char InfoPila(lista *tope);
void Mostrar(lista *tope);
lista *ElimRep(lista *tope, int elem);
lista *InicPila(lista *tope);
int Resultado(lista *tope);

int main(int argc, char const *argv[])
{
   int limit;
   char list1[50];
   string data;
   cout << "\t\tCALCULADORA INFIJA" << endl;
   cout << "Ingrese la expresion: ";
   getline(cin, data);
   strcpy(list1, data.c_str());
   limit = strlen(list1);
	for(int i = 0; i < limit; i++)
	{
		Tope = InsertaPila(Tope, list1[i]);
	}
	Resultado(Tope);
   return 0;
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
	lista *r;
	if(!PilaVacia(tope))
	{
		r = tope;
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
	lista *r;
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
int Resultado(lista *pila)
{
   lista *tope, *tope2;
   tope = InicPila(tope);
   tope2 = InicPila(tope2);
   while(!PilaVacia(pila))
   {
      char dato = InfoPila(pila);
      if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-')
      {
         tope = InsertaPila(tope, InfoPila(pila));
      }
      else
      {
         tope2 = InsertaPila(tope2, InfoPila(pila));
      }
      pila = ElimPila(pila);
   }
   Mostrar(tope);
   Mostrar(tope2);
}
