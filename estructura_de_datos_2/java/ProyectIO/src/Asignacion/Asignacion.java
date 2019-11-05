/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

import Guis.GuiAsignacion;
import javax.swing.JTable;

/**
 *
 * @author 57300
 */
public class Asignacion {
   private int filaCerosManor;
    private int columnaCerosManor;
    private boolean ganoFila;
    private double Menor;
    private int cantifadaR;
    private int filaAsiganar;
    private int columnaAsignar;
    
    public Asignacion() {
        this.ganoFila = true;
    }
    
    public void inicirBusqueda(final JTable tabla) {
        this.cantifadaR = 0;
        while (this.faltaSintachar(tabla)) {
            this.cantidadCeroMayor(tabla);
            this.tachar(tabla);
        }
        System.out.println("Canti r" + this.cantifadaR);
    }
    
    public void tachar(final JTable tabla) {
        final int fila = GuiAsignacion.datosAsignacio.length;
        final int columna = GuiAsignacion.datosAsignacio[0].length;
        if (this.ganoFila && this.filaCerosManor > 0) {
            for (int col = 0; col < columna; ++col) {
                if (GuiAsignacion.datosAsignacio[this.filaCerosManor - 1][col].isRayado()) {
                    GuiAsignacion.datosAsignacio[this.filaCerosManor - 1][col].setDobleRayado(true);
                }
                else {
                    GuiAsignacion.datosAsignacio[this.filaCerosManor - 1][col].setRayado(true);
                }
            }
            ++this.cantifadaR;
        }
        else if (this.columnaCerosManor > 0) {
            for (int fil = 0; fil < fila; ++fil) {
                if (GuiAsignacion.datosAsignacio[fil][this.columnaCerosManor - 1].isRayado()) {
                    GuiAsignacion.datosAsignacio[fil][this.columnaCerosManor - 1].setDobleRayado(true);
                }
                else {
                    GuiAsignacion.datosAsignacio[fil][this.columnaCerosManor - 1].setRayado(true);
                }
            }
            ++this.cantifadaR;
        }
    }
    
    public void cantidadCeroMayor(final JTable tabla) {
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        int cantiFil = 0;
        int cantiCol = 0;
        int cantiTotal = 0;
        this.filaCerosManor = 0;
        this.columnaCerosManor = 0;
        for (int fil = 1; fil < fila - 1; ++fil) {
            cantiFil = 0;
            for (int col = 1; col < columna - 1; ++col) {
                final double valor = Double.parseDouble("" + tabla.getValueAt(fil, col));
                if (valor == 0.0 && !GuiAsignacion.datosAsignacio[fil - 1][col - 1].isRayado()) {
                    ++cantiFil;
                }
            }
            if (cantiFil > cantiTotal) {
                this.filaCerosManor = fil;
                this.ganoFila = true;
                cantiTotal = cantiFil;
            }
        }
        for (int co = 1; co < columna - 1; ++co) {
            cantiCol = 0;
            for (int fil2 = 1; fil2 < fila - 1; ++fil2) {
                final double valor = Double.parseDouble("" + tabla.getValueAt(fil2, co));
                if (valor == 0.0 && !GuiAsignacion.datosAsignacio[fil2 - 1][co - 1].isRayado()) {
                    ++cantiCol;
                }
            }
            if (cantiCol > cantiTotal) {
                this.columnaCerosManor = co;
                this.ganoFila = false;
                cantiTotal = cantiCol;
            }
        }
    }
    
    public void buscarMenorFila(final JTable tabla) {
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        for (int i = 1; i < fila - 1; ++i) {
            double auxMenor = Double.MAX_VALUE;
            for (int j = 1; j < columna - 1; ++j) {
                final double menor = Double.parseDouble("" + tabla.getValueAt(i, j));
                if (menor < auxMenor) {
                    auxMenor = menor;
                }
            }
            tabla.setValueAt("" + auxMenor, i, columna - 1);
        }
    }
    
