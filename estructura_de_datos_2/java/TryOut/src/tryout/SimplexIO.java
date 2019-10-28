/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class SimplexIO {   
   public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      double[] vectorC, vectorCb,rfo, fo, b, cbBA, cbBA_C, Bb;
      String[] desigualdades, var, var1;
      double[][] matrizA,restricciones, matrizB, matrizAB;
      int nRestricciones, nVariablesDeDecision, n = 0;
      double M = 999999999, z = 0;
      String opc;
      Matriz mat = new Matriz();      
      System.out.print("# de variables de decisión: ");
      nVariablesDeDecision = entrada.nextInt();
      fo = new double[nVariablesDeDecision];
      System.out.print("Coeficientes de la funcion objetivo\n>> ");
      opc = entrada.next();
      for(int i = 0; i < nVariablesDeDecision; i++){
          fo[i] = entrada.nextDouble();
      }

      System.out.print("# de restricciones\n>> ");
      nRestricciones = entrada.nextInt();
      b = new double[nRestricciones];
      desigualdades = new String[nRestricciones];
      restricciones = new double[nRestricciones][nVariablesDeDecision];
        
      for(int j = 0; j < nRestricciones; j++){
         System.out.print("Coeficientes de la restriccion "+(j+1)+"\n>> ");
         for(int k = 0; k < nVariablesDeDecision; k++){
            restricciones[j][k] = entrada.nextDouble();
         }
         desigualdades[j] = entrada.next();
         b[j] = entrada.nextDouble();
      }
        
      for(String s: desigualdades){
         if(s.equals("<=") || s.equals("=")){
            n++;
         }else{
            n += 2;
         }
      }
        
      matrizA = new double[nRestricciones][nVariablesDeDecision+n];
      matrizAB = new double[nRestricciones][nVariablesDeDecision+n];
      matrizB = new double[n][n];
      vectorCb = new double[n];
      rfo = new double[nVariablesDeDecision+n];
      vectorC = new double[rfo.length];
      cbBA = new double[vectorC.length];
      cbBA_C = new double[vectorC.length];
      Bb = new double[vectorCb.length];
      var = new String[nRestricciones];
      var1 = new String[rfo.length];

      for(int i = 0; i < vectorCb.length; i++){
         vectorCb[i] = 0;
      }
               
      for(int i = 0; i < vectorC.length; i++){
         if(i < nVariablesDeDecision){
            vectorC[i] = fo[i];
         }else{
            vectorC[i] = 0;
         }
      }
      for(int i = 0; i < var1.length; i++){
         if(i < nVariablesDeDecision){
            var1[i] = "X"+(i+1);
         }else{
            var1[i] = "S"+(i-nVariablesDeDecision+1);
         }
      }
      for(int i = 0; i < var.length; i++){
         var[i] = var1[i+nVariablesDeDecision];
      }
        
      for(int i = 0; i < nRestricciones; i++){
           
         for(int j = 0; j < nVariablesDeDecision+n; j++){
            if(j < nVariablesDeDecision){
               matrizA[i][j] = restricciones[i][j]; 
            }else if(i == j-n+1 && desigualdades[i].equals("<=")){
               matrizA[i][j] = 1;
               matrizB[i][j-n+1] = 1;
            }else{
               matrizA[i][j] = 0; 
               matrizB[i][j-n+1] = 0;
            }
         }
      }
        
      matrizAB = mat.multiplicarMatrices(mat.inversa(matrizB),matrizA,n, nVariablesDeDecision+n);
      Bb = mat.multiplicarMatrizVector(mat.inversa(matrizB),b);
      cbBA = mat.multiplicarVectorMatriz(vectorCb,matrizAB);
      cbBA_C = mat.restarVectores(cbBA, vectorC);
      z = mat.multiplicarVectores(vectorCb, Bb);
      mostrarMatriz(matrizAB, var1, var, Bb);

      double[] ve = new double[2];
      double[] ce = new double[nRestricciones];
      double[] fs = new double[nRestricciones];

      while(sePuedeContinuar(cbBA_C)){
         ve = variableQueEntra(cbBA_C);
         for(int i = 0; i < ce.length; i++){
            ce[i] = matrizA[i][(int)ve[1]];  
         }
         fs = variableQueSale(ce,Bb);
         for(int j = 0; j <= fs.length; j++){
            matrizB[j][(int)fs[1]] = ce[j];
         }
         matrizAB = mat.multiplicarMatrices(mat.inversa(matrizB),matrizA,n, nVariablesDeDecision+n);
         Bb = mat.multiplicarMatrizVector(mat.inversa(matrizB),b);
         vectorCb[(int)fs[1]] = vectorC[(int)ve[1]];
         var[(int)fs[1]] = var1[(int)ve[1]];
         cbBA = mat.multiplicarVectorMatriz(vectorCb,matrizAB);
         cbBA_C = mat.restarVectores(cbBA, vectorC);
         z = mat.multiplicarVectores(vectorCb, Bb);
         mostrarMatriz(matrizAB, var1, var, Bb);
      }
        
      System.out.println("Z = "+String.format("%.3f",z));
   }
    
   public static double[] variableQueEntra(double[] f){
      double[] menor = new double[2];
      menor[0] = f[0];
      for(int i = 1; i < f.length; i++){
         if(f[i] < menor[0]){
            menor[0] = f[i];
            menor[1] = i;
         }            
      }
      return menor;
   }
    
   public static double[] variableQueSale(double[] ce, double[] b){
      double[] m = new double[2];
      m[0] = b[0]/ce[0];
      for(int i = 1; i < b.length; i++){
         if((b[i]/ce[i] > 0) && b[i]/ce[i] < m[0]){
            m[0] = b[i]/ce[i];
            m[1] = i;
         }
      }
      return m;
   }
    
   public static void mostrarMatriz(double[][] m,String[] v1, String[] v2, double[] Bb){
      System.out.print("\n     ");
      for(int i = 0; i < v1.length; i++){
         System.out.print(v1[i]+"    ");
      }
      System.out.print("b\n");
      for(int i = 0; i < m.length; i++){
         System.out.print(v2[i]+"  ");
         for(int j = 0; j < m[i].length; j++){
            System.out.print(String.format("%.3f",m[i][j])+" ");
         }
         System.out.print(String.format("%.3f",Bb[i]));
         System.out.print("\n");
      }
   }
    
   public static void mostrarVector(double[] v){
      for(int i = 0; i < v.length; i++){
         System.out.print(String.format("%.3f",v[i])+" ");
      }
   }
    
   public static boolean sePuedeContinuar(double[] v){
      for(int i = 0; i < v.length; i++){
         if(v[i] < 0){
            return true;
         }
      }
      return false;
   }
}
