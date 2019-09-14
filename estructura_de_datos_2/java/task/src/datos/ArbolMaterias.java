/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class ArbolMaterias {
   private TadMaterias<Materias> raiz;
   /**
    * @return the raiz
    */
   public TadMaterias<Materias> getRaiz() {
      return raiz;
   }
   public void insertar(Materias x) {
      if(raiz == null)
      {
         raiz = new PlataformaImpl<>(x);
      }
      else
      {
         insertar((PlataformaImpl<Materias>) raiz, x);
      }
   }
   private void insertar(PlataformaImpl<Materias> raiz, Materias x) {
      if(x.getCodigo() < raiz.obtener().getCodigo())
      {
         if(raiz.izq() == null)
         {
            raiz.enlIzq(new PlataformaImpl<>(x));
         }
         else
         {
            insertar((PlataformaImpl<Materias>) raiz.izq(), x);
         }
      }
      else
      {
         if(raiz.der() == null)
         {
            raiz.enlDer(new PlataformaImpl<>(x));
         }
         else
         {
            insertar((PlataformaImpl<Materias>) raiz.der(), x);
         }
      }
   }
   String res = " ";
   public String mostrar(TadMaterias<Materias> raiz)
   {
      res = "";
      inorden(raiz);
      return res;
   }
   public void inorden(TadMaterias<Materias> raiz)
   {
      if(raiz != null)
      {
         inorden(raiz.izq());
         res += "\n\nNombre: " + raiz.obtener().getNombre() + "\nCodigo: " + raiz.obtener().getCodigo() + "\nCreditos: " + raiz.obtener().getCreditos() + "\nNota: " + raiz.obtener().getNota() + "\nSemestre: " + raiz.obtener().getSemestre();         
         inorden(raiz.der());
      }
   }
   public TadMaterias<Materias> buscarPorCodigo(int x)
   {
      if(raiz == null)
      {
         return null;
      }
      else
      {
         return buscar(raiz, x);
      }
   }
   private TadMaterias<Materias> buscar(TadMaterias<Materias> raiz, int x)
   {
      if(raiz.obtener().getCodigo() == x)
      {
         return raiz;
      }
      else
      {
         if(x < raiz.obtener().getCodigo())
         {
            if(raiz.izq() == null)
            {
               return null;
            }
            else
            {
               return buscar(raiz.izq(), x);
            }
         }
         else
         {
            if(raiz.der() == null)
            {
               return null;
            }
            else
            {
               return buscar(raiz.der(), x);
            }
         }
      }
   }
   public TadMaterias<Materias> buscarPorNombre(String x)
   {
      if(raiz == null)
      {
         return null;
      }
      else
      {
         return buscar(raiz, x);
      }
   }
   private TadMaterias<Materias> buscar(TadMaterias<Materias> raiz, String x)
   {
      if(x.compareTo(raiz.obtener().getNombre()) == 0)
      {
         return raiz;
      }
      else
      {
         if(x.compareTo(raiz.obtener().getNombre()) < 0)
         {
            if(raiz.izq() == null)
            {
               return null;
            }
            else
            {
               return buscar(raiz.izq(), x);
            }
         }
         else
         {
            if(raiz.der() == null)
            {
               return null;
            }
            else
            {
               return buscar(raiz.der(), x);
            }
         }
      }
   }
   public void eliminar(int x)
   {
      if(buscarPorCodigo(x) != null)
      {
         raiz = eliminar(raiz, x);
      }
   }
   private TadMaterias<Materias> eliminar(TadMaterias<Materias> raiz, int x)
   {
      if(x == raiz.obtener().getCodigo())
      {
         return borrar(raiz, x);
      }
      else
      {
         if(x < raiz.obtener().getCodigo())
         {
            raiz.enlIzq(eliminar(raiz.izq(), x));
         }
         else
         {
            raiz.enlDer(eliminar(raiz.der(), x));
         }
         return raiz;
      }
   }
   public TadMaterias<Materias> mayor(TadMaterias<Materias> raiz)
   {
      if(raiz.der() != null)
      {
         return mayor(raiz.der());
      }
      else
      {
         return raiz;
      }
   }
   private TadMaterias<Materias> borrar(TadMaterias<Materias> raiz, int x)
   {
      if(raiz.izq() == null && raiz.der() == null)
      {
         return null;
      }
      else
      {
         if(raiz.izq() == null)
         {
            return raiz.der();
         }
         else
         {
            if(raiz.der() == null)
            {
               return raiz.izq();
            }
            else
            {
               TadMaterias<Materias> remp = mayor(raiz.izq());
               raiz.modificar((Materias) remp.obtener());
               raiz.enlIzq(eliminar(raiz.izq(), remp.obtener().getCodigo()));
               return raiz;
            }
         }
      }
   }
   public static boolean verifSemestre(TadMaterias<Materias> raiz, int semestre)
   {
      if(raiz != null)
      {
         if(raiz.obtener().getSemestre() == semestre)
         {
            return true;
         }
         else
         {
            return verifCodigo(raiz.der(), semestre) || verifCodigo(raiz.izq(), semestre);
         }
      }
      else
      {
         return false;
      }
   }
   public static boolean verifCodigo(TadMaterias<Materias> raiz, int codigo)
   {
      if(raiz != null)
      {
         if(raiz.obtener().getCodigo() == codigo)
         {
            return true;
         }
         else
         {
            return verifCodigo(raiz.der(), codigo) || verifCodigo(raiz.izq(), codigo);
         }
      }
      else
      {
         return false;
      }
   }
   public static float sumTotal = 0, temporal;
   public static int credits = 0;   
   public static void promedio(TadMaterias<Materias> raiz, int elem, float temporal, float sumTotal, int credits)
   {
      if(raiz != null)
      {
         if(raiz.obtener().getSemestre() == elem)
         {
            credits += raiz.obtener().getCreditos();
            temporal = raiz.obtener().getNota() * raiz.obtener().getCreditos();
            sumTotal += temporal;
            promedio(raiz.izq(), elem, temporal, sumTotal, credits);
            promedio(raiz.der(), elem, temporal, sumTotal, credits);
         }         
      }     
   }
   public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
      ArbolMaterias arbol = new ArbolMaterias();
      TadMaterias<Materias> raiz;   
      TadMaterias<Materias> temp; 
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1, sw5 = 1;
      float notasPorSemestre[] = new float [11];
      int maxCreditos = 5;    //<---------------------- PARA CONTROLAR LA CANTIDAD MAXIMA DEL TIPO DE DATO
      float maxNota = 500;   //<---------------------- PARA CONTROLAR LA CANTIDAD MAXIMA DEL TIPO DE DATO
      /*File ob = new File("archivo.ch");
      if(ob.exists())
      {
         arbol = archivo.recuperar();
      }
      else
      {
         ArbolMaterias arbol = new ArbolMaterias();
      }*/
      /*ObjectInputStream ois;
      try
      {
         File archivo=new File("datos.txt");
         FileInputStream fis = new FileInputStream(archivo);
         ois = new ObjectInputStream(fis);
         while(true)
         {
            arbol = (ArbolMaterias) ois.readObject();
         }
      }
      catch(IOException io)
      {

      }*/
      String nombreEst = "Nombre Estudiante";
      String codigoEst = "0000000000";
      String menu = "          HISTORIAL ACADEMICO \nEstudiante: " + nombreEst + "\nCodigo estudiantil: " + codigoEst + "\n1.Estudiante \n2.Materias \n3.Informes \n0.Salir";
      String menu2 = "          ESTUDIANTE \n1.Modificar Nombre \n2.Modificar Codigo \n0.Salir";
      String menu3 = "          MATERIAS\n1.Buscar \n2.Insertar \n3.Eliminar \n4.Mostrar en lista \n0.Salir";
      String menu4 = "          BUSCAR MATERIA\n1.Por codigo \n2.Por nombre \n0.Salir";
      String menu5 = "          INFORMES\n1.Promedio ponderado \n2.%Materias perdidas \n3.Mejores 5 materias \n4.Semestres aprobados \n0.Salir";
      /*JOP tab primera opcion*/      
      do
      {
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);         
         switch(op)
         {            
            case 1:
               /*Estudiante*/
               do
               {                  
                  String opcion2 = JOptionPane.showInputDialog(menu2);
                  int op2 = Integer.parseInt(opcion2);
                  switch(op2)
                  {
                     case 1:
                        /*modificar nombre*/
                        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                        nombreEst = nombreEst.replaceAll(nombreEst, name);                                                
                        break;
                     case 2: 
                        /*modificar codigo*/
                        String code = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                        codigoEst = codigoEst.replaceAll(codigoEst, code);                                                
                        break;
                     case 0:
                        sw2 = 0;
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Opcion erronea...");
                        break;
                  }
               }while(sw2 != 0);                                             
               menu = "          HISTORIAL ACADEMICO \nEstudiante: " + nombreEst + "\nCodigo estudiantil: " + codigoEst + "\n1.Estudiante \n2.Materias \n3.Informes \n0.Salir";
               break;
            case 2:
               /*Materias*/
               do
               {
                  String opcion3 = JOptionPane.showInputDialog(menu3);
                  int op3 = Integer.parseInt(opcion3);
                  switch(op3)
                  {
                     case 1:
                        /*Buscar materia*/
                        raiz = arbol.getRaiz();
                        if(raiz != null)
                        {
                           do
                           {
                              String opcion4 = JOptionPane.showInputDialog(menu4);
                              int op4 = Integer.parseInt(opcion4);
                              switch(op4)
                              {
                                 case 1:
                                    /*buscar por codigo*/
                                    String buscarCode = JOptionPane.showInputDialog("Ingrese el codigo: ");
                                    int buscarCod = Integer.parseInt(buscarCode);                                
                                    if(arbol.buscarPorCodigo(buscarCod) != null)
                                    {
                                       temp = arbol.buscarPorCodigo(buscarCod);
                                       String muestraCodigoTemp = "          ELEMENTRO ENCONTRADO!\nNombre: " + temp.obtener().getNombre() + "\nCodigo: " + temp.obtener().getCodigo() + "\nCreditos: " + temp.obtener().getCreditos() + "\nNota: " + temp.obtener().getNota() + "\nSemestre: " + temp.obtener().getSemestre();                                                                        
                                       JOptionPane.showMessageDialog(null, muestraCodigoTemp);                                    
                                    }
                                    else
                                    {
                                       JOptionPane.showMessageDialog(null, "Elemento no encontrado...");
                                    }
                                    break;
                                 case 2:
                                    /*buscar por nombre*/
                                    String buscarName = JOptionPane.showInputDialog("Ingrese el nombre: ");
                                    if(arbol.buscarPorNombre(buscarName) != null)
                                    {
                                       temp = arbol.buscarPorNombre(buscarName);
                                       String muestraCodigoTemp = "          ELEMENTRO ENCONTRADO!\nNombre: " + temp.obtener().getNombre() + "\nCodigo: " + temp.obtener().getCodigo() + "\nCreditos: " + temp.obtener().getCreditos() + "\nNota: " + temp.obtener().getNota() + "\nSemestre: " + temp.obtener().getSemestre();                                                                        
                                       JOptionPane.showMessageDialog(null, muestraCodigoTemp);                                    
                                    }
                                    else
                                    {
                                       JOptionPane.showMessageDialog(null, "Elemento no encontrado...");
                                    }
                                    break;
                                 case 0:
                                    sw5 = 0;
                                 default:
                                    JOptionPane.showMessageDialog(null, "Opcion erronea...");
                                    break;                        
                              }
                           }while(sw5 != 0);
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(null, "El arbol esta vacio...");
                        }                                    
                        break;
                     case 2:
                        /*Insertar materia*/
                        raiz = arbol.getRaiz();
                        String codigo = JOptionPane.showInputDialog("Ingrese Codigo: ");
                        int codig = Integer.parseInt(codigo);
                        while(verifCodigo(raiz, codig))
                        {
                           JOptionPane.showMessageDialog(null, "El codigo ya existe!");
                           codigo = JOptionPane.showInputDialog("Ingrese Codigo: ");
                           codig = Integer.parseInt(codigo);
                        }
                        String nombre = JOptionPane.showInputDialog("Ingrese Nombre: ");
                        String creditos = JOptionPane.showInputDialog("Ingrese Creditos(max 5): ");
                        int credito = Integer.parseInt(creditos);
                        while(credito > maxCreditos || credito < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           creditos = JOptionPane.showInputDialog("Ingrese Creditos(max 5): ");
                           credito = Integer.parseInt(creditos);
                        }
                        String nota = JOptionPane.showInputDialog("Ingrese Nota(max 500): ");
                        float not = Float.parseFloat(nota);
                        while(not > maxNota || not < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           nota = JOptionPane.showInputDialog("Ingrese Nota(max 500): ");
                           not = Float.parseFloat(nota);
                        }
                        String semestre = JOptionPane.showInputDialog("Ingrese Semestre(1 a 10): ");
                        int semestr = Integer.parseInt(semestre);
                        while(semestr > 10 || semestr < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           semestre = JOptionPane.showInputDialog("Ingrese Semestre(1 a 10): ");                        
                           semestr = Integer.parseInt(semestre);                           
                        }
                        Materias dato = new Materias(codig, nombre, credito, not, semestr);
                        arbol.insertar(dato);
                        break;
                     case 3:
                        /*eliminar materia*/
                        raiz = arbol.getRaiz();
                        if(raiz != null)
                        {
                           String codigoElim = JOptionPane.showInputDialog("Ingrese Codigo: ");
                           int codigElim = Integer.parseInt(codigoElim);
                           arbol.eliminar(codigElim);
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(null, "El arbol esta vacio...");
                        }                        
                        break;             
                     case 4:
                        /*mostrar materias*/                                                        
                        raiz = arbol.getRaiz();
                        if(raiz != null)
                        {
                           JOptionPane.showMessageDialog(null, "          MATERIAS" + arbol.mostrar(raiz));
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(null, "El arbol esta vacio...");
                        }                                 
                        break;
                     case 0:
                        sw3 = 0;
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Opcion erronea...");
                        break;                        
                  }                  
               }while(sw3 != 0);
               break;
            case 3:
               /*Informes*/
               raiz = arbol.getRaiz();
               if(raiz != null)
               {
                  do
                  {
                     String opcion5 = JOptionPane.showInputDialog(menu5);
                     int op5 = Integer.parseInt(opcion5);
                     switch(op5)
                     {
                        case 1:
                           /*promedio ponderado*/
                           sumTotal = 0;
                           credits = 0;
                           for(int i = 1; i < notasPorSemestre.length; i++)
                           {
                              temporal = 0;
                              promedio(raiz, i, temporal, sumTotal, credits);
                              if(credits != 0)
                              {                                 
                                 notasPorSemestre[i] = sumTotal/credits;
                              }
                              else
                              {
                                 notasPorSemestre[i] = 0;
                              }
                           }
                           for(int i = 1; i < notasPorSemestre.length; i++)
                           {
                              System.out.println(" " + notasPorSemestre[i]);
                           }
                           break;
                        case 2:
                           /*%materias perdidas*/
                           break;
                        case 3:
                           /*mejores 5 materias*/
                           break;
                        case 4:
                           /*semestres aprobados*/
                           break;                        
                        case 0:
                           sw4 = 0;
                           break;
                        default:
                           JOptionPane.showMessageDialog(null, "Opcion erronea...");
                           break;                        
                     }                  
                  }while(sw4 != 0);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "El arbol esta vacio...");
               }               
               break;
            case 0:               
               sw = 0;
               /*File f = new File("datos.txt");
               FileOutputStream fos = new FileOutputStream(f);
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(arbol);
               oos.close();*/
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opcion erronea...");
               break;
         }            
      }while(sw != 0);
   }      
}
