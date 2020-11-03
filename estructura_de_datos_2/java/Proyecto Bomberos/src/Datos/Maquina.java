/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author 57300
 */
public class Maquina implements Serializable{
   private int codigo; /*IDENTIFICADOR DE LA MAQUINA*/
   private boolean Ocuped; /*SI ESTA OCUPADO EN INCENDIO*/
   private boolean habilitado; /*SE INHABILITO AL AISLAR BARRIO*/
   private boolean station; /*SI ESTA EN LA ESTACION*/
   private LinkedList<Integer> barrios; /*BARRIOS QUE ATENDIO ACCIDENTE*/

   public Maquina(int codigo) {
      this.codigo = codigo;
      this.Ocuped = false;
      this.habilitado = true;
      this.station = true;
      this.barrios = new LinkedList<>();
   }

   @Override
   public String toString() {
      return "Maquina{" + "codigo=" + codigo + ", Ocuped=" + Ocuped + ", habilitado=" + habilitado + ", station=" + station + ", barrios=" + barrios + '}';
   }
     
   /**
    * @return the placa
    */
   public int getCodigo() {
      return codigo;
   }

   /**
    * @param codigo
    */
   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   /**
    * @return the Ocuped
    */
   public boolean isOcuped() {
      return Ocuped;
   }

   /**
    * @param Ocuped the Ocuped to set
    */
   public void setOcuped(boolean Ocuped) {
      this.Ocuped = Ocuped;
   }

   /**
    * @return the barrios
    */
   public LinkedList<Integer> getBarrios() {
      return barrios;
   }

   /**
    * @param barrios the barrios to set
    */
   public void setBarrios(LinkedList<Integer> barrios) {
      this.barrios = barrios;
   }
   
   public void addBarrios(int barrio) {
      this.barrios.addLast(barrio);
   }
   
   /**
    * @return the habilitado
    */
   public boolean isHabilitado() {
      return habilitado;
   }

   /**
    * @param habilitado the habilitado to set
    */
   public void setHabilitado(boolean habilitado) {
      this.habilitado = habilitado;
   }

   /**
    * @return the station
    */
   public boolean isStation() {
      return station;
   }

   /**
    * @param station the station to set
    */
   public void setStation(boolean station) {
      this.station = station;
   }
}
