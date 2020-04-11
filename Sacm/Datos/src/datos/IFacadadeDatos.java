/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.exceptions.IllegalOrphanException;
import controlJPA.exceptions.NonexistentEntityException;
import dominio.Cita;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void agregarCliente(Cliente t);

    public void actualizarCliente(Cliente t);

    public void eliminarCliente(int id);

    public Cliente obtenerCliente(int id);
    
    public void agregarServicioderelajacion(Servicioderelajacion t);

    public void actualizarServicioderelajacion(Servicioderelajacion t);

    public void eliminarServicioderelajacion(int id);

    public Servicioderelajacion obtenerServicioderelajacion(int id);
    
}
