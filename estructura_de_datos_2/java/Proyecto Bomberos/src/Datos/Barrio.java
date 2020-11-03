/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import java.io.Serializable;

/**
 *
 * @author 57300
 */
public class Barrio implements Serializable{
   private String nombre; /*IDENTIFICADOR DEL BARRIO*/
   private int cantAccidentes; /*CONTADOR DE ACCIDENTES*/
      
   public Barrio(String nombre) {
      this.nombre = nombre;
      this.cantAccidentes = 0;
   }  

   @Override
   public String toString() {
      return "Barrio{" + "nombre=" + nombre + '}';
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
    * @return the cantAccidentes
    */
   public int getCantAccidentes() {
      return cantAccidentes;
   }

   /**
    * incrementa el contador
    */
   public void addCantAccidentes() {
      this.cantAccidentes++;
   }
      
}
