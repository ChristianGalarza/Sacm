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
    
    public void agregarServicioDeRelajacion(Servicioderelajacion t) {
        this.facadadeDatos.agregarServicioderelajacion(t);
    }

    public void actualizarServicioDeRelajacion(Servicioderelajacion t) {
        this.facadadeDatos.actualizarServicioderelajacion(t);
    }

    public void eliminarServicioDeRelajacion(int id) {
        this.facadadeDatos.eliminarServicioderelajacion(id);
    }

    public Servicioderelajacion obtenerServicioDeRelajacion(int id) {
        return this.facadadeDatos.obtenerServicioderelajacion(id);
    }
    
    
}
