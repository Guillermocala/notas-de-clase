/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrearTablas;

import Guis.GuiAsignacion;
import Asignacion.DatosAsignacion;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
/**
 *
 * @author 57300
 */
public class crearTablaAsignacio {
   public void crearTablaRestricciones(final int tareas, final int operador, final JTable jtRestricciones, final int des) {
        final Object[] cabeza = new String[tareas + 1 + des];
        cabeza[0] = " ";
        for (int i = 1; i <= tareas + des; ++i) {
            cabeza[i] = "Tarea " + i;
        }
        final DefaultTableModel modeloRestricciones = new DefaultTableModel(cabeza, operador) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return column != 0;
            }
        };
        jtRestricciones.setModel(modeloRestricciones);
        for (int j = 0; j < operador; ++j) {
            modeloRestricciones.setValueAt("Operador " + (j + 1), j, 0);
        }
    }
    
    public void CrearTablaSolucion(final JTable jtRestriciones, final JTable jtSolucion) {
        final int row = jtRestriciones.getRowCount();
        final int column = jtRestriciones.getColumnCount();
        final Object[] cabeza = new String[column + 1];
        for (int i = 0; i < column + 1; ++i) {
            cabeza[i] = "<>";
        }
        final DefaultTableModel modelosSolucion = new DefaultTableModel(cabeza, row + 2) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        jtSolucion.setModel(modelosSolucion);
        for (int fila = 1; fila < row + 1; ++fila) {
            modelosSolucion.setValueAt("Operador " + fila, fila, 0);
        }
        for (int col = 1; col < column; ++col) {
            modelosSolucion.setValueAt("Tarea " + col, 0, col);
        }
        for (int j = 1; j < modelosSolucion.getColumnCount() - 1; ++j) {
            jtSolucion.getColumnModel().getColumn(j).setPreferredWidth(45);
        }
        modelosSolucion.setValueAt("Menor \u2193", 0, column);
        modelosSolucion.setValueAt("Menor \u2192", row + 1, 0);
        this.extraerdatos(jtRestriciones, jtSolucion);
    }
    
    public void extraerdatos(final JTable jtRestriciones, final JTable jtSolucion) {
        final int row = jtRestriciones.getRowCount();
        final int column = jtRestriciones.getColumnCount();
        GuiAsignacion.datosAsignacio = new DatosAsignacion[row][column - 1];
        for (int fil = 0; fil < row; ++fil) {
            for (int col = 1; col < column; ++col) {
                final String tem = "" + jtRestriciones.getValueAt(fil, col);
                jtSolucion.setValueAt(tem, fil + 1, col);
                GuiAsignacion.datosAsignacio[fil][col - 1] = new DatosAsignacion(tem);
            }
        }
    }
}
