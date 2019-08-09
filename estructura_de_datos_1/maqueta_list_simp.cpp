#include "iostream"
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
using namespace std;
struct nodoa
{
   int info;
   nodoa *sig;
};

nodoa *ptr = NULL, *ptr1 = NULL, *r, *p, *k, *h, *j;

nodoa *InsertaCabeza(nodoa *p, int xinfo);
nodoa *InsertaCola(nodoa *p, int xinfo);
nodoa *Buscarllave( nodoa *p, int elem);
nodoa *Eliminacion(nodoa *p, int elem);
void Mostrar(nodoa *p);
void MenorMayorElem(nodoa *&ptr, nodoa *&ptr1, int elem);
int menu(void);

int main()
{
   system("cls");
   int sw = 1, i, j, x;
   long opcion;
   do{
      switch(menu())
      {
         case 1:
            system("CLS");
            cout << "Que lista recibira datos?: ";
            cin >> i;
            if(i == 1)
            {
               cout << "Ingrese el dato: ";
               cin >> j;
               ptr = InsertaCabeza(ptr, j);
            }
            else
            {
               cout << "Ingrese el dato: ";
               cin >> j;
               ptr1 = InsertaCabeza(ptr1, j);
            }
            break;
         case 2:
            system("CLS");
            printf("Ingrese La Informacion: ");
            scanf("%d", &i);
            ptr = InsertaCola(ptr,i);
            break;
         case 3:
            system("CLS");
            Mostrar(ptr);
            Mostrar(ptr1);
            break;
         case 4:
            system("cls");
            if(ptr == NULL)
            {
               printf("la lista esta vacia");
               getch();
            }
            else
            {
               printf("Ingrese Dato a buscar: ");
               scanf("%d", &i);
               nodoa *q;
               q = Buscarllave(ptr, i);
               if(q != NULL)
               {
                  printf("Se encontro el Elemento");
               }
               else
               {
                  printf("No se encontro el Elemento");
               }
               getch();
            }
            break;
         case 5:
            system("cls");
            if(ptr == NULL)
            {
               printf("La lista esta vacia");
               getch();
            }
            else
            {
               printf("ingrese el Dato a Eliminar: ");
               scanf("%d", &i);
               ptr = Eliminacion(ptr,i);
            }
            break;
         case 6:
         	system("cls");
         	if(ptr == NULL || ptr1 == NULL)
         	{
         		printf("Lista 1 o lista 2 vacia");
         	}
         	else
         	{
         		cout << "Ingrese el dato: ";
               cin >> i;
               MenorMayorElem(ptr, ptr1, i);
         	}
         	getch();
         	break;
         case 0:
            system("CLS");
            printf("Press any key to exit...");
            sw = 0;
            break;
         default:
            system("CLS");
            printf("opcion no valida... por favor intente nuevamente\n");
            break;
      }
   }while(sw);
   getch();
}
int menu()
{
   int opcion;
   system("CLS");
   printf ("\n\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#       MENU  LISTA SIMPLE       #\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 1  ->  Insertar Nodos cabeza   #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 2  ->  Insertar Nodos Cola     #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 3  ->  Mostrar lista           #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 4  ->  Buscar                  #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 5  ->  Eliminar                #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 6  ->  Taller                  #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t#                                #\n");
   printf("\t\t\t# 0  ->  Salir                   #\n");
   printf("\t\t\t##################################\n");
   printf("\t\t\t#    Elija una opcion...         #\n");
   printf("\t\t\t##################################\n");
   int sw = 1;
   /*se valida mediante el codigo ASCII de el caracter ingresado*/
   do{
      opcion = getch();
      if(opcion >= 48 && opcion <= 57)
      {
         sw = 0;
      }
      else
      printf("\n se debe ingresar un entero entre 1-9\n");
   }while(sw);
   opcion = opcion-48;
   return opcion;
}
nodoa *InsertaCabeza (nodoa *ptr,int xinfo)
{
   nodoa *p;
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
   nodoa *p, *j;
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
      j = ptr;
      while(j->sig != NULL)
      {
         j = j->sig;
      }
      p->sig = NULL;
      j->sig = p;
   }
   return ptr;
}
/*esta funcion se puede definir como booleana haciendo los sgtes cambios*/
nodoa *Buscarllave(nodoa *ptr, int elem)
{
   nodoa *p;
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
   nodoa *q, *k;
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
         k = ptr;
         while(k->sig != q)
         {
            k = k->sig;
         }
         k->sig = q->sig;
         free(q);
      }
   }
   return ptr;
}
void Mostrar(nodoa *ptr)
{
   system("CLS");
   nodoa *p;
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
