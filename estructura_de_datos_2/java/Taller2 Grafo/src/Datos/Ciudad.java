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
public class Ciudad implements Serializable{
   private Grafo<String> grafo;
   
   public boolean grafoVacio() {
      if (grafo.orden() == 0) {
         JOptionPane.showMessageDialog(null, grafo.orden());
         return true;
      }
      return false;
   }
   public void insBarrio(String nombre) {
      if (this.grafoVacio()) {
         grafo = new GrafoImp<>();         
      }
      insBarrio(grafo, nombre);
   }
   private void insBarrio(Grafo<String> grafo, String nombre) {
      if (busqBarrio(nombre)) {
         JOptionPane.showMessageDialog(null, "Ya existe el barrio!");
      }
      else {
         grafo.insVertice(nombre);
      }
   }
   public void insTiempo(int vi, int vf, int dato) {
      if (this.grafoVacio()) {
         JOptionPane.showMessageDialog(null, "No hay barrios!");
      }
      else {
         insTiempo(grafo, vi, vf, dato);
      }
   }
   private void insTiempo(Grafo<String> grafo, int vi, int vf, int dato) {
      if (vi == vf) {
         JOptionPane.showMessageDialog(null, "No se puede operar entre mismos barrios!");
      }
      else {
         if (grafo.obtArista(vi, vf) != 999999) {
            JOptionPane.showMessageDialog(null, "Ya tiene un valor asignado!");
         }
         else {
            grafo.insArista(vi, vf, dato);
         }         
      }
   }
   public void elimTiempo(int vi, int vf) {
      if (this.grafoVacio()) {
         JOptionPane.showMessageDialog(null, "No hay barrios!");
      }
      else {
         elimTiempo(grafo, vi, vf);
      }
   }
   private void elimTiempo(Grafo<String> grafo, int vi, int vf) {
      if (vi == vf) {
         JOptionPane.showMessageDialog(null, "No se puede operar entre mismos barrios!");
      }
      else {
         if (grafo.obtArista(vi, vf) != 999999) {
            JOptionPane.showMessageDialog(null, "El valor a eliminar no existe!!");
         }
         else {
            grafo.elimArista(vi, vf);
         }         
      }
   }
   public boolean busqBarrio(String nombre) {
      if (this.grafoVacio()) {
         return false;
      }
      else {
         return busqBarrio(grafo, nombre);
      }
   }
   private boolean busqBarrio(Grafo<String> grafo, String nombre) {
      for (int i = 0; i < grafo.orden(); i++) {
         if (grafo.obtVertice(i).compareTo(nombre) == 0) {
            return true;
         }
      }
      return false;
   }
   public ArrayList<String> sucesores(int pos) {
      if (!(this.grafoVacio())) {
         return grafo.sucesores(pos);
      }
      else {
         return null;
      }
   }
   public String mostrar() {
      if (this.grafoVacio()) {
         return "Grafo vacio!";
      }
      else {
         return grafo.mostrar();
      }
   }
}
