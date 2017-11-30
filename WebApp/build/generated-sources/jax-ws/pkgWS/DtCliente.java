
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtCliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtCliente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Publicador/}dtUsuario">
 *       &lt;sequence>
 *         &lt;element name="siguiendo" type="{http://Publicador/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="temasFav" type="{http://Publicador/}dtTema" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="albumFav" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listasFav" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ListasDeReproduccion" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCliente", propOrder = {
    "siguiendo",
    "temasFav",
    "albumFav",
    "listasFav",
    "listasDeReproduccion"
})
public class DtCliente
    extends DtUsuario
{

    @XmlElement(nillable = true)
    protected List<DtUsuario> siguiendo;
    @XmlElement(nillable = true)
    protected List<DtTema> temasFav;
    @XmlElement(nillable = true)
    protected List<Object> albumFav;
    @XmlElement(nillable = true)
    protected List<Object> listasFav;
    @XmlElement(name = "ListasDeReproduccion", nillable = true)
    protected List<Object> listasDeReproduccion;

    /**
     * Gets the value of the siguiendo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siguiendo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiguiendo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getSiguiendo() {
        if (siguiendo == null) {
            siguiendo = new ArrayList<DtUsuario>();
        }
        return this.siguiendo;
    }

    /**
     * Gets the value of the temasFav property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temasFav property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemasFav().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtTema }
     * 
     * 
     */
    public List<DtTema> getTemasFav() {
        if (temasFav == null) {
            temasFav = new ArrayList<DtTema>();
        }
        return this.temasFav;
    }

    /**
     * Gets the value of the albumFav property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the albumFav property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlbumFav().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAlbumFav() {
        if (albumFav == null) {
            albumFav = new ArrayList<Object>();
        }
        return this.albumFav;
    }

    /**
     * Gets the value of the listasFav property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listasFav property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListasFav().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getListasFav() {
        if (listasFav == null) {
            listasFav = new ArrayList<Object>();
        }
        return this.listasFav;
    }

    /**
     * Gets the value of the listasDeReproduccion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listasDeReproduccion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListasDeReproduccion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getListasDeReproduccion() {
        if (listasDeReproduccion == null) {
            listasDeReproduccion = new ArrayList<Object>();
        }
        return this.listasDeReproduccion;
    }

}
