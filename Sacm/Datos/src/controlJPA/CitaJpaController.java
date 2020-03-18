/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlJPA;

import controlJPA.exceptions.NonexistentEntityException;
import dominio.Cita;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pc
 */
public class CitaJpaController implements Serializable {

    public CitaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DatosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cita cita) {
        if (cita.getServicioderelajacionList() == null) {
            cita.setServicioderelajacionList(new ArrayList<Servicioderelajacion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = cita.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                cita.setIdCliente(idCliente);
            }
            List<Servicioderelajacion> attachedServicioderelajacionList = new ArrayList<Servicioderelajacion>();
            for (Servicioderelajacion servicioderelajacionListServicioderelajacionToAttach : cita.getServicioderelajacionList()) {
                servicioderelajacionListServicioderelajacionToAttach = em.getReference(servicioderelajacionListServicioderelajacionToAttach.getClass(), servicioderelajacionListServicioderelajacionToAttach.getIdServicioDeRelajacion());
                attachedServicioderelajacionList.add(servicioderelajacionListServicioderelajacionToAttach);
            }
            cita.setServicioderelajacionList(attachedServicioderelajacionList);
            em.persist(cita);
            if (idCliente != null) {
                idCliente.getCitaList().add(cita);
                idCliente = em.merge(idCliente);
            }
            for (Servicioderelajacion servicioderelajacionListServicioderelajacion : cita.getServicioderelajacionList()) {
                servicioderelajacionListServicioderelajacion.getCitaList().add(cita);
                servicioderelajacionListServicioderelajacion = em.merge(servicioderelajacionListServicioderelajacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cita cita) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita persistentCita = em.find(Cita.class, cita.getIdCita());
            Cliente idClienteOld = persistentCita.getIdCliente();
            Cliente idClienteNew = cita.getIdCliente();
            List<Servicioderelajacion> servicioderelajacionListOld = persistentCita.getServicioderelajacionList();
            List<Servicioderelajacion> servicioderelajacionListNew = cita.getServicioderelajacionList();
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                cita.setIdCliente(idClienteNew);
            }
            List<Servicioderelajacion> attachedServicioderelajacionListNew = new ArrayList<Servicioderelajacion>();
            for (Servicioderelajacion servicioderelajacionListNewServicioderelajacionToAttach : servicioderelajacionListNew) {
                servicioderelajacionListNewServicioderelajacionToAttach = em.getReference(servicioderelajacionListNewServicioderelajacionToAttach.getClass(), servicioderelajacionListNewServicioderelajacionToAttach.getIdServicioDeRelajacion());
                attachedServicioderelajacionListNew.add(servicioderelajacionListNewServicioderelajacionToAttach);
            }
            servicioderelajacionListNew = attachedServicioderelajacionListNew;
            cita.setServicioderelajacionList(servicioderelajacionListNew);
            cita = em.merge(cita);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getCitaList().remove(cita);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getCitaList().add(cita);
                idClienteNew = em.merge(idClienteNew);
            }
            for (Servicioderelajacion servicioderelajacionListOldServicioderelajacion : servicioderelajacionListOld) {
                if (!servicioderelajacionListNew.contains(servicioderelajacionListOldServicioderelajacion)) {
                    servicioderelajacionListOldServicioderelajacion.getCitaList().remove(cita);
                    servicioderelajacionListOldServicioderelajacion = em.merge(servicioderelajacionListOldServicioderelajacion);
                }
            }
            for (Servicioderelajacion servicioderelajacionListNewServicioderelajacion : servicioderelajacionListNew) {
                if (!servicioderelajacionListOld.contains(servicioderelajacionListNewServicioderelajacion)) {
                    servicioderelajacionListNewServicioderelajacion.getCitaList().add(cita);
                    servicioderelajacionListNewServicioderelajacion = em.merge(servicioderelajacionListNewServicioderelajacion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cita.getIdCita();
                if (findCita(id) == null) {
                    throw new NonexistentEntityException("The cita with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita cita;
            try {
                cita = em.getReference(Cita.class, id);
                cita.getIdCita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cita with id " + id + " no longer exists.", enfe);
            }
            Cliente idCliente = cita.getIdCliente();
            if (idCliente != null) {
                idCliente.getCitaList().remove(cita);
                idCliente = em.merge(idCliente);
            }
            List<Servicioderelajacion> servicioderelajacionList = cita.getServicioderelajacionList();
            for (Servicioderelajacion servicioderelajacionListServicioderelajacion : servicioderelajacionList) {
                servicioderelajacionListServicioderelajacion.getCitaList().remove(cita);
                servicioderelajacionListServicioderelajacion = em.merge(servicioderelajacionListServicioderelajacion);
            }
            em.remove(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cita> findCitaEntities() {
        return findCitaEntities(true, -1, -1);
    }

    public List<Cita> findCitaEntities(int maxResults, int firstResult) {
        return findCitaEntities(false, maxResults, firstResult);
    }

    private List<Cita> findCitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cita.class));
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

    public Cita findCita(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cita> rt = cq.from(Cita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
