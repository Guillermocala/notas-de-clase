/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 57300
 * @param <E>
 */
public interface Grafo<E> {
   void insVertice(E x);
   E obtVertice(int pos);
   void insArista(E vf, int valor);
   E obtArista(E vf);
   void elimArista(E vf);
   int orden();
   String mostrar();
}
