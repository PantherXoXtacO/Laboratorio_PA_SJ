/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class Cliente extends Usuario{
    private Map siguiendo;
    private Map temasFav;
    private Map albumsFav;
    private Map listasFav;
    private Map Listas; //Listas propias creadas por el usuario

    public Cliente(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    BufferedImage imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.siguiendo = new HashMap();
        this.temasFav = new HashMap();
        this.albumsFav = new HashMap();
        this.listasFav = new HashMap();
        this.Listas = new HashMap();
        
    }

    
    
}
