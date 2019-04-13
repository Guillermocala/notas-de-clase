/*Se obtanar√° por este m√©todo de funciones. 

Lista 1: [CC]->[Nombre]->[Fecha_de_nacimiento]->[Departamento_laboral]->[new_cc]->.....
Lista 2: [CC]->[concepto]->[Valor_del_concepto]->[New_cc]->...
Falta la funciÛn para terminar de llenar la lista dos, uniendo los nodos como se muestra en el 
ejemplo. Evitar hacer [cc]->[cc]->[cc]->NULL porque est√° mal. Se crear√≠an m√°s de dos listas*/

#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

using namespace std;


void gotoxy(int x, int y){
	
	HANDLE hCon;
	hCon= GetStdHandle(STD_OUTPUT_HANDLE);
	COORD dwPos;
	dwPos.X=x;
	dwPos.Y=y;
	SetConsoleCursorPosition(hCon, dwPos);
	
}

struct Datos{
	long int cedula;
	char nombre[30];
	int fechaNac[3];
	char departamento[20];
	Datos *sig;

	long int cedul;
	int cpt;
	long valcpt;
	Datos *next;

};


Datos* ptra=NULL, *l, *r,*y;
Datos* ptrb=NULL, *m, *h;

int rep=0;

Datos* insertarcedula(Datos *p,long int numero);
long int EsUnNumero(char numero[12]);
Datos* insertarnombre(Datos *p,char name[]);
Datos* nacimiento(Datos*p, int nac[]);
Datos* insertardepart(Datos*p,char dpta[]);

Datos* CopiarCC(Datos *a, long int ced);
Datos* Financiero(Datos *a, long int cto);
Datos* Buscarllave(Datos *ptrb, long int elem);
Datos* ValorCpt(Datos *a, float val);

void  Mostrar (Datos *ptrb);

void insertarinfo(Datos*p, Datos *k);
void mostrarinfo(Datos *p);
void insertarCpt();
int menu(void);

int main(int argc, char const *argv[])
{
	system("CLS");
	int sw=1;
	int n,j,i;

	long opcion,num;
	do
	{
		switch (menu())						
		{
			case 1:
				system("CLS");
				insertarinfo(ptra, ptrb);	
	            break;
			case 2:
				system("cls");
				mostrarinfo(ptra);
				getch();
				break;
			case 3: 
				Mostrar(ptrb);
				break;
			case 4:
				insertarCpt();
				break;			
		    case 0:
       	        system ("CLS");
                system("pause");
				sw=0;
                break;
			default:
				system("cls");
                cout<<"opcion no valida...por favor intente nuevamente\n";
                getch();
                break;    
		}
	}while(sw);

	getch();
}
int menu (void){
	int opcion;
	system("CLS");
	system ("color 0B");
	   
	cout<<"\t\t\t≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤             NOMINA            ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤  1-> Ingrese informacion      ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤  2-> Mostrar informacion      ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤  3-> Mostrar lista b          ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤  4-> Ingresar datos           ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤      financieros.             ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤  0-> Salir                    ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤                               ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤       Elija una opcion:       ≤≤≤≤\n";
	cout<<"\t\t\t≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤≤\n";
	gotoxy(52,16); cout<<" "; cin>>opcion;
	
	   return opcion;
} 

Datos* insertarcedula(Datos *p,long numero)
{
	
	p=(struct Datos*) malloc(sizeof (Datos));
	p->cedula=numero;
	if(ptra==NULL)
	{
		ptra=p;
		ptra->sig=NULL;
	}
	else
	{
		l=ptra;
		while(l->sig!=NULL or l->cedula==p->cedula)
		{
			if(l->cedula==p->cedula)
			{
				cout<<"Este numero de cedula ya fue ingresado"<<endl;
				rep=1;
				getch();
				return ptra;
			}
			else
			{
				l=l->sig;
			}
		}
		l->sig=p;
		p->sig=NULL;
		
	}
	return ptra;
}

Datos* insertarnombre(Datos*p,char name[])
{
	p=(struct Datos*) malloc(sizeof (Datos));
	strcpy(p->nombre,name);

		l=ptra;
		while(l->sig!=NULL)
		{
			l=l->sig;
		}
		l->sig=p;
		p->sig=NULL;
	return ptra;
}

void mostrarinfo(Datos *p)
{
	y=ptra;
	int i=1;
	while(y!=NULL)
	{   
		cout<<"Trabajador "<<i<<". --------------> "<<y->cedula<<endl;
		y=y->sig;
		cout<<"Nombre--------------> "<<y->nombre<<endl;
		y=y->sig;
	    cout<<"Fecha de nacimiento-> ";
	    cout<<y->fechaNac[1]<<"/"<<y->fechaNac[2]<<"/"<<y->fechaNac[3]<<endl;
	    y=y->sig;
		cout<<"Departamento--------> "<<y->departamento<<endl;
		y=y->sig;
		i++;
		cout<<"\n\n";
	}
}
Datos* nacimiento(Datos*p,int nac[])
{
	p=(struct Datos*) malloc(sizeof (Datos));
	for(int i=0;i<3;i++)
	{
		p->fechaNac[i+1]=nac[i+1];
	}
	l=ptra;
	while(l->sig!=NULL)
	{
	l=l->sig;
	}
	l->sig=p;
	p->sig=NULL;
	return ptra;
}

