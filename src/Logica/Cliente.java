/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Casca
 */
public class Cliente extends Usuario{
    private List<Usuario> siguiendo;
    private List<Tema> temasFav;
    private List<Album> albumsFav;
    private List<ListaDeReproduccion> listasFav;

    public Cliente(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    BufferedImage imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.siguiendo = null;
        this.temasFav = null;
        this.albumsFav = null;
        this.listasFav = null;
        
    }

    
    
}
