/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Scanner;

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
   public static void main(String[] args) /*psvm y tab*/
   {
      float num;
      boolean result;
      ArbolBusqFloat arbol = new ArbolBusqFloat();
      arbol.insertar(4);
      arbol.insertar(5);
      arbol.insertar(7);
      arbol.insertar(9);
      arbol.insertar(1);
      arbol.insertar(3);      
      System.out.println(" " + arbol.listar());
      System.out.println("Ingrese el dato a buscar: ");
      Scanner entrada = new Scanner(System.in);
      num = entrada.nextFloat();
      result = arbol.buscar(num);
      if(result)
      {
         System.out.println("Dato encontrado");
      }
      else
      {
         System.out.println("Dato no encontrado");
      }
   }
   /*porbar eliminar y buscar de los apuntes*/

   
}
