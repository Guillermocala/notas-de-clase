/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Principal.GrafoMatr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57300
 */
public class EstacionBomb implements Serializable{
   private GrafoMatr<Barrio> ciudad;
   private LinkedList<Maquina> maquinas;

   
   /**PARA MANTENER TODO ORGANIZADO SACO 3 LISTAS DE MAQUINAS*/
   
   /*libres y ocupadas son colas*/
   private LinkedList<Maquina> libres;
   private LinkedList<Maquina> ocupadas;
   
   /*lista de inhabilitadas*/
   private LinkedList<Maquina> inhabilitadas;
   
   public EstacionBomb() {
      this.ciudad = new GrafoMatr<>();
      this.maquinas = new LinkedList<>();
      this.libres = new LinkedList<>();
      this.ocupadas = new LinkedList<>();
      this.inhabilitadas = new LinkedList<>();
   }
   
   /**
    * @return the ciudad
    */
   public GrafoMatr<Barrio> getCiudad() {
      return ciudad;
   }

   /**
    * @return the maquinas
    */
   public LinkedList<Maquina> getMaquinas() {
      return maquinas;
   }
   
   public void delMaquinas() {
      maquinas.clear();
   }
   
   public void generarMaquinas(int num) {
      /**HAGO UNA LISTA PARA QUE NO SE ME REPITAN LOS NUMEROS GENERADOS CON MATH.RANDOM*/
      LinkedList<Integer> existe = new LinkedList<>();
      Maquina temp;
      for (int i = 0; i < num; i++) {
         /**PREGUNTO SI ESTA REPETIDO PARA GENERAR OTRO, ANTES ME SALIAN NUMEROS 
          * REPETIDOS, CREO LA MAQUINA CON ESE NUMERO Y DE UNA VEZ LA METO EN LA LISTA
          * QUE HAY EN LA ESTACION, Y METO LA MAQUINA EN LA LISTA DE LIBRES*/
         int dato = (int) (Math.random() * 5000 + 1000);
         while (existe.contains(dato)) {            
            dato = (int) (Math.random() * 5000 + 1000);
         }
         existe.add(dato);
         temp = new Maquina(dato);
         /*añado el barrio 0, osea el inicial o la estacion a los barrios visitados*/
         temp.addBarrios(0);
         /*meto la maquina en la lista de la estacion*/
         maquinas.add(temp);
         /*metemos en la cola de disponibles*/
         libres.addLast(temp);
      }
   }
   
   public void moverMaquina(int barrio) {
      /*llamo a floyd para operar costos y caminos minimos*/
      Floyd camino = new Floyd(ciudad);
      camino.CaminoMinimo();
      int menor = 99999;
      Maquina cercana = null;
      /*pregunto en la cola de maquinas libres*/
      for (Maquina libre : libres) {
         int temp = camino.CostoMinimo(libre.getBarrios().getLast(), barrio);
         if (temp < menor) {
            menor = temp;
            cercana = libre;
         }
      }
      /*SI NO HAY LIBRES MUESTRA LA ALERTA*/
      if (cercana == null) {
         JOptionPane.showMessageDialog(null, "Maquinas no disponibles");
      }
      else {
         /*SI SE DEVUELVE A LA ESTACION SETEAMOS EL ATRIBUTO*/
         if (barrio == 0) {
            cercana.setStation(true);
         }
         else {
            cercana.setStation(false);
         }
         /*AUMENTAMOS EL CONTADOR DE ACCIDENTES DE LA CIUDAD Y LUEGO SETEAMOS LOS ATRIBUTOS*/
         ciudad.obtVertice(barrio).addCantAccidentes();
         cercana.setOcuped(true);
         /*LE AÑADIMOS A LA MAQUINA EL BARRIO AL CUAL FUE PARA MANEJAR EL REGISTRO*/
         cercana.addBarrios(barrio);
         /*OPERACIONES CON LAS COLAS*/
         ocupadas.addLast(cercana);
         libres.remove(cercana);
         actualizaColas();
      }
   }
   
