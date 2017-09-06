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
                                    BufferedImage imagen, String userType,
                                    String biografia, String dir_web) {
        //Instancio al manejador
        Manejador mu = Manejador.getinstance();
        //Creo el usuario
        if(userType=="Cliente"){
            Cliente user = new Cliente(nickname, contraseña, mail, nombre, apellido,
                                            fechaDeNacimiento, imagen);
            mu.addUsuario(user, userType);
        }
        else if (userType=="Artista"){
            Artista user = new Artista(biografia, dir_web, nickname, contraseña, mail, nombre, apellido,
                                            fechaDeNacimiento, imagen);
            mu.addUsuario(user, userType);
        }        
    }
    
    @Override
    public DataUsuario ConsultarCliente(String nickname){
        Manejador mu = Manejador.getinstance();
        Usuario u = mu.obtenerCliente(nickname);
        if (u!= null)
            return new DataUsuario(u.getNickname(), u.getContraseña(),
                                   u.getMail(), u.getNombre(), u.getApellido(),
                                   u.getFechaDeNacimiento(), u.getImagen());
        else
            return new DataUsuario("", "", "", "", "", null, null);        
    }
    
    @Override
    public DataUsuario ConsultarArtista(String nickname){
        Manejador mu = Manejador.getinstance();
        Usuario u = mu.obtenerArtista(nickname);
        if (u!= null)
            return new DataUsuario(u.getNickname(), u.getContraseña(),
                                   u.getMail(), u.getNombre(), u.getApellido(),
                                   u.getFechaDeNacimiento(), u.getImagen());
        else
            return new DataUsuario("", "", "", "", "", null, null);        
    }
    
    @Override
    public void AltaGenero(String nombre, Genero padre){
        Genero g=new Genero(nombre);
        if(padre==null){
            Manejador M=Manejador.getinstance();
            M.getGenero().addGenero(g);
        }
        else{
            padre.addGenero(g);
        }
    }
    

    @Override
    public Genero GetGenero(){
        Manejador M=Manejador.getinstance();
        return M.getGenero();
    }
    
    public void AgregarTema(){
    
    }
    @Override
    public void EliminarTemaFav(){
    
    }
    @Override
    public void ConsultarAlbum(){
        
    }

    @Override
    public boolean FindUser(String text){
        Manejador M=Manejador.getinstance();
        return (M.FindUser(text));
    }

    @Override
    public void SeguirUsuario(String seguidor, String seguido) {
       Manejador M=Manejador.getinstance();
       Usuario u1 = M.obtenerUsuario(seguidor);
       Usuario u2 = M.obtenerUsuario(seguido);
       u1.addFollow(u2);
       u2.addFollower(u1);
    }
    
}
