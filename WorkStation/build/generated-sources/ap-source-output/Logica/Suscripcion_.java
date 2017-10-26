package Logica;

import Enums.EstadosDeSuscripcion;
import Enums.TiposDeSuscripcion;
import Logica.Cliente;
import Logica.Fecha;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-26T19:40:09")
@StaticMetamodel(Suscripcion.class)
public class Suscripcion_ { 

    public static volatile SingularAttribute<Suscripcion, Cliente> cliente;
    public static volatile SingularAttribute<Suscripcion, EstadosDeSuscripcion> estado;
    public static volatile SingularAttribute<Suscripcion, TiposDeSuscripcion> tipo;
    public static volatile SingularAttribute<Suscripcion, Float> costo;
    public static volatile SingularAttribute<Suscripcion, Fecha> fechaDeInicio;
    public static volatile SingularAttribute<Suscripcion, Fecha> fechaDeVencimiento;
    public static volatile SingularAttribute<Suscripcion, Long> id;

}