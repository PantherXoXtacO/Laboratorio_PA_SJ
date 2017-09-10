package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ARTISTA")
public class Artista extends Usuario {
    @Column(name = "BIOGRAFIA")
    private String biografia;
    @Column(name = "DIR_WEB")
    private String dir_web;    
    @OneToMany
    @JoinTable(name="ALBUMS_DE_ARTISTA", joinColumns=@JoinColumn(name="ARTISTA_NICKNAME"),
               inverseJoinColumns=@JoinColumn(name="ALBUMS_ID")) 
    private List<Album> albums;
    //@OneToMany
    //@JoinTable(name="USUARIOS_SEGUIDOS", joinColumns=@JoinColumn(name="USUARIO_NICKNAME"),
    //           inverseJoinColumns=@JoinColumn(name="SEGUIDOS_NICK"))
    private List<Usuario> siguiendo;

    public String getBiografia() {
        return biografia;
    }

    public String getDir_web() {
        return dir_web;
    }

    public Artista(String biografia, String dir_web, String nickname, String contraseña, String mail, String nombre, String apellido, Fecha fechaDeNacimiento, String imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.biografia = biografia;
        this.dir_web = dir_web;
        this.albums = new ArrayList();
    }
    
    public Artista(){
        
    }
}
