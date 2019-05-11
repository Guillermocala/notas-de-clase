/*
*Guillermo Cala; 24/ march/ 19; modified: 26/ march/ 19
*maqueta de listas circulares dobles con operaciones basicas
*/
#include "iostream"
using namespace std;
struct Nodo
{
   int info;
   Nodo *sig;
   Nodo *ant;
};
Nodo *ptr = NULL;
int menu();
Nodo *insertarCabeza(Nodo *ptr, int xinfo);
Nodo *insertarCola(Nodo *ptr, int xinfo);
Nodo *Buscar(Nodo *ptr, int elem);
Nodo *EliminarNodo(Nodo *ptr, int elem);
Nodo *OrdenarDesc(Nodo *ptr);
Nodo *OrdenarAsc(Nodo *ptr);
Nodo *Intercambio(Nodo *ptr);
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
            else if(p->sig == ptr && p->ant == ptr)
            {
               cout << "la lista solo tiene un elemento" << endl;
               cin.get();
            }
            else
            {
               int opt;
               system("clear");
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
            int ext;
            system("clear");
            cout << "\tEsta seguro que desea cerrar el programa?\nPresione 1 para salir, de lo contrario digite cualquier otro numero: ";
            cin >> ext;
            if(ext == 1)
            {
               sw = 0;
            }
            break;
         case 8:
            system("clear");
            /*unexpected function*/
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
   printf("\n\t\t\t���������������������������");
	printf("\n\t\t\t�  MENU LISTA CIRC DOBLES �");
	printf("\n\t\t\t���������������������������");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  1) INSERTAR CABEZA     �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  2) INSERTAR COLA       �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  3) BUSCAR LLAVE        �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  4) ELIMINAR NODO       �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  5) MOSTRAR LISTA       �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  6) ORDENAR             �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t�  7) SALIR               �");
	printf("\n\t\t\t�                         �");
	printf("\n\t\t\t���������������������������");
	printf("\n\t\t\t�    ELIJA UNA OPCION     �");
	printf("\n\t\t\t���������������������������");
   int opt;
   cout << "\nIngrese una opcion: ";
   cin >> opt;
   return opt;
}
Nodo *insertarCabeza(Nodo *ptr, int xinfo)
{
   Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
   p->info = xinfo;
   if(ptr == NULL)
   {
      ptr = p;
      p->sig = p; /*p->sig = ptr;*/
      p->ant = p; /*p->ant = ptr;*/
   }
   else
   {
      /*podemos acceder al ultimo nodo directamente con ptr->ant
      sin hacer uso de ciclo alguno*/
      Nodo *j = ptr->ant;
      p->sig = ptr;
      ptr->ant = p;
      j->sig = p;
      p->ant = j;
      ptr = p;
   }
   return ptr;
}
Nodo *insertarCola(Nodo *ptr, int xinfo)
{
   /*lo mismo que insertar por cabeza, pero sin reposicionar ptr*/
   Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
   p->info = xinfo;
   if(ptr == NULL)
   {
      ptr = p;
      p->sig = p; /*p->sig = ptr;*/
      p->ant = p; /*p->ant = ptr;*/
   }
   else
   {
      Nodo *j = ptr->ant;
      p->sig = ptr;
      ptr->ant = p;
      j->sig = p;
      p->ant = j;
   }
   return ptr;
}
void Mostrar(Nodo *ptr)
{
   /*como no se alcanza a imprimir el ultimo se coloca una escritura
   por fuera del ciclo, ya que el apuntador esta posicionado en el nodo.
   dada la flexibilidad de las listas circulares dobles podemos imprimir
   al reves*/
   Nodo *r = ptr;
   int opc;
   cout << "1-Imprimir la lista en orden de las manecillas del reloj\n2-Imprimir la lista en orden contrario a las manecillas del reloj." << endl;
   cout << "Ingrese la opcion: ";
   cin >> opc;
   switch(opc)
   {
      case 1:
         cout << "PTR -> ";
         while(r->sig != ptr)
         {
            cout << "[" << r->info << "] -> ";
            r = r->sig;
         }
         cout << "[" << r->info << "] -> ";
         cout << "NULL ";
         cin.ignore();
         break;
      case 2:
         r = ptr->ant;
         cout << "PTR -> ";
         while(r->ant != ptr->ant)
         {
            cout << "[" << r->info << "] -> ";
            r = r->ant;
         }
         cout << "[" << r->info << "] -> ";
         cout << "NULL ";
         cin.ignore();
         break;
      default:
         cout << "Ha ingresado un valor incorrecto..." << endl;
         break;
   }
}
Nodo *Buscar(Nodo *ptr, int elem)
{
   Nodo *r = ptr;
   while(r->sig != ptr)
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
   /*se verifica de nuevo porque el bucle no toma el ultimo*/
   if(r->info == elem)
   {
      return r;
   }
   else
   {
      return NULL;
   }
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
      if(q == ptr && q->sig == ptr || q->ant == ptr)
      {
         free(q);
         ptr = NULL;
      }
      else
      {
         Nodo *j = q->ant;
         Nodo *k = q->sig;
         k->ant = j;
         j->sig = k;
         if(q == ptr)
         {
            ptr = k;
         }
         free(q);
      }
      return ptr;
   }
   return ptr;
}
Nodo *OrdenarDesc(Nodo *ptr)
{
   Nodo *p, *q, *aux, *aux2;
   p = ptr;
   if(ptr->sig->sig == ptr && ptr->ant->ant == ptr)
   {
      if(ptr->info < ptr->sig->info)
      {
         ptr = ptr->sig; /*ptr->ant = ptr*/
      }
   }
   else
   {
      while(p->sig != ptr)
      {
         q = ptr;
         while(q->sig != ptr)
         {
            if(q->sig != ptr && q->info < q->sig->info)
            {
               /*para los movimientos posicionamos aux2 detras directamente con
               q->ant sin necesidad de bucle alguno*/
               aux = q->sig;
               if(q == ptr)
               {
                  aux2 = ptr->ant;
                  aux->sig->ant = q;
                  q->sig = aux->sig;
                  aux->sig = ptr;
                  ptr->ant = aux;
                  aux2->sig = aux;
                  aux->ant = aux2;
                  ptr = aux;
               }
               else
               {
                  if(aux->sig != ptr)
                  {
                     aux2 = q->ant;
                     aux->sig->ant = q;
                     q->sig = aux->sig;
                     aux->sig = q;
                     q->ant = aux;
                     aux2->sig = aux;
                     aux->ant = aux2;
                  }
                  else
                  {
                     aux2 = q->ant;
                     ptr->ant = q;
                     q->sig = ptr;
                     aux2->sig = aux;
                     aux->ant = aux2;
                     aux->sig = q;
                     q->ant = aux;
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
   }
   cin.get();
   return ptr;
}
Nodo *OrdenarAsc(Nodo *ptr)
{
   Nodo *p, *q, *aux, *aux2;
   p = ptr;
   if(ptr->sig->sig == ptr && ptr->ant->ant == ptr)
   {
      if(ptr->info > ptr->sig->info)
      {
         ptr = ptr->sig; /*ptr->ant = ptr*/
      }
   }
   else
   {
      while(p->sig != ptr)
      {
         q = ptr;
         while(q->sig != ptr)
         {
            if(q->sig != ptr && q->info > q->sig->info)
            {
               /*para los movimientos posicionamos aux2 detras directamente con
               q->ant sin necesidad de bucle alguno*/
               aux = q->sig;
               if(q == ptr)
               {
                  aux2 = ptr->ant;
                  aux->sig->ant = q;
                  q->sig = aux->sig;
                  aux->sig = ptr;
                  ptr->ant = aux;
                  aux2->sig = aux;
                  aux->ant = aux2;
                  ptr = aux;
               }
               else
               {
                  if(aux->sig != ptr)
                  {
                     aux2 = q->ant;
                     aux->sig->ant = q;
                     q->sig = aux->sig;
                     aux->sig = q;
                     q->ant = aux;
                     aux2->sig = aux;
                     aux->ant = aux2;
                  }
                  else
                  {
                     aux2 = q->ant;
                     ptr->ant = q;
                     q->sig = ptr;
                     aux2->sig = aux;
                     aux->ant = aux2;
                     aux->sig = q;
                     q->ant = aux;
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
   }
   cin.get();
   return ptr;
}
