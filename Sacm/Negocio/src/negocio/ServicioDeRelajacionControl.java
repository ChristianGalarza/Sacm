/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import datos.FacadadeDatos;
import dominio.Servicioderelajacion;
import java.util.List;
import datos.IFacadadeDatos;
/**
 *
 * @author pc
 */
public class ServicioDeRelajacionControl {
    
    private IFacadadeDatos facadadeDatos;

    public ServicioDeRelajacionControl() {
        this.facadadeDatos = new FacadadeDatos();
    }
    
    public List<Servicioderelajacion> obtenerServiciosDeRelajacion() {
        return this.facadadeDatos.obtenerServicioderelajacion();
    }
    
    
    
}
