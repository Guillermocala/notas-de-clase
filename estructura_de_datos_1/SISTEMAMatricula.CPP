#include <stdio.h>
#include <iostream>
#include <conio.h>
#include <string.h>
#include <stdlib.h>
#include <windows.h>
using namespace std;
int t;

void gotoxy(int x,int y){  
      HANDLE hcon;  
      hcon = GetStdHandle(STD_OUTPUT_HANDLE);  
      COORD dwPos;  
      dwPos.X = x;  
      dwPos.Y= y;  
      SetConsoleCursorPosition(hcon,dwPos);  
 }  
struct notas {
 long notanumero;
 long nota;
 notas *ntsig;
};

struct matricula{
 long cod;
 matricula *mrsig;
 notas *ntptr;
};

struct alum{
 long cod;
 char nomb[50];
 char dir[50];
 long tel;
 char email[50];
 alum *alsig;
 matricula *a1ptr;
};

struct amatri{
 amatri *atsig;
 alum *t;
};

struct materias{
  long cod;
  char nomb[50];
  char semes[50];
  amatri *aptr;
  materias *mtsig;
};

//FUNCION PARA BUSCAR ESTUDIANTES
int busest(alum *alptr,long cod){
alum *r=alptr;
int sw=0;
while(r!=NULL && sw==0){
 if(r->cod==cod)
	 sw=1;
 else
	 r=r->alsig;
}
if(sw==1)
 return 1;
else
 return 0;
}

//FUNCION PARA BUSCAR MATERIAS
int busmate(materias *mtptr,long cod){
 materias *r=mtptr;
 int sw=0;
 while(r!=NULL && sw==0){
  if(r->cod==cod)
	 sw=1;
  else
	 r=r->mtsig;
}
if(sw==1)
 return 1;
else
 return 0;
}

//FUNCION PARA BUSCAR MATRICULA

int busmatri(alum *alptr, long cod, long cod1){
	alum *r=alptr;
  int sw=0;

while(r!=NULL && sw==0){
    if(r->cod==cod)
	 sw=1;
    else
	 r=r->alsig;
}
sw=0;
matricula *p=r->a1ptr;

while(p!=NULL && sw==0){
    if(p->cod==cod1)
	 sw=1;
    else
	 p=p->mrsig;
}

if(sw==1)
 return 1;
else
 return 0;
}


//FUNCION PARA BUSCAR NOTAS
int busnota(alum *alptr,long codal,long codmat, long numero){

alum *r=alptr;
matricula *y;
notas *y1;
int sw=0;

while(r!=NULL && sw==0){
if(r->cod==codal)
 sw=1;
else
r=r->alsig;
}

sw=0;
y=r->a1ptr;
while(y!=NULL && sw==0){
   if(y->cod==codmat)
   sw=1;
   else
y=y->mrsig;
}
sw=0;
y1=y->ntptr;
while(y1!=NULL && sw==0){
if(y1->notanumero==numero)
sw=1;
else
y1=y1->ntsig;
}


if(sw==1)
 return 1;
 else
 return 0;



}

//FUNCION PARA CREAR ESTUDIANTES
alum *crearestu(alum *alptr, long cod, char nomb[50],char dir[50],long tel,char email[50]){
 alum *r,*p;
 p=new alum;

 if(alptr==NULL){
  p->alsig=NULL;
  alptr=p;
 }
 else{
  r=alptr;
  while(r->alsig!=NULL)
  r=r->alsig;

  r->alsig=p;
  p->alsig=NULL;
 }

   p->a1ptr=NULL;

   p->cod=cod;
   strcpy(p->nomb,nomb);
   strcpy(p->dir,dir);
   p->tel=tel;
   strcpy(p->email,email);
   return alptr;
}

//FUNCION PARA CREAR MATERIAS
materias *crearmate(materias *mtptr, long cod, char nomb[50],char seme[50]){
 materias *r,*p;
 p=new materias;
 if(mtptr==NULL){
  p->mtsig=NULL;
  mtptr=p;
 }
 else{
  r=mtptr;
  while(r->mtsig!=NULL){
  r=r->mtsig;
  }
  r->mtsig=p;
  p->mtsig=NULL;
   }

   p->aptr=NULL;
   p->cod=cod;
   strcpy(p->nomb,nomb);
   strcpy(p->semes,seme);
   return mtptr;
}

//FUNCION PARA VALIDAR NUMEROS
int validar(char v[50]){
 int sw=0;
if(strlen(v)!=0){
 for(int x=0;x<strlen(v);x++){
  if(v[x]!='0' && v[x]!='1' && v[x]!='2' && v[x]!='3' && v[x]!='4' &&v[x]!='5' &&v[x]!='6' &&v[x]!='7' && v[x]!='8' && v[x]!='9' )
   sw=1;
 }
 }
 else{
  if(v[0]!='0' && v[0]!='1' && v[0]!='2' && v[0]!='3' && v[0]!='4' &&v[0]!='5' &&v[0]!='6' &&v[0]!='7' && v[0]!='8' && v[0]!='9' ){
   sw=1;
 }

 }
 if(sw==1)
  return 1;
 else
  return 0;
}


