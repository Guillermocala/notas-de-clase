#include <stdlib.h>
#include <iostream>
#include <string.h>
using namespace std;
struct nodoa
{
     int info;
     nodoa *sig;
};
nodoa *ptr=NULL, *r,*p,*k,*h, *j;
nodoa* InsertaCabeza(nodoa *p,int xinfo);
nodoa* InsertaCola(nodoa *p,int xinfo);
nodoa* Buscarllave( nodoa *p, int elem);
nodoa* Eliminacion(nodoa *p,int elem);
nodoa* Elimrep(nodoa *p, int elem);
nodoa* Rotar(nodoa *p, int n);
nodoa* ascendente(nodoa *p, int elem);
void Mostrar(nodoa *p);
int menu (void);

int main(int argc, char*argv[])
{
   system ("clear");
   int sw=1, i, j, x, q;
   long opcion;
   do
   {
      switch (menu())
      {
         case 1:
            system ("clear");
            printf ("Ingrese La Informacion: ");
            scanf ("%d", &i);
            ptr=InsertaCabeza(ptr,i);
            break;
         case 2:
            system ("clear");
            printf ("Ingrese La Informacion: ");
            scanf ("%d", &i);
            ptr=InsertaCola(ptr,i);
            break;
         case 3:
            system ("clear");
            if(ptr==NULL)
            {
               printf("La lista se encuentra vacia, por favor llenarla");
               cin.get();
            }
            else
            {
               printf("Ingrese el dato a Buscar: ");
               scanf("%d", &i);
               nodoa *q;
               q=Buscarllave(ptr, i);
               if(q!=NULL)
               {
                  printf("\n\n Se encontro el elemento");
               }
               else
               {
                  printf("\n\n No se encontro el elemento");
               }
            }
            cin.get();
            break;
         case 4:
            system("clear");
            if(ptr==NULL)
            {
               printf("La lista se encuentra vacia, por favor llenarla");
            }
            else
            {
               printf("Ingrese el dato a eliminar: ");
               scanf("%d", &i);
               ptr=Eliminacion(ptr, i);
            }
            break;
         case 5:
            system("clear");
            Mostrar(ptr);
            cin.get();
            break;
         case 6:
            system("clear");
            if(ptr==NULL)
            {
               printf("La lista se encuentra vacia, por favor llenarla");
            }
            else
            {
               printf("Ingrese el dato a eliminar: ");
               scanf("%d", &i);
               ptr=Elimrep(ptr, i);
            }
            cin.get();
            break;
         case 7:
            system("clear");
            printf("Ingrese la cantidad a rotar: ");
            scanf("%d", &i);
            ptr = Rotar(ptr, i);
            cin.get();
            break;
         case 8:
            system("clear");
            printf("Ingrese el dato: ");
            scanf("%d", &i);
            ptr = ascendente(ptr, i);
            cin.get();
            break;
         case 0:
            system ("clear");
            printf ("Press any key to exit...");
            sw=0;
            break;
         default:
            system ("clear");
            printf("opcion no valida...por favor intente nuevamente\n");
            break;
      }
   }
   while(sw);
   cin.get();
}
int menu(void)
{
   int opcion;
   system("clear");
   system ("color 0B");
   printf ("\n\n");
   printf("\t\t\t����������������������������������\n");
   printf("\t\t\t�     ESTRUCTURA DE DATOS        �\n");
   printf("\t\t\t����������������������������������\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 1  ->  Insertar Nodos cabeza   �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 2  ->  Insertar Nodos Cola     �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 3  ->  Consulta                �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 4  ->  Eliminacion             �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 5  ->  Mostrar Lista           �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 6  ->  Elim. repetidos         �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 7  ->  Rotar nodos             �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 8  ->  Insertar ascendente     �\n");
   printf("\t\t\t�                                �\n");
   printf("\t\t\t� 0  ->  Salir                   �\n");
   printf("\t\t\t����������������������������������\n");
   printf("\t\t\t�    Elija una opcion...         �\n");
   printf("\t\t\t����������������������������������\n");
   int sw=1;
   do
   {
      opcion=cin.get();
      if(opcion>=48 && opcion <=57)
      {
         sw=0;
      }
      else
      {
         printf("\n se debe ingresar un entero entre 1-9\n");
      }
   }
   while(sw);
   opcion=opcion-48;
   return opcion;
}
nodoa* InsertaCabeza (nodoa *ptr,int xinfo)
{
   p= (struct nodoa *) malloc (sizeof (nodoa));
   p->info = xinfo;
   if(ptr==NULL)
   {
      ptr=p;
      p->sig=NULL;
   }
   else
   {
      p->sig=ptr;
      ptr=p;
   }
   return ptr;
}

