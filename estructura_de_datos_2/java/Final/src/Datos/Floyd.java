/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Principal.GrafoMatr;
import java.util.ArrayList;

/**
 *
 * @author xxx
 */
public class Floyd {
   private int f[][];   /*GUARDA COSTO*/
   private int r[][];   /*GUARDA RUTA*/
   private GrafoMatr<Ciudad> g;
   
   public Floyd(GrafoMatr<Ciudad> g) {
      int n = g.orden();
      f = new int[n][n];
      r = new int[n][n];
      this.g = g;
      Inicializar();
      CaminoMinimo();
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
   
   private ArrayList<Ciudad> ruta = new ArrayList<>();
   public ArrayList<Ciudad> getRuta(){
      return ruta;
   }
   public void ruta(GrafoMatr<Ciudad> g, int vi, int vf) {
      int k = r[vi][vf];
      if (k != -1) {
         ruta(g, vi, k);
         ruta.add(g.obtVertice(k));
         ruta(g, k, vf);
      }
   }
}
