/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IFacadadeNegocio {

    public List<Cita> obtenerCitas();
    
    public void agregarCita(Cita cita);
    
    public void actualizarCita(Cita cita);
    
    public void eliminarCita(int id);

    public Cita obtenerCita(int id);
    
    public String formatearFecha(Date fecha);

    public Calendar convertirDateToCalendar(Date date);

    public String formatearHora(Date hora);
    
    public List<Cita> obtenerCitasPorFecha(Date fecha);
    
    public int obtenerHora(Date hora);
    
    public int obtenerMinutos(Date hora);
    
    public Float calcularCostoTotalCita(List<Servicioderelajacion> listaServicios);

    public Calendar calcularDuracionCita(List<Servicioderelajacion> listaServicios);

    public Date convertirHoras(int hora, int minuto);

    public List<Servicioderelajacion> obtenerServiciosDeRelajacion();

    public List<Cliente> obtenerClientes();

    public Date sumarHora(Date horaInicio, Date duracion);

    public List<Cita> verificarCitasEmpalmadas(Cita cita);

    public void agregarCliente(Cliente t);

    public void actualizarCliente(Cliente t);

    public void eliminarCliente(int id);

    public Cliente obtenerCliente(int id);
}
