package Logica;
import java.awt.image.BufferedImage;

/**
 *
 * @author Casca
 */
public interface IControlador{
    public abstract void registrarUsuario(String nickname, String contraseña,
                    String mail, String nombre, String apellido,
                    Fecha fechaDeNacimiento, BufferedImage imagen);
    public abstract DataUsuario verInfoUsuario(String nickname);
    
    public abstract void AltaGenero(String nombre, Genero padre);
    public abstract Genero GetGenero();
    //public abstract void AgregarTema(Usuario user, );//Agregar tema a lista
    public abstract void SeguirUsuario(String seguidor, String seguido);
    public abstract void EliminarTemaFav();//Eliminar Tema, Album o lista de favoritos
    public abstract void ConsultarAlbum();

    public abstract boolean FindUser(String text);
}

