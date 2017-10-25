/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Casca
 */
@Entity
public class Fecha{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) 
    long id;
    @Column(name = "DIA")
    private int dia;
    @Column(name = "MES")
    private int mes;
    @Column(name = "AÑO")
    private int año;
    
    public Fecha(){}
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Fecha)) {
            return false;
    }

    Fecha that = (Fecha) other;

    return this.getDia() == that.getDia() && this.getMes() == that.getMes() 
            && this.getAño() == that.getAño();
}
    
    
    public boolean validarFecha(){
        Pattern p = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
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
    
    public void setCurrentDate(){
        LocalDate localDate = LocalDate.now();
        this.dia = localDate.getDayOfMonth();
        this.mes = localDate.getMonthValue();
        this.año = localDate.getYear();
    }
    
}

