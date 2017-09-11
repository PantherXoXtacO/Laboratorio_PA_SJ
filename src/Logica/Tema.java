package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
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