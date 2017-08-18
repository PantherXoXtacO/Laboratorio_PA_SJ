package Logica;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Casca
 */
public class Album {
    
    private String nombre;
    private int año;
    private List<Genero> generos;
    private BufferedImage imagen;
    private List<Album> albums;
    private Artista artista;

    public Album(String nombre, int año, BufferedImage imagen, Artista artista) {
        this.nombre = nombre;
        this.año = año;
        this.generos = null;
        this.imagen = imagen;
        this.albums = null;
        this.artista = artista;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(int año) {
        this.año = año;
    }


    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

   
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public List<Genero> getGenero() {
        return generos;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public Artista getArtista() {
        return artista;
    }
    
    
}
