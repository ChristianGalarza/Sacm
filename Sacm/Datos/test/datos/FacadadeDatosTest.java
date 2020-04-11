/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 *
 * @author pc
 */
public class FacadadeDatosTest {
    
    IFacadadeDatos instance = new FacadadeDatos();
    /**
     * Test of obtenerCitas method, of class FacadadeDatos.
     */
    @Test
    public void testObtenerCitas() {
        System.out.println("obtenerCitas");
        List<Cita> expResult = new ArrayList<>();
        expResult.add(new Cita(1));
        expResult.add(new Cita(2));
        List<Cita> result = instance.obtenerCitas();
        assertEquals(expResult, result);
    }

    /**
     * Test of agregarCita method, of class FacadadeDatos.
     */
    @Test
    public void testAgregarCita() throws ParseException {
        System.out.println("agregarCita");
        //ServicioderelajacionJpaController servicioControl = new ServicioderelajacionJpaController();
        
        List<Servicioderelajacion> listaDeServicio = new ArrayList<>();
//        listaDeServicio.add(new Servicioderelajacion(2));
        listaDeServicio.add(new Servicioderelajacion(1));
        //listaDeServicio.add(servicioControl.findServicioderelajacion("servicio2"));
        

        //Agregar cita
        Cita cita = new Cita();
        cita.setIdCita(0);
        
        //Agregar Fecha a cita
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("18/03/2020");
        cita.setFecha(d);
        
        //Agregar Hora a cita
        Calendar c2 = Calendar.getInstance();
//        c2.set(HOUR_OF_DAY,8);
//        c2.set(MINUTE,30);
//        c2.set(SECOND,0);
//        c2.set(MILLISECOND,0);
//        c2.add(Calendar.DATE, 1);
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
        cita.setCostoTotal(400.0f);
        
        //Agregar cliente
        cita.setIdCliente(new Cliente(1));
        
        //Agregra servicios
        cita.setServicioderelajacionList(listaDeServicio);
        
        instance.agregarCita(cita);
        
    }
    
    @Test
    public void obtenerCitasPorFecha() {
        List<Cita> lista = instance.obtenerCitasPorFecha(Calendar.getInstance().getTime());
        
        System.out.println(lista);
    }
    
    @Test
    public void obtenerServicios() {
        List<Servicioderelajacion> lista = instance.obtenerServicioderelajacion();
        for (Servicioderelajacion servicioderelajacion : lista) {
            System.out.println(servicioderelajacion.toString());
            
        }
    }
    
    @Test
    public void obtenerClientes(){
        List<Cliente> lista = instance.obtenerClientes();
        for (Cliente cliente : lista) {
            System.out.println(cliente.getNombre());
        }
    }
    
    @Test
    public void generarQuery() {
        String query = "SELECT c\n"
                + "FROM Cita c\n"
                + "where c.fecha = \"2020-03-29\" \n"
                + "and (((c.hora > \"07:30:00\" and c.hora < \"12:30:00\") \n"
                + "or (c.horaFin > \"07:30:00\" and c.hora < \"12:30:00\")) \n"
                + "or (\"07:30:00\" > c.hora and c.hora < c.horaFin) \n"
                + "or (\"12:30:00\" > c.hora and c.hora < c.horaFin))";

//        String query = "SELECT c FROM Cita c";
        List<Cita> lista = instance.generarQuery(query);

        System.out.println(lista.get(0).getIdCita());
    }
//
//    /**
//     * Test of actualizarCita method, of class FacadadeDatos.
//     */
//    @Test
//    public void testActualizarCita() {
//        System.out.println("actualizarCita");
//        Cita cita = null;
//        FacadadeDatos instance = new FacadadeDatos();
//        instance.actualizarCita(cita);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarCita method, of class FacadadeDatos.
//     */
//    @Test
//    public void testEliminarCita() {
//        System.out.println("eliminarCita");
//        String id = "";
//        FacadadeDatos instance = new FacadadeDatos();
//        instance.eliminarCita(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerCita method, of class FacadadeDatos.
//     */
//    @Test
//    public void testObtenerCita() {
//        System.out.println("obtenerCita");
//        String id = "";
//        FacadadeDatos instance = new FacadadeDatos();
//        Cita expResult = null;
//        Cita result = instance.obtenerCita(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
