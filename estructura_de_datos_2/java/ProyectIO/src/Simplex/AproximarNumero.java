/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

/**
 *
 * @author 57300
 */
public class AproximarNumero {
   static String tem;
    
    public static String valorAprocimado(final String cadena) {
        String f = "";
        for (int k = 0; k < cadena.length(); ++k) {
            final char c = cadena.charAt(k);
            if (c == '.') {
                f += '.';
                if (++k < cadena.length() && cadena.charAt(k) != 'E') {
                    f += cadena.charAt(k);
                    ++k;
                }
                if (k < cadena.length() && cadena.charAt(k) != 'E') {
                    f += cadena.charAt(k);
                    ++k;
                }
                if (k < cadena.length() && cadena.charAt(k) != 'E') {
                    f += cadena.charAt(k);
                    ++k;
                }
                f += contieneE(cadena);
                break;
            }
            f += cadena.charAt(k);
        }
        return f;
    }
    
    public static String contieneE(final String cadena) {
        for (int i = 0; i < cadena.length(); ++i) {
            final char c = cadena.charAt(i);
            if (c == 'e' || c == 'E') {
                return cadena.substring(i, cadena.length());
            }
        }
        return "";
    }
}
