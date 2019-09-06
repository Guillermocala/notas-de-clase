/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Prueba {
   public static void main(String[] args) {
      String color = JOptionPane.showInputDialog("Color: ");
      String modelo = JOptionPane.showInputDialog("Modelo: ");
      int mod = Integer.parseInt(modelo);
      String placa = JOptionPane.showInputDialog("Placa: ");
      String dueno = JOptionPane.showInputDialog("Dueno: ");
      String kilometraje = JOptionPane.showInputDialog("Kilometraje: ");
      int km = Integer.parseInt(kilometraje);
      Auto ob = new Auto(color, mod, placa, dueno, km);
      
      
      JOptionPane.showMessageDialog(null, ob.getPlaca()); // para obtener los datos
   }
   
   
   
}
