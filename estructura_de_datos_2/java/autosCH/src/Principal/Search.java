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
public class Search {
   public int busqBinariaPlaca(ArrayList<Auto> autos, String placa) {
      int ini = 0;
      int fin = autos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (placa.compareTo(autos.get(c).getPlaca()) == 0) {
            return c;
         }
         else {
            if (placa.compareTo(autos.get(c).getPlaca()) > 0) {
               ini = c + 1;                  
            }
            else {
               fin = c - 1;
            }
         }
      }
      return -1;
   }
   public int busqBinariaModelo(ArrayList<Auto> autos, String modelo) {
      int ini = 0;
      int fin = autos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (modelo.compareTo(autos.get(c).getMarca()) == 0) {
            return c;
         }
         else {
            if (modelo.compareTo(autos.get(c).getMarca()) > 0) {
               ini = c + 1;
            }
            else {
               fin = c - 1;
            }
         }
      }
      return -1;
   }
   public int busqBinariaCosto(ArrayList<Auto> autos, float costo) {
      int ini = 0;
      int fin = autos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (costo == autos.get(c).getCosto()) {
            return c;
         }
         else {
            if (costo > autos.get(c).getCosto()) {
               ini = c + 1;                  
            }
            else {
               fin = c - 1;
            }
         }
      }
      return -1;
   }
}
