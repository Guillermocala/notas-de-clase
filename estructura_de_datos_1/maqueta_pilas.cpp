#include "iostream"
using namespace std;

struct Nodo
{
    int info;
    Nodo *sig;
};
Nodo *InicPila(int tope);
Nodo *AdicPila(int tope, int elem);
int InfoPila(int tope);
Nodo *ElimPila(int tope);
bool PilaVacia(int tope);

int main()
{






    return 0;
}
Nodo *InicPila(int tope)
{
    tope = NULL;
    return tope;
}
Nodo *AdicPila(int tope, int elem)
{
    Nodo *p;
    p = (struct Nodo*) malloc (sizeof (Nodo));
    p->info = elem;
    if(tope == NULL)
    {
        tope = p;
        p->sig = NULL;
    }
    else
    {
        p->sig = tope;
        tope = p;
    }
    return tope;
}
int InfoPila(int tope)
{
    int value;
    value = tope->info;
    return value;
}
Nodo *ElimPila(int tope)
{
    int j = tope;
    tope = tope->sig;
    free(j);
    return tope;
}
bool PilaVacia(int tope)
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
