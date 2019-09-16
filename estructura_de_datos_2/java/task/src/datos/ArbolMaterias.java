/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author 57300
 */
public class ArbolMaterias implements Serializable{
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
         res += "\n-Nombre: " + raiz.obtener().getNombre() + "\nCodigo: " + raiz.obtener().getCodigo() + "\nCreditos: " + raiz.obtener().getCreditos() + "\nNota: " + raiz.obtener().getNota() + "\nSemestre: " + raiz.obtener().getSemestre();         
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
      else
      {
         JOptionPane.showMessageDialog(null, "Dato no encontrado...");
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
            if(codigo < raiz.obtener().getCodigo())
            {
               if(raiz.izq() == null)
               {
                  return false;
               }
               else
               {
                  return verifCodigo(raiz.izq(), codigo);
               }
            }
            else
            {
               if(raiz.der() == null)
               {
                  return false;
               }
               else
               {
                  return verifCodigo(raiz.der(), codigo);
               }
            }            
         }
      }
      else
      {
         return false;
      }
   }
   public static float cant = 0;
   public static float promedio(TadMaterias<Materias> raiz, int elem)
   {
      if(raiz != null)
      {
         if(elem == raiz.obtener().getSemestre())
         {
            cant += raiz.obtener().getCreditos();
            return ((raiz.obtener().getNota()*raiz.obtener().getCreditos()) + promedio(raiz.izq(), elem) + promedio(raiz.der(), elem));            
         }
         else
         {            
            return 0;
         }
      }
      else
      {
         return 0;
      }
   }
   public static float cantMat = 0, cantPerd = 0, cantGana = 0;
   public static void matPerdidas(TadMaterias<Materias> raiz)
   {
      if(raiz != null)
      {
         if(raiz.obtener().getNota() < 300)
         {
            cantPerd++;
         }
         else
         {
            cantGana += raiz.obtener().getCreditos();
         }
         cantMat++;         
         matPerdidas(raiz.izq());
         matPerdidas(raiz.der());
      }
   }
   public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
      ArbolMaterias arbol;
      TadMaterias<Materias> raiz;   
      TadMaterias<Materias> temp;
      Persistencia archivo = new Persistencia();
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1, sw5 = 1;
      String nombreEst;
      String codigoEst;
      int maxCreditos = 5;    //<---------------------- PARA CONTROLAR LA CANTIDAD MAXIMA DE CREDITOS
      float maxNota = 500;   //<---------------------- PARA CONTROLAR LA CANTIDAD MAXIMA DE NOTAS
      int maxSemestre = 10;    //<---------------------- PARA CONTROLAR LA CANTIDAD MAXIMA DE SEMESTRES
      File ob = new File("archivo.ch");
      if(ob.exists())
      {
         arbol = archivo.recuperar("archivo.ch");
      }
      else
      {
         arbol = new ArbolMaterias();
      }
      File est = new File("archivoEst.ch");
      if(est.exists())
      {
         nombreEst = archivo.recuperarEst("archivoEst.ch");
      }
      else
      {
         nombreEst = "Nombre Estudiante";
      }
      File cod = new File("archivoCod.ch");
      if(cod.exists())
      {
         codigoEst = archivo.recuperarCod("archivoCod.ch");
      }
      else
      {
         codigoEst = "0000000000";
      }      
      String menu = "          HISTORIAL ACADEMICO \nEstudiante: " + nombreEst + "\nCodigo estudiantil: " + codigoEst + "\n1.Estudiante \n2.Materias \n3.Informes \n0.Salir";
      String menu2 = "          ESTUDIANTE \n1.Modificar Nombre \n2.Modificar Codigo \n0.Salir";
      String menu3 = "          MATERIAS\n1.Buscar \n2.Insertar \n3.Eliminar \n4.Mostrar en lista \n0.Salir";
      String menu4 = "          BUSCAR MATERIA\n1.Por codigo \n2.Por nombre \n0.Salir";
      String menu5 = "          INFORMES\n1.Promedio ponderado \n2.% Materias perdidas \n3.Mejores 5 materias \n4.Semestres aprobados \n0.Salir";
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
                        archivo.guardarEst(name);
                        break;
                     case 2: 
                        /*modificar codigo*/
                        String code = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                        codigoEst = codigoEst.replaceAll(codigoEst, code);
                        archivo.guardarCod(code);
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
                                    break;
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
                        String creditos = JOptionPane.showInputDialog("Ingrese los creditos(1 a " + maxCreditos + "): ");
                        int credito = Integer.parseInt(creditos);
                        while(credito > maxCreditos || credito < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           creditos = JOptionPane.showInputDialog("Ingrese los creditos(1 a " + maxCreditos + "): ");
                           credito = Integer.parseInt(creditos);
                        }
                        String nota = JOptionPane.showInputDialog("Ingrese la nota(1 a " + maxNota + "): ");
                        float not = Float.parseFloat(nota);
                        while(not > maxNota || not < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           nota = JOptionPane.showInputDialog("Ingrese la nota(1 a " + maxNota + "): ");
                           not = Float.parseFloat(nota);
                        }
                        String semestre = JOptionPane.showInputDialog("Ingrese Semestre(1 a " + maxSemestre + "): ");
                        int semestr = Integer.parseInt(semestre);
                        while(semestr > maxSemestre || semestr < 1)
                        {
                           JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                           semestre = JOptionPane.showInputDialog("Ingrese Semestre(1 a " + maxSemestre + "): ");
                           semestr = Integer.parseInt(semestre);                           
                        }
                        Materias dato = new Materias(codig, nombre, credito, not, semestr);
                        arbol.insertar(dato);
                        archivo.guardar(arbol);
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
                        archivo.guardar(arbol);                        
                        break;             
                     case 4:
                        /*mostrar materias*/                                                        
                        raiz = arbol.getRaiz();
                        if(raiz != null)
                        {
                           JTextArea textArea = new JTextArea(arbol.mostrar(raiz));
                           JScrollPane scrollPane = new JScrollPane(textArea);  
                           textArea.setLineWrap(true);  
                           textArea.setWrapStyleWord(true); 
                           scrollPane.setPreferredSize(new Dimension(250,400));
                           JOptionPane.showMessageDialog(null, scrollPane, "                    MATERIAS", JOptionPane.YES_NO_OPTION);                           
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
                           float vectTemp[] = new float[11];
                           cant = 0;
                           float notaTemp = promedio(raiz, 1);
                           vectTemp[1] = notaTemp/cant;
                           String mostrarDato = "El promedio es: " + Float.toString(vectTemp[1]);
                           JOptionPane.showMessageDialog(null, mostrarDato);
                           break;
                        case 2:
                           /*% materias perdidas*/
                           cantMat = 0;
                           cantPerd = 0;
                           matPerdidas(raiz);
                           float percent = ((cantPerd/cantMat) * 100);
                           String percent2 = "El porcentaje de materias perdidas es: " + Float.toString(percent) + "%";
                           JOptionPane.showMessageDialog(null, percent2);
                           break;
                        case 3:
                           /*mejores 5 materias*/
                           String nothingToDo = "Building...";
                           JOptionPane.showMessageDialog(null, nothingToDo);
                           break;
                        case 4:
                           /*semestres aprobados*/
                           cantGana = 0;
                           matPerdidas(raiz);
                           String semAprob = JOptionPane.showInputDialog(null, "Ingrese la cantidad de creditos por semestre(entre 10 y 20): ");
                           float cantPerSemestre = Float.parseFloat(semAprob);
                           while(cantPerSemestre < 10 || cantPerSemestre > 20)
                           {
                              JOptionPane.showMessageDialog(null, "Verifique el dato ingresado!");
                              semAprob = JOptionPane.showInputDialog(null, "Ingrese la cantidad de creditos por semestre(entre 10 y 20): ");
                              cantPerSemestre = Integer.parseInt(semAprob);
                           }
                           float cantSemestres = 160/cantPerSemestre;
                           float semesAprobados = cantGana/cantPerSemestre;
                           String conclusion = "Con " + cantPerSemestre + " creditos por semestre, se aprobaron " + semesAprobados + " de " + cantSemestres + " semestres.";
                           JOptionPane.showMessageDialog(null, conclusion);
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
               archivo.guardar(arbol);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opcion erronea...");
               break;
         }            
      }while(sw != 0);
   }      
}
