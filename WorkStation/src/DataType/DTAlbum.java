/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.Album;
import Logica.Genero;
import Logica.Tema;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DTAlbum {

    private String nombre;
    private int anio;
    private String imagen;
    private String artista;
    private List<DTTema> temas;
    private List generos;
    
    public DTAlbum(Album album) {
        nombre=album.getNombre();
        anio=album.getAnio();
        imagen=album.getImg();
        artista=album.getArtista().getNombre();
        Iterator genIt = album.getGeneros().iterator();
        Genero g;
        while(genIt.hasNext()){
            g=(Genero) genIt.next();
            generos.add(g.getNombre());
        }
        Iterator temaIt = album.getTemas().iterator();
        Tema t;
        while(temaIt.hasNext()){
            t = (Tema) temaIt.next();
            temas.add(new DTTema (t));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getImagen() {
        return imagen;
    }

    public String getArtista() {
        return artista;
    }

    public List<DTTema> getTemas() {
        return temas;
    }

    public List getGeneros() {
        return generos;
    }
}
