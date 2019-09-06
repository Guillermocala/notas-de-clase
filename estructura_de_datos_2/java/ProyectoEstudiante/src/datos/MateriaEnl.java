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
public class MateriaEnl<E> implements Materias<E> {

   private E dato;
   private Materias<E> izq;
   private Materias<E> der;

   public MateriaEnl(E dato, Materias<E> izq, Materias<E> der) {
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
   public Materias<E> izq() {
      return izq;
   }

   @Override
   public Materias<E> der() {
      return der;
   }

   @Override
   public void enlIzq(Materias<E> x) {
      izq = x;
   }

   @Override
   public void enlDer(Materias<E> x) {
      der = x;
   }
   
}
