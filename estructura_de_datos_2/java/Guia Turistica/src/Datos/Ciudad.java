/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.SubData.Hotel;
import Datos.SubData.PlatoTipico;
import Datos.SubData.Restaurante;
import Datos.SubData.SitioTuristico;
import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class Ciudad {
   private ArrayList<Hotel> hoteles = new ArrayList<>();
   private ArrayList<PlatoTipico> platos = new ArrayList<>();
   private ArrayList<Restaurante> restaurantes = new ArrayList<>();
   private ArrayList<SitioTuristico> sitios = new ArrayList<>();

   public void addHotel(Hotel x) {
      hoteles.add(x);
   }
   
   public void addPlatos(PlatoTipico x) {
      platos.add(x);
   }
   
   public void addRestaurante(Restaurante x) {
      restaurantes.add(x);
   }
   
   public void addSitios(SitioTuristico x) {
      sitios.add(x);
   }
   
   
   /**
    * @return the hoteles
    */
   public ArrayList<Hotel> getHoteles() {
      return hoteles;
   }

   /**
    * @return the platos
    */
   public ArrayList<PlatoTipico> getPlatos() {
      return platos;
   }

   /**
    * @return the restaurantes
    */
   public ArrayList<Restaurante> getRestaurantes() {
      return restaurantes;
   }

   /**
    * @return the Sitios
    */
   public ArrayList<SitioTuristico> getSitios() {
      return sitios;
   }
   
  
}
