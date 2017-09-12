package Logica;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario{
    private List<Usuario> siguiendo;
    private List<Tema> temasFav;
    private List<Album> albumsFav;
    private List<ListaDeReproduccion> listasFav;
    private List<ListaDeReproduccion> Listas; //Listas propias creadas por el usuario

    
    
    public Cliente(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    String imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.siguiendo = new ArrayList();
        this.temasFav = new ArrayList();
        this.albumsFav = new ArrayList();
        this.listasFav = new ArrayList();
        this.Listas = new ArrayList();        
    }

    public Cliente() {
    }   
    
    @Override
    void addFollow(Usuario u2) {
        siguiendo.add(u2);
    }

}
