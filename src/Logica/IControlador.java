package Logica;
import java.awt.image.BufferedImage;
import java.util.List;

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
    
    public abstract void AltaGenero(String nombre, String padre);
    public abstract Genero GetGenero();
    public abstract Genero getGeneroPorNombre(String nombre);
    //public abstract void AgregarTema(Usuario user, );//Agregar tema a lista
    public abstract void SeguirUsuario(String seguidor, String seguido);
    public abstract void ConsultarAlbum();

    public abstract boolean FindUser(String text);
    public abstract boolean nicknameLibre(String nickname);
    public abstract boolean mailLibre(String mail);
    public abstract Cliente consultarCliente(String nickname);
    public abstract Artista consultarArtista(String nickname);
    public abstract List getItemCliente();

    public abstract List getTemasItem();

    public abstract void agregarTemaALista(Object selectedItem, Object selectedItem0);
    
    public abstract void quitarTemaDeLista(Object selectedItem, Object selectedItem0);

    public abstract void QuitarTemaFavorito(Object selectedItem, Object selectedItem0);

    public abstract void QuitarAlbumFav(Object selectedItem, Object selectedItem0);

    public abstract void QuitarListaFav(Object selectedItem, Object selectedItem0);

    public abstract List getAlbumPorGenItem(String s);

    public abstract List getItemArtist();
    public abstract void addListaParticular(Cliente client, String nombreDeLista, String imagenDeLista);
    public abstract void addListaPorDefecto(Genero genero, String nombreDeLista, String imagenDeLista);
    public abstract void privatizarLista(ListaParticular lista, boolean modo);
    public ListaParticular getListByName(Cliente user, String name);

    public boolean artistLibre(String artistAlbum);

    public void GuardarListaFav(Object selectedItem, Object selectedItem0);

    public void GuardarTemaFav(Object selectedItem, Object selectedItem0);

    public void GuardarAlbumFav(Object selectedItem, Object selectedItem0);

    public void DejarSeguirUsuario(String seguidor, String seguido);

    public void AltaAlbum(String newAlb, String toGen);
}

