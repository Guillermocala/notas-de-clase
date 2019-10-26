/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author 57300
 * @param <E>
 */
public class GrafoList<E> implements Grafo<E>, Serializable{
   LinkedList<Vertice> vertices = new LinkedList<>();   

   @Override
   public void insVertice(E x) {
      Vertice temp = new Vertice(x);
      this.vertices.add(temp);
   }

   @Override
   public E obtVertice(int pos) {
      return (E) this.vertices.get(pos);
   }

   @Override
   public void insArista(int vi, int vf, int valor) {
      Vertice temp = this.vertices.get(vi);
      temp.insArista(vf, valor);      
   }

   @Override
   public int obtArista(int vi, int vf) {
      Vertice temp = this.vertices.get(vi);
      return temp.obtArista(vf);
   }

   @Override
   public void elimArista(int vi, int vf) {
      Vertice temp = this.vertices.get(vi);
      temp.borraArista(vf);
   }

   @Override
   public int orden() {
      return this.vertices.size();
   }

   @Override
   public String mostrar() {
      String res = "";
      int i = 0;
      for (Vertice vertice : vertices) {
         res += "[" + i + "]" + vertice.showMe();
         i++;
      }
      return res;
   }
}
