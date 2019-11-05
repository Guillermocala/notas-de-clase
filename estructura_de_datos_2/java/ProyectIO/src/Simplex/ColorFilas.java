/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author 57300
 */
public class ColorFilas extends DefaultTableCellRenderer{
   private JLabel componete;
    int i;
    
    public ColorFilas() {
        this.i = 0;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        this.componete = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row >= 2 && row < table.getRowCount() - 2 && column > 0 && column < table.getColumnCount() - 3) {
            this.componete.setBackground(Color.WHITE);
        }
        else if (column >= table.getColumnCount() - 3 && column < table.getColumnCount() - 1 && row >= table.getRowCount() - 2 && row < table.getRowCount() - 1) {
            this.componete.setBackground(new Color(5, 230, 5));
        }
        else if (column == table.getColumnCount() - 1) {
            this.componete.setBackground(new Color(61, 175, 215));
        }
        else {
            this.componete.setBackground(new Color(238, 79, 111));
        }
        if (isSelected) {
            this.componete.setBackground(new Color(223, 211, 231));
        }
        return this.componete;
    }
}
