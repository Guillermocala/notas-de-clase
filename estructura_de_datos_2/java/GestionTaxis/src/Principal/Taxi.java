/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class Taxi {
   private String placa;
   private Conductor conductor;
   private boolean statusOcu;
   private boolean statusAsig;
   private ArrayList<String> carreras;

   public Taxi(String placa) {
      this.placa = placa;
   }

   /**
    * @return the placa
    */
   public String getPlaca() {
      return placa;
   }

   /**
    * @return the conductor
    */
   public Conductor getConductor() {
      return conductor;
   }

   /**
    * @return the statusOcu
    */
   public boolean isStatusOcu() {
      return statusOcu;
   }

   /**
    * @param statusOcu the statusOcu to set
    */
   public void setStatusOcu(boolean statusOcu) {
      this.statusOcu = statusOcu;
   }

   /**
    * @return the statusAsig
    */
   public boolean isStatusAsig() {
      return statusAsig;
   }

   /**
    * @param statusAsig the statusAsig to set
    */
   public void setStatusAsig(boolean statusAsig) {
      this.statusAsig = statusAsig;
   }

   /**
    * @return the carreras
    */
   public ArrayList<String> getCarreras() {
      return carreras;
   }

   /**
    * @param carrera
    */
   public void addCarreras(String carrera) {
      this.carreras.add(carrera);
   }

   /**
    * @param conductor the conductor to set
    */
   public void setConductor(Conductor conductor) {
      this.conductor = conductor;
   }
}
