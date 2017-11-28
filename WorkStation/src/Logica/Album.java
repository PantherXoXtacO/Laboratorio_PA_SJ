package Logica;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.EntityManagerFactory;

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Año")
    private int anio;
    @Column(name = "ImgPath")
    private String img;
    @JoinColumn(name = "ArtistasDelAlbum")
    private Artista artista;
    @JoinColumn(name = "TemasDelAlbum")
    private List<Tema> temas;
    @JoinColumn(name = "GenerosDelAlbum")
    private List<Genero> genero;

    public Album() {
        nombre="";
        anio = 0;
        img="";
        artista= null;
        temas = new ArrayList();
        genero = new ArrayList();
    }
    
    public Album(String nom, int year, String imagen, Artista artist){
        nombre=nom;
        anio=year;
        img=imagen;
        artista=artist;        
        temas=new ArrayList();
        genero=new ArrayList();
    }
    
    public Album(Album album){
        nombre = album.nombre;
        anio = album.anio;
        img = album.img;
        artista = album.artista;
        temas = album.temas;
        genero = album.genero;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public void setGenero(List<Genero> genero) {
        Iterator it= genero.iterator();
        Genero gen;
        while(it.hasNext()){
            gen = (Genero) it.next();
        }
        this.genero = genero;
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
    
    public void addTema(Tema tema){        
        this.temas.add(tema);
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

    public Tema getTema(String tema) {
        Iterator it = temas.iterator();
        Tema t=null;
        while(it.hasNext()){
            t=(Tema)it.next();
            if(t.getNombre().equals(tema)){
                return t;
            }
        }
        return t;
    }
}