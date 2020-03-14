/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.CitaJpaController;
import dao.ClienteJpaController;
import dao.ServicioderelajacionJpaController;
import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        CitaJpaController cjc = new CitaJpaController();
        ClienteJpaController clienteControl = new ClienteJpaController();
        ServicioderelajacionJpaController servicioControl = new ServicioderelajacionJpaController();
        
        List<Servicioderelajacion> listaDeServicio = new ArrayList<>();
        
        listaDeServicio.add(servicioControl.findServicioderelajacion("servicio2"));
        

        //Agregar cita
        Cita cita = new Cita();
        cita.setIdCita("cita4");
        //Agregar Fecha a cita
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("06/03/2020");
        cita.setFecha(d);
        //Agregar Hora a cita
        Calendar c2 = Calendar.getInstance();
        c2.set(HOUR_OF_DAY,8);
        c2.set(MINUTE,30);
        c2.set(SECOND,0);
        c2.set(MILLISECOND,0);
        Date d2 = c2.getTime();
        cita.setHora(d2);
        //Agregar Duracion a cita
        Calendar c1 = Calendar.getInstance();
        c1.set(HOUR_OF_DAY,1);
        c1.set(MINUTE,0);
        c1.set(SECOND,0);
        c1.set(MILLISECOND,0);
        Date d1 = c1.getTime();
        cita.setDuracion(d1);
        //Agregar Costo Cita
        cita.setCostoTotal(5000.0f);
        cita.setIdCliente(clienteControl.findCliente("cliente1"));
        cita.setServicioderelajacionList(listaDeServicio);
        cjc.create(cita);
        
        
//        //Editar cita
//        //Editar Fecha a cita
//        d = sdf.parse("06/03/2021");
//        cita.setFecha(d);
//        //Editar Hora a cita
//        c2.set(HOUR_OF_DAY,9);
//        c2.set(MINUTE,30);
//        c2.set(SECOND,0);
//        c2.set(MILLISECOND,0);
//        d2 = c2.getTime();
//        cita.setHora(d2);
//        //Editar Duracion a cita
//        c1.set(HOUR_OF_DAY,1);
//        c1.set(MINUTE,30);
//        c1.set(SECOND,0);
//        c1.set(MILLISECOND,0);
//        d1 = c1.getTime();
//        cita.setDuracion(d1);
//        //Editar Costo Cita
//        cita.setCostoTotal(5200.0f);
//        cita.setIdCliente(clienteControl.findCliente("CH24"));
//        cjc.edit(cita);
        
        
        
        //Eliminar cita
//        cjc.destroy(cjc.findCita("cita1").getIdCita());
    }
    
}
