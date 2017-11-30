/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.ListaDeReproduccion;
import Logica.Tema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Usuario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DTListaRepro {
    private String nombre;
    private List temas;
    private String imagen;
    
    
    public DTListaRepro(ListaDeReproduccion L){
        nombre = L.getNombre();
        imagen = L.getImagen();
        temas = new ArrayList();
        Iterator it = L.getTemas().iterator();
        Tema t;
        while(it.hasNext()){
            t = (Tema) it.next();
            temas.add(new DTTema(t));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List getTemas() {
        return temas;
    }

    public String getImagen() {
        return imagen;
    }
    
}
