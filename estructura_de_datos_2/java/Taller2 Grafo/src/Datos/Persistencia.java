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
 * @author 57300
 */
public class Persistencia {
   public void guardar(Ciudad x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"))) {
         ob.writeObject(x);
      }
   }
   public Ciudad recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      Ciudad ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (Ciudad) ob.readObject();
      }
      return ar;
   }
}
