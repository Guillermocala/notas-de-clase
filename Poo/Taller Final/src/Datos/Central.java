/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillermo
 */
public class Central implements Serializable{
   private ArrayList<Articulo> inventario = new ArrayList<>();
   private ArrayList<Articulo> vendidos = new ArrayList<>();
   private ArrayList<Articulo> empeniados = new ArrayList<>();
   private ArrayList<Articulo> empeniadosVencidos = new ArrayList<>();
   private String fechaInicial = "";
   private String fechaMod = "";
   /**
    * @return the inventario
    */
   
   public String generaFecha(){
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      LocalDateTime actual = LocalDateTime.now();  //aca sacamos la fecha de nuestra pc
      String fecha = formato.format(actual);
      return fecha;
   }
   public String getFechaInicial(){
      return this.fechaInicial;
   }
   
   public void setFechaMod(String fecha){
      this.fechaMod = fecha;
   }
   
   public boolean isDateChanged(){
      if (this.fechaInicial.equalsIgnoreCase(this.fechaMod)) {
         return false;
      }
      return true;
   }
   public ArrayList<Articulo> getInventario() {
      return inventario;
   }

   /**
    * @param inventario the inventario to set
    */
   public void setInventario(ArrayList<Articulo> inventario) {
      this.inventario = inventario;
   }

   /**
    * @return the vendidos
    */
   public ArrayList<Articulo> getVendidos() {
      return vendidos;
   }

   /**
    * @param vendidos the vendidos to set
    */
   public void setVendidos(ArrayList<Articulo> vendidos) {
      this.vendidos = vendidos;
   }

   /**
    * @return the empeniados
    */
   public ArrayList<Articulo> getEmpeniados() {
      return empeniados;
   }

   /**
    * @param empeniados the empeniados to set
    */
   public void setEmpeniados(ArrayList<Articulo> empeniados) {
      this.empeniados = empeniados;
   }

   /**
    * @return the empeniadosVencidos
    */
   public ArrayList<Articulo> getEmpeniadosVencidos() {
      return empeniadosVencidos;
   }

   /**
    * @param empeniadosVencidos the empeniadosVencidos to set
    */
   public void setEmpeniadosVencidos(ArrayList<Articulo> empeniadosVencidos) {
      this.empeniadosVencidos = empeniadosVencidos;
   }
   
   public String inventario(){
      String res = "";
      for (Articulo articulo : inventario) {
         res += articulo.toString() + "\n";
      }
      return res;
   }
   //esto es para mostrar en el jlist de ventas
   public String[] inventarioInArray(){
      String []res = new String[inventario.size()];
      for (int i = 0; i < inventario.size(); i++) {
         res[i] = inventario.get(i).getNombre();
      }
      return res;
   }
   
   public String empenados(){
      String res = "";
      for (Articulo articulo : empeniados) {
         res += articulo.toString() + "\n";
      }
      return res;
   }
   
   public String vendidos(){
      String res = "";
      for (Articulo articulo : vendidos) {
         res += articulo.toString() + "\n";
      }
      return res;
   }
   
   public String empenadosVencidos(){
      String res = "";
      for (Articulo articulo : empeniadosVencidos) {
         res += articulo.toString() + "\n";
      }
      return res;
   }
   
