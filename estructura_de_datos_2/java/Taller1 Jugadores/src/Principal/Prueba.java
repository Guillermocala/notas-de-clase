/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Datos.Jugador;
import Datos.Persistencia;
import Datos.Plataforma;
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
      /*SI SE MODIFICA LA CLASE PLATAFORMA HAY QUE IR AL DIRECTORIO Y ELIMINAR "archivo.ch" PARA QUE
      LO GENERE NUEVAMENTE BAJO EL NUEVO CODIGO*/
      Persistencia archivo = new Persistencia(); /*PARA GUARDAR DATOS*/
      Plataforma arbol; /*CREAMOS LA PLATAFORMA QUE TIENE EL ARBOL Y FUNCIONES*/
      File obj = new File("archivo.ch"); /*EL CONDICIONAL Y ESTO ES OPERACION DE GUARDAR Y RECUPERAR DATOS*/
      if (obj.exists()) {
         arbol = archivo.recuperar("archivo.ch");
      }
      else {
         arbol = new Plataforma();
      }
      int sw = 1, codigo, goles;
      float salario;
      String nombre, aux;
      ArrayList<Jugador> salariosX;
      Jugador temp;
      JTextArea textArea;
      JScrollPane scrollPane;
      String menu = "1.Insertar Jugador \n2.Listar jugadores \n3.Buscar por codigo \n4.Eliminar por nombre \n5.Mayor goleador \n6.Jugadores con mas de X salario \n0.Salir";
      do {         
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);
         switch(op) {
            case 1:
               /*insertar jugador*/
               nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
               codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo: "));
               salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese salario: "));
               goles = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese goles: "));
               arbol.insertar(new Jugador(nombre, salario, codigo, goles));
               archivo.guardar(arbol);
               break;
            case 2:
               /*listar jugadores*/
               /*PARA COMPROBAR QUE EL ARBOL TENGA ELEMENTOS, LO HAGO EN TODO MENOS INSERTAR*/
               if (arbol.raiz != null) {
                  textArea = new JTextArea(arbol.listar());
                  scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true);  
                  textArea.setWrapStyleWord(true); 
                  scrollPane.setPreferredSize(new Dimension(550,250));
                  JOptionPane.showMessageDialog(null, scrollPane, "                    JUGADORES", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Arbol vacio!");
               }
               break;
            case 3:
               /*buscar por codigo*/
               if (arbol.raiz != null) {
                  codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo a eliminar: "));
                  temp = arbol.buscaByCodigo(codigo);
                  if (temp != null) {
                     JOptionPane.showMessageDialog(null, temp.toString());
                  }
                  else {
                     JOptionPane.showMessageDialog(null, "No encontrado!");
                  }
               }
               else {
                  JOptionPane.showMessageDialog(null, "Arbol vacio!");
               }               
               break;
            case 4:
               /*eliminar por nombre*/
               if (arbol.raiz != null) {
                  nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                  /*SI LO ELIMINA COLOCA UNA CONFIRMACION, EN CASO CONTRARIO NO PASA NADA*/
                  temp = arbol.buscaByNombre(nombre);                  
                  arbol.elimina(temp);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Arbol vacio!");
               }
               archivo.guardar(arbol);
               break;
            case 5:
               /*mayor goleador*/
               if (arbol.raiz != null) {
                  arbol.goleador(arbol.raiz);
                  /*TEMPORAL ES EL JUGADOR GOLEADOR GUARDADO EN PLATAFORMA*/
                  JOptionPane.showMessageDialog(null, "El mayor goleador es: " + arbol.temporal.toString());
               }
               else {
                  JOptionPane.showMessageDialog(null, "Arbol vacio!");
               }
               break;
            case 6:
               /*jugadores con mas de x salario*/
               if (arbol.raiz != null) {
                  salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese salario: "));
                  salariosX = arbol.masX_salario(salario); /*GUARDO TODOS LOS JUGADORES EN LA COLECCION*/
                  if (salariosX.isEmpty()) { /*SI NO INGRESÓ JUGADORES, COLECION VACIA*/
                     JOptionPane.showMessageDialog(null, "Sin ocurrencias...");
                  }
                  else {
                     aux = "";
                     /*PARA RECORRER LA COLECCION Y GUARDAR EL EL STRING*/
                     for (Jugador jugador : salariosX) {
                        aux += jugador.toString() + "\n";                     
                     }                     
                     textArea = new JTextArea(aux);
                     scrollPane = new JScrollPane(textArea);
                     textArea.setLineWrap(true);  
                     textArea.setWrapStyleWord(true); 
                     scrollPane.setPreferredSize(new Dimension(550,250));
                     JOptionPane.showMessageDialog(null, scrollPane, "                    JUGADORES CON MAS DE SALARIO $" + salario, JOptionPane.YES_NO_OPTION);
                  }
               }
               else {
                  JOptionPane.showMessageDialog(null, "Arbol vacio!");
               }
               break;
            case 0:
               /*salir*/
               sw = 0;
               break;
         }            
      }while(sw != 0);
   }
}
