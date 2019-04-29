/*
*Guillermo Cala; 24/ march/ 19; modified: 26/ march/ 19; mod: 01/ april/ 19
*maqueta de listas circulares simples con operaciones basicas
*/
#include "iostream"
#include "cstring"
using namespace std;
struct Nodo
{
   long long int info;
   Nodo *sig;
};
Nodo *ptr = NULL, *ptr2 = NULL, *ptr3 = NULL, *ptr4 = NULL;
int menu();
Nodo *insertarCabeza(Nodo *ptr, int xinfo);
Nodo *insertarCola(Nodo *ptr, long long int xinfo);
Nodo *Buscar(Nodo *ptr, int elem);
Nodo *EliminarNodo(Nodo *ptr, int elem);
Nodo *InsertarAsc(Nodo *ptr, int xinfo);
Nodo *OrdenarDesc(Nodo *ptr);
Nodo *OrdenarAsc(Nodo *ptr);
void Mostrar(Nodo *ptr);
Nodo *DosDeTres(Nodo *ptr, Nodo *ptr2, Nodo *ptr3);
Nodo *Josephus(Nodo *ptr,int info);
Nodo *Fibonacci(Nodo *ptr, int tope);
Nodo *Diferencia(Nodo *ptr, Nodo *ptr2);
int main()
{
   int number;
   int sw = 1, info, opt;
   do{
      switch(menu())
      {
         case 1:
            system("clear");
            cout << "En que lista desea trabajar?: ";
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
               case 3:
                  cout << "Ingrese el dato: ";
                  cin >> info;
                  ptr3 = insertarCabeza(ptr3, info);
                  break;
               default:
                  cout << "Valor incorrecto." << endl;
                  cin.ignore();
                  cin.get();
                  break;
            }
            break;
         case 2:
            system("clear");
            cout << "En que lista desea trabajar?: ";
            cin >> opt;
            switch(opt)
            {
               case 1:
                  cout << "Ingrese el dato: ";
                  cin >> info;
                  ptr = insertarCola(ptr, info);
                  break;
               case 2:
                  cout << "Ingrese el dato: ";
                  cin >> info;
                  ptr2 = insertarCola(ptr2, info);
                  break;
               case 3:
                  cout << "Ingrese el dato: ";
                  cin >> info;
                  ptr3 = insertarCola(ptr3, info);
                  break;
               default:
                  cout << "Valor incorrecto." << endl;
                  cin.ignore();
                  cin.get();
                  break;
            }
            break;
         case 3:
            system("clear");
            int llave;
            Nodo *q;
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
               cout << "Elemento no encontrado o lista vacia" << endl;
               cin.ignore();
               cin.get();
            }
            break;
         case 4:
            system("clear");
            int dato;
            cout << "En que lista desea trabajar?: ";
            cin >> opt;
            switch(opt)
            {
               case 1:
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
               case 2:
                  if(ptr2 == NULL)
                  {
                     cout << "Lista vacia" << endl;
                     cin.ignore();
                     cin.get();
                  }
                  else
                  {
                     cout << "Ingrese el dato a eliminar: ";
                     cin >> dato;
                     ptr2 = EliminarNodo(ptr2, dato);
                  }
                  break;
               case 3:
                  if(ptr3 == NULL)
                  {
                     cout << "Lista vacia" << endl;
                     cin.ignore();
                     cin.get();
                  }
                  else
                  {
                     cout << "Ingrese el dato a eliminar: ";
                     cin >> dato;
                     ptr3 = EliminarNodo(ptr3, dato);
                  }
                  break;
               default:
                  cout << "Valor incorrecto." << endl;
                  cin.ignore();
                  cin.get();
                  break;
            }
            break;
         case 5:
            system("clear");
            /*esta verificacion es para evitar un inifity loop, puede suceder
            cuando se intenta imprimir y la lista esta vacia*/
            if(ptr == NULL)
            {
               cout << "lista 1 vacia" << endl;
            }
            else
            {
               Mostrar(ptr);
            }
            if(ptr2 == NULL)
            {
               cout << "lista 2 vacia" << endl;
            }
            else
            {
               Mostrar(ptr2);
            }
            if(ptr3 == NULL)
            {
               cout << "lista 3 vacia" << endl;
            }
            else
            {
               Mostrar(ptr3);
            }if(ptr4 == NULL)
            {
               cout << "lista 4 vacia" << endl;
            }
            else
            {
               Mostrar(ptr4);
            }
            cin.ignore();
            cin.get();
            break;
         case 6:
            if(ptr == NULL)
            {
               cout << "la lista esta vacia" << endl;
               cin.get();
            }
            else if(ptr->sig->sig == ptr)
            {
               cout << "la lista solo tiene un elemento" << endl;
               cin.get();
            }
            else
            {
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
            int limit;
            system("clear");
            Diferencia(ptr, ptr2);
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
   printf("\n\t\t\t�   3 LISTAS DISPOINBLES   �");
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
Nodo *insertarCola(Nodo *ptr,long long int xinfo)
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
   int i = 1;
   while(r != ptr)
   {
      cout << i <<" [" << r->info << "] -> ";
      r = r->sig;
      i++;
   }
   cout << "NULL " << "\n\n";
}
Nodo *Buscar(Nodo *ptr, int elem)
{
   if(ptr == NULL)
   {
      return NULL;
   }
   else
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
Nodo *InsertarAsc(Nodo *ptr, int xinfo)
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
      Nodo *aux = ptr->sig, *aux2;
      /*posicionamos aux en el nodo anterior al de mayor info que el ingresado
      y debemos validar que sea aux ->sig != ptr; sino entonces aux quedara en
      ptr y no funcionara el algoritmo*/
      while(aux->sig != ptr && xinfo > aux->info)
      {
         aux = aux->sig;
      }
      if(aux == ptr->sig)
      {
         /*esta verificacion nos salva si hemos de posicionar antes o despues del nodo*/
         if(xinfo > aux->info)
         {
            p->sig = aux->sig;
            aux->sig = p;
         }
         else
         {
            ptr->sig = p;
            p->sig = aux;
         }
      }
      else
      {
         if(xinfo > aux->info)
         {
            p->sig = aux->sig;
            aux->sig = p;
         }
         else
         {
            aux2 = ptr->sig;
            while(aux2->sig != aux)
            {
               aux2 = aux2->sig;
            }
            aux2->sig = p;
            p->sig = aux;
         }
      }
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
Nodo *DosDeTres(Nodo *ptr, Nodo *ptr2, Nodo *ptr3)
{
   /*al ser 3 listas solo necesitamos hacer 2 recorridos: el de la primera lista con las
   2 sgtes y la ultima lista con las 2 primeras y asi evitamos evaluar la lista 2*/
   Nodo *q, *aux, *aux2, *aux3;
   /*con esta seccion comparamos la lista 1 con la lista 2 y 3*/
   aux = ptr->sig;
   while(aux != ptr)
   {
      aux2 = ptr2->sig;
      while(aux2 != ptr2)
      {
         aux3 = ptr3->sig;
         while(aux3 != ptr3)
         {
            if(aux->info == aux2->info || aux->info == aux3->info)
            {
               q = Buscar(ptr4, aux->info);
               if(q == NULL)
               {
                  ptr4 = InsertarAsc(ptr4, aux->info);
               }
            }
            aux3 = aux3->sig;
         }
         aux2 = aux2->sig;
      }
      aux = aux->sig;
   }
   /*con esta seccion comparamos la lista 3 con la lista 2 y 1*/
   aux3 = ptr3->sig;
   while(aux3 != ptr3)
   {
      aux2 = ptr2->sig;
      while(aux2 != ptr2)
      {
         aux = ptr->sig;
         while(aux != ptr)
         {
            if(aux3->info == aux2->info || aux3->info == aux->info)
            {
               q = Buscar(ptr4, aux3->info);
               if(q == NULL)
               {
                  ptr4 = InsertarAsc(ptr4, aux3->info);
               }
            }
            aux = aux->sig;
         }
         aux2 = aux2->sig;
      }
      aux3 = aux3->sig;
   }
   cout << "Insercion completa en la lista 4." << endl;
   cin.ignore();
   cin.get();
}
Nodo *Josephus(Nodo *ptr,int info)
{
   Nodo *aux = Buscar(ptr, info);
   int num;
   if(aux == NULL)
   {
      cout << "Elemento no se puede eliminar" << endl;
      cin.ignore();
      cin.get();
   }
   else
   {
      while(ptr->sig->sig != ptr)
      {
         /*con "num" realizamos una copia del valor de nodo antes de eliminarlo y luego, nos
         movemos ese num de veces dentro de la lista y eliminamos ese nodo, realizamos
         copia de su valor y repetimos el proceso hasta que quede un solo nodo*/
         /*como la lista tiene un encabezado debemos confirmas que al posicionar queda en ptr; ya
         que como ese nodo no tiene valor debemos mover el apuntador al sgte*/
         if(aux == ptr)
         {
            aux = aux->sig;
            num = aux->info;
            ptr = EliminarNodo(ptr, num);
         }
         else
         {
            num = aux->info;
            ptr = EliminarNodo(ptr, num);
         }
         for(int i = 0; i < num; i++)
         {
            /*si el el recorrido llega a estar en ptr se mueve un nodo de mas para que
            no altere el flujo del algoritmo*/
            if(aux == ptr)
            {
               aux = aux->sig;
            }
            aux = aux->sig;
         }
      }
      cout << "Ahora solo hay un elemento en la lista." << endl;
      cin.ignore();
      cin.get();
   }
   return ptr;
}
Nodo *Fibonacci(Nodo *ptr, int tope)
{
   /*el proceso es tener en base el 0 y 1(sumandos para llevar la operacion), luego sumar
   y reasignar los numeros para no usar mas recursos y en vista que tenemos creados los dos
   nodos (0 y 1) reducimos en 2 el valor digitado por el usuario*/
   long long int num1, num2, num3;
   num1 = 0;
   num2 = 1;
   ptr = insertarCola(ptr, num1);
   ptr = insertarCola(ptr, num2);
   tope -= 2;
   for(int i = 0; i < tope; i++)
   {
      num3 = num1 + num2;
      num1 = num2;
      num2 = num3;
      ptr = insertarCola(ptr, num3);
   }
   return ptr;
}
Nodo *Diferencia(Nodo *ptr, Nodo *ptr2)
{
   Nodo *aux, *aux2, *aux3;
   aux = ptr->sig;
   while(aux != ptr)
   {
      aux2 = ptr2->sig;
      while(aux2 != ptr2)
      {
         if(aux->info == aux2->info)
         {
            aux3 = Buscar(prt3, aux->sig);
            if(aux3 == NULL)
            {
               ptr3 = InsertarAsc(ptr3, aux->sig);
            }
         }
         aux2 = aux2->sig;
      }
      aux = aux->sig;  
   }
   cout << "Accion completa" << endl;
   cin.ignore();
   cin.get();
}