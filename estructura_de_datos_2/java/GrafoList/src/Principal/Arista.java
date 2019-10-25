/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 57300
 */
public class Arista {
   private Vertice vf;
   private int datoArista;

   public Arista(Vertice vf, int datoArista) {
      this.vf = vf;
      this.datoArista = datoArista;
   }

   /**
    * @return the vf
    */
   public Vertice getVf() {
      return vf;
   }

   /**
    * @param vf the vf to set
    */
   public void setVf(Vertice vf) {
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
