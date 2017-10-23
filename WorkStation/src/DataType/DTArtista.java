package DataType;

import Logica.Album;
import Logica.Artista;
import Logica.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DTArtista extends DTUsuario{
    private String biografia;
    private String dir_web;
    private List<DTAlbum> albums;

    public DTArtista(Usuario u) {
        super(u);
        Artista a = (Artista) u;
        String biografia = a.getBiografia();
        String dir_web = a.getDir_web();
        Iterator it = a.getAlbums().iterator();
        albums = new ArrayList();
        while(it.hasNext()){
            albums.add(new DTAlbum ((Album)it.next()));
        }
    }

    public String getBiografia() {
        return biografia;
    }

    public String getDir_web() {
        return dir_web;
    }

    public List<DTAlbum> getAlbums() {
        return albums;
    }
}
