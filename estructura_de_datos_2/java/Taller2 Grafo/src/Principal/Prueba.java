/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Datos.Ciudad;
import Datos.Persistencia;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 57300
 */
public class Prueba {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      Ciudad grafoC;
      Persistencia archivo = new Persistencia(); /*PARA GUARDAR DATOS*/      
      File obj = new File("archivo.ch"); /*EL CONDICIONAL Y ESTO ES OPERACION DE GUARDAR Y RECUPERAR DATOS*/
      if (obj.exists()) {
         grafoC = archivo.recuperar("archivo.ch");
      }
      else {
         grafoC = new Ciudad();
      }
      int sw = 1, pos, vi, vf, dato;
      String nombre, aux;
      ArrayList<String> temporal;
      JTextArea textArea;
      JScrollPane scrollPane;
      String menu = "1.Insertar Barrio \n2.Insertar Tiempo(entre barrios) \n3.Mostrar \n4.Eliminar Tiempo \n5.Sucesores \n0.Salir";
      do {         
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);
         switch(op) {
            case 1:
               /*insertar vertice*/
               nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");               
               grafoC.insBarrio(nombre);
               archivo.guardar(grafoC);
               break;
            case 2:
               /*insertar arista*/
               vi = Integer.getInteger(JOptionPane.showInputDialog("Ingrese vertice inicial: "));
               vf = Integer.getInteger(JOptionPane.showInputDialog("Ingrese vertice final: "));
               dato = Integer.getInteger(JOptionPane.showInputDialog("Ingrese vertice dato: "));
               grafoC.insTiempo(vi, vf, dato);
               archivo.guardar(grafoC);
               break;
            case 3:
               /*mostrar*/
               /*textArea = new JTextArea(grafoC.mostrar());
               scrollPane = new JScrollPane(textArea);
               textArea.setLineWrap(true);  
               textArea.setWrapStyleWord(true); 
               scrollPane.setPreferredSize(new Dimension(550,250));
               JOptionPane.showMessageDialog(null, scrollPane, "                    JUGADORES", JOptionPane.YES_NO_OPTION);*/
               JOptionPane.showMessageDialog(null, grafoC.mostrar());
               break;
            case 4:
               /*eliminar arista*/               
               vi = Integer.getInteger(JOptionPane.showInputDialog("Ingrese barrio inicial: "));
               vf = Integer.getInteger(JOptionPane.showInputDialog("Ingrese barrio final: "));
               grafoC.elimTiempo(vi, vf);
               archivo.guardar(grafoC);               
               break;
            case 5:
               /*sucesores*/               
               pos = Integer.getInteger(JOptionPane.showInputDialog("Ingrese la posicion: "));
               temporal = grafoC.sucesores(pos);
               if (temporal != null) {
                  aux = "";
                  for (String string : temporal) {
                     aux += string + " ";
                  }
                  textArea = new JTextArea(aux);
                  scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true);  
                  textArea.setWrapStyleWord(true); 
                  scrollPane.setPreferredSize(new Dimension(550,250));
                  JOptionPane.showMessageDialog(null, scrollPane, "                    JUGADORES", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No tiene sucesores!");
               }
               break;            
            case 0:
               /*salir*/
               sw = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opcion erronea");
               break;
         }            
      }while(sw != 0);
   }
}
