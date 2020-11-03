/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 57300
 */
public class main {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      EstacionBomberos estacion;
      /*aca usamos persistencia creamos un archivo con file y comprobamos si existe para recuperar los datos de ahi
      y cada vez que guardemos usamos guardado.guardar(estacion)*/
      Persistencia guardado = new Persistencia();
      File archivo = new File("bomberos.ch");
      if (archivo.exists()) {
         estacion = guardado.recuperar("bomberos.ch");
      }
      else {
         estacion = new EstacionBomberos();
      }
      
      
      boolean activador = true, activador2 = true;
      int opcion, vi, vf, dato;
      String placa, nombre, res;
      String menu = "1.ingresa camion \n2.ingresa barrio \n3.ingresa arista \n4.enviar maquina \n5.motrar grafo "
              + "\n6.reportes \n7.aislar barrio \n8.inhabilitar maquina \n9.recorrido anchura \n10.recorrido profundidad"
              + "\n0.salir \ningrese la opcion: ";
      String reportes = "1.% Trabajo cada camion \n2.Barrio con mas Accidentes \n3.Consulta Maquina y sus accidentes \n0.Salir";
      Scanner entrada = new Scanner(System.in);
      do {
         System.out.println(menu);
         opcion = entrada.nextInt();
         /*como al presionar enter luego de digitar un numero carga el bufer con un salto de linea
         toca limpiarlo despues con nextline, se hace cada vez que ingresa un numero*/
         entrada.nextLine();
         switch(opcion) {
            case 1: //ingresa camion
               System.out.println("ingrese placa del camion: ");
               placa = entrada.nextLine();
               estacion.ingresaCamion(placa);
               guardado.guardar(estacion);
               break;
            case 2: //ingresa barrio
               System.out.println("ingrese el nombre del barrio: ");
               nombre = entrada.nextLine();
               /*accedemos al grafo e insertamos el vertice creando el barrio con el nombre
               la cant de accidentes en 0 y null porque no hay un camion atendiento incendio*/
               estacion.getGraf().insVertice(new Barrio(nombre, 0, null));
               guardado.guardar(estacion);
               break;
            case 3: //ingresa arista
               System.out.println("ingrese el indice del barrio de partida: ");
               vi = entrada.nextInt();
               entrada.nextLine();
               System.out.println("ingrese el indice del barrio de llegada: ");
               vf = entrada.nextInt();
               entrada.nextLine();
               System.out.println("ingrese el tiempo entre ambos: ");
               dato = entrada.nextInt();
               entrada.nextLine();
               /*acedemos al grafo e insertamos aristas normalmente, toca limpiar cada que 
               digitamos un numero, por eso se hace algo larga esta opcion*/
               estacion.getGraf().insArista(vi, vf, dato);
               guardado.guardar(estacion);
               break;
            case 4: //enviar maquina
               System.out.println("ingrese el indice del barrio: ");
               dato = entrada.nextInt();
               entrada.nextLine();
               //verificamos que el vertice exista para poder hacer el recorrido
               if (dato < 0 || dato >= estacion.getGraf().orden()) {
                  System.out.println("valor incorrecto!");
               }
               else {
                  estacion.enviaCamion(dato);
                  guardado.guardar(estacion);
               }
               break;
            case 5: //mostrar grafo
               res = "";
               System.out.println(estacion.getGraf().mostrar());
               if (estacion.getCamiones().isEmpty()) {
                  System.out.println("\nNo hay camiones para mostrar...");
               }
               else{
                  for (Camion camione : estacion.getCamiones()) {
                     res += camione.toString();
                  }
                  System.out.println("\nLos camiones o maquinas... \n" + res);
               }
               break;
            case 6: //reportes
               do {                  
                  System.out.println(reportes);
                  opcion = entrada.nextInt();
                  /*como al presionar enter luego de digitar un numero carga el bufer con un salto de linea
                  toca limpiarlo despues con nextline, se hace cada vez que ingresa un numero*/
                  entrada.nextLine();
                  switch(opcion) {
                     case 1: // porcentajes
                        estacion.porcentajes();
                        break;
                     case 2: // barrio mas accidentado
                        System.out.println(estacion.masAccidentado());
                        break;
                     case 3: // consulta camion
                        System.out.println("Ingrese la placa del camion a consultar: ");
                        placa = entrada.nextLine();
                        System.out.println(estacion.consultaCamion(placa));
                        break;
                     case 0:
                        activador2 = false;
                        break;
                     default: 
                        System.out.println("opcion invalida");
                        break;
                  }
               } while (activador2);
               break;
            case 7: //aislar barrio
               System.out.println("ingrese el indice del barrio: ");
               dato = entrada.nextInt();
               entrada.nextLine();
               //verificamos que el vertice exista para poder hacer el recorrido
               if (dato < 0 || dato >= estacion.getGraf().orden()) {
                  System.out.println("valor incorrecto!");
               }
               else {
                  estacion.aislaBarrio(dato);
                  guardado.guardar(estacion);
               }
               break;
            case 8: //inhabilitar maquina
               System.out.println("ingrese la placa del camion: ");
               nombre = entrada.nextLine();
               estacion.inhabilitaCamion(nombre);
               guardado.guardar(estacion);
               break;
            case 9: //recorrido anchura
               System.out.println("ingrese el indice del barrio: ");
               dato = entrada.nextInt();
               entrada.nextLine();
               //verificamos que el vertice exista para poder hacer el recorrido
               if (dato < 0 || dato >= estacion.getGraf().orden()) {
                  System.out.println("valor incorrecto!");
               }
               else {
                  estacion.recoAnchura(dato);
               }
               break;
            case 10: //recorrido profundidad
               System.out.println("ingrese el indice del barrio: ");
               dato = entrada.nextInt();
               entrada.nextLine();
               if (dato < 0 || dato >= estacion.getGraf().orden()) {
                  System.out.println("valor incorrecto!");
               }
               else {
                  estacion.recoProfundidad(dato);
               }
               break;
            case 0:
               activador = false;
               break;
            default:
               System.out.println("opcion erronea!");
               break;
         }
      } while (activador);
   }
}
