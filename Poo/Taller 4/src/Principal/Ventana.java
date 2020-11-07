/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Guillermo
 */
public class Ventana extends JFrame{
   JPanel panelNum;
   JPanel operaciones;
   JTextField panelText;
   
   public Ventana(){
      super("Calculadora");                  
      setDefaultCloseOperation(EXIT_ON_CLOSE);      
      getContentPane().setLayout(new GridBagLayout());     
      GridBagConstraints constrains = new GridBagConstraints();
      
      //el textarea que sirve de panel de salida
      panelText = new JTextField();
      //a continuacion irá la fuente, en negrita y con tamanio de 30
      panelText.setFont(new Font("SansSerif", 1, 30));
      panelText.setHorizontalAlignment(JTextField.RIGHT);
      //panelText.setEnabled(false);  //para que solo entren datos por los botones
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
      for (int i = 7; i < 10; i++) newNumButton(String.valueOf(i));
      for (int i = 4; i < 7; i++) newNumButton(String.valueOf(i));
      for (int i = 1; i < 4; i++) newNumButton(String.valueOf(i));
      newNumButton("0");
      newNumButton(".");
      constrains.gridx = 0; 
      constrains.gridy = 1;
      constrains.gridwidth = 2;
      constrains.gridheight = 2;
      constrains.fill = GridBagConstraints.BOTH;
      getContentPane().add(panelNum, constrains);
      
      
      //montaje del panel de operaciones
      operaciones = new JPanel();
      operaciones.setLayout(new GridLayout(0, 1));
      newOperationButton("Erase");
      newOperationButton("/");
      newOperationButton("*");
      newOperationButton("-");
      newOperationButton("+");
      newOperationButton("Intro");
      constrains.gridx = 2; 
      constrains.gridy = 1;
      constrains.gridwidth = 1;
      constrains.gridheight = 2;
      constrains.fill = GridBagConstraints.BOTH;
      getContentPane().add(operaciones, constrains);
      
      setSize(400, 530);
      setVisible(true);
   }
   
   private void newNumButton(String num){
      JButton button = new JButton();
      button.setText(num);
      button.addActionListener(this::verifica);
      panelNum.add(button);
   }
   
   private void newOperationButton(String operation){
      JButton button = new JButton();
      button.setText(operation);
      button.addActionListener(this::verifica);
      operaciones.add(button);
   }
   private void verifica(ActionEvent e){
      String opera[] = {".", "/", "*", "-", "+", "Intro"};
      String data = e.getActionCommand();
      String aux = panelText.getText(), temp;
      if(data.equals("Erase")){
         if (aux.length() > 0) {
            temp =  aux.substring(0, aux.length() - 1);
            panelText.setText(temp);
         }
         System.out.println("esta pulsando erase");
      }
      else if (Arrays.asList(opera).contains(data)) {
         System.out.println("es una operacion");
         panelText.setText(aux + e.getActionCommand());
      }
      else{
         System.out.println("es un numero");
         panelText.setText(aux + e.getActionCommand());
      }
      
   }
   public static void main(String[] args) {
      Ventana app = new Ventana();
   }
}
