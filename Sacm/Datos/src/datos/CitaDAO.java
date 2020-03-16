/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlesJPA.CitaJpaController;
import controlesJPA.exceptions.NonexistentEntityException;
import dominio.Cita;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class CitaDAO extends DAOBase<Cita>{
    
    private CitaJpaController cjc;

    public CitaDAO() {
        this.cjc = new CitaJpaController();
    }

    @Override
    public List<Cita> obtenerTodos() {
        return cjc.findCitaEntities();
    }

    @Override
    public void agregar(Cita t) {
        try {
            cjc.create(t);
        } catch (Exception ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Cita t) {
        try {
            cjc.edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            cjc.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cita obtener(int id) {
        return cjc.findCita(id);
    }
    
}
