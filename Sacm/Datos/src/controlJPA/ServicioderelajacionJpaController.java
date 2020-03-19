/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlJPA;

import controlJPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cita;
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
public class ServicioderelajacionJpaController implements Serializable {

    public ServicioderelajacionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DatosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicioderelajacion servicioderelajacion) {
        if (servicioderelajacion.getCitaList() == null) {
            servicioderelajacion.setCitaList(new ArrayList<Cita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cita> attachedCitaList = new ArrayList<Cita>();
            for (Cita citaListCitaToAttach : servicioderelajacion.getCitaList()) {
                citaListCitaToAttach = em.getReference(citaListCitaToAttach.getClass(), citaListCitaToAttach.getIdCita());
                attachedCitaList.add(citaListCitaToAttach);
            }
            servicioderelajacion.setCitaList(attachedCitaList);
            em.persist(servicioderelajacion);
            for (Cita citaListCita : servicioderelajacion.getCitaList()) {
                citaListCita.getServicioderelajacionList().add(servicioderelajacion);
                citaListCita = em.merge(citaListCita);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicioderelajacion servicioderelajacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicioderelajacion persistentServicioderelajacion = em.find(Servicioderelajacion.class, servicioderelajacion.getIdServicioDeRelajacion());
            List<Cita> citaListOld = persistentServicioderelajacion.getCitaList();
            List<Cita> citaListNew = servicioderelajacion.getCitaList();
            List<Cita> attachedCitaListNew = new ArrayList<Cita>();
            for (Cita citaListNewCitaToAttach : citaListNew) {
                citaListNewCitaToAttach = em.getReference(citaListNewCitaToAttach.getClass(), citaListNewCitaToAttach.getIdCita());
                attachedCitaListNew.add(citaListNewCitaToAttach);
            }
            citaListNew = attachedCitaListNew;
            servicioderelajacion.setCitaList(citaListNew);
            servicioderelajacion = em.merge(servicioderelajacion);
            for (Cita citaListOldCita : citaListOld) {
                if (!citaListNew.contains(citaListOldCita)) {
                    citaListOldCita.getServicioderelajacionList().remove(servicioderelajacion);
                    citaListOldCita = em.merge(citaListOldCita);
                }
            }
            for (Cita citaListNewCita : citaListNew) {
                if (!citaListOld.contains(citaListNewCita)) {
                    citaListNewCita.getServicioderelajacionList().add(servicioderelajacion);
                    citaListNewCita = em.merge(citaListNewCita);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = servicioderelajacion.getIdServicioDeRelajacion();
                if (findServicioderelajacion(id) == null) {
                    throw new NonexistentEntityException("The servicioderelajacion with id " + id + " no longer exists.");
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
            Servicioderelajacion servicioderelajacion;
            try {
                servicioderelajacion = em.getReference(Servicioderelajacion.class, id);
                servicioderelajacion.getIdServicioDeRelajacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioderelajacion with id " + id + " no longer exists.", enfe);
            }
            List<Cita> citaList = servicioderelajacion.getCitaList();
            for (Cita citaListCita : citaList) {
                citaListCita.getServicioderelajacionList().remove(servicioderelajacion);
                citaListCita = em.merge(citaListCita);
            }
            em.remove(servicioderelajacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicioderelajacion> findServicioderelajacionEntities() {
        return findServicioderelajacionEntities(true, -1, -1);
    }

    public List<Servicioderelajacion> findServicioderelajacionEntities(int maxResults, int firstResult) {
        return findServicioderelajacionEntities(false, maxResults, firstResult);
    }

    private List<Servicioderelajacion> findServicioderelajacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicioderelajacion.class));
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

    public Servicioderelajacion findServicioderelajacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicioderelajacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioderelajacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicioderelajacion> rt = cq.from(Servicioderelajacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
