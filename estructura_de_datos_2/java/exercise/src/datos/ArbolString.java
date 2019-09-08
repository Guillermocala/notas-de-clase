/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class ArbolString implements Serializable{
   private Arbin<String> raiz;   
   public void insertar(String x)
   {
      if(raiz == null)
      {
         raiz = new ArbinImpl<>(x);
      }
      else
      {
         insertar(raiz, x);
      }
   }
   private void insertar(Arbin<String> raiz, String x)
   {
      if(x.compareTo(raiz.obtener()) < 0)
      {         
         if(raiz.izq() == null)
         {
            raiz.enlIzq(new ArbinImpl<>(x));
         }
         else
         {
            insertar(raiz.izq(), x);
         }
      }
      else
      {
         if(x.compareTo(raiz.obtener()) > 0)
         {
            if(raiz.der() == null)
            {
               raiz.enlDer(new ArbinImpl<>(x));
            }
            else
            {
               insertar(raiz.der(), x);
            }
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
   private void inorden(Arbin<String> raiz)
   {
      if(raiz != null)
      {
         inorden(raiz.izq());
         res += " - " + raiz.obtener();
         inorden(raiz.der());
      }
   }
   public boolean buscar(String x)
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
   private boolean buscar(Arbin<String> raiz, String x)
   {
      if(x.compareTo(raiz.obtener()) == 0)
      {
         return true;
      }
      else
      {
         if(x.compareTo(raiz.obtener()) < 0)
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
   public void eliminar(String x)
   {
      if(buscar(x))
      {
         raiz = eliminar(raiz, x);
      }
   }
   private Arbin eliminar(Arbin<String> raiz, String x)
   {
      if(x.compareTo(raiz.obtener()) == 0)
      {
         return borrar(raiz, x);
      }
      else
      {
         if(x.compareTo(raiz.obtener()) < 0)
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
   public Arbin mayor(Arbin<String> raiz)
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
   private Arbin borrar(Arbin<String> raiz, String x)
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
               Arbin remp = mayor(raiz.izq());
               raiz.modificar((String) remp.obtener());
               raiz.enlIzq(eliminar(raiz.izq(), (String) remp.obtener()));
               return raiz;
            }
         }
      }
   }
   public static void main(String[] args) throws IOException {
      ArbolString arbol = new ArbolString();
      Persistencia archivo = new Persistencia();
      //hacer promedio de datos, mayor      
      String menu = "1.Insertar \n2.Listar \n3.Buscar \n4.Eliminar \n5.Salir";
      /*JOP tab primera opcion*/   
      arbol = archivo.recuperar("archivo.ch");
      salir:do
      {         
         String opcion = JOptionPane.showInputDialog(menu);
         int op = Integer.parseInt(opcion);
         switch(op)
         {
            case 1:
               String num = JOptionPane.showInputDialog("Digite el dato: ");               
               arbol.insertar(num);
               break;
            case 2:
               String aqui = arbol.listar();
               JOptionPane.showMessageDialog(null, aqui);               
               break;
            case 3:
               String parabuscar = JOptionPane.showInputDialog("Digite la dato a buscar: ");               
               if(arbol.buscar(parabuscar))
               {
                  JOptionPane.showMessageDialog(null, "Dato encontrado");
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Dato no encontrado");
               }
               break;
            case 4:
               String parabuscar2 = JOptionPane.showInputDialog("Digite el dato a eliminar: ");               
               if(arbol.buscar(parabuscar2))
               {                  
                  arbol.eliminar(parabuscar2);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "Dato no encontrado");
               }                                            
               break;            
            case 5:        
               archivo.guardar(arbol);
               break salir;
         }            
      }while(true);
   }
}
