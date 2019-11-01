/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.Comparator;

/**
 *
 * @author 57300
 */
public class SortAutoCost implements Comparator<Object>{

   @Override
   public int compare(Object t, Object t1) {
      Auto a1 = (Auto) t;
      Auto a2 = (Auto) t1;
      String costo1 = String.valueOf(a1.getCosto());
      String costo2 = String.valueOf(a2.getCosto());
      return (costo1.compareTo(costo2));
   }
   
}
