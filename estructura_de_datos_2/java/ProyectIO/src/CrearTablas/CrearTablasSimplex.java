/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrearTablas;

import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 57300
 */
public class CrearTablasSimplex {
   public static void TablaSolucion(final int Xn, final int Nrestricciones, final DefaultTableModel modeloRestricciones, final JTable Tablon) {
        final int cantidad_A = cantidad_A(modeloRestricciones);
        final int cantidad_S = cantidad_S(modeloRestricciones);
        final int numeroColumnas = Xn + cantidad_A + cantidad_S;
        final DefaultTableModel modeloSolucion = crearModeloTabla(numeroColumnas);
        Tablon.setModel(modeloSolucion);
        final String[] filas = new String[numeroColumnas + 4];
        for (int i = 0; i < Nrestricciones + 4; ++i) {
            modeloSolucion.addRow(filas);
        }
        agregarLasX_S_A(Xn, cantidad_S, cantidad_A, modeloSolucion, modeloRestricciones);
        agregar_Base_Xb_Xn(modeloSolucion, modeloRestricciones);
        agregarIndices(Xn, modeloRestricciones, modeloSolucion);
        modeloSolucion.setValueAt("        Cj", 0, 0);
        modeloSolucion.setValueAt("Xb  / Xj", 1, 0);
        modeloSolucion.setValueAt("   Zj ", modeloSolucion.getRowCount() - 2, 0);
        modeloSolucion.setValueAt(" Cj - Zj", modeloSolucion.getRowCount() - 1, 0);
        modeloSolucion.setValueAt("Z = ", modeloSolucion.getRowCount() - 2, modeloSolucion.getColumnCount() - 3);
        ajustarTabla(Tablon, modeloSolucion);
    }
    
    public static void ajustarTabla(final JTable Tablon, final DefaultTableModel modeloSolucion) {
        Tablon.setRowHeight(25);
        Tablon.getColumnModel().getColumn(modeloSolucion.getColumnCount() - 3).setPreferredWidth(35);
        Tablon.getColumnModel().getColumn(modeloSolucion.getColumnCount() - 2).setPreferredWidth(70);
        Tablon.getColumnModel().getColumn(0).setPreferredWidth(50);
    }
    
    public static void agregarCj(final int Xn, final int numeroColumnas, final int cantidad_S, final int cantidad_A, final DefaultTableModel modeloRestricciones, final DefaultTableModel modeloSolucion) {
        for (int col = 1; col <= Xn; ++col) {
            modeloSolucion.setValueAt(modeloRestricciones.getValueAt(0, col), 0, col);
        }
        for (int col = Xn; col <= Xn + cantidad_S; ++col) {
            modeloSolucion.setValueAt("0", 0, col);
        }
        for (int col = Xn + cantidad_S; col <= Xn + cantidad_S + cantidad_A; ++col) {
            modeloSolucion.setValueAt("M", 0, col);
        }
    }
    
    public static void agregar_Base_Xb_Xn(final DefaultTableModel modeloSolucion, final DefaultTableModel modeloRestricciones) {
        int s = 1;
        int a = 1;
        final int row = modeloRestricciones.getRowCount();
        final int column = modeloRestricciones.getColumnCount();
        modeloSolucion.setValueAt("Base", 1, modeloSolucion.getColumnCount() - 3);
        modeloSolucion.setValueAt("Xn", 1, modeloSolucion.getColumnCount() - 2);
        for (int i = 1; i < row; ++i) {
            if (String.valueOf(modeloRestricciones.getValueAt(i, column - 2)).equalsIgnoreCase("=") || String.valueOf(modeloRestricciones.getValueAt(i, column - 2)).equalsIgnoreCase(">=")) {
                modeloSolucion.setValueAt("A" + a, i + 1, modeloSolucion.getColumnCount() - 3);
                modeloSolucion.setValueAt("M", i + 1, 0);
                ++a;
            }
            else {
                modeloSolucion.setValueAt("S" + s, i + 1, modeloSolucion.getColumnCount() - 3);
                modeloSolucion.setValueAt("0", i + 1, 0);
                ++s;
            }
            modeloSolucion.setValueAt("" + modeloRestricciones.getValueAt(i, column - 1), i + 1, modeloSolucion.getColumnCount() - 2);
        }
    }
    
