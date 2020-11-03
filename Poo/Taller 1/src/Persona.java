/**
 * @(#)Persona.java
 *
 *
 * @author 
 * @version 1.00 2020/9/14
 */


public class Persona {

    private String nombre;
   private String apellido;
   private long id;
   private int edad;
   private String genero;
   private String ciudad;

   public Persona() {
      this.nombre = "";
      this.apellido = "";
      this.id = 0;
      this.edad = 0;
      this.genero = "";
      this.ciudad = "";
   }

   public String toString() {
      return "nombre = " + nombre + ", apellido = " + apellido + ", id = " + id + ", edad = "
              + edad + ", genero = " + genero + ", ciudad = " + ciudad;
   }
  
   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public double getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public int getEdad() {
      return edad;
   }

   public void setEdad(int edad) {
      if (edad <= 0) {
         System.out.println("la edad no puede ser menor o igual a 0");
      }
      else{
         this.edad = edad;
      }
      
   }

   public String getGenero() {
      return genero;
   }

   public void setGenero(String genero) {
      String temp = genero.toLowerCase();
      if (temp.equals("femenino") || temp.equals("masculino")) {
         this.genero = genero;
      }
      else{
         System.out.println("dato invalido, verifique");         
      }
   }

   public String getCiudad() {
      return ciudad;
   }

   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }
   
   //metodo para a?o de nacimiento segun edad
   public static int edadActual(int edad){
      if (edad > 0) {
         final int anioActual = 2020;
         int temp = anioActual - edad;         
         return temp;
      }
      else{
         System.out.println("edad invalida");
         return 0;
      }
   }
   
   //metodo para CamelCase en nombre y apellido
   public static void applyCamel(Persona pers){
      if (pers.getNombre().isEmpty() || pers.getApellido().isEmpty()) {
         System.out.println("No hay nombre o apellido, verifique");
      }
      else{
         /*aplico el setter para modificar. en el parametro saco con substring la primera letra
         es decir del digito 0 al 1 y el aplico el uppercase, luego le concateno el resto con la misma funcion*/
         pers.setNombre(pers.getNombre().substring(0, 1).toUpperCase() + pers.getNombre().substring(1));
         pers.setApellido(pers.getApellido().substring(0, 1).toUpperCase() + pers.getApellido().substring(1));
      }
   }
    
}