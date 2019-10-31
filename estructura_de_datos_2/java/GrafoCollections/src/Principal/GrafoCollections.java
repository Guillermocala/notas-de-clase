/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 * @param <E>
 */
public class GrafoCollections<E> implements Grafo<E>, Serializable{
   ArrayList<Vertice> vertices = new ArrayList<>();
   
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
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         Vertice temp = this.vertices.get(vi);
         temp.insArista(vf, valor);
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor incorrecto!");
      }
   }

   @Override
   public int obtArista(int vi, int vf) {
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         Vertice temp = this.vertices.get(vi);
         return temp.obtArista(vf);
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor incorrecto!");
         return 0;
      }
   }

   @Override
   public void elimArista(int vi, int vf) {
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         Vertice temp = this.vertices.get(vi);
         temp.borraArista(vf);
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor incorrecto!");
      }
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
