/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import Principal.Conductor;
import Principal.Taxi;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Test {
   public static void main(String[] args) {
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1, sw5 = 1;
      String placa, nombre;
      String menu = "MENU PRINCIPAL\n1- Ingresar \n2- Asignaciones \n3- Mostrar \n4- Buscar \n0- Salir";
      String menu2 = "INSERCION \n1- Taxi \n2- Conductor \n0- Salir";
      String menu3 = "ASIGNACIONES \n1- Conductor a taxi \n2- Carrera a taxi \n0- Salir";
      String menu4 = "LISTADO \n1- Taxis ordenado por placa \n2- Conductores ordenado por cedula \n 3- Taxis con sus carreras \n0- Salir";
      String menu5 = "BUSQUEDA \n1- Taxi por placa \n2- Conductor por nombre \n0- Salir";
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
                        
                        break;
                     case 2:
                        //INSERTA CONDUCTOR
                        
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
            case 2:
               //SUB-MENU DE ASIGNACIONES
               do {
                  opcionSub = JOptionPane.showInputDialog(menu3);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //ASIGNA CONDUCTOR A TAXI

                        break;
                     case 2:
                        //ASIGNA CARRERA A TAXI
                        
                        break;                     
                     case 0:
                        sw3 = 0;               
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
               } while(sw3 != 0);
               break;
            case 3:
               //SUB-MENU DE LISTADOS
               do {
                  opcionSub = JOptionPane.showInputDialog(menu4);
                  opcionSub2 = Integer.parseInt(opcionSub);
                  switch(opcionSub2)
                  {
                     case 1:
                        //LISTA TAXIS ORDENADOS POR PLACA
                        
                        break;
                     case 2:
                        //LISTA CONDUCTORES ORDENADOS POR CEDULA
                        
                        break;
                     case 3:
                        //LISTA TAXIS CON SUS CARRERAS
                        
                        break;
                     case 0:
                        sw4 = 0;               
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Dato incorrecto!");
                        break;
                  }
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
                        
                        break;
                     case 2:
                        //BUSQUEDA CONDUCTOR POR NOMBRE
                        
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
