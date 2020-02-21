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
public class ArbinEnl implements Arbin
{
   private int dato;
   private Arbin izq;
   private Arbin der;
   public ArbinEnl(int dato)
   {
      this.dato = dato;
   }        
   @Override
   public int obtener()
   {
      return dato;
   }
   @Override
   public void modificar(int x)
   {
      dato = x;
   }
   @Override
   public Arbin izq()
   {
      return izq;
   }
   @Override
   public Arbin der()
   {
      return der;
   }
   @Override
   public void enlIzq(Arbin x)
   {
      izq = x;
   }
   @Override
   public void enlDer(Arbin x)
   {
      der = x;
   }
}
