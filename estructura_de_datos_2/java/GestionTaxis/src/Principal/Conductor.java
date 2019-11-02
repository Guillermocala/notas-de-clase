/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 57300
 */
public class Conductor {
   private double cedula;
   private String nombre;
   private String placaTaxi;
   public Conductor(double cedula, String nombre) {
      this.cedula = cedula;
      this.nombre = nombre;
   }

   /**
    * @return the cedula
    */
   public double getCedula() {
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
