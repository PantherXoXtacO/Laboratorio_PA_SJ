package Logica;

import java.util.HashMap;
import java.util.Map;

public class Manejador {
    //Clase que conserva las colecciones globales del sistema
    
    private Map usuariosCI;
    private Map Listas; // Listas por defecto
    private Genero genero; // Guarda el genero raiz
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuariosCI=new HashMap();
        Listas=new HashMap();
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
            usuariosCI.put(nickname,usu);
        }
    }
    
    public Usuario obtenerUsuario(String nickname){
        return ((Usuario) usuariosCI.get(nickname));
    }
}
