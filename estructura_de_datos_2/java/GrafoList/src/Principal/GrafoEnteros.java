/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 * @param <E>
 */
public class GrafoEnteros<E> implements Serializable{
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      Grafo<Integer> juas;
      Persistencia angel = new Persistencia();
      File check = new File("archivo.ch");
      if (check.exists()) {
         juas = angel.recuperar("archivo.ch");
      }
      else {
         juas = new GrafoList<>();
      }
      int sw = 1;
      String temp, temp2, temp3;
      String menu = "1- Insertar vertice \n2- Insertar arista \n3- Elim Arista \n4- mostrar \n0- salir";      
      do {
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:
               temp = JOptionPane.showInputDialog(null, "Ingrese el dato del vertice: ");
               int ver = Integer.parseInt(temp);
               juas.insVertice(ver);
               break;
            case 2:
               temp = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de partida: ");
               int vi = Integer.parseInt(temp);
               temp2 = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de llegada: ");
               int vf = Integer.parseInt(temp2);
               temp3 = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
               int data = Integer.parseInt(temp3);
               juas.insArista(vi, vf, data);
               break;
            case 3:
               temp = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de partida: ");
               vi = Integer.parseInt(temp);
               temp2 = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de llegada: ");
               vf = Integer.parseInt(temp2);
               juas.elimArista(vi, vf);
            case 4:
               String showMe = juas.mostrar();
               JOptionPane.showMessageDialog(null, showMe);
               break;
            case 0:
               sw = 0;
               angel.guardar(juas);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);
   }
}
