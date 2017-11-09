package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import DataType.*;
import Enums.EstadosDeSuscripcion;
import Enums.TiposDeSuscripcion;

/**
 *
 * @author Casca
 */
public class Controlador implements IControlador {
    
    public Controlador(){
        
    }
    
    @Override
    public void registrarCliente(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen){
        
        Manejador mu = Manejador.getinstance();
        if (!mu.ClienteNickRepetido(nickname) && !mu.ClienteMailRepetido(mail)){
            Cliente user = new Cliente(nickname, contraseña, mail, nombre, apellido,
                                       fechaDeNacimiento, imagen);
            mu.addCliente(user);
        }
    } 
        
    public void registrarArtista(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen,
                    String biografia, String dir_web){
        
        Manejador mu = Manejador.getinstance();
        if(!mu.ArtistaNickRepetido(nickname) && !mu.ArtistaMailRepetido(mail)){
            Artista user = new Artista(biografia, dir_web, nickname, contraseña, mail, nombre, apellido,
                                            fechaDeNacimiento, imagen);
            mu.addArtista(user);
        }
    }
    
    @Override
    public List<Cliente> getListaClientes(){
        Manejador mu = Manejador.getinstance();
        List<Cliente> clientes = mu.getClientes();
        return clientes;
    }
      
