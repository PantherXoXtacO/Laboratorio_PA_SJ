/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Casca
 */
public class ManejadorUsuario {
    //Clase que conserva la colección global de los Usuarios del Sistema
    private Map usuariosCI;
    private static ManejadorUsuario instancia=null;
    
    private ManejadorUsuario(){
        usuariosCI=new HashMap();
    }
    
    public static ManejadorUsuario getinstance(){
        if (instancia==null)
            instancia = new ManejadorUsuario();
        return instancia;
    }
    
    public void addUsuario(Usuario usu){
        String nickname = usu.getNickname();
        if (this.obtenerUsuario(nickname) == null) {
            usuariosCI.put(nickname,usu);
        }
    }
    
    public Usuario obtenerUsuario(String nickname){
        return ((Usuario) usuariosCI.get(nickname));
    }
}
