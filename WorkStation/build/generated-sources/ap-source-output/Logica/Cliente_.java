package Logica;

import Logica.Album;
import Logica.Tema;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-19T19:39:36")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Usuario_ {

    public static volatile SingularAttribute<Cliente, List> siguiendo;
    public static volatile ListAttribute<Cliente, Tema> temasFav;
    public static volatile ListAttribute<Cliente, Album> albumsFav;
    public static volatile SingularAttribute<Cliente, List> Listas;
    public static volatile SingularAttribute<Cliente, List> listasFav;

}