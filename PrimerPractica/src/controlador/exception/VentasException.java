/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.exception;

/**
 *
 * @author sfav
 */
public class VentasException extends Exception {

    /**
     * Creates a new instance of <code>VentasException</code> without detail
     * message.
     */
    public VentasException() {
    }

    /**
     * Constructs an instance of <code>VentasException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public VentasException(String msg) {
        super("La posición del mes es invalida ");
    }
}
