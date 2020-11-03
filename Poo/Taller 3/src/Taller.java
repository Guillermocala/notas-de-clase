/**
 * @(#)Taller.java
 *
 * Taller application
 *
 * @author 
 * @version 1.00 2020/11/3
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 
public class Taller {
	
    
   public static void main(String[] args) {
      Set<Vehiculo> lista = new HashSet<>();
      List<Vehiculo> ordenados = new LinkedList<>();
      
      Vehiculo op = new Vehiculo(0, "nose", "asd", 0);   //solo esta creado para usar las operaciones
      String menu = "1-Insertar \n2-Buscar por placa \n3-Eliminar por placa \n4-Generar vehiculos \n5-Mostrar"
              + "\n6-Eliminar vehiculos igual tipo y cc \n7-Organizar por tipo \n0-Salir \nIngrese la opcion: ";
      int sw = 1, opcion, id, cc, aux;
      String placa, tipo;
      Vehiculo temp;
      Scanner entrada = new Scanner(System.in);
      
      do {
         System.out.println(menu);
         opcion = entrada.nextInt();
         switch(opcion)
         {
            case 1:  //Inserta vehiculo
               System.out.println("Ingrese el ID: ");
               id = entrada.nextInt();
               entrada.nextLine();  //limpia el buffer por el salto de linea
               System.out.println("Ingrese la placa(3 letras y 3 numeros): ");
               placa = entrada.nextLine();
               System.out.println("Ingrese el tipo(CAMION, CAMIONETA, AUTOMOVIL): ");
               tipo = entrada.nextLine();
               System.out.println("Ingrese el cilindraje(1000 a 4500, siendo multiplo de 100): ");
               cc = entrada.nextInt();
               op.insertar(new Vehiculo(id, placa, tipo, cc), lista);
               break;
            case 2:  //Busca por placa
               if (lista.isEmpty()) {
                  System.out.println("No hay elementos para buscar");
               }
               else{
                  System.out.println("Ingrese la placa(3 letras y 3 numeros): ");
                  placa = entrada.nextLine();
                  temp = op.buscar(placa, lista);
                  if (temp != null) {
                     System.out.println(temp.toString());
                  }
                  else{
                     System.out.println("No encontrado");
                  }
               }
               break;
            case 3:  //Eliminar por placa
               if (lista.isEmpty()) {
                  System.out.println("No hay elementos para eliminar");
               }
               else{
                  System.out.println("Ingrese la placa(3 letras y 3 numeros): ");
                  placa = entrada.nextLine();
                  op.eliminar(placa, lista);
               }
               
               break;
            case 4:  //Generar vehiculos
               if (lista.isEmpty()) {
                  System.out.println("Ingrese la cantidad a generar: ");
                  aux = entrada.nextInt();
                  while (lista.size() < aux) {
                     temp = op.generaVehiculo(lista);
                     if (op.insertar(temp, lista)) {
                        temp = op.generaVehiculo(lista);
                     }
                  }
                  System.out.println(aux + " Vehiculos generados exitosamente!");
               }
               else{
                  System.out.println("Ya ha generado vehiculos, reinicie el programa");
               }
               break;
            case 5:  //Mostrar
               if (lista.isEmpty()) {
                  System.out.println("No hay elementos para mostrar");
               }
               else{
                  System.out.println("-----Hay " + lista.size() + ", Vehiculos");
                  for (Vehiculo vehiculo : lista) {
                     System.out.println(vehiculo);
                  }
               }
               break;
            case 6:  //Eliminar igual tipo y cc
               if (lista.isEmpty()) {
                  System.out.println("No hay elementos para operar");
               }
               else{
                  op.removeSameType(lista);
               }
               break;
            case 7:  //organizar por tipo
               if (lista.isEmpty()) {
                  System.out.println("No hay elementos para organizar");
               }
               else{
                  ordenados = op.sortByType(lista);
                  System.out.println("Los elementos ordenados son: ");
                  for (Object ordenado : ordenados) {
                     System.out.println(ordenado);
                  }
               }
               break;
            case 0:  //Salir
               sw = 0;             
               break;
            default:
               System.out.println("Dato incorrecto!");
               break;
         }         
      } while(sw != 0);
   }
}
