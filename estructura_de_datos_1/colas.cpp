#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "iostream"
using namespace std;
struct lista
{
  int info;
  lista *sig;
};
lista *ptr = NULL, *Tope = NULL, *Tope1 = NULL, *Tope2 = NULL;
lista *InicCola(lista *tope);
lista *InsertaCola(lista *tope, int xinfo);
lista *ElimCola(lista *tope);
bool ColaVacia(lista *tope);
int  InfoCola(lista * tope);
void Mostrar(lista *tope);
lista *InsertaInver(lista *tope, int elem);
lista *InsertPos(lista *tope, int elem, int pos);
int menu();

int main(int argc, char*argv[])
{
   system ("clear");
   int sw = 1, i, j, xinfo, xinfo2;
   do{
      switch(menu())
      {
         case 1:
            system("clear");
            printf("Ingrese un numero...");
            scanf("%d", &xinfo);
            Tope = InsertaCola(Tope, xinfo);
            Mostrar(Tope);
            break;
         case 2:
            system("clear");
            printf("Ingrese un numero...");
            scanf("%d", &xinfo);
            Tope1 = InsertaCola(Tope1, xinfo);
            Mostrar(Tope1);
            break;
         case 3:
            Tope = ElimCola(Tope);
            break;
         case 4:
            system("clear");
            /*UNEXPECTED FUNCTION*/
            break;
         case 5:
            system("clear");
            Mostrar(Tope);
            cout << endl;
            Mostrar(Tope1);
            cout << endl;
            Mostrar(Tope2);
            break;
         case 6:
            system("clear");
            printf("Press any key to exit...");
            sw = 0;
            break;
         default:
            system("clear");
            printf("opcion no valida...por favor intente nuevamente\n");
            break;
      }
   }
   while(sw);
   cin.ignore();
   cin.get();
}
int menu(void)
{
  int opcion;
  system("clear");
  printf("\n\n");
  printf("\t\t\t����������������������������������\n");
  printf("\t\t\t�       MAQUETA DE COLAS         �\n");
  printf("\t\t\t����������������������������������\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 1  ->  Insertar Cola           �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 2  ->  Insertar Cola 2         �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 3  ->  Eliminar Tope           �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 4  ->  Ejercicio               �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 5  ->  Mostrar                 �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t� 6  ->  Salir                   �\n");
  printf("\t\t\t�                                �\n");
  printf("\t\t\t����������������������������������\n");
  printf("\t\t\t�    Elija una opcion...         �\n");
  printf("\t\t\t����������������������������������\n");
  cin >> opcion;
  return opcion;
}
lista *InicCola(lista *tope)
{
   tope = NULL;
   return tope;
}
int InfoCola(lista *tope)
{
   return tope->info;
}
lista *InsertaCola(lista *tope, int info)
{
   lista *r = (struct lista*) malloc (sizeof(lista)), *j;
   r->info = info;
   if(tope == NULL)
   {
      tope = r;
      r->sig = NULL;
   }
   else
   {
      j = tope;
      while(j->sig != NULL)
      {
         j = j->sig;
      }
      j->sig = r;
      r->sig = NULL;
   }
   return tope;
}
lista *ElimCola(lista *tope)
{
   if(!ColaVacia(tope))
   {
      lista *r = tope;
      tope = tope->sig;
      free(r);
      printf("\n Registro Eliminado con Exito\n");
      return tope;
   }
   else
   {
      printf("\n La Cola esta Vacia....\n");
   }
   cin.ignore();
   cin.get();
}
bool ColaVacia(lista *tope)
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
void Mostrar(lista *tope)
{
   lista *r = tope;
   if(tope == NULL)
   {
      printf("\n La Cola esta Vacia....\n");
   }
   else
   {
      while(r != NULL)
      {
         printf("[%d]->", r->info);
         r = r->sig;
      }
   }
   cin.ignore();
   cin.get();
}
lista *InsertaInver(lista *tope, int elem)
{
   lista *r = (struct lista*) malloc (sizeof(lista)), *j;
   r->info = elem;
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
}a
