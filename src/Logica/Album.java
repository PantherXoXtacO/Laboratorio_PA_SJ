package Logica;

import java.awt.image.BufferedImage;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class Album {
   
    private String nombre;
    private int anio;
    private BufferedImage img;
    private Artista artista;
    
    private Map temas;
    private Map genero;
    
    public Album(String nom, int year, BufferedImage imagen, Artista artist){
        nombre=nom;
        anio=year;
        img=imagen;
        artista=artist;
        
        temas=new HashMap();
        genero=new HashMap();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public BufferedImage getImg(){
        return img;
    }
    
    public Artista getArtista(){
        return artista;
    }
    
    public Map getTemas(){
        return temas;
    }
    
    public Map getGeneros(){
        return genero;
    }
}