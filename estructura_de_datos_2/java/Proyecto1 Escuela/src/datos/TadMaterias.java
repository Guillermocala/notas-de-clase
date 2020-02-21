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
public interface TadMaterias<E> {
   E obtener();
   void modificar(E x);
   TadMaterias<E> izq();
   TadMaterias<E> der();
   void enlIzq(TadMaterias<E> x);
   void enlDer(TadMaterias<E> x);    
}
