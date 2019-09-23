/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author 57300
 */
public class GrafoMat<E> implements Grafo<E> {

   private int aristas[][];
   private ArrayList<E> vertices;

   public GrafoMat() {
      aristas = new int[100][100];
      vertices = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
         for (int j = 0; j < 100; j++) {
            if(i!=j) aristas[i][j] = inf;
         }
      }
      
   }
   
   
   
   @Override
   public void insVertice(E x) {
      vertices.add(x);
   }

   @Override
   public E obtVertice(int pos) {
      return vertices.get(pos);
   }

   @Override
   public void insArista(int vI, int vF, int dato) {
      aristas[vI][vF] = dato;
   }

   @Override
   public int obtArista(int vI, int vF) {
      return aristas[vI][vF];
   }

   @Override
   public void elimArista(int vI, int vF) {
      aristas[vI][vF] = inf;
   }

   @Override
   public int orden() {
      return vertices.size();
   }

   @Override
   public ArrayList<E> sucesores(int pos) {
      ArrayList<E> suces = new ArrayList<>();
      for (int i = 0; i < orden(); i++) {
         if(aristas[pos][i] != inf && i != pos)
         {
            suces.add(obtVertice(i));
         }         
      }
      return suces;
   }

   @Override
   public String mostrar() { //muestra grafos primitivos(intm float, string), no objetos
      String con = "";
      for (int i = 0; i < orden(); i++) {
         con += "Vertice: " + obtVertice(i);
         for (int j = 0; j < orden(); j++) {
            con += "-" + obtArista(i, j);
         }
         con += "\n";
      }
      return con;
   }
   
}
