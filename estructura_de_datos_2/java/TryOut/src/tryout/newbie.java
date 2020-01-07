/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout;

import java.util.*;

/**
 *
 * @author 57300
 */
public class newbie {
   public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      String temporal;
      int arreglo[] = new int[100];      
      int num, i = 0;      
      boolean control = true;
      while (control == true) {
         System.out.println("Ingrese dato: ");
         temporal = entrada.nextLine();
         num = Integer.parseInt(temporal);
         if (num == 0){
            break;
         }
         arreglo[i] = num;
         i++;
      }
      int n = 0;
      int suma = 0;
      while (n <= i) {
         //suma de los pares
         if (n % 2 != 0) {
            suma = suma + arreglo[n];
         }         
         n++;
      }
//      int suma = 0;
//      for (int i = 0; i < 5; i++) {
//         System.out.println("Ingrese el dato: ");
//         temporal = entrada.nextLine();
//         num = Integer.parseInt(temporal);
//         suma = suma + num;
//      }
      System.out.println("la suma impares: " + suma);
   }
}