    @Override
    public void AltaGenero(String nombre, String padre){
        if(!nombre.equals("General")){ 
            Manejador mu = Manejador.getinstance();
            Genero gen;
            Genero nuevoGen=mu.findGenero(nombre);
            if(nuevoGen==null){
                nuevoGen=new Genero(nombre);
                if(padre.equals("") || padre.equals("General")){
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
    }
    

    @Override
    public Genero GetGenero(){
        Manejador M=Manejador.getinstance();
        return M.getGenero();
    }
    
    @Override
    public Genero getGeneroPorNombre(String nombre){
        Manejador M=Manejador.getinstance();
        return M.getGeneroPorNombre(nombre);
    }

    /*@Override
    public boolean FindUser(String text){
        Manejador M=Manejador.getinstance();
        return (M.FindUser(text));
    }*/

    @Override
    public void SeguirUsuario(Item seguidor, Item seguido) {
       Usuario u1 = (Usuario) seguidor.getValue();
       Usuario u2 = (Usuario) seguido.getValue();
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
    public List getItemArtista(){
        Manejador M=Manejador.getinstance();
        List ret=M.ItemArtista();
        return ret;       
    }
    
    @Override
    public List getTemasItem(){
     Manejador M=Manejador.getinstance();
     List ret=M.ItemTemas();
     return ret;
    }    
    
    @Override
    public List getItemSuscripciones(){
        Manejador M=Manejador.getinstance();
        List ret = M.ItemSuscripciones();
        return ret;
    }
    
    @Override
    public List getGeneroItem(){
     Manejador M=Manejador.getinstance();
     List ret=M.ItemGenero();
     return ret;
    } 
    
    @Override
    public void agregarTemaALista(Object Lista, Object Tema){
        Item l = (Item) Lista;
        Item t = (Item) Tema;
        ListaDeReproduccion lista = (ListaDeReproduccion) l.getValue();
        Tema tem = (Tema) t.getValue();
        lista.agregarTema(tem);
    }
    
    @Override
    public void QuitarTemaFavorito(Item cliente, Item tema){
        Cliente c = (Cliente) cliente.getValue();
        Tema t = (Tema) tema.getValue();
        c.quitarTemaFav(t);
    }
    
    @Override
    public void QuitarAlbumFav(Item cliente, Item album){
        Cliente client = (Cliente) cliente.getValue();
        Album a = (Album) album.getValue();
        client.quitarAlbumFav(a); 
    }

    @Override
    public void QuitarListaFav(Item cliente, Item lista){
        Cliente c = (Cliente) cliente.getValue();
        ListaDeReproduccion l = (ListaDeReproduccion) lista.getValue();
        c.quitarListFav(l);
    }
    
    @Override
    public List getAlbumPorGenItem(String s){
        Manejador M=Manejador.getinstance();
        List generos=M.getListGeneros();
        List ret= new ArrayList();
        Iterator it = generos.iterator();
        
        //Busca el genero
        Genero g=null;
        while(it.hasNext()){
            g=(Genero) it.next();
            if(s.equals(g.getNombre())){
                break;
            }
            else g=null;
        }
        
        //Busca los albums dentro del genero
        if(g!=null){
            Iterator itAlbum = g.getAlbums().iterator();
            Album alb;
            while(itAlbum.hasNext()){
                alb= (Album) itAlbum.next();
                ret.add(new Item(alb,alb.getNombre()));
            }
        }
        return ret;
    }
    
    @Override
    public List getItemArtist(){
        Manejador M=Manejador.getinstance();
        Iterator it=M.getArtistas().iterator();
        Artista art;
        List ret=new ArrayList();
        while(it.hasNext()){
            art=(Artista)it.next();
            ret.add(new Item(art,art.getNickname()));
        }
        return ret;
    }
    @Override
    public void addListaParticular(Cliente client, String nombreDeLista, String imagenDeLista){
        Manejador M=Manejador.getinstance();
        if (client != null && !nombreDeLista.equals("") && !imagenDeLista.equals(""))
        M.addListaParticular(client, nombreDeLista, imagenDeLista);
    }
    
    @Override
    public void addListaPorDefecto(Genero genero, String nombreDeLista, String imagenDeLista){
        Manejador M=Manejador.getinstance();
        if (genero != null && !nombreDeLista.equals("") && !imagenDeLista.equals(""))
        M.addListaPorDefecto(genero, nombreDeLista, imagenDeLista);
    }
    
    @Override
    public void privatizarLista(ListaParticular lista, boolean modo){
        if(lista != null){
            lista.setPrivacidad(modo);
        }
        
    }
    
    @Override
    public ListaParticular getListByName(Cliente user, String name){
        Manejador M=Manejador.getinstance();
        return M.getListaPorNombre(user, name);
    }
    
     @Override
    public boolean artistLibre(String artistAlbum) {
        Manejador M=Manejador.getinstance();
        return M.artistLibre(artistAlbum);
    }

    @Override
    public void GuardarTemaFav(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item tem = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Tema t = (Tema) tem.getValue();
        client.guardarTemaFav(t);
    }
    
    @Override
    public void GuardarAlbumFav(Object selectedItem, Object selectedItem0){
        Item usr = (Item) selectedItem;
        Item alb = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Album a = (Album) alb.getValue();
        client.guardarAlbumFav(a); 
    }
    
    @Override
    public void DejarSeguirUsuario(Item seguidor, Item seguido) {
       Usuario u1 = (Usuario) seguidor.getValue();
       Usuario u2 = (Usuario) seguido.getValue();
       if(u1!=null && u2!=null){
           u1.removeFollow(u2);
           u2.removeFollower(u1);
       }
       else{
           System.out.println("kek");
       }
    }  
    
    @Override
    public List getListasDefectoItem(){
        Manejador M=Manejador.getinstance();
        return M.getListasDefectoItem();
    }

    @Override
    public void GuardarListaFav(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item lst = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        ListaDeReproduccion lista = (ListaDeReproduccion) lst.getValue();
        client.guardarListFav(lista);
    }

    @Override
    public void AgregarTema(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void quitarTemaDeLista(Object selectedItem, Object selectedItem0) {
        Item l = (Item) selectedItem;
        Item t = (Item) selectedItem0;
        ListaDeReproduccion lista = (ListaDeReproduccion) l.getValue();
        Tema tem = (Tema) t.getValue();
        lista.quitarTema(tem);
    }

    @Override
    public void QuitarTemaFavorito(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item tem = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Tema t = (Tema) tem.getValue();
        client.quitarTemaFav(t);
    }

    @Override
    public void QuitarAlbumFav(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item alb = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        Album a = (Album) alb.getValue();
        client.quitarAlbumFav(a); 
    }

    @Override
    public void QuitarListaFav(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item lst = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        ListaDeReproduccion lista = (ListaDeReproduccion) lst.getValue();
        client.quitarListFav(lista);
    }

    @Override
    public void GuardarTemaFavorito(Object selectedItem, Object selectedItem0) {
        Item usr = (Item) selectedItem;
        Item lst = (Item) selectedItem0;
        Cliente client = (Cliente) usr.getValue();
        ListaDeReproduccion lista = (ListaDeReproduccion) lst.getValue();
        client.guardarListFav(lista);
    }
    
    @Override
    public void DejarDeSeguirUsuario(String seguidor, String seguido){
        Manejador M=Manejador.getinstance();
         Usuario u1 = M.obtenerUsuario(seguidor);
         Usuario u2 = M.obtenerUsuario(seguido);
         if(u1!=null && u2!=null){
             u1.removeFollow(u2);
             u2.removeFollower(u1);
       }
    }
    
    @Override
    public void createTemporalAlbum(){
        Manejador M=Manejador.getinstance();
        M.createTemporalAlbum();
    }
    
    @Override
    public void deleteTemporalAlbum(){
        Manejador M=Manejador.getinstance();
        M.deleteTemporalAlbum();
    }
    
    @Override
    public void configTemporalAlbum(Artista artist, String nombre, List<Genero> generos, int año, String imagePath){
        Manejador M=Manejador.getinstance();
        M.configTemporalAlbum(artist, nombre, generos, año, imagePath);
        
    }
    
    @Override
    public void addTemaToM(Tema tema){
        Manejador M=Manejador.getinstance();
        M.addTema(tema);
    }
    
    @Override
    public void addTemporalAlbum(Artista artist){
        Manejador M=Manejador.getinstance();
        M.addTemporalAlbum(artist);
    }
    
    @Override
    public void createTemporalGenres(){
        Manejador M=Manejador.getinstance();
        M.createTemporalGenres();
    }
    
    @Override
    public void addToTemporalGenres(Genero genero){
        Manejador M=Manejador.getinstance();
        M.addToTemporalGenres(genero);
    }
    
    @Override
    public void wipeTemporalGenres(){
        Manejador M=Manejador.getinstance();
        M.wipeTemporalGenres();
    }
    
    @Override
    public List<Genero> getTemporalGenres(){
        Manejador M=Manejador.getinstance();
        return M.getTemporalGenres();
    }
    
    @Override
    public Album getTemporalAlbum(){
        Manejador M=Manejador.getinstance();
        return M.getTemporalAlbum();
    }
    
    @Override
    public String absolutePathToRelative(String path){
        Pattern p = Pattern.compile("\\w+\\\\data\\\\user_images\\\\\\w+.jpg|\\\\\\w+\\\\data\\\\user_images\\\\\\w+.png");
        Pattern p2 = Pattern.compile("(\\\\\\w+)+\\\\data\\\\user_images\\\\\\w+(.png|.jpg)");
        Matcher m = p2.matcher(path);
        if(m.matches()){
            int relativeIndex = path.indexOf("user_images/");
            int finalRelativeIndex = relativeIndex + 12;
            String relative = path.substring(finalRelativeIndex);
            return relative;
        }
        else
            return "../WebApp/web/imagenes/default.jpg";
    }

    @Override
    public List getAlbumsAsItem(){
        Manejador M=Manejador.getinstance();
        return M.getAlbumsItem();
    }
    
    @Override
    public List getListasAsItem(){
        Manejador M=Manejador.getinstance();
        return M.getAllListsAsItem();
    }
    
    
    /////////////////////////////////////FUNCIONES DE SERVLET//////////////////////////////////////////////

    @Override
    public DTUsuario getUserData(String nick){
        Manejador M=Manejador.getinstance();
        return M.getUserData(nick);
    }    
    
    
    @Override
    public void WebAltaCliente(String nick, String mail, String fecha, String pass, String nombre, String apellido){
        Matcher m = Pattern.compile("\\d+").matcher(fecha);
        List<Integer> numbers = new ArrayList<Integer>();
        while(m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        Fecha f = new Fecha(numbers.get(0), numbers.get(1), numbers.get(2));
        this.registrarCliente(nick, pass, mail, nombre, apellido, f, "");
    }
    
    
    
    public void addListaParticular(String user, String nombreLista, String img){
        Manejador m = Manejador.getinstance();
        Cliente c = m.obtenerCliente(user);
        if(c!=null){
            this.addListaParticular(c, nombreLista, img);
        }
    }

    @Override
    public void AgregarTemaListaWeb(String user, String lista, String artista, String album, String tema) {
        Manejador m = Manejador.getinstance();
        m.AgregarTemaListaWeb(user, lista, artista, album, tema);
    }
    
    @Override
    public void actualizarEstadoDeSuscripcion(Suscripcion s, EstadosDeSuscripcion estado){
        if(s!=null && s.getEstado()==EstadosDeSuscripcion.Pendiente){
            s.setEstado(estado);
            Fecha fechaDeInicio = new Fecha();
            fechaDeInicio.setCurrentDate(); 
            s.setFechaDeInicio(fechaDeInicio);
            s.updateFechaDeVencimiento();
        }
    }

    @Override
    public void actualizarEstadoDeSuscripcionWeb(Cliente cliente, EstadosDeSuscripcion estado) {
        Suscripcion s = cliente.getSuscripcion();
        s.setEstado(estado);
    }

    @Override
    public void contratarSuscripcion(Cliente cliente, TiposDeSuscripcion tipo) {
        Manejador M=Manejador.getinstance();
        Suscripcion s = new Suscripcion(cliente, tipo);        
        M.addSuscripcion(cliente, s);
    }

    @Override
    public DataSession getUserSession(String identificador, String pass){
        Manejador M=Manejador.getinstance();
        return M.getUserSession(identificador, pass);
    } 

    @Override
    public void setTemporalAlbum(Album album) {
        Manejador M=Manejador.getinstance();
        M.setTemporalAlbum(album);
    }

    @Override
    public List<String> GenerosToString(List<Genero> generos) {
       Iterator it =generos.iterator();
       Genero gen;
       String genString;
       List<String> ret = new ArrayList();
       while(it.hasNext()){
           gen = (Genero) it.next();
           genString = gen.getNombre();
           ret.add(genString);
       }
       return ret;
    }

    @Override
    public List<String> getGenerosInString() {
        Manejador M=Manejador.getinstance();
        List<Genero> generosRet = M.getListGeneros();
        List<String> ret = GenerosToString(generosRet);
        return ret;
    }

    @Override
    public List<Genero> getGeneros() {
        Manejador M=Manejador.getinstance();
        return M.getListGeneros();
    }

    @Override
    public List<String> getArtistas() {
        Manejador M=Manejador.getinstance();
        List<Artista> artistas = M.getArtistas();        
        Iterator it =artistas.iterator();
        Artista art;
        String artString;
        List<String> ret = new ArrayList();
        while(it.hasNext()){
            art = (Artista) it.next();
            artString = art.getNickname();
            ret.add(artString);
       }
        return ret;
    }

    @Override
    public void ActualizarImagenUsuario(String UserNick, String path) {
        Manejador M = Manejador.getinstance();
        M.ActualizarImagenUsuario(UserNick, path);
    }
    
    @Override
    public List<Album> getAlbumsList() {
        Manejador M = Manejador.getinstance();
        return M.getAlbumList();
    }

    @Override
    public Album getAlbumByName(String albumname) {
        Manejador M = Manejador.getinstance();
        return M.getAlbumByName(albumname);
    }

    @Override
    public List<String> getAlbumsListtoString() {
       List<Album> albums = getAlbumsList();
       Iterator it = albums.iterator();
       List<String> ret = new ArrayList();
       Album alb;
       String albString;
       while(it.hasNext()){
           alb = (Album) it.next();
           albString = alb.getNombre();
           ret.add(albString);
       }
       return ret;
    }

    @Override
    public List<String> albumListToString(List<Album> albums) {
        Iterator it = albums.iterator();
        List<String> ret = null;
        Album album;
        String str;
        while(it.hasNext()){
            album = (Album) it.next();
            str = album.getNombre();
            ret.add(str);
        }
        
        return ret;
    }
 
 }