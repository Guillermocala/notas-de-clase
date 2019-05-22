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

int main()
{
   string data;
	system("cls");
   cout << "\t\tEVALUADOR DE EXPRESION INFIJA" << endl;
   cout << "Si va a usar numeros de mas de un digito use variables(x, y, z)" << endl;
	cout << "Ingrese la expresion(SIN ESPACIOS): ";
   getline(cin, data);
	Tope = Convertir(data, Tope);
	if(Verificacion(Tope))
	{
		cout << "\tEXPRESION EN NOTACION INFIJA" << endl;
	}
	else
	{
		cout << "\tEXPRESION NO ESTA NOTACION INFIJA" << endl;
	}
//	Tope = DestroyStack(Tope);
	Tope = InicPila(Tope);
	Tope = Convertir(data, Tope);
	if(Parentesis(Tope))
	{
		cout << "\tPARENTESIS CORRECTAMENTE" << endl;
	}
	else
	{
		cout << "\tPARENTESIS NO CORRECTAMENTE O SIN PARENTESIS" << endl;
	}
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
	int cont = 0, cont2 = 0, cont3 = 0;
	bool ver = true, spaces = true;
   tope2 = InicPila(tope2);
   tope3 = InicPila(tope3);
   while(!PilaVacia(tope))
   {
      char dato = InfoPila(tope);
      if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
      {
			tope2 = InsertaPila(tope2, InfoPila(tope));
			if(dato == '*' || dato == '/' || dato == '+' || dato == '-' ||
			dato == '^')
			{
				cont3 = 0;
				cont = 0;
				cont2++;
			}
			else if(dato == '(')
			{
				cont3++;
			}
			if(cont2 > 2)
			{
				ver = false;
			}
      }
		else if(dato == ' ')
		{
			tope2 = InsertaPila(tope2, InfoPila(tope));
			spaces = false;
		}
      else
      {
			cont++;
         tope3 = InsertaPila(tope3, InfoPila(tope));
			if(cont > 1 || cont3 > 0)
			{
				ver = false;
			}
			cont2 = 0;
      }
		tope = ElimPila(tope);
   }
	if(!spaces)
	{
		cout << "\tERROR: Se ha encontrado un espacio en la expresion..." << endl;
		ver = false;
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
	while(!PilaVacia(tope))
	{
		dato = InfoPila(tope);
      //si evaluamos con != no funciona y pasa todo a tope3
		if(dato == '(' || dato == ')')
		{
			if(dato == '(')
			{
				cant1++;
			}
			else
			{
				cant2++;
			}
			tope2 = InsertaPila(tope2, InfoPila(tope));
		}
		tope = ElimPila(tope);
	}
   //si no hay parentesis
	if(PilaVacia(tope2))
	{
		return false;
	}
	else
	{
		while(!PilaVacia(tope2))
		{
			dato = InfoPila(tope2);
         /*como quedan en orden inverso preguntamos por el contrario*/
			if(dato == '(')
			{
				tope3 = InsertaPila(tope3, dato);
			}
			else
			{
				if(PilaVacia(tope3))
				{
					cout << "\tPARENTESIS: Hay " << cant1 << " De apertura y " << cant2 << " De cierre" << endl;
					cout << "\tERROR: Falta " << cant2 - cant1 << " De apertura" << endl;
 					return false;
				}
				else
				{
					tope3 = ElimPila(tope3);
				}
			}
			tope2 = ElimPila(tope2);
		}
		if(!PilaVacia(tope3))
		{
			cout << "\tERROR: falta " << cant1 - cant2 <<" De cierre "<< endl;
			return false;
		}
		return true;
	}
}
