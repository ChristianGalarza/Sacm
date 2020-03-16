/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Cita;
import java.util.List;

/**
 *
 * @author pc
 */
public class FacadadeNegocio implements IFacadadeNegocio{

    private CitaControl citaControl;

    public FacadadeNegocio() {
        this.citaControl = new CitaControl();
    }

    @Override
    public List<Cita> obtenerCitas() {
        return this.citaControl.obtenerCitas();
    }
    
    @Override
    public void agregarCita(Cita cita) {
        this.citaControl.agregarCita(cita);
    }
    
    @Override
    public void actualizarCita(Cita cita) {
        this.citaControl.actualizarCita(cita);
    }

    
    @Override
    public void eliminarCita(int id) {
        this.citaControl.eliminarCita(id);
    }

    @Override
    public Cita obtenerCita(int id) {
        return this.citaControl.obtenerCita(id);
    }
    
    
}
