/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Casca
 */
public class Tema {
    
    private String nombre;
    private int duracion;
    private int orden;
    private Album album;

    public Tema(String nombre, int duracion, int orden, Album album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.orden = orden;
        this.album = album;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getOrden() {
        return orden;
    }

    public Album getAlbum() {
        return album;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    
}
