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
public class Burbuja {
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
   public void ordenar(int v[]) {
      int temp;
      for (int i = 0; i < v.length; i++) {
         for (int j = 0; j < (v.length - 1); j++) {
            if (v[j] > v[j + 1]) {
               temp = v[j];
               v[j] = v[j + 1];
               v[j + 1] = temp;
            }
         }
      }
   }
   public static void main(String[] args) {
      Burbuja nuevo = new Burbuja();
      String showMe = "";
      int vector[] = nuevo.generar(5);
      showMe += nuevo.mostrarvec(vector);
      long timeInit = System.nanoTime();
      nuevo.ordenar(vector);
      long timeFinal = System.nanoTime();
      long timeElapsed = timeFinal - timeInit;
      showMe += "\nOrdenado\n" + nuevo.mostrarvec(vector);
      showMe += "\nTime elapsed: " + timeElapsed + " Miliseconds";
      JOptionPane.showMessageDialog(null, showMe);
   }
}
