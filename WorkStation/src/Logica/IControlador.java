package Logica;
import java.awt.image.BufferedImage;
import java.util.List;
import DataType.*;
import Enums.EstadosDeSuscripcion;
import Enums.TiposDeSuscripcion;
/**
 *
 * @author Casca
 */
public interface IControlador{
    public abstract void registrarCliente(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen);
    public abstract void registrarArtista(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen,
                    String biografia, String dir_web);
    
    public abstract List<Cliente> getListaClientes();
    public abstract void AltaGenero(String nombre, String padre);
    public abstract Genero GetGenero();
    public abstract Genero getGeneroPorNombre(String nombre);
    //public abstract void AgregarTema(Usuario user, );//Agregar tema a lista
    public abstract void SeguirUsuario(Item seguidor, Item seguido);
    
    //public abstract boolean FindUser(String text);
    public abstract boolean nicknameLibre(String nickname);
    public abstract boolean mailLibre(String mail);
    public abstract Cliente consultarCliente(String nickname);
    public abstract Artista consultarArtista(String nickname);
    public abstract List getItemCliente();
    public abstract List getItemArtista();
    public abstract List getTemasItem();
    public abstract List getGeneroItem();
    public abstract List getItemSuscripciones();

    public abstract void agregarTemaALista(Object Lista, Object Tema);

    public abstract void QuitarTemaFavorito(Item cliente, Item tema);

    public abstract void QuitarAlbumFav(Item cliente, Item album);

    public abstract void QuitarListaFav(Item cliente, Item lista);

    public abstract List getAlbumPorGenItem(String s);

    public abstract List getItemArtist();
    public abstract void addListaParticular(Cliente client, String nombreDeLista, String imagenDeLista);
    public abstract void addListaPorDefecto(Genero genero, String nombreDeLista, String imagenDeLista);
    public abstract void privatizarLista(ListaParticular lista, boolean modo);
    public ListaParticular getListByName(Cliente user, String name);

    public abstract List getListasDefectoItem();
    public boolean artistLibre(String artistAlbum);

    public void GuardarListaFav(Object selectedItem, Object selectedItem0);
    public abstract void GuardarTemaFav(Object selectedItem, Object selectedItem0);
    public abstract void GuardarAlbumFav(Object selectedItem, Object selectedItem0);
    public abstract void DejarSeguirUsuario(Item seguidor, Item seguido);
    
    
    
    public abstract void AgregarTema(Usuario user);
    public abstract void SeguirUsuario(String seguidor, String seguido);
    
    public abstract void quitarTemaDeLista(Object selectedItem, Object selectedItem0);

    public abstract void QuitarTemaFavorito(Object selectedItem, Object selectedItem0);

    public abstract void QuitarAlbumFav(Object selectedItem, Object selectedItem0);

    public abstract void QuitarListaFav(Object selectedItem, Object selectedItem0);
    public abstract void GuardarTemaFavorito(Object selectedItem, Object selectedItem0);
    public abstract void DejarDeSeguirUsuario(String seguidor, String seguido);
    public abstract void createTemporalAlbum();
    public abstract void deleteTemporalAlbum();
    public abstract void configTemporalAlbum(Artista artist, String nombre, List<Genero> generos, int año, String imagePath);
    public abstract void addTemporalAlbum(Artista artist);
    public abstract void createTemporalGenres();
    public abstract void addToTemporalGenres(Genero genero);
    public abstract void wipeTemporalGenres();
    public abstract List<Genero> getTemporalGenres();
    public abstract Album getTemporalAlbum();
    public abstract void setTemporalAlbum(Album album);
    public abstract void addTemaToM(Tema tema);
    public abstract String absolutePathToRelative(String path);

    public abstract List getAlbumsAsItem();
    public abstract List getListasAsItem();
    
    
    /////////////////////////////////////FUNCIONES DE SERVLET//////////////////////////////////////////////
    public abstract DTUsuario getUserData(String nick);
    public abstract void WebAltaCliente(String nick, String mail, String fecha, String pass, String nombre, String apellido);
    public abstract void actualizarEstadoDeSuscripcion(Suscripcion s, EstadosDeSuscripcion estado);
    public abstract void actualizarEstadoDeSuscripcionWeb(Cliente cliente, EstadosDeSuscripcion estado);
    public abstract void contratarSuscripcion(Cliente cliente, TiposDeSuscripcion tipo);
    public abstract DataSession getUserSession(String identificador, String pass);
    public abstract void addListaParticular(String user, String nombreLista, String img);
    public abstract void AgregarTemaListaWeb(String user, String lista, String artista, String album, String tema);
    public abstract List<String> GenerosToString(List<Genero> generos);
    public abstract List<String> getGenerosInString(); 
    public abstract List<Genero> getGeneros();
}

