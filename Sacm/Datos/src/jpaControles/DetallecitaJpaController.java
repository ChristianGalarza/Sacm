/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControles;

import exceptions.NonexistentEntityException;
import exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cita;
import dominio.Detallecita;
import dominio.Servicioderelajacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pc
 */
public class DetallecitaJpaController implements Serializable {

    public DetallecitaJpaController() {
        this.emf = this.emf = Persistence.createEntityManagerFactory("DatosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detallecita detallecita) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita idCita = detallecita.getIdCita();
            if (idCita != null) {
                idCita = em.getReference(idCita.getClass(), idCita.getIdCita());
                detallecita.setIdCita(idCita);
            }
            Servicioderelajacion idServicioDeRelajacion = detallecita.getIdServicioDeRelajacion();
            if (idServicioDeRelajacion != null) {
                idServicioDeRelajacion = em.getReference(idServicioDeRelajacion.getClass(), idServicioDeRelajacion.getIdServicioDeRelajacion());
                detallecita.setIdServicioDeRelajacion(idServicioDeRelajacion);
            }
            em.persist(detallecita);
            if (idCita != null) {
                idCita.getDetallecitaList().add(detallecita);
                idCita = em.merge(idCita);
            }
            if (idServicioDeRelajacion != null) {
                idServicioDeRelajacion.getDetallecitaList().add(detallecita);
                idServicioDeRelajacion = em.merge(idServicioDeRelajacion);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetallecita(detallecita.getIdDetalleCita()) != null) {
                throw new PreexistingEntityException("Detallecita " + detallecita + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallecita detallecita) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecita persistentDetallecita = em.find(Detallecita.class, detallecita.getIdDetalleCita());
            Cita idCitaOld = persistentDetallecita.getIdCita();
            Cita idCitaNew = detallecita.getIdCita();
            Servicioderelajacion idServicioDeRelajacionOld = persistentDetallecita.getIdServicioDeRelajacion();
            Servicioderelajacion idServicioDeRelajacionNew = detallecita.getIdServicioDeRelajacion();
            if (idCitaNew != null) {
                idCitaNew = em.getReference(idCitaNew.getClass(), idCitaNew.getIdCita());
                detallecita.setIdCita(idCitaNew);
            }
            if (idServicioDeRelajacionNew != null) {
                idServicioDeRelajacionNew = em.getReference(idServicioDeRelajacionNew.getClass(), idServicioDeRelajacionNew.getIdServicioDeRelajacion());
                detallecita.setIdServicioDeRelajacion(idServicioDeRelajacionNew);
            }
            detallecita = em.merge(detallecita);
            if (idCitaOld != null && !idCitaOld.equals(idCitaNew)) {
                idCitaOld.getDetallecitaList().remove(detallecita);
                idCitaOld = em.merge(idCitaOld);
            }
            if (idCitaNew != null && !idCitaNew.equals(idCitaOld)) {
                idCitaNew.getDetallecitaList().add(detallecita);
                idCitaNew = em.merge(idCitaNew);
            }
            if (idServicioDeRelajacionOld != null && !idServicioDeRelajacionOld.equals(idServicioDeRelajacionNew)) {
                idServicioDeRelajacionOld.getDetallecitaList().remove(detallecita);
                idServicioDeRelajacionOld = em.merge(idServicioDeRelajacionOld);
            }
            if (idServicioDeRelajacionNew != null && !idServicioDeRelajacionNew.equals(idServicioDeRelajacionOld)) {
                idServicioDeRelajacionNew.getDetallecitaList().add(detallecita);
                idServicioDeRelajacionNew = em.merge(idServicioDeRelajacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = detallecita.getIdDetalleCita();
                if (findDetallecita(id) == null) {
                    throw new NonexistentEntityException("The detallecita with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecita detallecita;
            try {
                detallecita = em.getReference(Detallecita.class, id);
                detallecita.getIdDetalleCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallecita with id " + id + " no longer exists.", enfe);
            }
            Cita idCita = detallecita.getIdCita();
            if (idCita != null) {
                idCita.getDetallecitaList().remove(detallecita);
                idCita = em.merge(idCita);
            }
            Servicioderelajacion idServicioDeRelajacion = detallecita.getIdServicioDeRelajacion();
            if (idServicioDeRelajacion != null) {
                idServicioDeRelajacion.getDetallecitaList().remove(detallecita);
                idServicioDeRelajacion = em.merge(idServicioDeRelajacion);
            }
            em.remove(detallecita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detallecita> findDetallecitaEntities() {
        return findDetallecitaEntities(true, -1, -1);
    }

    public List<Detallecita> findDetallecitaEntities(int maxResults, int firstResult) {
        return findDetallecitaEntities(false, maxResults, firstResult);
    }

    private List<Detallecita> findDetallecitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallecita.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Detallecita findDetallecita(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallecita.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallecitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallecita> rt = cq.from(Detallecita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
