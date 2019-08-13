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
      p->info = xinfo;
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
   void  Mostrar(nodoa *ptr)
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
            if(q->sig==NULL)
      {
      ptr=NULL;
      free(q);
      }else{
      ptr=q->sig;
      ptr->ant=NULL;
      free(q);
      }
      }else{
      if(q->sig==NULL)
      {
      k=q->ant;
      k->sig=NULL;
      free(q);
      }else{
      k=q->ant;
      l=q->sig;
      l->ant=k;
      free(q);
      }
      }
      return ptr;
      }
   }
}
