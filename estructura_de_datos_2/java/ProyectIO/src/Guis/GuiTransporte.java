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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.io.File;
import javax.swing.border.SoftBevelBorder;
import java.awt.Cursor;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.filechooser.FileFilter;
import javax.swing.BoxLayout;
import javax.swing.AbstractButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.JTableHeader;
import java.awt.Color;
import javax.swing.table.TableCellRenderer;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFileChooser;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
//import Transprte.RssFeedCellRenderer;
//import Transprte.GuardarTransporte;
//import Transprte.Vogel;
//import Transprte.CostoMinimo;
//import Transprte.EsquinaNO;
import CrearTablas.CrearTablaTransporte;
//import Transprte.Datos;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
/**
 *
 * @author 57300
 */
public class GuiTransporte extends JFrame{
   public static int destinos;
    public static int origenes;
    public static DefaultTableModel modeloRestricciones;
    private DefaultTableModel modeloSolucion;
    public static Datos[][] datos;
    CrearTablaTransporte ct;
    EsquinaNO NO;
    CostoMinimo minimo;
    Vogel vogel;
    public static int extraRow;
    public static int extraColumn;
    public boolean artificialFila;
    public boolean artificialColumna;
    double demanda;
    double oferta;
    public static boolean corte;
    public static String repetidosNumeros;
    boolean guardar;
    GuardarTransporte guarda;
    RssFeedCellRenderer Renderizar;
    private ButtonGroup buttonGroup1;
    private JLabel info2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JCheckBox jCheckBox1;
    public static JDialog jDialog1;
    private JDialog jDialog2;
    private JFileChooser jFileChooser2;
    private JFrame jFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JSeparator jSeparator1;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTable jTable1;
    private JTextField jTextField2;
    private JComboBox jcbMeto;
    private JCheckBox jckbDestino;
    private JCheckBox jckbPlanta;
    private JSpinner jspDestinos;
    private JSpinner jspOrigen;
    private JTable jtRestricciones;
    private JTable jtSolucion;
    private JLabel jtfResultado;
    
