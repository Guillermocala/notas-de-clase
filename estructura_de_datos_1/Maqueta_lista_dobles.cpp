<<<<<<< HEAD

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>


 struct nodoa {

        int info;
        nodoa *ant;
        nodoa *sig;
};



nodoa *ptr=NULL, *r,*p,*k,*h, *j;

nodoa* InsertaCabeza(nodoa *p,int xinfo);
nodoa* InsertaCola(nodoa *p,int xinfo);
nodoa* Buscarllave( nodoa *p, int elem);
nodoa* Eliminacion(nodoa *p,int elem);
void Mostrar(nodoa *p);

int menu (void);

int main(int argc, char*argv[]){
    system ("CLS");
    int sw=1, i, j, x;
    long opcion;
    do{
    switch (menu()){
    case 1:
    	 system ("CLS");
    	 printf ("Ingrese La Informacion: ");
         scanf ("%d", &i);
         ptr=InsertaCabeza(ptr,i);
       break;
    case 2:
       	 system ("CLS");
    	 printf ("Ingrese La Informacion: ");
         scanf ("%d", &i);
         ptr=InsertaCola(ptr,i);
       break;
     case 3:
        system ("CLS");
        Mostrar(ptr);
		getch();
       break;
     case 4:
     	system("cls");
     	if (ptr == NULL){
     		printf("la lista esta vacia");
     		getch();
		 }else{
		 	printf ("Ingrese Dato a buscar: ");
		 	scanf ("%d", &i);
		 	nodoa *q;
		 	q=Buscarllave(ptr, i);
		 	if (q!=NULL){
		 		printf("Se encontro el Elemento");
			 }else{
			 	printf("No se encontro el Elemento");
			 }
			 getch();
		 }
       break;
	 case 5:
	     system("cls");
	     if(ptr == NULL){
	     	printf("La lista esta vacia");
	     	getch();
		 }else{
		 	printf("ingrese el Dato a Eliminar: ");
		 	scanf("%d", &i);
		 	ptr = Eliminacion(ptr,i);
		 }
       break;
	   case 6:

       	break;

       case 0:
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
printf("\t\t\t� 3  ->  Mostrar lista           �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 4  ->  Buscar                  �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 5  ->  Eliminar                �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 6  ->                          �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 0  ->  Salir                   �\n");
printf("\t\t\t����������������������������������\n");
printf("\t\t\t�    Elija una opcion...         �\n");
printf("\t\t\t����������������������������������\n");


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

nodoa* InsertaCabeza (nodoa *ptr,int xinfo){

    p= (struct nodoa *) malloc (sizeof (nodoa));
    p->info = xinfo;
    if(ptr==NULL){
    	ptr=p;
    	p->ant=NULL;
    	p->sig=NULL;
	}else{
		p->ant=NULL;
		p->sig=ptr;
		ptr->ant=NULL;
		ptr=p;
	}
	return ptr;

}

nodoa* InsertaCola (nodoa *ptr,int xinfo){
	p= (struct nodoa *) malloc (sizeof (nodoa));
    p->info = xinfo;
    if(ptr==NULL){
    	ptr=p;
    	p->ant=NULL;
    	ptr->sig=NULL;
	}else{
		j=ptr;
		while(j->sig!=NULL){
			j=j->sig;
		}
		p->sig=NULL;
		j->sig=p;
		p->ant=j;
	}
  return ptr;
}


void  Mostrar (nodoa *ptr){
      system ("CLS");
      r=ptr;
      printf("PTR");
      while(r!=NULL){
      	printf("[%d]->", r->info);
      	r=r->sig;
	  }
	  printf("NULL");
getch();
}

nodoa* Buscarllave(nodoa *ptr,int elem){
	r=ptr;
	while(r!=NULL){
		if(r->info==elem){
			return r;
		}else{
			r=r->sig;
		}
	}
	r=NULL;
	return r;
}

nodoa* Eliminacion (nodoa *ptr,int elem){
	nodoa *q, *k, *l;
	q=Buscarllave(ptr,elem);
	if(q==NULL){
		printf("No se puede eliminar el elemento");
	}else{
		if(q==ptr)
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
=======

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>


 struct nodoa {

        int info;
        nodoa *ant;
        nodoa *sig;
};



nodoa *ptr=NULL, *r,*p,*k,*h, *j;

nodoa* InsertaCabeza(nodoa *p,int xinfo);
nodoa* InsertaCola(nodoa *p,int xinfo);
nodoa* Buscarllave( nodoa *p, int elem);
nodoa* Eliminacion(nodoa *p,int elem);
void Mostrar(nodoa *p);

int menu (void);

int main(int argc, char*argv[]){
    system ("CLS");
    int sw=1, i, j, x;
    long opcion;
    do{
    switch (menu()){
    case 1:
    	 system ("CLS");
    	 printf ("Ingrese La Informacion: ");
         scanf ("%d", &i);
         ptr=InsertaCabeza(ptr,i);
       break;
    case 2:
       	 system ("CLS");
    	 printf ("Ingrese La Informacion: ");
         scanf ("%d", &i);
         ptr=InsertaCola(ptr,i);
       break;
     case 3:
        system ("CLS");
        Mostrar(ptr);
		getch();
       break;
     case 4:
     	system("cls");
     	if (ptr == NULL){
     		printf("la lista esta vacia");
     		getch();
		 }else{
		 	printf ("Ingrese Dato a buscar: ");
		 	scanf ("%d", &i);
		 	nodoa *q;
		 	q=Buscarllave(ptr, i);
		 	if (q!=NULL){
		 		printf("Se encontro el Elemento");
			 }else{
			 	printf("No se encontro el Elemento");
			 }
			 getch();
		 }
       break;
	 case 5:
	     system("cls");
	     if(ptr == NULL){
	     	printf("La lista esta vacia");
	     	getch();
		 }else{
		 	printf("ingrese el Dato a Eliminar: ");
		 	scanf("%d", &i);
		 	ptr = Eliminacion(ptr,i);
		 }
       break;
	   case 6:

       	break;

       case 0:
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
printf("\t\t\t� 3  ->  Mostrar lista           �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 4  ->  Buscar                  �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 5  ->  Eliminar                �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 6  ->                          �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t�                                �\n");
printf("\t\t\t� 0  ->  Salir                   �\n");
printf("\t\t\t����������������������������������\n");
printf("\t\t\t�    Elija una opcion...         �\n");
printf("\t\t\t����������������������������������\n");


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

nodoa* InsertaCabeza (nodoa *ptr,int xinfo){

    p= (struct nodoa *) malloc (sizeof (nodoa));
    p->info = xinfo;
    if(ptr==NULL){
    	ptr=p;
    	p->ant=NULL;
    	p->sig=NULL;
	}else{
		p->ant=NULL;
		p->sig=ptr;
		ptr->ant=NULL;
		ptr=p;
	}
	return ptr;

}

nodoa* InsertaCola (nodoa *ptr,int xinfo){
	p= (struct nodoa *) malloc (sizeof (nodoa));
    p->info = xinfo;
    if(ptr==NULL){
    	ptr=p;
    	p->ant=NULL;
    	ptr->sig=NULL;
	}else{
		j=ptr;
		while(j->sig!=NULL){
			j=j->sig;
		}
		p->sig=NULL;
		j->sig=p;
		p->ant=j;
	}
  return ptr;
}


void  Mostrar (nodoa *ptr){
      system ("CLS");
      r=ptr;
      printf("PTR");
      while(r!=NULL){
      	printf("[%d]->", r->info);
      	r=r->sig;
	  }
	  printf("NULL");
getch();
}

nodoa* Buscarllave(nodoa *ptr,int elem){
	r=ptr;
	while(r!=NULL){
		if(r->info==elem){
			return r;
		}else{
			r=r->sig;
		}
	}
	r=NULL;
	return r;
}

nodoa* Eliminacion (nodoa *ptr,int elem){
	nodoa *q, *k, *l;
	q=Buscarllave(ptr,elem);
	if(q==NULL){
		printf("No se puede eliminar el elemento");
	}else{
		if(q==ptr)
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
>>>>>>> 70e79980be098aeacaab67607063399b97fa0f25
