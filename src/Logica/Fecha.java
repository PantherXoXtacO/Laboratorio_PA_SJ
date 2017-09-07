/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Casca
 */
public class Fecha implements Serializable{
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(){}
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public boolean validarFecha(){
        Pattern p = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        StringBuilder sb= new StringBuilder();
        String fecha_string = String.valueOf(this.dia) + "-" + String.valueOf(this.mes) + "-" + String.valueOf(this.año);
        Matcher m = p.matcher(fecha_string);
        if (m.matches())
            return true;
        else
            return false;
    }
    
    //setters
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    
    public void setAño(int año) {
        this.año = año;
    }

    //getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
    
}

