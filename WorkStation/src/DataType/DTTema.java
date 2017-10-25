package DataType;

import Logica.Tema;


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
    
}
