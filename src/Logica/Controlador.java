package Logica;

import java.awt.image.BufferedImage;
import java.util.List;

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
                                    byte[] imagen, String userType,
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
    public void AltaGenero(String nombre, String padre){
        Manejador mu = Manejador.getinstance();
        Genero gen;
        Genero nuevoGen=mu.findGenero(nombre);
        if(nuevoGen==null){
            nuevoGen=new Genero(nombre);
            if(padre.equals("") || padre.equals("General")){
            System.out.println("sin padre");
            gen=mu.getGenero();
            gen.addHijo(nuevoGen);
            }
            else{
               gen=mu.findGenero(padre);
                if(gen!=null){
                   gen.addHijo(nuevoGen);
                }
            }
            mu.addGeneroToList(nuevoGen);
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
       if(u1!=null && u2!=null){
            u1.addFollow(u2);
            u2.addFollower(u1);
       }
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