//FUNCION PARA VER MATERIAS DE UN ALUMNO
vermate(materias *mtptr, alum *alptr){
materias *r=mtptr;
alum *r1=alptr;

char cod[50];
long op;
long y1;

d1:
system("cls");
   gotoxy(19,1);
cout<<"...:::LISTA DE MATERIAS DE UN ESTUDIANTE:::...";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DEL ESTUDIANTE";
gotoxy(16,9);
cin>>cod;


if(validar(cod)==1){
	     gotoxy(16,11);
	     cout<<"ERROR : CODIGO INCORRECTO";
	     getch();
	     goto d1;
}

else{
 y1=atol(cod);
  if(busest(alptr,y1)==0){
  gotoxy(16,11);
	     cout<<"ERROR : CODIGO INCORRECTO";
	     getch();
	     goto d1;

  }
  else{
  int sw=0;
  while(r1!=NULL && sw==0){
    if(r1->cod==y1)
    sw=1;
    else
    r1=r1->alsig;
    }

   if(r1->a1ptr==NULL){
     gotoxy(16,11);
    cout<<"EL ESTUDIANTE NO TIENE MATERIAS MATRICULADAS";
	     getch();
	     goto d1;
   }
   else{
 system("cls");
   gotoxy(19,1);
cout<<"...:::LISTA DE MATERIAS DE UN ESTUDIANTE:::...";
gotoxy(3,5);
cout<<"CODIGO";
gotoxy(18,5);
cout<<"NOMBRE";
gotoxy(33,5);
cout<<"SEMESTRE";
int x=3,y=8;

   matricula *e=r1->a1ptr;
   while(e!=NULL){
       r=mtptr;

	while(r!=NULL){
if(r->cod==e->cod){
  gotoxy(x,y);
 cout<<r->cod;
 x=x+15;
  gotoxy(x,y);
  cout<<r->nomb;
   x=x+15;
  gotoxy(x,y);
    cout<<r->semes;
   y=y+1;
   x=3;

}
r=r->mtsig;
 }
   e=e->mrsig;
   }

   }
  }

}

getch();
}


//FUNCION PARA VER LOS ESTUDIANTES DE UNA MATERIA
verest(materias *mtptr){

materias *r=mtptr;


char cod[50];
long y1;

d1:
system("cls");
   gotoxy(19,1);
cout<<"...:::LISTA DE ESTUDIANTES DE UNA MATERIA:::...";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DE LA MATERIA";
gotoxy(16,9);
cin>>cod;
if(validar(cod)==1){
	     gotoxy(16,11);
	     cout<<"ERROR : CODIGO INCORRECTO";
	     getch();
	     goto d1;
}
else{
 y1=atol(cod);
  if(busmate(mtptr,y1)==0){
  gotoxy(16,11);
	     cout<<"ERROR : CODIGO INCORRECTO";
	     getch();
	     goto d1;

  }
  else{
  int sw=0;
  while(r!=NULL && sw==0){
    if(r->cod==y1)
    sw=1;
    else
    r=r->mtsig;
    }

   if(r->aptr==NULL){
     gotoxy(16,11);
    cout<<"LA MATERIA NO TIENE ESTUDIANTES MATRICULADOS";
	     getch();
	     goto d1;
   }
   else{
   amatri *a=r->aptr;
   alum *al;
 system("cls");
gotoxy(19,1);
cout<<"...:::LISTA DE ESTUDIANTES DE UNA MATERIA:::...";
gotoxy(3,5);
cout<<"CODIGO";
gotoxy(18,5);
cout<<"NOMBRE";
gotoxy(33,5);
cout<<"DIRECCION";
gotoxy(48,5);
cout<<"TELEFONO";
gotoxy(63,5);
cout<<"EMAIL";

int x=3,y=8;

while(a!=NULL){
al=a->t;
 gotoxy(x,y);
 cout<<al->cod;
 x=x+15;
  gotoxy(x,y);
  cout<<al->nomb;
   x=x+15;
  gotoxy(x,y);
    cout<<al->dir;
   x=x+15;
  gotoxy(x,y);
    cout<<al->tel;
   x=x+15;
  gotoxy(x,y);
    cout<<al->email;
   x=x+15;
  gotoxy(x,y);
   y=y+1;
   x=3;

a=a->atsig;
}


   }


	}

 }
getch();
}


//FUNCION PARA MATRICULAR ESTUDIANTES
int  matricular(materias *mtptr, alum *alptr){

char cod[50];
long y;
long x;
d:
system("cls");
gotoxy(24,2);

		cout<<"..::MATRICULAR ESTUDIANTE::..";
		gotoxy(16,30);
cout<<"(S). REGRESAR";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DEL ESTUDIANTE";
gotoxy(16,9);
cin>>cod;



		if(strcmp("S",cod)==0)
			     return 0;
			     else{


		if(strcmp("S",cod)==0)
			     return 0;

			  else{


if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
		goto d;
}
else{


		y=atol(cod);
		if(busest(alptr,y)==0){
			 gotoxy(16,11);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
			 goto d;
		}
		else{

		d1:
		       gotoxy(16,11);
			cout<<"DIGITE EL CODIGO DE LA MATERIA";
			gotoxy(16,13);
			cin>>cod;



		if(strcmp("S",cod)==0)
			     return 0;
			     else{

			if((validar(cod))==1){
	gotoxy(16,15);
	cout<<"ERROR: CODIGO INCORRECTO";

		getch();
		gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
		goto d1;
}

else{
		x=atol(cod);
		if(busmate(mtptr,x)==0){
			 gotoxy(16,15);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
			 goto d1;
		}
		else{
		 if(busmatri(alptr,y,x)==1){
			 gotoxy(16,15);
			 cout<<"ERROR : YA ESTA MATRICULADO EN ESTA MATERIA";
			 getch();
gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
			 goto d1;
		}
		else{

		matricula *p,*p1;
		alum *r=alptr;
		int sw=0;
		while(r!=NULL && sw==0){
		 if(r->cod==y)
		  sw=1;
		  else
		  r=r->alsig;
		}
		p=r->a1ptr;
		if(p==NULL){
		p1=new matricula;
		p1->cod=x;
		p1->ntptr=NULL;
		p1->mrsig=NULL;
		r->a1ptr=p1;
		}
		else{
		 while(p->mrsig!=NULL){
		  p=p->mrsig;
		 }
		 p1=new matricula;
		 p1->ntptr=NULL;
		 p1->cod=x;
		 p->mrsig=p1;
		 p1->mrsig=NULL;
		}


		sw=0;
		materias *f=mtptr;
		while(f!=NULL && sw==0){
		 if(f->cod==x)
		  sw=1;
		  else
		   f=f->mtsig;
		}
		amatri *u=f->aptr;
		amatri *aux;
		if(u==NULL){
		 aux=new amatri;
		 f->aptr=aux;
		 aux->t=r;
		 aux->atsig=NULL;
		}
		else{
		  while(u->atsig!=NULL){
		  u=u->atsig;
		  }
		  aux=new amatri;
		  u->atsig=aux;
		  aux->atsig=NULL;
		  aux->t=r;
		}    }
		gotoxy(16,15);
			 cout<<"ESTUDIANTE MATRICULADO";
		getch();
		}
		}
	}       }
		}

	  }
 }

}


