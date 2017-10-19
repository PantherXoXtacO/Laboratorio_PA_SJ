package Logica;

import Logica.Album;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-19T19:39:36")
@StaticMetamodel(Artista.class)
public class Artista_ extends Usuario_ {

    public static volatile SingularAttribute<Artista, List> siguiendo;
    public static volatile ListAttribute<Artista, Album> albums;
    public static volatile SingularAttribute<Artista, String> biografia;
    public static volatile SingularAttribute<Artista, String> dir_web;

}