    public GuiTransporte() {
        this.modeloSolucion = null;
        this.ct = new CrearTablaTransporte();
        this.artificialFila = false;
        this.artificialColumna = false;
        this.demanda = 0.0;
        this.oferta = 0.0;
        this.Renderizar = new RssFeedCellRenderer();
        this.initComponents();
        this.jtSolucion.setDefaultRenderer(Object.class, this.Renderizar);
        this.jtSolucion.setRowHeight(50);
        this.jtRestricciones.setRowHeight(25);
        this.jTable1.setRowHeight(22);
        GuiTransporte.destinos = Integer.parseInt("" + this.jspDestinos.getValue());
        GuiTransporte.origenes = Integer.parseInt("" + this.jspOrigen.getValue());
        new CrearTablaTransporte().crearTablaRestricciones(GuiTransporte.destinos, GuiTransporte.origenes, this.jtRestricciones, 0);
        GuiTransporte.jDialog1.setBounds(this.getX() + this.getWidth() / 2 - GuiTransporte.jDialog1.getWidth() / 2, this.getHeight() / 2 - GuiTransporte.jDialog1.getHeight() / 2, GuiTransporte.jDialog1.getWidth(), GuiTransporte.jDialog1.getHeight());
        this.jFrame1.setBounds(this.getX() + this.getWidth() / 2 - this.jFrame1.getWidth() / 2, this.getHeight() / 2 - this.jFrame1.getHeight() / 2, this.jFrame1.getWidth(), this.jFrame1.getHeight());
        final JTableHeader th = this.jtRestricciones.getTableHeader();
        th.setForeground(Color.red);
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
        this.jPanel1 = new JPanel();
        this.jcbMeto = new JComboBox();
        this.jPanel5 = new JPanel();
        this.jspOrigen = new JSpinner();
        this.jspDestinos = new JSpinner();
        this.jButton3 = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jPanel4 = new JPanel();
        this.jckbPlanta = new JCheckBox();
        this.jckbDestino = new JCheckBox();
        this.jButton7 = new JButton();
        GuiTransporte.jDialog1 = new JDialog();
        this.jPanel6 = new JPanel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jSeparator1 = new JSeparator();
        this.jButton6 = new JButton();
        this.jLabel5 = new JLabel();
        this.buttonGroup1 = new ButtonGroup();
        this.jDialog2 = new JDialog();
        this.jFileChooser2 = new JFileChooser();
        this.jScrollPane3 = new JScrollPane();
        this.jtSolucion = new JTable();
        this.jPanel7 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jtfResultado = new JLabel();
        this.jScrollPane4 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jLabel1 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem2 = new JMenuItem();
        this.jMenuItem1 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jFrame1.setTitle("Coeficientes");
        this.jFrame1.setMinimumSize(new Dimension(680, 610));
        this.jFrame1.setResizable(false);
        this.jFrame1.setState(100000);
        this.jFrame1.getContentPane().setLayout(null);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Coeficientes del Problema", 0, 0, new Font("Tahoma", 1, 14)));
        this.jPanel3.setLayout(null);
        this.jtRestricciones.setFont(new Font("Tahoma", 0, 14));
        this.jtRestricciones.setModel(new DefaultTableModel(new Object[][] { { "Origen 1", null, null, null }, { "Origen 2", null, null, null }, { "Demanda", null, null, null } }, new String[] { "", "Destino 1", "Destino 2", "Oferta" }));
        this.jtRestricciones.setAutoResizeMode(0);
        this.jtRestricciones.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent evt) {
                GuiTransporte.this.jtRestriccionesFocusGained(evt);
            }
        });
        this.jtRestricciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiTransporte.this.jtRestriccionesMousePressed(evt);
            }
        });
        this.jtRestricciones.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                GuiTransporte.this.jtRestriccionesKeyTyped(evt);
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
                GuiTransporte.this.jButton2MousePressed(evt);
            }
            
            @Override
            public void mouseReleased(final MouseEvent evt) {
                GuiTransporte.this.jButton2MouseReleased(evt);
            }
        });
        this.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jButton2);
        this.jButton2.setBounds(447, 390, 180, 40);
        this.jCheckBox1.setFont(new Font("Tahoma", 1, 12));
        this.jCheckBox1.setBorder(BorderFactory.createEtchedBorder());
        this.jCheckBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent evt) {
                GuiTransporte.this.jCheckBox1MousePressed(evt);
            }
        });
        this.jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jCheckBox1ActionPerformed(evt);
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
        this.jPanel3.setBounds(10, 118, 650, 450);
        this.jPanel8.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel8.setLayout(null);
        this.jPanel1.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel1.setLayout(null);
        this.jcbMeto.setFont(new Font("Tahoma", 1, 14));
        this.jcbMeto.setModel(new DefaultComboBoxModel<String>(new String[] { "Costo M\u00ednimo", "Esquina Noroeste", "Vogel" }));
        this.jcbMeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jcbMetoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jcbMeto);
        this.jcbMeto.setBounds(20, 24, 160, 34);
        this.jPanel8.add(this.jPanel1);
        this.jPanel1.setBounds(10, 10, 190, 80);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout(null);
        this.jspOrigen.setFont(new Font("Tahoma", 1, 18));
        this.jspOrigen.setModel(new SpinnerNumberModel(2, 1, 400, 1));
        this.jspOrigen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent evt) {
                GuiTransporte.this.jspOrigenStateChanged(evt);
            }
        });
        this.jPanel5.add(this.jspOrigen);
        this.jspOrigen.setBounds(80, 50, 80, 28);
        this.jspDestinos.setFont(new Font("Tahoma", 1, 18));
        this.jspDestinos.setModel(new SpinnerNumberModel(2, 2, 350, 1));
        this.jPanel5.add(this.jspDestinos);
        this.jspDestinos.setBounds(80, 10, 80, 28);
        this.jButton3.setFont(new Font("Tahoma", 1, 14));
        this.jButton3.setText("OK");
        this.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jButton3);
        this.jButton3.setBounds(170, 50, 60, 30);
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Origen");
        this.jPanel5.add(this.jLabel4);
        this.jLabel4.setBounds(10, 50, 110, 30);
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Destino");
        this.jPanel5.add(this.jLabel6);
        this.jLabel6.setBounds(10, 10, 130, 30);
        this.jPanel8.add(this.jPanel5);
        this.jPanel5.setBounds(210, 10, 250, 88);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder("Ficticia"));
        this.jPanel4.setLayout(null);
        this.jckbPlanta.setText("Planta ");
        this.jckbPlanta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jckbPlantaActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.jckbPlanta);
        this.jckbPlanta.setBounds(10, 15, 80, 30);
        this.jckbDestino.setText("Destino");
        this.jckbDestino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jckbDestinoActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.jckbDestino);
        this.jckbDestino.setBounds(10, 40, 80, 30);
        this.jPanel8.add(this.jPanel4);
        this.jPanel4.setBounds(470, 10, 100, 80);
        this.jButton7.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/imgres_1.jpg")));
        this.jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton7ActionPerformed(evt);
            }
        });
        this.jPanel8.add(this.jButton7);
        this.jButton7.setBounds(570, 18, 70, 70);
        this.jFrame1.getContentPane().add(this.jPanel8);
        this.jPanel8.setBounds(10, 10, 650, 100);
        GuiTransporte.jDialog1.setMinimumSize(new Dimension(260, 270));
        GuiTransporte.jDialog1.setResizable(false);
        GuiTransporte.jDialog1.getContentPane().setLayout(null);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder("Opciones"));
        this.jPanel6.setLayout(null);
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Origen");
        this.jPanel6.add(this.jRadioButton1);
        this.jRadioButton1.setBounds(20, 30, 80, 23);
        this.buttonGroup1.add(this.jRadioButton2);
        this.jRadioButton2.setText("Destino");
        this.jPanel6.add(this.jRadioButton2);
        this.jRadioButton2.setBounds(110, 30, 93, 20);
        this.jLabel3.setText("Posicion ");
        this.jPanel6.add(this.jLabel3);
        this.jLabel3.setBounds(30, 90, 80, 14);
        this.jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent evt) {
                GuiTransporte.this.jTextField2KeyTyped(evt);
            }
        });
        this.jPanel6.add(this.jTextField2);
        this.jTextField2.setBounds(90, 80, 100, 30);
        this.jPanel6.add(this.jSeparator1);
        this.jSeparator1.setBounds(10, 62, 210, 10);
        this.jButton6.setText("Analizar");
        this.jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton6ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.jButton6);
        this.jButton6.setBounds(70, 130, 100, 40);
        GuiTransporte.jDialog1.getContentPane().add(this.jPanel6);
        this.jPanel6.setBounds(10, 10, 230, 200);
        this.jLabel5.setFont(new Font("Tahoma", 0, 10));
        this.jLabel5.setText("34343");
        this.jLabel5.setBorder(BorderFactory.createEtchedBorder());
        GuiTransporte.jDialog1.getContentPane().add(this.jLabel5);
        this.jLabel5.setBounds(10, 210, 230, 20);
        this.jDialog2.setTitle("Abrir");
        this.jDialog2.setMinimumSize(new Dimension(643, 419));
        this.jDialog2.getContentPane().setLayout(new BoxLayout(this.jDialog2.getContentPane(), 2));
        this.jFileChooser2.setFileFilter(null);
        this.jFileChooser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jFileChooser2ActionPerformed(evt);
            }
        });
        this.jDialog2.getContentPane().add(this.jFileChooser2);
        this.setDefaultCloseOperation(3);
        this.setTitle("Transporte ");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent evt) {
                GuiTransporte.this.formWindowActivated(evt);
            }
        });
        this.getContentPane().setLayout(null);
        this.jtSolucion.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
        this.jtSolucion.setAutoResizeMode(0);
        this.jtSolucion.setCursor(new Cursor(0));
        this.jScrollPane3.setViewportView(this.jtSolucion);
        this.getContentPane().add(this.jScrollPane3);
        this.jScrollPane3.setBounds(10, 20, 750, 450);
        this.jPanel7.setBorder(new SoftBevelBorder(0));
        this.jPanel7.setLayout(null);
        this.jButton1.setFont(new Font("Tahoma", 1, 24));
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/pen67.png")));
        this.jButton1.setText("Coeficientes");
        this.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton1ActionPerformed(evt);
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
                GuiTransporte.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton4);
        this.jButton4.setBounds(490, 10, 240, 50);
        this.jButton5.setFont(new Font("Tahoma", 1, 18));
        this.jButton5.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logotype171.png")));
        this.jButton5.setText("Resolver");
        this.jButton5.setEnabled(false);
        this.jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton5);
        this.jButton5.setBounds(260, 10, 160, 50);
        this.getContentPane().add(this.jPanel7);
        this.jPanel7.setBounds(10, 480, 750, 70);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel2.setLayout(null);
        this.jLabel2.setFont(new Font("Tahoma", 1, 14));
        this.jLabel2.setText("Z =");
        this.jPanel2.add(this.jLabel2);
        this.jLabel2.setBounds(40, 30, 30, 30);
        this.jtfResultado.setBackground(new Color(255, 255, 255));
        this.jtfResultado.setBorder(BorderFactory.createTitledBorder(""));
        this.jtfResultado.setOpaque(true);
        this.jPanel2.add(this.jtfResultado);
        this.jtfResultado.setBounds(80, 30, 210, 30);
        this.jTable1.setModel(new DefaultTableModel(new Object[0][], new String[] { "Origen", "Destino", "Matriales", "Precio", "Sub Total" }));
        this.jTable1.setAutoResizeMode(0);
        this.jScrollPane4.setViewportView(this.jTable1);
        this.jPanel2.add(this.jScrollPane4);
        this.jScrollPane4.setBounds(10, 80, 290, 360);
        this.getContentPane().add(this.jPanel2);
        this.jPanel2.setBounds(770, 20, 310, 450);
        this.jLabel1.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel1);
        this.jLabel1.setBounds(10, 560, 430, 20);
        this.jLabel7.setText("Ingenier\u00eda de sistemas VI-- CECAR 2015 - Fredys vergara");
        this.jLabel7.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel7);
        this.jLabel7.setBounds(450, 560, 330, 20);
        this.jLabel8.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/logoC.jpg")));
        this.jLabel8.setBorder(BorderFactory.createEtchedBorder());
        this.getContentPane().add(this.jLabel8);
        this.jLabel8.setBounds(780, 490, 204, 54);
        this.jMenu1.setText("File");
        this.jMenuItem2.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/inicio.png")));
        this.jMenuItem2.setText("Inicio");
        this.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuItem1.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/salir.png")));
        this.jMenuItem1.setText("Salir");
        this.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                GuiTransporte.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("Edit");
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        this.setSize(new Dimension(1102, 650));
        this.setLocationRelativeTo(null);
    }
    
    private void jtRestriccionesFocusGained(final FocusEvent evt) {
    }
    
    private void jtRestriccionesMousePressed(final MouseEvent evt) {
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
    
    private void jButton2ActionPerformed(final ActionEvent evt) {
        final boolean resp = this.equilibarSistema();
        if (this.isNumeric(this.jtRestricciones) && resp) {
            GuiTransporte.destinos = Integer.parseInt("" + this.jspDestinos.getValue());
            GuiTransporte.origenes = Integer.parseInt("" + this.jspOrigen.getValue());
            this.ct.CrearTablaSolucion(this.jtRestricciones, this.jtSolucion, GuiTransporte.extraRow, GuiTransporte.extraColumn);
            if (this.jcbMeto.getSelectedIndex() == 1) {
                (this.NO = new EsquinaNO()).calcularDemandaOfretTotal(this.jtSolucion, 0, 0);
            }
            else if (this.jcbMeto.getSelectedIndex() == 0) {
                this.minimo = new CostoMinimo();
            }
            else if (this.jcbMeto.getSelectedIndex() == 2) {
                (this.vogel = new Vogel()).calcularmenoresColumnas(this.jtSolucion);
                this.vogel.calcularSumaMenoresFilas(this.jtSolucion);
                this.vogel.buscarMayorFilaColumna(this.jtSolucion);
            }
            this.jButton4.setEnabled(true);
            this.jButton5.setEnabled(true);
            this.jFrame1.setVisible(false);
        }
    }
    
    private void jCheckBox1MousePressed(final MouseEvent evt) {
        this.info2.setText(" Procesando\u2026");
    }
    
    private void jCheckBox1ActionPerformed(final ActionEvent evt) {
    }
    
    private void jspOrigenStateChanged(final ChangeEvent evt) {
        final int fi = Integer.parseInt(this.jspOrigen.getValue().toString());
        this.info2.setText(null);
        final String[] g = new String[GuiTransporte.destinos];
        if (fi > GuiTransporte.origenes) {
            for (int i = GuiTransporte.origenes + 1; i <= fi; ++i) {
                g[0] = "Demanda " + i;
                GuiTransporte.modeloRestricciones.addRow(g);
                for (int j = 0; j < GuiTransporte.modeloRestricciones.getColumnCount(); ++j) {
                    final String tem = "" + GuiTransporte.modeloRestricciones.getValueAt(GuiTransporte.modeloRestricciones.getRowCount() - 2, j);
                    if (!tem.equals("null")) {
                        GuiTransporte.modeloRestricciones.setValueAt(tem, GuiTransporte.modeloRestricciones.getRowCount() - 1, j);
                    }
                    GuiTransporte.modeloRestricciones.setValueAt("", GuiTransporte.modeloRestricciones.getRowCount() - 2, j);
                }
                GuiTransporte.modeloRestricciones.setValueAt("Origen " + i, GuiTransporte.modeloRestricciones.getRowCount() - 2, 0);
                GuiTransporte.modeloRestricciones.setValueAt("", GuiTransporte.modeloRestricciones.getRowCount() - 1, GuiTransporte.modeloRestricciones.getColumnCount() - 1);
            }
            GuiTransporte.origenes = fi;
        }
        else if (fi < GuiTransporte.origenes) {
            while (GuiTransporte.origenes != fi) {
                GuiTransporte.modeloRestricciones.removeRow(GuiTransporte.origenes - 1);
                --GuiTransporte.origenes;
            }
        }
        this.jCheckBox1ActionPerformed(null);
    }
    
    private void jButton3ActionPerformed(final ActionEvent evt) {
        GuiTransporte.destinos = Integer.parseInt("" + this.jspDestinos.getValue());
        GuiTransporte.origenes = Integer.parseInt("" + this.jspOrigen.getValue());
        new CrearTablaTransporte().crearTablaRestricciones(GuiTransporte.destinos, GuiTransporte.origenes, this.jtRestricciones, 0);
        this.jckbPlanta.setSelected(false);
        this.jckbDestino.setSelected(false);
        this.artificialColumna = false;
        this.artificialFila = false;
        this.info2.setBackground(new Color(240, 240, 240));
        this.info2.setText(null);
    }
    
    private void jButton1ActionPerformed(final ActionEvent evt) {
        this.jFrame1.setVisible(true);
    }
    
    private void jButton4ActionPerformed(final ActionEvent evt) {
        if (this.jcbMeto.getSelectedIndex() == 1) {
            if (this.NO.noroeste(this.jtSolucion, this.modeloSolucion)) {
                this.jLabel1.setText(" Fin del proceso");
                this.enviar();
                this.jButton4.setEnabled(false);
            }
            this.jtSolucion.setValueAt("", 0, 0);
        }
        if (this.jcbMeto.getSelectedIndex() == 0) {
            if (this.minimo.costoMinimo(this.jtSolucion)) {
                this.jLabel1.setText(" Fin del proceso");
                this.enviar();
                this.jButton4.setEnabled(false);
            }
            this.jtSolucion.setValueAt("", 0, 0);
        }
        if (this.jcbMeto.getSelectedIndex() == 2) {
            if (this.vogel.calcularVogel(this.jtSolucion)) {
                this.vogel.calcularVogel(this.jtSolucion);
                this.jLabel1.setText(" Fin del proceso");
                this.enviar();
            }
            this.jtSolucion.setValueAt("", 0, 0);
        }
        this.jtfResultado.setText("" + this.calularTotal());
    }
    
    private void jButton5ActionPerformed(final ActionEvent evt) {
        boolean fin = false;
        GuiTransporte.corte = false;
        while (!fin) {
            if (this.jcbMeto.getSelectedIndex() == 1 && this.NO.noroeste(this.jtSolucion, this.modeloSolucion)) {
                this.jLabel1.setText(" Fin del proceso");
                this.enviar();
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
                fin = true;
            }
            if (this.jcbMeto.getSelectedIndex() == 0) {
                if (this.minimo.costoMinimo(this.jtSolucion)) {
                    this.jLabel1.setText(" Fin del proceso");
                    this.enviar();
                    this.jButton4.setEnabled(false);
                    this.jButton5.setEnabled(false);
                    fin = true;
                }
                this.jtSolucion.setValueAt("", 0, 0);
            }
            if (this.jcbMeto.getSelectedIndex() == 2) {
                this.vogel.calcularmenoresColumnas(this.jtSolucion);
                this.vogel.calcularSumaMenoresFilas(this.jtSolucion);
                this.vogel.buscarMayorFilaColumna(this.jtSolucion);
                if (this.vogel.getFilaMayor() >= 0 && this.vogel.getColumnaMayor() >= 0) {
                    this.vogel.buscarCostoMenor();
                    this.vogel.agr(this.jtSolucion);
                }
                else {
                    fin = true;
                    this.enviar();
                    this.jLabel1.setText(" Fin del proceso");
                    this.jButton4.setEnabled(false);
                    this.jButton5.setEnabled(false);
                }
            }
        }
        this.jtfResultado.setText("" + this.calularTotal());
    }
    
    private void jButton2MouseReleased(final MouseEvent evt) {
    }
    
    private void formWindowActivated(final WindowEvent evt) {
    }
    
    private void jcbMetoActionPerformed(final ActionEvent evt) {
        GuiTransporte.repetidosNumeros = null;
        if (this.jcbMeto.getSelectedIndex() == 0 || this.jcbMeto.getSelectedIndex() == 1) {
            GuiTransporte.extraRow = 0;
            GuiTransporte.extraColumn = 0;
        }
        else {
            GuiTransporte.extraRow = 1;
            GuiTransporte.extraColumn = 1;
        }
        this.info2.setBackground(new Color(240, 240, 240));
        this.info2.setText(null);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);
    }
    
    private void jckbPlantaActionPerformed(final ActionEvent evt) {
        this.info2.setBackground(new Color(240, 240, 240));
        this.info2.setText(null);
        if (this.jckbDestino.isSelected()) {
            this.eliminarColumna();
        }
        this.calcularDemandaOfretTotal(this.jtSolucion, 0, 0);
        this.jckbDestino.setSelected(false);
        if (!this.jckbPlanta.isSelected()) {
            this.eliminaFila();
        }
        else {
            this.agregarFila();
        }
    }
    
    private void jckbDestinoActionPerformed(final ActionEvent evt) {
        this.info2.setBackground(new Color(240, 240, 240));
        this.info2.setText(null);
        if (this.jckbPlanta.isSelected()) {
            this.eliminaFila();
        }
        this.calcularDemandaOfretTotal(this.jtRestricciones, 0, 0);
        this.jckbPlanta.setSelected(false);
        if (!this.jckbDestino.isSelected()) {
            this.eliminarColumna();
        }
        else {
            this.agregarColumna();
        }
    }
    
    private void jButton7ActionPerformed(final ActionEvent evt) {
        this.info2.setBackground(new Color(240, 240, 240));
        this.info2.setText(null);
        if (this.artificialColumna) {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 0, 1);
            GuiTransporte.modeloRestricciones.setValueAt(this.oferta - this.demanda, GuiTransporte.modeloRestricciones.getRowCount() - 1, GuiTransporte.modeloRestricciones.getColumnCount() - 2);
        }
        else if (this.artificialFila) {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 1, 0);
            GuiTransporte.modeloRestricciones.setValueAt(this.oferta - this.demanda, GuiTransporte.modeloRestricciones.getRowCount() - 2, GuiTransporte.modeloRestricciones.getColumnCount() - 1);
        }
        else {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 0, 0);
        }
        if (this.oferta == this.demanda) {
            if (this.artificialFila) {
                this.eliminaFila();
                this.artificialFila = false;
                this.jckbPlanta.setSelected(false);
            }
            else if (this.artificialColumna) {
                this.eliminarColumna();
                this.artificialColumna = false;
                this.jckbDestino.setSelected(false);
            }
        }
        else if (this.oferta != this.demanda) {
            if (this.oferta > this.demanda && this.artificialFila) {
                this.eliminaFila();
                this.artificialFila = false;
                this.jckbPlanta.setSelected(false);
                this.agregarColumna();
                this.artificialColumna = true;
                this.jckbDestino.setSelected(true);
            }
            else if (this.oferta < this.demanda && this.artificialColumna) {
                this.eliminarColumna();
                this.artificialColumna = false;
                this.jckbDestino.setSelected(false);
                this.agregarFila();
                this.artificialFila = true;
                this.jckbPlanta.setSelected(true);
            }
        }
        if (!this.artificialColumna && !this.artificialFila) {
            if (this.oferta < this.demanda) {
                this.agregarFila();
                this.artificialFila = true;
                this.jckbPlanta.setSelected(true);
            }
            else if (this.oferta > this.demanda) {
                this.agregarColumna();
                this.artificialColumna = true;
                this.jckbDestino.setSelected(true);
            }
        }
    }
    
    private void jButton6ActionPerformed(final ActionEvent evt) {
        final int f = this.jtSolucion.getRowCount();
        final int c = this.jtSolucion.getColumnCount();
        if (!this.jTextField2.getText().isEmpty()) {
            final int p = Integer.parseInt(this.jTextField2.getText());
            if (this.jRadioButton1.isSelected()) {
                if (p > 0 && p < f - 2) {
                    if (this.vogel.existe(p, c - 1, this.jtSolucion)) {
                        this.vogel.setFilaMayor(p);
                        this.vogel.setBuscarPorColumna(false);
                        this.vogel.buscarCostoMenor();
                        this.vogel.agr(this.jtSolucion);
                        GuiTransporte.jDialog1.setVisible(false);
                        this.jtSolucion.setValueAt("", 0, 0);
                    }
                    else {
                        this.jLabel5.setText("Seleccion Incorrecta ");
                    }
                }
                else {
                    this.jLabel5.setText("Posici\u00f3n Incorrecta");
                }
            }
            else if (this.jRadioButton2.isSelected()) {
                if (p > 0 && p < c - 2) {
                    if (this.vogel.existe(f - 1, p, this.jtSolucion)) {
                        this.vogel.setColumnaMayor(p);
                        this.vogel.setBuscarPorColumna(true);
                        this.vogel.buscarCostoMenor();
                        this.vogel.agr(this.jtSolucion);
                        GuiTransporte.jDialog1.setVisible(false);
                        this.jtSolucion.setValueAt("", 0, 0);
                    }
                    else {
                        this.jLabel5.setText("Seleccion Incorrecta ");
                    }
                }
                else {
                    this.jLabel5.setText("Posici\u00f3n Incorrecta");
                }
            }
        }
        else {
            this.jLabel5.setText("Ingrese una Posici\u00f3n");
        }
    }
    
    private void jTextField2KeyTyped(final KeyEvent evt) {
        final char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        this.jLabel5.setText(null);
    }
    
    private void jMenuItem1ActionPerformed(final ActionEvent evt) {
        System.exit(0);
    }
    
    private void jMenuItem2ActionPerformed(final ActionEvent evt) {
        new GuiInicio().setVisible(true);
        this.dispose();
    }
    
    private void jFileChooser2ActionPerformed(final ActionEvent evt) {
        this.guarda = new GuardarTransporte("" + this.jcbMeto.getSelectedItem(), this.artificialFila, this.artificialColumna);
        final JFileChooser seChooser = (JFileChooser)evt.getSource();
        final String comando = evt.getActionCommand();
        if (comando.equals("ApproveSelection")) {
            final File archivoSelecciondo = seChooser.getSelectedFile();
            final String ruta = archivoSelecciondo.getAbsolutePath();
            if (!this.guardar) {
                this.guarda.guardarArchivo(ruta, ruta, this.guarda);
            }
        }
        else {
            GuiTransporte.jDialog1.dispose();
        }
    }
    
    public boolean equilibarSistema() {
        this.info2.setBackground(new Color(253, 177, 177));
        if (this.artificialColumna) {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 0, 1);
        }
        else if (this.artificialFila) {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 1, 0);
        }
        else {
            this.calcularDemandaOfretTotal(this.jtRestricciones, 0, 0);
        }
        if (this.oferta == this.demanda) {
            if (this.artificialFila) {
                this.info2.setText("Planta Artificial innecesaria");
                return false;
            }
            if (this.artificialColumna) {
                this.info2.setText("Destino Artificial innecesario");
                return false;
            }
        }
        else if (this.oferta != this.demanda) {
            if (this.oferta > this.demanda && this.artificialFila) {
                this.info2.setText("Sistema Mal equilibrado");
                return false;
            }
            if (this.oferta < this.demanda && this.artificialColumna) {
                this.info2.setText("Sistema Mal equilibrado");
                return false;
            }
        }
        if (!this.artificialColumna && !this.artificialFila) {
            if (this.oferta < this.demanda) {
                this.info2.setText("La Oferta No Satisface la demanda");
                return false;
            }
            if (this.oferta > this.demanda) {
                this.info2.setText("La Demanda No Satisface la oferta");
                return false;
            }
        }
        this.info2.setBackground(new Color(240, 240, 240));
        return true;
    }
    
    void eliminaFila() {
        this.artificialFila = false;
        GuiTransporte.modeloRestricciones.removeRow(GuiTransporte.modeloRestricciones.getRowCount() - 2);
    }
    
    void agregarColumna() {
        this.artificialColumna = true;
        GuiTransporte.modeloRestricciones.addColumn("Oferta");
        this.renombrarColumn("Ficticio", this.jtRestricciones);
        this.trasladorDatos(this.jtRestricciones);
        GuiTransporte.modeloRestricciones.setValueAt(this.oferta - this.demanda, GuiTransporte.modeloRestricciones.getRowCount() - 1, GuiTransporte.modeloRestricciones.getColumnCount() - 2);
    }
    
    void eliminarColumna() {
        this.artificialColumna = false;
        final String[][] tem = this.extrar(this.jtRestricciones, 1);
        new CrearTablaTransporte().crearTablaRestricciones(GuiTransporte.destinos, GuiTransporte.origenes, this.jtRestricciones, 0);
        for (int i = 0; i < tem.length; ++i) {
            for (int j = 1; j < tem[i].length; ++j) {
                GuiTransporte.modeloRestricciones.setValueAt(tem[i][j], i, j);
            }
        }
    }
    
    void agregarFila() {
        this.artificialFila = true;
        GuiTransporte.modeloRestricciones.addRow(new String[] { "Demanda" });
        final int p = GuiTransporte.modeloRestricciones.getRowCount();
        for (int i = 0; i < GuiTransporte.modeloRestricciones.getColumnCount(); ++i) {
            String temp = "" + GuiTransporte.modeloRestricciones.getValueAt(p - 2, i);
            if (String.valueOf(GuiTransporte.modeloRestricciones.getValueAt(p - 2, i)).equalsIgnoreCase("null")) {
                temp = "";
            }
            GuiTransporte.modeloRestricciones.setValueAt(temp, p - 1, i);
            if (i == 0) {
                GuiTransporte.modeloRestricciones.setValueAt("Ficticio", p - 2, i);
            }
            else {
                GuiTransporte.modeloRestricciones.setValueAt("0", p - 2, i);
            }
        }
        GuiTransporte.modeloRestricciones.setValueAt(this.demanda - this.oferta, GuiTransporte.modeloRestricciones.getRowCount() - 2, GuiTransporte.modeloRestricciones.getColumnCount() - 1);
    }
    
    public void renombrarColumn(final String nom, final JTable t) {
        final JTableHeader th = t.getTableHeader();
        final TableColumnModel tcm = th.getColumnModel();
        final TableColumn tc = tcm.getColumn(t.getColumnCount() - 2);
        tc.setHeaderValue("Ficticio");
        th.repaint();
    }
    
    public void trasladorDatos(final JTable t) {
        for (int f = 0; f < t.getRowCount() - 1; ++f) {
            t.setValueAt(t.getValueAt(f, t.getColumnCount() - 2), f, t.getColumnCount() - 1);
            t.setValueAt(0, f, t.getColumnCount() - 2);
        }
    }
    
    public String[][] extrar(final JTable t, final int c) {
        final String[][] tem = new String[t.getRowCount()][t.getColumnCount() - c];
        for (int i = 0; i < t.getRowCount(); ++i) {
            for (int j = 0; j < t.getColumnCount() - 2; ++j) {
                if (String.valueOf(t.getValueAt(i, j)).equalsIgnoreCase("null")) {
                    tem[i][j] = "";
                }
                else {
                    tem[i][j] = "" + t.getValueAt(i, j);
                }
            }
        }
        final int p = t.getColumnCount();
        for (int k = 0; k < t.getRowCount() - 1; ++k) {
            if (String.valueOf(t.getValueAt(k, p - 1)).equalsIgnoreCase("null")) {
                tem[k][p - c - 1] = "";
            }
            else {
                tem[k][p - c - 1] = "" + t.getValueAt(k, p - 1);
            }
        }
        return tem;
    }
    
    public void calcularDemandaOfretTotal(final JTable tableSolucion, final int extraf, final int extraC) {
        this.demanda = 0.0;
        this.oferta = 0.0;
        for (int i = 1; i < this.jtRestricciones.getColumnCount() - 1 - extraC; ++i) {
            try {
                this.demanda += Double.parseDouble("" + this.jtRestricciones.getValueAt(this.jtRestricciones.getRowCount() - 1, i));
            }
            catch (Exception ex) {}
        }
        for (int i = 0; i < this.jtRestricciones.getRowCount() - 1 - extraf; ++i) {
            try {
                this.oferta += Double.parseDouble("" + this.jtRestricciones.getValueAt(i, this.jtRestricciones.getColumnCount() - 1));
            }
            catch (Exception ex2) {}
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
            Logger.getLogger(GuiTransporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex2) {
            Logger.getLogger(GuiTransporte.class.getName()).log(Level.SEVERE, null, ex2);
        }
        catch (IllegalAccessException ex3) {
            Logger.getLogger(GuiTransporte.class.getName()).log(Level.SEVERE, null, ex3);
        }
        catch (UnsupportedLookAndFeelException ex4) {
            Logger.getLogger(GuiTransporte.class.getName()).log(Level.SEVERE, null, ex4);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiTransporte().setVisible(true);
            }
        });
    }
    
    private boolean isNumeric(final JTable t) {
        for (int i = 0; i < t.getRowCount(); ++i) {
            for (int j = 1; j < t.getColumnCount(); ++j) {
                try {
                    if (i == t.getRowCount() - 1 && j == t.getColumnCount() - 1) {
                        return true;
                    }
                    if (i == t.getRowCount() - 1 || j == t.getColumnCount() - 1) {
                        Double.parseDouble("" + t.getValueAt(i, j));
                    }
                    else if (!"-".equals("" + t.getValueAt(i, j))) {
                        Double.parseDouble("" + t.getValueAt(i, j));
                    }
                }
                catch (NumberFormatException nfe) {
                    this.info2.setText("Dato Incorrecto ' " + t.getValueAt(i, j) + " '");
                    this.info2.setBackground(new Color(253, 177, 177));
                    return false;
                }
            }
        }
        return true;
    }
    
    public void enviar() {
        final Object[] cabeza = { "Origen", "Destino", "Material", "Precio", "Sub Total" };
        final DefaultTableModel mode = new DefaultTableModel(cabeza, 0) {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        final String[] row = new String[5];
        for (int i = 0; i < GuiTransporte.datos.length; ++i) {
            for (int j = 0; j < GuiTransporte.datos[0].length; ++j) {
                if (GuiTransporte.datos[i][j].getCantidad() > 0.0) {
                    row[0] = "" + (i + 1);
                    row[1] = "" + (j + 1);
                    row[2] = "" + GuiTransporte.datos[i][j].getCantidad();
                    row[3] = "" + GuiTransporte.datos[i][j].getPrecio();
                    row[4] = "" + GuiTransporte.datos[i][j].getCantidad() * Double.parseDouble(GuiTransporte.datos[i][j].getPrecio());
                    mode.addRow(row);
                }
            }
        }
        this.jTable1.setModel(mode);
    }
    
    double calularTotal() {
        double total = 0.0;
        for (int i = 0; i < GuiTransporte.datos.length; ++i) {
            for (int j = 0; j < GuiTransporte.datos[i].length; ++j) {
                if (!GuiTransporte.datos[i][j].getPrecio().equalsIgnoreCase("-")) {
                    total += Double.parseDouble(GuiTransporte.datos[i][j].getPrecio()) * GuiTransporte.datos[i][j].getCantidad();
                }
            }
        }
        return total;
    }
    
    static {
        GuiTransporte.destinos = 0;
        GuiTransporte.modeloRestricciones = null;
        GuiTransporte.extraRow = 0;
        GuiTransporte.extraColumn = 0;
        GuiTransporte.corte = true;
    }
}
