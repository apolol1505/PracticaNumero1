/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
/**
 *
 * @author sfav
 */
public class Peticion {

    private String usuario;
    private String reclamo;
    private Date fechaCreacion;

    public Peticion(String usuario, String reclamo) {
        this.usuario = usuario;
        this.reclamo = reclamo;
        this.fechaCreacion = new Date();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getReclamo() {
        return reclamo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