    public static void agregarLasX_S_A(final int Xn, final int cantidad_S, final int cantidad_A, final DefaultTableModel modeloSolucion, final DefaultTableModel modeloRestricciones) {
        int s = 1;
        int A = 1;
        for (int col = 1; col <= Xn; ++col) {
            modeloSolucion.setValueAt("X" + col, 1, col);
            modeloSolucion.setValueAt(modeloRestricciones.getValueAt(0, col), 0, col);
        }
        for (int col = Xn + 1; col <= Xn + cantidad_S; ++col) {
            modeloSolucion.setValueAt("S" + s, 1, col);
            modeloSolucion.setValueAt("0", 0, col);
            ++s;
        }
        for (int col = Xn + cantidad_S + 1; col <= Xn + cantidad_S + cantidad_A; ++col) {
            modeloSolucion.setValueAt("A" + A, 1, col);
            modeloSolucion.setValueAt("M", 0, col);
            ++A;
        }
    }
    
    public static DefaultTableModel crearModeloTabla(final int numeroColumnas) {
        final String[] cabeza = new String[numeroColumnas + 4];
        for (int i = 0; i < numeroColumnas + 4; ++i) {
            cabeza[i] = "<>";
        }
        final DefaultTableModel modelo = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        return modelo;
    }
    
    private static int cantidad_A(final DefaultTableModel modeloRestricciones) {
        int cantidad_A = 0;
        final int row = modeloRestricciones.getRowCount();
        final int columna = modeloRestricciones.getColumnCount();
        for (int fil = 1; fil < row; ++fil) {
            final String tem = String.valueOf(modeloRestricciones.getValueAt(fil, columna - 2));
            if (tem.equals(">=") || tem.equals(">")) {
                ++cantidad_A;
            }
            else if (tem.equals("=")) {
                ++cantidad_A;
            }
        }
        return cantidad_A;
    }
    
    private static int cantidad_S(final DefaultTableModel modeloRestricciones) {
        int cantidad_S = 0;
        final int row = modeloRestricciones.getRowCount();
        final int columna = modeloRestricciones.getColumnCount();
        for (int fil = 1; fil < row; ++fil) {
            final String tem = String.valueOf(modeloRestricciones.getValueAt(fil, columna - 2));
            if (tem.equalsIgnoreCase(">=") || tem.equalsIgnoreCase(">") || tem.equalsIgnoreCase("<=") || tem.equalsIgnoreCase("<")) {
                ++cantidad_S;
            }
        }
        return cantidad_S;
    }
    
    public static void agregarIndices(final int Xn, final DefaultTableModel modeloRestricciones, final DefaultTableModel modeloSolucion) {
        int s = 1;
        int a = 1;
        final int row = modeloSolucion.getRowCount();
        final int columna = modeloSolucion.getColumnCount();
        for (int fil = 2; fil < row - 2; ++fil) {
            for (int col = 1; col < columna - 3; ++col) {
                modeloSolucion.setValueAt("0", fil, col);
            }
        }
        for (int fil2 = 1; fil2 < modeloRestricciones.getRowCount(); ++fil2) {
            final String tem = String.valueOf(modeloRestricciones.getValueAt(fil2, modeloRestricciones.getColumnCount() - 2));
            for (int col2 = 1; col2 < modeloRestricciones.getColumnCount() - 2; ++col2) {
                modeloSolucion.setValueAt(modeloRestricciones.getValueAt(fil2, col2), fil2 + 1, col2);
            }
            if (tem.equalsIgnoreCase("<=") || tem.equalsIgnoreCase("<")) {
                final int index = buscarIndice("S" + s, modeloSolucion);
                modeloSolucion.setValueAt("1", fil2 + 1, index);
                ++s;
            }
            else if (tem.equalsIgnoreCase(">=") || tem.equalsIgnoreCase(">")) {
                int index = buscarIndice("S" + s, modeloSolucion);
                modeloSolucion.setValueAt("-1", fil2 + 1, index);
                ++s;
                index = buscarIndice("A" + a, modeloSolucion);
                modeloSolucion.setValueAt("1", fil2 + 1, index);
                ++a;
            }
            else if (tem.equalsIgnoreCase("=")) {
                final int index = buscarIndice("A" + a, modeloSolucion);
                modeloSolucion.setValueAt("1", fil2 + 1, index);
                ++a;
            }
        }
    }
    
    private static int buscarIndice(final String va, final DefaultTableModel modeloSolucion) {
        for (int col = 1; col < modeloSolucion.getColumnCount() - 3; ++col) {
            final String tem = String.valueOf(modeloSolucion.getValueAt(1, col));
            if (tem.equalsIgnoreCase(va)) {
                return col;
            }
        }
        return -1;
    }
}
