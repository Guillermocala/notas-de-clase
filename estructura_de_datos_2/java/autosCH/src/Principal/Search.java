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
   
   public int busqBinaria(ArrayList<Auto> autos, String placa) {
      int ini = 0;
      int fin = autos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (x == v[c]) {
            return c;
         }
         else {
            if (x > v[c]) {
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
