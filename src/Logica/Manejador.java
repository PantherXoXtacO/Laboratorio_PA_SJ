package Logica;

import java.util.ArrayList;
import java.util.List;

public class Manejador {
    //Clase que conserva las colecciones globales del sistema
    
    private List<Usuario> usuariosCI;
    private List<ListaDeReproduccion> Listas; // Listas por defecto
    private Genero genero; // Guarda el genero raiz
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuariosCI=new ArrayList();
        Listas=new ArrayList();
        genero=new Genero("Genero");
        IdTema=0;
        IdAlbum=0;
        IdList=0;
    }
    
    public static Manejador getinstance(){
        if (instancia==null)
            instancia = new Manejador();
        return instancia;
    }
    
    public void addUsuario(Usuario usu){
        String nickname = usu.getNickname();
        if (this.obtenerUsuario(nickname) == null) {
      //      usuariosCI.put(nickname,usu); Cambiar por funcion de List
        }
    }
    
    public Usuario obtenerUsuario(String nickname){
    //    return ((Usuario) usuariosCI.get(nickname)); Cambiar por funcion de List
          return null;
    }
    
    
    //Funciones auxiliares
    public Genero getGenero(){
        return genero;
    }

    boolean FindUser(String text) {
    //    return usuariosCI.containsKey(text); Cambiar por funcion de List
    return true;
    }
}
