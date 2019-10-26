/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.LinkedList;

/**
 *
 * @author 57300
 */
public class Vertice<E> {
   private E dato;
   private LinkedList<Arista> aristas = new LinkedList<>();

   /**
    * @return the nombre
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
      res += "nombre: " + this.dato + "\nAristas: ";
      for (int i = 0; i < aristas.size(); i++) {
         res += this.aristas.get(i) + "\n";         
      }      
      return res;
   }
   public E getDato() {
      return dato;
   }

   /**
    * @param nombre the nombre to set
    */
   public void setDato(E dato) {
      this.dato = dato;
   }

   /**
    * @return the aristas
    */
   public LinkedList<Arista> getAristas() {
      return aristas;
   }

   /**
    * @param aristas the aristas to set
    */
   public void setAristas(LinkedList<Arista> aristas) {
      this.aristas = aristas;
   }
   
}
