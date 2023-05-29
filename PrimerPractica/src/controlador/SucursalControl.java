/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.exception.*;
import modelo.*;

/**
 *
 * @author sfav
 */
public class SucursalControl {

    private ListaEnlazada<Sucursal> sucursales;
    private Sucursal sucursal;
    private Venta venta;

    public SucursalControl() {
        this.sucursales = new ListaEnlazada<>();
    }

    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ListaEnlazada<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public Sucursal getSucursal() {
        //Si no existe se crea una sucursal
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean guardarVentas(Integer posicionVenta, Double valor) throws EspacioException {
        if (this.sucursal != null) {
            try {
                Venta venta = this.sucursal.getVentas().get(posicionVenta);
                venta.setValor(valor);
                return true;
            } catch (VacioException | PosicionException e) {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
    }

    public boolean registrar() throws EspacioException, PosicionException {

        if (sucursal.getVentas().getSize() == 0) {
            for (EnumMes mes : EnumMes.values()) {
                Venta venta = new Venta();
                venta.setId(mes.ordinal() + 1);
                venta.setMes(mes);
                venta.setValor(0.0);
                sucursal.getVentas().insertar(venta);
            }
        }
        sucursales.insertar(sucursal);
        return true;

    }

}
