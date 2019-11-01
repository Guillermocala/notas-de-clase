/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ESTUDIANTE
 */
public class Persistencia {
   public void guardar(ArbolMaterias x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"))) {
         ob.writeObject(x);
      }
   }
   public ArbolMaterias recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      ArbolMaterias ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (ArbolMaterias) ob.readObject();
      }
      return ar;
   }
   public void guardarEst(String x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivoEst.ch"))) {
         ob.writeObject(x);
      }
   }
   public String recuperarEst(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      String ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (String) ob.readObject();
      }
      return ar;
   }
   public void guardarCod(String x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivoCod.ch"))) {
         ob.writeObject(x);
      }
   }
   public String recuperarCod(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      String ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (String) ob.readObject();
      }
      return ar;
   }
}
