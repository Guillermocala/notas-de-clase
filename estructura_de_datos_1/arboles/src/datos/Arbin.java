/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
/**
 *
 * @author enanv
 */
public interface Arbin
{
   int obtener();
   void modificar(int x);
   Arbin izq();
   Arbin der();
   void enlIzq(Arbin x);
   void enlDer(Arbin x);    
}
