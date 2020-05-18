/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Servicioderelajacion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class CalendarControl {

    public String formatearFecha(Date fecha) {
        Calendar calendar = this.convertirDateToCalendar(fecha);

        // Meses del anio
        String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Dias de la semana
        String DIA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado","Domingo"};

        String fechaObtenida = DIA[calendar.get(Calendar.DAY_OF_WEEK)] + " " + (calendar.get(Calendar.DAY_OF_MONTH)+1) + " de " + MES[calendar.get(Calendar.MONTH)] + " del " + calendar.get(Calendar.YEAR);

        return fechaObtenida;
    }

    public Calendar convertirDateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }
    
    public Date convertirHoras(int hora, int minuto){
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.HOUR_OF_DAY,hora);
        c2.set(Calendar.MINUTE,minuto);
        c2.set(Calendar.SECOND,0);
        c2.set(Calendar.MILLISECOND,0);
        return c2.getTime();
    }

    public String formatearHora(Date hora) {
        return new SimpleDateFormat("HH:mm:SS").format(hora);
    }
    
    public String formatearfecha(Date fecha) {
        Calendar calendar = this.convertirDateToCalendar(fecha);
        return calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+(calendar.get(Calendar.DAY_OF_WEEK) - 1);
    }
    
    public int obtenerHora(Date hora){
        Calendar calendar = this.convertirDateToCalendar(hora);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    
    public int obtenerMinutos(Date hora){
        Calendar calendar = this.convertirDateToCalendar(hora);
        return calendar.get(Calendar.MINUTE);
    }
    
    public Calendar calcularDuracionCita(List<Servicioderelajacion> listaServicios) {
        Calendar calendarAuxiliar = Calendar.getInstance();
        calendarAuxiliar.set(Calendar.HOUR_OF_DAY, 0);
        calendarAuxiliar.set(Calendar.MINUTE, 0);
        calendarAuxiliar.set(Calendar.SECOND, 0);
        calendarAuxiliar.set(Calendar.MILLISECOND, 0);
        for (Servicioderelajacion servicioderelajacion : listaServicios) {
            calendarAuxiliar.add(Calendar.HOUR_OF_DAY, obtenerHora(servicioderelajacion.getDuracion()));
            calendarAuxiliar.add(Calendar.MINUTE, obtenerMinutos(servicioderelajacion.getDuracion()));
        }
        return calendarAuxiliar;
    }
    
    public Date sumarHora(Date horaInicio, Date duracion) {
        Calendar h1 = this.convertirDateToCalendar(horaInicio);
        Calendar h2 = this.convertirDateToCalendar(duracion);
        h1.add(Calendar.HOUR_OF_DAY, h2.get(Calendar.HOUR_OF_DAY));
        h1.add(Calendar.MINUTE, h2.get(Calendar.MINUTE));
        return h1.getTime();
    }
}
