#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "iostream"
using namespace std;
int lista[50], lista2[50];
int Tope = -1, Tope2 = -1;
int InicCola(int tope);
int InfoCola(int vector[], int tope);
int InsertaCola(int tope, int vector[], int elem);
int ElimCola(int vector[], int tope);
bool ColaVacia(int tope);
void Mostrar(int vector[], int tope);

int menu();

int main(int argc, char*argv[])
{
   system ("clear");
   int sw = 1, i, j, xinfo;
   do{
      switch(menu())
      {
         case 1:
            system("clear");
            printf("Ingrese un numero...");
            scanf("%d", &xinfo);
            Tope = InsertaCola(Tope, lista, xinfo);
            Mostrar(lista, Tope);
            break;
         case 2:
            system("clear");
            printf("Ingrese un numero...");
            scanf("%d", &xinfo);
            Tope2 = InsertaCola(Tope2, lista2, xinfo);
            Mostrar(lista2, Tope2);
            break;
         case 3:
            Tope = ElimCola(lista, Tope);
            break;
         case 4:
            system("clear");
            /*UNEXPECTED FUNCTION*/
            break;
         case 5:
            system("clear");
            Mostrar(lista, Tope);
            cout << endl;
            Mostrar(lista2, Tope2);
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
int InicCola(int tope)
{
   tope = -1;
   return tope;
}
int InfoCola(int vector[], int tope)
{
   return vector[tope];
}
int InsertaCola(int tope, int vector[], int elem)
{
   tope++;
   vector[tope] = elem;
   return tope;
}
int ElimCola(int vector[], int tope)
{
   if(!ColaVacia(tope))
   {
      for(int i = 0; i <= tope; i++)
      {
         vector[i] = vector[i+1];
      }
      tope--;
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
bool ColaVacia(int tope)
{
   if(tope < 0)
   {
      return true;
   }
   else
   {
      return false;
   }
}
void Mostrar(int vector[], int tope)
{
   if(tope < 0)
   {
      printf("\n La Cola esta Vacia....\n");
   }
   else
   {
      for(int i = 0; i <= tope; i++)
      {
         cout << vector[i] << " -> ";
      }
   }
   cin.ignore();
   cin.get();
}
