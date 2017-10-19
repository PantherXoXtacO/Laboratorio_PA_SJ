/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Casca
 */
public class DataUsuario {
    private String nickname;
    private String contraseña;
    private String mail; // Identificador
    private String nombre;
    private String apellido;
    private Fecha fechaDeNacimiento;
    private BufferedImage imagen;
    
    public DataUsuario(){
        this.nickname = "";
        this.contraseña = "";
        this.mail = "";
        this.nombre = "";
        this.apellido = "";
        this.fechaDeNacimiento = null;
        this.imagen = null;
    }

    public DataUsuario(String nickname, String contraseña, String mail,
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

}
    
