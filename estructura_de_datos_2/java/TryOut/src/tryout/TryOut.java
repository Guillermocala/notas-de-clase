/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class TryOut {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      String nuevo = JOptionPane.showInputDialog(null, "ingrese el dato: ");
      int datoNum = Integer.parseInt(nuevo);
      datoNum *= 5;
      
      JOptionPane.showMessageDialog(null, datoNum);
   }
   
}
