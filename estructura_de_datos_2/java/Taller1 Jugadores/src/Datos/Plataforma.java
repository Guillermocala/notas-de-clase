/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class Plataforma implements Serializable{
   public Arbin<Jugador> raiz;
   public Jugador temporal;
   int mayor = 0;
   ArrayList<Jugador> asalariados; /*GUARDA LOS JUGADORES QUE TIENEN MAS DE SALARIO X*/
   String jugadores;
   
   public void insertar(Jugador x) {
      if (raiz != null) {
         insertar(raiz, x);
      }
      else {
         raiz = new ArbinImp(x);
      }
   }
   private void insertar(Arbin<Jugador> r, Jugador x) {
      if (x.getCodigo() < r.obtener().getCodigo()) {
         if (r.izq() == null) {
            r.enlIzq(new ArbinImp(x));
         }
         else {
            insertar(r.izq(), x);
         }
      }
      else {
         if (r.der() == null) {
            r.enlDer(new ArbinImp(x));
         }
         else {
            insertar(r.der(), x);
         }
      }
   }
   public Jugador buscaByCodigo(int codigo) {
      if (raiz != null) {
         return buscaByCodigo(raiz, codigo);
      }
      else {
         return null;
      }
   }
   private Jugador buscaByCodigo(Arbin<Jugador> r, int codigo) {
      if (r.obtener().getCodigo() == codigo) {
         return r.obtener();
      }
      else {
         if (codigo < r.obtener().getCodigo()) {
            if (r.izq() != null) {
               return buscaByCodigo(r.izq(), codigo);
            }
            else{ 
               return null;
            }
         }
         else {
            if (r.der() != null) {
               return buscaByCodigo(r.der(), codigo);
            }
            else{ 
               return null;
            }
         }
      }
   }
   public Jugador buscaByNombre(String nombre) {
      temporal = null;
      if (raiz != null) {         
         buscaByNombre(raiz, nombre);
         return temporal;
      }
      return temporal;
   }
   private void buscaByNombre(Arbin<Jugador> r, String nombre) {
      if (r != null) {
         /*ENCONTRAMOS EL OBJETO CON .COMPARETO()*/
         if (r.obtener().getNombre().compareTo(nombre) == 0) {
            temporal = r.obtener();
         }
         buscaByNombre(r.izq(), nombre);
         buscaByNombre(r.der(), nombre);
      }         
   }
   public void elimina(Jugador x) {
      /*ESTE IF ES POR SI USAMOS LA FUNCION EN OTRA OCASION Y NECESITAMOS
      UNA EVALUACION ELEMENTAL COMO LO ES QUE EL OBJETO NO EXISTA, ES DECIR = NULL*/
      if (x != null) {
         raiz = elimina(raiz, x);
         /*DESPUES DE ENTRAR A LA FUNCION IMPRIMIMOS UNA CONFIRMACION*/
         JOptionPane.showMessageDialog(null, "Eliminado con exito!");
      }
      else {
         JOptionPane.showMessageDialog(null, "No encontrado!");
      }
   }
   /*LA MISMA FUNCION Y PROCEDIMIENTOS DE ELIMINAR, PERO EVALUAMOS CON EL OBJETO
   ENTERO EN VEZ DE EL DATO EN ESPECIFICO*/   
   private Arbin elimina(Arbin<Jugador> r, Jugador x) {
      if (x.getCodigo() == r.obtener().getCodigo()) {
         return borrar(r, x);
      }
      else {
         if (x.getCodigo() < r.obtener().getCodigo()) {
            r.enlIzq(elimina(r.izq(), x));
         }
         else {
            r.enlDer(elimina(r.der(), x));
         }
         return r;
      }
   }
   public Arbin mayor(Arbin<Jugador> raiz) {
      if(raiz.der() != null) {
         return mayor(raiz.der());
      }
      else {
         return raiz;
      }
   }
   private Arbin borrar(Arbin<Jugador> raiz, Jugador x) {
      if(raiz.izq() == null && raiz.der() == null) {
         return null;
      }
      else {
         if(raiz.izq() == null) {
            return raiz.der();
         }
         else {
            if(raiz.der() == null) {
               return raiz.izq();
            }
            else {
               Arbin remp = mayor(raiz.izq());
               raiz.modificar((Jugador) remp.obtener());
               raiz.enlIzq(elimina(raiz.izq(), (Jugador) remp.obtener()));
               return raiz;
            }
         }
      }
   }
   public void goleador(Arbin<Jugador> r) {
      if (r != null) {
         if (r.obtener().getGoles() > mayor) {
            /*COMO NOS INTERESA LOS DATOS, GUARDAMOS EN UN JUGADOR VACIO*/
            mayor = r.obtener().getGoles();
            temporal = r.obtener();
         }
         goleador(r.izq());
         goleador(r.der());
      }      
   }
   public ArrayList<Jugador> masX_salario(float salario) {
      if (raiz != null) {
         /*INICIALIZAMOS LA COLECCION Y LUEGO DEL PROCESO LA RETORNAMOS*/
         asalariados = new ArrayList<>();
         masX_salario(raiz, salario);
         return asalariados;
      }
      return null;
   }
   private void masX_salario(Arbin<Jugador> r, float salario) {
      if (r != null) {
         if (r.obtener().getSalario() > salario && !(asalariados.contains(r.obtener()))) {
            /*SI EL SALARIO ES MAYOR Y NO ESTÁ REPETIDO EN LA COLECCION LO AÑADIMOS*/
            asalariados.add(r.obtener());
         }
         masX_salario(r.izq(), salario);
         masX_salario(r.der(), salario);
      }
   }
   public String listar() {
      /*INICIALIZAMOS PARA RENOVAR Y EVITAR CARGAR CON DATOS ANTERIORES*/
      jugadores = "";
      jugadores = listar(raiz);
      return jugadores;
   }
   private String listar(Arbin<Jugador> r) {
      /*SI R ESTA EN NULL NO RETORNO NADA*/
      if (r == null) {
         return "";
      }
      else {
         /*RETORNO EL JUGADOR CON SU PARTE POR LA IZQ Y LA DER(SI LA TIENE)*/
         return r.obtener().toString() + listar(r.izq()) + listar(r.der());
      }
   }   
}