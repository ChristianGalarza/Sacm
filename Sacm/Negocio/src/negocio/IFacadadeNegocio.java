/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
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
}
