
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 57300
 */
public class prueba {
   public static void main(String[] args) {
      
      String name, edad2;
      int edad;
      name = JOptionPane.showInputDialog(null, "ingrese el nombre: ");
      edad2 = JOptionPane.showInputDialog(null, "ingrese la edad: ");
      edad = Integer.parseInt(edad2);
      perro perro1 = new perro(name, edad);
      System.out.println("El perro creado es: " + perro1.toString());
      
   }
}
