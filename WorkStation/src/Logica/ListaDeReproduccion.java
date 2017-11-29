/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;*/

/**
 *
 * @author Casca
 */
//@Entity
//@Table(name="ListaDeReproduccion")
public class ListaDeReproduccion //implements Serializable 
{
    
    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;
    
    //@Column(name = "NOMBRE")
    private String nombre;
    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "TEMAS")
    private List<Tema> temas;
    //@Column(name = "IMAGEN")
    private String imagen;

    public ListaDeReproduccion(String nombre, String imagen) {
        this.nombre = nombre;
        this.temas = new ArrayList();
        this.imagen = imagen;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public String getImagen() {
        return imagen;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    void agregarTema(Tema tem) {
        if(!temas.contains(tem)) temas.add(tem);
    }
        
     void quitarTema(Tema tem) {
        temas.remove(tem);
    } 
     
     public void GeneroListRecievingString(List<String> generos){
         
     }
     
}
