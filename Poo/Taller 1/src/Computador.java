/**
 * @(#)Computador.java
 *
 *
 * @author 
 * @version 1.00 2020/9/14
 */


public class Computador {

    private String tipo;
   private String marca;
   private float memRam;
   private float velProcesador;
   private int memRom;

   public Computador() {
      this.tipo = "";
      this.marca = "";
      this.memRam = 0;
      this.velProcesador = 0;
      this.memRom = 0;
   }

   @Override
   public String toString() {
      return "tipo = " + tipo + ", marca = " + marca + ", memRam = " + memRam + "GB, "
              + "velProcesador = " + velProcesador + "GHz, memRom = " + memRom + "GB";
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public float getMemRam() {
      return memRam;
   }

   public void setMemRam(float memRam) {
      if (memRam <= 0) {
         System.out.println("valor invalido, verifique");
      }
      else{
         this.memRam = memRam;
      }
   }

   public float getVelProcesador() {
      return velProcesador;
   }

   public void setVelProcesador(float velProcesador) {
      if (velProcesador <= 0) {
         System.out.println("valor invalido, verifique");
      }
      else{
         this.velProcesador = velProcesador;
      }
   }

   public int getMemRom() {
      return memRom;
   }

   public void setMemRom(int memRom) {
      if (memRom <= 0) {
         System.out.println("valor invalido, verifique");
      }
      else{
         this.memRom = memRom;
      }
   }
   
   //metodo evaluar
   public static String evaluar(Computador pc) {
      float vel = (pc.getVelProcesador() * 40) / 100;
      int rom = (pc.getMemRom()* 30) / 100;
      float ram = (pc.getMemRam()* 30) / 100;
      String res = "\nProcesador: " + vel + "GHZ, Memoria ROM: " + rom + "GB, Memoria RAM: " + ram + "GB";
      return res;
   }
   
   //method upgrade 15%
   public static void upgrade(Computador pc, int opt) {      
      switch(opt) {
         case 1:  //up procesador
            float procesador = (pc.getVelProcesador() * 15) / 100;
            pc.setVelProcesador(pc.getVelProcesador() + procesador);
            break;
         case 2:  //up ram
            float ram = (pc.getMemRam() * 15) / 100;
            pc.setMemRam(pc.getMemRam() + ram);
            break;
         case 3:  //up rom
            int rom = (pc.getMemRom() * 15) / 100;
            pc.setMemRom(pc.getMemRom() + rom);
            break;
         default:
            System.out.println("opcion invalida");
            break;
      }
   }
    
    
}