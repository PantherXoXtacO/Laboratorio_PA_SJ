
package Logica;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
/**
 *
 * @author Casca
 */
public class Usuario {
    private String nickname;
    private String contraseña;
    private String mail; // Identificador
    private String nombre;
    private String apellido;
    private Fecha fechaDeNacimiento;
    private BufferedImage imagen;
    

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
    
}