/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class Genero {
    private String nombre;
    private Map hijos;
    private Map albums;
    private Map listas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.hijos = new HashMap();
        this.albums = new HashMap();
        this.listas = new HashMap();
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public Map getHijos() {
        return hijos;
    }
    
    public Map getAlbums() {
        return albums;
    }
    
    public Map getListas(){
        return listas;
    }
    
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
}
