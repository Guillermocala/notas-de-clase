/*
    Autor: Joel Cesar Fernandez Segura
    Curso: Estructura de Datos
    Ejercicio: REGISTRAR PACIENTES
    IDE: CodeBlocks
    Pagina Web: http://codebotic.blogspot.com
*/

#include<iostream>
#include<cstdlib>
#include<string.h>
#define maxchar 50

using namespace std;


struct nodo{

    int codigo;     // campo codigo
    char nombres[maxchar]; // campo que almacena el nombre
    char apellidos[maxchar];// campo que almacena el apellido
    char direccion[maxchar];// campo que almacena la direccion
    int telefono;// campo que almacena el telefono
    struct nodo *sgte;

};


typedef struct nodo *PLista;

/*--------------------- FUNCION MENU PRINCIPAL --------------------*/
void menu(void){

    cout<<"\n\t\t[    REGISTRO DE PACIENTES    ]\n";
    cout<<"\t\t----------------------------\n\n";
    cout<<" 1. REGISTRAR PACIENTE                          "<<endl;
    cout<<" 2. ELIMINAR DATOS DE PACIENTE                  "<<endl;
    cout<<" 3. ACTUALIZAR PACIENTES                        "<<endl;
    cout<<" 4. MOSTRAR LISTADO                             "<<endl;
    cout<<" 5. COPIAR DATOS DE UN PACIENTE A OTRO          "<<endl;
    cout<<" 6. SALIR                                       "<<endl;

    cout<<"\n Ingrese opcion : ";
}


/*----------------- CUNCION PARA ACTUALIZAR UN DATO---------------*/
void menu_actualizar(void){

    cout<<"\n\t\t[    ESPECIFIQUE CAMPO A ACTUALIZAR    ]\n";
    cout<<"\t\t----------------------------\n\n";
    cout<<" 1. NOMBRES                       "<<endl;
    cout<<" 2. APELLIDOS                     "<<endl;
    cout<<" 3. DIRECCION                     "<<endl;
    cout<<" 4. TELEFONO                      "<<endl;
    cout<<" 5. SALIR                         "<<endl;

    cout<<"\n Ingrese opcion : ";
}


/*-------------------- FUNCION REGISTRAR PACIENTES ------------------*/
void registrar_pacientes(PLista &lista){

    PLista t,q = new(struct nodo);

    cout<<"\n\n\t\t[  REGISTRO  ]\n";
    cout<<"\t\t------------";
    cout<<"\n\tDATOS DEL PACIENTE ";
    cin.ignore();cout<<"\n\n\tCODIGO:"; cin>>q->codigo;
    cin.ignore();cout<<"\n\tNOMBRES:"; cin.getline(q->nombres,maxchar);
    cin.ignore();cout<<"\tAPELLIDOS:"; cin.getline(q->apellidos,maxchar);
    cin.ignore();cout<<"\tDIRECCION:"; cin.getline(q->direccion,maxchar);
    cin.ignore();cout<<"\n\tTELEFONO:"; cin>>q->telefono;

    system("cls");

    q->sgte = NULL;

    if(lista==NULL){

        lista = q;

    } else {

        t = lista;

        while(t->sgte!=NULL){

                t = t->sgte;
        }

        t->sgte = q;

    }
}

/*------------------------ FUNCION ELIMINAR PACIENTE ---------------------*/
void eliminar_paciente(PLista &lista){

    int cod;
    PLista q,t;
    q=lista;

    cout<<"\n\n\n\tELIMINAR UN PACIENTE";
    cout<<"\n\n\tINGRESE CODIGO:"; cin>>cod;

    while(q!=NULL){

            if(q->codigo==cod){

                if(q==lista)
                    lista=lista->sgte;

                else
                    t->sgte=q->sgte;

                delete(q);

                cout<<"\n\n\tREGISTRO ELIMINADO...!!!!!\n";

                return;

            }else {

                t=q;
                q=q->sgte;

        }

    }
    if(q==NULL)
        cout<<"\n\tCODIGO INCORRECTO...!!\n";

}


/*-------------------- FUNCION ACTUALIZAR PACIENTE -------------------*/
void actualizar_paciente(PLista lista){

    int cod, x;
    PLista q;
    q=lista;

    cout<<"\n\n\n\tACTUALIZAR REGISTRO DE PACIENTE";
    cout<<"\n\n\tINGRESE CODIGO:"; cin>>cod;

    while(q!=NULL){

            if(q->codigo==cod){
                system("cls");
                cout<<"\n\tDATOS DEL PACIENTE  ";
                cout<<"\n\t--------------------";
                cout<<"\n\n\tCODIGO   : "<<q->codigo<<endl;
                cout<<"\n\tNOMBRES  : "<<q->nombres<<endl;
                cout<<"\tAPELLIDOS: "<<q->apellidos<<endl;
                cout<<"\tDIRECCION: "<<q->direccion<<endl;
                cout<<"\tTELEFONO : "<<q->telefono<<endl;

                menu_actualizar();
                cin>>x;

                switch(x){

                    case 1: cout<<"\n\n\tINGRESE NOMBRES:";
                            cin.ignore(); cin.getline(q->nombres,maxchar);
                            break;

                    case 2: cout<<"\n\n\tINGRESE APELLIDOS:";
                            cin.ignore(); cin.getline(q->apellidos,maxchar);
                            break;

                    case 3: cout<<"\n\n\tINGRESE DIRECCION:";
                            cin.ignore(); cin.getline(q->direccion,maxchar);
                            break;

                    case 4: cout<<"\n\n\tINGRESE TELEFONO:";
                            cin>>q->telefono;
                            break;

                    default: cout<<"\nINGRESE UNA OPCION VALIDA...\n"; break;

                }
                cout<<"\n\n\tREGISTRO ACTUALIZADO...!!!!!\n";

                return;

            }else {


                q=q->sgte;

        }

    }
    if(q==NULL)
        cout<<"\n\tCODIGO INCORRECTO...!!\n";
}


