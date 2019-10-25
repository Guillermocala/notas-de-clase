/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letras;

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
public class Persistencia2<E> {
   public void guardar(Grafo<E> x) throws FileNotFoundException, IOException {
      ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"));
      ob.writeObject(x);
      ob.close();
   }
   public Grafo<E> recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom));
      Grafo<E> ar = (Grafo<E>) ob.readObject();
      ob.close();
      return ar;
   }
}
