/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Enums.EstadosDeSuscripcion;
import Enums.TiposDeSuscripcion;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Casca
 */

@Entity
@Table(name = "Suscripcion")    
public class Suscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    private Cliente cliente;
    private EstadosDeSuscripcion estado;
    private TiposDeSuscripcion tipo;
    private float costo;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Fecha fechaDeInicio;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Fecha fechaDeVencimiento;
    

    public Suscripcion(Cliente cliente, TiposDeSuscripcion tipo) {
        this.cliente = cliente;
        this.estado = EstadosDeSuscripcion.Pendiente;
        this.tipo = tipo;
        switch(tipo){
            case Anual:
                this.costo = 300;
            case Mensual:
                this.costo = 20;
            case Semanal:
                this.costo = 7;
        }
        this.fechaDeInicio = this.getCurrentDate();
        this.fechaDeVencimiento = new Fecha();
        switch(tipo){
            case Anual:
                this.fechaDeVencimiento.setAño(fechaDeInicio.getAño()+1);
            case Mensual:
                this.fechaDeVencimiento.setMes(fechaDeInicio.getMes()+1);
            case Semanal:
                agregarSemanaAFecha(fechaDeInicio);
        }
    }
    
    public Suscripcion(){
                
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(EstadosDeSuscripcion estado) {
        this.estado = estado;
    }

    public void setTipo(TiposDeSuscripcion tipo) {
        this.tipo = tipo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setFechaDeInicio(Fecha fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setFechaDeVencimiento(Fecha fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadosDeSuscripcion getEstado() {
        return estado;
    }

    public TiposDeSuscripcion getTipo() {
        return tipo;
    }

    public float getCosto() {
        return costo;
    }

    public Fecha getFechaDeInicio() {
        return fechaDeInicio;
    }

    public Fecha getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }
    
    public Fecha getCurrentDate(){
        LocalDate localDate = LocalDate.now();
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        Fecha fecha = new Fecha(day, month, year);
        return fecha;
    }
    
    public void agregarSemanaAFecha(Fecha fecha){
        Calendar c = Calendar.getInstance();
        c.set(fecha.getAño(), fecha.getMes(), fecha.getDia());
        c.add(Calendar.DATE, 7);
        fecha.setDia(c.get(Calendar.DAY_OF_MONTH));
        fecha.setMes(c.get(Calendar.MONTH));
        fecha.setAño(c.get(Calendar.YEAR));
    }
    
    public void updateFechaDeVencimiento(){
        switch(this.tipo){
            case Anual:
                this.fechaDeVencimiento.setAño(fechaDeInicio.getAño()+1);
            case Mensual:
                this.fechaDeVencimiento.setMes(fechaDeInicio.getMes()+1);
            case Semanal:
                agregarSemanaAFecha(fechaDeInicio);
        }
    }
    
}
