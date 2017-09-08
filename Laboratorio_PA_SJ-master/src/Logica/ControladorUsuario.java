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
public class ControladorUsuario implements IControladorUsuario {
    
    public ControladorUsuario(){
        
    }
    
    @Override
    public void registrarUsuario(String nickname, String contraseña, 
                                    String mail, String nombre, String apellido,
                                    Fecha fechaDeNacimiento,
                                    BufferedImage imagen) {
        //Instancio al manejador
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Creo el usuario
        Usuario u = new Usuario(nickname, contraseña, mail, nombre, apellido,
                                fechaDeNacimiento, imagen);
        //Lo agrego a la colección global
        mu.addUsuario(u);
    }
    
    public DataUsuario verInfoUsuario(String ci){
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u!= null)
            return new DataUsuario(u.getNickname(), u.getContraseña(),
                                   u.getMail(), u.getNombre(), u.getApellido(),
                                   u.getFechaDeNacimiento(), u.getImagen());
        else
            return new DataUsuario("", "", "", "", "", null, null);
        
    }

    
    
}
