/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import Logica.Cliente;
import Logica.Fecha;
import Logica.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DTUsuario {
    
    private String nick;
    private String mail;
    private String nom;//Nombre
    private String ap;//Apellido
    private String img;
    private Fecha fechaNacimiento;
    private List<DTUsuario>seguidores;
    private Boolean artista;
    
    public DTUsuario(Usuario u){
        nick=u.getNickname();
        mail=u.getMail();
        nom=u.getNombre();
        ap=u.getApellido();
        img=u.getImagen();
        fechaNacimiento=u.getFechaDeNacimiento();
        seguidores = new ArrayList();
        if(u instanceof Cliente){
            artista = false;
        }
        else{
            artista = true;
        }
        Iterator it = u.getSeguidores().iterator();
        Usuario aux;
        while(it.hasNext()){
            aux=(Usuario)it.next();
            seguidores.add(new DTUsuario(aux));
        }
    }
    
    public String getNick(){
        return nick;
    }
    
    public String getMail(){
        return mail;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getAp(){
        return ap;
    }

    public String getImg() {
        return img;
    }
}
