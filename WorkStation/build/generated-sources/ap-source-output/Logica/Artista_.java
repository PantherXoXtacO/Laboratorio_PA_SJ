package Logica;

import Logica.Album;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-13T18:36:30")
@StaticMetamodel(Artista.class)
public class Artista_ extends Usuario_ {

    public static volatile ListAttribute<Artista, Album> albums;
    public static volatile SingularAttribute<Artista, String> biografia;
    public static volatile SingularAttribute<Artista, String> dir_web;

}