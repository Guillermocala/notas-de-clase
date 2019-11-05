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
import java.util.ArrayList;
import Simplex.Guardar;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;
import java.io.File;
import javax.swing.JOptionPane;
import Simplex.GetX;
import java.awt.Color;
import Simplex.AproximarNumero;
import Simplex.Simplex;
import CrearTablas.CrearTablasSimplex;
import javax.swing.KeyStroke;
import javax.swing.border.SoftBevelBorder;
import javax.accessibility.Accessible;
import javax.swing.BoxLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
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
import javax.swing.filechooser.FileFilter;
import javax.swing.ImageIcon;
import Simplex.ColorFilasFunciones;
import javax.swing.table.TableCellRenderer;
import Simplex.ColorFilas;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFileChooser;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import Persistencia.EscribirLeer;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
/**
 *
 * @author 57300
 */
public class GuiSimplex extends JFrame{
   private FileNameExtensionFilter filtro;
    private DefaultTableModel modeloRestricciones;
    private DefaultTableModel modeloSolucion;
    private int Xn;
    private int Nrestricciones;
    private boolean limpiar;
    private boolean guardar;
    private EscribirLeer archivo;
    private JTable Tablon;
    public static JLabel info;
    private JLabel info2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JCheckBox jCheckBox1;
    private JDialog jDialog1;
    private JFileChooser jFileChooser2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JMenu jMenu1;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenuBar jMenuBar1;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPopupMenu jPopupMenu2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane5;
    private JPopupMenu.Separator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTabbedPane jTabbedPane1;
    private JComboBox jcbObjetivo;
    private JLabel jlPivote;
    private JLabel jlcolunna;
    private JLabel jlfila;
    private JSpinner jspRest;
    private JSpinner jspvariables;
    private JTable jtRestricciones;
    private JTextArea jtaEcuaciones;
    public static JTextArea jtaOperaciones;
    private JFrame ventanaCoeficientes;
    
    public GuiSimplex() {
        this.filtro = new FileNameExtensionFilter("Arcivos sipx ", new String[] { "sipx" });
        this.modeloRestricciones = null;
        this.modeloSolucion = null;
        this.Xn = 0;
        this.limpiar = true;
        this.guardar = true;
        this.archivo = new EscribirLeer();
        this.initComponents();
        this.Tablon.setDefaultRenderer(Object.class, new ColorFilas());
        this.jtRestricciones.setDefaultRenderer(Object.class, new ColorFilasFunciones());
        this.setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/icon1.png")).getImage());
        this.jDialog1.setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/icon1.png")).getImage());
        this.ventanaCoeficientes.setIconImage(new ImageIcon(this.getClass().getResource("/Imagenes/icon1.png")).getImage());
        this.jFileChooser2.setFileFilter(this.filtro);
    }
    
