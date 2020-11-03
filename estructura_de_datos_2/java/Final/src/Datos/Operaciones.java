/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Principal.GrafoMatr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author xxx
 */
public class Operaciones implements Serializable{
   
   private GrafoMatr<Ciudad> grafo;

   public Operaciones() {
      grafo = new GrafoMatr<>();
   }

   /**
    * @return the grafo
    */
   public GrafoMatr<Ciudad> getGrafo() {
      return grafo;
   }
   
   //insertar
   public String insCiudad(String name) {
      for (int i = 0; i < grafo.orden(); i++) {
         if (grafo.obtVertice(i).getNombre().compareTo(name) == 0) {
            return "Nombre ya existente";
         }
      }
      grafo.insVertice(new Ciudad(name));
      return "Ciudad insertada";
   }
   
   public void insTiempo(int vi, int vf, int tiempo) {
      grafo.insArista(vi, vf, tiempo);
   }
   
   //recorridos
   private ArrayList<Ciudad> visitado = new ArrayList<>(); // necesario para los recorridos
   private ArrayList<Integer> reco = new ArrayList<>();
   public void limpia(){ //para no guardar datos basura cuando llame a las funciones de nuevo
      visitado.clear();
      reco.clear();
   }
   
   public ArrayList<Integer> getRecorrido() {
      return reco;
   }
   public void recoAnchura(int vi) {
      reco.add(vi);
      visitado.add(grafo.obtVertice(vi));
      ArrayList<Ciudad> suc = grafo.sucesores(vi);
      for (Ciudad ciudad : suc) {
         if (!(visitado.contains(ciudad))) {
            recoAnchura(obtIndice(ciudad));
         }
      }
   }
   public void recoProf(int vi) {
      LinkedList<Ciudad> cola = new LinkedList<>();
      cola.addLast(grafo.obtVertice(vi));
      visitado.add(grafo.obtVertice(vi));
      while (!(cola.isEmpty())) {         
         Ciudad aux = cola.removeFirst();
         reco.add(obtIndice(aux));
         ArrayList<Ciudad> suc = grafo.sucesores(obtIndice(aux));
         for (Ciudad x : suc) {
            if (!(visitado.contains(x))) {
               cola.addLast(x);
               visitado.add(x);
            }
         }
      }
   }
   public int obtIndice(Ciudad x) { 
      /*como trabajamos con objetos y recorrido anchura necesita
      numeros entonces esta funcion nos permite trabajar esa recursividad sin problema*/
      for (int i = 0; i < grafo.orden(); i++) {
         if (grafo.obtVertice(i) == x) {
            return i;
         }
      }
      return -1;
   }
   //ruta minima y costo minimo
   public String rutaMinima(int vi, int vf) {
      String res = "";
      Floyd minimo = new Floyd(grafo); //inicio la clase floyd y luego llamo las funciones
      res += "El costo minimo es: " + minimo.CostoMinimo(vi, vf) + "\nRuta minima es: ";
      res += grafo.obtVertice(vi).getNombre() + " - "; //para que me muestre de donde sale
      minimo.ruta(grafo, vi, vf);
      for (Ciudad ciudad : minimo.getRuta()) {
         res += ciudad.getNombre() + " - ";
      }
      res += grafo.obtVertice(vf).getNombre(); //para que me muestre el ultimo
      return res;
   }
}
