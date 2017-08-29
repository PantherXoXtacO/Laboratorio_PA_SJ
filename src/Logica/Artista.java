/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class Artista extends Usuario {
    private String biografia;
    private String dir_web;
    private Map albums;

    public Artista(String biografia, String dir_web, String nickname, String contraseña, String mail, String nombre, String apellido, Fecha fechaDeNacimiento, BufferedImage imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.biografia = biografia;
        this.dir_web = dir_web;
        this.albums = new HashMap();
    }

    
    
    
}
