/**
 * @(#)Taller2.java
 *
 * Taller2 application
 *
 * @author 
 * @version 1.00 2020/10/7
 */
 
public class Taller2 {
    
	public static void main(String[] args) {      
      String televisores = "Televisores:\n";
      String neveras = "Neveras:\n";
      String lavadoras = "Lavadoras:\n";
      float sumTele = 0, sumNeve = 0, sumlava = 0, sumTotal = 0;
      Electrodomestico[] arreglo = new Electrodomestico[10];
      
      Television tele1 = new Television("gris", 10000, 'a', 3);
      Nevera nevera1 = new Nevera("negro", 70000, 'b', 1);
      Lavadora lava1 = new Lavadora(1000, 5);
      Television tele2 = new Television("blue", 6400, 'c', 1);
      Nevera nevera2 = new Nevera("rojo", 5000, 'x', 6);
      Lavadora lava2 = new Lavadora();
      Television tele3 = new Television("blanco", 1000, 'a', 1);
      Nevera nevera3 = new Nevera("negro", 1000, 'a', 1);
      Lavadora lava3 = new Lavadora("rojo", 5000, 'f', 4);
      Lavadora lava4 = new Lavadora(6000, 3);
      
      arreglo[0] = tele1;
      arreglo[1] = nevera1;
      arreglo[2] = lava1;
      arreglo[3] = tele2;
      arreglo[4] = nevera2;
      arreglo[5] = lava2;
      arreglo[6] = tele3;
      arreglo[7] = nevera3;
      arreglo[8] = lava3;
      arreglo[9] = lava4;

      for (int i = 0; i < arreglo.length; i++) {         
         Electrodomestico temp = arreglo[i];
         temp.precioFinal(temp.getConsumoEner());
         sumTotal += temp.getPrecio();         
         switch(temp.getClass().getSimpleName()){
            case "Television":
               televisores += temp.toString() + "\n";
               sumTele += temp.getPrecio();
               break;
            case "Lavadora":
               lavadoras += temp.toString() + "\n";
               sumlava += temp.getPrecio();
               break;
            case "Nevera":
               neveras += temp.toString() + "\n";
               sumNeve += temp.getPrecio();
               break;
            default:
               System.out.println("error de identificacion de clase");
               break;
         }
      }
      System.out.println(televisores + "El precio de todos es: " + sumTele + "\n" +lavadoras + "El precio de todos es: " + sumlava + 
              "\n" + neveras + "El precio de todos es: " + sumNeve + "\n\n" + "El precio de todos los electrodomesticos es: " + sumTotal);
      
   }
}
