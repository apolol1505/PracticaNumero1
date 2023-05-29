/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author sfav
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaEnlazada <Venta> ventas= new ListaEnlazada<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ListaEnlazada<Venta> venta) {
        this.ventas = venta;
    }
    
    
    
}
