/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class GrafoImp<E> implements Grafo<E>, Serializable {
   final int limit = 100;
   private ArrayList<E> vertices = new ArrayList<>();
   private int[][] aristas = new int[limit][limit];

   public GrafoImp() {
      for (int i = 0; i < this.limit; i++) {
         for (int j = 0; j < this.limit; j++) {
            if (i != j) {
               this.aristas[i][j] = 999999;
            }
         }
      }
      
   }
   
   
   @Override
   public void insVertice(E x) {
      this.vertices.add(x);
   }

   @Override
   public E obtVertice(int pos) {
      return this.vertices.get(pos);
   }

   @Override
   public void insArista(int vi, int vf, int dato) {
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         this.aristas[vi][vf] = dato;
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor de vertices incorrecto!");
      }
   }

   @Override
   public int obtArista(int vi, int vf) {
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         return this.aristas[vi][vf];
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor de vertices incorrecto!");
         return 0;
      }
   }

   @Override
   public void elimArista(int vi, int vf) {
      if ((vi > -1 && vi < this.vertices.size()) && (vf > -1 && vf < this.vertices.size()) && (vi != vf)) {
         this.aristas[vi][vf] = 999999;
      }
      else {
         JOptionPane.showMessageDialog(null, "Valor de vertices incorrecto!");
      }
   }

   @Override
   public int orden() {
      return this.vertices.size();
   }

   @Override
   public String mostrar() {
      String res = "";
      for (int i = 0; i < orden(); i++) {
         res += "Vertice: " + this.vertices.get(i) + " ";
         for (int j = 0; j < orden(); j++) {
            res += this.aristas[i][j] + " ";
         }
         res += "\n";
      }
      return res;
   }

   @Override
   public ArrayList<E> sucesores(int pos) {
      ArrayList<E> res = new ArrayList<>();
      for (int i = 0; i < orden(); i++) {
         if (this.aristas[pos][i] != 999999 && this.aristas[pos][i] != 0)   {
            res.add(this.vertices.get(i));
         }
      }
      return res;
   }

   @Override
   public ArrayList<E> antecesores(int pos) {
      ArrayList<E> res = new ArrayList<>();
      for (int i = 0; i < orden(); i++) {
         if (this.aristas[i][pos] != 999999 && this.aristas[i][pos] != 0)   {
            res.add(this.vertices.get(i));
         }
      }
      return res;
   }
}
