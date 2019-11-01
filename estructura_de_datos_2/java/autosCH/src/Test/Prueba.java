/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Principal.Auto;
import Principal.Concesionario;
import Principal.Persistencia;
import Principal.SortAutoCost;
import Principal.SortAutoModel;
import Principal.SortAutoPlaca;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 57300
 */
public class Prueba {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      Concesionario nuevo;
      Persistencia archivo = new Persistencia();
      File angel = new File("archivo.ch");
      if (angel.exists()) {
         nuevo = archivo.recuperar("archivo.ch");
      }
      else {
         nuevo = new Concesionario();
      }
      int sw = 1, sw2 = 1, sw3 = 1;
      String showMe, placa, modelo, precio;
      float precio1;
      JTextArea textarea;
      JScrollPane scroll;
      String menu = "1- Ingrese auto \n2- Eliminar auto \n3- Mostrar autos \n4- Ordenar \n5- Buscar \n0- Exit";
      String menu2 = "Ordenar \n1-Placa \n2- Modelo \n3- Costo \n0- Exit";
      do {
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:
               placa = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
               modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo: ");
               precio = JOptionPane.showInputDialog(null, "Ingrese el costo: ");
               precio1 = Float.parseFloat(precio);
               Auto temp = new Auto(placa, modelo, precio1);
               nuevo.addAuto(temp);
               archivo.guardar(nuevo);
               break;
            case 2:
               placa = JOptionPane.showInputDialog(null, "Ingrese la placa a eliminar: ");
               nuevo.elimAuto(placa);
               break;
            case 3:
               showMe = nuevo.listar();
               textarea = new JTextArea(showMe);
               scroll = new JScrollPane(textarea);
               textarea.setLineWrap(true);
               scroll.setPreferredSize(new Dimension(400, 250));
               JOptionPane.showMessageDialog(null, scroll, "Concesionario", 0);
               break;
            case 4:
               do {         
                  String opcionSub = JOptionPane.showInputDialog(menu2);
                  int opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        Collections.sort(nuevo.getAutos(), new SortAutoPlaca());
                        JOptionPane.showMessageDialog(null, "Ordenado Exitosamente");
                        break;
                     case 2:
                        Collections.sort(nuevo.getAutos(), new SortAutoModel());
                        JOptionPane.showMessageDialog(null, "Ordenado Exitosamente");
                        break;
                     case 3:
                        Collections.sort(nuevo.getAutos(), new SortAutoCost());
                        JOptionPane.showMessageDialog(null, "Ordenado Exitosamente");
                        break;            
                     case 0:
                        sw2 = 0;               
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
               } while(sw2 != 0);
               break;
            case 5:
               break;
            case 0:
               sw = 0;
               archivo.guardar(nuevo);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);      
      //ordenar por marca
      //busqueda binaria por placa

   }
}
