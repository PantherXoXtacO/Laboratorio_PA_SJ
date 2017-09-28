package Logica;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;

    
    private String nombre;
    private int anio;
    private String img;
    private Artista artista;
    
    private List<Tema> temas;
    private List<Genero> genero;

    public Album() {
    }
    
    public Album(String nom, int year, String imagen, Artista artist){
        nombre=nom;
        anio=year;
        img=imagen;
        artista=artist;
        
        temas=new ArrayList();
        genero=new ArrayList();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public String getImg(){
        return img;
    }
    
    public Artista getArtista(){
        return artista;
    }
    
    public List<Tema> getTemas(){
        return temas;
    }
    
    public List<Genero> getGeneros(){
        return genero;
    }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Funciones del @Entity
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Album[ id=" + id + " ]";
    }    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}