//FUNCION PARA ELIMINAR MATERIA
materias *elimmate(materias *mtptr,alum *alptr, long cod){
materias *r=mtptr,*r1;
int sw=0;

 while(r!=NULL && sw==0){
  if(r->cod==cod)
   sw=1;
   else
   r=r->mtsig;
 }

 amatri *y,*y1;
 alum *i;
 matricula *u,*u1,*u2;
 notas *n,*n1;

 if(r->aptr!=NULL){
	y=r->aptr;
	 //ELIMINAR NODOS APUNTADORES
	  while(y!=NULL){
	    i=y->t;
	    u=i->a1ptr;
	   //ELIMINAR MATRICULA EN LISTA ESTUDIANTES
	    while(u!=NULL){
		if(u->cod==cod){
		    //ELIMINAR NOTAS
			if(u->ntptr!=NULL){
			 n=u->ntptr;
		    while(n!=NULL){
		     n1=n;
		n=n->ntsig;
	     u->ntptr=n;
	     n1->ntsig=NULL;
	     free(n1);
	    }
	}


      //ELIMINAR MATERIA EN LISTA MATRICULA
      if(u==i->a1ptr){
	u1=u;
      u=u->mrsig;
      i->a1ptr=u;
      u1->mrsig=NULL;
      free(u1);
      }
      else{
       u1=u;
       u=u->mrsig;
       u2=i->a1ptr;
       while(u2->mrsig!=u1){
       u2=u2->mrsig;
       }
       u2->mrsig=u;
       u1->mrsig=NULL;
       free(u1);
      }
    //
    }
    else
    u=u->mrsig;
    }

   y1=y;
   y=y->atsig;
   r->aptr=y;
   y1->atsig=NULL;
   y1->t=NULL;
   free(y1);
  }
 }

r1=mtptr;
if(r==mtptr){
  r=r->mtsig;
  mtptr=r;
  r1->mtsig=NULL;
  free(r1);
}
else{
 while(r1->mtsig!=r){
 r1=r1->mtsig;
 }
 r1->mtsig=r->mtsig;
 r->mtsig=NULL;
 free(r);
}

return mtptr;
}


//FUNCION PARA VALIDAR ELIMINACION DE MATERIAS

materias *valimat(materias *mtptr,alum *alptr){
char cod[50];
long y;
d:
system("cls");
gotoxy(24,2);

		cout<<"..::ELIMINAR MATERIA::..";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DE LA MATERIA";
gotoxy(16,9);
cin>>cod;
if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
		goto d;
}

else{
		y=atol(cod);
		if(busmate(mtptr,y)==0){
			 gotoxy(16,11);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
			 goto d;

		}
		else{

				  mtptr=elimmate(mtptr,alptr,y);
				  gotoxy(16,11);
			 cout<<"MATERIA ELIMINADA";
			 getch();

		}
	}
	return mtptr;
}

//FUNCION PARA ELIMINAR ESTUDIANTES
alum *elimes(alum *alptr,materias *mtptr, long cod){
 alum *r=alptr;
 alum *p=r;
 alum *s;

 int sw=0;


 while(r!=NULL && sw==0){
    if(r->cod==cod)
     sw=1;
    else
     r=r->alsig;
 }

 if(r->a1ptr!=NULL){
  sw=0;
   matricula *w=r->a1ptr;
   matricula *aux=w;
   materias *rt;
   amatri *a1,*a2;
   notas *q,*q1;

   while(w!=NULL){
    rt=mtptr;
     while(rt!=NULL && sw==0){
	if(rt->cod==w->cod)
	 sw=1;
	else
	 rt=rt->mtsig;
     }

     a1=rt->aptr;
     sw=0;
     while(a1!=NULL && sw==0){
     s=a1->t;
      if(s->cod==r->cod){
       sw=1;           }
       else  {
       a1=a1->atsig;}
      }

     if(a1==rt->aptr){
      rt->aptr=a1->atsig;
     }
     else{
     a2=rt->aptr;
      while(a2->atsig!=a1){
      a2=a2->atsig;
      }
      a2->atsig=a1->atsig;
     }

     a1->atsig=NULL;
     a1->t=NULL;
     free(a1);
     sw=0;

     if(w==r->a1ptr){
       aux=w;

       //ELIMINAR NOTAS
       q=w->ntptr;
       if(q!=NULL){
       while(q!=NULL){
	q1=q;
	q=q->ntsig;
	w->ntptr=q;
	q1->ntsig=NULL;
	free(q1);
	}
       }
       //
       w=w->mrsig;
       r->a1ptr=w;
       aux->mrsig=NULL;
       free(aux);
     }

     else{
     matricula *aux2;
       while(aux->mrsig!=w){
       aux=aux->mrsig;
       }
       aux2=w;
       aux->mrsig=w->mrsig;
       w=w->mrsig;
       aux2->mrsig=NULL;
       free(aux2);
     }



   }


 }

 if(r==alptr) {
  p=r;
  r=r->alsig;
  alptr=r;
  p->alsig=NULL;
  free(p);
 }
 else{
  while(p->alsig!=r){
  p=p->alsig;
  }
  p->alsig=r->alsig;
  r->alsig=NULL;
  free(r);
 }



return alptr;

}


