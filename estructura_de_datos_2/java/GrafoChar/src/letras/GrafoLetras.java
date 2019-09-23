/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letras;

import datos.Grafo;
import datos.GrafoMat;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class GrafoLetras {
   public Grafo<String> crear() {
      Grafo<String> gra = new GrafoMat<>();
      //gra.insVertice('A');
      //gra.insVertice('B');
      //gra.insVertice('C');
      //gra.insVertice('D');
      //gra.insVertice('E');
      gra.insArista(0, 1, 2);
      gra.insArista(0, 2, 10);
      gra.insArista(0, 4, 12);
      
      gra.insArista(1, 0, 4);
      gra.insArista(1, 2, 3);
      
      gra.insArista(2, 3, 7);
      
      gra.insArista(3, 0, 13);
      gra.insArista(3, 4, 5);
      
      gra.insArista(4, 0, 9);
      int sw = 1;
      String temp, temp2, temp3, temp4;
      String menu = "1- Insertar vertice \n2- Insertar arista \n3- mostrar \n0- salir";      
      do {
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:
               temp = JOptionPane.showInputDialog(null, "Ingrese el dato del vertice: ");
               gra.insVertice(temp);
               JOptionPane.showMessageDialog(null, "Building");
               break;
            case 2:
               temp = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de partida: ");
               int data = Integer.parseInt(temp);
               temp2 = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de llegada: ");
               int data2 = Integer.parseInt(temp2);
               temp3 = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
               int data3 = Integer.parseInt(temp3);
               gra.insArista(data, data2, data3);
               JOptionPane.showMessageDialog(null, "Building");
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
      Grafo<String> crear = ob.crear();
      //System.out.println(" " + crear.mostrar());
   }
}
