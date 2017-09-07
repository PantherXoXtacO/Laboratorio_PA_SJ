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
    private final Genero genero=new Genero("General"); // Guarda el genero raiz
    private List<Genero> generosList;
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    //Para la base de datos
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab_Pro_AplPU" );
    EntityManager entitymanager = emfactory.createEntityManager( );    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuarios =new ArrayList();
        clientes=new ArrayList();
        artistas=new ArrayList();
        Listas=new ArrayList();
        generosList=new ArrayList();
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
    
    public void addUsuario(Usuario usu, String userType){ //El usuario sera Cliente o Artista
        String nickname = usu.getNickname(); //si no existe en la lista
        usuarios.add(usu);
        Usuario user = new Usuario(usu.getNickname(),"",usu.getMail(),usu.getNombre(),usu.getApellido(),null,null);
        
        try {
            entitymanager.getTransaction().begin();
            entitymanager.persist(user);
            entitymanager.getTransaction().commit();
            entitymanager.close();            
        } catch (Exception e) {
            e.printStackTrace();
            entitymanager.getTransaction().rollback();
        } 
  
        if(userType=="Cliente"){
            Cliente cliente = (Cliente) usu;
            clientes.add(cliente); 
           }
        if(userType=="Artista"){
              Artista artista = (Artista) usu;
              artistas.add(artista); 
           } 
    } 
    
    
    public boolean nicknameLibre(String nickname){
        return this.obtenerUsuario(nickname) == null; 
    }  
    
    public boolean mailLibre(String mail){
        return this.obtenerUsuarioPorMail(mail) == null; 
    } 
    
    public Usuario obtenerUsuarioPorMail(String mail){
        Iterator it = usuarios.iterator();
        Usuario user;
        while(it.hasNext()){
            user = (Usuario)it.next();
            if(user.getMail().equals(mail))
                return user;
        }
        return null;
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
    
    public Cliente obtenerCliente(String nickname){
        Iterator it = clientes.iterator();
        Cliente user;
        while(it.hasNext()){
            user = (Cliente)it.next();
            if(user.getNickname().equals(nickname))
                return user;
        }
        return null;
    }
    
    public Artista obtenerArtista(String nickname){
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

    public void persist(Object object) {
        entitymanager.getTransaction().begin();
        try {
            entitymanager.persist(object);
            entitymanager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entitymanager.getTransaction().rollback();
        } finally {
            entitymanager.close();
        }
    }

    Genero findGenero(String text) {
        Iterator it=generosList.iterator();
        Genero g;
        while(it.hasNext()){
            g=(Genero)it.next();
            if(g.getNombre().equals(text))
                return g;
        }
        return null;
    }

    void addGeneroToList(Genero nuevoGen){
            generosList.add(nuevoGen);
    }
}
