/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Casca
 */
public class ListaDeReproduccion {
    
    private String nombre;
    private List<Tema> temas;
    private BufferedImage imagen;

    public ListaDeReproduccion(String nombre, BufferedImage imagen) {
        this.nombre = nombre;
        this.temas = null;
        this.imagen = imagen;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    
    
}
