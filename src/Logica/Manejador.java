package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
        Listas=new ArrayList(); // Listas por defecto
        generosList=new ArrayList();
        IdTema=0;
        IdAlbum=0;
        IdList=0;
        
        Query q = entitymanager.createQuery("SELECT a FROM Cliente a");
        Query q2 = entitymanager.createQuery("SELECT a FROM Artista a");
        clientes = q.getResultList();
        artistas = q2.getResultList();
        
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
        //String nickname = usu.getNickname(); //si no existe en la lista
        //usuarios.add(usu);
        if(userType=="Cliente"){
            Cliente cliente = (Cliente) usu;            
            clientes.add(cliente); 
             try {
                entitymanager.getTransaction().begin();
                entitymanager.persist(cliente);
                entitymanager.getTransaction().commit();
                entitymanager.close(); 
             }
             catch (Exception e) {
                e.printStackTrace();
                entitymanager.getTransaction().rollback();
            } 
        }
        if(userType=="Artista"){
              Artista artista = (Artista) usu;
              artistas.add(artista); 
              try {
                entitymanager.getTransaction().begin();
                entitymanager.persist(artista);
                entitymanager.getTransaction().commit();
                entitymanager.close(); 
              }
              catch (Exception e) {
                e.printStackTrace();
                entitymanager.getTransaction().rollback();
              } 
           } 
    } 
        
    public boolean nicknameLibre(String nickname){
        if(this.obtenerCliente(nickname) == null){
            if(this.obtenerArtista(nickname)== null)
                return true;
        }
        return false;
    }  
    
    public boolean mailLibre(String mail){
        if(this.obtenerClientePorMail(mail) == null){
            if(this.obtenerArtistaPorMail(mail)== null)
                return true;
        }
        return false;
    } 
    
   
    public Usuario obtenerClientePorMail(String mail){
        Iterator it = clientes.iterator();
        Cliente user;
        while(it.hasNext()){
            user = (Cliente)it.next();
            if(user.getMail().equals(mail))
                return user;
        }
        return null;
    }
    public Usuario obtenerArtistaPorMail(String mail){
        Iterator it = artistas.iterator();
        Artista user;
        while(it.hasNext()){
            user = (Artista)it.next();
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
    
    public Genero getGeneroPorNombre(String nombre){
        Iterator it = generosList.iterator();
        Genero user;
        while(it.hasNext()){
            user = (Genero)it.next();
            if(user.getNombre().equals(nombre))
                return user;
        }
        return null;
    }
    
    public ListaParticular getListaPorNombre(Cliente user, String nombre){
        List<ListaDeReproduccion> listas = user.getListas();
        Iterator it = listas.iterator();
        ListaDeReproduccion lista;
        while(it.hasNext()){
            lista = (ListaDeReproduccion)it.next();
            if(lista.getNombre().equals(nombre)){
                ListaParticular listaFinal = (ListaParticular) lista;
                return listaFinal;
            }
                
        }
        return null;
    }
    
    public List<Genero> getListGeneros(){
        return generosList;
    }

    boolean FindUser(String text) {
        Iterator it=usuarios.iterator();
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
    
    void addListaParticular(Cliente client, String nombreDeLista, String imagenDeLista){
        ListaParticular lista = new ListaParticular(client, nombreDeLista, imagenDeLista);
        client.setListaParticular(lista);
    }
    
    void addListaPorDefecto(Genero genero, String nombreDeLista, String imagenDeLista){
        ListaPorDefecto lista = new ListaPorDefecto(genero, nombreDeLista, imagenDeLista);
        this.Listas.add(lista);
    }
    
}
