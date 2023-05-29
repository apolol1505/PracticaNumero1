/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sfav
 */
public class AdaptadorDao <T> implements InterfazDao<T>{
    
    private Conexion conexion;
    private Class clazz;
    private String url;
    
    public AdaptadorDao(Class clazz){
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL+clazz.getSimpleName().toLowerCase()+".json";
    }

    @Override
    public void guardar(T obj) throws IOException {
        ListaEnlazada<T> lista = listar();
        lista.insertar(obj);
        conexion.getXStream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public void modificar(T obj, Integer pos) throws IOException,VacioException, PosicionException {
        ListaEnlazada<T> lista = listar();
        lista.update(pos,obj);
        conexion.getXStream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<T>)conexion.getXStream().fromXML(new File(url));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}