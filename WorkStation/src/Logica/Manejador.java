package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import DataType.*;


public class Manejador {
    //Clase que conserva las colecciones globales del sistema
    
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    private List<Artista> artistas;
    private List<ListaDeReproduccion> Listas; // Listas por defecto
    private Genero genero=new Genero("General"); // Guarda el genero raiz
    private List<Genero> generosList;
    private List<Tema> Temas;//Guarda los temas en una lista
    private List<Album> Albums;
    private Album TemporalAlbum;
    private List<Genero> TemporalGeneros;
    
    //Ids para la identificadores
    private double IdTema;
    private double IdAlbum;
    private double IdList;
    
    //Para la base de datos
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab_Pro_AplPU" );
    
    
    private static Manejador instancia=null;
    
    private Manejador(){
        usuarios =new ArrayList();
        clientes=new ArrayList();
        artistas=new ArrayList();
        Listas=new ArrayList(); // Listas por defecto
        generosList=new ArrayList();
        Temas=new ArrayList();
        IdTema=0;
        IdAlbum=0;
        IdList=0;
        
        EntityManager entitymanager = emfactory.createEntityManager( );    
        Query q = entitymanager.createQuery("SELECT a FROM Cliente a");
        Query q2 = entitymanager.createQuery("SELECT a FROM Artista a");
        Query QGeneros = entitymanager.createQuery("SELECT a FROM Genero a");
        Query q3 = entitymanager.createQuery("SELECT a from Album a");
        Query q4 = entitymanager.createQuery("SELECT a from Tema a");
        clientes = q.getResultList();
        artistas = q2.getResultList();
        generosList = QGeneros.getResultList();
        Albums = q3.getResultList();
        Temas = q4.getResultList();
        
        
        
        
        GeneralGetHijos();
    }
    
    private void GeneralGetHijos(){
        Iterator it = generosList.iterator();
        Genero g;
        while(it.hasNext()){
            g=(Genero) it.next();
            if(g.getPadre().equals(genero.getNombre())){
                genero.addHijo(g);
            }
            else{
                Genero padre = findGenero(g.getPadre());
                if(padre!=null){
                    padre.addHijo(g);
                }
            }
        }
    }
    
     public List getAlbumsItem() {
        Iterator it = Albums.iterator();
        List ret= new ArrayList();
        Album L;
        while(it.hasNext()){
            L= (Album) it.next();
            ret.add(new Item(L,L.getNombre()));
        }
        return ret;
    }
     
     public List getListasItem() {
        Iterator it = Listas.iterator();
        List ret= new ArrayList();
        ListaDeReproduccion L;
        while(it.hasNext()){
            L= (ListaDeReproduccion) it.next();
            ret.add(new Item(L,L.getNombre()));
        }
        return ret;
    }
    
