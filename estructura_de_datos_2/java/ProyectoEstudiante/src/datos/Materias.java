/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author 57300
 * @param <E>
 */
public interface Materias<E> {
   E obtener();
   void modificar(E x);
   Materias<E> izq();
   Materias<E> der();
   void enlIzq(Materias<E> x);
   void enlDer(Materias<E> x);    
}
