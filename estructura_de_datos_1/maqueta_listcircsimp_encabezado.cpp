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
Nodo *ptr = NULL;
int menu();
Nodo *insertarCabeza(Nodo *ptr, int xinfo);
Nodo *insertarCola(Nodo *ptr, int xinfo);
Nodo *Buscar(Nodo *ptr, int elem);
Nodo *EliminarNodo(Nodo *ptr, int elem);
Nodo *OrdenarDesc(Nodo *ptr);
Nodo *OrdenarAsc(Nodo *ptr);
Nodo *InserOcurrencia(Nodo *ptr);
void Mostrar(Nodo *ptr);
int main(int argc, char const *argv[])
{
   int sw = 1, info;
   do{
      switch(menu())
      {
         case 1:
            system("clear");
            cout << "Ingrese el dato: ";
            cin >> info;
            ptr = insertarCabeza(ptr, info);
            break;
         case 2:
            system("clear");
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
               system("clear");
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
            system("clear");
            int dato;
            if(ptr == NULL)
            {
               cout << "Lista vacia" << endl;
               cin.ignore();
               cin.get();
            }
            else
            {
               cout << "Ingrese el dato a eliminar: ";
               cin >> dato;
               ptr = EliminarNodo(ptr, dato);
            }
            break;
         case 5:
            system("clear");
            /*esta verificacion es para evitar un inifity loop, puede suceder
            cuando se intenta imprimir y la lista esta vacia */
            if(ptr == NULL)
            {
               cout << "lista vacia" << endl;
               cin.ignore();
               cin.get();
            }
            else
            {
               Mostrar(ptr);
               cin.get();
            }
            break;
         case 6:
            Nodo *p;
            p = ptr;
            if(ptr == NULL)
            {
               cout << "la lista esta vacia" << endl;
               cin.get();
            }
            else if(p->sig == ptr)
            {
               cout << "la lista solo tiene un elemento" << endl;
               cin.get();
            }
            else
            {
               int opt;
               system("clear");
               if(ptr == NULL)
               {
                  cout << "Lista vacia" <<endl;
               }
               else
               {
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
            }
            cin.ignore();
            break;
         case 7:
            int exit;
            system("clear");
            cout << "\tEsta seguro que desea cerrar el programa?\nPresione 1 para salir, de lo contrario digite cualquier otro numero: ";
            cin >> exit;
            if(exit == 1)
            {
               sw = 0;
            }
            break;
         case 8:
            system("clear");
            InserOcurrencia(ptr);
            break;
         default:
            cout << "Ha ingresado un valor invalido..." << endl;
            cin.ignore();
            cin.get();
            break;
      }
   }while(sw);
   return 0;
}
int menu()
{
   system("clear");
   printf("\n\t\t\t����������������������������");
	printf("\n\t\t\t�  MENU LISTA CIRC SIMPLES �");
	printf("\n\t\t\t����������������������������");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  1) INSERTAR CABEZA      �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  2) INSERTAR COLA        �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  3) BUSCAR LLAVE         �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  4) ELIMINAR NODO        �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  5) MOSTRAR LISTA        �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  6) ORDENAR              �");
	printf("\n\t\t\t�                          �");
	printf("\n\t\t\t�  7) SALIR                �");
	printf("\n\t\t\t�                          �");
   printf("\n\t\t\t�  8- EJERCICIO            �");
   printf("\n\t\t\t�                          �");
	printf("\n\t\t\t����������������������������");
	printf("\n\t\t\t�    ELIJA UNA OPCION      �");
	printf("\n\t\t\t����������������������������");
   int opt;
   cout << "\nIngrese una opcion: ";
   cin >> opt;
   return opt;
}
Nodo *insertarCabeza(Nodo *ptr, int xinfo)
{
   Nodo *p, *r;
   p = (struct Nodo*) malloc (sizeof(Nodo));
   p->info = xinfo;
   if(ptr == NULL)
   {
      r = (struct Nodo*) malloc (sizeof(Nodo));
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
   Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
   p->info = xinfo;
   if(ptr == NULL)
   {
      Nodo *r = (struct Nodo*) malloc (sizeof(Nodo));
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
   cin.ignore();
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
      cin.ignore();
      cin.get();
   }
   else
   {
      if(ptr->sig == q && q->sig == ptr)
      {
         free(q);
         free(ptr);
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
         free(q);
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
Nodo *InserOcurrencia(Nodo *ptr)
{
   int cont, info, ocu, info2;
   Nodo *aux, *aux2;
   Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
   aux = ptr->sig;
   while(aux != ptr)
   {
      info = aux->info;
      aux2 = ptr->sig;
      cont = 0;
      while(aux2 != ptr)
      {
         if(info == aux2->info)
         {
            cont++;
         }
         aux2 = aux2->sig;
      }
      if(cont > 1)
      {
         cout << "el elemento repetido es: " << info << " repetido " << cont << " veces."<< endl;
         break;
      }
      aux = aux->sig;
   }
   cout << "Despues de que ocurrencia desea ingresar el dato?: ";
   cin >> ocu;
   if(ocu == 1)
   {
      cout << "Ingrese el dato del nodo: ";
      cin >> info2;
      p->info = info2;
      p->sig = aux->sig;
      aux->sig = p;
   }
   else if(ocu >= 2 && ocu <= cont)
   {
      cout << "Ingrese el dato del nodo: ";
      cin >> info2;
      p->info = info2;
      while(ocu <= cont)
      {
         aux = aux->sig;
         while(aux->info != info)
         {
            aux = aux->sig;
         }
         ocu++;
      }
      p->sig = aux->sig;
      aux->sig = p;
   }
   else
   {
      cout << "Ha ingresado un numero incorrecto" << endl;
      cin.ignore();
      cin.get();
   }
}
