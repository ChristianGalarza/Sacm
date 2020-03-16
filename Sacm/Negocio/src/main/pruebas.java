/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.Cita;
import java.util.ArrayList;
import java.util.List;
import negocio.FacadadeNegocio;
import negocio.IFacadadeNegocio;

/**
 *
 * @author pc
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFacadadeNegocio instance = new FacadadeNegocio();
        System.out.println("obtenerCitas");
        
        List<Cita> expResult = new ArrayList<>();
        expResult.add(new Cita("c1"));
        expResult.add(new Cita("c2"));
        List<Cita> result = instance.obtenerCitas();
        System.out.println("Yia");
        
    }
    
}
