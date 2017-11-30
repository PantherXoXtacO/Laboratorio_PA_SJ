/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.ListaDeReproduccion;
import Logica.ListaParticular;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Usuario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTListaPrticular extends DTListaRepro{
    private String cliente;
    private boolean privacidad;
    
    
    public DTListaPrticular(ListaDeReproduccion L) {
        super(L);
        ListaParticular LP = (ListaParticular) L;
        cliente = LP.getCliente().getNickname();
        privacidad = LP.getPrivacidad();
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isPrivacidad() {
        return privacidad;
    }
    
    
}
