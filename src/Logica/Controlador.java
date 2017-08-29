package Logica;

import java.awt.image.BufferedImage;

/**
 *
 * @author Casca
 */
public class Controlador implements IControlador {
    
    public Controlador(){
        
    }
    
    @Override
    public void registrarUsuario(String nickname, String contraseña, 
                                    String mail, String nombre, String apellido,
                                    Fecha fechaDeNacimiento,
                                    BufferedImage imagen) {
        //Instancio al manejador
        Manejador mu = Manejador.getinstance();
        //Creo el usuario
        Usuario u = new Usuario(nickname, contraseña, mail, nombre, apellido,
                                fechaDeNacimiento, imagen);
        //Lo agrego a la colección global
        mu.addUsuario(u);
    }
    
    public DataUsuario verInfoUsuario(String ci){
        Manejador mu = Manejador.getinstance();
        Usuario u = mu.obtenerUsuario(ci);
        if (u!= null)
            return new DataUsuario(u.getNickname(), u.getContraseña(),
                                   u.getMail(), u.getNombre(), u.getApellido(),
                                   u.getFechaDeNacimiento(), u.getImagen());
        else
            return new DataUsuario("", "", "", "", "", null, null);
        
    }

    
    
}
