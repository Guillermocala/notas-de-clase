/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import Principal.Conductor;
import Principal.Ordenamiento;
import Principal.Persistencia;
import Principal.Platform;
import Principal.SortByPlate;
import Principal.Taxi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Test {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      Platform nuevo;
      Taxi taxi;
      Conductor conductor;
      Ordenamiento orden = new Ordenamiento();
      Persistencia archivo = new Persistencia();
      File angel = new File("archivo.ch");
      if (angel.exists()) {
         nuevo = archivo.recuperar("archivo.ch");
      }
      else {
         nuevo = new Platform();
      }
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1, sw5 = 1, sw6 = 1;
      long cedula;
      String placa, nombre, cedu, carrera, showMe;
      String menu = "MENU PRINCIPAL\n1- Ingresar \n2- Asignaciones \n3- Mostrar \n4- Buscar \n5- Eliminacion \n0- Salir";
      String menu2 = "INSERCION \n1- Taxi \n2- Conductor \n0- Salir";
      String menu3 = "ASIGNACIONES \n1- Conductor a taxi \n2- Carrera a taxi \n0- Salir";
      String menu4 = "LISTADO \n1- Taxis ordenado por placa \n2- Conductores ordenado por cedula \n3- Taxis con sus carreras \n0- Salir";
      String menu5 = "BUSQUEDA \n1- Taxi por placa \n2- Conductor por nombre \n0- Salir";
      String menu6 = "ELIMINACION \n1- Taxi por placa \n2- Conductor por nombre \n3- Carrera de taxi\n0- Salir";
      do {
         String opcionSub = JOptionPane.showInputDialog(menu);
         int opcionSub2 = Integer.parseInt(opcionSub);
         switch(opcionSub2)
         {
            case 1:
               // SUB-MENU DE INSERCION
               do {
                  opcionSub = JOptionPane.showInputDialog(menu2);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //INSERTA TAXI
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa del taxi: ");
                        nuevo.addTaxi(new Taxi(placa));
                        break;
                     case 2:
                        //INSERTA CONDUCTOR
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del conductor: ");
                        cedu = JOptionPane.showInputDialog(null, "Ingrese la cedula: ");
                        cedula = Long.parseLong(cedu);
                        nuevo.addConductor(new Conductor(cedula, nombre));
                        break;
                     case 0:
                        sw2 = 0;             
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
                  archivo.guardar(nuevo);
               } while(sw2 != 0);
               break;
            case 2:
               //SUB-MENU DE ASIGNACIONES
               do {
                  opcionSub = JOptionPane.showInputDialog(menu3);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //ASIGNA CONDUCTOR A TAXI
                        cedu = JOptionPane.showInputDialog(null, "Ingrese la cedula del conductor: ");
                        cedula = Long.parseLong(cedu);
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa del taxi a asignar: ");
                        nuevo.asigConducTaxi(cedula, placa);
                        break;
                     case 2:
                        //ASIGNA CARRERA A TAXI
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa del taxi: ");
                        carrera = JOptionPane.showInputDialog(null, "Ingrese la carrera: ");
                        nuevo.asigCarreraTaxi(placa, carrera);
                        break;
                     case 0:
                        sw3 = 0;               
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
                  archivo.guardar(nuevo);
               } while(sw3 != 0);
               break;
            case 3:
               //SUB-MENU DE LISTADOS
               do {
                  showMe = "";
                  opcionSub = JOptionPane.showInputDialog(menu4);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //LISTA TAXIS ORDENADOS POR PLACA
                        if (orden.isOrderedPlate(nuevo.getTaxis())) {
                           for (int i = 0; i < nuevo.getTaxis().size(); i++) {
                              Taxi taxiTemp = nuevo.getTaxis().get(i);
                              showMe += "[" + (i + 1) + "]" + taxiTemp.toString();
                           }
                        }
                        else {
                           Collections.sort(nuevo.getTaxis(), new SortByPlate());
                           for (int i = 0; i < nuevo.getTaxis().size(); i++) {
                              Taxi taxiTemp = nuevo.getTaxis().get(i);
                              showMe += "[" + (i + 1) + "]" + taxiTemp.toString();
                           }
                        }
                        JOptionPane.showMessageDialog(null, showMe);
                        break;
                     case 2:
                        //LISTA CONDUCTORES ORDENADOS POR CEDULA
                        if (orden.isOrderedCedu(nuevo.getConductores())) {
                           for (int i = 0; i < nuevo.getConductores().size(); i++) {
                              Conductor conduc = nuevo.getConductores().get(i);
                              showMe += "\t[" + (i + 1) + "]" + conduc.toString();
                           }
                        }
                        else {
                           orden.sortByCedu(nuevo.getConductores());
                           for (int i = 0; i < nuevo.getConductores().size(); i++) {
                              Conductor conduc = nuevo.getConductores().get(i);
                              showMe += "\t[" + (i + 1) + "]" + conduc.toString();
                           }
                        }
                        JOptionPane.showMessageDialog(null, showMe);
                        break;
                     case 3:
                        //LISTA TAXIS CON SUS CARRERAS
                        if (orden.isOrderedPlate(nuevo.getTaxis())) {
                           for (int i = 0; i < nuevo.getTaxis().size(); i++) {
                              Taxi taxiTemp = nuevo.getTaxis().get(i);
                              showMe += "[" + (i + 1) + "]" + taxiTemp.listarAll();
                           }
                        }
                        else {
                           Collections.sort(nuevo.getTaxis(), new SortByPlate());
                           for (int i = 0; i < nuevo.getTaxis().size(); i++) {
                              Taxi taxiTemp = nuevo.getTaxis().get(i);
                              showMe += "[" + (i + 1) + "]" + taxiTemp.listarAll();
                           }
                        }
                        break;
                     case 0:
                        sw4 = 0;               
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
                  archivo.guardar(nuevo);
               } while(sw4 != 0);
               break;
            case 4:
               //SUB-MENU DE BUSQUEDAS
               do {
                  opcionSub = JOptionPane.showInputDialog(menu5);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //BUSQUEDA TAXI POR PLACA
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa a buscar: ");
                        taxi = nuevo.busqLinealTaxi(placa);
                        JOptionPane.showMessageDialog(null, taxi.listarAll());
                        break;
                     case 2:
                        //BUSQUEDA CONDUCTOR POR NOMBRE
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar: ");
                        conductor = nuevo.busqLinealConduc(nombre);
                        JOptionPane.showMessageDialog(null, conductor.listarAll());
                        break;                     
                     case 0:
                        sw5 = 0;
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
               } while(sw5 != 0);
               break;
            case 5:
               //SUB-MENU DE ELIMINACION
               do {
                  opcionSub = JOptionPane.showInputDialog(menu6);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //ELIMINA TAXI POR PLACA
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa a buscar: ");
                        nuevo.elimTaxi(placa);
                        break;
                     case 2:
                        //ELIMINA CONDUCTOR POR NOMBRE
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar: ");
                        nuevo.elimConduc(nombre);
                        break;
                     case 3:
                        //ELIMINA CARRERA
                        placa = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
                        taxi = nuevo.busqLinealTaxi(placa);
                        carrera = JOptionPane.showInputDialog(null, "Ingrese la carrera: ");
                        nuevo.elimCarrera(taxi, carrera);
                        break;
                     case 0:
                        sw6 = 0;
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
                  archivo.guardar(nuevo);
               } while(sw6 != 0);
               break;
            case 0:
               sw = 0;               
               break;
            default:
               JOptionPane.showMessageDialog(null, "Dato incorrecto!");
               break;
         }
      } while(sw != 0);
   }
}