Datos* insertardepart(Datos*p,char dpta[])
{
	p=(struct Datos*)malloc (sizeof (Datos));
	strcpy(p->departamento,dpta);
	l=ptra;
	while(l->sig!=NULL)
	{
		l=l->sig;
	}
	l->sig=p;
	p->sig=NULL;
	return ptra;	
}

void insertarinfo(Datos*p, Datos *k)
{
	char name[30],dpt[20];
	int fecha[3]; 
	long int nume;
	char num[12];
	rep=0;
	cout<<"ingrese la cedula: ";
	getchar();
	cin.getline(num, 12, '\n');
	
	nume=EsUnNumero(num);
	insertarcedula(ptra,nume);
	if(rep==0)
	{
		CopiarCC(ptrb, nume);
		fflush(stdin);
		cout<<"ingrese el nombre: ";
		cin.getline(name,30,'\n');
		insertarnombre(ptra,name);
		cout<<"Ingrese la fecha de nacimento: "<<endl;
		cout<<"Dia: ";
		cin>>fecha[1];
		cout<<"Numero del Mes: ";
		cin>>fecha[2];
		cout<<"Anho: ";
		cin>>fecha[3];
		while(fecha[3]>=2001){
			cout<<"Error en el ingreso del anho. Intentlo de nuevo: "<<endl;
			cin>>fecha[3];
		}
		nacimiento(ptra,fecha);
		fflush(stdin);
		cout<<"ingrese departamento: ";
		cin.getline(dpt,20,'\n');
	    insertardepart(ptra,dpt);
	}
}
Datos* CopiarCC(Datos *k, long ced){
	k=(struct Datos *) malloc (sizeof (Datos));
	k->cedul=ced;
	Datos *aux;
	if(k==NULL){
		ptrb=k;
		ptrb->next=NULL;
	}
	else{
		k->next=ptrb;
		ptrb=k;
	}
	return ptrb;
}


void  Mostrar (Datos *ptrb){
    system ("CLS");
	h=ptrb;
    while(h!=NULL){
      	cout<<"Cedula ------>"<<h->cedul<<endl;
    	h=h->next;
    	cout<<"Concepto-----> "<<h->cpt<<endl;
		h=h->next;
		cout<<"Valor del concepto----> "<<h->valcpt<<"\n";
		h=h->next;
	}
	system("pause");
}

long int EsUnNumero(char numero[12]){
	char number[12];
	strcpy(number, numero);
	long int entero=1;
	if(strlen(number)==0){
		cout<<"El campo esta vacio. Intentelo de nuevo: ";
		cin.getline(number, 12, '\n');
		EsUnNumero(number);
	}
	
	for (int i =0; i<strlen(number); i++){
		if (!(isdigit(number[i]))){
			entero=0;
		}
	}
	
	if(entero==0){
		cout<<"No es un numero entero. Ingreselo nuevamente: ";
		cin.getline(number, 12, '\n');
		EsUnNumero(number);
	}
	else {
		entero=atoi(number);
	}
	return entero;
}

Datos* Financiero(Datos *a, long int cto){
	system("cls");
	a=(struct Datos *) malloc (sizeof (Datos));
	if(cto<=299){
		a->cpt=1;
		cout<<"todo funciona hasta aqui";
		system("pause");
	}
	else{
		a->cpt=2;
	}
	m=ptrb;
	while(m->sig!=NULL)
	{
		m=m->sig;
	}
	m->next=a;
	m->next=NULL;
	return ptrb;
}

Datos* ValorCpt(Datos *a, float val){
	a=(struct Datos *)malloc(sizeof (Datos));
	a->valcpt=val;
	m=ptrb;
	while(a->sig!=NULL)
	{
		m=m->sig;
	}
	m->next=a;
	m->next=NULL;
	return ptrb;
}
void insertarCpt(){
	char verif[12];
	int concep;
	float valor;
	cout << "ingrese la cedula del trabajador: ";
	getchar();
	cin.getline(verif, 12, '\n');
	if(verif == ){
		cout<<"Ingrese el concepto asociado.\n";
		cout<<"100 a 299-> Devengado.\n300 a 500->Deduccion\n Digite una opcion: ";
		cin>>concep;
		while(concep>500||concep<100)
		{
			cout<<"Error. Intentelo de nuevo: ";
			cin>>concep;
		}
		Financiero(ptrb, concep);
		cout<<"Ingrese el valor del concepto asociado: ";
		cin>>valor;
		ValorCpt(ptrb, valor);								    
	}
	else{
		
	}
}
