/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

import Guis.GuiSimplex;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 57300
 */
public class GetX {
   private static int filaX;
    
    public static void mostar(final DefaultTableModel modeloSolucion, final int Xn) {
        final int fil = modeloSolucion.getRowCount();
        final int col = modeloSolucion.getColumnCount();
        GuiSimplex.jtaOperaciones.setText("   === Soluci\u00f3n ===\n\n");
        for (int n = 1; n <= Xn; ++n) {
            final String xn = "X" + n;
            if (estaXn(modeloSolucion, xn, fil, col)) {
                GuiSimplex.jtaOperaciones.append(">> " + xn + " = " + AproximarNumero.valorAprocimado(String.valueOf(modeloSolucion.getValueAt(GetX.filaX, col - 2))) + "\n");
            }
            else {
                GuiSimplex.jtaOperaciones.append(">> " + xn + " = 0" + "\n");
            }
        }
        GuiSimplex.jtaOperaciones.append("\n>> Z = " + String.valueOf(modeloSolucion.getValueAt(fil - 2, col - 2)));
    }
    
    private static boolean estaXn(final DefaultTableModel modeloSolucion, final String xn, final int fil, final int col) {
        for (int f = 2; f < fil - 2; ++f) {
            final String x = String.valueOf(modeloSolucion.getValueAt(f, col - 3));
            if (x.equalsIgnoreCase(xn)) {
                GetX.filaX = f;
                return true;
            }
        }
        return false;
    }
}
