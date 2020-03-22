/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
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
    private ServicioDeRelajacionControl serviciosControl;
    private ClienteControl clienteControl;

    public FacadadeNegocio() {
        this.citaControl = new CitaControl();
        this.calendarControl = new CalendarControl();
        this.serviciosControl = new ServicioDeRelajacionControl();
        this.clienteControl = new ClienteControl();
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

    @Override
    public int obtenerHora(Date hora) {
        return this.calendarControl.obtenerHora(hora);
    }

    @Override
    public int obtenerMinutos(Date hora) {
        return this.calendarControl.obtenerMinutos(hora);
    }

    @Override
    public Float calcularCostoTotalCita(List<Servicioderelajacion> listaServicios) {
        return this.citaControl.calcularCostoTotalCita(listaServicios);
    }

    @Override
    public Calendar calcularDuracionCita(List<Servicioderelajacion> listaServicios) {
        return this.calendarControl.calcularDuracionCita(listaServicios);
    }

    @Override
    public Date convertirHoras(int hora, int minuto) {
        return this.calendarControl.convertirHoras(hora, minuto);
    }

    @Override
    public List<Servicioderelajacion> obtenerServiciosDeRelajacion() {
        return this.serviciosControl.obtenerServiciosDeRelajacion();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return this.clienteControl.obtenerClientes();
    }
    
    
}
