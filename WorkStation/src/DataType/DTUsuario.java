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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Usuario
 */


@XmlAccessorType(XmlAccessType.FIELD)
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
    
    public List getSeguidores(){
        return seguidores;
    }
    
    public boolean yaSigue(String s){
        DTUsuario aux;
        Iterator it = seguidores.iterator();
        while(it.hasNext()){
            aux=(DTUsuario) it.next();
            if(aux.getNick().equals(s)){
                return true;
            }
        }
        return false;
    }
}
