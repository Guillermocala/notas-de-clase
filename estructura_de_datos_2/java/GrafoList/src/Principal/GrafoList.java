/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.LinkedList;

/**
 *
 * @author 57300
 * @param <E>
 */
public class GrafoList<E> implements Grafo<E>{
   LinkedList<Vertice> vertices = new LinkedList<>();   

   @Override
   public void insVertice(E x) {
      this.vertices.add((Vertice) x);
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
   public E obtArista(int vi, int vf) {
      Vertice temp = this.vertices.get(vi);
      temp.getAristas()
   }

   @Override
   public void elimArista(int vi, int vf) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public int orden() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public String mostrar() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
