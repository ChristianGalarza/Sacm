/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cita;
import exceptions.IllegalOrphanException;
import exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpaControles.CitaJpaController;

/**
 *
 * @author pc
 */
public class CitaDAO extends DAOBase<Cita>{
    
    CitaJpaController cjc = new CitaJpaController();

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
    public void eliminar(String id) {
        try {
            cjc.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cita obtener(String id) {
        return cjc.findCita(id);
    }
    
}