   public void actualizaColas() {
      /*cuando 2 maquinas estan ocupadas, libero 1*/
      if (!(ocupadas.isEmpty()) && ocupadas.size() >= 2) {
         Maquina aux = ocupadas.getFirst();
         aux.setOcuped(false);
         libres.addLast(aux);         
         ocupadas.removeFirst();
      }
   }
   
   public void aislar(int barrio) {
      /*BORRAMOS LOS SUCESORES Y ANTECESORES*/
      for (int i = 0; i < ciudad.orden(); i++) {
         if (i != barrio) {
            ciudad.elimArista(barrio, i);
            ciudad.elimArista(i, barrio);
         }
      }
      for (Maquina object : maquinas) {
         /*LOCALIZAMOS EL OBJETO Y SETEAMOS SUS ATRIBUTOS CORRESPONDIENTES LUEGO 
         QUITAMOS LA MAQUINA DE OCUPADAS Y METEMOS EN INHABILITADAS Y NOS SALIMOS
         CON UN BREAK PORQUE NO NECESITAMOS SEGUIR RECORRIENDO*/
         if (object.getBarrios().getLast() == barrio) {
            object.setHabilitado(false);
            object.setOcuped(false);
            ocupadas.remove(object);
            inhabilitadas.add(object);
            break;
         }
      }
   }
   public void inhabilitar(int maquina) {
      Maquina aux = null;
      for (Maquina maq : maquinas) {
         if (maq.getCodigo() == maquina) {
            /*SI LA MAQUINA ESTA HABILITADA PROCEDEMOS, SINO SALIMOS SIN HACER  NADA
            PORQUE NO PODEMOS INHABILITAR UNA MAQUINA YA INHABILITADA*/
            if (maq.isHabilitado()) {
               aux = maq;
            }
            break;
         }
      }
      /*SI ESTA INHABILITADA O NO SE ENCUENTRA SE MUESTRA LA ALERTA*/
      if (aux == null) {
         JOptionPane.showMessageDialog(null, "No encontrada o ya está deshabilitada, verifique datos en mostrar maquinas");
      }
      else {
         /*SACAMOS DE OCUPADAS Y DE LIBRES, PARA AÑADIR A INHABILITADAS Y SETEAMOS LOS ATRIBUTOS
         CORRESPONDIENTES A LA MAQUINA*/
         ocupadas.remove(aux);
         libres.remove(aux);
         inhabilitadas.add(aux);
         aux.setOcuped(false);
         aux.setHabilitado(false);
      }
   }
   public void barrioMasAccidentes() {
      int mayor = 0;
      Barrio temp = null;
      for (int i = 0; i < ciudad.orden(); i++) {
         int aux = ciudad.obtVertice(i).getCantAccidentes();
         if (aux > mayor) {
            mayor = aux;
            temp = ciudad.obtVertice(i);
         }
      }
      if (temp == null) {
         JOptionPane.showMessageDialog(null, "Barrios sin accidentes");
      }
      else {
         JOptionPane.showMessageDialog(null, "El barrio con mas accidentes es: " + temp.toString());
      }
   }
   public String consultaMaq(int codigo) {
      /*SI LA ENCUENTRA RETORNAMOS EL TOSTRING, SINO RETORNAMOS UN MENSAJE DE NO ENCONTRADO*/
      for (Maquina maquina : maquinas) {
         if (maquina.getCodigo() == codigo) {
            return maquina.toString();
         }
      }
      return "No encontrada";
   }
   public void trabajoMaquinas() {
      /*SACAMOS LA CANTIDAD DE ACCIDENTES TOTALES*/
      int accidentes = 0;
      for (int i = 0; i < ciudad.orden(); i++) {
         accidentes += ciudad.obtVertice(i).getCantAccidentes();         
      }
      if (accidentes == 0) {
         JOptionPane.showMessageDialog(null, "No hay accidentes registrados!!!");
      }
      else {
         for (Maquina maquina : maquinas) {
            /*COMO EL PRIMER VALOR DE LOS BARRIOS ES LA ESTACION (PUNTO DE PARTIDA)
            HAY QUE QUITARLO DE LA CUENTA CON SIZE() - 1*/
            float aux = maquina.getBarrios().size() - 1;           
            float temp = (aux / accidentes) * 100;
            /*IMPRIMIMOS INDIVIDUALMENTE CON JOPTION*/
            String res = "La maquina " + maquina.getCodigo() + " tiene %" + temp + " de trabajo";
            JOptionPane.showMessageDialog(null, res);
         }
      }
   }
   public int getPosition(Barrio x) {
      /*USAMOS ESTO PARA LOS RECORRIDOS, COMO SIEMPRE USAMOS UN PARAMETRO VALIDO
      NO LLEGA A RETORNAR -1 (HASTA EL MOMENTO)*/
      for (int i = 0; i < ciudad.orden(); i++) {
         if (ciudad.obtVertice(i) == x) {
            return i;
         }
      }
      return -1;
   }
   private ArrayList<Barrio> visitado;
   private ArrayList<Integer> recorrido;
   /*VISITADO ES PARA LOS RECORRIDOS, Y RECORRIDO ES PARA GUARDAR LOS INDICES Y LUEGO
   IMPRIMIR DICHO RECORRIDO Y NO IMPRIMIRLO INMEDIATAMENTE*/
   public void dfs(int vi) {
      recorrido.add(vi);
      visitado.add(ciudad.obtVertice(vi));
      ArrayList<Barrio> suc = ciudad.sucesores(vi);
      for (Barrio barrio : suc) {
         if (!(visitado.contains(barrio))) {
            dfs(getPosition(barrio));
         }
      }
   }
   public void bfs(int vi) {
      LinkedList<Barrio> cola = new LinkedList<>();
      cola.addLast(ciudad.obtVertice(vi));
      visitado.add(ciudad.obtVertice(vi));
      while (!(cola.isEmpty())) {         
         Barrio aux = cola.removeFirst();
         recorrido.add(getPosition(aux));
         ArrayList<Barrio> suc = ciudad.sucesores(getPosition(aux));
         for (Barrio x : suc) {
            if (!(visitado.contains(x))) {
               cola.addLast(x);
               visitado.add(x);
            }
         }
      }
   }
   public String recorridos(int opt) {
      /*INICIALIZAMOS AQUI LAS 2 COLECCIONES PARA NO ACUMULAR DATOS BASURA*/
      int barrio;
      visitado = new ArrayList<>();
      recorrido = new ArrayList<>();
      String res = "";
      switch(opt) {
         case 1:
            /*dfs --- RECORRIDO POR PROFUNDIDAD*/
            barrio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + getCiudad().orden() + "): "));
            while (barrio < 0 || barrio >= getCiudad().orden()) {
               barrio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + getCiudad().orden() + "): "));
            }
            dfs(barrio);
            if (recorrido.isEmpty()) {
               JOptionPane.showMessageDialog(null, "No hay recorrido disponible, verifique datos!");
            }
            else {
               /*RECORRO LO QUE ME GUARDA LOS DATOS PARA PODER IMPRIMIRLOS SIN PROBLEMA*/
               for (int x : recorrido) {
                  res += ciudad.obtVertice(x).getNombre() + " - ";
               }
            }
            return res;
         case 2:
            /*bfs --- RECORRIDO POR ANCHURA*/
            barrio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + getCiudad().orden() + "): "));
            while (barrio < 0 || barrio >= getCiudad().orden()) {
               barrio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el indice del barrio(>= 0 y < " + getCiudad().orden() + "): "));
            }
            bfs(barrio);
            if (recorrido.isEmpty()) {
               JOptionPane.showMessageDialog(null, "No hay recorrido disponible, verifique datos!");
            }
            else {
               for (int x : recorrido) {
                  res += ciudad.obtVertice(x).getNombre() + " - ";
               }
            }
            return res;
         default:
            return "Opcion erronea";
      }
   }
}
