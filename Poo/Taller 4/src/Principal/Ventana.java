/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Guillermo
 */
public class Ventana extends JFrame{
   JPanel panelNum;
   JPanel principal;
   JPanel operaciones;
   JTextArea panelText;
   
   public Ventana(){
      super("Calculadora");                  
      setDefaultCloseOperation(EXIT_ON_CLOSE);      
      getContentPane().setLayout(new GridBagLayout());     
      GridBagConstraints constrains = new GridBagConstraints();
      
      //el textarea que sirve de panel de salida
      panelText = new JTextArea();
      panelText.setLineWrap(true);
      constrains.gridx = 0;   //empieza columna
      constrains.gridy = 0;   //empieza fila
      constrains.gridwidth = 3;  //ocupa columna
      constrains.gridheight = 1; //ocupa fila
      constrains.weightx = 1.0;  //estiramos columna
      constrains.weighty = 1.0;  //estriamos fila
      constrains.fill = GridBagConstraints.BOTH;   //estiramos el componente completo
      getContentPane().add(panelText, constrains);
      
      //montaje del panel numerico
      panelNum = new JPanel();
      panelNum.setLayout(new GridLayout(4, 3));
      for (int i = 7; i < 10; i++) panelNum.add(new Button("" + i));
      for (int i = 4; i < 7; i++) panelNum.add(new Button("" + i));
      for (int i = 1; i < 4; i++) panelNum.add(new Button("" + i));
      panelNum.add(new JButton("0"));
      panelNum.add(new JButton("."));
      constrains.gridx = 0; 
      constrains.gridy = 1;
      constrains.gridwidth = 2;
      constrains.gridheight = 2;
      constrains.fill = GridBagConstraints.BOTH;
      getContentPane().add(panelNum, constrains);
      
      
      //montaje del panel de operaciones
      operaciones = new JPanel();
      operaciones.setLayout(new GridLayout(0, 1));
      operaciones.add(new Button("Erase"));
      operaciones.add(new Button("/"));
      operaciones.add(new Button("*"));
      operaciones.add(new Button("-"));
      operaciones.add(new Button("+"));
      operaciones.add(new Button("Intro"));
      constrains.gridx = 2; 
      constrains.gridy = 1;
      constrains.gridwidth = 1;
      constrains.gridheight = 2;
      constrains.fill = GridBagConstraints.BOTH;
      getContentPane().add(operaciones, constrains);
      
      setSize(400, 530);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      Ventana app = new Ventana();
   }
}