//FUNCION PARA VALIDAR ELIMINACION DE ESTUDIANTE
alum *elimvali(alum *alptr,materias *mtptr){
char cod[50];
long y;
d:
system("cls");
gotoxy(24,2);

		cout<<"..::ELIMINAR ESTUDIANTE::..";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DEL ESTUDIANTE";
gotoxy(16,9);
cin>>cod;
if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
		goto d;
}

else{
		y=atol(cod);
		if(busest(alptr,y)==0){
			 gotoxy(16,11);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
			 goto d;
		}
		else{

				  alptr=elimes(alptr,mtptr,y);
				  gotoxy(16,11);
			 cout<<"ESTUDIANTE ELIMINADO";
			 getch();

		}



}
return alptr;
}

//FUNCION PARA MODIFICAR MATERIA
modimate(materias *mtptr){
    d:	system("cls");
gotoxy(24,2);
		cout<<"..::MODIFICAR MATERIA::..";
char cod[50];
long y;
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DE LA MATERIA";
gotoxy(16,9);
cin>>cod;
if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
		goto d;
}

else{

	y=atol(cod);
	if(busmate(mtptr,y)==0){
	 gotoxy(16,11);
	 cout<<"ERROR : CODIGO NO EXISTE";
	 getch();
	 goto d;
	}
	else{

	      char f[50];

	  materias *r=mtptr;
	  int sw=0;
	   while(r!=NULL && sw==0){
	      if(r->cod==y)
	       sw=1;
	       else
	       r=r->mtsig;
	   }

	   do{
	     e:

	   system("cls");


			gotoxy(24,2);

		cout<<"..::DATOS DE LA MATERIA::..";
	   gotoxy(16,7);
	 cout<<"(NO)  CODIGO -> "<<r->cod;
		   gotoxy(16,9);
	 cout<<"(1).  NOMBRE -> "<<r->nomb;
		   gotoxy(16,11);
	 cout<<"(2).  SEMESTRE -> "<<r->semes;
	   gotoxy(16,15);
	 cout<<"(3).  REGRESAR ";
	   gotoxy(16,17);
	 cout<<"DIGITE EL NUMERO DEL DATO A MODIFICAR(?)";
		      gotoxy(16,19);
	     cin>>f;
	     if(validar(f)==1){
	      gotoxy(16,21);
	 cout<<"ERROR : OPCION INCORRECTA";
	 getch();

	  goto e;

	 }
	 else{
	    y=atol(f);
	    if(y<1 || y>3){
		      gotoxy(16,21);
		 cout<<"ERROR : OPCION INCORRECTA";
		 getch();
		 goto e;

	    }
	    else{
	    switch(y){
	      case 1:{

	      gotoxy(16,21);
		      cout<<"                                                                   ";
			       gotoxy(16,21);
		 cout<<"DIGITE EL NUEVO NOMBRE";

		 gotoxy(16,22);
		      cout<<"                                                                   ";
		      gotoxy(16,23);
		      cout<<"                                                                   ";
			       gotoxy(16,23);
	       gets(cod);
		  strcpy(r->nomb,cod);
		   gotoxy(16,25);
		 cout<<"NOMBRE MODIFICADO";
		 getch();
		  goto e;
	      break;
	      }

	      case 2:{
	       gotoxy(16,21);
		      cout<<"                                                                   ";
			       gotoxy(16,21);
		 cout<<"DIGITE EL NUEVO SEMESTRE";

		 gotoxy(16,22);
		      cout<<"                                                                   ";
		      gotoxy(16,23);
		      cout<<"                                                                   ";
			       gotoxy(16,23);
	       gets(cod);
		  strcpy(r->semes,cod);
		   gotoxy(16,25);
		 cout<<"SEMESTRE MODIFICADO";
		 getch();
		  goto e;
	      break;
	      }
	    }

	    }
	 }
	     }while(y>=1 && y<=2);
	}
}

}

//FUNCION CREAR NOTAS
crearnotas(alum *alptr,long codal,long codmat, long numero, long nota){

alum *r=alptr;
	matricula *r1;
	notas *n;
	int sw=0;
	while(r!=NULL && sw==0){
	  if(r->cod==codal)
	  sw=1;
	  else
	  r=r->alsig;
	}

sw=0;
r1=r->a1ptr;
while(r1!=NULL && sw==0){
if(r1->cod==codmat)
  sw=1;
  else
  r1=r1->mrsig;
}
n=r1->ntptr;
notas *p, *aux1;
p=new notas;

if(n==NULL){
  r1->ntptr=p;
  p->ntsig=NULL;
}
else{

 if(numero<n->notanumero){
 p->ntsig=n;
 r1->ntptr=p;
 }
else{

 while(n->ntsig!=NULL)
n=n->ntsig;

if(numero>n->notanumero){
 n->ntsig=p;
 p->ntsig=NULL;
}

else{
aux1=r1->ntptr;
p->ntsig=n;
aux1->ntsig=p;

}
     }


}
    p->notanumero=numero;
    p->nota=nota;

}


//FUNCION PARA VALIDAR INGRESO DE NOTAS

