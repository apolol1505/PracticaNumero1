/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.peticiones;

import controlador.ed.lista.ListaEnlazada;
import modelo.Peticion;
/**
 *
 * @author sfav
 */
public class ControladorPeticiones {

    private static ListaEnlazada<Peticion> misPeticiones = new ListaEnlazada<>();

    public static ListaEnlazada<Peticion> getMisPeticiones() {
        return misPeticiones;
    }

    public static void setMisPeticiones(ListaEnlazada<Peticion> peticiones) {
        misPeticiones = peticiones;
    }
}
