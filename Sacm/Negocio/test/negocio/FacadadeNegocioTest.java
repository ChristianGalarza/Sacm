/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.*;
import org.junit.Test;

/**
 *
 * @author pc
 */
public class FacadadeNegocioTest {
    
    IFacadadeNegocio instance = new FacadadeNegocio();
    /**
     * Test of obtenerCitas method, of class FacadadeNegocio.
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
//     * Test of agregarCita method, of class FacadadeNegocio.
//     */
//    @Test
//    public void testAgregarCita() {
//        System.out.println("agregarCita");
//        Cita cita = null;
//        FacadadeNegocio instance = new FacadadeNegocio();
//        instance.agregarCita(cita);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of actualizarCita method, of class FacadadeNegocio.
//     */
//    @Test
//    public void testActualizarCita() {
//        System.out.println("actualizarCita");
//        Cita cita = null;
//        FacadadeNegocio instance = new FacadadeNegocio();
//        instance.actualizarCita(cita);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarCita method, of class FacadadeNegocio.
//     */
//    @Test
//    public void testEliminarCita() {
//        System.out.println("eliminarCita");
//        String id = "";
//        FacadadeNegocio instance = new FacadadeNegocio();
//        instance.eliminarCita(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerCita method, of class FacadadeNegocio.
//     */
//    @Test
//    public void testObtenerCita() {
//        System.out.println("obtenerCita");
//        String id = "";
//        FacadadeNegocio instance = new FacadadeNegocio();
//        Cita expResult = null;
//        Cita result = instance.obtenerCita(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
