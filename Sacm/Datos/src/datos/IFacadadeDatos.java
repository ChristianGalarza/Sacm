/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IFacadadeDatos {
    
    public List<Cita> obtenerCitas();
    
    public void agregarCita(Cita cita);
    
    public void actualizarCita(Cita cita);
    
    public void eliminarCita(int id);
    
    public Cita obtenerCita(int id);
    
    public List<Cita> obtenerCitasPorFecha(Date fecha);
    
    public List<Servicioderelajacion> obtenerServicioderelajacion();
    
    public List<Cliente> obtenerClientes();
    
    public List<Cita> generarQuery(String query);
    
}
