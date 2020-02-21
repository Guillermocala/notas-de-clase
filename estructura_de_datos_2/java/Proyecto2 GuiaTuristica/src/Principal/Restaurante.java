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
class Restaurante implements Serializable{
   private String nombre;
   
   public Restaurante(String nombre) {
      this.nombre = nombre;
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
