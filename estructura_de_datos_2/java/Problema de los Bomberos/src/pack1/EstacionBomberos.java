/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author 57300
 */
public class EstacionBomberos implements Serializable{
   private GrafoImp<Barrio> graf;
   private LinkedList<Camion> camiones;
   

   public EstacionBomberos() {
      this.graf = new GrafoImp<>();
      this.camiones = new LinkedList<>();
   }
   
   /**
    * @return the ciudad
    */
   public GrafoImp<Barrio> getGraf() {
      return graf;
   }

   /**
    * @param ciudad the ciudad to set
    */
   public void setCiudad(GrafoImp<Barrio> ciudad) {
      this.graf = ciudad;
   }

   /**
    * @return the camiones
    */
   public LinkedList<Camion> getCamiones() {
      return camiones;
   }

   /**
    * @param camiones the camiones to set
    */
   public void setCamiones(LinkedList<Camion> camiones) {
      this.camiones = camiones;
   }
   //ya aca empezamos las funciones que necesitamos
   
   /*aca empezamos los recorridos y como sucesores devuelve un array<E> entonces
   necesitamos una funcion que nos devuelva el indice para trabajar los recorridos*/
   public int hallaIndice(Barrio bar) {
      for (int i = 0; i < graf.orden(); i++) {
         if (graf.obtVertice(i) == bar) {
            return i;
         }
      }
      return 999999;
   }
   
   private ArrayList<Barrio> visita2 = new ArrayList<>();
   
   public void recoProfundidad(int vi) {
      System.out.println(graf.obtVertice(vi) + " - ");
      visita2.add(graf.obtVertice(vi));
      ArrayList<Barrio> suc = graf.sucesores(vi);
      for (Barrio barrio : suc) {
         if (!(visita2.contains(barrio))) {
            recoProfundidad(hallaIndice(barrio));
         }
      }
   }
   public void recoAnchura(int vi) {
      LinkedList<Barrio> cola = new LinkedList<>();
      cola.addLast(graf.obtVertice(vi));
      visita2.add(graf.obtVertice(vi));
      while (!(cola.isEmpty())) {         
         Barrio aux = cola.removeFirst();
         System.out.println(graf.obtVertice(vi) + " - ");
         ArrayList<Barrio> suc = graf.sucesores(hallaIndice(aux));
         for (Barrio x : suc) {
            if (!(visita2.contains(x))) {
               cola.addLast(x);
               visita2.add(x);
            }
         }
      }
   }
   
   /*aca hacemos las funciones de inhabilitar maquina y aislar barrio*/
   
   public void aislaBarrio(int barrio) {
      if (barrio == 0) {
         System.out.println("No se puede aislar la estacion!");
      }
      else {
         for (int i = 0; i < graf.orden(); i++) {
            if (i != barrio) {
               graf.elimArista(i, barrio);
               graf.elimArista(barrio, i);
            }
         }
         /*si hay un camion en la ciudad debo inhabilitarlo */
         Camion temp = graf.obtVertice(barrio).getCamion();
         if (temp != null) {
            temp.setHabilitado(false);
            temp.setOcupado(false);
         }
      }
      
   }
   public void inhabilitaCamion(String placa) {
      boolean act = false;
      for (Camion camione : camiones) {
         if (camione.getPlaca().compareTo(placa) == 0) {
            camione.setHabilitado(false);
            camione.setOcupado(false);
            act = true;
         }
      }
      if (!act) {
         System.out.println("Camion no encontrado!");
      }
   }
   /*en esta parte viene enviar maquina e ingresarla*/
   
   public String ingresaCamion(String placa) {
      for (Camion camione : camiones) {
         if (camione.getPlaca().compareTo(placa) == 0) {
            return "Ya existe la placa";
         }
      }
      Camion aux = new Camion(placa, false, true);
      camiones.add(aux);
      desocupadas.add(aux);
      return "operacion exitosa";
   }
   
   private LinkedList<Camion> ocupadas = new LinkedList<>();
   private LinkedList<Camion> desocupadas = new LinkedList<>();
   public void enviaCamion(int barrio) {
      Floyd minimo = new Floyd(graf);
      minimo.CaminoMinimo();
      int menor = 77777;
      Camion masCercano = null;
      for (int i = 0; i < desocupadas.size(); i++) {
         int camino = minimo.CostoMinimo(desocupadas.get(i).getVisitados().getLast(), barrio);
         if (camino < menor) {
            menor = camino;
            masCercano = desocupadas.get(i);
         }
      }
      if (menor != 77777) {
         masCercano.addBarrio(barrio);
         ocupadas.add(masCercano);
         desocupadas.remove(masCercano);
         int cantAcc = (graf.obtVertice(barrio).getAccidentes()) + 1;
         graf.obtVertice(barrio).setAccidentes(cantAcc);
      }
   }
   
   /*aca estan los reportes*/
   public String masAccidentado() {
      int mayor = 0;
      Barrio accidentado = null;
      for (int i = 0; i < graf.orden(); i++) {
         int mayorcito = graf.obtVertice(i).getAccidentes();
         if (mayorcito > mayor) {
            mayor = mayorcito;
            accidentado = graf.obtVertice(i);
         }
      }
      if (mayor == 0) {
         return "no se han reportado accidentes";
      }
      else {
         return "el barrio con mas accidentes es: " + accidentado.toString();
      }
   }
   public String consultaCamion(String placa) {
      for (Camion camione : camiones) {
         if (camione.getPlaca().compareTo(placa) == 0) {
            return camione.toString();
         }
      }
      return "no encontrado";
   }
   public void porcentajes() {
      int accidentesTotales = 0;
      for (int i = 0; i < graf.orden(); i++) {
         accidentesTotales += graf.obtVertice(i).getAccidentes();
      }
      if (accidentesTotales == 0) {
         System.out.println("no se han reportado accidentes");
      }
      else {
         for (Camion camione : camiones) {
            float dividendo = camione.getVisitados().size();
            float porcentaje = (dividendo / accidentesTotales) * 100;
            System.out.println("el camion: " + camione.getPlaca() + "tiene %" + porcentaje + " de trabajo");
         }
      }
   }
}
