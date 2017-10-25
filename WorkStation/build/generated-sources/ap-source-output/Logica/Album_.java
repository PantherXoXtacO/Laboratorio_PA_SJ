package Logica;

import Logica.Artista;
import Logica.Genero;
import Logica.Tema;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-25T12:54:47")
@StaticMetamodel(Album.class)
public class Album_ { 

    public static volatile SingularAttribute<Album, String> img;
    public static volatile SingularAttribute<Album, Artista> artista;
    public static volatile ListAttribute<Album, Genero> genero;
    public static volatile SingularAttribute<Album, Long> id;
    public static volatile ListAttribute<Album, Tema> temas;
    public static volatile SingularAttribute<Album, String> nombre;
    public static volatile SingularAttribute<Album, Integer> anio;

}