package Logica;

import Logica.Album;
import Logica.Genero;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T00:53:50")
@StaticMetamodel(Genero.class)
public class Genero_ { 

    public static volatile SingularAttribute<Genero, String> padre;
    public static volatile ListAttribute<Genero, Album> albums;
    public static volatile ListAttribute<Genero, Genero> hijos;
    public static volatile SingularAttribute<Genero, List> listas;
    public static volatile SingularAttribute<Genero, Long> id;
    public static volatile SingularAttribute<Genero, String> nombre;

}