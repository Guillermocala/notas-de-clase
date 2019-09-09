/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

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
   public static void main(String[] args) {
      ArbolMaterias arbol = new ArbolMaterias();
      TadMaterias<Materias> raiz;   
      TadMaterias<Materias> temp;
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1, sw5 = 1;            
      String nombreEst = "Nombre Estudiante";
      String codigoEst = "0000000000";
      String menu = "          HISTORIAL ACADEMICO \nEstudiante: " + nombreEst + "\nCodigo estudiantil: " + codigoEst + "\n1.Estudiante \n2.Materias \n3.Informes \n0.Salir";
      String menu2 = "          ESTUDIANTE \n1.Modificar Nombre \n2.Modificar Codigo \n0.Salir";
      String menu3 = "          MATERIAS\n1.Buscar \n2.Insertar \n3.Eliminar \n4.Mostrar en lista \n0.Salir";
      String menu4 = "          BUSCAR MATERIA\n1.Por codigo \n2.Por nombre \n0.Salir";
      String menu5 = "          INFORMES\n1.Promedio Ponderado \n2.%Materias perdidas \n3.Mejores 5 materias \n4.Semestres aprobados \n0.Salir";
      /*JOP tab primera opcion*/      
      do
      {
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);         
         switch(op)
         {            
            case 1:               
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
                        String codigo = JOptionPane.showInputDialog("Ingrese Codigo: ");
                        int codig = Integer.parseInt(codigo);
                        String nombre = JOptionPane.showInputDialog("Ingrese Nombre: ");
                        String creditos = JOptionPane.showInputDialog("Ingrese Creditos: ");
                        int credito = Integer.parseInt(creditos);
                        String nota = JOptionPane.showInputDialog("Ingrese Nota: ");
                        int not = Integer.parseInt(nota);
                        String semestre = JOptionPane.showInputDialog("Ingrese Semestre: ");
                        int semestr = Integer.parseInt(semestre);
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
               do
               {
                  String opcion5 = JOptionPane.showInputDialog(menu5);
                  int op5 = Integer.parseInt(opcion5);
                  switch(op5)
                  {
                     case 1:
                        /*promedio ponderado*/
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
               break;
            case 0: 
               sw = 0;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opcion erronea...");
               break;
         }            
      }while(sw != 0);
   }   
}
