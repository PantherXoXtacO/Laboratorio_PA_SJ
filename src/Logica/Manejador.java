package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public class Manejador {
    //Clase que conserva las colecciones globales del sistema
    
    private List<Usuario> usuariosCI;
    private List<ListaDeReproduccion> Listas; // Listas por defecto
    private final Genero genero=new Genero("Genero"); // Guarda el genero raiz
    private List<Genero> generosList;
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuariosCI=new ArrayList();
        Listas=new ArrayList();
        generosList=new ArrayList();
        //genero=new Genero("Genero");
        generosList.add(genero);
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
            usuariosCI.add(usu);
        }
    }
    
    public Usuario obtenerUsuario(String nickname){
        Iterator it=usuariosCI.iterator();
        Usuario user;
        while(it.hasNext()){
            user=(Usuario)it.next();
            if(user.getNickname().equals(nickname)){
                return user;
            }
        }
        return null;
    }
    
    
    //Funciones auxiliares
    public Genero getGenero(){
        return genero;
    }
    
    public List<Genero> getListGeneros(){
        return generosList;
    }

    boolean FindUser(String text) {
        Iterator it=usuariosCI.iterator();
        Usuario user;
        while(it.hasNext()){
            user=(Usuario)it.next();
            if(user.getNickname()==text){
                return true;
            }
        }
        return false;
    }
}
