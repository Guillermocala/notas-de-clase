/**
 * @(#)Operaciones.java
 *
 *
 * @author 
 * @version 1.00 2020/11/4
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Operaciones {
	public boolean insertar(Vehiculo obj, Set<Vehiculo> lista){
      //validar que el vehiculo no este repetido(mismo id y placa)
      for (Vehiculo vehiculo : lista) {
         if ((obj.getId() == vehiculo.getId()) || (obj.getIdVehiculo().equalsIgnoreCase(vehiculo.getIdVehiculo()))) {
            return true;
         }
      }
      lista.add(obj);
      return false;
   }
   
   public boolean verificaTipo(String tipo){
      switch(tipo){
         case "CAMION":
            return true;
         case "CAMIONETA":
            return true;
         case "AUTOMOVIL":
            return true;
         default:
            return false;
      }
   }
    
   public Vehiculo buscar(String placa, Set<Vehiculo> lista){
      Vehiculo res = null;
      for (Vehiculo temp : lista) {
         if (temp.getIdVehiculo().equalsIgnoreCase(placa)) {
            res = temp;
            return res;
         }
      }
      return res;
   }
   
   public void eliminar(String placa, Set<Vehiculo> lista){
      Vehiculo temp = buscar(placa, lista);
      if (temp != null) {
         lista.remove(temp);
         System.out.println("eliminado con exito");
      }
      else{
         System.out.println("no se pudo eliminar");
      }
   }
   
   /* 
      esta funcion trabaja con el codigo ascii del alfabeto, pero en minus. al final
      le pongo un uppercase para que quede mejor visualmente
   */
   public String generaPalabra(){
      String palabra = "", res;
      int caracteres = (int) (Math.random() * 20) + 5;
      for (int i = 0; i < caracteres; i++){
         int codigoAscii = (int) Math.floor(Math.random() * (122 - 97) + 97);
         palabra = palabra + (char) codigoAscii;
      }
      res = palabra.substring(0, 3).toUpperCase();
      return res;
   }
   
   public int generaNum(){
      int res = (int) (Math.random() * 899 + 100);
      return res;
   }
   
   public String generarIdVehiculo(){
      String res = generaPalabra() + String.valueOf(generaNum());
      return res;
   }
   /*
      esta funcion genera el ID para el hash code, si se va a trabajar con muchos
      datos, es necesario cambiarlo por un valor mas grande. en vez de 2000 cmbiarlo a 1millon por ej
   */
   public int generaID(){
      int res = (int) (Math.random() * 2000 + 1);
      return res;
   }
   
   public String generaTipo(){
      int res = (int) (Math.random() * 3 + 0);
      switch(res){
         case 0:
            return "AUTOMOVIL";
         case 1:
            return "CAMION";
         case 2:
            return "CAMIONETA";
         default:
            return "Opcion erronea";
      }
   }
   
   public int generaCC(){
      int res;
      do {         
         res = (int) (Math.random() * 3500 + 1000);
      } while (res % 100 != 0);      
      return res;
   }
   
   public void generaVehicuo(int cant, Set<Vehiculo> lista){
      for(int i = 0; i < cant; i++) {
         Vehiculo temp = generaVehiculo(lista);
         /*si el vehiculo esta repetido entonces generamos uno nuevo y quitamos
         una iteracion del bucle*/
         if (insertar(temp, lista)) {
            temp = generaVehiculo(lista);
            i -= 1;  
         }
      }
      System.out.println(cant + " Vehiculos generados exitosamente!");
   }
   
   public Vehiculo generaVehiculo(Set<Vehiculo> lista){
      Vehiculo temp = new Vehiculo(generaID(), generarIdVehiculo(), generaTipo(), generaCC());
      return temp;
   }
   
   public void removeSameType(Set<Vehiculo> lista){
      List<Vehiculo> repetidos = new LinkedList<>();
      for (Vehiculo vehiculo : lista) {
         for (Vehiculo vehiculo1 : lista) {
            if ((vehiculo != vehiculo1) && (vehiculo.getTipo().compareTo(vehiculo1.getTipo()) == 0) && 
                 (vehiculo.getCilindraje() == vehiculo1.getCilindraje())) {
               if (!(repetidos.contains(vehiculo)) || !(repetidos.contains(vehiculo1))) {
                  /*
                  System.out.println(vehiculo + "------" + vehiculo1);
                  esta linea muestra los vehiculos eliminados, su respectiva comparacion
                  */
                  repetidos.add(vehiculo);
                  repetidos.add(vehiculo1);
               }
            }
         }
      }
      lista.removeAll(repetidos);
      System.out.println("Vehiculos con mismo tipo y cc eliminados exitosamente!");
   }
   //metodo brubuja
   public List<Vehiculo> sortByType(Set<Vehiculo> lista){
      //sacamos una copia de set para poder trabajar ordenamiento con listas normales
      List<Vehiculo> copia = new LinkedList<>(lista);
      Vehiculo temp;
      for (int i = 0; i < lista.size(); i++) {
         for (int j = 0; j < (lista.size() - 1); j++) {
            if (copia.get(j).getTipo().compareTo(copia.get(j + 1).getTipo()) > 0) {
               temp = copia.get(j);
               copia.set(j, copia.get(j + 1));
               copia.set(j + 1, temp);
            }
         }
      }
      return copia;
   }
}