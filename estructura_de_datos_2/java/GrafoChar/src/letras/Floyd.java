/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letras;

import Principal.Grafo;
import Principal.GrafoMatr;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Floyd {
   private int f[][];
   private int r[][];
   private Grafo<Integer> g;

   public Floyd(Grafo<Integer> g) {
      int n = g.orden();
      f = new int[n][n];
      r = new int[n][n];      
      this.g = g;
      inicializar();
   }
   public void inicializar(){ 
      for (int i = 0; i < f.length; i++) {
         for (int j = 0; j < f.length; j++) {
            r[i][j] = -1;
            f[i][j] = g.obtArista(i, j);
         }
      }
   }
   public void caminoMinimo(){ 
      for (int k = 0; k < g.orden(); k++) {
         for (int i = 0; i < g.orden(); i++) {
            for (int j = 0; j < g.orden(); j++) {
               int valor = f[i][k] + f[k][j];
               if(valor < f[i][j]){ 
                  f[i][j] = valor;
                  r[i][j] = k;
               }
            }
         }
      }      
   }
   public int costoMinimo(int vi, int vf){ 
      return f[vi][vf];
   }
   public void ruta(int vi, int vf){ 
      int k = r[vi][vf];
      if(k != -1){ 
         ruta(vi, k);
         System.out.println(" " + k);
         ruta(k, vf);
      }
   }
   public static void main(String[] args) {
      Grafo<Integer> tryit = new GrafoMatr<>();
      tryit.insVertice(0);
      tryit.insVertice(1);
      tryit.insVertice(2);
      tryit.insVertice(3);
      tryit.insArista(0, 1, 2);
      tryit.insArista(0, 2, 7);
      
      String temp = tryit.mostrar();
      JOptionPane.showMessageDialog(null, temp);
   }
}
