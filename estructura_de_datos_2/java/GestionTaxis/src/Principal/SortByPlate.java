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
public class SortByPlate implements Comparator<Object>{
   @Override
   public int compare(Object t, Object t1) {
      Taxi ob1 = (Taxi) t;
      Taxi ob2 = (Taxi) t1;
      return (ob1.getPlaca().compareTo(ob2.getPlaca()));
   }
}
