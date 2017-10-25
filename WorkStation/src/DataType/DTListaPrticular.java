/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.ListaDeReproduccion;
import Logica.ListaParticular;

/**
 *
 * @author Usuario
 */
public class DTListaPrticular extends DTListaRepro{
    private String cliente;
    private boolean privacidad;
    
    
    public DTListaPrticular(ListaDeReproduccion L) {
        super(L);
        ListaParticular LP = (ListaParticular) L;
        cliente = LP.getCliente().getNickname();
        privacidad = LP.getPrivacidad();
    }
    
}
