/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author sfav
 */
public class SucursalDao extends AdaptadorDao<Sucursal> {

    private Sucursal sucursal;

    public SucursalDao() {
        super(Sucursal.class);
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            this.sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void guardar() throws IOException {
        sucursal.setVentas(new ListaEnlazada<>());
        for (int i = 0; i < 12; i++) {
            Venta v = new Venta();
            v.setId(i);
            v.setMes(EnumMes.values()[i]);
            v.setValor(0.0);
            sucursal.getVentas().insertar(v);
        }

        this.guardar(sucursal);
    }

    public void modificar(Integer pos) throws IOException {
        this.modificar(pos);
    }

    private Integer generarId() {
        return listar().size() + 1;
    }

    public static void main(String[] args) {
        SucursalDao sd = new SucursalDao();

        sd.getSucursal().setNombre("Alice");
        sd.getSucursal().setId(sd.generarId());

        Venta v = new Venta();
        v.setMes(EnumMes.Mayo);
        v.setValor(10080.0);
        sd.getSucursal().getVentas().insertar(v);

        try {
            sd.guardar(sd.getSucursal());
            System.out.println(sd.listar());
            sd.listar().imprimir();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
