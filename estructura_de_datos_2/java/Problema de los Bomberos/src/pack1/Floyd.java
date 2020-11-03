/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import pack1.Barrio;
import pack1.GrafoImp;

/**
 *
 * @author 57300
 */
public class Floyd {
   private int f[][];   /*GUARDA COSTO*/
   private int r[][];   /*GUARDA RUTA*/
   private GrafoImp<Barrio> g;
   
   public Floyd(GrafoImp<Barrio> g) {
      int n = g.orden();
      f = new int[n][n];
      r = new int[n][n];
      this.g = g;
      Inicializar();
   }
   public void Inicializar() {
      for (int i = 0; i < f.length; i++) {
         for (int j = 0; j < f.length; j++) {
            if (i != j) {
               r[i][j] = -1;
               f[i][j] = g.obtArista(i, j);
            }
         }
      }
   }
   public void CaminoMinimo() {
      for (int k = 0; k < g.orden(); k++) {
         for (int i = 0; i < g.orden(); i++) {
            for (int j = 0; j < g.orden(); j++) {
               int valor = f[i][k] + f[k][j];
               if (valor < f[i][j]) {
                  f[i][j] = valor;
                  r[i][j] = k;
               }
            }
         }
      }
   }
   public int CostoMinimo(int vi, int vf) {
      return f[vi][vf];
   }
   public void ruta(GrafoImp<Barrio> g, int vi, int vf) {
      int k = r[vi][vf];
      if (k != -1) {
         ruta(g, vi, k);
         System.out.println(g.obtVertice(k).toString());
         ruta(g, k, vf);
      }
   }
}
