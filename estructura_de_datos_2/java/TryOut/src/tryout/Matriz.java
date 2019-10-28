/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout;

/**
 *
 * @author 57300
 */
public class Matriz {
   public double[][] trasponerMatriz(double[][] m){
         double[][] a = new double[m.length][m.length];
         for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                a[i][j] = m[j][i];
            }
         }
         return a;
      }
      public double determinante(double[][] m, int i){
         if(m.length == 2){
             double d = m[0][0]*m[1][1]-m[0][1]*m[1][0];
             return d;
         }
         else {
            double d = 0;
            for(int j = 0; j < m.length; j++){
               double[][] aux = subMatriz(i,j,m);
               d = d+Math.pow(-1,i+j)*m[i][j]*this.determinante(aux,i);
            }
            return d;
          }
      }    
      private double[][] subMatriz(int i, int j, double[][] m){
         double[][] aux = new double[m.length-1][m.length-1];
         int cont1 = 0, cont2 = 0;

         for(int k = 0; k < m.length; k++){
            if(k != i){
               cont2 = 0;
               for(int l = 0; l < m.length; l++){
                  if(l != j){
                     aux[cont1][cont2] = m[k][l];
                     cont2++;
                  }
               }
               cont1++;
            }
         }
         return aux;
      }
      public double[][] adjunta(double[][] m){
         double[][] adj = new double[m.length][m.length];
         for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
               if((i+j)%2 == 0){
                  adj[i][j] = 1;
               }
               else {
                  adj[i][j] =-1;
               }
            }
         }        
         for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m.length; j++){
               adj[i][j] = adj[i][j]*determinante(subMatriz(i,j,m),0);
            }
         }
         return adj;
      }    
      public double[][] inversa(double[][] m){
         double d = determinante(m,0);
         double[][] adjt = trasponerMatriz(adjunta(m));
         double[][] inversa = new double[m.length][m.length];        
         for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
               inversa[i][j] = (1/d)*adjt[i][j];
            }
         }
         return inversa;
      }    
      public double[][] multiplicarMatrices(double[][] b, double[][] a, int fb, int ca){
         double[][] m = new double[fb][ca];        
         for(int i = 0; i < m.length; i++){
            for(int j = 0; j < ca; j++){
               for(int k = 0; k < fb; k++){
                  m[i][j] += b[i][k]*a[k][j];
               }
            }
         }
         return m;
      }    
      public double[][] retarMatrices(double[][] a, double[][]b){
         double[][] c = new double[a.length][a.length];        
         for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
               c[i][j] = a[i][j] - b[i][j];
            }
         }
         return c;
      }    
      public double[] multiplicarVectorMatriz(double[] v, double[][] m){
         double[] vector = new double[m[0].length];        
         for(int i = 0; i < m[0].length; i++){
            for(int j = 0; j < m.length; j++){
               vector[i] += v[j]*m[j][i];
            }
         }
         return vector;
      }
      public double multiplicarVectores(double[] v1, double[] v2){
         double m = 0;        
         for(int i = 0; i < v1.length; i++){
            m += v1[i]*v2[i];
         }
         return m;
      }
      public double[] restarVectores(double[] v1, double[] v2){
         double[] resta = new double[v1.length];        
         for(int i = 0; i < v1.length; i++){
            resta[i] = v1[i] - v2[i];
         }
         return resta;
      }
      public double[] multiplicarMatrizVector(double[][] m, double[] v){
         double[] v_ = new double[v.length];
         for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
               v_[i] += m[i][j]*v[j];				
            }		
         }
         return v_;
      }
}
