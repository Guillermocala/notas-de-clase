/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;

/**
 *
 * @author xxx
 */
public class Ciudad implements Serializable{
   private String nombre;

   public Ciudad(String nombre) {
      this.nombre = nombre;
   }

   @Override
   public String toString() {
      return "Ciudad{" + "nombre=" + nombre + '}';
   }

   /**
    * @return the nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * @param nombre the nombre to set
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   
}
