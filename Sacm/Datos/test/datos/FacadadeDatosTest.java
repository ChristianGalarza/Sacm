/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cita;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 *
 * @author pc
 */
public class FacadadeDatosTest {
    
    IFacadeDatos instance = new FacadadeDatos();
    /**
     * Test of obtenerCitas method, of class FacadadeDatos.
     */
    @Test
    public void testObtenerCitas() {
        System.out.println("obtenerCitas");
        List<Cita> expResult = new ArrayList<>();
        expResult.add(new Cita("c1"));
        expResult.add(new Cita("c2"));
        List<Cita> result = instance.obtenerCitas();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of agregarCita method, of class FacadadeDatos.
//     */
//    @Test
//    public void testAgregarCita() {
//        System.out.println("agregarCita");
//        Cita cita = null;
//        FacadadeDatos instance = new FacadadeDatos();
//        instance.agregarCita(cita);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
