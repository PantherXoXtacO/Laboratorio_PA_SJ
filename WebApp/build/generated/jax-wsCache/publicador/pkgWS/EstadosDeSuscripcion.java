
package pkgWS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadosDeSuscripcion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadosDeSuscripcion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pendiente"/>
 *     &lt;enumeration value="Vigente"/>
 *     &lt;enumeration value="Vencida"/>
 *     &lt;enumeration value="Cancelada"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadosDeSuscripcion")
@XmlEnum
public enum EstadosDeSuscripcion {

    @XmlEnumValue("Pendiente")
    PENDIENTE("Pendiente"),
    @XmlEnumValue("Vigente")
    VIGENTE("Vigente"),
    @XmlEnumValue("Vencida")
    VENCIDA("Vencida"),
    @XmlEnumValue("Cancelada")
    CANCELADA("Cancelada");
    private final String value;

    EstadosDeSuscripcion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadosDeSuscripcion fromValue(String v) {
        for (EstadosDeSuscripcion c: EstadosDeSuscripcion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
