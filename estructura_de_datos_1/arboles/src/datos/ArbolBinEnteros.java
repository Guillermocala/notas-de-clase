/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author enanv
 */
public class ArbolBinEnteros
{    
   Arbin crearArbol()
   {
      Arbin raiz=new ArbinEnl(1);
      Arbin i1=new ArbinEnl(2);
      raiz.enlIzq(i1);
      Arbin i2=new ArbinEnl(3);
      raiz.enlDer(i2);
      raiz.izq().enlIzq(new ArbinEnl(4)); /*enlazar desde la raiz*/
      raiz.der().enlDer(new ArbinEnl(5));
      raiz.izq().izq().enlDer(new ArbinEnl(8));
      raiz.der().der().enlIzq(new ArbinEnl(7));        
      return raiz;
   }
   void preorden(Arbin x)
   {
      if(x != null)
      {
         System.out.println(" " + x.obtener()); /*se escribe sout y luego TAB*/
         preorden(x.izq());
         preorden(x.der());
      }
   }
   void postorden(Arbin x)
   {
      if(x != null)
      {
         postorden(x.izq());
         postorden(x.der());
         System.out.println(" " + x.obtener());
      }
   }
   void inorden(Arbin x)
   {
      if(x!=null)
      {
         inorden(x.izq());
         System.out.println(" " + x.obtener());
         inorden(x.der());
      }
   }
   int c = 0;
   void peso(Arbin x)
   {
      if(x!=null)
      {
         c++;
         peso(x.izq());
         peso(x.der());
      }
   }
   public static void main(String[] args)
   { /* se escribe psvm y luego preciono tab*/
      ArbolBinEnteros arbol = new ArbolBinEnteros();
      Arbin raiz = arbol.crearArbol();
      arbol.preorden(raiz);
      arbol.peso(raiz);      
   }
}
