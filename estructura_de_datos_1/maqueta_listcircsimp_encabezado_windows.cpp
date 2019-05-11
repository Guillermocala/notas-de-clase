/*
*Guillermo Cala; 24/ march/ 19; modified: 26/ march/ 19; mod: 01/ april/ 19
*maqueta de listas circulares simples con operaciones basicas
*/
#include "iostream"
using namespace std;
struct Nodo
{
   int info;
   Nodo *sig;
};
Nodo *ptr = NULL, *ptr2 = NULL;
int menu();
Nodo *insertarCabeza(Nodo *ptr, int xinfo);
Nodo *insertarCola(Nodo *ptr, int xinfo);
Nodo *Buscar(Nodo *ptr, int elem);
Nodo *EliminarNodo(Nodo *ptr, int elem);
Nodo *OrdenarDesc(Nodo *ptr);
Nodo *OrdenarAsc(Nodo *ptr);
Nodo *Quizz(Nodo *ptr, Nodo *ptr2);
void Mostrar(Nodo *ptr);
int main(int argc, char const *argv[])
{
   int sw = 1, info, opt;
   do{
      switch(menu())
      {
         case 1:
            system("cls");
            cout << "ingrese que lista va a trabajar: ";
            cin >> opt;
            switch(opt)
            {
            	case 1:
            		cout << "Ingrese el dato: ";
            		cin >> info;
            		ptr = insertarCabeza(ptr, info);
            		break;
            	case 2:
            		cout << "Ingrese el dato: ";
            		cin >> info;
            		ptr2 = insertarCabeza(ptr2, info);
            		break;
            	default:
            		cout << "valor invalido!" << endl;
            		system("pause");
            		break;
			}
            break;
         case 2:
            system("cls");
            cout << "Ingrese el dato: ";
            cin >> info;
            ptr = insertarCola(ptr, info);
            break;
         case 3:
            int llave;
            if(ptr == NULL)
            {
               cout << "lista vacia" << endl;
               cin.ignore();
               cin.get();
            }
            else
            {
               Nodo *q;
               system("cls");
               cout << "Ingrese el elemento a buscar: ";
               cin >> llave;
               q = Buscar(ptr, llave);
               if(q != NULL)
               {
                  cout << "Elemento encontrado" << endl;
                  cin.ignore();
                  cin.get();
               }
               else
               {
                  cout << "Elemento no encontrado" << endl;
                  cin.ignore();
                  cin.get();
               }
            }
            break;
         case 4:
            system("cls");
            int dato;
            if(ptr == NULL)
            {
               cout << "Lista vacia" << endl;
               system("pause");
            }
            else
            {
               cout << "Ingrese el dato a eliminar: ";
               cin >> dato;
               ptr = EliminarNodo(ptr, dato);
            }
            break;
         case 5:
            system("cls");
            /*esta verificacion es para evitar un inifity loop, puede suceder
            cuando se intenta imprimir y la lista esta vacia */
            cout << "ingrese que lista va a trabajar: ";
            cin >> opt;
            switch(opt)
            {
            	case 1:
            		if(ptr == NULL)
            		{
               			cout << "lista vacia" << endl;
               			system("pause");
		            }
        		    else
            		{
               			Mostrar(ptr);
            		}
            		break;
            	case 2:
            		if(ptr2 == NULL)
            		{
               			cout << "lista vacia" << endl;
						 system("pause");
		            }
        		    else
            		{
               			Mostrar(ptr2);
            		}
            		break;
            	default:
            		cout << "valor invalido!" << endl;
            		break;
			}
            break;
         case 6:
            Nodo *p;
            p = ptr;
            if(ptr == NULL)
            {
               cout << "la lista esta vacia" << endl;
               system("pause");
            }
            else if(p->sig == ptr)
            {
               cout << "la lista solo tiene un elemento" << endl;
               system("pause");
            }
            else
            {
               int opt;
               system("cls");
               cout << "1- Ordenar Descendente\n2- Ordenar Ascendente" << endl;
               cout << "Ingrese una opcion: ";
               cin >> opt;
               switch(opt)
               {
                  case 1:
                     ptr = OrdenarDesc(ptr);
                     break;
                  case 2:
                     ptr = OrdenarAsc(ptr);
                     break;
                  default:
                     cout << "Valor invalido!" << endl;
                     cin.get();
                     break;
               }
            }
            cin.ignore();
            break;
         case 7:
            int exit;
            system("cls");
            cout << "\tEsta seguro que desea cerrar el programa?\nPresione 1 para salir, de lo contrario digite cualquier otro numero: ";
            cin >> exit;
            if(exit == 1)
            {
               sw = 0;
            }
            break;
        case 8:
        	system("cls");
        	Quizz(ptr, ptr2);
        	break;
         default:
            cout << "Ha ingresado un valor invalido..." << endl;
            system("pause");
            break;
      }
   }while(sw);
   return 0;
}
int menu()
{
   system("clear");
    printf("\n\t\t0000000000000000000000000000000");
	printf("\n\t\t00  MENU LISTA CIRC SIMPLES 00");
	printf("\n\t\t0000000000000000000000000000000");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  1) INSERTAR CABEZA      00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  2) INSERTAR COLA        00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  3) BUSCAR LLAVE         00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  4) ELIMINAR NODO        00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  5) MOSTRAR LISTA        00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  6) ORDENAR              00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  8) QUIZZ                00");
	printf("\n\t\t00                          00");
	printf("\n\t\t00  7) SALIR                00");
	printf("\n\t\t00                          00");
	printf("\n\t\t000000000000000000000000000000");
	printf("\n\t\t00    ELIJA UNA OPCION      00");
	printf("\n\t\t000000000000000000000000000000");
   int opt;
   cout << "\nIngrese una opcion: ";
   cin >> opt;
   return opt;
}
Nodo *insertarCabeza(Nodo *ptr, int xinfo)
{
   Nodo *p, *r;
   p = new Nodo();
   p->info = xinfo;
   if(ptr == NULL)
   {
      r = new Nodo();
      ptr = r;
      r->sig = p;
      p->sig = r;
   }
   else
   {
      r = ptr;
      p->sig = r->sig;
      r->sig = p;
   }
   return ptr;
}
Nodo *insertarCola(Nodo *ptr, int xinfo)
{
   Nodo *p = new Nodo();
   p->info = xinfo;
   if(ptr == NULL)
   {
      Nodo *r = new Nodo();;
      ptr = r;
      r->sig = p; /*p->sig = ptr;*/
      p->sig = r;
   }
   else
   {
      Nodo *j = ptr->sig;
      while(j->sig != ptr)
      {
         j = j->sig;
      }
      j->sig = p;
      p->sig = ptr;
   }
   return ptr;
}
void Mostrar(Nodo *ptr)
{
   Nodo *r = ptr->sig;
   cout << "PTR -> ";
   while(r != ptr)
   {
      cout << "[" << r->info << "] -> ";
      r = r->sig;
   }
   cout << "NULL ";
   system("pause");
}
Nodo *Buscar(Nodo *ptr, int elem)
{
   Nodo *r = ptr->sig;
   while(r != ptr)
   {
      if(r->info == elem)
      {
         return r;
      }
      else
      {
         r = r->sig;
      }
   }
   return NULL;
}
Nodo *EliminarNodo(Nodo *ptr, int elem)
{
   Nodo *q = Buscar(ptr, elem);
   if(q == NULL)
   {
      cout << "Elemento no encontrado " << endl;
      system("pause");
   }
   else
   {
      if(ptr->sig == q && q->sig == ptr)
      {
         delete(q);
         delete(ptr);
         ptr = NULL;
      }
      else
      {
         /*para eliminar; j siempre debe estar antes de q*/
         Nodo *j = ptr;
         while(j->sig != q)
         {
            j = j->sig;
         }
         j->sig = q->sig;
         delete(q);
      }
      return ptr;
   }
   return ptr;
}
Nodo *OrdenarDesc(Nodo *ptr)
{
   Nodo *p, *q, *aux, *aux2;
   p = ptr->sig;
   while(p != ptr)
   {
      q = ptr->sig;
      while(q != ptr)
      {
         /*para que no se produzca un inifity loop tenemos que dejar a q en
         ptr->ant con q->sig != ptr*/
         if(q->sig != ptr && q->info < q->sig->info)
         {
            aux = q->sig;
            if(q == ptr->sig)
            {
               q->sig = aux->sig;
               aux->sig = q;
               ptr->sig = aux;
            }
            else
            {
               if(aux->sig != ptr)
               {
                  aux2 = ptr->sig;
                  while(aux2->sig != q)
                  {
                     aux2 = aux2->sig;
                  }
                  q->sig = aux->sig;
                  aux->sig = q;
                  aux2->sig = aux;
               }
               else
               {
                  aux2 = ptr->sig;
                  while(aux2->sig != q)
                  {
                     aux2 = aux2->sig;
                  }
                  aux2->sig = aux;
                  q->sig = ptr;
                  aux->sig = q;
               }
            }
            /*en el caso de que rotemos un nodo y este tenga referenciado el bucle de recorrido
            principal, debemos regresar este a su posicion anterior para no afectar el funcionamiento de la funcion*/
            if(q == p)
            {
               p = aux;
            }
         }
         else
         {
            q = q->sig;
         }
      }
      p = p->sig;
   }
   cin.get();
   return ptr;
}
Nodo *OrdenarAsc(Nodo *ptr)
{
   Nodo *p, *q, *aux, *aux2;
   p = ptr->sig;
   while(p != ptr)
   {
      q = ptr->sig;
      while(q != ptr)
      {
         if(q->sig != ptr && q->info > q->sig->info)
         {
            aux = q->sig;
            if(q == ptr->sig)
            {
               q->sig = aux->sig;
               aux->sig = q;
               ptr->sig = aux;
            }
            else
            {
               if(aux->sig != ptr)
               {
                  aux2 = ptr->sig;
                  while(aux2->sig != q)
                  {
                     aux2 = aux2->sig;
                  }
                  q->sig = aux->sig;
                  aux->sig = q;
                  aux2->sig = aux;
               }
               else
               {
                  aux2 = ptr->sig;
                  while(aux2->sig != q)
                  {
                     aux2 = aux2->sig;
                  }
                  aux2->sig = aux;
                  q->sig = ptr;
                  aux->sig = q;
               }
            }
            /*en el caso de que rotemos un nodo y este tenga referenciado el bucle de recorrido
            principal, debemos regresar este a su posicion anterior para no afectar el funcionamiento de la funcion*/
            if(q == p)
            {
               p = aux;
            }
         }
         else
         {
            q = q->sig;
         }
      }
      p = p->sig;
   }
   cin.get();
   return ptr;
}
Nodo *Quizz(Nodo *ptr, Nodo *ptr2)
{
	int num1 = 0, num2 = 0, ward = 0;
	Nodo *p, *j;
	p = ptr->sig;
	j = ptr2->sig;
	while(p!= ptr)
	{
		num1++;
		p = p->sig;
	}
	while(j!= ptr2)
	{
		num2++;
		j = j->sig;
	}
	if(num1 != num2)
	{
		cout << "no son semejantes" << endl;
		system("pause");
	}
	else
	{
		p = ptr->sig;
		j = ptr2->sig;
		while(p!=ptr)
		{
			while(j!=ptr2)
			{
				if(p->info == j->info)
				{
					ward++;
					j=j->sig;
				}
				else{
					j=j->sig;
				}
			}
			j=ptr2->sig;
			p=p->sig;
		}
	}
	if(num1 == ward)
	{
		cout << "listas semejantes" << endl;
		system("pause");
	}
	else
	{
		cout << "listas no semejantes" << endl;
		system("pause");
	}
}
