/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Random;

/**
 *
 * @author 57300
 */
public class GeneradorNumRandom {
   private Random rnd;
   private int limiteRango1;
   private int limiteRango2;

   public GeneradorNumRandom() {
      this.rnd = new Random();
      this.limiteRango1 = 100;
      this.limiteRango2 = 1000;
   }
   
   int getNumeroRandom() {
      if (limiteRango1 < limiteRango2) {
         return rnd.nextInt(limiteRango2 - limiteRango1 + 1) + limiteRango1;
      }
      else {
         return rnd.nextInt(limiteRango1 - limiteRango2 + 1) + limiteRango2;
      }      
   }
}
