/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;

/**
 *
 * @author 57300
 */
public class Conductor implements Serializable{
   private long cedula;
   private String nombre;
   private String placaTaxi;
   public Conductor(long cedula, String nombre) {
      this.cedula = cedula;
      this.nombre = nombre;
   }

   @Override
   public String toString() {
      return "Conductor " + " Cedula = " + cedula + ", nombre = " + nombre + "\n";
   }
   public String listarAll() {
      return "Conductor " + "\nCedula = " + cedula + "\nNombre = " + nombre + "\nTaxi asignado = " + placaTaxi;
   }
   /**
    * @return the cedula
    */
   public long getCedula() {
      return cedula;
   }

   /**
    * @return the nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * @return the placaTaxi
    */
   public String getPlacaTaxi() {
      return placaTaxi;
   }

   /**
    * @param placaTaxi the placaTaxi to set
    */
   public void setPlacaTaxi(String placaTaxi) {
      this.placaTaxi = placaTaxi;
   }
   
}
