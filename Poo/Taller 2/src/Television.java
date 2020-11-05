
public class Television extends Electrodomestico {
   private float consumoEner = (float) 0.35;
   
   public Television(){
      super();
   }
   public Television(String color, int precio, char consumo, int peso){
      super(color, precio, consumo, peso);
   }
   public Television(int precio, int peso){
      super(precio, peso);
   }

   @Override
   public float getConsumoEner() {
      return this.consumoEner;
   }
}
