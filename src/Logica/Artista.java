package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Artista extends Usuario {
    private String biografia;
    private String dir_web;
    private List<Album> albums;

    public Artista(String biografia, String dir_web, String nickname, String contraseña, String mail, String nombre, String apellido, Fecha fechaDeNacimiento, BufferedImage imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.biografia = biografia;
        this.dir_web = dir_web;
        this.albums = new ArrayList();
    }
}