/*---------------------- FUNCION MOSTRAR PACIENTE -------------------*/
void mostrar_pacientes(PLista q){

    int i=1;

    while(q!=NULL){

        cout<<"\n\tDATOS DEL PACIENTE ["<<i<<"] ";
        cout<<"\n\t------------------------";
        cout<<"\n\n\tCODIGO   : "<<q->codigo<<endl;
        cout<<"\n\tNOMBRES  : "<<q->nombres<<endl;
        cout<<"\tAPELLIDOS: "<<q->apellidos<<endl;
        cout<<"\tDIRECCION: "<<q->direccion<<endl;
        cout<<"\tTELEFONO : "<<q->telefono<<endl;

        q=q->sgte;

        i++;
    }

}

/*--------------- FUNCION COPIAR DATOS DE UN PACIENTEA OTRO ------------------*/
void copiar_datos_paciente(PLista lista){

    int cod1,cod2, x;
    PLista p,q,t;
    p=lista;
    q=lista;
    char dato[maxchar];

    cout<<"\n\n\n\tCOPIAR DATOS DE PACIENTE A OTRO";
    cout<<"\n\n\n\t--------------------------------";
    cout<<"\n\n\tINGRESE CODIGO DE PACIENTE A COPIAR:"; cin>>cod1;
    cout<<"\n\n\tINGRESE CODIGO DE PACIENTE A SUSTITUIR:";cin>>cod2;
    system("cls");

    while(p!=NULL){

            if(p->codigo==cod1){
                t=p;
                cout<<"\n\tDATOS DEL PACIENTE  COPIAR ";
                cout<<"\n\t---------------------------";
                cout<<"\n\n\tCODIGO   : "<<p->codigo<<endl;
                cout<<"\n\tNOMBRES  : "<<p->nombres<<endl;
                cout<<"\tAPELLIDOS: "<<p->apellidos<<endl;
                cout<<"\tDIRECCION: "<<p->direccion<<endl;
                cout<<"\tTELEFONO : "<<p->telefono<<endl;

            }
                p=p->sgte;

        }
    while(q!=NULL){

            if(q->codigo==cod2){

                cout<<"\n\tDATOS DEL PACIENTE A SUSITUIR ";
                cout<<"\n\t--------------------";
                cout<<"\n\n\tCODIGO   : "<<q->codigo<<endl;
                cout<<"\n\tNOMBRES  : "<<q->nombres<<endl;
                cout<<"\tAPELLIDOS: "<<q->apellidos<<endl;
                cout<<"\tDIRECCION: "<<q->direccion<<endl;
                cout<<"\tTELEFONO : "<<q->telefono<<endl;

                menu_actualizar();
                cin>>x;

                switch(x){

                    case 1: strcpy(dato,t->nombres);
                            strcpy(q->nombres,dato);
                            break;

                    case 2: strcpy(dato,t->apellidos);
                            strcpy(q->apellidos,dato);
                            break;

                    case 3: strcpy(dato,t->direccion);
                            strcpy(q->direccion,dato);
                            break;

                    case 4: q->telefono=t->telefono;
                            break;

                    default: cout<<"\nINGRESE UNA OPCION VALIDA...\n"; break;

                }
                cout<<"\n\n\tREGISTRO ACTUALIZADO...!!!!!\n";

                return;

            }else {


                q=q->sgte;

        }

    }

    if(q==NULL)
        cout<<"\n\tCODIGO INCORRECTO...!!\n";

}

/*------------------------- FUNCION PRINCIPAL -------------------*/
int main(void){

    system("color 0a");

    PLista lista=NULL;

    int opcion;

    do{
            menu();
            cin>>opcion;

            switch(opcion){

                case 1: registrar_pacientes(lista);
                        break;

                case 2: if(lista==NULL){

                            cout<"\n\tNo Hay Pacientes Registrados.....!!!!\n";

                        }else{

                            eliminar_paciente(lista);

                        }
                        break;

                case 3: if(lista==NULL){

                            cout<"\n\tNo Hay Pacientes Registrados.....!!!!\n";

                        }else{

                            actualizar_paciente(lista);

                        }
                        break;

                case 4: if(lista==NULL){

                            cout<"\n\tNo Hay Pacientes Registrados.....!!!!\n";

                        }else {

                            mostrar_pacientes(lista);

                        }
                        break;

                case 5: if(lista==NULL){

                            cout<"\n\tNo Hay Pacientes Registrados.....!!!!\n";

                        }else{

                            copiar_datos_paciente(lista);

                        }
                        break;

                case 6: return 0;


                default: cout<<"\nINGRESE UNA OPCION VALIDA...\n"; break;

            }

            system("pause");  system("cls");

        }while(opcion!=6);

    system("pause");

    return 0;
}
