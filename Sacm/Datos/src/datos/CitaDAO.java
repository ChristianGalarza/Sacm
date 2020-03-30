/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.CitaJpaController;
import controlJPA.exceptions.NonexistentEntityException;
import dominio.Cita;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    
    public List<Cita> obtenerCitasPorFecha(Date fecha) {
        EntityManager em = cjc.getEntityManager();
        TypedQuery<Cita> consultaCita = em.createNamedQuery("Cita.findByFecha", Cita.class);
        consultaCita.setParameter("fecha", fecha);
        List<Cita> lista = consultaCita.getResultList();
        return lista;
    }
    
    public List<Cita> generarQuery(String query) {
        EntityManager em = cjc.getEntityManager();
        Query queryGenerado = em.createQuery(query);
        return (List<Cita>)queryGenerado.getResultList();
    }
}
