/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Historial;

/**
 *
 * @author sfav
 */
public class ModeloTablaHistorial extends AbstractTableModel {

    private ListaEnlazada<Historial> acciones = new ListaEnlazada<>();

    public ListaEnlazada<Historial> getAaciones() {
        return acciones;
    }

    public void setAaciones(ListaEnlazada<Historial> aaciones) {
        this.acciones = aaciones;
    }

    @Override
    public int getRowCount() {
        return acciones.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Historial h= null;
        String accion="";
        try {
            h= acciones.get(i);
            
        } catch (Exception e) {
        }
        switch(i1){
            case 0:return h.obtenerUltimaAccion();
            default:return null;
        }
    }

}
