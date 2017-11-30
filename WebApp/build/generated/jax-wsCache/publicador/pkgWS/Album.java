
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para album complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="album">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="img" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artista" type="{http://Publicador/}artista" minOccurs="0"/>
 *         &lt;element name="temas" type="{http://Publicador/}tema" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="genero" type="{http://Publicador/}genero" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "album", propOrder = {
    "id",
    "nombre",
    "anio",
    "img",
    "artista",
    "temas",
    "genero"
})
public class Album {

    protected Long id;
    protected String nombre;
    protected int anio;
    protected String img;
    protected Artista artista;
    @XmlElement(nillable = true)
    protected List<Tema> temas;
    @XmlElement(nillable = true)
    protected List<Genero> genero;

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
     * Obtiene el valor de la propiedad anio.
     * 
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Define el valor de la propiedad anio.
     * 
     */
    public void setAnio(int value) {
        this.anio = value;
    }

    /**
     * Obtiene el valor de la propiedad img.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImg() {
        return img;
    }

    /**
     * Define el valor de la propiedad img.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImg(String value) {
        this.img = value;
    }

    /**
     * Obtiene el valor de la propiedad artista.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * Define el valor de la propiedad artista.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setArtista(Artista value) {
        this.artista = value;
    }

    /**
     * Gets the value of the temas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tema }
     * 
     * 
     */
    public List<Tema> getTemas() {
        if (temas == null) {
            temas = new ArrayList<Tema>();
        }
        return this.temas;
    }

    /**
     * Gets the value of the genero property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genero property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenero().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Genero }
     * 
     * 
     */
    public List<Genero> getGenero() {
        if (genero == null) {
            genero = new ArrayList<Genero>();
        }
        return this.genero;
    }

}
