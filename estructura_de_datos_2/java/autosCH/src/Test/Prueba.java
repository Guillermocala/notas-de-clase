/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Principal.Auto;
import Principal.Concesionario;
import Principal.SortAutoPlaca;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Prueba {
   public static void main(String[] args) {
      Concesionario nuevo = new Concesionario();
      nuevo.addAuto(new Auto("gty698", "thyhyh", 10000));
      nuevo.addAuto(new Auto("uli658", "noseque", 560000));
      nuevo.addAuto(new Auto("zxs658", "thyhyh", 10000));
      JOptionPane.showMessageDialog(null, nuevo.listar());
      //ordenar por marca
      //busqueda binaria por placa
      Collections.sort(nuevo.getAutos(), new SortAutoPlaca());
      JOptionPane.showMessageDialog(null, nuevo.listar());
   }
}
