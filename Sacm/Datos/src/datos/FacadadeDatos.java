/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cita;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class FacadadeDatos implements IFacadeDatos{
    
    private DAOBase<Cita> daoCita;

    public FacadadeDatos() {
        this.daoCita = new CitaDAO();
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
    
    
}
