/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;

/**
 *
 * @author 57300
 */
public class Arista implements Serializable{
   private int vf;
   private int datoArista;

   public Arista(int vf, int datoArista) {
      this.vf = vf;
      this.datoArista = datoArista;
   }

   /**
    * @return the vf
    */
   public String showMeAri() {
      String res = "";
      res += "[ " + this.datoArista + " | " + this.vf + " ]";
      return res;
   }
   public int getVf() {
      return vf;
   }

   /**
    * @param vf the vf to set
    */
   public void setVf(int vf) {
      this.vf = vf;
   }

   /**
    * @return the datoArista
    */
   public int getDatoArista() {
      return datoArista;
   }

   /**
    * @param datoArista the datoArista to set
    */
   public void setDatoArista(int datoArista) {
      this.datoArista = datoArista;
   }
}
