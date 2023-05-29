/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.util.Utilidades;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;

/**
 *
 * @author sfav
 */
public class ModeloTablaSucursal extends AbstractTableModel {

    private ListaEnlazada<Sucursal> datos = new ListaEnlazada<>();

    public ListaEnlazada<Sucursal> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Sucursal> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        try {
            Sucursal s = datos.get(fila);
                    switch (columna) {
            case 0:
                return (s != null) ? s.getNombre() : "NO DEFINIDO";
            case 1:
                return (s != null) ? Utilidades.sumarVentas(s) : 0.0;
            case 2:
                return (s != null) ? Utilidades.mediaVentas(s) : 0.0;
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
                return "SUCURSAL";
            case 1:
                return "VENTA ANUAL";
            case 2:
                return "VENTA PROMEDIO";
            default:
                return null;
        }
    }

}
