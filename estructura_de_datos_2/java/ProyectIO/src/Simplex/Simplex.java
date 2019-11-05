/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simplex;

import java.awt.Color;
import Guis.GuiSimplex;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 57300
 */
public class Simplex {
   public static int columnaMayor;
    public static int filalaMenor;
    public static int ntablones;
    public static double pivote;
    private static int posicioSubstringAnteM;
    public static boolean todosMenor;

    public static void calcularZj(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        double suamMs = 0.0;
        double sumaNumeros = 0.0;
        for (int col = 1; col < colum - 1; ++col) {
            if (col != colum - 3) {
                suamMs = 0.0;
                sumaNumeros = 0.0;
                for (int fil = 2; fil < fila - 2; ++fil) {
                    final String valor = String.valueOf(modeloSolucion.getValueAt(fil, 0));
                    if (contieneM(valor)) {
                        suamMs += Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(fil, col)));
                    }
                    else {
                        final double xb = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(fil, 0)));
                        final double x = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(fil, col)));
                        sumaNumeros += xb * x;
                    }
                }
                if (sumaNumeros == 0.0 && suamMs == 0.0) {
                    modeloSolucion.setValueAt("0", fila - 2, col);
                }
                else if (sumaNumeros == 0.0) {
                    modeloSolucion.setValueAt("" + suamMs + "M", fila - 2, col);
                }
                else if (suamMs == 0.0) {
                    modeloSolucion.setValueAt(sumaNumeros, fila - 2, col);
                }
                else if (sumaNumeros > 0.0) {
                    modeloSolucion.setValueAt("" + suamMs + "M+" + sumaNumeros, fila - 2, col);
                }
                else {
                    modeloSolucion.setValueAt("" + suamMs + "M" + sumaNumeros, fila - 2, col);
                }
            }
        }
    }

    public static void calcularCj_Zj(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        for (int colum = modeloSolucion.getColumnCount(), col = 1; col < colum - 3; ++col) {
            final String aux1 = String.valueOf(modeloSolucion.getValueAt(0, col));
            final String aux2 = String.valueOf(modeloSolucion.getValueAt(fila - 2, col));
            if (!contieneM(aux1) && !contieneM(aux2)) {
                final double cj = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(0, col)));
                final double zj = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(fila - 2, col)));
                if (cj - zj == 0.0) {
                    modeloSolucion.setValueAt(0, fila - 1, col);
                }
                else {
                    modeloSolucion.setValueAt(cj - zj, fila - 1, col);
                }
            }
            else if (!contieneM(aux1) && contieneM(aux2)) {
                double cj = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(0, col)));
                cj += -1.0 * subnumero(aux2);
                final double auxiliar = -1.0 * subNumeroAnteM(aux2);
                if (cj == 0.0) {
                    modeloSolucion.setValueAt("" + auxiliar + "M", fila - 1, col);
                }
                else if (auxiliar > 0.0) {
                    modeloSolucion.setValueAt("" + cj + "+" + auxiliar + "M", fila - 1, col);
                }
                else {
                    modeloSolucion.setValueAt("" + cj + "" + auxiliar + "M", fila - 1, col);
                }
            }
            else if (contieneM(aux1) && !contieneM(aux2)) {
                final double zj = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(fila - 2, col))) * -1.0;
                if (zj == 0.0) {
                    modeloSolucion.setValueAt(aux1, fila - 1, col);
                }
                else if (subNumeroAnteM(aux1) > 0.0) {
                    modeloSolucion.setValueAt(zj + "+" + aux1, fila - 1, col);
                }
                else {
                    modeloSolucion.setValueAt("" + zj + "" + aux1, fila - 1, col);
                }
            }
            else if (contieneM(aux1) && contieneM(aux2)) {
                final double multiM = 1.0 - subNumeroAnteM(aux2);
                final double num = -1.0 * subnumero(aux2);
                if (multiM == 0.0 && num == 0.0) {
                    modeloSolucion.setValueAt(0, fila - 1, col);
                }
                else if (multiM == 0.0) {
                    modeloSolucion.setValueAt(num, fila - 1, col);
                }
                else if (num == 0.0) {
                    modeloSolucion.setValueAt(multiM + "M", fila - 1, col);
                }
                else if (multiM > 0.0) {
                    modeloSolucion.setValueAt("" + num + "+" + multiM + "M", fila - 1, col);
                }
                else {
                    modeloSolucion.setValueAt("" + num + "" + multiM + "M", fila - 1, col);
                }
            }
        }
    }

    public static void mayorFilaCj_Zj(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        Simplex.todosMenor = true;
        double mayor = -100.0;
        final double M = 1.1000000455E10;
        double y = 0.0;
        Simplex.posicioSubstringAnteM = 0;
        for (int f = 1; f < colum - 3; ++f) {
            final String tem = String.valueOf(modeloSolucion.getValueAt(fila - 1, f));
            if (contieneM(tem)) {
                final double aux1 = numero(tem);
                final double aux2 = aux(tem);
                y = aux1 + aux2 * M;
            }
            else {
                y = Double.parseDouble(tem);
            }
            if (y > mayor) {
                mayor = y;
                Simplex.columnaMayor = f;
            }
            if (y > 0.0) {
                Simplex.todosMenor = false;
            }
        }
    }

    public static void menorFilaCj_Zj(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        double menor = Double.MAX_VALUE;
        final double M = 1.10006700089E10;
        double y = 0.0;
        Simplex.posicioSubstringAnteM = 0;
        Simplex.todosMenor = true;
        for (int f = 1; f < colum - 3; ++f) {
            final String tem = String.valueOf(modeloSolucion.getValueAt(fila - 1, f));
            if (contieneM(tem)) {
                final double aux1 = numero(tem);
                final double aux2 = aux(tem);
                y = aux1 + aux2 * M;
            }
            else {
                y = Double.parseDouble(tem);
            }
            if (y < menor) {
                menor = y;
                Simplex.columnaMayor = f;
            }
            if (y < 0.0) {
                Simplex.todosMenor = false;
            }
        }
    }

    public static void CalcularXn_Mayor(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        for (int i = 2; i < fila - 2; ++i) {
            final double xn = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(i, colum - 2)));
            final double x = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(i, Simplex.columnaMayor)));
            if (x == 0.0) {
                modeloSolucion.setValueAt("\u221e", i, colum - 1);
            }
            else {
                modeloSolucion.setValueAt(xn / x, i, colum - 1);
            }
        }
    }

    public static void Menor(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        double menor = Double.MAX_VALUE;
        double tem = 0.0;
        Simplex.filalaMenor = 0;
        for (int i = 2; i < fila - 2; ++i) {
            if (!String.valueOf(modeloSolucion.getValueAt(i, colum - 1)).equalsIgnoreCase("\u221e")) {
                tem = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(i, colum - 1)));
                if (tem > 0.0 && menor > tem) {
                    menor = tem;
                    Simplex.filalaMenor = i;
                }
            }
        }
    }

    private static double numero(final String va) {
        String p = "";
        for (int i = 1; i < va.length(); ++i) {
            if ((va.charAt(i) == '-' || (va.charAt(i) == '+' && va.charAt(i - 1) != 'E')) && va.charAt(i - 1) != 'E') {
                Simplex.posicioSubstringAnteM = i;
                p = va.substring(0, i);
                return Double.parseDouble(p);
            }
        }
        Simplex.posicioSubstringAnteM = 0;
        return 0.0;
    }

    public static void Convertir0Pivote(final DefaultTableModel modeloSolucion) {
        final int colum = modeloSolucion.getColumnCount();
        final String x = String.valueOf(modeloSolucion.getValueAt(1, Simplex.columnaMayor));
        final String s = String.valueOf(modeloSolucion.getValueAt(Simplex.filalaMenor, colum - 3));
        final String xb = String.valueOf(modeloSolucion.getValueAt(0, Simplex.columnaMayor));
        modeloSolucion.setValueAt(s, 1, Simplex.columnaMayor);
        modeloSolucion.setValueAt(x, Simplex.filalaMenor, colum - 3);
        modeloSolucion.setValueAt(xb, Simplex.filalaMenor, 0);
        Simplex.pivote = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(Simplex.filalaMenor, Simplex.columnaMayor)));
        GuiSimplex.jtaOperaciones.append("\n  --Tablon " + Simplex.ntablones + "--\n\n");
        ++Simplex.ntablones;
        GuiSimplex.jtaOperaciones.append("> (1/" + AproximarNumero.valorAprocimado(String.valueOf(Simplex.pivote)) + ")F" + (Simplex.filalaMenor - 1) + "\n");
        for (int co = 1; co < colum - 1; ++co) {
            if (co != colum - 3) {
                double aux = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(Simplex.filalaMenor, co)));
                aux /= Simplex.pivote;
                modeloSolucion.setValueAt(aux, Simplex.filalaMenor, co);
            }
        }
    }

    public static void Gauss(final DefaultTableModel modeloSolucion) {
        final int fila = modeloSolucion.getRowCount();
        final int colum = modeloSolucion.getColumnCount();
        GuiSimplex.info.setText("");
        GuiSimplex.info.setBackground(new Color(240, 240, 240));
        for (int f = 2; f < fila - 2; ++f) {
            final double valor = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(f, Simplex.columnaMayor)));
            if (f != Simplex.filalaMenor) {
                if (valor == 1.0) {
                    GuiSimplex.jtaOperaciones.append("> F" + (f - 1) + "-F" + (Simplex.filalaMenor - 1) + "\n");
                }
                else if (valor != 0.0) {
                    GuiSimplex.jtaOperaciones.append("> F" + (f - 1) + "-(" + AproximarNumero.valorAprocimado(String.valueOf(valor)) + ")F" + (Simplex.filalaMenor - 1) + "\n");
                }
                for (int col = 1; col < colum - 1; ++col) {
                    if (col != colum - 3) {
                        final double f2 = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(Simplex.filalaMenor, col)));
                        final double f3 = Double.parseDouble(String.valueOf(modeloSolucion.getValueAt(f, col)));
                        final double g = f2 * valor;
                        modeloSolucion.setValueAt(f3 - g, f, col);
                    }
                }
            }
        }
    }

    public static double aux(final String va) {
        if (va.substring(Simplex.posicioSubstringAnteM, va.length() - 1).equalsIgnoreCase("+")) {
            return 1.0;
        }
        if (va.substring(Simplex.posicioSubstringAnteM, va.length() - 1).equalsIgnoreCase("-")) {
            return -1.0;
        }
        if (va.substring(Simplex.posicioSubstringAnteM, va.length() - 1).length() == 0) {
            return 1.0;
        }
        return Double.parseDouble(String.valueOf(va.substring(Simplex.posicioSubstringAnteM, va.length() - 1)));
    }

    private static double subNumeroAnteM(final String v) {
        for (int i = 0; i < v.length(); ++i) {
            if (v.charAt(i) == 'M') {
                final String tem = v.substring(0, i);
                if (tem.length() > 0) {
                    return Double.parseDouble(tem);
                }
            }
        }
        return 1.0;
    }

    private static double subnumero(final String va) {
        String sub = "";
        for (int i = 0; i < va.length(); ++i) {
            if (va.charAt(i) == 'M') {
                sub = va.substring(i + 1, va.length());
                if (sub.length() > 0) {
                    return Double.parseDouble(sub);
                }
            }
        }
        return 0.0;
    }

    public static boolean contieneM(final String valor) {
        for (int i = 0; i < valor.length(); ++i) {
            final String c = String.valueOf(valor.charAt(i));
            if (c.equalsIgnoreCase("M")) {
                return true;
            }
        }
        return false;
    }

    static {
        Simplex.ntablones = 1;
        Simplex.todosMenor = false;
    }
}
