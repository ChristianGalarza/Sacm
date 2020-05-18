/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import controlJPA.ClienteJpaController;
import controlJPA.ServicioderelajacionJpaController;
import datos.FacadadeDatos;
import dominio.Cita;
import dominio.Servicioderelajacion;
import java.text.ParseException;
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
 * @author Usuario
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
//        FacadadeDatos instance = new FacadadeDatos();
//        ClienteJpaController clienteController = new ClienteJpaController();
//        ServicioderelajacionJpaController servicioController = new ServicioderelajacionJpaController();
//        List<Servicioderelajacion> listaServicios = new ArrayList<>();
//        listaServicios.add(servicioController.findServicioderelajacion(2));
//        System.out.println("obtenerCitas");
//        List<Cita> result = instance.obtenerCitas();
//        System.out.println(result);
//        //Agregar Cita
//        Cita cita = new Cita();
//        //Agregar Fecha Cita
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date d = sdf.parse("06/03/2020");
//        cita.setFecha(d);
//        //Agregar Hora
//        Calendar c2 = Calendar.getInstance();
//        c2.set(HOUR_OF_DAY, 8);
//        c2.set(MINUTE,30);
//        c2.set(SECOND,0);
//        c2.set(MILLISECOND,0);
//        Date d2 = c2.getTime();
//        cita.setHora(d2);
//        //Agregar Duracion a cita
//        Calendar c1 = Calendar.getInstance();
//        c1.set(HOUR_OF_DAY,1);
//        c1.set(MINUTE,0);
//        c1.set(SECOND,0);
//        c1.set(MILLISECOND,0);
//        Date d1 = c1.getTime();
//        cita.setDuracion(d1);
//        //AgregarCosto
//        cita.setCostoTotal(servicioController.findServicioderelajacion(2).getCosto());
//        cita.setServicioderelajacionList(listaServicios);
//        cita.setIdCliente(clienteController.findCliente(2));
//        instance.agregarCita(cita);
//        //-------------------
//        /*
//        IMPRIMIR RESULTADOS NUEVOS
//        */
//        //-------------------
//        System.out.println("obtenerCitas");
//        result = instance.obtenerCitas();
//        System.out.println(result);
//        //Actualizar cita
//        d = sdf.parse("08/03/2020");
//        cita.setFecha(d);
//        c2.set(HOUR_OF_DAY, 10);
//        c2.set(MINUTE,50);
//        c2.set(SECOND,0);
//        c2.set(MILLISECOND,0);
//        d2 = c2.getTime();
//        cita.setHora(d2);
//        c1 = Calendar.getInstance();
//        c1.set(HOUR_OF_DAY,1);
//        c1.set(MINUTE,0);
//        c1.set(SECOND,0);
//        c1.set(MILLISECOND,0);
//        d1 = c1.getTime();
//        cita.setDuracion(d1);
//        cita.setCostoTotal(servicioController.findServicioderelajacion(1).getCosto());
//        cita.setServicioderelajacionList(listaServicios);
//        cita.setIdCliente(clienteController.findCliente(1));
//        instance.actualizarCita(cita);
//        //-------------------
//        /*
//        IMPRIMIR RESULTADOS NUEVOS
//        */
//        //-------------------
//        System.out.println("obtenerCitas");
//        result = instance.obtenerCitas();
//        System.out.println(result);
//        //Eliminar Cita
//        instance.eliminarCita(cita.getIdCita());
//        //-------------------
//        /*
//        IMPRIMIR RESULTADOS NUEVOS
//        */
//        //-------------------
//        System.out.println("obtenerCitas");
//        result = instance.obtenerCitas();
//        System.out.println(result);

        FacadadeDatos instance = new FacadadeDatos();
        ClienteJpaController clienteController = new ClienteJpaController();
        ServicioderelajacionJpaController servicioController = new ServicioderelajacionJpaController();
        List<Servicioderelajacion> listaServicios = new ArrayList<>();
        listaServicios.add(servicioController.findServicioderelajacion(2));
        System.out.println("obtenerCitas");
        List<Cita> result = instance.obtenerCitas();
        for (Cita cita : result) {
            System.out.println(cita.getFecha());
            
        }
    }

}