int valinotas(materias *mtptr, alum *alptr){

char cod[50];
long y;
long x;


d:
system("cls");
gotoxy(24,2);

		cout<<"..::INGRESO DE NOTAS::..";
					 gotoxy(16,30);
	  cout<<"(S). REGRESAR\n";
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DE LA MATERIA";
gotoxy(16,9);
cin>>cod;

		if(strcmp("S",cod)==0)
			     return 0;
else{

if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
}
else{
		y=atol(cod);



		if(busmate(mtptr,y)==0){
			 gotoxy(16,11);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
			 goto d;
		}


		d1:
		       gotoxy(16,11);
			cout<<"DIGITE EL CODIGO DEL ESTUDIANTE";
			gotoxy(16,13);
			cin>>cod;
		if(strcmp("S",cod)==0)
			     return 0;


		 else{

			if((validar(cod))==1){
	gotoxy(16,15);
	cout<<"ERROR: CODIGO INCORRECTO";

		getch();
		gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
		goto d1;
}

else{
		x=atol(cod);
		if(busest(alptr,x)==0){
			 gotoxy(16,15);
			 cout<<"ERROR : CODIGO NO EXISTE";
			 getch();
gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
			 goto d1;
		}
		else{   if(busmatri(alptr,x,y)==0){
		 gotoxy(16,15);
			 cout<<"ERROR : NO ESTA MATRICULADO EN ESTA MATERIA";
			 getch();
gotoxy(16,15);
		cout<<"                                                                     ";
			gotoxy(16,13);
		cout<<"                                                                     ";
			 goto d1;
		}

		else{



		long y1;
		long x1;
		char op[50];

		char nota[50];
			t:
			do{

		    gotoxy(16,15);

			 cout<<"QUE NOTA QUIERE INGRESAR?";
					    gotoxy(16,18);
			cout<<"(1) NOTA # 1";
			gotoxy(16,20);
			cout<<"(2) NOTA # 2";
			 gotoxy(16,22);
			cout<<"(3) NOTA # 3";
			gotoxy(16,30);
			cout<<"(4) REGRESAR";


			gotoxy(16,24);
			cin>>op;


		       if( validar(op)==1){
					 gotoxy(16,26);
			   cout<<"ERROR : OPCION INCORRECTA";
						getch();
			   gotoxy(16,24);
			    cout<<"                                                                                                           ";
			     gotoxy(16,26);
			    cout<<"                                                                                                           ";


			goto t;
		       }
		       else{


		       x1=atol(op);

		       if(busnota(alptr,x,y,x1)==1){
					 gotoxy(16,26);
			   cout<<"ERROR : YA EXISTE UNA NOTA LA NOTA #" <<x1;
						getch();
			   gotoxy(16,24);
			    cout<<"                                                                                                           ";
			     gotoxy(16,26);
			    cout<<"                                                                                                           ";
			goto t;
		       }

			else{
			switch(x1){
			 case 1:{
			gotoxy(16,18);
			cout<<"                                                                               ";
			gotoxy(16,20);
			cout<<"                                                                               ";
			 gotoxy(16,22);
			cout<<"                                                                         ";
			 gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
			h1:
						  gotoxy(16,18);
			  cout<<"DIGITE : LA NOTA #"<<x1;
			     gotoxy(16,20);
			     cin>>nota;

			     if(validar(nota)==1){
				 gotoxy(16,22);
				 cout<<"ERROR : DIGITE UNA NOTA CORRECTA";
				  getch();
				  gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,20);
				  cout<<"                                                                                             ";
				  goto h1;
			     }
			     else{


			     long nt;
			     nt=atol(nota);
			       crearnotas(alptr,x,y,x1,nt);
				gotoxy(16,22);
				 cout<<"NOTA INGRESADA";
				  getch();
				  gotoxy(16,20);
				  cout<<"                                                                                             ";
				   gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,18);
				  cout<<"                                                                                             ";
				   gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
			     }


			 break;
			 }
			 case 2:{


			gotoxy(16,18);
			cout<<"                                                                               ";
			gotoxy(16,20);
			cout<<"                                                                               ";
			 gotoxy(16,22);
			cout<<"                                                                         ";
			 gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
			h2:
						  gotoxy(16,18);
			  cout<<"DIGITE : LA NOTA #"<<x1;
			     gotoxy(16,20);
			     cin>>nota;

			     if(validar(nota)==1){
				 gotoxy(16,22);
				 cout<<"ERROR : DIGITE UNA NOTA CORRECTA";
				  getch();
				  gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,20);
				  cout<<"                                                                                             ";
				   gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";

				  goto h2;
			     }
			     else{


			     long nt;
			     nt=atol(nota);
			       crearnotas(alptr,x,y,x1,nt);
				gotoxy(16,22);
				 cout<<"NOTA INGRESADA";
				  getch();
				  gotoxy(16,20);
				  cout<<"                                                                                             ";
				   gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,18);
				  cout<<"                                                                                             ";
				   gotoxy(16,24);
				  cout<<"                                                                                             ";
				   gotoxy(16,26);
			cout<<"                                                                         ";
			     }


			 break;
			 }
			 case 3:{

			gotoxy(16,18);
			cout<<"                                                                               ";
			gotoxy(16,20);
			cout<<"                                                                               ";
			 gotoxy(16,22);
			cout<<"                                                                         ";
			 gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
			h3:
						  gotoxy(16,18);
			  cout<<"DIGITE : LA NOTA #"<<x1;
			     gotoxy(16,20);
			     cin>>nota;

			     if(validar(nota)==1){
				 gotoxy(16,22);
				 cout<<"ERROR : DIGITE UNA NOTA CORRECTA";
				  getch();
				  gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,20);
				  cout<<"                                                                                             ";
				   gotoxy(16,24 );
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
				  goto h3;
			     }
			     else{


			     long nt;
			     nt=atol(nota);
			       crearnotas(alptr,x,y,x1,nt);
				gotoxy(16,22);
				 cout<<"NOTA INGRESADA";
				  getch();
				  gotoxy(16,20);
				  cout<<"                                                                                             ";
				   gotoxy(16,22);
				  cout<<"                                                                                             ";
				   gotoxy(16,18);
				  cout<<"                                                                                             ";
				   gotoxy(16,24);
			cout<<"                                                                         ";
			 gotoxy(16,26);
			cout<<"                                                                         ";
			     }


			 break;
			 }

			}
			}



			}
			   }while(x1>=1 && x1<=3);
						gotoxy(16,30);
						cout<<"                                                                                 ";

		       }







		}
     }
 }

 }
 }



}



