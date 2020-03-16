/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.FacadadeDatos;
import datos.IFacadeDatos;
import dominio.Cita;
import java.util.List;

/**
 *
 * @author pc
 */
public class CitaControl {
    
    private IFacadeDatos facadadeDatos;

    public CitaControl() {
        this.facadadeDatos = new FacadadeDatos();
    }

    public List<Cita> obtenerCitas() {
        return this.facadadeDatos.obtenerCitas();
    }
    
    public void agregarCita(Cita cita) {
        this.facadadeDatos.agregarCita(cita);
    }
    
    public void actualizarCita(Cita cita) {
        this.facadadeDatos.actualizarCita(cita);
    }

    
    public void eliminarCita(String id) {
        this.facadadeDatos.eliminarCita(id);
    }

    public Cita obtenerCita(String id) {
        return this.facadadeDatos.obtenerCita(id);
    }
}
