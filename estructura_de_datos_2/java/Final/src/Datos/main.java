/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author xxx
 */
public class main {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      Operaciones opera;
      Persistencia persi = new Persistencia();
      File archivo = new File("archivo.ch");
      if (archivo.exists()) {
         opera = persi.recuperar("archivo.ch");
      }
      else {
         opera = new Operaciones();
      }
      int vi, vf, tiempo;
      String nombre, res;
      String menu = "1.Insertar Ciudad \n2.Insertar Tiempo \n3.Mostrar grafo \n4.Costo min y Ruta entre 2 ciudades"
              + "\n5.Recorrido por Profundidad \n6.Recorrido por Anchura \n7.Antecesores de Vertice \n8.Salir";
      boolean entrada = true;
      int opcion;
      JTextArea textarea;
      JScrollPane scroll;
      do {
         opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
         switch(opcion) {
            case 1: //ins ciudad
               nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
               JOptionPane.showMessageDialog(null, opera.insCiudad(nombre));
               persi.guardar(opera);
               break;
            case 2: //ins arista o tiempo
               if (opera.getGrafo().orden() > 0) {
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice inicial: "));
                  vf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice final: "));
                  tiempo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo: "));
                  opera.insTiempo(vi, vf, tiempo);
                  persi.guardar(opera);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 3: //muestra grafo
               if (opera.getGrafo().orden() > 0) {
                  textarea = new JTextArea(opera.getGrafo().mostrar()); //para mostrar
                  scroll = new JScrollPane(textarea); //para habilitar la barra de desplazamiento
                  textarea.setLineWrap(true); //para activar linewrap(cuando llegue al extremo haga un salto de linea)
                  scroll.setPreferredSize(new Dimension(600, 450)); //las dimensiones de la ventana
                  JOptionPane.showMessageDialog(null, scroll, "Grafo", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 4: //costo minimo y ruta minimo
               if (opera.getGrafo().orden() > 0) {
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice inicial: "));
                  vf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice final: "));
                  textarea = new JTextArea(opera.rutaMinima(vi, vf)); //para mostrar
                  scroll = new JScrollPane(textarea); //para habilitar la barra de desplazamiento
                  textarea.setLineWrap(true); //para activar linewrap(cuando llegue al extremo haga un salto de linea)
                  scroll.setPreferredSize(new Dimension(600, 450)); //las dimensiones de la ventana
                  JOptionPane.showMessageDialog(null, scroll, "Grafo", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 5: //recorrido profu
               if (opera.getGrafo().orden() > 0) {
                  res = "";
                  opera.limpia();
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del vertice: "));
                  opera.recoProf(vi);
                  for (Integer integer : opera.getRecorrido()) {
                     res += opera.getGrafo().obtVertice(integer).getNombre() + " - ";
                  }
                  textarea = new JTextArea(res); //para mostrar
                  scroll = new JScrollPane(textarea); //para habilitar la barra de desplazamiento
                  textarea.setLineWrap(true); //para activar linewrap(cuando llegue al extremo haga un salto de linea)                  
                  scroll.setPreferredSize(new Dimension(600, 200)); //las dimensiones de la ventana
                  JOptionPane.showMessageDialog(null, scroll, "Recorrido profundidad", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 6: //recorrido anchu
               if (opera.getGrafo().orden() > 0) {
                  res = "";
                  opera.limpia();
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del vertice: "));
                  opera.recoAnchura(vi);
                  for (Integer integer : opera.getRecorrido()) {
                     res += opera.getGrafo().obtVertice(integer).getNombre() + " - ";
                  }
                  textarea = new JTextArea(res); //para mostrar
                  scroll = new JScrollPane(textarea); //para habilitar la barra de desplazamiento
                  textarea.setLineWrap(true); //para activar linewrap(cuando llegue al extremo haga un salto de linea)
                  scroll.setPreferredSize(new Dimension(600, 200)); //las dimensiones de la ventana
                  JOptionPane.showMessageDialog(null, scroll, "Recorrido anchura", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 7: //antecesores
               if (opera.getGrafo().orden() > 0) {
                  res = "";
                  vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del vertice: "));
                  for (Ciudad x : opera.getGrafo().antecesores(vi)) {
                     res += x.getNombre() + " - ";
                  }
                  textarea = new JTextArea(res); //para mostrar
                  scroll = new JScrollPane(textarea); //para habilitar la barra de desplazamiento
                  textarea.setLineWrap(true); //para activar linewrap(cuando llegue al extremo haga un salto de linea)
                  scroll.setPreferredSize(new Dimension(600, 200)); //las dimensiones de la ventana
                  JOptionPane.showMessageDialog(null, scroll, "Antecesores", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "Grafo sin vertices!");
               }
               break;
            case 8: //salir
               entrada = false;
               break;
            default:
               break;
         }
      } while (entrada);
   }
}
