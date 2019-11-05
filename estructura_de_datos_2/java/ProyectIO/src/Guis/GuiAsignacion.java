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
import javax.swing.KeyStroke;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.Cursor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import javax.swing.table.TableModel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Dimension;
import CrearTablas.crearTablaAsignacio;
import javax.swing.table.TableCellRenderer;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import Asignacion.ColorFilasAsignacionSolucion;
import Asignacion.DatosAsignacion;
import Asignacion.Asignacion;
import javax.swing.JFrame;
/**
 *
 * @author 57300
 */
public class GuiAsignacion extends JFrame{
   int tarea;
    int operador;
    Asignacion asignar;
    public static DatosAsignacion[][] datosAsignacio;
    ColorFilasAsignacionSolucion colorCedas;
    DefaultTableModel modeloSolucion;
    boolean parte1;
    private JLabel info2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JCheckBox jCheckBox1;
    private JFrame jFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JPopupMenu.Separator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTable jTable1;
    private JLabel jTextField1;
    private JSpinner jspOperadores;
    private JSpinner jspTareas;
    private JTable jtRestricciones;
    private JTable jtSolucion;
    
    public GuiAsignacion() {
        this.tarea = 2;
        this.operador = 2;
        this.asignar = new Asignacion();
        this.colorCedas = new ColorFilasAsignacionSolucion();
        this.parte1 = true;
        this.initComponents();
        this.jtSolucion.setRowHeight(25);
        this.jtRestricciones.setRowHeight(25);
        this.jtSolucion.setDefaultRenderer(Object.class, this.colorCedas);
        new crearTablaAsignacio().crearTablaRestricciones(this.tarea, this.operador, this.jtRestricciones, 0);
        this.jFrame1.setBounds(this.getX() + this.getWidth() / 2 - this.jFrame1.getWidth() / 2, this.getHeight() / 2 - this.jFrame1.getHeight() / 2, this.jFrame1.getWidth(), this.jFrame1.getHeight());
    }
    
