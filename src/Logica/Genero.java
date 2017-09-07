package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Genero implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    
    private String nombre;
    private List<Genero> hijos;
    private List<Album> albums;
    private List<ListaDeReproduccion> listas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList();
        this.albums = new ArrayList();
        this.listas = new ArrayList();
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
    
    public List<ListaDeReproduccion> getListas(){
        return listas;
    }
    
    
    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    
    
    //Funciones
    public void addHijo(Genero g) {
        Iterator it=hijos.iterator();
        Genero aux;
        while(it.hasNext()){
            aux=(Genero)it.next();
            if(aux.getNombre().equals(g.getNombre()))
                return;
        }
        hijos.add(g);
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
