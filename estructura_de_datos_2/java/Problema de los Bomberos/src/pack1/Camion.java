/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author 57300
 */
public class Camion implements Serializable{
   private String placa;
   private boolean ocupado;
   private boolean habilitado;
   private LinkedList<Integer> visitados = new LinkedList<>();

   public Camion(String placa, boolean ocupado, boolean habilitado) {
      this.placa = placa;
      this.ocupado = ocupado;
      this.habilitado = habilitado;
      visitados.add(0);
   }

   @Override
   public String toString() {
      return "Camion{" + "placa=" + placa + ", ocupado=" + ocupado + ", habilitado=" + habilitado + ", visitados=" + visitados + '}';
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
    * @return the ocupado
    */
   public boolean isOcupado() {
      return ocupado;
   }

   /**
    * @param ocupado the ocupado to set
    */
   public void setOcupado(boolean ocupado) {
      this.ocupado = ocupado;
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
    * @return the visitados
    */
   public LinkedList<Integer> getVisitados() {
      return visitados;
   }
   public void addBarrio(int barrio) {
      visitados.add(barrio);
   }

   /**
    * @param visitados the visitados to set
    */
   public void setVisitados(LinkedList<Integer> visitados) {
      this.visitados = visitados;
   }
   
   
}
