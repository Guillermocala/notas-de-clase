#include "iostream"
#include "conio.h"
using namespace std;

namespace TAD_List_Simp
{
   struct nodoa
   {
      int info;
      nodoa *sig;
   };
   nodoa *ptr = NULL, *ptr1 = NULL, *ptr2 = NULL, *p, *q, *r;
   nodoa *InsertaCabeza(nodoa *ptr, int xinfo)
   {
      p = (struct nodoa *) malloc (sizeof (nodoa));
      p->info = xinfo;
      if(ptr == NULL)
      {
         ptr = p;
         p->sig = NULL;
      }
      else
      {
         p->sig = ptr;
         ptr = p;
      }
      return ptr;
   }
   nodoa *InsertaCola(nodoa *ptr, int xinfo)
   {
      p = (struct nodoa *) malloc (sizeof (nodoa));
      p->info = xinfo;
      if(ptr == NULL)
      {
         ptr = p;
         ptr->sig = NULL;
      }
      else
      {
         /*siempre usamos un aux y lo posicionamos antes de, para realizar el nexo*/
         q = ptr;
         while(q->sig != NULL)
         {
            q = q->sig;
         }
         p->sig = NULL;
         q->sig = p;
      }
      return ptr;
   }
   /*esta funcion se puede definir como booleana haciendo los sgtes cambios*/
   nodoa *Buscarllave(nodoa *ptr, int elem)
   {
      p = ptr;
      while(p != NULL)
      {
         if(p->info == elem)
         {
            return p; /*retornamos true*/
         }
         else
         {
            p = p->sig;
         }
      }
      p = NULL; /*esta linea esta de mas, y retornariamos false en vez de p*/
      return p;
   }
   nodoa *Eliminacion(nodoa *ptr, int elem)
   {
      q = Buscarllave(ptr, elem); /*verificamos que el elemento exista*/
      if(q == NULL)
      {
         cout << "No se puede eliminar el elemento" << endl;
      }
      else
      {
         if(q == ptr)
         {
            ptr = ptr->sig;
            free(q);
         }
         else
         {
            /*necesitamos un aux antes y para esto solo usamos un bucle*/
            r = ptr;
            while(r->sig != q)
            {
               r = r->sig;
            }
            r->sig = q->sig;
            free(q);
         }
      }
      return ptr;
   }
   void Mostrar(nodoa *ptr)
   {
      system("CLS");
      p = ptr;
      cout << "PTR -> ";
      while(p != NULL)
      {
         cout << "[" << p->info << "] -> ";
         p = p->sig;
      }
      cout << "NULL ";
      getch();
   }
}
namespace TAD_List_Doble
{
   struct nodoa
   {
      int info;
      nodoa *ant;
      nodoa *sig;
   };
   nodoa *ptr = NULL, *ptr1 = NULL, *ptr2 = NULL, *r,*p,*k,*h, *j;
   nodoa *InsertaCabeza(nodoa *ptr, int elem)
   {
      p = (struct nodoa *) malloc (sizeof (nodoa));
      p->info = elem;
      if(ptr == NULL)
      {
         ptr = p;
         p->ant = NULL;
         p->sig = NULL;
      }
      else
      {
         p->ant = NULL;
         p->sig = ptr;
         ptr->ant = NULL;
         ptr = p;
      }
      return ptr;
   }
   nodoa *InsertaCola(nodoa *ptr, int elem)
   {
      p = (struct nodoa *) malloc (sizeof (nodoa));
      p->info = elem;
      if(ptr == NULL)
      {
         ptr = p;
         p->ant = NULL;
         ptr->sig = NULL;
      }
      else
      {
         j = ptr;
         while(j->sig!=NULL)
         {
            j=j->sig;
         }
         p->sig = NULL;
         j->sig = p;
         p->ant = j;
      }
      return ptr;
   }
   void Mostrar(nodoa *ptr)
   {
      system ("CLS");
      r = ptr;
      cout << "PTR->";
      while(r != NULL)
      {
         cout << r->info << " - ";
         r = r->sig;
      }
      cout << "NULL" << endl;
      getch();
   }
   nodoa *Buscarllave(nodoa *ptr, int elem)
   {
      r = ptr;
      while(r != NULL)
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
      r = NULL;
      return r;
   }
   nodoa *Eliminacion(nodoa *ptr, int elem)
   {
      nodoa *q, *k, *l;
      q = Buscarllave(ptr, elem);
      if(q == NULL)
      {
         cout << "No se puede eliminar el elemento" << endl;
      }
      else
      {
         if(q == ptr)
         {
            if(q->sig == NULL)
            {
               ptr = NULL;
               free(q);
            }
            else
            {
               ptr = q->sig;
               ptr->ant = NULL;
               free(q);
            }
         }
         else
         {
            if(q->sig == NULL)
            {
               k = q->ant;
               k->sig = NULL;
               free(q);
            }
            else
            {
               k = q->ant;
               l = q->sig;
               l->ant = k;
               free(q);
            }
         }
      }
      return ptr;
   }
}
namespace TAD_List_Circ_Simp
{
   struct Nodo
   {
      int info;
      Nodo *sig;
   };
   Nodo *ptr = NULL, *ptr2 = NULL, *ptr3 = NULL;
   Nodo *InsertaCabeza(Nodo *ptr, int xinfo)
   {
      Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
      p->info = xinfo;
      if(ptr == NULL)
      {
         ptr = p;
         p->sig = p; /*p->sig = ptr;*/
      }
      else
      {
         Nodo *j = ptr;
         while(j->sig != ptr)
         {
            j = j->sig;
         }
         p->sig = ptr;
         j->sig = p;
         /*si insertamos por cola ignoramos la sgte linea. ya que se
         inserta en el mismo lado, pero no se reubica ptr.*/
         ptr = p;
      }
      return ptr;
   }
   Nodo *InsertaCola(Nodo *ptr, int xinfo)
   {
      /*lo mismo que Insertar por cabeza, pero sin reposicionar ptr*/
      Nodo *p = (struct Nodo*) malloc (sizeof(Nodo));
      p->info = xinfo;
      if(ptr == NULL)
      {
         ptr = p;
         p->sig = p; /*p->sig = ptr;*/
      }
      else
      {
         Nodo *j = ptr;
         while(j->sig != ptr)
         {
            j = j->sig;
         }
         p->sig = ptr;
         j->sig = p;
      }
      return ptr;
   }
   void Mostrar(Nodo *ptr)
   {
      Nodo *r = ptr;
      cout << "PTR -> ";
      while(r->sig != ptr)
      {
         cout << "[" << r->info << "] -> ";
         r = r->sig;
      }
      /*como no se alcanza a imprimir el ultimo se coloca una escritura
      por fuera del ciclo, ya que el apuntador esta posicionado en el nodo*/
      cout << "[" << r->info << "] -> ";
      cout << "NULL ";
      cin.ignore();
   }
   Nodo *Buscarllave(Nodo *ptr, int elem)
   {
      Nodo *r = ptr;
      /*esta verificacion de lista vacia es para usar la funcion
      por fuera de una verificacion externa*/
      if(r == NULL)
      {
         return NULL;
      }
      else
      {
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
   }
   Nodo *Eliminacio(Nodo *ptr, int elem)
   {
      Nodo *q = Buscarllave(ptr, elem);
      if(q == NULL)
      {
         cout << "Elemento no encontrado " << endl;
         cin.ignore();
         cin.get();
      }
      else
      {
         if(q == ptr && q->sig == ptr)
         {
            free(q);
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
            if(q == ptr)
            {
               ptr = q->sig;
            }
            free(q);
         }
         return ptr;
      }
      return ptr;
   }
}
namespace TAD_List_Circ_Doble
{
   struct Nodo
   {
      int info;
      Nodo *sig;
      Nodo *ant;
   };
   Nodo *ptr = NULL, *ptr1 = NULL, *ptr2 = NULL;
   Nodo *InsertaCabeza(Nodo *ptr, int xinfo)
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
   Nodo *InsertaCola(Nodo *ptr, int xinfo)
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
   Nodo *Buscarllave(Nodo *ptr, int elem)
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
   Nodo *Eliminacion(Nodo *ptr, int elem)
   {
      Nodo *q = Buscarllave(ptr, elem);
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
}
