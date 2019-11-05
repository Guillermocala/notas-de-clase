/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
/**
 *
 * @author 57300
 */
public class Guardar implements Serializable{
   private String objetivo;
    private int filas;
    private int columnas;
    private DefaultTableModel modeloRestricciones;
    private String[][] CoeficientesyZ;
    
    public Guardar(final DefaultTableModel modeloRestricciones, final String objetivo) {
        this.filas = 0;
        this.columnas = 0;
        this.modeloRestricciones = null;
        this.CoeficientesyZ = null;
        this.filas = modeloRestricciones.getRowCount();
        this.columnas = modeloRestricciones.getColumnCount();
        this.CoeficientesyZ = new String[this.filas][this.columnas];
        this.objetivo = objetivo;
        this.CrearMatrizCoeficientesyZ(modeloRestricciones);
    }
    
    public void CrearMatrizCoeficientesyZ(final DefaultTableModel modeloRestricciones) {
        for (int f = 0; f < this.filas; ++f) {
            for (int C = 0; C < this.columnas; ++C) {
                this.CoeficientesyZ[f][C] = String.valueOf(modeloRestricciones.getValueAt(f, C));
            }
        }
    }
    
    public DefaultTableModel getModeloRestricciones() {
        return this.modeloRestricciones;
    }
    
    public String getObjetivo() {
        return this.objetivo;
    }
    
    public void armarTabla(final JTable tabla) {
        final Object[] cabeza = new String[this.columnas];
        cabeza[0] = " ";
        for (int i = 1; i <= this.columnas - 3; ++i) {
            cabeza[i] = "X" + i;
        }
        cabeza[this.columnas - 1] = " ";
        cabeza[this.columnas - 2] = " ";
        tabla.setModel(this.modeloRestricciones = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return column != 0 && (row != 0 || column < Guardar.this.modeloRestricciones.getColumnCount() - 2);
            }
        });
        final String[] fila = new String[this.columnas];
        for (int f = 0; f < this.filas; ++f) {
            for (int C = 0; C < this.columnas; ++C) {
                fila[C] = this.CoeficientesyZ[f][C];
            }
            this.modeloRestricciones.addRow(fila);
        }
        this.modeloRestricciones.setValueAt("", 0, this.columnas - 2);
        this.modeloRestricciones.setValueAt("", 0, this.columnas - 1);
    }
}
