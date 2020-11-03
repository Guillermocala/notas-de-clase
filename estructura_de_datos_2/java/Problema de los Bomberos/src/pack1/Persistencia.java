package pack1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
   public void guardar(EstacionBomberos x) throws FileNotFoundException, IOException {
      try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("bomberos.ch"))) {
         ob.writeObject(x);
      }
   }
   public EstacionBomberos recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      EstacionBomberos ar;
      try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom))) {
         ar = (EstacionBomberos) ob.readObject();
      }
      return ar;
   }
}
