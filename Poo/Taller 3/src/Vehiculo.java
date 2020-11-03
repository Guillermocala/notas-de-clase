/**
 * @(#)Vehiculo.java
 *
 *
 * @author 
 * @version 1.00 2020/11/3
 */
 
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Vehiculo {
   
   private String idVehiculo;
   private String tipo;
   private int cilindraje;
   private int id;

   public Vehiculo(int id, String idVehiculo, String tipo, int cilindraje) {
      this.idVehiculo = idVehiculo;
      this.tipo = tipo;
      this.cilindraje = cilindraje;
      this.id = id;
   }

   @Override
   public String toString() {
      return "idVehiculo=" + idVehiculo + ", tipo=" + tipo + ", cilindraje=" + cilindraje + ", id=" + id + '}';
   }
   
   
   

   /**
    * @return the idVehiculo
    */
   public String getIdVehiculo() {
      return idVehiculo;
   }

   /**
    * @param idVehiculo the idVehiculo to set
    */
   public void setIdVehiculo(String idVehiculo) {
      this.idVehiculo = idVehiculo;
   }

   /**
    * @return the tipo
    */
   public String getTipo() {
      return tipo;
   }

   /**
    * @param tipo the tipo to set
    */
   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   /**
    * @return the cilindraje
    */
   public int getCilindraje() {
      return cilindraje;
   }

   /**
    * @param cilindraje the cilindraje to set
    */
   public void setCilindraje(int cilindraje) {
      this.cilindraje = cilindraje;
   }
   
   /**
    * @return the id
    */
   public int getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(int id) {
      this.id = id;
   }

   @Override
   public boolean equals(Object obj){      
      Vehiculo temp = (Vehiculo) obj;
      return (temp.id == this.id);
   }
   @Override
   public int hashCode(){
      return (this.id * 2);
   }
   
   public boolean insertar(Vehiculo obj, Set<Vehiculo> lista){
      for (Vehiculo vehiculo : lista) {
         if ((obj.getId() == vehiculo.getId()) || (obj.getIdVehiculo().equalsIgnoreCase(vehiculo.getIdVehiculo()))) {
            return true;
         }
      }
      lista.add(obj);
      return false;
   }
    
   public Vehiculo buscar(String id, Set<Vehiculo> lista){
      Vehiculo res = null;
      for (Vehiculo temp : lista) {
         if (temp.getIdVehiculo().equalsIgnoreCase(id)) {
            res = temp;
            return res;
         }
      }
      return res;
   }
   public void eliminar(String id, Set<Vehiculo> lista){
      Vehiculo temp = buscar(id, lista);
      if (temp != null) {
         lista.remove(temp);
         System.out.println("eliminado con exito");
      }
      else{
         System.out.println("no se pudo eliminar");
      }
   }
   
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
            return "invalid";
      }
   }
   public int generaCC(){
      int res = (int) (Math.random() * 3500 + 1000);
      while(res % 100 != 0){
         res = (int) (Math.random() * 3500 + 1000);
      }
      return res;
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
               if (!(repetidos.contains(vehiculo))) {
                  repetidos.add(vehiculo);
               }
            }
         }
      }
      lista.removeAll(repetidos);
      System.out.println("Vehiculos con mismo tipo y cc eliminados exitosamente!");
   }
   public List<Vehiculo> sortByType(Set<Vehiculo> lista){
      //sacamos una copia de set para poder trabajar ordenamiento con listas normales
      List<Vehiculo> copia = new LinkedList<>(lista);
      //metodo brubuja porque me da la puta gana :v
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