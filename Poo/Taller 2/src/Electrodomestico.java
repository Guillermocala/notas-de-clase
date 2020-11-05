
abstract public class Electrodomestico {
      protected String color;
      protected float precio;
      protected char consumo;
      protected int peso;
      protected int valorLetra;
      
      public Electrodomestico(String color, float precio, char consumo, int peso){
         this.color = color;
         this.precio = precio;
         this.consumo = consumo;
         this.peso = peso;
         checkConsume();
         checkColor();
      }
      public Electrodomestico(){
         this.color = "blanco";
         this.precio = 1000;
         this.consumo = 'f';
         this.peso = 5;
         checkConsume();
         checkColor();
      }
      public Electrodomestico(int precio, int peso){
         this.color = "blanco";
         this.precio = precio;
         this.consumo = 'f';
         this.peso = peso;
         checkConsume();
         checkColor();
      }

      public String toString(){
         return "Color: " + this.color + " ,Precio: " + this.precio +
         " ,Consumo: " + this.consumo + " ,Peso: " + this.peso;
      }
      public String getColor(){
         return this.color;
      }
      public float getPrecio(){
         return this.precio;
      }
      public char getConsumo(){
         return this.consumo;
      }
      public int getPeso(){
         return this.peso;
      }
      /*esta funcion es para rescatar el dato del porcentaje en la clase, ya que al 
      crear el array de electrodomestico esta funcion rescata el porcentaje segun el 
      tipo de electrodomestico*/
      abstract float getConsumoEner();
      
      public void checkConsume(){
         char temp = Character.toUpperCase(this.consumo);
         this.consumo = temp;
         switch(temp) {
            case 'A':
               this.valorLetra = 500;
               break;
            case 'B':
               this.valorLetra = 1000;
               break;
            case 'C':
               this.valorLetra = 1500;
               break;
            case 'D':
               this.valorLetra = 2000;
               break;
            case 'E':
               this.valorLetra = 2500;
               break;
            case 'F':
               this.valorLetra = 3000;
               break;
            default:
               this.valorLetra = 3000;
               this.consumo = 'F';
               break;
         }
      }
      /*
      public void checkConsume(){
         char temp = Character.toUpperCase(this.consumo);
         if (!(temp == 'A' || temp == 'B' || temp == 'C' || temp == 'D' || temp == 'E' || temp == 'F')) {
            this.consumo = 'F';
         }
         else {
            this.consumo = temp;
         }
      }
      */
      public void checkColor(){
         String temp = this.color.toUpperCase();
         if (temp.contentEquals("BLANCO") || temp.contentEquals("NEGRO") || temp.contentEquals("ROJO") || temp.contentEquals("AZUL") || temp.contentEquals("GRIS")) {
            this.color = temp;
         }
         else{
            this.color = "BLANCO";
         }
      }
      //PRECIOFINAL = (consumo * peso) + 15%
      public void precioFinal(float tipo){
         float result = valorLetra * this.peso; //multiplicacion de consumo por peso
         float porcen = result * (float) 0.15; //sacamos el 15% a ese valor
         this.precio += result + porcen; //sumamos todo a lo que teniamos en precio inicial
         result = this.precio * tipo; // dependienteo el tipo de electrodomestico sacamos su porcentaje
         this.precio += result; // sumamos dicho porcentaje al valor de precio que teniamos
      }
      
}


