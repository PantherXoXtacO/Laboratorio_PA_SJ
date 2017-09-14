package Logica;

import Logica.Fecha;
import Logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T18:39:22")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Fecha> fechaDeNacimiento;
    public static volatile SingularAttribute<Usuario, String> mail;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> nickname;
    public static volatile SingularAttribute<Usuario, byte[]> imagen;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Usuario> seguidores;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}