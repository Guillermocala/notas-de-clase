/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrearTablas;

//import Transprte.Datos;
import javax.swing.table.TableModel;
import Guis.GuiTransporte;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
/**
 *
 * @author 57300
 */
public class CrearTablaTransporte {
   public void crearTablaRestricciones(final int destino, final int origen, final JTable jtRestricciones, final int des) {
        final Object[] cabeza = new String[destino + 2 + des];
        cabeza[0] = " ";
        cabeza[destino + 1 + des] = "Oferta";
        for (int i = 1; i <= destino + des; ++i) {
            cabeza[i] = "Drestino " + i;
        }
        jtRestricciones.setModel(GuiTransporte.modeloRestricciones = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return column != 0 && (row != jtRestricciones.getRowCount() - 1 || column != jtRestricciones.getColumnCount() - 1);
            }
        });
        final String[] fila = new String[destino + 2 + des];
        for (int j = 0; j < origen; ++j) {
            fila[0] = new String("Origen " + (j + 1));
            GuiTransporte.modeloRestricciones.addRow(fila);
        }
        fila[0] = new String("Demanda");
        GuiTransporte.modeloRestricciones.addRow(fila);
    }
    
    public void CrearTablaSolucion(final JTable jtRestriciones, final JTable jtSolucion, final int extraRow, final int extaColumn) {
        final int row = jtRestriciones.getRowCount();
        final int column = jtRestriciones.getColumnCount();
        this.extraerDatos(jtRestriciones);
        final Object[] cabeza = new String[column + extaColumn];
        for (int i = 0; i < column + extaColumn; ++i) {
            cabeza[i] = "<>";
        }
        final DefaultTableModel modelosSolucion = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        jtSolucion.setModel(modelosSolucion);
        for (int fila = 0; fila < row + 1 + extraRow; ++fila) {
            final String[] origen = new String[column + extaColumn];
            if (fila > 0 && fila < row) {
                origen[0] = "" + fila;
            }
            modelosSolucion.addRow(origen);
        }
        for (int j = 0; j < modelosSolucion.getColumnCount(); ++j) {
            jtSolucion.getColumnModel().getColumn(j).setPreferredWidth(70);
        }
        for (int fil = 0; fil < row - 1; ++fil) {
            final String tem = "" + GuiTransporte.modeloRestricciones.getValueAt(fil, column - 1);
            modelosSolucion.setValueAt(tem, fil + 1, column - 1);
        }
        for (int col = 1; col < column - 1; ++col) {
            final String tem = "" + GuiTransporte.modeloRestricciones.getValueAt(row - 1, col);
            modelosSolucion.setValueAt(tem, modelosSolucion.getRowCount() - 1 - extaColumn, col);
            modelosSolucion.setValueAt(col, 0, col);
        }
        modelosSolucion.setValueAt("Demanda", row, 0);
        modelosSolucion.setValueAt("Oferta \u2193", 0, column - 1);
        if (extaColumn > 0) {
            modelosSolucion.setValueAt("Penaliza.", 0, column);
        }
        if (extraRow > 0) {
            modelosSolucion.setValueAt("Penaliza.", row + 1, 0);
        }
    }
    
    private void extraerDatos(final JTable jtRestriciones) {
        final int row = jtRestriciones.getRowCount();
        final int column = jtRestriciones.getColumnCount();
        GuiTransporte.datos = new Datos[row - 1][column - 2];
        for (int i = 0; i < row - 1; ++i) {
            for (int j = 0; j < column - 2; ++j) {
                GuiTransporte.datos[i][j] = new Datos(0.0, "" + jtRestriciones.getValueAt(i, j + 1), false);
            }
        }
    }
}
