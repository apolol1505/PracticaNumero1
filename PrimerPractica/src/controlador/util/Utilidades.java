/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.util;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.NodoLista;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author sfav
 */
public class Utilidades {

    public static void imprimir(Object[] objs) {
        System.out.println("Lista de " + objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }

    public static Double sumarVentas(Sucursal s) {
        if (s.getVentas() != null) {
            Double ventas = 0.0;
            NodoLista<Venta> nodoActual = s.getVentas().getCabecera();

            while (nodoActual != null) {
                ventas += nodoActual.getInformacion().getValor();
                nodoActual = nodoActual.getSiguiente();
            }

            return ventas;
        }
        return 0.0;
    }

    public static Double mediaVentas(Sucursal s) {
        Double suma = sumarVentas(s);
        if (suma == 0) {
            return suma;
        } else {
            return Math.round((suma / s.getVentas().size())* 100.0) / 100.0;
        }
    }

    public static String sucursalConMayoresVentas(ListaEnlazada<Sucursal> sucursales) {
        String indice = "";
        double maxVentas = 0;

        NodoLista<Sucursal> nodo = sucursales.getCabecera();
        int i = 0;
        while (nodo != null) {
            Sucursal s = nodo.getInformacion();

            if (s != null) {
                double totalVentas = Utilidades.sumarVentas(s);
                if (totalVentas > maxVentas) {
                    maxVentas = totalVentas;
                    indice = s.getNombre();
                }
            }

            nodo = nodo.getSiguiente();
            i++;
        }

        return indice;
    }

    public static String sucursalConMenoresVentas(ListaEnlazada<Sucursal> sucursales) {
        String indice = "";
        double minVentas = Double.MAX_VALUE;

        NodoLista<Sucursal> nodo = sucursales.getCabecera();
        int i = 0;
        while (nodo != null) {
            Sucursal s = nodo.getInformacion();
            if (s != null) {
                double totalVentas = Utilidades.sumarVentas(s);
                if (totalVentas < minVentas) {
                    minVentas = totalVentas;
                    indice = s.getNombre();
                }
            }
            nodo = nodo.getSiguiente();
            i++;
        }

        return indice;
    }

}
