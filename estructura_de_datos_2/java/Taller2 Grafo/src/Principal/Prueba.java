/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Datos.GrafoImp;
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
      GrafoImp<String> grafo;
      Persistencia archivo = new Persistencia(); /*PARA GUARDAR DATOS*/      
      File obj = new File("archivo.ch"); /*EL CONDICIONAL Y ESTO ES OPERACION DE GUARDAR Y RECUPERAR DATOS*/
      if (obj.exists()) {
         grafo = archivo.recuperar("archivo.ch");
      }
      else {
         grafo = new GrafoImp<>();
      }
      int sw = 1, pos, vi, vf, dato;
      String nombre, aux;
      ArrayList<String> temporal;
      JTextArea textArea;
      JScrollPane scrollPane;
      String menu = "1.Insertar Barrio \n2.Insertar Tiempo(entre barrios) \n3.Mostrar \n4.Eliminar Tiempo \n5.Sucesores \n0.Salir";
      /*HAY QUE TENER EN CUENTA QUE TODO EMPIEZA EN LA POSICION 0*/
      do {         
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);
         switch(op) {
            case 1:
               /*insertar vertice*/
               nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");               
               grafo.insVertice(nombre);
               archivo.guardar(grafo);
               break;
            case 2:
               /*insertar arista*/
               /*preguntamos si el grafo esta vacio*/
               if (grafo.orden() != 0) {                  
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese barrio inicial: "));
                  vf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese barrio final: "));
                  if (vi != vf) {
                     dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo: "));
                     grafo.insArista(vi, vf, dato);
                     archivo.guardar(grafo);
                  }
                  else {
                     JOptionPane.showMessageDialog(null, "No se puede operar entre mismos barrios!");
                  }
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 3:
               /*mostrar*/
               if (grafo.orden() != 0) {
                  textArea = new JTextArea(grafo.mostrar());
                  scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true);  
                  textArea.setWrapStyleWord(true); 
                  scrollPane.setPreferredSize(new Dimension(550,250));
                  JOptionPane.showMessageDialog(null, scrollPane, "                    GRAFO BARRIOS", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Sin barrios!");
               }               
               break;
            case 4:
               /*eliminar arista*/
               if (grafo.orden() != 0) {
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese barrio inicial: "));
                  vf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese barrio final: "));
                  if (vi != vf) {
                     grafo.elimArista(vi, vf);
                     archivo.guardar(grafo);
                  }
                  else {
                     JOptionPane.showMessageDialog(null, "No se puede operar entre mismos barrios!");
                  }                  
               }
               else {
                  JOptionPane.showMessageDialog(null, "Sin barrios!");
               }               
               
               break;
            case 5:
               /*sucesores*/               
               pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion: "));               
               temporal = grafo.sucesores(pos);
               if (temporal.size() != 0) {
                  aux = "";
                  for (String string : temporal) {
                     aux += string + " - ";
                  }
                  textArea = new JTextArea(aux);
                  scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true);  
                  textArea.setWrapStyleWord(true); 
                  scrollPane.setPreferredSize(new Dimension(550,250));
                  JOptionPane.showMessageDialog(null, scrollPane, "                    SUCESORES", JOptionPane.YES_NO_OPTION);
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
               JOptionPane.showMessageDialog(null, "Opcion erronea!");
               break;
         }            
      }while(sw != 0);
   }
}
