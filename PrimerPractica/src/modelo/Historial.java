/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controlador.ed.pila.Pila;
import controlador.ed.pila.exception.TopeException;
import javax.swing.JOptionPane;
/**
 *
 * @author sfav
 */
public class Historial {

    private Pila<String> pilaAcciones;
    private SimpleDateFormat formatoFecha;

    public Historial() {
        pilaAcciones = new Pila<>(20); // Tamaño máximo de 20 elementos
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public void guardarAccion(String accion) throws VacioException, PosicionException {
        Date fechaActual = new Date();
        String accionConFecha = formatoFecha.format(fechaActual) + ": " + accion;

        try {
            if (pilaAcciones.size() == 20) {
                pilaAcciones.pop(); // Eliminar el elemento más antiguo si la pila está llena
            }
            pilaAcciones.push(accionConFecha);
            
            JOptionPane.showMessageDialog(null, "Accion guardada : " + accionConFecha, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } catch (TopeException e) {
            System.out.println("No se pudo guardar mas acciones.");
        }
    }

    public String obtenerUltimaAccion() {
        try {
            return pilaAcciones.pop();
        } catch (Exception e) {
            return null;
        }
    }

    public void imprimirPila() {
        try {
            pilaAcciones.print();
        } catch (Exception e) {
            System.out.println("La pila está vacía.");
        }
    }
}