    public void buscarMenorcolumna(final JTable tabla) {
        final int fila = tabla.getRowCount();
        for (int columna = tabla.getColumnCount(), col = 1; col < columna - 1; ++col) {
            double auxMenor = Double.MAX_VALUE;
            for (int fil = 1; fil < fila - 1; ++fil) {
                final double menor = Double.parseDouble("" + tabla.getValueAt(fil, col));
                if (menor < auxMenor) {
                    auxMenor = menor;
                }
            }
            tabla.setValueAt("" + auxMenor, fila - 1, col);
        }
    }
    
    public void restarMenorFila(final JTable tabla) {
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila - 1; ++fil) {
            final double menor = Double.parseDouble("" + tabla.getValueAt(fil, columna - 1));
            for (int col = 1; col < columna - 1; ++col) {
                final double tem = Double.parseDouble("" + tabla.getValueAt(fil, col));
                tabla.setValueAt(tem - menor, fil, col);
            }
        }
    }
    
    public void restarMenorColuma(final JTable tabla) {
        final int fila = tabla.getRowCount();
        for (int columna = tabla.getColumnCount(), col = 1; col < columna - 1; ++col) {
            final double menor = Double.parseDouble("" + tabla.getValueAt(fila - 1, col));
            for (int fil = 1; fil < fila - 1; ++fil) {
                final double tem = Double.parseDouble("" + tabla.getValueAt(fil, col));
                tabla.setValueAt(tem - menor, fil, col);
            }
        }
    }
    
    public boolean faltaSintachar(final JTable tabla) {
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila - 1; ++fil) {
            for (int col = 1; col < columna - 1; ++col) {
                if (!GuiAsignacion.datosAsignacio[fil - 1][col - 1].isRayado() && Double.parseDouble("" + tabla.getValueAt(fil, col)) == 0.0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void quitarRayas() {
        final int fila = GuiAsignacion.datosAsignacio.length;
        final int columna = GuiAsignacion.datosAsignacio[0].length;
        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                GuiAsignacion.datosAsignacio[i][j].setDobleRayado(false);
                GuiAsignacion.datosAsignacio[i][j].setRayado(false);
            }
        }
    }
    
    public void buscarMenorTabla(final JTable tabla) {
        this.Menor = Double.MAX_VALUE;
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila - 1; ++fil) {
            for (int col = 1; col < columna - 1; ++col) {
                if (!GuiAsignacion.datosAsignacio[fil - 1][col - 1].isRayado()) {
                    final double tem = Double.parseDouble("" + tabla.getValueAt(fil, col));
                    if (tem < this.Menor) {
                        this.Menor = tem;
                    }
                }
            }
        }
    }
    
    public void sumarMenor(final JTable tabla) {
        final int fila = tabla.getRowCount();
        final int columna = tabla.getColumnCount();
        for (int fil = 1; fil < fila - 1; ++fil) {
            for (int col = 1; col < columna - 1; ++col) {
                final double tem = Double.parseDouble("" + tabla.getValueAt(fil, col));
                if (GuiAsignacion.datosAsignacio[fil - 1][col - 1].isDobleRayado()) {
                    tabla.setValueAt("" + (tem + this.Menor), fil, col);
                }
                else if (!GuiAsignacion.datosAsignacio[fil - 1][col - 1].isRayado()) {
                    tabla.setValueAt("" + (tem - this.Menor), fil, col);
                }
            }
        }
    }
    
    public int getCantifadaR() {
        return this.cantifadaR;
    }
    
    public void buscarSoloCeroFila(final JTable tablaSolucion) {
        final int fila = tablaSolucion.getRowCount();
        final int columna = tablaSolucion.getColumnCount();
        int canti = 0;
        for (int fi = 1; fi < fila - 1; ++fi) {
            canti = 0;
            this.filaAsiganar = fi;
            for (int co = 1; co < columna - 1; ++co) {
                if (!GuiAsignacion.datosAsignacio[fi - 1][co - 1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(fi, co)).equalsIgnoreCase(" ")) {
                    final double dato = Double.parseDouble("" + tablaSolucion.getValueAt(fi, co));
                    if (dato == 0.0) {
                        ++canti;
                        this.columnaAsignar = co;
                    }
                }
            }
            if (canti == 1) {
                this.eliminarAlternativaFila(this.filaAsiganar, tablaSolucion);
                this.eliminarAlternativaColumna(this.columnaAsignar, tablaSolucion);
            }
        }
        if (!this.todosAsiganos()) {
            this.buscarSoloCeroColumna(tablaSolucion);
        }
    }
    
    public void buscarSoloCeroColumna(final JTable tablaSolucion) {
        final int fila = tablaSolucion.getRowCount();
        final int columna = tablaSolucion.getColumnCount();
        int canti = 0;
        for (int c = 1; c < columna - 1; ++c) {
            canti = 0;
            this.columnaAsignar = c;
            for (int f = 1; f < fila - 1; ++f) {
                if (!GuiAsignacion.datosAsignacio[f - 1][c - 1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(f, c)).equalsIgnoreCase(" ")) {
                    final double dato = Double.parseDouble("" + tablaSolucion.getValueAt(f, c));
                    if (dato == 0.0) {
                        ++canti;
                        this.filaAsiganar = f;
                    }
                }
            }
            if (canti == 1) {
                this.eliminarAlternativaColumna(this.columnaAsignar, tablaSolucion);
                this.eliminarAlternativaFila(this.filaAsiganar, tablaSolucion);
            }
        }
        if (!this.todosAsiganos()) {
            this.elegirUno(tablaSolucion);
        }
    }
    
    public void eliminarAlternativaFila(final int fil, final JTable tablaSolucion) {
        for (int columna = tablaSolucion.getColumnCount(), c = 1; c < columna - 1; ++c) {
            if (c != this.columnaAsignar) {
                tablaSolucion.setValueAt(" ", fil, c);
            }
            else {
                GuiAsignacion.datosAsignacio[fil - 1][c - 1].setColorea(true);
            }
            GuiAsignacion.datosAsignacio[fil - 1][c - 1].setAsignado(true);
        }
    }
    
    public void eliminarAlternativaColumna(final int col, final JTable tablaSolucion) {
        for (int fila = tablaSolucion.getRowCount(), f = 1; f < fila - 1; ++f) {
            if (f != this.filaAsiganar) {
                tablaSolucion.setValueAt(" ", f, col);
            }
            else {
                GuiAsignacion.datosAsignacio[f - 1][col - 1].setColorea(true);
            }
            GuiAsignacion.datosAsignacio[f - 1][col - 1].setAsignado(true);
        }
    }
    
    public boolean todosAsiganos() {
        final int fila = GuiAsignacion.datosAsignacio.length;
        final int columna = GuiAsignacion.datosAsignacio[0].length;
        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                if (!GuiAsignacion.datosAsignacio[i][j].isAsignado()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void elegirUno(final JTable tablaSolucion) {
        final int fila = tablaSolucion.getRowCount();
        final int columna = tablaSolucion.getColumnCount();
        for (int i = 1; i < fila - 1; ++i) {
            for (int j = 1; j < columna - 1; ++j) {
                if (!GuiAsignacion.datosAsignacio[i - 1][j - 1].isAsignado() && !String.valueOf(tablaSolucion.getValueAt(i, j)).equalsIgnoreCase(" ")) {
                    final double dato = Double.parseDouble("" + tablaSolucion.getValueAt(i, j));
                    if (dato == 0.0) {
                        this.filaAsiganar = i;
                        this.columnaAsignar = j;
                        this.eliminarAlternativaFila(this.filaAsiganar, tablaSolucion);
                        this.eliminarAlternativaColumna(this.columnaAsignar, tablaSolucion);
                        this.buscarSoloCeroFila(tablaSolucion);
                        return;
                    }
                }
            }
        }
    }
}
