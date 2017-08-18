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
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(){}
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
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

