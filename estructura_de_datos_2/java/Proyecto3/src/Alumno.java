
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 57300
 */
public class Alumno implements Serializable {
   private String nombre;
   private int codigo;
   private int edad;
   private int grado;

   public Alumno(String nombre, int codigo, int edad, int grado) {
      this.nombre = nombre;
      this.codigo = codigo;
      this.edad = edad;
      this.grado = grado;
   }

   @Override
   public String toString() {
      return "Alumno{" + "nombre=" + nombre + ", codigo=" + codigo + ", edad=" + edad + ", grado=" + grado + '}';
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
    * @return the edad
    */
   public int getEdad() {
      return edad;
   }

   /**
    * @param edad the edad to set
    */
   public void setEdad(int edad) {
      this.edad = edad;
   }

   /**
    * @return the grado
    */
   public int getGrado() {
      return grado;
   }

   /**
    * @param grado the grado to set
    */
   public void setGrado(int grado) {
      this.grado = grado;
   }
   
}
