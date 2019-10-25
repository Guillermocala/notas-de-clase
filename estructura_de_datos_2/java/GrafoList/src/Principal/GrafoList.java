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
   public void insArista(E vf, int valor) {
      Vertice asd = this.vertices.get(valor);
      asd.insAristas((Vertice) vf, valor);      
   }

   @Override
   public E obtArista(E vf) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void elimArista(E vf) {
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
