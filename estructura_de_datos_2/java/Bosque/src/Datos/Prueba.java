/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author 57300
 */
public class Prueba {
   Arbin<Integer> raiz;
   Arbin<Arbin<Integer>> raizB;
   public void insertar(int x) {
      if (raiz != null) {
         insertar(raiz, x);
      }
      else {
         raiz = new ArbinImp(x);
      }
   }
   private void insertar(Arbin<Integer> r, int x) {
      if (x < r.obtener()) {
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
   
   public boolean busca(int dato) {
      if (raiz != null) {
         return busca(raiz, dato);
      }
      else {
         return false;
      }
   }
   private boolean busca(Arbin<Integer> r, int dato) {
      if (r.obtener() == dato) {
         return true;
      }
      else {
         if (dato < r.obtener()) {
            if (r.izq() != null) {
               return busca(r.izq(), dato);
            }
            else{ 
               return false;
            }
         }
         else {
            if (r.der() != null) {
               return busca(r.der(), dato);
            }
            else{ 
               return false;
            }
         }
      }
   }
   private Arbin elimina(Arbin<Integer> r, int x) {
      if (x == r.obtener()) {
         return borrar(r, x);
      }
      else {
         if (x < r.obtener()) {
            r.enlIzq(elimina(r.izq(), x));
         }
         else {
            r.enlDer(elimina(r.der(), x));
         }
         return r;
      }
   }
   public Arbin mayor(Arbin<Integer> raiz) {
      if(raiz.der() != null) {
         return mayor(raiz.der());
      }
      else {
         return raiz;
      }
   }
   private Arbin borrar(Arbin<Integer> raiz, int x) {
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
               raiz.modificar((Integer) remp.obtener());
               raiz.enlIzq(elimina(raiz.izq(), (Integer) remp.obtener()));
               return raiz;
            }
         }
      }
   }   
   public String listar(Arbin<Integer> r) {
      /*SI R ESTA EN NULL NO RETORNO NADA*/
      if (r == null) {
         return "";
      }
      else {
         /*RETORNO EL JUGADOR CON SU PARTE POR LA IZQ Y LA DER(SI LA TIENE)*/
         return r.obtener() + listar(r.izq()) + listar(r.der());
      }
   }
   public void insertaBosque(Arbin<Integer> x) {
      if (raizB != null) {
         insertaBosque(raizB, x);
      }
      else {
         raizB = new ArbinImp(x);
      }
   }
   private void insertaBosque(Arbin<Arbin<Integer>> r, Arbin<Integer> x) {
      if (x < r.obtener()) {
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
   
   public boolean buscaBosque(Arbin<Integer> codigo) {
      if (raizB != null) {
         return buscaBosque(raizB, codigo);
      }
      else {
         return false;
      }
   }
   private boolean buscaBosque(Arbin<Arbin<Integer>> raiz, Arbin<Integer> x) {
      if (r.obtener().getCodigo() == codigo) {
         return true;
      }
      else {
         if (codigo < r.obtener().getCodigo()) {
            if (r.izq() != null) {
               return buscaByCodigo(r.izq(), codigo);
            }
            else{ 
               return false;
            }
         }
         else {
            if (r.der() != null) {
               return buscaByCodigo(r.der(), codigo);
            }
            else{ 
               return false;
            }
         }
      }
   }
   private Arbin eliminaBosque(Arbin<Arbin<Integer>> raiz, Arbin<Integer> x) {
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
         return raiz;
      }
   }
   public Arbin mayorBosque(Arbin<Arbin<Integer>> raiz) {
      if(raiz.der() != null) {
         return mayorBosque(raiz.der());
      }
      else {
         return raiz;
      }
   }
   private Arbin borrarBosque(Arbin<Arbin<Integer>> raiz, Arbin<Integer> x) {
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
   
   
   public static void main(String[] args) {
      
   }
}

