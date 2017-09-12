package Logica;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Casca
 */
public interface IControlador{
    public abstract void registrarUsuario(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, String imagen, String usertype,
                    String biografia, String dir_web);
    
    public abstract void AltaGenero(String nombre, String padre);
    public abstract Genero GetGenero();
    //public abstract void AgregarTema(Usuario user, );//Agregar tema a lista
    public abstract void SeguirUsuario(String seguidor, String seguido);
    public abstract void EliminarTemaFav();//Eliminar Tema, Album o lista de favoritos
    public abstract void ConsultarAlbum();

    public abstract boolean FindUser(String text);
    public abstract boolean nicknameLibre(String nickname);
    public abstract boolean mailLibre(String mail);
    public abstract Cliente consultarCliente(String nickname);
    public abstract Artista consultarArtista(String nickname);
    public abstract List getItemCliente();

    public abstract List getTemasItem();

    public abstract void agregarTemaALista(Object selectedItem, Object selectedItem0);
}

