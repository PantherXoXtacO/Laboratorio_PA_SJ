
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para genero complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="genero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="padre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hijos" type="{http://Publicador/}genero" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="albums" type="{http://Publicador/}album" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listas" type="{http://Publicador/}listaDeReproduccion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "genero", propOrder = {
    "id",
    "nombre",
    "padre",
    "hijos",
    "albums",
    "listas"
})
public class Genero {

    protected Long id;
    protected String nombre;
    protected String padre;
    @XmlElement(nillable = true)
    protected List<Genero> hijos;
    @XmlElement(nillable = true)
    protected List<Album> albums;
    @XmlElement(nillable = true)
    protected List<ListaDeReproduccion> listas;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad padre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPadre() {
        return padre;
    }

    /**
     * Define el valor de la propiedad padre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPadre(String value) {
        this.padre = value;
    }

    /**
     * Gets the value of the hijos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hijos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHijos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Genero }
     * 
     * 
     */
    public List<Genero> getHijos() {
        if (hijos == null) {
            hijos = new ArrayList<Genero>();
        }
        return this.hijos;
    }

    /**
     * Gets the value of the albums property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the albums property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlbums().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Album }
     * 
     * 
     */
    public List<Album> getAlbums() {
        if (albums == null) {
            albums = new ArrayList<Album>();
        }
        return this.albums;
    }

    /**
     * Gets the value of the listas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaDeReproduccion }
     * 
     * 
     */
    public List<ListaDeReproduccion> getListas() {
        if (listas == null) {
            listas = new ArrayList<ListaDeReproduccion>();
        }
        return this.listas;
    }

}
