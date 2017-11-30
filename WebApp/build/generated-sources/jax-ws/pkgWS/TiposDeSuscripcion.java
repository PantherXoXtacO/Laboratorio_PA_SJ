
package pkgWS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tiposDeSuscripcion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tiposDeSuscripcion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Semanal"/>
 *     &lt;enumeration value="Mensual"/>
 *     &lt;enumeration value="Anual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tiposDeSuscripcion")
@XmlEnum
public enum TiposDeSuscripcion {

    @XmlEnumValue("Semanal")
    SEMANAL("Semanal"),
    @XmlEnumValue("Mensual")
    MENSUAL("Mensual"),
    @XmlEnumValue("Anual")
    ANUAL("Anual");
    private final String value;

    TiposDeSuscripcion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TiposDeSuscripcion fromValue(String v) {
        for (TiposDeSuscripcion c: TiposDeSuscripcion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
