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
bool Verificacion(lista *tope);

int main(int argc, char const *argv[])
{
   int limit;
   char list1[50];
   string data;
   cout << "\t\tCALCULADORA INFIJA" << endl;
   cout << "Si va a usar numeros de mas de un digito use variables\nIngrese la expresion: ";
   getline(cin, data);
   strcpy(list1, data.c_str());
   limit = strlen(list1);
	for(int i = 0; i < limit; i++)
	{
		Tope = InsertaPila(Tope, list1[i]);
	}
	if(Verificacion(Tope))
	{
		cout << "Esta en infija" << endl;
	}
	else
	{
		cout << "nanai infija" << endl;
	}
	cin.ignore();
	cin.get();
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
bool Verificacion(lista *tope)
{
   lista *tope2, *tope3, *tope4;
	int cont = 0, cont2 = 0;
	bool ver = true;
   tope2 = InicPila(tope2);
   tope3 = InicPila(tope3);
	tope4 = InicPila(tope4);
   while(!PilaVacia(tope))
   {
      char dato = InfoPila(tope);
      if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
      {
         tope2 = InsertaPila(tope2, InfoPila(tope));
			if(dato == ')')
			{
				cont2++;
			}
			else
			{
				cout << 10 << endl;
				cont2 = 0;
			}
			cont = 0;
      }
      else
      {
			cont++;
         tope3 = InsertaPila(tope3, InfoPila(tope));
			if(cont > 0 || cont2 > 0)
			{
				ver = false;
			}
      }
		tope4 = InsertaPila(tope4, InfoPila(tope));
		tope = ElimPila(tope);
   }
	Mostrar(tope2);
	Mostrar(tope3);
	return ver;
}
