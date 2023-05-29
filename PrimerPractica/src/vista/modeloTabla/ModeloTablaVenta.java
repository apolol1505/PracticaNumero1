/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author sfav
 */
public class ModeloTablaVenta extends AbstractTableModel {

    private ListaEnlazada<Venta> ventas = new ListaEnlazada<>();
    private ListaEnlazada<Sucursal> sucursales = new ListaEnlazada<>();

    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setDatos(ListaEnlazada<Sucursal> datos) {
        this.sucursales = datos;
    }

    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ListaEnlazada<Venta> datos) {
        this.ventas = datos;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        if (ventas == null) {
            return 0;
        }
        return ventas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        try {
            Venta venta = ventas.get(fila);
            switch (columna) {
                case 0:
                    return (venta != null) ? venta.getMes().toString() : "NO DEFINIDO";
                case 1:
                    return (venta != null) ? venta.getValor() : 0.0;
                default:
                    return null;
            }
        } catch (VacioException ex) {
            JOptionPane.showMessageDialog(null, "Vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (PosicionException ex) {
            JOptionPane.showMessageDialog(null, "Posicion Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "MES";
            case 1:
                return "VALOR";
            default:
                return null;
        }
    }

}
