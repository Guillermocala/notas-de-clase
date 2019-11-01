/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

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
   public void guardar(Concesionario x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"))) {
         ob.writeObject(x);
      }
   }
   public Concesionario recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      Concesionario ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (Concesionario) ob.readObject();
      }
      return ar;
   }
}
