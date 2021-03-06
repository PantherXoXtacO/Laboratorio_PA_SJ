package Logica;



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario{
    private List<Usuario> siguiendo;
    private List<Tema> temasFav;
    private List<Album> albumsFav;
    private List<ListaDeReproduccion> listasFav;
    private List<ListaDeReproduccion> Listas; //Listas propias creadas por el usuario

    
    
    public Cliente(String nickname, String contraseña, String mail,
                    String nombre, String apellido, Fecha fechaDeNacimiento,
                    String imagen) {
        super(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        this.siguiendo = new ArrayList();
        this.temasFav = new ArrayList();
        this.albumsFav = new ArrayList();
        this.listasFav = new ArrayList();
        this.Listas = new ArrayList();
    }

    public Cliente() {
    }   
    
    public List<ListaDeReproduccion> getListas(){
        return this.Listas;
    }
    
    @Override
    public void addFollow(Usuario u2) {
        siguiendo.add(u2);
    }    
    
    @Override
    void removeFollow(Usuario u2) {
        siguiendo.remove(u2);
    } 
    
    void setListaParticular(ListaDeReproduccion lista){
        this.Listas.add(lista);
    }
    

    public List getListsItem() {
        Iterator it = Listas.iterator();
        List ret= new ArrayList();
        ListaDeReproduccion L;
        while(it.hasNext()){
            L= (ListaDeReproduccion) it.next();
            ret.add(new Item(L,L.getNombre()));
        }
        return ret;
    }

    public List getTemasFavItem() {
        Iterator it = temasFav.iterator();
        List ret= new ArrayList();
        Tema T;
        while(it.hasNext()){
            T= (Tema)it.next();
            ret.add(new Item(T,T.getNombre()));
        }
        return ret;
    }

    public void quitarTemaFav(Tema t) {
        temasFav.remove(t);
    }

    public void quitarAlbumFav(Album a) {
        albumsFav.remove(a);
    }

    public List getListsFavItem() {
        Iterator it = listasFav.iterator();
        List ret= new ArrayList();
        ListaDeReproduccion L;
        while(it.hasNext()){
            L= (ListaDeReproduccion)it.next();
            ret.add(new Item(L,L.getNombre()));
        }
        return ret;
    }

    public void quitarListFav(ListaDeReproduccion lista) {
        listasFav.remove(lista);
    }

    public List getAlbumsFavItem() {
        Iterator it = albumsFav.iterator();
        Album a;
        List ret =new ArrayList();
        while(it.hasNext()){
            a= (Album) it.next();
            ret.add(new Item(a,a.getNombre()));
        }
        return ret;
    }
}
