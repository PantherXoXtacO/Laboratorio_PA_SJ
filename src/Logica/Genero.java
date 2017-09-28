package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Genero")
public class Genero implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    @Column(name = "NOMBRE")
    private String nombre;
    @Column (name = "PADRE")
    private String padre;
    @OneToMany
    @JoinTable(name="GENEROS_HIJOS", joinColumns=@JoinColumn(name="NOMBRE_GENERO"),inverseJoinColumns=@JoinColumn(name="HIJOS")) 
    private List<Genero> hijos;
    @OneToMany
    @JoinTable(name="ALBUMS_DE_GENERO", joinColumns=@JoinColumn(name="NOMBRE_GENERO"),inverseJoinColumns=@JoinColumn(name="ALBUMS_GENERO"))
    private List<Album> albums;
    //@OneToMany
    //@JoinTable(name="LISTA_DE_GENERO", joinColumns=@JoinColumn(name="NOMBRE_GENERO"),inverseJoinColumns=@JoinColumn(name="LISTA_GENERO")) 
    private List<ListaDeReproduccion> listas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList();
        this.albums = new ArrayList();
        this.listas = new ArrayList();
        this.padre = null;
    }
    
    public Genero(){
    
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
        g.setPadre(this);
        hijos.add(g);
    }
    
    private void setPadre(Genero dad){
        padre=dad.getNombre();
    }
    
    public String getPadre(){
        return padre;
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
    
    public void addAlbum(Album album){
        this.albums.add(album);
    }
    
   
    
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
}
