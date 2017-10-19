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
public class Fabrica {
    
private static Fabrica instancia;
private Fabrica(){};

/*
    @doc La documentacion en general...
*/  
public static Fabrica getInstance(){
    if (instancia == null){
        instancia = new Fabrica();
    }
    return instancia;
}
    
public IControlador getIControlador() {
    IControlador IG = new Controlador();
    return IG;
}
}
