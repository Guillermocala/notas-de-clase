/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Guillermo
 */
public class Persistencia {
   public void guardar(Central x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("informacion.ch"))) {
         ob.writeObject(x);
      }
   }
   public Central recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      Central ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (Central) ob.readObject();
      }
      return ar;
   }
}
