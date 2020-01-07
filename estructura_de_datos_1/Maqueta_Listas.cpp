#include "iostream"
#include <conio.h>
#include "cstring"
#include "TAD_Listas.cpp"
using namespace std;
using namespace TAD_List_Simp; //<---------------- TAD LISTAS SIMPLES
//using namespace TAD_List_Doble; <---------------- TAD LISTAS DOBLES
//using namespace TAD_List_Circ_Simp; <---------------- TAD LISTAS CIRCULARES SIMPLES
//using namespace TAD_List_Circ_Doble; <---------------- TAD LISTAS CIRCULARES DOBLES

int menu(void);
/*
* InsertaCabeza
* InsertaCola
* Buscarllave
* Mostrar
* Eliminacion
*/
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
            cout << "En cual lista va a trabajar?: ";
            cin >> i;
            switch(i)
            {
               case 1:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr = InsertaCabeza(ptr, j);
                  getch();
                  break;
               case 2:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr1 = InsertaCabeza(ptr1, j);
                  break;
               case 3:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr2 = InsertaCabeza(ptr2, j);
                  break;
               default:
                  cout << "Valor invalido!" << endl;
                  break;
            }
            break;
         case 2:
            system("CLS");
            cout << "En cual lista va a trabajar?: ";
            cin >> i;
            switch(i)
            {
               case 1:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr = InsertaCola(ptr, j);
                  break;
               case 2:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr1 = InsertaCola(ptr1, j);
                  break;
               case 3:
                  cout << "Ingrese el dato: ";
                  cin >> j;
                  ptr2 = InsertaCola(ptr2, j);
                  break;
               default:
                  cout << "Valor invalido!" << endl;
                  break;
            }
            break;
         case 3:
            system("CLS");
            Mostrar(ptr);
            Mostrar(ptr1);
            Mostrar(ptr2);
            break;
         case 4:
            system("cls");
            cout << "En cual lista va a trabajar?: ";
            cin >> i;
            switch(i)
            {
               case 1:
                  if(ptr == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr, i);
                     if(q != NULL)
                     {
                        cout << "Se encontro el elemento" << endl;
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               case 2:
                  if(ptr1 == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr1, i);
                     if(q != NULL)
                     {
                        cout << "Se encontro el elemento" << endl;
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               case 3:
                  if(ptr2 == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr2, i);
                     if(q != NULL)
                     {
                        cout << "Se encontro el elemento" << endl;
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               default:
                  cout << "Valor invalido!" << endl;
                  break;
            }
            break;
         case 5:
            system("cls");
            cout << "En cual lista va a trabajar?: ";
            cin >> i;
            switch(i)
            {
               case 1:
                  if(ptr == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr, i);
                     if(q != NULL)
                     {
                        ptr = Eliminacion(ptr, j);
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               case 2:
                  if(ptr1 == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr1, i);
                     if(q != NULL)
                     {
                        ptr1 = Eliminacion(ptr1, j);
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               case 3:
                  if(ptr2 == NULL)
                  {
                     cout << "La lista esta vacia" << endl;
                     getch();
                  }
                  else
                  {
                     cout << "Ingrese el dato: ";
                     cin >> j;
                     nodoa *q;
                     q = Buscarllave(ptr2, i);
                     if(q != NULL)
                     {
                        ptr = Eliminacion(ptr, j);
                     }
                     else
                     {
                        cout << "No encontro el elemento" << endl;
                     }
                     getch();
                  }
                  break;
               default:
                  cout << "Valor invalido!" << endl;
                  break;
            }
            break;
         case 6:
         	system("cls");
         	//cout << "Espacio reservado para ejercicio..." << endl;
            if (ptr != NULL) {
               /*unexpected function*/
            }
            else {
               cout << "lista vacia..." << endl;
            }
            getch();
         	break;
         case 0:
            system("CLS");
            cout << "Press any key to exit..." << endl;
            sw = 0;
            break;
         default:
            system("CLS");
            cout << "Opcion no valida... por favor intente nuevamente" << endl;
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
   printf("\t\t\t# 6  ->  Ejercicio(lista1)       #\n");
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
      cout << "Se debe ingresar un entero entre 1-9" << endl;
   }while(sw);
   opcion = opcion-48;
   return opcion;
}
