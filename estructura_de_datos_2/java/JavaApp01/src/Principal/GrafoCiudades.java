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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class GrafoCiudades implements Serializable{
   
   public Ciudad nuevaCiudad() {
      Hotel hot1;
      Plato plat1;
      Restaurante res1;
      Sitio sit1;
      String nombHot, nombPlat, nombRes, nomSit, nombCiudad;
      ArrayList<Hotel> lisHot = new ArrayList<>();
      ArrayList<Plato> lisPla = new ArrayList<>();
      ArrayList<Restaurante> lisRes = new ArrayList<>();
      ArrayList<Sitio> lisSit = new ArrayList<>();      
      nombCiudad = JOptionPane.showInputDialog(null, "nombre: ");
      String cant = JOptionPane.showInputDialog(null, "Ingrese cuantos hoteles: ");
      int cant1 = Integer.parseInt(cant);       
      for (int i = 0; i < cant1; i++) {
         nombHot = JOptionPane.showInputDialog(null, "nombre: ");
         hot1 = new Hotel(nombHot);
         lisHot.add(hot1);
      }      
      cant = JOptionPane.showInputDialog(null, "Ingrese cuantos platos: ");
      cant1 = Integer.parseInt(cant);            
      for (int i = 0; i < cant1; i++) {
         nombPlat = JOptionPane.showInputDialog(null, "nombre: ");
         plat1 = new Plato(nombPlat);
         lisPla.add(plat1);
      }
      cant = JOptionPane.showInputDialog(null, "Ingrese cuantos restaurantes: ");
      cant1 = Integer.parseInt(cant);      
      for (int i = 0; i < cant1; i++) {         
         nombRes = JOptionPane.showInputDialog(null, "nombre: ");
         res1 = new Restaurante(nombRes);
         lisRes.add(res1);
      }
      cant = JOptionPane.showInputDialog(null, "Ingrese cuantos sitios: ");
      cant1 = Integer.parseInt(cant);      
      for (int i = 0; i < cant1; i++) {
         nomSit = JOptionPane.showInputDialog(null, "nombre: ");
         sit1 = new Sitio(nomSit);
         lisSit.add(sit1);
      }
      Ciudad nueva = new Ciudad(nombCiudad, lisHot, lisRes, lisSit, lisPla);
      return nueva;
   }
   public String showMeName(Grafo<Ciudad> g) {
      String res = "";
      for (int i = 0; i < g.orden(); i++) {
         res += (i + 1) + " - " + g.obtVertice(i).getNombre() + "\n";
      }      
      return res;
   }   
   public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
      Grafo<Ciudad> gral;
      GrafoCiudades inicio = new GrafoCiudades();
      Persistencia archivo = new Persistencia();
      File angel = new File("archivo.ch");
      if (angel.exists()) {
         gral = archivo.recuperar("archivo.ch");
      }
      else {
         gral = new GrafoMat<>();
      }
      int sw = 1;
      String temp, temp2, temp3;
      String menu = "1- Insertar ciudad \n2- Insertar arista \n3- mostrar \n0- salir";      
      do {
         String opcion = JOptionPane.showInputDialog(menu);
         int opcion2 = Integer.parseInt(opcion);
         switch(opcion2)
         {
            case 1:               
               Ciudad verti = inicio.nuevaCiudad();
               gral.insVertice(verti);
               break;
            case 2:
//               temp = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de partida: ");
//               int data = Integer.parseInt(temp);
//               temp2 = JOptionPane.showInputDialog(null, "Ingrese el num del vertice de llegada: ");
//               int data2 = Integer.parseInt(temp2);
//               temp3 = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
//               int data3 = Integer.parseInt(temp3);
//               gra.insArista(data, data2, data3);
               break;
            case 3:               
               String bai = inicio.showMeName(gral);
               JOptionPane.showMessageDialog(null, bai);
               break;
            case 0:
               sw = 0;
               archivo.guardar(gral);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);
   }
}
