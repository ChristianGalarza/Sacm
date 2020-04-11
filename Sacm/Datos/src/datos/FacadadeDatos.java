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
public class FacadadeDatos implements IFacadadeDatos{
    
    private DAOBase<Cita> daoCita;
    private DAOBase<Servicioderelajacion> daoServicioDeRelajacion;
    private DAOBase<Cliente> daoCliente;

    public FacadadeDatos() {
        this.daoCita = new CitaDAO();
        this.daoServicioDeRelajacion = new ServicioDeRelajacionDAO();
        this.daoCliente = new ClienteDAO();
    }

    @Override
    public List<Cita> obtenerCitas() {
        return this.daoCita.obtenerTodos();
    }

    @Override
    public void agregarCita(Cita cita) {
        this.daoCita.agregar(cita);
    }

    @Override
    public void actualizarCita(Cita cita) {
        this.daoCita.actualizar(cita);
    }

    @Override
    public void eliminarCita(int id) {
        this.daoCita.eliminar(id);
    }

    @Override
    public Cita obtenerCita(int id) {
        return daoCita.obtener(id);
    }

    @Override
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        return ((CitaDAO)daoCita).obtenerCitasPorFecha(fecha);
    }

    @Override
    public List<Servicioderelajacion> obtenerServicioderelajacion() {
        return this.daoServicioDeRelajacion.obtenerTodos();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return this.daoCliente.obtenerTodos();
    }

    @Override
    public List<Cita> generarQuery(String query) {
        return ((CitaDAO)daoCita).generarQuery(query);
    }

    @Override
    public void agregarCliente(Cliente t) {
        this.daoCliente.agregar(t);
    }

    @Override
    public void actualizarCliente(Cliente t) {
        this.daoCliente.actualizar(t);
    }

    @Override
    public void eliminarCliente(int id) {
        this.daoCliente.eliminar(id);
    }

    @Override
    public Cliente obtenerCliente(int id) {
        return this.daoCliente.obtener(id);
    }

    @Override
    public void agregarServicioderelajacion(Servicioderelajacion t) {
        this.daoServicioDeRelajacion.agregar(t);
    }

    @Override
    public void actualizarServicioderelajacion(Servicioderelajacion t) {
        this.daoServicioDeRelajacion.actualizar(t);
    }

    @Override
    public void eliminarServicioderelajacion(int id) {
        this.daoServicioDeRelajacion.eliminar(id);
    }

    @Override
    public Servicioderelajacion obtenerServicioderelajacion(int id) {
        return this.daoServicioDeRelajacion.obtener(id);
    }
    
    
    
}
