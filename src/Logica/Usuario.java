
package Logica;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Casca
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) 
    long id;
    
    //@Column(name = "NICKNAME")
    private String nickname;
    //@Column(name = "CONSTRASEÑA")
    private String contraseña;
    //@Column(name = "MAIL")
    private String mail; // Identificador
    //@Column(name = "NOMBRE")
    private String nombre;
    //@Column(name = "APELLIDO")
    private String apellido;
    //@Column(name = "FECHA_DE_NACIMIENTO")  ???
    private Fecha fechaDeNacimiento;
    private BufferedImage imagen;
    
    private Map seguidores;
    

    public Usuario(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    BufferedImage imagen) {
        this.nickname = nickname;
        this.contraseña = contraseña;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.imagen = null;
        try {
            this.imagen = ImageIO.read(new File("data/default.jpg"));
        } catch (IOException e) {
        }
                
        this.seguidores=new HashMap();
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

    public BufferedImage getImagen() {
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

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }        
    void addFollower(Usuario u1) {
        seguidores.put(u1.getNickname(), u1);
    }

    void addFollow(Usuario u2) {}
    
}