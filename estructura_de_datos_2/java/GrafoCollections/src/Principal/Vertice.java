/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author 57300
 */
public class Vertice<E> implements Serializable{
   private E dato;
   private ArrayList<Arista> aristas = new ArrayList<>();

   /**
    * @param nombre
    */
   
   public Vertice(E nombre) {
      this.dato = nombre;
   }

   public void insArista(int vf, int dato) {
      Arista asd = new Arista(vf, dato);
      aristas.add(asd);
   }
   public int obtArista(int vf) {
      Arista temp = this.aristas.get(vf);
      return temp.getDatoArista();
   }
   public void borraArista(int vf) {
      this.aristas.remove(vf);
   }
   public String showMe() {
      String res = "";      
      res += " Nombre: " + this.dato + "\nAristas: ";
      for (Arista arista : aristas) {
         res += arista.showMeAri() + "\n";
      }
      res += "\n";
      return res;
   }
   public E getDato() {
      return dato;
   }

   /**
    * @param dato
    */
   public void setDato(E dato) {
      this.dato = dato;
   }

   /**
    * @return the aristas
    */
   public ArrayList<Arista> getAristas() {
      return aristas;
   }

   /**
    * @param aristas the aristas to set
    */
   public void setAristas(ArrayList<Arista> aristas) {
      this.aristas = aristas;
   }
}
