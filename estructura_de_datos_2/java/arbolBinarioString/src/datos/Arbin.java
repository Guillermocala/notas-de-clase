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
public interface Arbin<E> {
   E obtener();
   void modificar(E x);
   Arbin<E> izq();
   Arbin<E> der();
   void enlIzq(Arbin<E> x);
   void enlDer(Arbin<E> x);    
}
