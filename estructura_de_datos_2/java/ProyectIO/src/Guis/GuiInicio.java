/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guis;

import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author 57300
 */
public class GuiInicio extends JFrame{
   private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    
    public GuiInicio() {
        this.initComponents();
    }
    
    private void initComponents() {
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.setTitle("Inicio");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.jButton1.setFont(new Font("Tahoma", 1, 14));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/images.png")));
        this.jButton1.setText("Minimizacion");
        this.jButton1.setHorizontalTextPosition(0);
        this.jButton1.setVerticalAlignment(1);
        this.jButton1.setVerticalTextPosition(3);
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiInicio.this.jButton1ActionPerformed(evt);
            }
        });
        this.getContentPane().add(this.jButton1);
        this.jButton1.setBounds(10, 30, 120, 120);
        this.jButton2.setFont(new Font("Tahoma", 1, 14));
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/imgres.jpg")));
        this.jButton2.setText("Transporte");
        this.jButton2.setHorizontalTextPosition(0);
        this.jButton2.setVerticalAlignment(1);
        this.jButton2.setVerticalTextPosition(3);
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiInicio.this.jButton2ActionPerformed(evt);
            }
        });
        this.getContentPane().add(this.jButton2);
        this.jButton2.setBounds(10, 158, 120, 141);
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/metodo-de-medicion.jpg")));
        this.jLabel1.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel1);
        this.jLabel1.setBounds(140, 30, 540, 404);
        this.jLabel2.setText("Ingenier\u00eda de sistemas VI-- CECAR 2015 - Fredys vergara");
        this.jLabel2.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel2);
        this.jLabel2.setBounds(340, 450, 340, 20);
        this.jButton3.setFont(new Font("Tahoma", 1, 18));
        this.jButton3.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/salir.png")));
        this.jButton3.setText("Salir");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiInicio.this.jButton3ActionPerformed(evt);
            }
        });
        this.getContentPane().add(this.jButton3);
        this.jButton3.setBounds(140, 440, 120, 40);
        this.jButton4.setFont(new Font("Tahoma", 1, 14));
        this.jButton4.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/admitidos_gran_210_213.png")));
        this.jButton4.setText("Asignaci\u00f3n");
        this.jButton4.setHorizontalTextPosition(0);
        this.jButton4.setVerticalTextPosition(3);
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiInicio.this.jButton4ActionPerformed(evt);
            }
        });
        this.getContentPane().add(this.jButton4);
        this.jButton4.setBounds(10, 306, 120, 130);
        this.setSize(new Dimension(721, 526));
        this.setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        new GuiSimplex().setVisible(true);
        this.dispose();
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        new GuiTransporte().setVisible(true);
        this.dispose();
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        new GuiAsignacion().setVisible(true);
        this.dispose();
    }
    
    public static void main(final String[] args) {
        try {
            for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(GuiInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(GuiInicio.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(GuiInicio.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(GuiInicio.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiInicio().setVisible(true);
            }
        });
    }
}
