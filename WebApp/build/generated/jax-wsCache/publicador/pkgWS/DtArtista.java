
package pkgWS;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtArtista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtArtista">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Publicador/}dtUsuario">
 *       &lt;sequence>
 *         &lt;element name="biografia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dir_web" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="albums" type="{http://Publicador/}dtAlbum" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtArtista", propOrder = {
    "biografia",
    "dirWeb",
    "albums"
})
public class DtArtista
    extends DtUsuario
{

    protected String biografia;
    @XmlElement(name = "dir_web")
    protected String dirWeb;
    @XmlElement(nillable = true)
    protected List<DtAlbum> albums;

    /**
     * Obtiene el valor de la propiedad biografia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Define el valor de la propiedad biografia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiografia(String value) {
        this.biografia = value;
    }

    /**
     * Obtiene el valor de la propiedad dirWeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirWeb() {
        return dirWeb;
    }

    /**
     * Define el valor de la propiedad dirWeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirWeb(String value) {
        this.dirWeb = value;
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
     * {@link DtAlbum }
     * 
     * 
     */
    public List<DtAlbum> getAlbums() {
        if (albums == null) {
            albums = new ArrayList<DtAlbum>();
        }
        return this.albums;
    }

}
