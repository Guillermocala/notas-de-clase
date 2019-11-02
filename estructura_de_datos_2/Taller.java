/*
*Taller 3er seguimiento(20pts)
*Crear una estructura lineal que reciba datos, ordenar la estructura con cualquier algoritmo
*Buscar un elemento en la estructura con cualquier algoritmo(busqueda lineal o binaria)
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class task {
    public int busqBinariaNumeros(ArrayList<Integer> numeros, int x) {
      int ini = 0;
      int fin = numeros.size() - 1;
      while (ini <= fin) {
         int c = (ini + fin) / 2;
         if (x == numeros.get(c)) {
            return c;
         }
         else {
            if (x > numeros.get(c)) {
               ini = c + 1;
            }
            else {
               fin = c - 1;
            }
         }
      }
      return -1;
   }
    public void ordenaCol(ArrayList<Integer> lista) {
      int n = lista.size();
      for (int i = 1; i < n; i++) {
         int ward = lista.get(i);
         int j = i - 1;
         while (j >= 0 && lista.get(j) > ward) {
            lista.set(j + 1, lista.get(j));
            j = j - 1;
         }
         lista.set(j + 1, ward);
      }
   }
    public String mostrarCol(ArrayList<Integer> temp) {
      String lis = "";
      for (int i = 0; i < temp.size(); i++) {
         lis += temp.get(i) + " - ";
      }
      return lis;
   }

    public static void main(String[] args) {
        task nuevo = new task();
        ArrayList<Integer> numeros = new ArrayList<>();
        int result;
        String menu = "1- Ingrese dato \n2-Ordenar \n3-Buscar \n4-Mostrar \n0-Salir";
        String showMe, datoIns;
        int sw3 = 1, dato, dato2;
        do {
            String opcion = JOptionPane.showInputDialog(menu);
            int opcion2 = Integer.parseInt(opcion);
            switch(opcion2)
            {
               case 1:
                  datoIns = JOptionPane.showInputDialog("Ingrese el dato a insertar: ");
                  dato = Integer.parseInt(datoIns);
                  numeros.add(dato);
                  break;
               case 2:
                  nuevo.ordenaCol(numeros);
                  JOptionPane.showMessageDialog(null, "estructura ordenada!");
                  break;
               case 3:
                  String datoBusq = JOptionPane.showInputDialog("Ingrese el dato a buscar: ");
                  dato2 = Integer.parseInt(datoBusq);
                  result = nuevo.busqBinariaNumeros(numeros, dato2);
                  showMe = "El dato se encuentra en la posicion: " + result;
                  if (result != -1) {
                     JOptionPane.showMessageDialog(null, showMe);
                  }
                  else {
                     JOptionPane.showMessageDialog(null, "Auto no encontrado");
                  }
                  break;
               case 4:
                   showMe = nuevo.mostrarCol(numeros);
                   JOptionPane.showMessageDialog(null, showMe);
                   break;
               case 0:
                  sw3 = 0;
                  break;
               default:
                  JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                  break;
            }
        } while(sw3 != 0);
    }
}
