/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;



@XmlAccessorType(XmlAccessType.FIELD)
public class DataSession {
    private String nick;
    private String mail;
    Boolean esArtista;

    public DataSession(String nick, String mail, Boolean esArtista) {
        this.nick = nick;
        this.mail = mail;
        this.esArtista = esArtista;
    }

    public String getNick() {
        return nick;
    }

    public String getMail() {
        return mail;
    }

    public Boolean getEsArtista() {
        return esArtista;
    }
}
