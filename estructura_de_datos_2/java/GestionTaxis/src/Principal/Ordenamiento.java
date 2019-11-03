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
public class Ordenamiento {
   public boolean isOrderedPlate(ArrayList<Taxi> taxis) {
      for (int i = 0; i < (taxis.size() - 1); i++) {
         if (taxis.get(i).getPlaca().compareTo(taxis.get(i + 1).getPlaca()) > 0) {
            return false;
         }
      }
      return true;
   }
   public boolean isOrderedCedu(ArrayList<Conductor> conductores) {
      for (int i = 0; i < (conductores.size() - 1); i++) {
         if (conductores.get(i).getCedula() > conductores.get(i + 1).getCedula()) {
            return false;
         }
      }
      return true;
   }
   public void sortByCedu(ArrayList<Conductor> conductores) {
      for (int i = 0; i < (conductores.size() - 1); i++) {
         Conductor ward = conductores.get(i);
         int j = i - 1;
         while (j >= 0 && conductores.get(j).getCedula() > ward.getCedula()) {
            conductores.set(j + 1, conductores.get(j));
            j--;
         }
         conductores.set(j + 1, ward);
      }
   }
}
