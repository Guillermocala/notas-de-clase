/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

import Guis.GuiAsignacion;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author 57300
 */
public class ColorFilasAsignacionSolucion extends DefaultTableCellRenderer{
   private JLabel componete;
    int i;
    
    public ColorFilasAsignacionSolucion() {
        this.i = 0;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        this.componete = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0) {
            this.componete.setBackground(new Color(255, 86, 86));
        }
        else if (row != 0 && column != 0) {
            this.componete.setBackground(Color.white);
        }
        if (row == 0) {
            this.componete.setBackground(new Color(102, 204, 255));
        }
        if (row > 0 && row < table.getRowCount() - 1 && column > 0 && column < table.getColumnCount() - 1) {
            if (GuiAsignacion.datosAsignacio[row - 1][column - 1].isRayado()) {
                this.componete.setBackground(new Color(253, 253, 178));
            }
            if (GuiAsignacion.datosAsignacio[row - 1][column - 1].isDobleRayado()) {
                this.componete.setBackground(Color.YELLOW);
            }
        }
        if (row > 0 && row < table.getRowCount() - 1 && column > 0 && column < table.getColumnCount() - 1 && GuiAsignacion.datosAsignacio[row - 1][column - 1].isColorea()) {
            this.componete.setBackground(new Color(255, 204, 204));
        }
        if (isSelected) {
            this.componete.setBackground(new Color(223, 211, 231));
        }
        return this.componete;
    }
}
