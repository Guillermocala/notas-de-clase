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
public class Concesionario implements Serializable{
   private ArrayList<Auto> autos;

   public Concesionario() {
      this.autos =  new ArrayList<>();
   }

   /**
    * @return the autos
    */
   public ArrayList<Auto> getAutos() {
      return autos;
   }
   public void addAuto(Auto a) {
      autos.add(a);
   }
   public String listar() {
      String res = "";
      for (Auto auto : autos) {
         res += " " + auto.toString();
      }
      return res;
   }
   public void elimAuto(String placa) {
      for (int i = 0; i < autos.size(); i++) {
         if (autos.get(i).getPlaca().compareTo(placa) == 0) {
            autos.remove(i);
         }
      }
   }
}
