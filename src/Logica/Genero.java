/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author Casca
 */
public class Genero {
    private String nombre;
    private List<Genero> hijos;
    private List<Album> albums;
    private List<ListaPorDefecto> listas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.hijos = null;
        this.albums = null;
        this.listas = null;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public List<Genero> getHijos() {
        return hijos;
    }
    
    public List<Album> getAlbums() {
        return albums;
    }
    
    public List<ListaPorDefecto> getListas(){
        return listas;
    }
    
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
}
