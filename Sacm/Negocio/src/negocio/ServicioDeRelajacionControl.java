/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import datos.FacadadeDatos;
import datos.IFacadeDatos;
import dominio.Servicioderelajacion;
import java.util.List;
/**
 *
 * @author pc
 */
public class ServicioDeRelajacionControl {
    
    private IFacadeDatos facadadeDatos;

    public ServicioDeRelajacionControl() {
        this.facadadeDatos = new FacadadeDatos();
    }
    
    public List<Servicioderelajacion> obtenerServiciosDeRelajacion() {
        return this.facadadeDatos.obtenerServicioderelajacion();
    }
    
    
    
}
