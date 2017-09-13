package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
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
                                    String imagen, String userType,
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
    
    
    @Override
    public List getItemCliente(){
        Manejador M=Manejador.getinstance();
        List ret=M.ItemCLiente();
        return ret;       
    }
    
    @Override
    public List getTemasItem(){
     Manejador M=Manejador.getinstance();
     List ret=M.ItemTemas();
     return ret;
    }    
    
    @Override
    public void agregarTemaALista(Object selectedItem, Object selectedItem0){
        Item l = (Item) selectedItem;
        Item t = (Item) selectedItem0;
        ListaDeReproduccion lista = (ListaDeReproduccion) l.getValue();
        Tema tem = (Tema) t.getValue();
        lista.agregarTema(tem);
    }
    
    @Override
    public void QuitarTemaFavorito(Object selectedItem, Object selectedItem0){
        Item usr = (Item) selectedItem;
        Item tem = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Tema t = (Tema) tem.getValue();
        client.quitarTemaFav(t);
    }
    
    @Override
    public void QuitarAlbumFav(Object selectedItem, Object selectedItem0){
        Item usr = (Item) selectedItem;
        Item alb = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Album a = (Album) alb.getValue();
        client.quitarAlbumFav(a); 
    }

    @Override
    public void QuitarListaFav(Object selectedItem, Object selectedItem0){
        Item usr = (Item) selectedItem;
        Item lst = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        ListaDeReproduccion lista = (ListaDeReproduccion) lst.getValue();
        client.quitarListFav(lista);
    }
}
