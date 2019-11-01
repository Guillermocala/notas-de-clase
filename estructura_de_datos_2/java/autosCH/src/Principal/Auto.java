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
public class Auto implements Serializable{
   private String placa;
   private String marca;
   private float costo;

   public Auto(String placa, String marca, float costo) {
      this.placa = placa;
      this.marca = marca;
      this.costo = costo;
   }

   @Override
   public String toString() {
      return "Auto [ " + "placa = " + placa + ", marca = " + marca + ", costo = " + costo + " ]" + "\n";
   }

   /**
    * @return the placa
    */
   public String getPlaca() {
      return placa;
   }

   /**
    * @param placa the placa to set
    */
   public void setPlaca(String placa) {
      this.placa = placa;
   }

   /**
    * @return the marca
    */
   public String getMarca() {
      return marca;
   }

   /**
    * @param marca the marca to set
    */
   public void setMarca(String marca) {
      this.marca = marca;
   }

   /**
    * @return the costo
    */
   public float getCosto() {
      return costo;
   }

   /**
    * @param costo the costo to set
    */
   public void setCosto(float costo) {
      this.costo = costo;
   }
   
}
