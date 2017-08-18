/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.awt.image.BufferedImage;

/**
 *
 * @author Casca
 */
public interface IControladorUsuario {
    public abstract void registrarUsuario(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, BufferedImage imagen);
    public abstract DataUsuario verInfoUsuario(String nickname);
}

