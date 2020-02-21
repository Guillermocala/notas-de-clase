/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class Pelota {
   private double velInicial;
   private double angulo;
   private final double decadencia = 0.15; /*ESTA VARIABLE HACE REFERENCIA AL PORCENTAJE DE PERDIDA DE VELOCIDAD*/
   private ArrayList<Double> velocidades = new ArrayList<>();
   private ArrayList<Double> distancias = new ArrayList<>();
   
   
   
   public void addVelocidad(double x) {
      getVelocidades().add(x);
   }
   
   public void addDistancia(double x) {
      getDistancias().add(x);
   }
   
   /**
    * @return the velInicial
    */
   public double getVelInicial() {
      return velInicial;
   }

   /**
    * @param velInicial the velInicial to set
    */
   public void setVelInicial(double velInicial) {
      this.velInicial = velInicial;
   }

   /**
    * @return the angulo
    */
   public double getAngulo() {
      return angulo;
   }

   /**
    * @param angulo the angulo to set
    */
   public void setAngulo(int angulo) {
      this.angulo = angulo;
   }

   /**
    * @return the decadencia
    */
   public double getDecadencia() {
      return decadencia;
   }

   /**
    * @return the velocidades
    */
   public ArrayList<Double> getVelocidades() {
      return velocidades;
   }

   /**
    * @return the distancias
    */
   public ArrayList<Double> getDistancias() {
      return distancias;
   }
   
   public double sumDistancias() {
      double sum = 0;
      for (Double distancia : distancias) {
         sum += distancia;
      }
      return sum;
   }
   
}