//FUNCION PARA MODIFICAR ESTUDIANTE
modiestu(alum *alptr){
    d:	system("cls");
gotoxy(24,2);
		cout<<"..::MODIFICAR ESTUDIANTE::..";
char cod[50];
long y;
gotoxy(16,7);
cout<<"DIGITE EL CODIGO DEL ESTUDIANTE";
gotoxy(16,9);
cin>>cod;
if((validar(cod))==1){
	gotoxy(16,11);
	cout<<"ERROR: CODIGO INCORRECTO";
		getch();
		goto d;
}

else{

	y=atol(cod);
	if(busest(alptr,y)==0){
	 gotoxy(16,11);
	 cout<<"ERROR : CODIGO NO EXISTE";
	 getch();
	 goto d;
	}
	else{

	      char f[50];

	  alum *r=alptr;
	  int sw=0;
	   while(r!=NULL && sw==0){
	      if(r->cod==y)
	       sw=1;
	       else
	       r=r->alsig;
	   }

	   do{
	     e:

	   system("cls");


			gotoxy(24,2);

		cout<<"..::DATOS DEL ESTUDIANTE::..";
	   gotoxy(16,7);
	 cout<<"(NO).  CODIGO -> "<<r->cod;
		   gotoxy(16,9);
	 cout<<"(1).  NOMBRE -> "<<r->nomb;
		   gotoxy(16,11);
	 cout<<"(2).  DIRECCION -> "<<r->dir;
	   gotoxy(16,13);
	 cout<<"(3).  TELEFONO -> "<<r->tel;
	   gotoxy(16,15);
	 cout<<"(4).  EMAIL -> "<<r->email;
		   gotoxy(16,19);
	 cout<<"(5).  REGRESAR";

	  gotoxy(16,21);

	 cout<<"DIGITE EL NUMERO DEL DATO A MODIFICAR(?)";
		      gotoxy(16,23);
	     cin>>f;
	     if(validar(f)==1){
	      gotoxy(16,25);
	 cout<<"ERROR : OPCION INCORRECTA";
	 getch();

	  goto e;

	 }
	 else{
	    y=atol(f);
	    if(y<1 || y>5){
		      gotoxy(16,25);
		 cout<<"ERROR : OPCION INCORRECTA";
		 getch();
		 goto e;

	    }
	    else{
	    switch(y){

	      case 1:{

			 gotoxy(16,29);
		      cout<<"                                                                   ";
				 gotoxy(16,27);
		      cout<<"                                                                   ";
		 gotoxy(16,25);
		      cout<<"                                                                   ";

			       gotoxy(16,25);
		 cout<<"DIGITE EL NUEVO NOMBRE";


			       gotoxy(16,27);
	       gets(cod);
		  strcpy(r->nomb,cod);
		   gotoxy(16,29);
		 cout<<"NOMBRE MODIFICADO";
		 getch();
		  goto e;
	      break;
	      }

	      case 2:{
	       gotoxy(16,25);
		      cout<<"                                                                   ";
			       gotoxy(16,25);
		 cout<<"DIGITE LA NUEVA DIRECCION";
		 gotoxy(16,27);
		      cout<<"                                                                   ";
			       gotoxy(16,27);

	       gets(cod);

		  strcpy(r->dir,cod);
				 gotoxy(16,29);
		      cout<<"                                                                   ";
		   gotoxy(16,29);
		 cout<<"DIRECCION MODIFICADA";
		 getch();
		  goto e;

	      break;
	      }

	      case 3:{
		    gotoxy(16,25);
		      cout<<"                                                                   ";
			       gotoxy(16,25);
		 cout<<"DIGITE EL NUEVO TELEFONO";
				 gotoxy(16,29);
		      cout<<"                                                                   ";

		p1:
				 gotoxy(16,27);
		      cout<<"                                                                   ";
		 gotoxy(16,27);

	       cin>>cod;
		if(validar(cod)==1){
		 gotoxy(16,29);
		 cout<<"ERROR : DIGITE UN TELEFONO CORRECTO";
		 getch();
		 goto p1;
		}
		else{
		long h;
		       h=atol(cod);
		  r->tel=h;
		   gotoxy(16,29);
		 cout<<"TELEFONO MODIFICADO";
		 getch();
		  goto e;

		}
	      break;
	      }

	      case 4:{
	       gotoxy(16,25);
		      cout<<"                                                                   ";
			       gotoxy(16,25);
		 cout<<"DIGITE EL NUEVO EMAIL";

				 gotoxy(16,29);
		      cout<<"                                                                   ";

		      gotoxy(16,27);
		      cout<<"                                                                   ";
			       gotoxy(16,27);
	       gets(cod);
		  strcpy(r->email,cod);
		   gotoxy(16,29);
		 cout<<"EMAIL MODIFICADO";
		 getch();
		  goto e;

	      break;
	      }


	    }


	    }
	 }
	     }while(y>=1 && y<=4);


	}




}
}



//FUNCION PARA CAPTURAR DATOS DE LAS MATERIAS

