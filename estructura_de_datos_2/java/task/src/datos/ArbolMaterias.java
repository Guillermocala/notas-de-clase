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
   public String listar()
   {
      res = "";
      inorden(raiz);
      return res;
   }
   private void inorden(TadMaterias<Materias> raiz)
   {
      if(raiz != null)
      {
         inorden(raiz.izq());
         res += " " + raiz.obtener();
         inorden(raiz.der());
      }
   }
   public boolean buscar(Materias x)
   {
      if(raiz == null)
      {
         return false;
      }
      else
      {
         return buscar(raiz, x);
      }
   }
   private boolean buscar(TadMaterias<Materias> raiz, Materias x)
   {
      if(raiz.obtener() == x)
      {
         return true;
      }
      else
      {
         if(x.getCodigo() < raiz.obtener().getCodigo())
         {
            if(raiz.izq() == null)
            {
               return false;
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
               return false;
            }
            else
            {
               return buscar(raiz.der(), x);
            }
         }
      }
   }
   public void eliminar(Materias x)
   {
      if(buscar(x))
      {
         raiz = eliminar(raiz, x);
      }
   }
   private TadMaterias eliminar(TadMaterias<Materias> raiz, Materias x)
   {
      if(x.getCodigo() == raiz.obtener().getCodigo())
      {
         return borrar(raiz, x);
      }
      else
      {
         if(x.getCodigo() < raiz.obtener().getCodigo())
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
   public TadMaterias mayor(TadMaterias<Materias> raiz)
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
   private TadMaterias borrar(TadMaterias<Materias> r, Materias x)
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
               TadMaterias remp = mayor(raiz.izq());
               raiz.modificar((Materias) remp.obtener());
               raiz.enlIzq(eliminar(raiz.izq(), (Materias) remp.obtener()));
               return raiz;
            }
         }
      }
   }
   public static void main(String[] args) {
      ArbolMaterias arbol = new ArbolMaterias();
      int sw = 1, sw2 = 1, sw3 = 1, sw4 = 1;
      String menu = "1.Estudiante \n2.Materias \n3.Informes \n0.Salir";
      String menu2 = "1.Modificar Nombre \n2.Modificar Codigo \n0.Salir";
      String menu3 = "1.Buscar \n2.Insertar \n3.Eliminar \n4.Codigo \n5.Materia \n0.Salir";
      String menu4 = "1.Promedio Ponderado \n2.%Materias perdidas \n3.Mejores 5 materias \n4.Semestres aprobados \n0.Salir";
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
                        break;
                     case 2: 
                        /*modificar codigo*/
                        break;
                     case 0:
                        sw2 = 0;
                        break;
                     default:
                        JOptionPane.showMessageDialog(null, "Opcion erronea...");
                        break;
                  }
               }while(sw2 != 0);                                             
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
                        break;
                     case 2:
                        /*Insertar materia*/
                        break;
                     case 3:
                        /*eliminar materia*/                        
                        break;
                     case 4:
                        /*codigo de materia*/
                        break;
                     case 5:
                        /*Nombre de materia*/
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
                  String opcion4 = JOptionPane.showInputDialog(menu4);
                  int op4 = Integer.parseInt(opcion4);
                  switch(op4)
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
