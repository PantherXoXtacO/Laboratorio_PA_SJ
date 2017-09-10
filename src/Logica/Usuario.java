
package Logica;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Casca
 */
@MappedSuperclass
@Table(name = "USUARIO")
public abstract class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) 
    long id;
    
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "CONSTRASEÑA")
    private String contraseña;
    @Column(name = "MAIL")
    private String mail; // Identificador
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FECHA_DE_NACIMIENTO")
    private Fecha fechaDeNacimiento;
    @Column(name = "IMAGEN_DE_USUARIO")
    private String imagen; //path a la imagen del usuario
    
    
    public Usuario(){}
    
    public Usuario(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    String imagen) {
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.imagen = imagen;    
        //this.seguidores=new List();
    }
    
    //getters

    public String getNickname() {
        return nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getMail() {
        return mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    //setters
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaDeNacimiento(Fecha fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }        
    void addFollower(Usuario u1) {
        //seguidores.put(u1.getNickname(), u1);
        return;
    }

    void addFollow(Usuario u2) {}
    
}