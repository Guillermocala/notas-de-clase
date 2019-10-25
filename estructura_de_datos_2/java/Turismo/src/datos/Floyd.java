/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author 57300
 */
public class Floyd {
   private int f[][]; //<--- GUARDA COSTO
   private int r[][]; //<--- GUARDA RUTA
   private Grafo<Integer> g;
   
   public Floyd(Grafo<Integer> g) { 
      int n = g.orden();
      f = new int [n][n];
      r = new int [n][n];
      this.g = g;
      inicializar();
   }
   public void inicializar() {
      for (int i = 0; i < f.length; i++) {
         for (int j = 0; j < f.length; j++) {            
            r[i][j] = -1;
            f[i][j] = g.obtArista(i, j);
         }
      }
   }
   public void caminoMinimo() {
      for (int i = 0; i < g.orden(); i++) {
         for (int j = 0; j < g.orden(); j++) {
            for (int k = 0; k < g.orden(); k++) {               
               int valor = f[j][i] + f[i][k];
               if (valor < f[j][k]) {
                  f[j][k] = valor;
                  r[j][k] = i;
               }
            }
         }
      }
   }
   public int costoMinimo(int vi, int vf) { 
      return f[vi][vf];
   }
   public void ruta(int vi, int vf) { 
      int k = r[vi][vf];
      if (k != -1) {
         ruta(vi, k);
         System.out.println(" " + k);
         ruta(k, vf);
      }
   }
}