   //verificaciones de compra
   public boolean verificaNombreInven(String name){
      boolean fine = true;
      for (Articulo articulo : inventario) {
         if (articulo.getNombre().equalsIgnoreCase(name)) {
            JOptionPane.showMessageDialog(null, "El nombre ingresado ya esta en uso");
            fine = false;
         }
      }
      return fine;
   }
   public boolean verificaNoNegativo(int value){
      boolean fine = true;
      if (value < 1) {
         JOptionPane.showMessageDialog(null, "El valor tiene que ser positivo o distinto de cero");
         fine = false;
      }
      return fine;
   }
   public boolean verificaFecha(String fecha){
      boolean fine = true;
      if (fecha.length() != 10) {
         JOptionPane.showMessageDialog(null, "no se ha respetado el formato de fecha");
         fine = false;
      }
      else{
         String dia = fecha.substring(0, 2);
         String mes = fecha.substring(3, 5);
         String anio = fecha.substring(6, 10);
         System.out.println(dia);
         System.out.println(mes);
         System.out.println(anio);
         if (Integer.parseInt(dia) < 0 || Integer.parseInt(dia) > 30) {
            fine = false;
            JOptionPane.showMessageDialog(null, "dia incorrecto");
         }
         if (Integer.parseInt(mes) < 0 || Integer.parseInt(mes) > 12) {
            fine = false;
            JOptionPane.showMessageDialog(null, "mes incorrecto");
         }
         if (Integer.parseInt(anio) < 1500 || Integer.parseInt(anio) > 2500) {
            System.out.println("hola???'");
            fine = false;
            JOptionPane.showMessageDialog(null, "año incorrecto(1500 a 2500)");
         }
      }
      return fine;
   }
   public boolean verificaCompra(String nombre, int valor, String fecha, int cantidad){
      boolean fine = false;              
      if (verificaNombreInven(nombre) && verificaNoNegativo(valor) && verificaFecha(fecha) && verificaNoNegativo(cantidad)) {
         inventario.add(new Articulo(nombre, valor, fecha + generaFecha().substring(10, 19), "Undefined", cantidad));
         fine = true;
      }
      return fine;
   }
   
   //verificaciones de empenio
   public boolean verificaNombreEmpe(String name){
      boolean fine = true;
      for (Articulo articulo : empeniados) {
         if (articulo.getNombre().equalsIgnoreCase(name)) {
            JOptionPane.showMessageDialog(null, "El nombre ingresado ya esta en uso");
            fine = false;
         }
      }
      return fine;
   }
   public boolean verificaFechas(String fechaIngreso, String fechaRetiro){
      boolean fine = true;
      String diaIngre = fechaIngreso.substring(0, 2);
      String mesIngre = fechaIngreso.substring(3, 5);
      String anioIngre = fechaIngreso.substring(6, 10);
      String diaReti = fechaRetiro.substring(0, 2);
      String mesReti = fechaRetiro.substring(3, 5);
      String anioReti = fechaRetiro.substring(6, 10);
      if ((Integer.parseInt(anioReti) < Integer.parseInt(anioIngre)) || (Integer.parseInt(mesReti) < Integer.parseInt(mesIngre)) || (Integer.parseInt(diaReti) < Integer.parseInt(diaIngre))) {
         fine = false;
      }
      if (Integer.parseInt(diaReti) == Integer.parseInt(diaIngre) && Integer.parseInt(mesReti) == Integer.parseInt(mesIngre)) {
         if (Integer.parseInt(anioReti) <= Integer.parseInt(anioIngre) ) {
            fine = false;
         }
      }
      if (Integer.parseInt(mesIngre) == Integer.parseInt(mesReti) && Integer.parseInt(anioIngre) == Integer.parseInt(anioReti)) {
         if (Integer.parseInt(diaReti) <= Integer.parseInt(diaIngre) ) {
            fine = false;
         }
      }
      if (Integer.parseInt(diaReti) == Integer.parseInt(diaIngre) && Integer.parseInt(anioIngre) == Integer.parseInt(anioReti)) {
         if (Integer.parseInt(mesReti) <= Integer.parseInt(mesIngre) ) {
            fine = false;
         }
      }
      return fine;
   }
   
   public boolean verificaEmpenio(String nombre, int monto, String fechaIngreso, String fechaRetiro, int cantidad){
      boolean fine = false;
      if (verificaNombreEmpe(nombre) && verificaNoNegativo(monto) && verificaFecha(fechaIngreso) && verificaFecha(fechaRetiro) && verificaNoNegativo(cantidad)) {
         if (verificaFechas(fechaIngreso, fechaRetiro)) {
            empeniados.add(new Articulo(nombre, monto, fechaIngreso + generaFecha().substring(10, 19), fechaRetiro + generaFecha().substring(10, 19), cantidad));
            fine = true;
         }
         else{
            JOptionPane.showMessageDialog(null, "La fecha de retiro no puede ser anterior a la de ingreso");
         }
      }
      return fine;
   }
}
