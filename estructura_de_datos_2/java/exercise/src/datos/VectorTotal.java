/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author 57300
 */
public class VectorTotal {
   int vectorTemp[];
   int limit;
   
   public VectorTotal(int tamanio) {
      vectorTemp = new int [tamanio];
      limit = 1;
   }
   
   public void ingreso(int dato) {
      vectorTemp[limit] = dato;
      limit++;
   }
   
   public void mostrarVector() {
      for(int i = 1; i < limit; i++) {
         System.out.println(" " + vectorTemp[i]);
      }
   }
}
