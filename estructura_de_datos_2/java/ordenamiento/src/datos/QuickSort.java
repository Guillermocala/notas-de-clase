/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class QuickSort {
   public int[] generar(int n) {
      int v[] = new int[n];
      for (int i = 0; i < v.length; i++) {
         v[i] = (int) (Math.random() * 1000);
      }
      return v;
   }
   public String mostrarvec(int v[]) {
      String lis = "";
      for (int i = 0; i < v.length; i++) {
         int j = v[i];
         lis += j + " - "; 
      }
      return lis;
   }
   public void ordenar(int v[], int ini, int fin) {
      int m = (ini + fin) / 2;
      int pivot = v[m];
      int i = ini;
      int j = fin;
      int temp;
      while (i <= j) {         
         while (v[i] < pivot) {            
            i++;
         }
         while (v[j] > pivot) {            
            j--;
         }
         if (i <= j) {
            temp = v[i];
            v[i] = v[j];
            v[j] = temp;
         }
         i++;
         j--;
      }
      if (ini < j) {
         ordenar(v, ini, j);
      }
      else if (fin > j) {
         ordenar(v, i, fin);
      }
   }
   public static void main(String[] args) {
      QuickSort nuevo = new QuickSort();
      String showMe = "";
      int vector[] = nuevo.generar(5);
      int fin = vector.length - 1; // se resta una posicion, porque el inicio va en 0
      showMe += nuevo.mostrarvec(vector);
      long timeInit = System.nanoTime();
      nuevo.ordenar(vector, 0, fin);
      long timeFinal = System.nanoTime();
      long timeElapsed = timeFinal - timeInit;
      showMe += "\nOrdenado\n" + nuevo.mostrarvec(vector);
      showMe += "\nTime elapsed: " + timeElapsed + " Miliseconds";
      JOptionPane.showMessageDialog(null, showMe);
   }
}
