package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manejador {
    //Clase que conserva las colecciones globales del sistema
    
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    private List<Artista> artistas;
    private List<ListaDeReproduccion> Listas; // Listas por defecto
    private Genero genero; // Guarda el genero raiz
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    //Para la base de datos
    //EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    //EntityManager entitymanager = emfactory.createEntityManager( );    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuarios =new ArrayList();
        clientes=new ArrayList();
        artistas=new ArrayList();
        Listas=new ArrayList();
        genero=new Genero("Genero");
        IdTema=0;
        IdAlbum=0;
        IdList=0;
    }
    
    public List<Cliente> getClientes(){
        return this.clientes;        
    }
    
    public List<Artista> getArtistas(){
        return this.artistas;        
    }
    
    public static Manejador getinstance(){
        if (instancia==null)
            instancia = new Manejador();
        return instancia;
    }
    
    public void addUsuario(Usuario usu, String userType){
        String nickname = usu.getNickname();
        if (this.obtenerUsuario(nickname) == null) { //si no existe en la lista
           usuarios.add(usu); 
           //entitymanager.getTransaction( ).begin( );
           //entitymanager.persist(usu);
           //entitymanager.getTransaction().commit();
           //entitymanager.close();   
           if(userType=="Cliente"){
               Cliente cliente = (Cliente) usu;
               clientes.add(cliente);
               //entitymanager.getTransaction( ).begin( );
            //entitymanager.persist(usu);
            //entitymanager.getTransaction().commit();
            //entitymanager.close();   
           }
           if(userType=="Artista"){
              Artista artista = (Artista) usu;
              artistas.add(artista);
            //entitymanager.getTransaction( ).begin( );
            //entitymanager.persist(usu);
            //entitymanager.getTransaction().commit();
            //entitymanager.close();   
           }           
        }
        else
            System.out.println("Usuario ya existe");
    } 
    
    public Usuario obtenerUsuario(String nickname){
        Iterator it = usuarios.iterator();
        Usuario user;
        while(it.hasNext()){
            user = (Usuario)it.next();
            if(user.getNickname().equals(nickname))
                return user;
        }
        return null;
    }
    
    public Usuario obtenerCliente(String nickname){
        Iterator it = clientes.iterator();
        Cliente user;
        while(it.hasNext()){
            user = (Cliente)it.next();
            if(user.getNickname().equals(nickname))
                return user;
        }
        return null;
    }
    
    public Usuario obtenerArtista(String nickname){
        Iterator it = artistas.iterator();
        Artista user;
        while(it.hasNext()){
            user = (Artista)it.next();
            if(user.getNickname().equals(nickname))
                return user;
        }
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
