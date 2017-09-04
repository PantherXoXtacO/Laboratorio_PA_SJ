/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;

/**
 *
 * @author Casca
 */
public class ListaParticular extends ListaDeReproduccion {
    
    private Cliente cliente;
    private boolean privacidad; //true si la lista es privada

    public ListaParticular(Cliente cliente, String nombre, BufferedImage imagen) {
        super(nombre, imagen);
        this.cliente = cliente;
        this.privacidad = false;
    }
        
}
