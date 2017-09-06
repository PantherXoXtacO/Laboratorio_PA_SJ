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
    
    @Override
    public boolean nicknameLibre(String nickname){
        Manejador M=Manejador.getinstance();
        return M.nicknameLibre(nickname);
    }
    
    @Override
    public boolean mailLibre(String mail){
        Manejador M=Manejador.getinstance();
        return M.mailLibre(mail);
    }
    
    @Override
    public Cliente consultarCliente(String nickname){
        Manejador M=Manejador.getinstance();
        return M.obtenerCliente(nickname);
    }
    
    @Override
    public Artista consultarArtista(String nickname){
        Manejador M=Manejador.getinstance();
        return M.obtenerArtista(nickname);
    }
    
}
