/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class ArbolBusqFloat
{
   private Arbin<Float> raiz;   
   public void insertar(float x)
   {
      if(raiz == null)
      {
         raiz = new ArbinEnl<>(x);
      }
      else
      {
         insertar(raiz, x);
      }
   }
   private void insertar(Arbin<Float> raiz, float x)
   {
      if(x < raiz.obtener())
      {
         if(raiz.izq() == null)
         {
            raiz.enlIzq(new ArbinEnl<>(x));
         }
         else
         {
            insertar(raiz.izq(), x);
         }
      }
      else
      {
         if(raiz.der() == null)
         {
            raiz.enlDer(new ArbinEnl<>(x));
         }
         else
         {
            insertar(raiz.der(), x);
         }
      }
   }
   String res = " ";
   public String listar()
   {
      res = "";
      inorden(raiz);
      return res;
   }
   private void inorden(Arbin<Float> raiz)
   {
      if(raiz != null)
      {
         inorden(raiz.izq());
         res += " " + raiz.obtener();
         inorden(raiz.der());
      }
   }
   public boolean buscar(float x)
   {
      if(raiz == null)
      {
         return false;
      }
      else
      {
         return buscar(raiz, x);
      }
   }
   private boolean buscar(Arbin<Float> raiz, float x)
   {
      if(raiz.obtener() == x)
      {
         return true;
      }
      else
      {
         if(x < raiz.obtener())
         {
            if(raiz.izq() == null)
            {
               return false;
            }
            else
            {
               return buscar(raiz.izq(), x);
            }
         }
         else
         {
            if(raiz.der() == null)
            {
               return false;
            }
            else
            {
               return buscar(raiz.der(), x);
            }
         }
      }
   }
   public void eliminar(float x)
   {
      if(buscar(x))
      {
         raiz = eliminar(raiz, x);
      }
   }
   private Arbin eliminar(Arbin<Float> r, float x)
   {
      if(x == r.obtener())
      {
         return borrar(r, x);
      }
      else
      {
         if(x < r.obtener())
         {
            r.enlIzq(eliminar(r.izq(), x));
         }
         else
         {
            r.enlDer(eliminar(r.der(), x));
         }
         return r;
      }
   }
   public Arbin mayor(Arbin<Float> r)
   {
      if(r.der() != null)
      {
         return mayor(r.der());
      }
      else
      {
         return r;
      }
   }
   private Arbin borrar(Arbin<Float> r, float x)
   {
      if(r.izq() == null && r.der() == null)
      {
         return null;
      }
      else
      {
         if(r.izq() == null)
         {
            return r.der();
         }
         else
         {
            if(r.der() == null)
            {
               return r.izq();
            }
            else
            {
               Arbin remp = mayor(r.izq());
               r.modificar((Float) remp.obtener());
               r.enlIzq(eliminar(r.izq(), (float) remp.obtener()));
               return r;
            }
         }
      }
   }
   public static void main(String[] args) /*psvm y tab*/
   {
      
      ArbolBusqFloat arbol = new ArbolBusqFloat();
      //hacer promedio de datos, mayor
      
      String menu = "1.Insertar \n2.Listar \n3.Buscar \n4.Eliminar \n5.Salir";
      /*JOP tab primera opcion*/      
      salir:do
      {
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);
         switch(op)
         {
            case 1:
               String num = JOptionPane.showInputDialog("Digite numero: ");
               float numero = Float.parseFloat(num);
               arbol.insertar(numero);
               break;
            case 2:
               String aqui = arbol.listar();
               JOptionPane.showMessageDialog(null, aqui);               
               break;
            case 3:
               String parabuscar = JOptionPane.showInputDialog("Digite el numero a buscar: ");
               float buscareal = Float.parseFloat(parabuscar);
               if(arbol.buscar(buscareal))
               {
                  JOptionPane.showMessageDialog(null, "Dato encontrado");
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Dato no encontrado");
               }
               break;
            case 4:
               String parabuscar2 = JOptionPane.showInputDialog("Digite el numero a eliminar: ");
               float buscareal2 = Float.parseFloat(parabuscar2);               
               if(arbol.buscar(buscareal2))
               {                  
                  arbol.eliminar(buscareal2);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Dato no encontrado");
               }                                            
               break;
            case 5:                            
               break salir;
         }            
      }while(true);

   }
   /*porbar eliminar y buscar de los apuntes*/
   

   
}
