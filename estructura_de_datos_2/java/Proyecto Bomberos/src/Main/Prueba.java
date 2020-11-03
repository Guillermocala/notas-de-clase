/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Datos.Barrio;
import Datos.EstacionBomb;
import Datos.Maquina;
import Datos.Persistencia;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author 57300
 */
public class Prueba {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      EstacionBomb central;
      
      /*CREO UN OBJETO DE PERSISTENCIA LUEGO OTRO DE FILE Y COMPARO SI EXISTE EN LA CARPETA DEL PROYECTO, SI 
      ESTA RECUPERO LOS DATOS, SINO INICIALIZO LA ESTACION*/
      Persistencia archivo = new Persistencia();
      File angel = new File("archivo.ch");
      if (angel.exists()) {
         central = archivo.recuperar("archivo.ch");
      }
      else {
         central = new EstacionBomb();
      }
      boolean temp;
      
      /*los sw son los controladores de los switch case que a su vez controlan los menus*/
      int sw = 1, sw2 = 1, sw3 = 1;
      int dato, opt, cantMaqui;
      String nombre, opcion, aux;
      
      /*el textarea y scroll es para visualizar bien una cantidad ed datos muy grande que el joptionpane no es capaz de abarcar*/
      JTextArea textArea;
      JScrollPane scrollPane;
      
      /*aca estan todos los menus que uso*/
      String menu = "1-Insertar Maquinas(una vez) \n2-Ingresa Barrio \n3-Ingresa Tiempo \n4-Reportar Accidente \n5-Mostrar \n6-Reportes \n7-Aislar barrio \n8-Inhabilitar Maquina \n9-Recorridos \n0-Salir";
      String menu2 = "1-% Trabajo de cada Maquina \n2-Barrio con mas Accidentes \n3-Consulta Maquina y sus accidentes \n0-Salir";
      String menu3 = "1-Mostrar Grafo \n2-Mostrar Maquinas \n3-Salir";
      String menu4 = "1.Recorrido DFS \n2-Recorrido BFS";
      String advice = "Usted ha ingresado maquinas anteriormente, si continua restablecerá las mismas \n1-Continuar \n2-salir";
            
