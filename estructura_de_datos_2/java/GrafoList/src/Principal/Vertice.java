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
public class Vertice {
   private String nombre;
   private LinkedList<Arista> aristas = new LinkedList<>();

   /**
    * @return the nombre
    */
   public void insArista(int vf, int dato) {
      Arista asd = new Arista(vf, dato);
      aristas.add(asd);
   }
   public int obtArista(int vf) {
      
   }
   public String showMe() {
      String res = "";
      res += "nombre: " + this.nombre + "\nAristas: ";
      for (int i = 0; i < aristas.size(); i++) {
         res += this.aristas.get(i) + "\n";         
      }      
      return res;
   }
   public String getNombre() {
      return nombre;
   }

   /**
    * @param nombre the nombre to set
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
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
