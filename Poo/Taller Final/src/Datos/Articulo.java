/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Guillermo
 */
public class Articulo {
   private String nombre;
   private int valor;
   private String fechaIngreso;
   private String fechaSalida;
   private int cantidad;
   
   public Articulo(String nombre, int valor, String fechaIngreso, String fechaSalida, int cantidad) {
      this.nombre = nombre;
      this.valor = valor;
      this.fechaIngreso = fechaIngreso;
      this.fechaSalida = fechaSalida;
      this.cantidad = cantidad;
   }

   @Override
   public String toString() {
      return "Articulo{" + "nombre=" + nombre + ", valor=" + valor + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", cantidad=" + cantidad + '}';
   }
   
   /**
    * @return the nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * @param nombre the nombre to set
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * @return the valor
    */
   public int getValor() {
      return valor;
   }

   /**
    * @param valor the valor to set
    */
   public void setValor(int valor) {
      this.valor = valor;
   }

   /**
    * @return the fechaIngreso
    */
   public String getFechaIngreso() {
      return fechaIngreso;
   }

   /**
    * @param fechaIngreso the fechaIngreso to set
    */
   public void setFechaIngreso(String fechaIngreso) {
      this.fechaIngreso = fechaIngreso;
   }

   /**
    * @return the fechaSalida
    */
   public String getFechaSalida() {
      return fechaSalida;
   }

   /**
    * @param fechaSalida the fechaSalida to set
    */
   public void setFechaSalida(String fechaSalida) {
      this.fechaSalida = fechaSalida;
   }

   /**
    * @return the cantidad
    */
   public int getCantidad() {
      return cantidad;
   }

   /**
    * @param cantidad the cantidad to set
    */
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }
   
}
