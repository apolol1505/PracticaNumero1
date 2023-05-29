/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;


import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import modelo.Peticion;
import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author sfav
 */
public class ModeloTablaPeticiones extends AbstractTableModel {

    private ListaEnlazada<Peticion> datos = new ListaEnlazada<>();

    public ListaEnlazada<Peticion> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Peticion> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Peticion peticion = datos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (peticion != null) ? peticion.getUsuario(): "NO DEFINIDO";
                case 1:
                    return (peticion != null) ? peticion.getReclamo(): 0;
                default:
                    return null;
            }
        } catch (VacioException e) {
            e.printStackTrace();
            return null;
        } catch (PosicionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Peticiones";
            default:
                return null;
        }
    }

    public void setDatos(List<Peticion> peticiones) {
        datos = new ListaEnlazada<>();
        for (Peticion peticion : peticiones) {
            datos.insertar(peticion);
        }
    }


}
