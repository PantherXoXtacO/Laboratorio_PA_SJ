/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.ListaDeReproduccion;
import Logica.ListaPorDefecto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Usuario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTListaDefecto extends DTListaRepro {
    private String genero;

    public DTListaDefecto(ListaDeReproduccion L) {
        super(L);
        ListaPorDefecto LD = (ListaPorDefecto) L;
        genero = LD.getGenero().getNombre();
    }
}
