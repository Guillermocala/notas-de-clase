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
   void insArista(int vi, int vf, int valor);
   int obtArista(int vi, int vf);
   void elimArista(int vi, int vf);
   int orden();
   String mostrar();
}
