/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 57300
 */
public class InsertionSort {
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
   public void ordenaVec(int v[]) {
      int n = v.length;
      for (int i = 1; i < n; i++) {
         int ward = v[i];
         int j = i - 1;
         while (j >= 0 && v[j] > ward) {            
            v[j + 1] = v[j];
            j = j - 1;
         }
         v[j + 1] = ward;
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
   public void ordenaList(LinkedList<Integer> lista) {
      int n = lista.size();
      for (int i = 1; i < n; i++) {
         int ward = lista.get(i);
         int j = i - 1;
         while (j >= 0 && lista.get(j) > ward) {
            lista.set(j + 1, lista.get(j));
            j = j - 1;
         }
         lista.set(j + 1, ward);
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
   public void ordenaCol(ArrayList<Integer> lista) {
      int n = lista.size();
      for (int i = 1; i < n; i++) {
         int ward = lista.get(i);
         int j = i - 1;
         while (j >= 0 && lista.get(j) > ward) {
            lista.set(j + 1, lista.get(j));            
            j = j - 1;
         }
         lista.set(j + 1, ward);
      }
   }
   public static void main(String[] args) {
      InsertionSort nuevo = new InsertionSort();
      String showMe, tamanio;
      int sw = 1, tamanio1;
      JTextArea textarea;
      JScrollPane scroll;
      String menu = "INSERTION-SORT SORTING METHOD\n1- Vector \n2- List \n3- Collection \n0- Exit";      
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
               nuevo.ordenaVec(vector);
               long timeFinal = System.nanoTime();
               long timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarVec(vector);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               textarea = new JTextArea(showMe);
               scroll = new JScrollPane(textarea);
               textarea.setLineWrap(true);
               textarea.setPreferredSize(new Dimension(250, 400));
               JOptionPane.showMessageDialog(null, scroll, "Insertion-sort Vect", 0);
               break;
            case 2:
               tamanio = JOptionPane.showInputDialog("Enter the length: ");
               tamanio1 = Integer.parseInt(tamanio);
               LinkedList<Integer> lista2 = nuevo.generarList(tamanio1);               
               showMe += nuevo.mostrarList(lista2);
               timeInit = System.nanoTime();
               nuevo.ordenaList(lista2);
               timeFinal = System.nanoTime();
               timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarList(lista2);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               textarea = new JTextArea(showMe);
               scroll = new JScrollPane(textarea);
               textarea.setLineWrap(true);
               textarea.setPreferredSize(new Dimension(250, 400));
               JOptionPane.showMessageDialog(null, scroll, "Insertion-sort Vect", 0);
               break;
            case 3:
               tamanio = JOptionPane.showInputDialog("Enter the length: ");
               tamanio1 = Integer.parseInt(tamanio);
               ArrayList<Integer> col = nuevo.generarCol(tamanio1);               
               showMe += nuevo.mostrarCol(col);
               timeInit = System.nanoTime();
               nuevo.ordenaCol(col);
               timeFinal = System.nanoTime();
               timeElapsed = timeFinal - timeInit;
               showMe += "\nOrdered\n" + nuevo.mostrarCol(col);
               showMe += "\nTime elapsed: " + timeElapsed + " Nanoseconds";
               textarea = new JTextArea(showMe);
               scroll = new JScrollPane(textarea);
               textarea.setLineWrap(true);
               textarea.setPreferredSize(new Dimension(250, 400));
               JOptionPane.showMessageDialog(null, scroll, "Insertion-sort Vect", 0);
               break;
            case 0:
               sw = 0;               
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);
   }
}
