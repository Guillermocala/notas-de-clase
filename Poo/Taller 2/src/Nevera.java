public class Nevera extends Electrodomestico{
   private float consumoEner = (float) 0.2;
   
   public Nevera(){
      super();
   }
   public Nevera(String color, int precio, char consumo, int peso){
      super(color, precio, consumo, peso);
   }
   public Nevera(int precio, int peso){
      super(precio, peso);
   }

   @Override
   public float getConsumoEner() {
      return this.consumoEner;
   }
}
