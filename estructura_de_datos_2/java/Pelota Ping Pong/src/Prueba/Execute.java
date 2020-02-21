/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Datos.Pelota;
import java.util.Scanner;

/**
 *
 * @author 57300
 */
public class Execute {
   public static void main(String[] args) {
      Pelota obj = new Pelota();
      Scanner entrada = new Scanner(System.in);
      double velIni, distancia;
      System.out.println("Ingrese la velocidad inicial: ");
      velIni = entrada.nextFloat();
      obj.setVelInicial(velIni);
      /*GUARDAMOS ENSEGUIDA EL VALOR YA QUE ES EL PRIMERO DE LA COLECCION DISTANCIAS*/
      obj.addVelocidad(velIni); 
      System.out.println("Ingrese el angulo: ");
      obj.setAngulo(entrada.nextInt());      
      /*HACEMOS LA OPERACION DENTRO DE UN CICLO Y VAMOS GUARDANDO*/
      for (double i = velIni; i > 1.0;) {
         distancia = (Math.pow(i, 2) * Math.sin(2 * obj.getAngulo())) / 9.8;
         /*REDUCIMOS EL 15% A LA VELOCIDAD Y GUARDAMOS*/
         obj.addDistancia(distancia);
         i -= i * obj.getDecadencia();
         obj.addVelocidad(i);
      }
      /*MOSTRAMOS CON STRING.FORMAT como el .size() nos da un valor maximo, hay que 
      restarle 1 para que tenga en cuenta el comienzo en 0 y no nos de problemas de lectura*/
      for (int i = 0; i < (obj.getVelocidades().size() - 1); i++) {
         System.out.println("Rebote " + i + "\t" + String.format("%.2f", obj.getVelocidades().get(i)) + 
                 "\t" + obj.getAngulo() + "\t" + String.format("%.2f", obj.getDistancias().get(i)));
      }
      System.out.println("Distancia total: " + String.format("%.2f", obj.sumDistancias()));
   }
}
