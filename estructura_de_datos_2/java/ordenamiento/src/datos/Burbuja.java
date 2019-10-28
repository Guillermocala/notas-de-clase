/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Burbuja {
   public int[] generarVec(int n) {
      int v[] = new int[n];
      for (int i = 0; i < v.length; i++) {
         v[i] = (int) (Math.random() * 1000);
      }
      return v;
   }
   public String mostrarVec(int v[]) {
      String lis = "";
      for (int i = 0; i < v.length; i++) {         
         lis += v[i] + " - "; 
      }
      return lis;
   }
   public void ordenarVec(int v[]) {
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
   public LinkedList<Integer> generarList(int n) {
      LinkedList<Integer> lista = new LinkedList<>();
      for (int i = 0; i < n; i++) {
         lista.add((int) (Math.random() * 1000));
      }
      return lista;
   }
   public String mostrarList(LinkedList<Integer> temp) {
      String lis = "";
      for (int i = 0; i < temp.size(); i++) {
         lis += temp.get(i) + " - "; 
      }
      return lis;
   }
   public void ordenarList(LinkedList<Integer> lista) {
      int temp;
      for (int i = 0; i < lista.size(); i++) {
         for (int j = 0; j < (lista.size() - 1); j++) {
            if (lista.get(j) > lista.get(j + 1)) {
               temp = lista.get(j);
               lista.set(j, lista.get(j + 1));
               lista.set(j + 1, temp);
            }
         }
      }
   }
   public ArrayList<Integer> generarCol(int n) {
      ArrayList<Integer> lista = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         lista.add((int) (Math.random() * 1000));
      }
      return lista;
   }
   public String mostrarCol(ArrayList<Integer> temp) {
      String lis = "";
      for (int i = 0; i < temp.size(); i++) {
         lis += temp.get(i) + " - "; 
      }
      return lis;
   }
   public void ordenarCol(ArrayList<Integer> col) {
      int temp;
      for (int i = 0; i < col.size(); i++) {
         for (int j = 0; j < (col.size() - 1); j++) {
            if (col.get(j) > col.get(j + 1)) {
               temp = col.get(j);
               col.set(j, col.get(j + 1));
               col.set(j + 1, temp);
            }
         }
      }
   }
   public static void main(String[] args) {
      Burbuja nuevo = new Burbuja();
      String showMe, tamanio;
      int sw = 1, tamanio1;
      String menu = "BUBBLE SORTING METHOD\n1- Vector \n2- List \n3- Collecction \n0- Exit";      
      do {
         showMe = "";
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:
               tamanio = JOptionPane.showInputDialog("Enter the length: ");
               tamanio1 = Integer.parseInt(tamanio);
               int vector[] = nuevo.generarVec(tamanio1);
               showMe += nuevo.mostrarVec(vector);
               long timeInit = System.nanoTime();
               nuevo.ordenarVec(vector);
               long timeFinal = System.nanoTime();
               long timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarVec(vector);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               JOptionPane.showMessageDialog(null, showMe);
               break;
            case 2:
               tamanio = JOptionPane.showInputDialog("Enter the length: ");
               tamanio1 = Integer.parseInt(tamanio);
               LinkedList<Integer> lista2 = nuevo.generarList(tamanio1);
               showMe += nuevo.mostrarList(lista2);
               timeInit = System.nanoTime();
               nuevo.ordenarList(lista2);
               timeFinal = System.nanoTime();
               timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarList(lista2);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               JOptionPane.showMessageDialog(null, showMe);
               break;
            case 3:
               tamanio = JOptionPane.showInputDialog("Enter the length: ");
               tamanio1 = Integer.parseInt(tamanio);
               ArrayList<Integer> col = nuevo.generarCol(tamanio1);
               showMe += nuevo.mostrarCol(col);
               timeInit = System.nanoTime();
               nuevo.ordenarCol(col);
               timeFinal = System.nanoTime();
               timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarCol(col);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               JOptionPane.showMessageDialog(null, showMe);
               break;
            case 0:
               sw = 0;               
               break;
            default:
               JOptionPane.showMessageDialog(null, "INCORRECT OPTION!");
               break;
         }
      } while(sw != 0);
   }
}
