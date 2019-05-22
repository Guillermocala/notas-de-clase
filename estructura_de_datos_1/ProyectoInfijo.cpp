#include "iostream"
#include "cstring"
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <windows.h>

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
void gotoxy(int x,int y);

int main()
{
    system("CLS");

    system ("color 0B");
    cout <<  ("\n\n");
    cout << ("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
    cout << ("\t\t\t²     EVALUADOR DE EXPRESION INFIJA      ²\n");
    cout << ("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
    cout << ("\t\t\t²                                        ²\n");
    cout << ("\t\t\t²  Ingrese La Expresion (SIN ESPACIOS)   ²\n");
    cout << ("\t\t\t²                                        ²\n");
    cout << ("\t\t\t²  Expresion :                           ²\n");
    cout << ("\t\t\t²                                        ²\n");
    cout << ("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
    cout << ("\t\t\t²     SI VA A USAR NUMEROS DE MAS DE     ²\n");
    cout << ("\t\t\t²     UN DIGITO USE LAS VARIBLES(X,Y,Z)  ²\n");
    cout << ("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");

   string data;


   gotoxy(38,8);getline(cin, data);
	Tope = Convertir(data, Tope);
	if(Verificacion(Tope))
	{
    gotoxy(20,15);cout << "\t-------EXPRESION EN NOTACION INFIJA-------" << endl;
	}
	else
	{
		gotoxy(20,15);cout << "\t-------LA EXPRESION NO ESTA NOTACION INFIJA-------" << endl;
	}
	Tope = DestroyStack(Tope);
	Tope = Convertir(data, Tope);
	if(Parentesis(Tope))
	{
		gotoxy(23,16);cout << "\t  -------PARENTESIS CORRECTAMENTE-------" << endl;
	}
	else
	{

		gotoxy(20,23);cout << "\t-------LOS PARENTESIS NO ESTAN EN EL ORDEN-";
		gotoxy(20,24);cout << "\t-------  CORRECTO O NO HAY PARENTESIS------"<< endl<<endl;

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
	int cont = 0, cont2 = 0,Cont3=0,Cont=0,Cont2=0;
	int operadorOtros=0,operador=0,correcto=1,parentesis=0,otros=0;
	bool ver = true, spaces = true;
   tope2 = InicPila(tope2);
   tope3 = InicPila(tope3);
	   while(!PilaVacia(tope) and ver==true)
   		{
     	 char dato = InfoPila(tope);
      		if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
      		{
				tope2 = InsertaPila(tope2, InfoPila(tope));
				cont = 0;
				operador++;

				if(dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
				{
					operadorOtros++;
				}
				if(cont > 1 or operador > 1 and operadorOtros>1)
				{
					ver = false;
				}

				if(dato == '('|| dato == ')' and ver==true)
				{
					parentesis=1;
				}
				else
				{
					if(ver==true)
					{
						otros=1;
					}
				}
			}
			else
			{
				cont++;
				operador=0;
				operadorOtros=0;
				parentesis=0;
				correcto=1;
				otros=0;
        		 tope3 = InsertaPila(tope3, InfoPila(tope));
				if(cont > 1 or operador > 1)
				{
					ver = false;
				}
      		}

      		if(otros==1 and parentesis==0 and ver==true)
		  	{
		  		ver=true;
		  		correcto=0;
		  	}
		  	else
		  	{
		  		if(otros == 1 and parentesis == 1 and correcto==1 and ver==true )
			  	{
			  		//ver =false;
			  	}
			  	else
			  	{
			  		if(otros==1 and parentesis==1 and correcto==0 and ver==true)
				  	{
				  		otros=0;
				  	}
			 	 }
		  	}


		  	if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
     	 	{

				if(dato == '*' || dato == '/' || dato == '+' || dato == '-' ||dato == '^')
				{
					Cont3 = 0;
					Cont = 0;
					Cont2++;
				}
				if(Cont2 > 2)
				{
					ver = false;
				}
				if(dato == '(')
				{
					Cont3++;
				}
     	 	}
			else if(dato == ' ')
			{
				tope2 = InsertaPila(tope2, InfoPila(tope));
				spaces = false;
			}
    		  else
    	  	{
				Cont++;

				if(Cont > 1 || Cont3 > 0)
				{
					ver = false;
				}
				Cont2 = 0;
    	  	}

			tope = ElimPila(tope);
		}

		if(!spaces)
		{

		gotoxy(20,21);cout << "\tERROR: Se ha encontrado un espacio en la expresion..." << endl;
			ver = false;
		}
	while(!PilaVacia(tope))
	{
		char dato = InfoPila(tope);
      	if(dato == '(' || dato == ')' || dato == '*' || dato == '/' || dato == '+' || dato == '-' || dato == '^')
      	{
				tope2 = InsertaPila(tope2, InfoPila(tope));
	  	}
		else
	  	{
	  		tope3 = InsertaPila(tope3, InfoPila(tope));
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
					gotoxy(20,18);cout << "\tPARENTESIS: Hay " << cant1 << " De apertura y " << cant2 << " De cierre" << endl;
					gotoxy(20,19);cout << "\tERROR: Falta " << cant2 - cant1 << " De apertura" << endl;
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
			gotoxy(20,19);cout << "\tERROR: falta " << cant1 - cant2 <<"  Parentesis de cierre "<< endl;
			return false;
		}
		return true;
	}
}

 void gotoxy(int x,int y){
      HANDLE hcon;
      hcon = GetStdHandle(STD_OUTPUT_HANDLE);
      COORD dwPos;
      dwPos.X = x;
      dwPos.Y= y;
      SetConsoleCursorPosition(hcon,dwPos);
}
