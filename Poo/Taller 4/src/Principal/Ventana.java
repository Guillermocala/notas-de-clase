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
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Guillermo
 */
public class Ventana extends JFrame{
   private JPanel panelNum;
   private JPanel operaciones;
   private JTextField panelText;
   private boolean haveNumber = false;
   private boolean haveOperation = false;
   private int num1, num2;
   private float num3, num4;
   private int posOperador = 0, cantOpera = 0;
   private String temp;
   
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
      panelText.setEditable(false);  //para que solo entren datos por los botones
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
      newNumButton(",");
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
      String opera[] = {",", "/", "*", "-", "+", "Intro"};
      String data = e.getActionCommand();
      String aux = panelText.getText();
      if(data.equals("Erase")){
         if (aux.length() != 0) {
            temp =  aux.substring(0, aux.length() - 1);
            panelText.setText(temp);
         }
         else{
            haveNumber = false;
         }
         System.out.println("esta pulsando erase");
      }
      else if (Arrays.asList(opera).contains(data)) {
         System.out.println("es una operacion");
         if (data.equals("Intro")) {
            System.out.println("intro aqui");
            System.out.println(aux.length() + " " + (posOperador + 1));
            System.out.println(haveNumber);
            if ((haveNumber) && (aux.length() > posOperador + 1)) {
               System.out.println(aux);
               panelText.setText(opera(aux, opera));
               haveNumber = true;
            }
         }
         else{
            if (haveNumber && !haveOperation) {
               haveOperation = true;
               cantOpera++;
               posOperador = aux.length();
               if (cantOpera == 2) {
                  temp = opera(aux, opera);
                  panelText.setText(temp + data);
                  posOperador = temp.length();
                  System.out.println(posOperador);
                  cantOpera = 1;
               }
               else{
                  panelText.setText(aux + e.getActionCommand());
               }
            }
         }
      }
      else{
         System.out.println("es un numero");
         haveNumber = true;
         haveOperation = false;
         panelText.setText(aux + e.getActionCommand());
      }
      
   }
   
   public String opera(String expresion, String operaciones[]){
      System.out.println("hizo la operacion");
      String arrayExp[] = expresion.split("");
      int aux = -1;
      for (String ope : operaciones) {
         aux = Arrays.asList(arrayExp).indexOf(ope);
         if (aux != -1) {  //si encuentra algo entonces deja de buscar
            break;
         }
      }
      switch(Arrays.asList(arrayExp).get(aux)){
         case "/":
            num1 = Integer.parseInt(expresion.substring(0, aux));
            num2 = Integer.parseInt(expresion.substring(aux + 1, expresion.length()));
            temp = String.valueOf(num1 / num2);
            break;
         case "*":
            num1 = Integer.parseInt(expresion.substring(0, aux));
            num2 = Integer.parseInt(expresion.substring(aux + 1, expresion.length()));
            temp = String.valueOf(num1 * num2);
            break;
         case "-":
            num1 = Integer.parseInt(expresion.substring(0, aux));
            num2 = Integer.parseInt(expresion.substring(aux + 1, expresion.length()));
            temp = String.valueOf(num1 - num2);
            break;
         case "+":
            num1 = Integer.parseInt(expresion.substring(0, aux));
            num2 = Integer.parseInt(expresion.substring(aux + 1, expresion.length()));
            temp = String.valueOf(num1 + num2);
            break;
         default:    //nunca llega aqui
            break;
      }
      cantOpera = 0;
      haveNumber = false;
      haveOperation = false;
      return temp;
   }
   public static void main(String[] args) {
      Ventana app = new Ventana();
   }
}
