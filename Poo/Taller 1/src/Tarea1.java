/**
 * @(#)Tarea1.java
 *
 * Tarea1 application
 *
 * @author 
 * @version 1.00 2020/9/14
 */
 
public class Tarea1 {
    
    public static void main(String[] args) {   
    	   
    	System.out.println("\tCOMPUTADORES\n");
      Computador pc1 = new Computador();
      pc1.setMarca("Lenovo");
      pc1.setTipo("portatil");
      pc1.setMemRam(8);
      pc1.setMemRom(2000);
      pc1.setVelProcesador((float) 2.0);
      System.out.println("\nComputador 1\n" + pc1.toString());
      System.out.println("Evaluando pc: " + Computador.evaluar(pc1));
      System.out.println("Despues del upgrade de procesador...");
      Computador.upgrade(pc1, 1);   //mejoramos la velProcesador
      System.out.println(pc1.toString());
      
      Computador pc2 = new Computador();
      pc2.setMarca("HP");
      pc2.setTipo("mesa");
      pc2.setMemRam(16);
      pc2.setMemRom(2000);
      pc2.setVelProcesador((float) 2.5);
      System.out.println("\nComputador 2\n" + pc2.toString());
      System.out.println("Evaluando pc: " + Computador.evaluar(pc2));
      System.out.println("Despues del upgrade de ram...");
      Computador.upgrade(pc2, 2);   //mejoramos la velProcesador
      System.out.println(pc2.toString());
      
      Computador pc3 = new Computador();
      pc3.setMarca("Dell");
      pc3.setTipo("portatil");
      pc3.setMemRam(3);
      pc3.setMemRom(1000);
      pc3.setVelProcesador((float) 1.5);
      System.out.println("\nComputador 3\n" + pc3.toString());
      System.out.println("Evaluando pc: " + Computador.evaluar(pc3));
      System.out.println("Despues del upgrade de rom...");
      Computador.upgrade(pc3, 3);   //mejoramos la velProcesador
      System.out.println(pc3.toString());
      
      Computador pc4 = new Computador();
      pc4.setMarca("Sony");
      pc4.setTipo("mesa");
      pc4.setMemRam(6);
      pc4.setMemRom(1500);
      pc4.setVelProcesador((float) 2.0);
      System.out.println("\nComputador 4\n" + pc4.toString());
      System.out.println("Evaluando pc: " + Computador.evaluar(pc4));
      System.out.println("Despues del upgrade de procesador...");
      Computador.upgrade(pc4, 1);   //mejoramos la velProcesador
      System.out.println(pc4.toString());
      
      Computador pc5 = new Computador();
      pc5.setMarca("Toshiba");
      pc5.setTipo("portatil");
      pc5.setMemRam(2);
      pc5.setMemRom(500);
      pc5.setVelProcesador((float) 1.0);
      System.out.println("\nComputador 5\n" + pc5.toString());
      System.out.println("Evaluando pc: " + Computador.evaluar(pc5));
      System.out.println("Despues del upgrade de ram...");
      Computador.upgrade(pc5, 2);   //mejoramos la velProcesador
      System.out.println(pc5.toString());  
      	
      System.out.println("\t\nPERSONAS");	
      
      Persona per1 = new Persona();
      per1.setNombre("juan");
      per1.setApellido("caicedo");
      Persona.applyCamel(per1);     //aplico el metodo para convertir la primera letra en mayus
      per1.setEdad(22);
      per1.setGenero("Masculino");
      per1.setId(1034245987);
      per1.setCiudad("Barranquilla");      
      System.out.println("\nPersona 1\n" + per1.toString());
      System.out.println("fecha de nacimiento: " + Persona.edadActual(per1.getEdad()));
      
      Persona per2 = new Persona();
      per2.setNombre("ana");
      per2.setApellido("mercedes");
      Persona.applyCamel(per2);     //aplico el metodo para convertir la primera letra en mayus
      per2.setEdad(17);
      per2.setGenero("Femenino");
      per2.setId(1124424598);
      per2.setCiudad("Bogota");      
      System.out.println("\nPersona 2\n" + per2.toString());
      System.out.println("fecha de nacimiento: " + Persona.edadActual(per2.getEdad()));
      
      Persona per3 = new Persona();
      per3.setNombre("jose");
      per3.setApellido("torres");
      Persona.applyCamel(per3);     //aplico el metodo para convertir la primera letra en mayus
      per3.setEdad(40);
      per3.setGenero("Masculino");
      per3.setId(1234567892);
      per3.setCiudad("Valle");      
      System.out.println("\nPersona 3\n" + per3.toString());
      System.out.println("fecha de nacimiento: " + Persona.edadActual(per3.getEdad()));
      
      Persona per4 = new Persona();
      per4.setNombre("andres");
      per4.setApellido("becerra");
      Persona.applyCamel(per4);     //aplico el metodo para convertir la primera letra en mayus
      per4.setEdad(10);
      per4.setGenero("Masculino");
      per4.setId(1452345987);
      per4.setCiudad("Santa Marta");      
      System.out.println("\nPersona 4\n" + per4.toString());
      System.out.println("fecha de nacimiento: " + Persona.edadActual(per4.getEdad()));
      
      Persona per5 = new Persona();
      per5.setNombre("camila");
      per5.setApellido("campo");
      Persona.applyCamel(per5);     //aplico el metodo para convertir la primera letra en mayus
      per5.setEdad(5);
      per5.setGenero("Femenino");
      per5.setId(1345654657);
      per5.setCiudad("Cartagena");      
      System.out.println("\nPersona 5\n" + per5.toString());
      System.out.println("fecha de nacimiento: " + Persona.edadActual(per5.getEdad()));	
   }  
}
