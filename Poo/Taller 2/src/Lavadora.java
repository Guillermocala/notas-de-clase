public class Lavadora extends Electrodomestico {
   
   private float consumoEner = (float) 0.25;
   
   public Lavadora(){
      super();
   }
   public Lavadora(String color, int precio, char consumo, int peso){
      super(color, precio, consumo, peso);
   }
   public Lavadora(int precio, int peso){
      super(precio, peso);
   }

   @Override
   public float getConsumoEner() {
      return this.consumoEner;
   }
}