    private void initComponents() {
        this.jFrame1 = new JFrame();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jtRestricciones = new JTable();
        this.jButton2 = new JButton();
        this.jCheckBox1 = new JCheckBox();
        this.info2 = new JLabel();
        this.jSeparator3 = new JSeparator();
        this.jSeparator4 = new JSeparator();
        this.jPanel8 = new JPanel();
        this.jPanel5 = new JPanel();
        this.jspTareas = new JSpinner();
        this.jspOperadores = new JSpinner();
        this.jButton3 = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.jtSolucion = new JTable();
        this.jPanel7 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jSeparator2 = new JPopupMenu.Separator();
        this.jMenuItem2 = new JMenuItem();
        this.jFrame1.setTitle("Coeficientes");
        this.jFrame1.setMinimumSize(new Dimension(680, 610));
        this.jFrame1.getContentPane().setLayout(null);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Coeficientes del Problema", 0, 0, new Font("Tahoma", 1, 14)));
        this.jPanel3.setLayout(null);
        this.jtRestricciones.setFont(new Font("Tahoma", 0, 14));
        this.jtRestricciones.setModel(new DefaultTableModel(new Object[][] { { "Origen 1", null, null, null }, { "Origen 2", null, null, null }, { "Demanda", null, null, null } }, new String[] { "", "Destino 1", "Destino 2", "Oferta" }));
        this.jtRestricciones.setAutoResizeMode(0);
        this.jtRestricciones.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent evt) {
                GuiAsignacion.this.jtRestriccionesFocusGained(evt);
            }
        });
        this.jtRestricciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiAsignacion.this.jtRestriccionesMousePressed(evt);
            }
        });
        this.jtRestricciones.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                GuiAsignacion.this.jtRestriccionesKeyTyped(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jtRestricciones);
        this.jPanel3.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(16, 30, 610, 350);
        this.jButton2.setFont(new Font("Tahoma", 1, 18));
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/writing62.png")));
        this.jButton2.setText("Terminar ");
        this.jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiAsignacion.this.jButton2MousePressed(evt);
            }
            
            @Override
            public void mouseReleased(final MouseEvent evt) {
                GuiAsignacion.this.jButton2MouseReleased(evt);
            }
        });
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jButton2);
        this.jButton2.setBounds(447, 390, 180, 40);
        this.jCheckBox1.setFont(new Font("Tahoma", 1, 12));
        this.jCheckBox1.setBorder(BorderFactory.createEtchedBorder());
        this.jCheckBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiAsignacion.this.jCheckBox1MousePressed(evt);
            }
        });
        this.jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jCheckBox1);
        this.jCheckBox1.setBounds(16, 398, 20, 31);
        this.info2.setBorder(BorderFactory.createEtchedBorder());
        this.info2.setOpaque(true);
        this.jPanel3.add(this.info2);
        this.info2.setBounds(138, 402, 290, 22);
        this.jSeparator3.setOrientation(1);
        this.jPanel3.add(this.jSeparator3);
        this.jSeparator3.setBounds(130, 402, 12, 20);
        this.jSeparator4.setOrientation(1);
        this.jPanel3.add(this.jSeparator4);
        this.jSeparator4.setBounds(432, 402, 12, 20);
        this.jFrame1.getContentPane().add(this.jPanel3);
        this.jPanel3.setBounds(10, 118, 680, 450);
        this.jPanel8.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel8.setLayout(null);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout(null);
        this.jspTareas.setFont(new Font("Tahoma", 1, 18));
        this.jspTareas.setModel(new SpinnerNumberModel(2, 1, 400, 1));
        this.jspTareas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                GuiAsignacion.this.jspTareasStateChanged(evt);
            }
        });
        this.jPanel5.add(this.jspTareas);
        this.jspTareas.setBounds(110, 40, 80, 28);
        this.jspOperadores.setFont(new Font("Tahoma", 1, 18));
        this.jspOperadores.setModel(new SpinnerNumberModel(2, 2, 350, 1));
        this.jPanel5.add(this.jspOperadores);
        this.jspOperadores.setBounds(110, 10, 80, 28);
        this.jButton3.setFont(new Font("Tahoma", 1, 14));
        this.jButton3.setText("OK");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton3);
        this.jButton3.setBounds(210, 40, 60, 30);
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Tareas");
        this.jPanel5.add(this.jLabel4);
        this.jLabel4.setBounds(10, 40, 110, 30);
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Operadores");
        this.jPanel5.add(this.jLabel6);
        this.jLabel6.setBounds(10, 10, 130, 30);
        this.jPanel8.add(this.jPanel5);
        this.jPanel5.setBounds(20, 10, 590, 80);
        this.jFrame1.getContentPane().add(this.jPanel8);
        this.jPanel8.setBounds(10, 10, 650, 100);
        this.setDefaultCloseOperation(3);
        this.setTitle("Asignaci\u00f3n");
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.jtSolucion.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
        this.jtSolucion.setAutoResizeMode(0);
        this.jtSolucion.setCursor(new Cursor(0));
        this.jtSolucion.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorMoved(final AncestorEvent evt) {
            }
            
            @Override
            public void ancestorAdded(final AncestorEvent evt) {
                GuiAsignacion.this.jtSolucionAncestorAdded(evt);
            }
            
            @Override
            public void ancestorRemoved(final AncestorEvent evt) {
            }
        });
        this.jScrollPane3.setViewportView(this.jtSolucion);
        this.getContentPane().add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 20, 790, 450);
        this.jPanel7.setBorder(new SoftBevelBorder(0));
        this.jPanel7.setLayout(null);
        this.jButton1.setFont(new Font("Tahoma", 1, 24));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/pen67.png")));
        this.jButton1.setText("Coeficientes");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton1);
        this.jButton1.setBounds(20, 10, 230, 50);
        this.jButton4.setFont(new Font("Tahoma", 1, 18));
        this.jButton4.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/play109.png")));
        this.jButton4.setText("Resolver P a P");
        this.jButton4.setEnabled(false);
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton4);
        this.jButton4.setBounds(530, 10, 240, 50);
        this.jButton5.setFont(new Font("Tahoma", 1, 18));
        this.jButton5.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logotype171.png")));
        this.jButton5.setText("Resolver");
        this.jButton5.setEnabled(false);
        this.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton5);
        this.jButton5.setBounds(340, 10, 160, 50);
        this.getContentPane().add(this.jPanel7);
        this.jPanel7.setBounds(10, 480, 790, 70);
        this.jLabel1.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel1);
        this.jLabel1.setBounds(10, 560, 450, 20);
        this.jLabel7.setText("Ingenier\u00eda de sistemas VI-- CECAR 2015 - Fredys vergara");
        this.jLabel7.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel7);
        this.jLabel7.setBounds(460, 560, 340, 20);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("Soluci\u00f3n"));
        this.jPanel1.setLayout(null);
        this.jTable1.setModel(new DefaultTableModel(new Object[0][], new String[] { "Operador", "Tarea", "Costo" }));
        this.jScrollPane2.setViewportView(this.jTable1);
        this.jPanel1.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 30, 240, 320);
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setText("Z = ");
        this.jLabel2.setOpaque(true);
        this.jPanel1.add(this.jLabel2);
        this.jLabel2.setBounds(50, 380, 30, 20);
        this.jTextField1.setBackground(new Color(255, 255, 255));
        this.jTextField1.setFont(new Font("Tahoma", 0, 12));
        this.jTextField1.setText("0.0");
        this.jTextField1.setBorder(BorderFactory.createTitledBorder(""));
        this.jTextField1.setOpaque(true);
        this.jPanel1.add(this.jTextField1);
        this.jTextField1.setBounds(80, 374, 160, 30);
        this.getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(810, 20, 260, 450);
        this.jLabel8.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logoC.jpg")));
        this.jLabel8.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel8);
        this.jLabel8.setBounds(820, 490, 204, 54);
        this.jMenu1.setText("File");
        this.jMenuItem1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/inicio.png")));
        this.jMenuItem1.setText("Inicio");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenu1.add(this.jSeparator2);
        this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.jMenuItem2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/salir.png")));
        this.jMenuItem2.setText("Salir");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiAsignacion.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        this.setSize(new Dimension(1093, 655));
        this.setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.jFrame1.setVisible(true);
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        if (this.asignar.getCantifadaR() == GuiAsignacion.datosAsignacio.length) {
            this.asignar.buscarSoloCeroFila(this.jtSolucion);
            this.solucion();
        }
        if (this.parte1) {
            this.asignar.buscarMenorFila(this.jtSolucion);
            this.asignar.restarMenorFila(this.jtSolucion);
            this.asignar.buscarMenorcolumna(this.jtSolucion);
            this.asignar.restarMenorColuma(this.jtSolucion);
            this.asignar.inicirBusqueda(this.jtSolucion);
            this.parte1 = false;
        }
        else if (!this.parte1) {
            this.quitarFilaMenorColumna();
            if (this.asignar.getCantifadaR() < GuiAsignacion.datosAsignacio.length) {
                this.asignar.buscarMenorTabla(this.jtSolucion);
                this.asignar.sumarMenor(this.jtSolucion);
                this.asignar.quitarRayas();
                this.asignar.inicirBusqueda(this.jtSolucion);
            }
            else {
                this.mostarSolucionT();
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
            }
        }
    }
    
    private void jButton5ActionPerformed(final ActionEvent evt) {
        while (true) {
            if (this.asignar.getCantifadaR() == GuiAsignacion.datosAsignacio.length) {
                this.asignar.buscarSoloCeroFila(this.jtSolucion);
                this.solucion();
            }
            if (this.parte1) {
                this.asignar.buscarMenorFila(this.jtSolucion);
                this.asignar.restarMenorFila(this.jtSolucion);
                this.asignar.buscarMenorcolumna(this.jtSolucion);
                this.asignar.restarMenorColuma(this.jtSolucion);
                this.asignar.inicirBusqueda(this.jtSolucion);
                this.parte1 = false;
            }
            else {
                if (this.parte1) {
                    continue;
                }
                this.quitarFilaMenorColumna();
                if (this.asignar.getCantifadaR() >= GuiAsignacion.datosAsignacio.length) {
                    break;
                }
                this.asignar.buscarMenorTabla(this.jtSolucion);
                this.asignar.sumarMenor(this.jtSolucion);
                this.asignar.quitarRayas();
                this.asignar.inicirBusqueda(this.jtSolucion);
            }
        }
        this.mostarSolucionT();
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);
    }
    
    private void jtRestriccionesFocusGained(final FocusEvent evt) {
    }
    
    private void jtRestriccionesMousePressed(final MouseEvent evt) {
        this.info2.setText("");
        this.info2.setBackground(new Color(240, 240, 240));
    }
    
    private void jtRestriccionesKeyTyped(final KeyEvent evt) {
        final char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '-' && c != 'E' && c != '.') {
            evt.consume();
        }
    }
    
    private void jButton2MousePressed(final MouseEvent evt) {
        this.info2.setText(" Procesando\u2026");
    }
    
    private void jButton2MouseReleased(final MouseEvent evt) {
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        if (!this.valiodarDatos()) {
            this.info2.setText("Datos Incorrectos...");
            this.info2.setBackground(new Color(255, 204, 204));
        }
        else if (this.tarea == this.operador) {
            new crearTablaAsignacio().CrearTablaSolucion(this.jtRestricciones, this.jtSolucion);
            this.asignar = new Asignacion();
            this.jButton4.setEnabled(true);
            this.jButton5.setEnabled(true);
            this.jFrame1.setVisible(false);
            this.modeloSolucion = (DefaultTableModel)this.jtSolucion.getModel();
            this.asignar.buscarMenorFila(this.jtSolucion);
            this.asignar.buscarMenorcolumna(this.jtSolucion);
            this.parte1 = true;
        }
        else {
            this.info2.setText("Sistema no Equilibrado...");
            this.info2.setBackground(new Color(255, 204, 204));
        }
    }
    
    private void jCheckBox1MousePressed(final MouseEvent evt) {
        this.info2.setText(" Procesando\u2026");
    }
    
    private void jCheckBox1ActionPerformed(final ActionEvent evt) {
    }
    
    private void jspTareasStateChanged(final ChangeEvent evt) {
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        this.tarea = Integer.parseInt("" + this.jspTareas.getValue());
        this.operador = Integer.parseInt("" + this.jspOperadores.getValue());
        new crearTablaAsignacio().crearTablaRestricciones(this.tarea, this.operador, this.jtRestricciones, 0);
        this.info2.setText("");
        this.info2.setBackground(new Color(240, 240, 240));
    }
    
    private void jtSolucionAncestorAdded(final AncestorEvent evt) {
    }
    
    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        new GuiInicio().setVisible(true);
        this.dispose();
    }
    
    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    public void quitarFilaMenorColumna() {
        final int fiI = this.jtSolucion.getRowCount();
        final int coI = this.jtSolucion.getColumnCount();
        for (int i = 1; i < fiI; ++i) {
            this.jtSolucion.setValueAt(" ", i, coI - 1);
        }
        for (int i = 1; i < coI; ++i) {
            this.jtSolucion.setValueAt(" ", fiI - 1, i);
        }
    }
    
    public void solucion() {
        for (int i = 0; i < GuiAsignacion.datosAsignacio.length; ++i) {
            for (int j = 0; j < GuiAsignacion.datosAsignacio[i].length; ++j) {
                if (GuiAsignacion.datosAsignacio[i][j].isColorea()) {
                    this.jtSolucion.setValueAt("" + GuiAsignacion.datosAsignacio[i][j].getCosto(), i + 1, j + 1);
                }
                GuiAsignacion.datosAsignacio[i][j].setDobleRayado(false);
                GuiAsignacion.datosAsignacio[i][j].setRayado(false);
            }
        }
    }
    
    public void mostarSolucionT() {
        double total = 0.0;
        final Object[] cabeza = { "Perador", "Tarea", "Costo" };
        final DefaultTableModel mode = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        this.jTable1.setModel(mode);
        final String[] row = new String[3];
        for (int i = 0; i < GuiAsignacion.datosAsignacio.length; ++i) {
            for (int j = 0; j < GuiAsignacion.datosAsignacio[0].length; ++j) {
                if (GuiAsignacion.datosAsignacio[i][j].isColorea()) {
                    row[0] = "" + (i + 1);
                    row[1] = "" + (j + 1);
                    row[2] = GuiAsignacion.datosAsignacio[i][j].getCosto();
                    mode.addRow(row);
                    total += Double.parseDouble("" + GuiAsignacion.datosAsignacio[i][j].getCosto());
                }
            }
        }
        this.jTextField1.setText(" " + total);
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
            Logger.getLogger(GuiAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(GuiAsignacion.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(GuiAsignacion.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(GuiAsignacion.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiAsignacion().setVisible(true);
            }
        });
    }
    
    public boolean valiodarDatos() {
        for (int i = 1; i < this.jtRestricciones.getRowCount(); ++i) {
            for (int j = 1; j < this.jtRestricciones.getColumnCount(); ++j) {
                try {
                    Double.parseDouble("" + this.jtRestricciones.getValueAt(i, j));
                }
                catch (Exception ex) {
                    return false;
                }
            }
        }
        return true;
    }
}
