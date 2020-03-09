/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;

/**
 *
 * @author 57300
 */
public class Jugador implements Serializable{
   private String nombre;
   private float salario;
   private int codigo;
   private int goles;

   public Jugador(String nombre, float salario, int codigo, int goles) {
      this.nombre = nombre;
      this.salario = salario;
      this.codigo = codigo;
      this.goles = goles;
   }

   @Override
   public String toString() {
      return "Jugador{" + "nombre=" + nombre + ", salario=" + salario + ", codigo=" + codigo + ", goles=" + goles + '}' + "\n";
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
    * @return the salario
    */
   public float getSalario() {
      return salario;
   }

   /**
    * @param salario the salario to set
    */
   public void setSalario(float salario) {
      this.salario = salario;
   }

   /**
    * @return the codigo
    */
   public int getCodigo() {
      return codigo;
   }

   /**
    * @param codigo the codigo to set
    */
   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   /**
    * @return the goles
    */
   public int getGoles() {
      return goles;
   }

   /**
    * @param goles the goles to set
    */
   public void setGoles(int goles) {
      this.goles = goles;
   }
   
}