      do {
         opcion = JOptionPane.showInputDialog(menu);
         opt = Integer.parseInt(opcion);
         switch(opt) {
            case 1:
               /*Insertar maquinas inicialmente*/
               /*VERIFICO QUE HAYA ELEMENTOS EN EL GRAFO CON ORDEN > 0*/
               if (central.getCiudad().orden() > 0) {
                  /**SI LA ESTACION YA TIENE MAQUINAS, LA ESTACION SIEMPRE VA EN LA PRIMERA POSICION
                   * DEL GRAFO, VERTICE(0)*/
                  if (!(central.getMaquinas().isEmpty())) {
                     /*ACA VA UN MENSAJE DE ALERTA, PORQUE PUEDE BORRAR LOS DATOS QUE HABIA ANTES*/
                     opt = Integer.parseInt(JOptionPane.showInputDialog(advice));
                     if (opt == 1) {
                        cantMaqui = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de maquinas(mayor que cero): "));
                        /*VERIFICO QUE INGRESE NUMEROS MAYORES QUE CERO, SI LO HACE TENDRA QUE INGRESAR UN NUMERO MAYOR PARA PODER SEGUIR*/
                        while (cantMaqui <= 0) {
                           cantMaqui = Integer.parseInt(JOptionPane.showInputDialog("Dato erroneo! \nIngrese el numero de maquinas(mayor que cero): "));
                        }
                        /*BORRO LOS DATOS ANTERIORES CON DELMAQUINAS Y LUEGO USO LA FUNCION PARA GENERAR LAS MAQUINAS*/
                        central.delMaquinas();
                        central.generarMaquinas(cantMaqui);
                     }                  
                  }
                  else {
                     cantMaqui = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de maquinas: "));
                     while (cantMaqui <= 0) {
                        cantMaqui = Integer.parseInt(JOptionPane.showInputDialog("Dato erroneo! \nIngrese el numero de maquinas(mayor que cero): "));
                     }
                     central.generarMaquinas(cantMaqui);
                  }
                  /*GUARDAMOS DE UNA VEZ*/
                  archivo.guardar(central);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 2:
               /*Ingresa barrio*/
               nombre = JOptionPane.showInputDialog("Ingrese el nombre del barrio: ");
               /*VERIFICO QUE EL NOMBRE NO SE REPITA CON UN BOOLEANO, UN CICLO Y LA FUNCION COMPARETO*/
               temp = false;               
               for (int i = 0; i < central.getCiudad().orden(); i++) {
                  if (nombre.compareTo(central.getCiudad().obtVertice(i).getNombre()) == 0) {
                     temp = true;
                     break;
                  }
               }
               if (temp) {
                  JOptionPane.showMessageDialog(null, "Ya existente!");
               }
               else {
                  /*INSERTO Y GUARDO*/
                  central.getCiudad().insVertice(new Barrio(nombre));
                  archivo.guardar(central);
               }               
               break;
            case 3:
               /*Ingresa Arista*/
               /*VERIFICO SI GRAFO ESTA VACIO*/
               if (central.getCiudad().orden() > 0) {
                  int vi = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice inicial: "));
                  int vf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el vertice final: "));
                  dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo: "));
                  /**NO NECESITO VERIFICAR, PORQUE LAS VERIFICACIONES LAS PUSE EN EL TAD :)
                   * INSETO Y GUARDO*/
                  central.getCiudad().insArista(vi, vf, dato);
                  archivo.guardar(central);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 4:
               /*reportar un accidente*/
               /**VERIFICO GRAFO VACIO Y PREGUNTO POR EL BARRIO DESDE EL INDICE QUE SE PUEDE VER CON LA OPCION
                * MOSTRAR, SI ESTA MAL ENTONCES LE SIGO PIDIENDO EL DATO HASTA QUE LO DIGITE BIEN*/
               if (central.getCiudad().orden() > 0) {
                  dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + central.getCiudad().orden() + "): "));
                  while (dato < 0 || dato >= central.getCiudad().orden()) {                     
                     dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + central.getCiudad().orden() + "): "));
                  }
                  /*COMO LAS MAQUINAS SE DEBEN DESOCUPAR ACA VA LA FUNCION Y LUEGO LA FUNCION DE MOVER LA MAQUINA MAS CERCANA Y LIBRE*/
                  central.moverMaquina(dato);
                  archivo.guardar(central);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 5:
               /*mostrar*/
               /*SI GRAFO TIENE ELEMENTOS SIGO...*/
               if (central.getCiudad().orden() > 0) {
                  do {
                     opcion = JOptionPane.showInputDialog(menu3);
                     opt = Integer.parseInt(opcion);
                     switch(opt) {
                        case 1:
                           /*Mstrar grafo*/
                           /*LO DE LOS TEXTAREA LO COGI DE INTERNET XD*/
                           /*EL ARGUMENTO DEL JTEXTAREA ES EL ESTRING QUE VAMOS A MOSTRAR*/
                           textArea = new JTextArea(central.getCiudad().mostrar());
                           scrollPane = new JScrollPane(textArea);
                           textArea.setLineWrap(true);  
                           textArea.setWrapStyleWord(true);
                           /*LOS NUMEROS SON LAS DIMENSIONES DE LA VENTANA*/
                           scrollPane.setPreferredSize(new Dimension(850,250));
                           JOptionPane.showMessageDialog(null, scrollPane, "                    GRAFO BARRIOS", JOptionPane.YES_NO_OPTION);
                           break;
                        case 2:
                           /*Mostrar Maquinas*/
                           /*PREGUNTO SI HAY MAQUINAS PARA MOSTRAR*/
                           if (!(central.getMaquinas().isEmpty())) {
                              /*USO UN AUXILIAR Y LE METO EL TOSTRING DE LAS MAQUINAS*/
                              aux = "";
                              for (Maquina maqui : central.getMaquinas()) {
                                 aux += maqui.toString() + "\n";
                              }
                              textArea = new JTextArea(aux);
                              scrollPane = new JScrollPane(textArea);
                              textArea.setLineWrap(true);  
                              textArea.setWrapStyleWord(true); 
                              scrollPane.setPreferredSize(new Dimension(850,250));
                              JOptionPane.showMessageDialog(null, scrollPane, "                    MAQUINAS", JOptionPane.YES_NO_OPTION);
                           }
                           else {
                              JOptionPane.showMessageDialog(null, "No hay maquinas para mostrar!");
                           }
                           break;
                        case 3:
                           sw3 = 0;
                           break;
                        default:
                           JOptionPane.showMessageDialog(null, "Opcion invalida");
                           break;
                     }
                  } while(sw3 != 0);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 6:
               /*reportes*/
               /*VERIFICO SI ESTA VACIO PARA MOSTRAR LOS REPORTES*/
               if (central.getCiudad().orden() > 0) {
                  do {
                     String opcion2 = JOptionPane.showInputDialog(menu2);
                     int op2 = Integer.parseInt(opcion2);
                     switch(op2) {
                        case 1:
                           /*% trabajo per maquina*/
                           central.trabajoMaquinas();
                           break;
                        case 2:
                           /*barrio mas incendiado*/
                           central.barrioMasAccidentes();
                           break;
                        case 3:
                           /*maquina y sus accidentes*/
                           dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la maquina a buscar: "));
                           JOptionPane.showMessageDialog(null, central.consultaMaq(dato));
                           break;
                        case 0:
                           /*salir*/
                           sw2 = 0;
                           break;
                        default:
                           JOptionPane.showMessageDialog(null, "Opcion invalida");
                           break;
                     }
                  } while(sw2 != 0);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 7:
               /*aislar barrio*/
               /*VERIFICACION DE RUTINA*/
               if (central.getCiudad().orden() > 0) {
                  dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(> 0 y < " + central.getCiudad().orden() + "): "));
                  while (dato <= 0 || dato >= central.getCiudad().orden()) {
                     /**VEO SI QUIERE AISLAR LA PRIMERA POSICION QUE SUPONE ES LA ESTACION
                      * POR LO TANTO NO TIENE MUCHO SENTIDO AISLARLA*/
                     if (dato == 0) {
                        JOptionPane.showMessageDialog(null, "No se puede aislar la Estacion de Bomberos");
                     }
                     dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(> 0 y < " + central.getCiudad().orden() + "): "));
                  }
                  /*ACA VA LA FUNCION DE AISLAR*/
                  central.aislar(dato);
                  archivo.guardar(central);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 8:
               /*inhabilitar maquina*/
               if (central.getCiudad().orden() > 0) {
                  dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la maquina a inhabilitar: "));
                  /*LLAMAMOS LA FUNCION Y GUARDAMOS*/
                  central.inhabilitar(dato);
                  archivo.guardar(central);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 9:
               /*recorridos*/
               if (central.getCiudad().orden() > 0) {
                  /*COMO EL RECORRIDOS DEVUELVE U STRING LO MUESTRO DE UNA VEZ CON EL TEXTAREA PORQUE
                  SON MUCHOS DATOS PARA UN JOPTION*/
                  opt = Integer.parseInt(JOptionPane.showInputDialog(menu4));
                  textArea = new JTextArea(central.recorridos(opt));
                  scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true);
                  textArea.setWrapStyleWord(true);
                  scrollPane.setPreferredSize(new Dimension(850,250));
                  JOptionPane.showMessageDialog(null, scrollPane, "                    RECORRIDO", JOptionPane.YES_NO_OPTION);
               }
               else {
                  JOptionPane.showMessageDialog(null, "No hay barrios!");
               }
               break;
            case 0:
               /*salir*/
               sw = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opcion invalida");
               break;
         }            
      }while(sw != 0);
   }
}
