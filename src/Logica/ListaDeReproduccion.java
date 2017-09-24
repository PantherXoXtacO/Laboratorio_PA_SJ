/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class ListaDeReproduccion {
    
    private String nombre;
    private List<Tema> temas;
    private String imagen;

    public ListaDeReproduccion(String nombre, String imagen) {
        this.nombre = nombre;
        this.temas = new ArrayList();
        this.imagen = imagen;
    }

    ListaDeReproduccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public String getImagen() {
        return imagen;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    void agregarTema(Tema tem) {
        temas.add(tem);
    }    
    
     void quitarTema(Tema tem) {
        temas.remove(tem);
    }    
}
