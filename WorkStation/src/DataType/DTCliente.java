package DataType;

import Logica.Usuario;
import java.util.List;

public class DTCliente extends DTUsuario{
    private List<DTUsuario> siguiendo;
    //private List <DTTema> temasFav;
    private List <DTAlbum> albumFav;
    private List listasFav;
    private List ListasDeReproduccion;

    public DTCliente(Usuario u) {
        super(u);
        /*siguiendo = u.getDTSiguiendo();
        temasFav = u.getDTTemasFav();
        albumFav = u.getDTAlbumFav();
        listasFav = u.getDTListasFav();
        ListasDeReproduccion = u.getDTListasDeReproduccion();*/
    }

    public List<DTUsuario> getSiguiendo() {
        return siguiendo;
    }

    /*public List<DTTema> getTemasFav() {
        return temasFav;
    }*/

    public List<DTAlbum> getAlbumFav() {
        return albumFav;
    }

    public List getListasFav() {
        return listasFav;
    }

    public List getListasDeReproduccion() {
        return ListasDeReproduccion;
    }
    
    
}
