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
class Sitio implements Serializable{
   private String nombre;

   public Sitio(String nombre) {
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
