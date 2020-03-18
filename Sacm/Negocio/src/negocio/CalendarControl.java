/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        String DIA[] = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

        String fechaObtenida = DIA[calendar.get(Calendar.DAY_OF_WEEK) - 1] + " " + calendar.get(Calendar.DAY_OF_MONTH) + " de " + MES[calendar.get(Calendar.MONTH)] + " del " + calendar.get(Calendar.YEAR);

        return fechaObtenida;
    }

    public Calendar convertirDateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public String formatearHora(Date hora) {
        return new SimpleDateFormat("HH:mm:SS").format(hora);
    }
}
