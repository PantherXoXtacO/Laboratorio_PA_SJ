package Logica;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    
    private String nombre;
    private int anio;
    private String img;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTISTA_DEL_ALBUM")
    private Artista artista;
    @OneToMany
    @JoinTable(name="TEMAS_DEL_ALBUM", joinColumns=@JoinColumn(name="ALBUM_ID"),
               inverseJoinColumns=@JoinColumn(name="TEMAS_ID")) 
    private List<Tema> temas;
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
}