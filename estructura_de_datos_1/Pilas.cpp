#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <iostream>
using namespace std;
struct lista {
        
        int info;
        lista *sig;
};

 lista *ptr=NULL, *Tope= NULL, *r, *Tope1=NULL;
 
lista *InsertaPila(lista *tope, int xinfo);
bool PilaVacia(lista *tope);
lista *ElimPila(lista *tope);
int  InfoPila(lista * tope);
int menu (void);
void mostrar(lista *tope);
lista *InicPila(lista *tope);
void promedio(lista *tope);
lista *Elim(lista *tope, int elem);
lista *ElimRep(lista *tope, int elem);
 
int main(int argc, char*argv[]){
    system ("CLS");
    int sw=1, i, j,xinfo;
    long opcion;
    do{
    switch (menu()){
    case 1:
     system ("CLS");
      printf ("Ingrese un numero...");
      scanf ("%d", &xinfo);    	
      Tope=InsertaPila(Tope,xinfo);
       mostrar(Tope);
       break;
    case 2:
       system("CLS");
    if (PilaVacia(Tope)){
    	 printf ("La Pila esta Vacia");
	
	}else{
	
       i=InfoPila(Tope);
      printf ("el Valor del Tope es ...[%d]",i); 
	}
	  getch();
	   break;
     case 3:
       Tope=ElimPila(Tope);
       break;
     case 4:
      system ("CLS");
      cout << "Ingrese el elemento a eliminar";
      cin >> xinfo;
      Tope = ElimRep(Tope, xinfo);
      /*
      printf ("Ingrese un numero...");
      scanf ("%d", &xinfo);    	
      Tope1=InsertaPila(Tope1,xinfo);
       mostrar(Tope1);
      // para ejercicios*/
	   break;
	 case 5:
	 	promedio(Tope);
       break;
     case 6:
         system ("CLS");
         printf ("Press any key to exit...");
         sw=0;
         break;
     default:
         system ("CLS");
         printf("opcion no valida...por favor intente nuevamente\n");
         break;    
    }
    }while(sw);

    
getch();
}
int menu (void){
int opcion;
system("CLS");

   
printf ("\n\n");
printf("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
printf("\t\t\t²     ESTRUCTURA DE DATOS        ²\n");
printf("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 1  ->  Insertar Pila           ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 2  ->  Infomacion Tope         ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 3  ->  Eliminar Tope           ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 4  ->  Eliminar Unica Ocu      ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 5  ->  Promedio                ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t² 6  ->  Salir                   ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t²                                ²\n");
printf("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
printf("\t\t\t²    Elija una opcion...         ²\n");
printf("\t\t\t²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");
    
 
int sw=1;
    do {
    opcion=getch();
       if (opcion>=48 && opcion <=57){
       sw=0;
       }else
        printf("\n se debe ingresar un entero entre 1-9\n");
    
    }while(sw);
    opcion=opcion-48;

   return opcion;
   }   
lista *InsertaPila (lista *tope, int info){
    r= (struct lista *) malloc (sizeof (lista));
    r->info=info;
    
    /* completar con el algoritmo de insertar cabeza */
    if (tope==NULL){
    	tope = r;
    	r->sig = NULL;
      

	}
	else
	{
		r->sig = tope;
		tope = r;
	  	}
return tope;
}

lista  *ElimPila(lista *tope){
    if (!PilaVacia(tope)){
    	r=tope;
    	tope = tope->sig;
    	free(r);
    	printf("\n Registro Eliminado con Exito\n");
        return tope;
	 
	}
	else{
		   printf("\n La Pila esta Vacia....\n");
   	}
	 
   	getch(); /* completar con el algoritmo de insertar cabeza */
    
}

bool PilaVacia(lista *tope){
	if (tope==NULL){
		return true;
	}
	else {
		return false;
	}
}

int InfoPila(lista *tope){
		return tope->info;
	
}

void mostrar(lista *tope){
	r=tope;
	if (tope == NULL){
	  printf("\n La Pila esta Vacia....\n");

	}
    else{
	
	while (r!=NULL){
     		   printf("[%d]->",r->info);
		r=r->sig;
	}
}
   getch();
}

lista *InicPila(lista *tope)
{
	tope = NULL;
	return tope;
}
void promedio(lista *tope)
{
	lista *tope2;
	tope2 = InicPila(tope2);
	int prom, c, sum;
	c = 0;
	sum = 0;
	while(!PilaVacia(tope))
	{
		c++;
		sum += InfoPila(tope);
		tope2 = InsertaPila(tope2, InfoPila(tope));
		tope = ElimPila(tope);
	}
	prom = sum / c;
	cout << "El promedio es: " << prom << endl;
	while(!PilaVacia(tope2))
	{
		tope = InsertaPila(tope, InfoPila(tope2));
		tope2 = ElimPila(tope2);
	}
	getch();
}
lista *ElimRep(lista *tope, int elem)
{
	lista *tope2;
	tope2 = InicPila(tope2);
	int prom, c, sum;
	while(!PilaVacia(tope))
	{
		if(InfoPila(tope) != elem)
		{
			tope2 = InsertaPila(tope2, InfoPila(tope));
		}
		tope = ElimPila(tope);
	}
	while(!PilaVacia(tope2))
	{
		tope = InsertaPila(tope, InfoPila(tope2));
		tope2 = ElimPila(tope2);
	}
	return tope;
}
