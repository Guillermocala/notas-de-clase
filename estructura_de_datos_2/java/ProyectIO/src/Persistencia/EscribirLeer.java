/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.File;
import Simplex.Guardar;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
/**
 *
 * @author 57300
 */
public class EscribirLeer {
   public void escribirFichero(final String fichero, final Object o) {
        try {
            final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            oos.writeObject(o);
            oos.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al escribir el primer dato del archio", "Error!", 0);
            e.printStackTrace();
        }
    }
    
    public ArrayList leeFichero(final String fichero) throws IOException {
        FileInputStream canalEntrada = null;
        ObjectInputStream objetoEntrada = null;
        final ArrayList<Guardar> auxi = new ArrayList<Guardar>();
        boolean fin = true;
        try {
            final File archivoEntrada = new File(fichero);
            canalEntrada = new FileInputStream(archivoEntrada);
            objetoEntrada = new ObjectInputStream(canalEntrada);
            do {
                try {
                    auxi.add((Guardar)objetoEntrada.readObject());
                }
                catch (IOException | ClassNotFoundException ex2) {
                    final Exception ex = null;
                    final Exception exc = ex;
                    fin = false;
                }
            } while (fin);
            objetoEntrada.close();
            canalEntrada.close();
        }
        catch (IOException e) {
            System.out.println("Error al extraer");
        }
        return auxi;
    }
}
