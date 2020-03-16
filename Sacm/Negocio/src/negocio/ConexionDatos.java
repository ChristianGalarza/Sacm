/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.FacadadeDatos;
import datos.IFacadeDatos;

/**
 *
 * @author pc
 */
public class ConexionDatos {
    
    public static IFacadeDatos facadadeDatos;

    private ConexionDatos() {
        
    }
    
    public static IFacadeDatos getInstancia() {
        if(facadadeDatos == null) {
            facadadeDatos = new FacadadeDatos();
        }
        return facadadeDatos;
    }
}
