/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class Ciudad implements Serializable{
   private String nombre;
   private ArrayList<Hotel> hoteles;
   private ArrayList<Restaurante> restaurantes;
   private ArrayList<Sitio> sitios;
   private ArrayList<Plato> platos;
   
   public Ciudad(String nombre, ArrayList<Hotel> hoteles, ArrayList<Restaurante> restaurantes, ArrayList<Sitio> sitios, ArrayList<Plato> platos) {
      this.nombre = nombre;
      this.hoteles = hoteles;
      this.restaurantes = restaurantes;
      this.sitios = sitios;
      this.platos = platos;
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
    * @return the hoteles
    */
   public ArrayList<Hotel> getHoteles() {
      return hoteles;
   }

   /**
    * @param hoteles the hoteles to set
    */
   public void setHoteles(ArrayList<Hotel> hoteles) {
      this.hoteles = hoteles;
   }

   /**
    * @return the restaurantes
    */
   public ArrayList<Restaurante> getRestaurantes() {
      return restaurantes;
   }

   /**
    * @param restaurantes the restaurantes to set
    */
   public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
      this.restaurantes = restaurantes;
   }

   /**
    * @return the sitios
    */
   public ArrayList<Sitio> getSitios() {
      return sitios;
   }

   /**
    * @param sitios the sitios to set
    */
   public void setSitios(ArrayList<Sitio> sitios) {
      this.sitios = sitios;
   }

   /**
    * @return the platos
    */
   public ArrayList<Plato> getPlatos() {
      return platos;
   }

   /**
    * @param platos the platos to set
    */
   public void setPlatos(ArrayList<Plato> platos) {
      this.platos = platos;
   }
   
}
