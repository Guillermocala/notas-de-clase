/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 57300
 */
public class perro {
   private String nombre;
   private int edad;
   

   public perro(String nombre, int edad) {
      this.nombre = nombre;
      this.edad = edad;
      
   }

   @Override
   public String toString() {
      return "perro{" + "nombre=" + nombre + ", edad=" + edad + ", vivo=";
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
    * @return the edad
    */
   public int getEdad() {
      return edad;
   }

   /**
    * @param edad the edad to set
    */
   public void setEdad(int edad) {
      this.edad = edad;
   }

   /**
    * @return the vivo
    */
   
   
}