nodoa* InsertaCola (nodoa *ptr,int xinfo)
{
   p= (struct nodoa *) malloc (sizeof (nodoa));
   p->info = xinfo;
   if(ptr==NULL)
   {
      ptr=p;
      p->sig=NULL;
   }
   else
   {
      j=ptr;
      while(j->sig!=NULL)
      {
         j=j->sig;
      }
      j->sig=p;
      p->sig=NULL;
   }
   return ptr;
}
void  Mostrar (nodoa *ptr)
{
   system ("clear");
   r=ptr;
   printf("PTR");
   while(r!=NULL)
   {
      printf("[%d]->", r->info);
      r=r->sig;
   }
   printf("NULL");
   cin.get();
}

nodoa* Buscarllave(nodoa *ptr,int elem)
{
   nodoa *k;
   k=ptr;
   while(k!=NULL)
   {
      if(k->info==elem)
      {
         return k;
      }
      else
      {
         k=k->sig;
      }
   }
   k=NULL;
   return k;
}

nodoa* Eliminacion (nodoa *ptr,int elem)
{
   j= Buscarllave(ptr, elem);
   if(j==NULL)
   {
      printf("El elemento no se encuentra en la lista, intentalo de nuevo");
   }
   else if(j==ptr)
   {
      ptr=j->sig;
      free(j);
   }
   else
   {
      r=ptr;
      while(r->sig!=j)
      {
         r=r->sig;
      }
      r->sig=j->sig;
      free(j);
   }
   return (ptr);
}

nodoa* Elimrep(nodoa *ptr, int elem)
{
   r=ptr;
   int c=0;
   while(r!=NULL)
   {
      if(r->info!=elem)
      {
         r=r->sig;
      }
      else if(r==ptr)
      {
         ptr=r->sig;
         free(r);
         c++;
         r=ptr;
      }
      else
      {
         nodoa *j=ptr;
         j=ptr;
         while(j->sig!=r)
         {
            j=j->sig;
         }
         j->sig=r->sig;
         free(r);
         c++;
         r=j;
      }
   }
   printf("El dato se elimino: %d veces", c);
   return ptr;
}

nodoa* Rotar(nodoa *ptr, int n)
{
   printf("Nodos Originales: \n");
   Mostrar(ptr);
   for(int i=1; i<=n; i++)
   {
      j=ptr;
      while(j->sig!=NULL)
      {
         j=j->sig;
      }
      j->sig=ptr;
      ptr=ptr->sig;
      j=j->sig;
      j->sig=NULL;
   }
   return ptr;
}
nodoa* ascendente(nodoa *p, int elem)
{
   p = (struct nodoa *) malloc (sizeof (nodoa));
   p->info = elem;
   if(ptr == NULL)
   {
      ptr = p;
      p->sig = NULL;
   }
   else
   {
      if(elem < ptr->info)
      {
         p->sig = ptr;
         ptr = p;
      }
      else
      {
         int	sw = 0;
         r = ptr;
         while(r != NULL && sw == 0)
         {
            if(elem <= r->info)
            {
               sw = 1;
            }
            else
            {
               r = r->sig;
            }
         }
         if(sw == 0)
         {
            j = ptr;
            while(j->sig != NULL)
            {
               j = j->sig;
            }
            j->sig = p;
            p->sig = NULL;
            j = ptr;
            while(j->sig != r)
            {
               j = j->sig;
            }
            j->sig = p;
            p->sig = r;
         }
      }
   }
   return ptr;
};
