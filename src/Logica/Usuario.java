
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
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Casca
 */
@Entity
public class Usuario implements Serializable {
    
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
    //@Column(name = "FECHA_DE_NACIMIENTO")
    private Fecha fechaDeNacimiento;
    
    private byte[] imagen;
    @OneToMany
    @JoinTable(name="SEGUIDORES", joinColumns=@JoinColumn(name="NICKNAME"),
               inverseJoinColumns=@JoinColumn(name="SEGUIDORES_NICK")) 
    private List<Usuario> seguidores;
    
    public Usuario(){}
    
    public Usuario(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    byte[] imagen) {
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.imagen = null;
        
        File fi = new File("data/default.jpg");
        try {
            this.imagen = Files.readAllBytes(fi.toPath());
            //this.imagen = ImageIO.read(new File("data/default.jpg")); para Buffered image
        } catch (IOException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
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

    public byte[] getImagen() {
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

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }        
    void addFollower(Usuario u1) {
        //seguidores.put(u1.getNickname(), u1);
        return;
    }

    void addFollow(Usuario u2) {}
    
}