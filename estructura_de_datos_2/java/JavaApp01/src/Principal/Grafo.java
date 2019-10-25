/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public interface Grafo<E> {
   void insVertice(E var1);
   E obtVertice(int var1);
   void insArista(int var1, int var2, int var3);
   int obtArista(int var1, int var2);
   void elimArista(int var1, int var2);
   int orden();
   ArrayList<E> sucesores(int var1);
   String mostrar();
}
