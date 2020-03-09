/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;

/**
 *
 * @author 57300
 * @param <E>
 */
public class ArbinImp<E> implements Arbin<E>, Serializable{
   
   private E dato;
   private Arbin<E> izq;
   private Arbin<E> der;

   public ArbinImp(E dato) {
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
   public Arbin<E> izq() {
      return izq;
   }

   @Override
   public Arbin<E> der() {
      return der;
   }

   @Override
   public void enlIzq(Arbin<E> x) {
      izq = x;
   }

   @Override
   public void enlDer(Arbin<E> x) {
      der = x;
   }
   
}