materias *capmate(materias *mtptr){
system("cls");
	char cod[50];
	char nomb[50];
	char seme[50];
    long y;

		  gotoxy(28,2);
		  cout<<"..::CREAR MATERIAS::..";
		  d:

		  gotoxy(12,7);
		  cout<<"               				                                      		             	 ";
		  gotoxy(12,7);
		  cout<<"CODIGO DE LA MATERIA->";
		  gotoxy(36,7);
		  gets(cod);
		  if(validar(cod)==1){
			       gotoxy(12,8);
			       cout<<"ERROR : ASIGNE UN CODIGO CORRECTO";
			       getch();
			       gotoxy(12,8);
			       cout<<"               				                                      		             	 ";

			  goto d;     }
		  else{
			  y=atol(cod);
			  if(busmate(mtptr,y)==1){
			   gotoxy(12,8);
			       cout<<"ERROR : EL CODIGO YA EXISTE";
			       getch();
			       gotoxy(12,8);
			       cout<<"               				                                      		             	 ";
			       goto d;            }

			   else{


			   gotoxy(12,9);
		  cout<<"NOMBRE DE LA MATERIA ->";
		  gotoxy(36,9);
		  gets(nomb);
		  gotoxy(12,11);
		  cout<<"SEMESTRE DE LA MATERIA ->";
		  gotoxy(39,11);
		  gets(seme);
				gotoxy(12,13);
				cout<<"MATERIA CREADA";
		  gotoxy(12,14);
		  mtptr=crearmate(mtptr,y, nomb,seme);
}
			  }
 getch();
return mtptr;
}

//FUNCION PARA CAPTURAR DATOS DEL ESTUDIANTE
alum *capest(alum *alptr){

system("cls");
	char cod[50];
	char nomb[50];
	char dir[50];
	char tel[50];
	char email[50];
    long y;
    long tele;



		  gotoxy(28,2);
		  cout<<"..::CREAR ESTUDIANTES::..";
		  d:

		  gotoxy(12,7);
		  cout<<"               				                                      		             	 ";
		  gotoxy(12,7);
		  cout<<"CODIGO DEL ESTUDIANTE ->";
		  gotoxy(36,7);
		  gets(cod);
		  if(validar(cod)==1){
			       gotoxy(12,8);
			       cout<<"ERROR : ASIGNE UN CODIGO CORRECTO";
			       getch();
			       gotoxy(12,8);
			       cout<<"               				                                      		             	 ";

			  goto d;     }
		  else{
					  y=atol(cod);
			  if(busest(alptr,y)==1){
			    gotoxy(12,8);
			       cout<<"ERROR : EL CODIGO YA EXISTE ";
			       getch();
			       gotoxy(12,8);
			       cout<<"                                                                     													 ";
						       goto d;

			  }




			  }
		  gotoxy(12,9);
		  cout<<"NOMBRE DEL ESTUDIANTE ->";
		  gotoxy(36,9);
		  gets(nomb);
		  gotoxy(12,11);
		  cout<<"DIRECCION DEL ESTUDIANTE ->";
		  gotoxy(39,11);
		  gets(dir);
					e:
		  gotoxy(12,13);
		  cout<<"               				                                      		             	 ";
				  gotoxy(12,13);

		  cout<<"TELEFONO DEL ESTUDIANTE ->";
			gotoxy(38,13);
			gets(tel);
			if(validar(tel)==1){
					  gotoxy(12,14);
			      cout<<"ERROR : ASIGNE UN TELEFONO CORRECTO";
			       getch();
			       gotoxy(12,14);
				cout<<"               				                                      		             	 ";
				goto e;     }
			else
				tele=atol(tel);
		  gotoxy(12,15);
		  cout<<"EMAIL DEL ESTUDIANTE ->";
		  gotoxy(36,15);
			gets(email);
		  alptr=crearestu(alptr,y,nomb,dir,tele,email);
		  gotoxy(12,17);
		  cout<<"ESTUDIANTE CREADO";
		  gotoxy(12,18);




 getch();
  return alptr;
}

//MENU ESTUDIANTES

alum *menuest(alum *alptr, materias *mtptr){
long y=-1;
char v[50];
t=1;
do{
system("cls");
gotoxy(28,2);
cout<<"..::ESTUDIANTES::..";
gotoxy(16,7);
cout<<"1. -> CREAR ESTUDIANTE...";
gotoxy(16,9);
cout<<"2. -> MODIFICAR ESTUDIANTE...";
gotoxy(16,11);
cout<<"3. -> ELIMINAR ESTUDIANTE...";
gotoxy(16,13);
cout<<"4. -> MATRICULAR MATERIA...";
gotoxy(16,15);
cout<<"5. -> REGRESAR\n";
gotoxy(16,17);

cin>>v;
if(validar(v)==1){
	gotoxy(16,19);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,20);
	getch();

 }
 else{
	y=atol(v);
	if(y<1 || y>5){
	gotoxy(16,19);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,20);
	getch();
	}
	else{
	  switch(y){
	  case 1:{
	  alptr=capest(alptr);
	  break;
	  }
	  case 2:{
	  if(alptr==NULL){
		  gotoxy(16,19);
		  cout<<"ERROR : NO EXISTE UNA LISTA DE ESTUDIANTES\n";
		gotoxy(16,20);
		getch();
	  }
	  else
	   modiestu(alptr);
	  break;
	  }
	  case 3:{
	  if(alptr==NULL){
		  gotoxy(16,19);
		cout<<"ERROR : NO EXISTE UNA LISTA DE ESTUDIANTES\n";
		gotoxy(16,20);
		getch();
	  }
	  else
		  alptr=elimvali(alptr,mtptr);
	  break;
	  }
	  case 4:{
	  if(mtptr==NULL){
		  gotoxy(16,19);
		cout<<"ERROR : NO EXISTE UNA LISTA DE MATERIAS\n";
		gotoxy(16,20);
		getch();  
	    cout<<"                                         ";
		gotoxy(16,20);}
		else{
		  if(alptr==NULL){
		  gotoxy(16,19);
		cout<<"ERROR : NO EXISTE UNA LISTA DE ESTUDIANTES\n";
		gotoxy(16,20);
		getch();  }

		else
		matricular(mtptr,alptr);
		}

	  break;
	  }

  }
  }

 }
}while(y>=1 && y<=4 || y<1 || y>5);
return alptr;
}



