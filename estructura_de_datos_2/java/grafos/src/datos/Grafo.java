/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author 57300
 * @param <E>
 */
public interface Grafo<E> {
   void insVertice(E x);
   E obtVertice(int pos);
   void insArista(int vI, int vF, int dato);
   int obtArista(int vI, int vF);
   void elimArista(int vI, int vF);
   int orden(); //num vertices del grafo
   ArrayList<E> sucesores(int pos); //vector, estructura estatica. LinkedList es lista doblemente enlazada y es dinamica
   String mostrar();
   int inf = 999999;
}
