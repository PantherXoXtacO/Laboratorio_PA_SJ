/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


/**
 *
 * @author Casca
 */
public class ListaParticular extends ListaDeReproduccion {
    
    private Cliente cliente;
    private boolean privacidad; //true si la lista es privada

    public ListaParticular(Cliente cliente, String nombre, String imagen) {
        super(nombre, imagen);
        this.cliente = cliente;
        this.privacidad = true;
    }
    
    public void setPrivacidad(boolean modo){
        this.privacidad = modo;
    }
    
    public boolean getPrivacidad(){
        return this.privacidad;
    }
        
}
