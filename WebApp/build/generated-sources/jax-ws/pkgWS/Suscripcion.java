
package pkgWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para suscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="suscripcion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cliente" type="{http://Publicador/}cliente" minOccurs="0"/>
 *         &lt;element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="estado" type="{http://Publicador/}estadosDeSuscripcion" minOccurs="0"/>
 *         &lt;element name="fechaDeInicio" type="{http://Publicador/}fecha" minOccurs="0"/>
 *         &lt;element name="fechaDeVencimiento" type="{http://Publicador/}fecha" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://Publicador/}tiposDeSuscripcion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "suscripcion", propOrder = {
    "cliente",
    "costo",
    "estado",
    "fechaDeInicio",
    "fechaDeVencimiento",
    "tipo"
})
public class Suscripcion {

    protected Cliente cliente;
    protected float costo;
    protected EstadosDeSuscripcion estado;
    protected Fecha fechaDeInicio;
    protected Fecha fechaDeVencimiento;
    protected TiposDeSuscripcion tipo;

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadosDeSuscripcion }
     *     
     */
    public EstadosDeSuscripcion getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadosDeSuscripcion }
     *     
     */
    public void setEstado(EstadosDeSuscripcion value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeInicio.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getFechaDeInicio() {
        return fechaDeInicio;
    }

    /**
     * Define el valor de la propiedad fechaDeInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setFechaDeInicio(Fecha value) {
        this.fechaDeInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    /**
     * Define el valor de la propiedad fechaDeVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setFechaDeVencimiento(Fecha value) {
        this.fechaDeVencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link TiposDeSuscripcion }
     *     
     */
    public TiposDeSuscripcion getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link TiposDeSuscripcion }
     *     
     */
    public void setTipo(TiposDeSuscripcion value) {
        this.tipo = value;
    }

}