    private void initComponents() {
        this.ventanaCoeficientes = new JFrame();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jtRestricciones = new JTable();
        this.jButton2 = new JButton();
        this.jCheckBox1 = new JCheckBox();
        this.info2 = new JLabel();
        this.jSeparator3 = new JSeparator();
        this.jSeparator4 = new JSeparator();
        this.jPanel8 = new JPanel();
        this.jPanel1 = new JPanel();
        this.jcbObjetivo = new JComboBox();
        this.jPanel5 = new JPanel();
        this.jspRest = new JSpinner();
        this.jspvariables = new JSpinner();
        this.jButton3 = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jMenuBar2 = new JMenuBar();
        this.jMenu3 = new JMenu();
        this.jMenu4 = new JMenu();
        this.jDialog1 = new JDialog();
        this.jFileChooser2 = new JFileChooser();
        this.jPopupMenu2 = new JPopupMenu();
        this.jMenuItem5 = new JMenuItem();
        this.jPanel4 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        GuiSimplex.jtaOperaciones = new JTextArea();
        this.jlPivote = new JLabel();
        this.jlcolunna = new JLabel();
        this.jlfila = new JLabel();
        this.jSeparator2 = new JSeparator();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.Tablon = new JTable();
        this.jLabel3 = new JLabel();
        this.jPanel6 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.jtaEcuaciones = new JTextArea();
        GuiSimplex.info = new JLabel();
        this.jPanel7 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem3 = new JMenuItem();
        this.jSeparator1 = new JPopupMenu.Separator();
        this.jMenuItem4 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.ventanaCoeficientes.setTitle("Coeficientes");
        this.ventanaCoeficientes.setMinimumSize(new Dimension(610, 610));
        this.ventanaCoeficientes.setResizable(false);
        this.ventanaCoeficientes.setSize(new Dimension(610, 610));
        this.ventanaCoeficientes.getContentPane().setLayout(null);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Coeficientes del Problema", 0, 0, new Font("Tahoma", 1, 14)));
        this.jPanel3.setLayout(null);
        this.jtRestricciones.setFont(new Font("Tahoma", 0, 14));
        this.jtRestricciones.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0] }, new String[0]));
        this.jtRestricciones.setAutoResizeMode(0);
        this.jtRestricciones.setComponentPopupMenu(this.jPopupMenu2);
        this.jtRestricciones.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent evt) {
                GuiSimplex.this.jtRestriccionesFocusGained(evt);
            }
        });
        this.jtRestricciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiSimplex.this.jtRestriccionesMousePressed(evt);
            }
        });
        this.jtRestricciones.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                GuiSimplex.this.jtRestriccionesKeyTyped(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jtRestricciones);
        this.jPanel3.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(16, 30, 558, 350);
        this.jButton2.setFont(new Font("Tahoma", 1, 18));
        this.jButton2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/writing62.png")));
        this.jButton2.setText("Terminar ");
        this.jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiSimplex.this.jButton2MousePressed(evt);
            }
        });
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jButton2);
        this.jButton2.setBounds(390, 390, 177, 41);
        this.jCheckBox1.setFont(new Font("Tahoma", 1, 12));
        this.jCheckBox1.setText("Rellenar con 0");
        this.jCheckBox1.setBorder(BorderFactory.createEtchedBorder());
        this.jCheckBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiSimplex.this.jCheckBox1MousePressed(evt);
            }
        });
        this.jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jCheckBox1);
        this.jCheckBox1.setBounds(16, 398, 110, 31);
        this.info2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.add(this.info2);
        this.info2.setBounds(138, 402, 240, 22);
        this.jSeparator3.setOrientation(1);
        this.jPanel3.add(this.jSeparator3);
        this.jSeparator3.setBounds(130, 402, 12, 20);
        this.jSeparator4.setOrientation(1);
        this.jPanel3.add(this.jSeparator4);
        this.jSeparator4.setBounds(382, 402, 12, 20);
        this.ventanaCoeficientes.getContentPane().add(this.jPanel3);
        this.jPanel3.setBounds(10, 120, 590, 450);
        this.jPanel8.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel8.setLayout(null);
        this.jPanel1.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel1.setLayout(null);
        this.jcbObjetivo.setFont(new Font("Tahoma", 1, 14));
        this.jcbObjetivo.setModel(new DefaultComboBoxModel<String>(new String[] { "Maximizar", "Minimizar" }));
        this.jPanel1.add(this.jcbObjetivo);
        this.jcbObjetivo.setBounds(20, 24, 120, 34);
        this.jPanel8.add(this.jPanel1);
        this.jPanel1.setBounds(20, 10, 160, 80);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout(null);
        this.jspRest.setFont(new Font("Tahoma", 1, 18));
        this.jspRest.setModel(new SpinnerNumberModel(2, 1, 400, 1));
        this.jspRest.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                GuiSimplex.this.jspRestStateChanged(evt);
            }
        });
        this.jPanel5.add(this.jspRest);
        this.jspRest.setBounds(140, 50, 100, 28);
        this.jspvariables.setFont(new Font("Tahoma", 1, 18));
        this.jspvariables.setModel(new SpinnerNumberModel(2, 2, 350, 1));
        this.jPanel5.add(this.jspvariables);
        this.jspvariables.setBounds(140, 10, 100, 28);
        this.jButton3.setFont(new Font("Tahoma", 1, 14));
        this.jButton3.setText("OK");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton3);
        this.jButton3.setBounds(270, 50, 60, 30);
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Restricciones");
        this.jPanel5.add(this.jLabel4);
        this.jLabel4.setBounds(30, 47, 110, 30);
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Variables ");
        this.jPanel5.add(this.jLabel6);
        this.jLabel6.setBounds(30, 10, 130, 30);
        this.jPanel8.add(this.jPanel5);
        this.jPanel5.setBounds(220, 6, 360, 88);
        this.ventanaCoeficientes.getContentPane().add(this.jPanel8);
        this.jPanel8.setBounds(10, 10, 590, 100);
        this.jMenuBar2.add(this.jMenu3);
        this.jMenuBar2.add(this.jMenu4);
        this.ventanaCoeficientes.setJMenuBar(this.jMenuBar2);
        this.jDialog1.setTitle("Abrir");
        this.jDialog1.setMinimumSize(new Dimension(643, 419));
        this.jDialog1.getContentPane().setLayout(new BoxLayout(this.jDialog1.getContentPane(), 2));
        this.jFileChooser2.setFileFilter(null);
        this.jFileChooser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jFileChooser2ActionPerformed(evt);
            }
        });
        this.jDialog1.getContentPane().add(this.jFileChooser2);
        this.jDialog1.getAccessibleContext().setAccessibleParent(null);
        this.jMenuItem5.setText("Eliminar Fila");
        this.jMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jMenuItem5ActionPerformed(evt);
            }
        });
        this.jPopupMenu2.add(this.jMenuItem5);
        this.setDefaultCloseOperation(3);
        this.setTitle("Simplex");
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder("Operaciones"));
        this.jPanel4.setLayout(null);
        GuiSimplex.jtaOperaciones.setEditable(false);
        GuiSimplex.jtaOperaciones.setColumns(20);
        GuiSimplex.jtaOperaciones.setFont(new Font("MS Gothic", 1, 18));
        GuiSimplex.jtaOperaciones.setRows(5);
        this.jScrollPane2.setViewportView(GuiSimplex.jtaOperaciones);
        this.jPanel4.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 20, 230, 310);
        this.jlPivote.setText("Pivote");
        this.jPanel4.add(this.jlPivote);
        this.jlPivote.setBounds(10, 360, 180, 20);
        this.jlcolunna.setText("Columna");
        this.jPanel4.add(this.jlcolunna);
        this.jlcolunna.setBounds(10, 410, 150, 20);
        this.jlfila.setText("Fila");
        this.jPanel4.add(this.jlfila);
        this.jlfila.setBounds(10, 380, 130, 20);
        this.jPanel4.add(this.jSeparator2);
        this.jSeparator2.setBounds(10, 340, 230, 10);
        this.getContentPane().add(this.jPanel4);
        this.jPanel4.setBounds(856, 41, 250, 450);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel2.setLayout(null);
        this.Tablon.setFont(new Font("Tahoma", 0, 14));
        this.Tablon.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.Tablon.setAutoResizeMode(0);
        this.jScrollPane3.setViewportView(this.Tablon);
        this.jPanel2.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 10, 820, 410);
        this.jLabel3.setText("Ingenier\u00eda de sistemas CECAR 2015   ---- Fredys Vergara");
        this.jLabel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.add(this.jLabel3);
        this.jLabel3.setBounds(10, 570, 310, 20);
        this.jTabbedPane1.addTab("Soluci\u00f3n", new ImageIcon(this.getClass().getResource("/Imagenes/one62 (2).png")), this.jPanel2);
        this.jPanel6.setLayout(null);
        this.jScrollPane5.setBorder(null);
        this.jtaEcuaciones.setEditable(false);
        this.jtaEcuaciones.setColumns(20);
        this.jtaEcuaciones.setFont(new Font("Arial Narrow", 0, 20));
        this.jtaEcuaciones.setRows(5);
        this.jtaEcuaciones.setBorder(null);
        this.jtaEcuaciones.setOpaque(false);
        this.jScrollPane5.setViewportView(this.jtaEcuaciones);
        this.jPanel6.add(this.jScrollPane5);
        this.jScrollPane5.setBounds(230, 80, 430, 290);
        this.jTabbedPane1.addTab("Ecuaciones", new ImageIcon(this.getClass().getResource("/Imagenes/text lines18.png")), this.jPanel6);
        this.getContentPane().add(this.jTabbedPane1);
        this.jTabbedPane1.setBounds(10, 10, 840, 480);
        GuiSimplex.info.setBorder(BorderFactory.createEtchedBorder());
        GuiSimplex.info.setOpaque(true);
        this.getContentPane().add(GuiSimplex.info);
        GuiSimplex.info.setBounds(20, 578, 400, 20);
        this.jPanel7.setBorder(new SoftBevelBorder(0));
        this.jPanel7.setLayout(null);
        this.jButton1.setFont(new Font("Tahoma", 1, 24));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/pen67.png")));
        this.jButton1.setText("Coeficientes");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton1);
        this.jButton1.setBounds(30, 10, 230, 50);
        this.jButton4.setFont(new Font("Tahoma", 1, 18));
        this.jButton4.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/play109.png")));
        this.jButton4.setText("Resolver P a P");
        this.jButton4.setEnabled(false);
        this.jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton4);
        this.jButton4.setBounds(520, 10, 240, 50);
        this.jButton5.setFont(new Font("Tahoma", 1, 18));
        this.jButton5.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logotype171.png")));
        this.jButton5.setText("Resolver");
        this.jButton5.setEnabled(false);
        this.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton5);
        this.jButton5.setBounds(320, 10, 160, 50);
        this.getContentPane().add(this.jPanel7);
        this.jPanel7.setBounds(10, 497, 830, 70);
        this.jLabel2.setText("Ingenier\u00eda de sistemas VI-- CECAR 2015 - Fredys vergara");
        this.jLabel2.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel2);
        this.jLabel2.setBounds(500, 580, 340, 20);
        this.jLabel8.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logoC.jpg")));
        this.jLabel8.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel8);
        this.jLabel8.setBounds(860, 500, 204, 54);
        this.jMenu1.setText("File");
        this.jMenu1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                GuiSimplex.this.jMenu1StateChanged(evt);
            }
        });
        this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(71, 2));
        this.jMenuItem1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/floppy2.png")));
        this.jMenuItem1.setText("Guardar");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        this.jMenuItem3.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/folder265.png")));
        this.jMenuItem3.setText("Abrir");
        this.jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jMenuItem3ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem3);
        this.jMenu1.add(this.jSeparator1);
        this.jMenuItem4.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/inicio.png")));
        this.jMenuItem4.setText("Inicio");
        this.jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jMenuItem4ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem4);
        this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.jMenuItem2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/salir.png")));
        this.jMenuItem2.setText("Salir");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiSimplex.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        this.setSize(new Dimension(1119, 667));
        this.setLocationRelativeTo(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.ventanaCoeficientes.setBounds(this.getX() + 100, this.getY() + 5, this.ventanaCoeficientes.getWidth(), this.ventanaCoeficientes.getHeight());
        this.ventanaCoeficientes.setVisible(true);
        if (this.limpiar) {
            this.crearTablaRestricciones();
        }
        this.limpiar = false;
        this.jButton4.setEnabled(false);
        this.Nrestricciones = this.modeloRestricciones.getRowCount() - 1;
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        this.crearTablaRestricciones();
        this.jCheckBox1ActionPerformed(evt);
    }
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        if (!this.validar()) {
            CrearTablasSimplex.TablaSolucion(this.Xn, this.Nrestricciones, this.modeloRestricciones, this.Tablon);
            Simplex.calcularZj(this.modeloSolucion = (DefaultTableModel)this.Tablon.getModel());
            Simplex.calcularCj_Zj(this.modeloSolucion);
            if (this.jcbObjetivo.getSelectedIndex() == 0) {
                Simplex.mayorFilaCj_Zj(this.modeloSolucion);
            }
            else {
                Simplex.menorFilaCj_Zj(this.modeloSolucion);
            }
            Simplex.CalcularXn_Mayor(this.modeloSolucion);
            Simplex.Menor(this.modeloSolucion);
            this.jButton4.setEnabled(true);
            this.jButton5.setEnabled(true);
            this.ventanaCoeficientes.setVisible(false);
            Simplex.ntablones = 1;
            GuiSimplex.jtaOperaciones.setText(null);
            this.jlfila.setText("Fila: " + (Simplex.filalaMenor - 1));
            this.jlcolunna.setText("Columna: " + Simplex.columnaMayor);
            this.jlPivote.setText("Pivote: " + Simplex.pivote);
            this.jlPivote.setText("Pivote: " + AproximarNumero.valorAprocimado(String.valueOf(this.modeloSolucion.getValueAt(Simplex.filalaMenor, Simplex.columnaMayor))));
            this.Ecuaciones();
        }
        this.info2.setText("");
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        GuiSimplex.info.setText(null);
        GuiSimplex.info.setBackground(new Color(240, 240, 240));
        if (!Simplex.todosMenor) {
            if (Simplex.filalaMenor <= 0) {
                GuiSimplex.info.setText("No se ha podido encontrar una soluci\u00f3n al sistema ");
                GuiSimplex.info.setBackground(new Color(255, 35, 35));
            }
            else {
                Simplex.Convertir0Pivote(this.modeloSolucion);
                Simplex.Gauss(this.modeloSolucion);
                Simplex.calcularZj(this.modeloSolucion);
                Simplex.calcularCj_Zj(this.modeloSolucion);
                if (this.jcbObjetivo.getSelectedItem().toString().equalsIgnoreCase("Maximizar")) {
                    Simplex.mayorFilaCj_Zj(this.modeloSolucion);
                }
                else if (this.jcbObjetivo.getSelectedItem().toString().equalsIgnoreCase("Minimizar")) {
                    Simplex.menorFilaCj_Zj(this.modeloSolucion);
                }
                Simplex.CalcularXn_Mayor(this.modeloSolucion);
                Simplex.Menor(this.modeloSolucion);
            }
        }
        if (Simplex.todosMenor) {
            this.jButton4.setEnabled(false);
            GuiSimplex.info.setBackground(Color.GREEN);
            GuiSimplex.info.setText("Fin de proceso");
            GetX.mostar(this.modeloSolucion, this.Xn);
            this.limpiarUltimaCelda();
        }
        this.jlfila.setText("Fila: " + (Simplex.filalaMenor - 1));
        this.jlcolunna.setText("Columna: " + Simplex.columnaMayor);
        this.jlPivote.setText("Pivote: " + AproximarNumero.valorAprocimado(String.valueOf(this.modeloSolucion.getValueAt(Simplex.filalaMenor, Simplex.columnaMayor))));
    }
    
    private void jspRestStateChanged(final ChangeEvent evt) {
        final int fi = Integer.parseInt(this.jspRest.getValue().toString());
        final String[] g = new String[this.Xn];
        if (fi > this.Nrestricciones) {
            for (int i = this.Nrestricciones + 1; i <= fi; ++i) {
                g[0] = "Rest " + i;
                this.modeloRestricciones.addRow(g);
                this.modeloRestricciones.setValueAt("<=", i, this.modeloRestricciones.getColumnCount() - 2);
            }
            this.Nrestricciones = fi;
        }
        else if (fi < this.Nrestricciones) {
            while (this.Nrestricciones != fi) {
                this.modeloRestricciones.removeRow(this.Nrestricciones);
                --this.Nrestricciones;
            }
        }
        this.jCheckBox1ActionPerformed(null);
    }
    
    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        final int s = JOptionPane.showConfirmDialog(this, "Desea salir...");
        if (s == 0) {
            System.exit(0);
        }
    }
    
    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        this.guardar = true;
        this.jDialog1.setVisible(true);
        this.jFileChooser2.setApproveButtonText("Guardar Archivo");
    }
    
    private void jMenuItem3ActionPerformed(final ActionEvent evt) {
        this.guardar = false;
        this.jDialog1.setVisible(true);
        this.jFileChooser2.setApproveButtonText("Abrir Archivo");
    }
    
    private void jtRestriccionesKeyTyped(final KeyEvent evt) {
        final char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '-' && c != 'E' && c != '.') {
            evt.consume();
        }
    }
    
    private void jFileChooser2ActionPerformed(final ActionEvent evt) {
        final JFileChooser seChooser = (JFileChooser)evt.getSource();
        final String comando = evt.getActionCommand();
        if (comando.equals("ApproveSelection")) {
            final File archivoSelecciondo = seChooser.getSelectedFile();
            final String ruta = archivoSelecciondo.getAbsolutePath();
            if (!this.guardar) {
                this.abrirArchivo(ruta, archivoSelecciondo.getName());
            }
            else {
                this.guardarArchivo(ruta, archivoSelecciondo.getName());
            }
        }
        else {
            this.jDialog1.dispose();
        }
    }
    
    private void jCheckBox1ActionPerformed(final ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            for (int f = 0; f < this.modeloRestricciones.getRowCount(); ++f) {
                for (int c = 1; c < this.modeloRestricciones.getColumnCount(); ++c) {
                    if (c != this.modeloRestricciones.getColumnCount() - 2 && (String.valueOf(this.modeloRestricciones.getValueAt(f, c)).equalsIgnoreCase("") || String.valueOf(this.modeloRestricciones.getValueAt(f, c)).equalsIgnoreCase("null"))) {
                        this.modeloRestricciones.setValueAt("0", f, c);
                    }
                }
            }
            this.modeloRestricciones.setValueAt("", 0, this.modeloRestricciones.getColumnCount() - 1);
        }
        else {
            for (int f = 0; f < this.modeloRestricciones.getRowCount(); ++f) {
                for (int c = 1; c < this.modeloRestricciones.getColumnCount(); ++c) {
                    if (c != this.modeloRestricciones.getColumnCount() - 2 && (String.valueOf(this.modeloRestricciones.getValueAt(f, c)).equalsIgnoreCase("0") || !isNumeric(String.valueOf(this.modeloRestricciones.getValueAt(f, c))))) {
                        this.modeloRestricciones.setValueAt("", f, c);
                    }
                }
            }
        }
        this.info2.setText(null);
    }
    
    private void jMenu1StateChanged(final ChangeEvent evt) {
        if (this.modeloRestricciones == null) {
            this.jMenuItem1.setEnabled(false);
        }
        else {
            this.jMenuItem1.setEnabled(true);
        }
    }
    
    private void jButton5ActionPerformed(final ActionEvent evt) {
        while (!Simplex.todosMenor && Simplex.filalaMenor > 0) {
            this.jButton4ActionPerformed(evt);
        }
        this.jButton5.setEnabled(false);
        this.limpiarUltimaCelda();
    }
    
    private void jButton2MousePressed(final MouseEvent evt) {
        this.info2.setText(" Procesando\u2026");
    }
    
    private void jCheckBox1MousePressed(final MouseEvent evt) {
        this.info2.setText(" Procesando\u2026");
    }
    
    private void jtRestriccionesFocusGained(final FocusEvent evt) {
    }
    
    private void jMenuItem5ActionPerformed(final ActionEvent evt) {
        final int fil = this.jtRestricciones.getSelectedRow();
        if (fil > 0) {
            this.modeloRestricciones.removeRow(fil);
            --this.Nrestricciones;
            for (int i = 1; i < this.modeloRestricciones.getRowCount(); ++i) {
                this.modeloRestricciones.setValueAt("Rest. " + i, i, 0);
                this.jspRest.setValue(this.Nrestricciones);
            }
        }
    }
    
    private void jtRestriccionesMousePressed(final MouseEvent evt) {
        final int fil = this.jtRestricciones.getSelectedRow();
        if (fil > 0 && this.modeloRestricciones.getRowCount() > 2) {
            this.jMenuItem5.setEnabled(true);
        }
        else {
            this.jMenuItem5.setEnabled(false);
        }
    }
    
    private void jMenuItem4ActionPerformed(final ActionEvent evt) {
        new GuiInicio().setVisible(true);
        this.dispose();
    }
    
    private void crearTablaRestricciones() {
        this.Xn = Integer.parseInt(String.valueOf(this.jspvariables.getValue()));
        this.Nrestricciones = Integer.parseInt(String.valueOf(this.jspRest.getValue()));
        final Object[] cabeza = new String[this.Xn + 3];
        cabeza[0] = " ";
        for (int i = 1; i <= this.Xn; ++i) {
            cabeza[i] = "X" + i;
        }
        cabeza[this.Xn + 1] = " ";
        cabeza[this.Xn + 2] = " ";
        this.modeloRestricciones = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return column != 0 && (row != 0 || column < GuiSimplex.this.modeloRestricciones.getColumnCount() - 2);
            }
        };
        this.jtRestricciones.setModel(this.modeloRestricciones);
        final String[] fila = new String[this.Xn + 3];
        for (int j = 0; j < this.Nrestricciones + 1; ++j) {
            if (j == 0) {
                fila[0] = new String("     Z =");
            }
            else {
                fila[0] = new String("Rest. " + j);
                fila[this.modeloRestricciones.getColumnCount() - 2] = "<=";
            }
            this.modeloRestricciones.addRow(fila);
        }
        this.agregarComboBox(this.modeloRestricciones.getColumnCount(), this.jtRestricciones);
    }
    
    private void Ecuaciones() {
        this.jtaEcuaciones.setText(null);
        final int fila = this.modeloRestricciones.getRowCount();
        final int col = this.modeloRestricciones.getColumnCount();
        this.jtaEcuaciones.append(" Z = ");
        for (int c = 1; c < col - 2; ++c) {
            if (Double.parseDouble(String.valueOf(this.modeloRestricciones.getValueAt(0, c))) >= 0.0) {
                this.jtaEcuaciones.append(" + " + this.modeloRestricciones.getValueAt(0, c) + "X" + c);
            }
            else {
                this.jtaEcuaciones.append(" " + this.modeloRestricciones.getValueAt(0, c) + " X" + c);
            }
        }
        this.jtaEcuaciones.append(" \n\n");
        for (int fil = 1; fil < fila; ++fil) {
            this.jtaEcuaciones.append(" ");
            for (int co = 1; co < col; ++co) {
                if (co == 1) {
                    this.jtaEcuaciones.append("" + this.modeloRestricciones.getValueAt(fil, co) + "X" + co);
                }
                else if (co == col - 2) {
                    this.jtaEcuaciones.append(" " + this.modeloRestricciones.getValueAt(fil, co));
                }
                else if (co >= col - 2) {
                    this.jtaEcuaciones.append(" " + this.modeloRestricciones.getValueAt(fil, co));
                }
                else if (Double.parseDouble(String.valueOf(this.modeloRestricciones.getValueAt(fil, co))) >= 0.0) {
                    this.jtaEcuaciones.append(" + " + this.modeloRestricciones.getValueAt(fil, co) + "X" + co);
                }
                else {
                    this.jtaEcuaciones.append(" " + this.modeloRestricciones.getValueAt(fil, co) + " X" + co);
                }
            }
            this.jtaEcuaciones.append("\n");
        }
    }
    
    private void agregarComboBox(final int co, final JTable jtRestricciones) {
        final String[] Condicion = { "<=", ">=", "=", ">", "<" };
        final JComboBox jcb = new JComboBox((E[])Condicion);
        final TableColumn tc = jtRestricciones.getColumnModel().getColumn(co - 2);
        final TableCellEditor tce = new DefaultCellEditor(jcb);
        tc.setCellEditor(tce);
        jtRestricciones.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtRestricciones.getColumnModel().getColumn(co - 1).setPreferredWidth(80);
        jtRestricciones.getColumnModel().getColumn(co - 2).setPreferredWidth(30);
        for (int i = 1; i <= co - 2; ++i) {
            jtRestricciones.getColumnModel().getColumn(0).setPreferredWidth(80);
        }
        jtRestricciones.setRowHeight(25);
    }
    
    public void guardarArchivo(String ruta, final String nom) {
        int op = 0;
        if (!ruta.substring(ruta.length() - 5, ruta.length()).equalsIgnoreCase(".sipx")) {
            ruta += ".sipx";
        }
        final File f = new File(ruta);
        if (f.exists()) {
            op = JOptionPane.showConfirmDialog(this, nom + " Ya existe \n¿Desea reemplazarlo?", "Guardar", 2);
        }
        if (op == 0) {
            final Guardar g = new Guardar(this.modeloRestricciones, this.jcbObjetivo.getSelectedItem().toString());
            this.archivo.escribirFichero(ruta, g);
            this.setTitle(nom + " - Simplex");
            this.jDialog1.dispose();
        }
    }
    
    public void abrirArchivo(final String ruta, final String nombre) {
        final File f = new File(ruta);
        if (f.exists()) {
            try {
                this.jDialog1.dispose();
                final ArrayList<Guardar> guardar = (ArrayList<Guardar>)this.archivo.leeFichero(ruta);
                guardar.get(0).armarTabla(this.jtRestricciones);
                this.jcbObjetivo.setSelectedItem(guardar.get(0).getObjetivo());
                this.modeloRestricciones = guardar.get(0).getModeloRestricciones();
                this.agregarComboBox(this.modeloRestricciones.getColumnCount(), this.jtRestricciones);
                this.ventanaCoeficientes.setBounds(this.getX() + 100, this.getY() + 5, this.ventanaCoeficientes.getWidth(), this.ventanaCoeficientes.getHeight());
                this.ventanaCoeficientes.setVisible(true);
                this.Xn = this.modeloRestricciones.getColumnCount() - 3;
                this.jspvariables.setValue(this.Xn);
                this.Nrestricciones = this.modeloRestricciones.getRowCount() - 1;
                this.jspRest.setValue(this.Nrestricciones);
                this.setTitle(nombre + " - Simplex");
                this.jCheckBox1.setSelected(true);
                this.jCheckBox1ActionPerformed(null);
                this.limpiar = false;
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, nombre + "\nError al leer  archivo ", "Error!", 0);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "No se encuentra el Archivo\nCompruebe el nombre de archivo e intente de nuevo", "Abrir", 2);
        }
    }
    
    private boolean validar() {
        final int fila = this.modeloRestricciones.getRowCount();
        final int colum = this.modeloRestricciones.getColumnCount();
        for (int i = 0; i < fila; ++i) {
            for (int j = 1; j < colum && (i != 0 || j < colum - 2); ++j) {
                if (j != colum - 2) {
                    final String texto = String.valueOf(this.modeloRestricciones.getValueAt(i, j));
                    if (!texto.matches("([+-]{1})?[0-9]+(\\.[0-9]+)?([Ee]{1}([-]{1})?[1-9])?")) {
                        JOptionPane.showMessageDialog(this, "Al parecer faltan o hay datos incorrectos,\naseg\u00farese de no escribir espacios en \nblanco o los decimales con coma\u2026");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Component prepareEditor(final TableCellEditor editor, final int row, final int columna) {
        return null;
    }
    
    public void limpiarUltimaCelda() {
        for (int i = 0; i < this.Tablon.getRowCount(); ++i) {
            this.Tablon.setValueAt("", i, this.Tablon.getColumnCount() - 1);
        }
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
            Logger.getLogger(GuiSimplex.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(GuiSimplex.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(GuiSimplex.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(GuiSimplex.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiSimplex().setVisible(true);
            }
        });
    }
    
    private static boolean isNumeric(final String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
}
