/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Empleado;

import Datos.Articulo;
import Datos.Central;
import Datos.Persistencia;
import Ventanas.Principal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo
 */
public class Venta extends javax.swing.JFrame {
   private static Central datos;
   private Persistencia archivo = new Persistencia();
   /**
    * Creates new form Venta
    * @param data
    */
   public Venta(Central data) {
      initComponents();
      this.datos = data;
      actualizaTabla();
      this.setLocationRelativeTo(null);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jButtonAtras = new javax.swing.JButton();
      jButtonVender = new javax.swing.JButton();
      jButtonLimpia = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTableVenta = new javax.swing.JTable();
      jLabelCantidad = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jFormattedTextFieldCantidad = new javax.swing.JFormattedTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Venta de Articulos");
      setLocation(new java.awt.Point(0, 0));
      setResizable(false);

      jPanel1.setBackground(new java.awt.Color(255, 255, 255));
      jPanel1.setPreferredSize(new java.awt.Dimension(500, 320));

      jButtonAtras.setText("Atras");
      jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonAtrasActionPerformed(evt);
         }
      });

      jButtonVender.setBackground(new java.awt.Color(102, 255, 102));
      jButtonVender.setText("Vender");
      jButtonVender.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonVenderActionPerformed(evt);
         }
      });

      jButtonLimpia.setBackground(new java.awt.Color(255, 51, 51));
      jButtonLimpia.setText("Limpia");
      jButtonLimpia.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonLimpiaActionPerformed(evt);
         }
      });

      jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "N°", "Nombre", "Precio", "Cantidad"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane2.setViewportView(jTableVenta);
      if (jTableVenta.getColumnModel().getColumnCount() > 0) {
         jTableVenta.getColumnModel().getColumn(0).setResizable(false);
         jTableVenta.getColumnModel().getColumn(0).setPreferredWidth(7);
         jTableVenta.getColumnModel().getColumn(1).setResizable(false);
         jTableVenta.getColumnModel().getColumn(1).setPreferredWidth(250);
         jTableVenta.getColumnModel().getColumn(2).setResizable(false);
         jTableVenta.getColumnModel().getColumn(3).setResizable(false);
      }

      jLabelCantidad.setText("Cantidad:");

      jLabel1.setText("Nota: Seleccione la columna del articulo a comprar.");

      jFormattedTextFieldCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
      jFormattedTextFieldCantidad.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
            if (jFormattedTextFieldCantidad.getText().length() == 9 ){
               JOptionPane.showMessageDialog(null, "El limite para la cantidad es de 9 digitos");
               e.consume();
            }
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane2)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAtras)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(0, 29, Short.MAX_VALUE)))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jButtonLimpia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jButtonVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jButtonVender)
                     .addComponent(jLabelCantidad)
                     .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpia)
                        .addGap(21, 21, 21))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(jButtonAtras)
                  .addContainerGap())))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
      Principal princi = new Principal(datos);
      princi.setVisible(true);
      dispose();
   }//GEN-LAST:event_jButtonAtrasActionPerformed

   private void jButtonLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiaActionPerformed
      limpiaFormulario();
   }//GEN-LAST:event_jButtonLimpiaActionPerformed

   private void jButtonVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVenderActionPerformed
      int indice = jTableVenta.getSelectedRow();
      if (indice == -1) {
         JOptionPane.showMessageDialog(null, "Seleccione un articulo!");
      }
      else{
         Articulo mover = datos.getInventario().get(indice);
         int cantObj = mover.getCantidad();
         int cantIngresada = Integer.parseInt(jFormattedTextFieldCantidad.getText());
         if (cantIngresada == 0) {
            JOptionPane.showMessageDialog(null, "La cantidad es invalida!");
         }
         else{
            if (cantIngresada < 1 || cantIngresada > cantObj) {
               JOptionPane.showMessageDialog(null, "Verifique la cantidad ingresada!");
            }
            else{
               mover.setFechaSalida(datos.generaFecha());
               if (cantObj == cantIngresada) {
                  datos.getInventario().remove(mover);
                  datos.getVendidos().add(mover);
               }
               else{
                  int cantidad = cantObj - cantIngresada;
                  datos.getInventario().get(indice).setCantidad(cantidad);
                  //si no creo un artículo nuevo entonces al modificar la cantidad se modifica tanto para lista inventario como para vendidos
                  Articulo vendido = new Articulo(mover.getNombre(), mover.getValor(), mover.getFechaIngreso(), mover.getFechaSalida(), cantIngresada);
                  datos.getVendidos().add(vendido);
               }
               JOptionPane.showMessageDialog(null, "Articulo Vendido!");
               limpiaFormulario();
               actualizaTabla();
               try {
                  archivo.guardar(datos);
               } catch (IOException ex) {
                  Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
         }
      }
   }//GEN-LAST:event_jButtonVenderActionPerformed
   private void limpiaFormulario(){
      jFormattedTextFieldCantidad.setValue(null);
   }
   private void actualizaTabla(){
      DefaultTableModel modelo = (DefaultTableModel) jTableVenta.getModel();
      modelo.setRowCount(0);
      for (int i = 0; i < datos.getInventario().size(); i++) {
         modelo.addRow(new Object[]{(i + 1), datos.getInventario().get(i).getNombre(), datos.getInventario().get(i).getValor()
                 , datos.getInventario().get(i).getCantidad()});
      }
   }
   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Venta(datos).setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButtonAtras;
   private javax.swing.JButton jButtonLimpia;
   private javax.swing.JButton jButtonVender;
   private javax.swing.JFormattedTextField jFormattedTextFieldCantidad;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabelCantidad;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTable jTableVenta;
   // End of variables declaration//GEN-END:variables
}
