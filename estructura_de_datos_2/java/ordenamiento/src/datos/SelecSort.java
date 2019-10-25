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
public class SelecSort {
   public int[] generar(int n) {
      int v[] = new int[n];
      for (int i = 0; i < v.length; i++) {
         v[i] = (int) (Math.random() * 1000);
      }
      return v;
   }
   public ArrayList<Integer> generarArray(int n) {
      ArrayList<Integer> cole = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         cole.add((int) (Math.random() * 1000));
      }
      return cole;
   }
   public LinkedList<Integer> generarList(int n) {
      LinkedList<Integer> lista = new LinkedList<>();
      for (int i = 0; i < n; i++) {
         lista.add((int) (Math.random() * 1000));
      }
      return lista;
   }
   public String mostrarvec(int v[]) {
      String lis = "";
      for (int i = 0; i < v.length; i++) {
         int j = v[i];
         lis += j + " - "; 
      }
      return lis;
   }
   public String mostrarArray(ArrayList<Integer> a) {
      String lis = "";
      for (int i = 0; i < a.size(); i++) {         
         lis += a.get(i) + " - ";
      }
      return lis;
   }
   public String mostrarList(LinkedList<Integer> a) {
      String lis = "";
      for (int i = 0; i < a.size(); i++) {         
         lis += a.get(i) + " - ";
      }
      return lis;
   }
   public void seleccion(int v[]) {
      for (int i = 0; i < v.length; i++) {         
         for (int j = (i + 1); j < v.length; j++) {
            if (v[j] < v[i]) {
               int t = v[i];
               v[i] = v[j];
               v[j] = t;
            }
         }
      }
   }
   public void seleccionArray(ArrayList<Integer> a) {
      for (int i = 0; i < a.size(); i++) {
         for (int j = (i + 1); j < a.size(); j++) {
            if (a.get(j) < a.get(i)) {
               int t = a.get(i);
               a.set(i, a.get(j));
               a.set(j, t);
            }            
         }
      }
   }
   public void seleccionList(LinkedList<Integer> v) {
      for (int i = 0; i < v.size(); i++) {
         for (int j = (i + 1); j < v.size(); j++) {
            if (v.get(j) < v.get(i)) {
               int t = v.get(i);
               v.set(i, v.get(j));
               v.set(j, t);
            }
         }
      }
   }
   public static void main(String[] args) {
      SelecSort a = new SelecSort();
//      int vec[] = a.generar(5);
//      String mos = a.mostrarvec(vec);
//      JOptionPane.showMessageDialog(null, mos);
//      a.seleccion(vec);
//      mos = a.mostrarvec(vec);
//      JOptionPane.showMessageDialog(null, mos);
////        ArrayList<Integer> b = a.generarArray(5);
////         String mos = a.mostrarArray(b);
////         JOptionPane.showMessageDialog(null, mos);
////         a.seleccionArray(b);
////         mos = a.mostrarArray(b);
////         JOptionPane.showMessageDialog(null, mos);
      LinkedList<Integer> abc = a.generarList(5);
      String mos = a.mostrarList(abc);
      JOptionPane.showMessageDialog(null, mos);
      a.seleccionList(abc);
      mos = a.mostrarList(abc);
      JOptionPane.showMessageDialog(null, mos);
   }
}
