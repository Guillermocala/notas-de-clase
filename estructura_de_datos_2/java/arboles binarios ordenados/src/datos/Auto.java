/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author 57300
 */
public class Auto {
   private String color;
   private int modelo;
   private String placa;
   private String dueno;
   private int kilometraje;

   public Auto(String color, int modelo, String placa, String dueno, int kilometraje) {
      this.color = color;
      this.modelo = modelo;
      this.placa = placa;
      this.dueno = dueno;
      this.kilometraje = kilometraje;
   }

   
   
   /**
    * @return the color
    */
   public String getColor() {
      return color;
   }

   /**
    * @param color the color to set
    */
   public void setColor(String color) {
      this.color = color;
   }

   /**
    * @return the modelo
    */
   public int getModelo() {
      return modelo;
   }

   /**
    * @param modelo the modelo to set
    */
   public void setModelo(int modelo) {
      this.modelo = modelo;
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
    * @return the dueno
    */
   public String getDueno() {
      return dueno;
   }

   /**
    * @param dueno the dueno to set
    */
   public void setDueno(String dueno) {
      this.dueno = dueno;
   }

   /**
    * @return the kilometraje
    */
   public int getKilometraje() {
      return kilometraje;
   }

   /**
    * @param kilometraje the kilometraje to set
    */
   public void setKilometraje(int kilometraje) {
      this.kilometraje = kilometraje;
   }
   
   
   
}
