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
    public void AltaGenero(String nombre, String padre){
        Manejador mu = Manejador.getinstance();
        Genero gen;
        Genero nuevoGen=mu.findGenero(nombre);
        if(nuevoGen==null){
            nuevoGen=new Genero(nombre);
            if(padre.equals("") || padre.equals("General")){
                //System.out.println("sin padre");
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
    public Genero getGeneroPorNombre(String nombre){
        Manejador M=Manejador.getinstance();
        return M.getGeneroPorNombre(nombre);
    }
    
    public void AgregarTema(){
    
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
    public List getTemasItem(){
     Manejador M=Manejador.getinstance();
     List ret=M.ItemTemas();
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
        Cliente client = (Cliente) cliente.getValue();
        Tema t = (Tema) tema.getValue();
        client.quitarTemaFav(t);
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
            ret.add(new Item(art,art.getNombre()));
        }
        return ret;
    }
    @Override
    public void addListaParticular(Cliente client, String nombreDeLista, String imagenDeLista){
        Manejador M=Manejador.getinstance();
        M.addListaParticular(client, nombreDeLista, imagenDeLista);
    }
    
    @Override
    public void addListaPorDefecto(Genero genero, String nombreDeLista, String imagenDeLista){
        Manejador M=Manejador.getinstance();
        M.addListaPorDefecto(genero, nombreDeLista, imagenDeLista);
    }
    
    @Override
    public void privatizarLista(ListaParticular lista, boolean modo){
        lista.setPrivacidad(modo);
    }
    
    @Override
    public ListaParticular getListByName(Cliente user, String name){
        Manejador M=Manejador.getinstance();
        return M.getListaPorNombre(user, name);
    }
    
     @Override
    public boolean artistLibre(String artistAlbum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GuardarTemaFav(Object selectedItem, Object selectedItem0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List getListasDefectoItem(){
        Manejador M=Manejador.getinstance();
        return M.getListasDefectoItem();
    }

    @Override
    public void GuardarListaFav(Object selectedItem, Object selectedItem0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
