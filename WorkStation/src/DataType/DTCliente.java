package DataType;

import Logica.Cliente;
import Logica.Usuario;
import java.util.List;

public class DTCliente extends DTUsuario{
    private List<DTUsuario> siguiendo;
    private List <DTTema> temasFav;
    private List albumFav;
    private List listasFav;
    private List ListasDeReproduccion;

    public DTCliente(Usuario u) {
        super(u);
        Cliente c = (Cliente) u;
        siguiendo = c.getSiguiendoWeb();
        temasFav = c.getTemasWeb();
        albumFav = c.getAlbumWeb();
        listasFav = c.getListasFavWeb();
        ListasDeReproduccion = c.getListasWeb();
    }

    public List<DTUsuario> getSiguiendo() {
        return siguiendo;
    }

    public List<DTTema> getTemasFav() {
        return temasFav;
    }

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
