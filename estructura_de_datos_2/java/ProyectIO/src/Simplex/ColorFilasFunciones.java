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
public class ColorFilasFunciones extends DefaultTableCellRenderer{
   private JLabel componete;
    int i;
    
    public ColorFilasFunciones() {
        this.i = 0;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        this.componete = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 0) {
            this.componete.setBackground(new Color(255, 86, 86));
        }
        if (row == 0) {
            this.componete.setBackground(new Color(102, 204, 255));
        }
        if (row != 0 && column != 0) {
            this.componete.setBackground(Color.white);
        }
        if (isSelected) {
            this.componete.setBackground(new Color(223, 211, 231));
        }
        return this.componete;
    }
}
