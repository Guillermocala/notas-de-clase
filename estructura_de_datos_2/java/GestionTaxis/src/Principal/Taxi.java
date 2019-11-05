/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class Taxi implements Serializable{
   private String placa;
   private Conductor conductor;
   private boolean statusOcu = false;
   private boolean statusAsig = false;
   private ArrayList<String> carreras = new ArrayList<>();

   public Taxi(String placa) {
      this.placa = placa;
   }

   @Override
   public String toString() {
      return "Taxi " + "placa = " + placa + ", " + conductor + ", Asignado = " + statusAsig + ", Ocupado = " + statusOcu + "\n";
   }
   public String listarAll() {
      int i = 0;
      String res = "";
      res += "Taxi \nPlaca = " + placa + "\nConductor = " + conductor + "\nOcupado = " + statusOcu + "\nAsignado = " + statusAsig + "\n";
      for (String carrera : carreras) {
         res += "Carrera #" + i + " = " + carrera + "\n";
         i++;
      }
      return res;
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
   public void elimCarrera(String carrera) {
      carreras.remove(carrera);
   }
}
