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
      return "PLACA = " + idVehiculo + ", Tipo = " + tipo + ", Cilindraje = " + cilindraje + ", ID = " + id;
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
}