/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letras;

import datos.Grafo;
import datos.GrafoMat;
//import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class GrafoLetras {
   public Grafo<String> crear() {
      Grafo<String> gra = new GrafoMat<>();      
      int sw = 1;
      String temp, temp2, temp3;
      String menu = "1- Insertar vertice \n2- Insertar arista \n3- mostrar \n0- salir";      
      do {
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:
               temp = JOptionPane.showInputDialog(null, "Ingrese el dato del vertice: ");
               gra.insVertice(temp);
               break;
            case 2:
               temp = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de partida: ");
               int data = Integer.parseInt(temp);
               temp2 = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de llegada: ");
               int data2 = Integer.parseInt(temp2);
               temp3 = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
               int data3 = Integer.parseInt(temp3);
               gra.insArista(data, data2, data3);
               break;
            case 3:               
               JOptionPane.showMessageDialog(null, gra.mostrar());
               break;
            case 0:
               sw = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);
      
      return gra;
   }
   
   public static void main(String[] args) {
      GrafoLetras ob = new GrafoLetras();
//      Persistencia archivo = new Persistencia();
//      File recover = new File("archivo.ch");
//      if(recover.exists())
//      {
//         ob = archivo.recuperar("archivo.ch");
//      }
//      else
//      {
//         ob = new GrafoLetras();
//      }
      Grafo<String> crear = ob.crear();
      //System.out.println(" " + crear.mostrar());
   }
}
