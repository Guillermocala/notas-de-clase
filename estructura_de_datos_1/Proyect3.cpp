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
int NumElem(lista *tope);
lista *InicPila(lista *tope);
bool Verificacion(lista *tope);
bool Parentesis(lista *tope);
lista *Convertir(string dato, lista *tope);
lista *DestroyStack(lista * tope);

int main(int argc, char const *argv[])
{
   string data;
   cout << "\t\tCALCULADORA INFIJA" << endl;
   cout << "Si va a usar numeros de mas de un digito use variables\nIngrese la expresion: ";
   getline(cin, data);
	Tope = Convertir(data, Tope);
	if(Verificacion(Tope))
	{
		cout << "Esta en infija" << endl;
		Tope = DestroyStack(Tope);
		Tope = Convertir(data, Tope);
		if(Parentesis(Tope))
		{
			cout << "Parentesis correctamente" << endl;
		}
		else
		{
			cout << "Parentesis no correctamente" << endl;
		}
	}
	else
	{
		cout << "no esta en infija" << endl;
	}
	cout << data << endl;
	cin.ignore();
	cin.get();
   return 0;
}
lista *Convertir(string dato, lista *tope)
{
	int limit;
	char lista1[50];
	strcpy(lista1, dato.c_str());
   limit = strlen(lista1);
	for(int i = 0; i < limit; i++)
	{
		tope = InsertaPila(tope, lista1[i]);
	}
	return tope;
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
		//printf("\n Registro Eliminado con Exito\n");
		return tope;
	}
	else
	{
		printf("\n La Pila esta Vacia....\n");
	}
	cin.ignore();
	cin.get(); /* completar con el algoritmo de insertar cabeza */
}
lista *DestroyStack(lista * tope)
{
	while(!PilaVacia(tope))
	{
		tope = ElimPila(tope);
	}
	return tope;
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
int NumElem(lista *tope)
{
	int cont = 0;
	lista *tope2;
	tope2 = InicPila(tope2);
	while(!PilaVacia(tope))
	{
		cont++;
		tope2 = InsertaPila(tope2, InfoPila(tope));
		tope = ElimPila(tope);
	}
	while(!PilaVacia(tope2))
	{
		tope = InsertaPila(tope, InfoPila(tope2));
		tope2 = ElimPila(tope2);
	}
	return cont;
}
bool Verificacion(lista *tope)
{
   lista *tope2, *tope3;
	int cont = 0, cont2 = 0;
	bool ver = true;
   tope2 = InicPila(tope2);
   tope3 = InicPila(tope3);
   while(!PilaVacia(tope))
   {
      char dato = InfoPila(tope);
      if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
      {
			tope2 = InsertaPila(tope2, InfoPila(tope));
			cont = 0;
      }
      else
      {
			cont++;
         tope3 = InsertaPila(tope3, InfoPila(tope));
			if(cont > 1)
			{
				ver = false;
			}
      }
		tope = ElimPila(tope);
   }
	return ver;
}
bool Parentesis(lista *tope)
{
	int cant1 = 0, cant2 = 0;
	lista *tope2, *tope3, *tope4;
	char dato;
	tope2 = InicPila(tope2);
	tope3 = InicPila(tope3);
	tope4 = InicPila(tope4);
	while(!PilaVacia(tope))
	{
		dato = InfoPila(tope);
      /*si evaluamos con != no funciona y pasa todo a tope3*/
		if(dato == '(' || dato == ')')
		{
			cant1++;
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
		cant2 = cant1;
		while(!PilaVacia(tope3))
		{
			dato = InfoPila(tope3);
         /*como quedan en orden inverso preguntamos por el contrario*/
			if(dato == '(')
			{
				tope4 = InsertaPila(tope4, dato);
				cant2++;
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
					cant2--;
				}
			}
			tope3 = ElimPila(tope3);
			cant1--;
		}
		if(!PilaVacia(tope3))
		{
			cout << "ERROR: falta " << cant1  <<" '(' "<< endl;
		}
		if(!PilaVacia(tope4))
		{
			cout << "ERROR: falta " << cant2  <<" ')' "<< endl;
			return false;
		}
		return true;
	}
}
