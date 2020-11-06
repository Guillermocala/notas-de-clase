/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
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
      setLayout(new BorderLayout());      
      
      panelNum = new JPanel();
      panelNum.setLayout(new GridLayout(4, 3, 10, 10));
      for (int i = 7; i < 10; i++) panelNum.add(new Button("" + i));
      for (int i = 4; i < 7; i++) panelNum.add(new Button("" + i));
      for (int i = 1; i < 4; i++) panelNum.add(new Button("" + i));
      panelNum.add(new JButton("0"));
      panelNum.add(new JButton("."));
      
      panelText = new JTextArea();
      panelText.setLineWrap(true);
      
      operaciones = new JPanel();
      operaciones.setLayout(new GridLayout(0, 1, 10, 10));
      operaciones.add(new Button("Erase"));
      operaciones.add(new Button("/"));
      operaciones.add(new Button("*"));
      operaciones.add(new Button("-"));
      operaciones.add(new Button("+"));
      operaciones.add(new Button("Intro"));
      
      principal = new JPanel();
      principal.setLayout(new BorderLayout());
      principal.add(panelText, BorderLayout.NORTH);
      principal.add(panelNum, BorderLayout.CENTER);
      principal.add(operaciones, BorderLayout.EAST);
            
      add(principal);
      setSize(400, 530);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      Ventana app = new Ventana();
   }
}
