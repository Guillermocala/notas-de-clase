
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 57300
 */
public class Colegio implements Serializable{
   private ArrayList<Alumno> alumnos = new ArrayList<>();

   /**
    * @return the alumnos
    */
   public ArrayList<Alumno> getAlumnos() {
      return alumnos;
   }

   /**
    * @param alumnos the alumnos to set
    */
   public void setAlumnos(ArrayList<Alumno> alumnos) {
      this.alumnos = alumnos;
   }
   
   //Ingresar objeto
   public void insertar(Alumno x) {
      if (alumnos.contains(x)) {
         JOptionPane.showMessageDialog(null, "Alumno ya existente!");
      }
      else {
         alumnos.add(x);
      }
   }
   //Mostrar objetos
   public void listar() {
      for (Alumno alumno : alumnos) {
         JOptionPane.showMessageDialog(null, alumno.toString());
      }
   }
   //busqueda lineal
   public void busqueda(String name) {
      for (Alumno alumno : alumnos) {
         if (alumno.getNombre().compareTo(name) == 0) {
            JOptionPane.showMessageDialog(null, alumno.toString());
            break;
         }
      }
   }
   //busquedas binarias: codigo y grado
   public Alumno busqBinCod(int code) {
      int ini = 0;
      int fin = alumnos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (code == alumnos.get(c).getCodigo()) {
            return alumnos.get(c);
         }
         else {
            if (code > alumnos.get(c).getCodigo()) {
               ini = c + 1;
            }
            else {
               fin = c - 1 ;
            }
         }
      }
      return null;
   }
   //busq grado
   public Alumno busqBinGrad(int grad) {
      int ini = 0;
      int fin = alumnos.size() - 1;
      while (ini <= fin) {         
         int c = (ini + fin) / 2;
         if (grad == alumnos.get(c).getGrado()) {
            return alumnos.get(c);
         }
         else {
            if (grad > alumnos.get(c).getGrado()) {
               ini = c + 1;
            }
            else {
               fin = c - 1 ;
            }
         }
      }
      return null;
   }
   //ordenar coleccion: codigo
   public void ordenaPorCodigo(int ini, int fin) {
      int piv = (ini + fin) / 2;
      Alumno pivote = alumnos.get(piv);
      int i = ini, j = fin;
      while(i <= j) {
         while(alumnos.get(i).getCodigo() < pivote.getCodigo()) { i++; }
         while(alumnos.get(j).getCodigo() > pivote.getCodigo()) { j--; }
         if(i <= j) {
            Alumno t = alumnos.get(i);
            alumnos.set(i, alumnos.get(j));
            alumnos.set(j, t);
            i++;
            j--;
         }
      }
      if (ini < j) {
         ordenaPorCodigo(ini, j);
      }
      if (i < fin) {
         ordenaPorCodigo(i, fin);
      }
   }
   //ordenar por grado
   public void ordenaPorGrado(int ini, int fin) {
      int piv = (ini + fin) / 2;
      Alumno pivote = alumnos.get(piv);
      int i = ini, j = fin;
      while(i <= j) {
         while(alumnos.get(i).getGrado()< pivote.getGrado()) { i++; }
         while(alumnos.get(j).getGrado()> pivote.getGrado()) { j--; }
         if(i <= j) {
            Alumno t = alumnos.get(i);
            alumnos.set(i, alumnos.get(j));
            alumnos.set(j, t);
            i++;
            j--;
         }
      }
      if (ini < j) {
         ordenaPorCodigo(ini, j);
      }
      if (i < fin) {
         ordenaPorCodigo(i, fin);
      }
   }
}
