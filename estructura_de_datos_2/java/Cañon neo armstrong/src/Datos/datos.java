/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class datos {
   private double velInicial;
   private double angulo;
   private double distancia;
   private double resultado;
   private GeneradorNumRandom gen = new GeneradorNumRandom();
   
   public double generaDistancia() {      
      distancia = gen.getNumeroRandom();
      return distancia;
   }
   public double getResultado() {
      return resultado;
   }
   public void setResultado(double x) {
      this.resultado = x;
   }
   public double getDistancia() {
      return distancia;
   }
   public void setDistancia(double x) {
      this.distancia = x;
   }
   /**
    * @param velInicial the velInicial to set
    */
   public void setVelInicial(double velInicial) {
      this.velInicial = velInicial;
   }

   /**
    * @param angulo the angulo to set
    */
   public void setAngulo(double angulo) {
      this.angulo = angulo;
   }

   /**
    * @return the velInicial
    */
   public double getVelInicial() {
      return velInicial;
   }

   /**
    * @return the angulo
    */
   public double getAngulo() {
      return angulo;
   }
   
}
