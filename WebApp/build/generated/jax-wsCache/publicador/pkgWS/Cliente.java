
package pkgWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cliente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Publicador/}usuario">
 *       &lt;sequence>
 *         &lt;element name="suscripcion" type="{http://Publicador/}suscripcion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", propOrder = {
    "suscripcion"
})
public class Cliente
    extends Usuario
{

    protected Suscripcion suscripcion;

    /**
     * Obtiene el valor de la propiedad suscripcion.
     * 
     * @return
     *     possible object is
     *     {@link Suscripcion }
     *     
     */
    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    /**
     * Define el valor de la propiedad suscripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link Suscripcion }
     *     
     */
    public void setSuscripcion(Suscripcion value) {
        this.suscripcion = value;
    }

}
