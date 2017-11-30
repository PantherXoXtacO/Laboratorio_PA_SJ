package DataType;

import Logica.Tema;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTTema {

    private String nombre;
    private int duracion;
    private int orden;
    private String path;
    private String album;
    
    
    public DTTema(Tema t) {
        this.nombre=t.getNombre();
        this.duracion=t.getDuracion();
        this.orden=t.getOrden();
        //this.path=t.getPath();
        this.album=t.getAlbum().getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getOrden() {
        return orden;
    }

    public String getPath() {
        return path;
    }

    public String getAlbum() {
        return album;
    }    
}
