/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author 57300
 */
public class PlataformaImpl<E> implements TadMaterias<E> {
   E dato;
   TadMaterias<E> izq;
   TadMaterias<E> der;

   public PlataformaImpl(E dato) {
      this.dato = dato;
   }
   
   @Override
   public E obtener() {
      return dato;
   }

   @Override
   public void modificar(E x) {
      dato = x;
   }

   @Override
   public TadMaterias<E> izq() {
      return izq;
   }

   @Override
   public TadMaterias<E> der() {
      return izq;
   }

   @Override
   public void enlIzq(TadMaterias<E> x) {
      izq = x;
   }

   @Override
   public void enlDer(TadMaterias<E> x) {
      der = x;
   }     
       
}
