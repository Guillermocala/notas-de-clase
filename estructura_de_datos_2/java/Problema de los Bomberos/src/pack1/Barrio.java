/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.Serializable;

/**
 *
 * @author 57300
 */
public class Barrio implements Serializable{
   private String nombre;
   private int accidentes;
   private Camion camion;

   public Barrio(String nombre, int accidentes, Camion camion) {
      this.nombre = nombre;
      this.accidentes = accidentes;
      this.camion = camion;
   }

   @Override
   public String toString() {
      return nombre + " ";
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

   /**
    * @return the accidentes
    */
   public int getAccidentes() {
      return accidentes;
   }

   /**
    * @param accidentes the accidentes to set
    */
   public void setAccidentes(int accidentes) {
      this.accidentes = accidentes;
   }

   /**
    * @return the camion
    */
   public Camion getCamion() {
      return camion;
   }

   /**
    * @param camion the camion to set
    */
   public void setCamion(Camion camion) {
      this.camion = camion;
   }
   
   
}
