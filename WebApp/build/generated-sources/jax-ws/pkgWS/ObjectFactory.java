
package pkgWS;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pkgWS package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pkgWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Artista }
     * 
     */
    public Artista createArtista() {
        return new Artista();
    }

    /**
     * Create an instance of {@link Album }
     * 
     */
    public Album createAlbum() {
        return new Album();
    }

    /**
     * Create an instance of {@link Suscripcion }
     * 
     */
    public Suscripcion createSuscripcion() {
        return new Suscripcion();
    }

    /**
     * Create an instance of {@link DataSession }
     * 
     */
    public DataSession createDataSession() {
        return new DataSession();
    }

    /**
     * Create an instance of {@link DtCliente }
     * 
     */
    public DtCliente createDtCliente() {
        return new DtCliente();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }
    
    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link HashMap }
     * 
     */
    public HashMap createHashMap() {
        return new HashMap();
    }

}
