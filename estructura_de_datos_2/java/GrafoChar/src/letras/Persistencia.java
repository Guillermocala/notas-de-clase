///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package letras;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
////import java.util.ArrayList;
//
///**
// *
// * @author ESTUDIANTE
// */
//public class Persistencia {
//   public void guardar(GrafoLetras x) throws FileNotFoundException, IOException {
//      ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"));
//      ob.writeObject(x);
//      ob.close();
//   }
//   public GrafoLetras recuperar(GrafoLetras nom) throws FileNotFoundException, IOException, ClassNotFoundException{
//      ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom));
//      GrafoLetras ar = (GrafoLetras) ob.readObject();
//      ob.close();
//      return ar;
//   }
////   public void guardar(ArrayList<String> x) throws FileNotFoundException, IOException {
////      ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("archivo.ch"));
////      ob.writeObject(x);
////      ob.close();
////   }
////   public ArrayList<String> recuperar(ArrayList<String> nom) throws FileNotFoundException, IOException, ClassNotFoundException{
////      ObjectInputStream ob = new ObjectInputStream(new FileInputStream(nom));
////      ArrayList<String> ar = (ArrayList<String>) ob.readObject();
////      ob.close();
////      return ar;
////   }
//}