    public List getTemasItem() {
        Iterator it = Temas.iterator();
        List ret= new ArrayList();
        Tema L;
        while(it.hasNext()){
            L= (Tema) it.next();
            ret.add(new Item(L,L.getNombre()));
        }
        return ret;
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
    
    public void addCliente(Cliente usu){
        clientes.add(usu);
        EntityManager entitymanager = emfactory.createEntityManager( );  
        try{
            entitymanager.getTransaction().begin();
            entitymanager.persist(usu);
            entitymanager.getTransaction().commit();
            entitymanager.close(); 
        }
        catch (Exception e) {
            e.printStackTrace();
            entitymanager.getTransaction().rollback();
        } 
    } 
    
    public void addArtista(Artista usu){
        artistas.add(usu); 
        EntityManager entitymanager = emfactory.createEntityManager( );    
        try {
            entitymanager.getTransaction().begin();
            entitymanager.persist(usu);
            entitymanager.getTransaction().commit();
            entitymanager.close(); 
        }
        catch (Exception e) {
            e.printStackTrace();
            entitymanager.getTransaction().rollback();
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
    
    public boolean artistLibre(String nombre){
            if(this.obtenerArtista(nombre)== null)
                return true;
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
    
    public void createTemporalAlbum(){
        this.TemporalAlbum = new Album();
    }
    
    public void deleteTemporalAlbum(){
        this.TemporalAlbum = null;
    }
    
    public Album getTemporalAlbum(){
        return this.TemporalAlbum;
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
        Iterator it = user.getListas().iterator();
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
            if(user.getNickname().equals(text)){
                return true;
            }
        }
        return false;
    }

    public void persist(Object object) {
        EntityManager entitymanager = emfactory.createEntityManager( );
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

    public Genero findGenero(String text) {
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
        EntityManager entitymanager = emfactory.createEntityManager( );    
        try {
            entitymanager.getTransaction().begin();
            entitymanager.persist(nuevoGen);
            entitymanager.getTransaction().commit();
            entitymanager.close(); 
        }
        catch (Exception e) {
            e.printStackTrace();
            entitymanager.getTransaction().rollback();
        } 
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
    

    public List ItemCLiente() {
        Iterator it=clientes.iterator();
        Cliente c;
        List ret= new ArrayList();
        while(it.hasNext()){
            c=(Cliente) it.next();
            ret.add(new Item(c, c.getNickname()));
        }
        return ret;
    }
    
    
    
    public List ItemArtista() {
        Iterator it=artistas.iterator();
        Artista c;
        List ret= new ArrayList();
        while(it.hasNext()){
            c=(Artista) it.next();
            ret.add(new Item(c, c.getNickname()));
        }
        return ret;
    }

    public List ItemTemas() {
        Iterator it=Temas.iterator();
        Tema t;
        List ret= new ArrayList();
        while(it.hasNext()){
            t=(Tema)it.next();
            ret.add(new Item(t, t.getNombre()));
        }
        return ret;
    }
    
    public List ItemGenero() {
        Iterator it=generosList.iterator();
        Genero t;
        List ret= new ArrayList();
        while(it.hasNext()){
            t=(Genero)it.next();
            ret.add(new Item(t, t.getNombre()));
        }
        return ret;
    }

    public void updatePersistGen(Genero gen) {
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.merge(gen);
    }

    public List getListasDefectoItem() {
        Iterator it = Listas.iterator();
        List ret = new ArrayList();
        ListaDeReproduccion lista;
        while(it.hasNext()){
            lista = (ListaDeReproduccion) it.next();
            ret.add(new Item(lista, lista.getNombre()));
        }
        return ret;
    }
    
    public void configTemporalAlbum(Artista artist, String nombre, List<Genero> generos, int año, String imagePath){
        this.TemporalAlbum.setArtista(artist);
        this.TemporalAlbum.setNombre(nombre);
        this.TemporalAlbum.setGenero(generos);
        this.TemporalAlbum.setAnio(año);
        this.TemporalAlbum.setImg(imagePath);
    }
    
    public void addTemporalAlbum(Artista artist){        
        EntityManager em = emfactory.createEntityManager( );
        //Artista artista = em.find(Artista.class, artist.id);
        try {
            em.getTransaction().begin();
            Album albumToAdd = new Album(this.TemporalAlbum);
            List<Genero> generos = this.TemporalAlbum.getGeneros();
            addAlbumToGeneros(generos, albumToAdd);
            em.persist(albumToAdd);
            albumToAdd.addTema(new Tema("1",1,1,albumToAdd));
            em.getTransaction().commit(); 
            em.close();         
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }         
        deleteTemporalAlbum();        
        
    }
    
    public void addAlbumToGeneros(List<Genero> generos, Album album){
        Iterator it=generos.iterator();
        Genero g;
        while(it.hasNext()){
            g=(Genero) it.next();
            g.addAlbum(album);
        }
    }
    
    public void createTemporalGenres(){
        this.TemporalGeneros = new ArrayList();
    }
    
    public void addToTemporalGenres(Genero genero){
        this.TemporalGeneros.add(genero);
    }
    
    public void wipeTemporalGenres(){
        this.TemporalGeneros = null;
    }
    
    public List<Genero> getTemporalGenres(){
        return this.TemporalGeneros;
    }
    
    public void addAlbum(Album album){
        this.Albums.add(album);
    }
    
    public void addTema(Tema tema){
        this.Temas.add(tema);
    }

    public List getAllListsAsItem() {
        List ret = new ArrayList();
        Iterator itC = clientes.iterator();
        Cliente c;
        while(itC.hasNext()){
            c=(Cliente) itC.next();
            ret.addAll(c.getListasPublicas());
        }
        ret.addAll(this.getListasDefectoItem());        
        return ret;
    }    




/////////////////////////////////////FUNCIONES DE SERVLET//////////////////////////////////////////////



    public DTUsuario getUserData(String nick) {
        DTUsuario ret = null;
        Usuario u;
        Iterator it = clientes.iterator();
        while(it.hasNext()){
            u=(Usuario) it.next();
            if(u.getNickname().equals(nick)){
                ret=new DTUsuario(u);
            }            
        }
        return ret;
    }
}
