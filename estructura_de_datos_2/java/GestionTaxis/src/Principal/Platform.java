/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Platform implements Serializable{
   private ArrayList<Taxi> taxis = new ArrayList<>();
   private ArrayList<Conductor> conductores = new ArrayList<>();
   private LinkedList<Taxi> taxisDisponibles = new LinkedList<>();
   private LinkedList<Taxi> taxisOcupados = new LinkedList<>();
   /**
    * @return the taxis
    */
   public ArrayList<Taxi> getTaxis() {
      return taxis;
   }
   /**
    * @param pos
    * @return the conductores
    */
   
   public Taxi getTaxi(int pos) {
      return taxis.get(pos);
   }
   
   public Conductor getConduc(int pos) {
      return conductores.get(pos);
   }
   
   public ArrayList<Conductor> getConductores() {
      return conductores;
   }
   
   public void addTaxi(Taxi taxi) {
      taxis.add(taxi);
   }
   
   public void addConductor(Conductor conduc) { 
      conductores.add(conduc);
   }
   
   public void insTaxiDisponible(Taxi taxi) {
      taxi.setStatusOcu(false);
      taxisDisponibles.addLast(taxi);
   }
   
   public void insTaxiOcupado(Taxi taxi) {
      taxi.setStatusOcu(true);
      taxisOcupados.addLast(taxi);
   }
   
   public void remTaxiDisponible(Taxi taxi) {
      taxi.setStatusOcu(true);
      taxisDisponibles.remove(taxi);
   }
   
   public void remTaxiOcupado(Taxi taxi) {
      taxi.setStatusOcu(false);
      taxisOcupados.remove(taxi);
   }
   
   public void elimTaxi(String placa) {
      Taxi taxi = busqLinealTaxi(placa);
      if (taxi != null) {
         taxis.remove(taxi);
      }
      else {
         JOptionPane.showMessageDialog(null, "No encontrado!");
      }
   }
   public void elimConduc(String nombre) {
      Conductor conduc = busqLinealConduc(nombre);
      if (conduc != null) {
         conductores.remove(conduc);
      }
      else {
         JOptionPane.showMessageDialog(null, "No encontrado!");
      }
   }
   public void elimCarrera(Taxi taxi, String carrera) {
      if (taxi != null) {
         for (int i = 0; i < taxi.getCarreras().size(); i++) {
            if (carrera.compareTo(taxi.getCarreras().get(i)) == 0) {
               taxi.elimCarrera(carrera);
         }
         }
      }
      else {
         JOptionPane.showMessageDialog(null, "Taxi no encontrado");
      }
   }
   public Taxi busqLinealTaxi(String placa) {
      for (Taxi taxi : taxis) {
         if (taxi.getPlaca().compareTo(placa) == 0) {
            return taxi;
         }
      }
      return null;
   }
   public Taxi busqBinTaxi(String placa) {
      int ini = 0;
      int fin = taxis.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (placa.compareTo(taxis.get(c).getPlaca()) == 0) {
            return taxis.get(c);
         }
         else {
            if (placa.compareTo(taxis.get(c).getPlaca()) > 0) {
               ini = c + 1;
            }
            else {
               fin = c - 1 ;
            }
         }
      }
      return null;
   }
   public Conductor busqLinealConduc(String nombre) {
      for (Conductor conduc : conductores) {
         if (conduc.getNombre().compareTo(nombre) == 0) {
            return conduc;
         }
      }
      return null;
   }
   public Conductor busqLinealConduc(double cedula) {
      for (Conductor conduc : conductores) {
         if (cedula == conduc.getCedula()) {
            return conduc;
         }
      }
      return null;
   }
   public Conductor busqBinConduc(String nombre) {
      int ini = 0;
      int fin = conductores.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (nombre.compareTo(conductores.get(c).getNombre()) == 0) {
            return conductores.get(c);
         }
         else {
            if (nombre.compareTo(conductores.get(c).getNombre()) > 0) {
               ini = c + 1;
            }
            else {
               fin = c - 1 ;
            }
         }
      }
      return null;
   }
   public void asigConducTaxi(double cedula, String placa) {
      Taxi taxi = busqLinealTaxi(placa);
      Conductor conductor = busqLinealConduc(cedula);
      if (taxis.contains(taxi) && conductores.contains(conductor)) {
         if (!taxi.isStatusAsig()) {
            taxi.setConductor(conductor);
            taxi.setStatusAsig(true);
            conductor.setTaxi(taxi);
            insTaxiDisponible(taxi);
         }
         else {
            JOptionPane.showMessageDialog(null, "Ya ha sido asignado un conductor al taxi!");
         }
      }
      else {
         JOptionPane.showMessageDialog(null, "Alguno de los dos datos ha sido erroneo!");
      }
   }
   public void asigCarreraTaxi(String placa, String carrera) {
      Taxi taxi = busqBinTaxi(placa);
      if (taxis.contains(taxi)) {
         taxi.addCarreras(carrera);
         remTaxiDisponible(taxi);
         if (taxisOcupados.size() == 2) {
            insTaxiDisponible(taxisOcupados.getFirst());
            taxisOcupados.removeFirst();
         }
         insTaxiOcupado(taxi);
      }
      else {
         JOptionPane.showMessageDialog(null, "Taxi no encontrado!");
      }
   }
}
