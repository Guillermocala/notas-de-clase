/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas.Admin;

import Datos.Central;
import Ventanas.Principal;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo
 */
public class EmpeniadosVencidos extends javax.swing.JFrame {
   private static Central datos;
   /**
    * Creates new form Empeniados
    * @param data
    */
   public EmpeniadosVencidos(Central data) {
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

      jPanel3 = new javax.swing.JPanel();
      Atras = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      jTableEmpeVencidos = new javax.swing.JTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Articulos Empeñados Vencidos");
      setLocation(new java.awt.Point(0, 0));
      setResizable(false);

      jPanel3.setBackground(new java.awt.Color(255, 255, 255));

      Atras.setText("Atras");
      Atras.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            AtrasActionPerformed(evt);
         }
      });

      jTableEmpeVencidos.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "N°", "Nombre", "Precio", "Fecha Ingreso", "Fecha Retiro", "Cantidad"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane1.setViewportView(jTableEmpeVencidos);
      if (jTableEmpeVencidos.getColumnModel().getColumnCount() > 0) {
         jTableEmpeVencidos.getColumnModel().getColumn(0).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(0).setPreferredWidth(7);
         jTableEmpeVencidos.getColumnModel().getColumn(1).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(1).setPreferredWidth(250);
         jTableEmpeVencidos.getColumnModel().getColumn(2).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(2).setPreferredWidth(50);
         jTableEmpeVencidos.getColumnModel().getColumn(3).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(3).setPreferredWidth(100);
         jTableEmpeVencidos.getColumnModel().getColumn(4).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(4).setPreferredWidth(100);
         jTableEmpeVencidos.getColumnModel().getColumn(5).setResizable(false);
         jTableEmpeVencidos.getColumnModel().getColumn(5).setPreferredWidth(50);
      }

      javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                  .addComponent(Atras)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
            .addContainerGap())
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
            .addComponent(Atras)
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
      Principal princi = new Principal(datos);
      princi.setVisible(true);
      dispose();
   }//GEN-LAST:event_AtrasActionPerformed
   public void actualizaTabla(){
      DefaultTableModel modelo = (DefaultTableModel) jTableEmpeVencidos.getModel();
      for (int i = 0; i < datos.getEmpeniadosVencidos().size() ; i++) {
         modelo.addRow(new Object[]{(i + 1), datos.getEmpeniadosVencidos().get(i).getNombre(), datos.getEmpeniadosVencidos().get(i).getValor()
                 , datos.getEmpeniadosVencidos().get(i).getFechaIngreso(), datos.getEmpeniadosVencidos().get(i).getFechaSalida(), 
                 datos.getEmpeniadosVencidos().get(i).getCantidad()});
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
         java.util.logging.Logger.getLogger(EmpeniadosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(EmpeniadosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(EmpeniadosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(EmpeniadosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new EmpeniadosVencidos(datos).setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton Atras;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTableEmpeVencidos;
   // End of variables declaration//GEN-END:variables
}