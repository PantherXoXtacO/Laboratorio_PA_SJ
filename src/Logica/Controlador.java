package Logica;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Cliente user = new Cliente(nickname, contraseña, mail, nombre, apellido,
                                            fechaDeNacimiento, imagen);
        mu.addCliente(user);
    } 
        
    public void registrarArtista(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen,
                    String biografia, String dir_web){
        
        Manejador mu = Manejador.getinstance();
        Artista user = new Artista(biografia, dir_web, nickname, contraseña, mail, nombre, apellido,
                                            fechaDeNacimiento, imagen);
        mu.addArtista(user);
    }
    
    @Override
    public List<Cliente> getListaClientes(){
        Manejador mu = Manejador.getinstance();
        List<Cliente> clientes = mu.getClientes();
        return clientes;
    }
    
    @Override
    public List<Artista> getListaArtistas(){
        Manejador mu = Manejador.getinstance();
        List<Artista> artistas = mu.getArtistas();
        return artistas;
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
    
    @Override
    public void ConsultarAlbum(){
        
    }

    @Override
    public boolean FindUser(String text){
        Manejador M=Manejador.getinstance();
        return (M.FindUser(text));
    }

    @Override
    public void SeguirUsuario(Item seguidor, Item seguido) {
       Manejador M=Manejador.getinstance();
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
        if(tema != null){
            Manejador M=Manejador.getinstance();
            M.addTema(tema);
        }
        
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
            return "data/user_images/default.jpg";
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
    
    @Override
    public boolean usuario_libre(String nickname, String mail){
        return nicknameLibre(nickname) && mailLibre(mail);
    }
}