//MENU MATERIA

materias *menumate(alum *alptr, materias *mtptr){
long y=-1;
char v[50];
t=2;
do{
system("cls");
gotoxy(28,2);
cout<<"..::MATERIAS::..";
gotoxy(16,7);
cout<<"1. -> CREAR MATERIA...";
gotoxy(16,9);
cout<<"2. -> MODIFICAR MATERIA...";
gotoxy(16,11);
cout<<"3. -> ELIMINAR MATERIA...";
gotoxy(16,13);
cout<<"4. -> REGRESAR\n";
gotoxy(16,15);

cin>>v;
if(validar(v)==1){
	gotoxy(16,17);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,18);
	getch();
 }
 else{

	y=atol(v);
	if(y<1 || y>4){
	gotoxy(16,17);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,18);
	getch();
	}
	else{
	  switch(y){
	  case 1:{
	  mtptr=capmate(mtptr);
	  break;
	  }
	  case 2:{
	  if(mtptr==NULL){

	  gotoxy(16,17);
	cout<<"ERROR : NO EXISTE UNA LISTA MATERIAS\n";
	gotoxy(16,18);
	getch();
	  }
	  else
		  modimate(mtptr);

	  break;
	  }
	  case 3:{

		  if(mtptr==NULL){

	  gotoxy(16,17);
	cout<<"ERROR : NO EXISTE UNA LISTA MATERIAS\n";
	gotoxy(16,18);
	getch();
	  }
	  else

	  mtptr=valimat(mtptr,alptr);

	  break;
	  }

  }
  }

 }
}while(y>=1 && y<=3 || y<1 || y>4);
return mtptr;
}

//MENU CONSULTAS

menuconsul(alum *alptr, materias *mtptr){
long y=-1;
char v[50];

do{
system("cls");
gotoxy(28,2);
cout<<"..::CONSULTAS::..";
gotoxy(16,7);
cout<<"1. -> VER TODAS LAS MATERIAS DE UN ALUMNO...";
gotoxy(16,9);
cout<<"2. -> VER TODOS LOS ALUMNOS DE UNA MATERIA...";
gotoxy(16,11);
cout<<"3. -> REGRESAR\n";
gotoxy(16,13);

cin>>v;

if(validar(v)==1){
	gotoxy(16,15);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,16);
	getch();
 }
 else{
	y=atol(v);
	if(y<1 || y>3){
	gotoxy(16,15);
	cout<<"ERROR : DIGITE UN DATO CORRECTO\n";
	gotoxy(16,16);
	getch();
	}
	else{
	  switch(y){
	  case 1:{

	  if(alptr==NULL){
	  gotoxy(16,15);
	cout<<"ERROR : NO EXISTE UNA LISTA ESTUDIANTES\n";
	gotoxy(16,16);
	getch();

	  }
	  else{
	  if(mtptr==NULL){
	  gotoxy(16,15);
	cout<<"ERROR : NO EXISTE UNA LISTA MATERIAS\n";
	gotoxy(16,16);
	getch();

	  }
	  else
		  vermate(mtptr,alptr);


	  }

	  break;
	  }
	  case 2:{

	  if(mtptr==NULL){
	  gotoxy(16,15);
	cout<<"ERROR : NO EXISTE UNA LISTA MATERIAS\n";
	gotoxy(16,16);
	getch();

	  }
	  else{
	  if(alptr==NULL){
	  gotoxy(16,15);
	cout<<"ERROR : NO EXISTE UNA LISTA ESTUDIANTES\n";
	gotoxy(16,16);
	getch();

	  }
	  else
	   verest(mtptr);
	  }
	  break;
	  }

     }
   }
 }
}while(y>=1 && y<=2 || y<1 || y>3);
}

menu(alum *alptr, materias *mtptr){
long y=-1;
char v[50];
do{
system("cls");
gotoxy(25,2);
cout<<"..::SISTEMA DE INFORMACION::..";
gotoxy(16,7);
cout<<"1. -> MATERIAS...";
gotoxy(43,7);
cout<<"2. -> ESTUDIANTES...";
gotoxy(16,10);
cout<<"3. -> INGRESAR NOTAS...";
gotoxy(43,10);
cout<<"4 -> CONSULTAS...\n";
gotoxy(31,14);
cout<<"5 -> SALIR...\n";
gotoxy(35,16);
cin>>v;
if(validar(v)==1){
gotoxy(25,18);
 cout<<"ERROR : DIGITE UN VALOR CORRECTO\n";
 gotoxy(25,19);
 getch();
 }
else{
  y=atol(v);
   if(y<1 || y>5){
	gotoxy(25,18);
	cout<<"ERROR : DIGITE UN VALOR CORRECTO\n";
	gotoxy(25,18);
	getch();
   }
   else{
	switch(y){
	case 1:{
	 mtptr=menumate(alptr,mtptr);
	 break;
	 }
	 case 2:{
	 alptr=menuest(alptr,mtptr);
	 break;
	 }
	 case 3:{
	 valinotas(mtptr,alptr);
	     break;
			}
			case 4:{
				menuconsul(alptr,mtptr);
			break;}
	}
    }
}
}while(y>=1 && y<=4 || y<1 || y>5);

}
main(){
//PTR INDEPENDIENTES
alum *alptr=NULL;
materias *mtptr=NULL;
menu(alptr,mtptr);

}
