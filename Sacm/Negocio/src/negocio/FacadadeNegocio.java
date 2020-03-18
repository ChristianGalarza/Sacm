/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class FacadadeNegocio implements IFacadadeNegocio{

    private CitaControl citaControl;
    private CalendarControl calendarControl;

    public FacadadeNegocio() {
        this.citaControl = new CitaControl();
        this.calendarControl = new CalendarControl();
    }

    @Override
    public List<Cita> obtenerCitas() {
        return this.citaControl.obtenerCitas();
    }
    
    @Override
    public void agregarCita(Cita cita) {
        this.citaControl.agregarCita(cita);
    }
    
    @Override
    public void actualizarCita(Cita cita) {
        this.citaControl.actualizarCita(cita);
    }

    
    @Override
    public void eliminarCita(int id) {
        this.citaControl.eliminarCita(id);
    }

    @Override
    public Cita obtenerCita(int id) {
        return this.citaControl.obtenerCita(id);
    }

    @Override
    public String formatearFecha(Date fecha) {
        return this.calendarControl.formatearFecha(fecha);
    }

    @Override
    public Calendar convertirDateToCalendar(Date date) {
        return this.calendarControl.convertirDateToCalendar(date);
    }

    @Override
    public String formatearHora(Date hora) {
        return this.calendarControl.formatearHora(hora);
    }

    @Override
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        return this.citaControl.obtenerCitasPorFecha(fecha);
    }
    
    
}
