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
    public void guardar(ArbolString x) throws FileNotFoundException, IOException {
        ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"));
        ob.writeObject(ob);
        ob.close();        
    }
    public ArbolString recuperar(String nom) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom));
        ArbolString ar = (ArbolString) ob.readObject();
        ob.close();        
        return ar;                
    }                
}
