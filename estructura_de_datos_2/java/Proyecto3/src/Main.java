
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class Main {
   public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
      //persistencia
      Colegio cole;
      Persistencia guarda = new Persistencia();
      File nose = new File("archivo.ch");
      if (nose.exists()) {
         cole = guarda.recuperar("archivo.ch");
      }
      else {
         cole = new Colegio();
      }
      String nombres;
      Alumno alum;
      boolean activador = true;
      int opcion, datoCodig, datoGrad, datoEdad;
      String menu = "1.Ingreso del objeto \n2.Listar objetos \n3.Buscar por 1 atributo(busq lineal) "
              + "\n4.Buscar por 2 atributos(busq binaria) \n5.Ordenar \n6.Salir";
      String ordenar = "1. Buscar por codigo \n2.Buscar por grado";
      do {
         opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
         switch(opcion) {
            case 1: //insertar
               nombres = JOptionPane.showInputDialog("Ingrese nombre: ");
               datoCodig = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo: "));
               datoGrad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado: "));
               datoEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el edad: "));
               cole.insertar(new Alumno(nombres, datoCodig, datoEdad, datoGrad));
               guarda.guardar(cole);
               break;
            case 2: //listar
               cole.listar();
               break;
            case 3: //buscar lineal
               nombres = JOptionPane.showInputDialog("Ingrese nombre: ");
               cole.busqueda(nombres);
               break;
            case 4: //busq binaria
               opcion = Integer.parseInt(JOptionPane.showInputDialog(ordenar));
               switch(opcion) {
                  case 1: //busq codigo
                     cole.ordenaPorCodigo(0, (cole.getAlumnos().size() - 1));
                     datoCodig = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo: "));
                     alum = cole.busqBinCod(datoCodig);
                     if (alum == null) {
                        JOptionPane.showMessageDialog(null, "no se encontro");
                     }
                     else {
                        JOptionPane.showMessageDialog(null, alum.toString());
                     }
                     break;
                  case 2: //busq grado
                     cole.ordenaPorGrado(0, (cole.getAlumnos().size() - 1));
                     datoGrad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el grado: "));
                     alum = cole.busqBinGrad(datoGrad);
                     if (alum == null) {
                        JOptionPane.showMessageDialog(null, "no se encontro");
                     }
                     else {
                        JOptionPane.showMessageDialog(null, alum.toString());
                     }
                     break; 
                  default:
                     JOptionPane.showMessageDialog(null, "error");
                     break;
               }
               break;
            case 5: //ordenar
               cole.ordenaPorCodigo(0, (cole.getAlumnos().size() - 1));
               guarda.guardar(cole);
               break;
            case 6: //salir
               activador = false;
               break;
            default:
               JOptionPane.showMessageDialog(null, "error");
               break;
         }
      } while (activador == true);
   }
}
