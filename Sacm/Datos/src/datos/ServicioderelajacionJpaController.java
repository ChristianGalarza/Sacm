/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.exceptions.IllegalOrphanException;
import datos.exceptions.NonexistentEntityException;
import datos.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Detallecita;
import dominio.Servicioderelajacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pc
 */
public class ServicioderelajacionJpaController implements Serializable {

    public ServicioderelajacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicioderelajacion servicioderelajacion) throws PreexistingEntityException, Exception {
        if (servicioderelajacion.getDetallecitaList() == null) {
            servicioderelajacion.setDetallecitaList(new ArrayList<Detallecita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Detallecita> attachedDetallecitaList = new ArrayList<Detallecita>();
            for (Detallecita detallecitaListDetallecitaToAttach : servicioderelajacion.getDetallecitaList()) {
                detallecitaListDetallecitaToAttach = em.getReference(detallecitaListDetallecitaToAttach.getClass(), detallecitaListDetallecitaToAttach.getIdDetalleCita());
                attachedDetallecitaList.add(detallecitaListDetallecitaToAttach);
            }
            servicioderelajacion.setDetallecitaList(attachedDetallecitaList);
            em.persist(servicioderelajacion);
            for (Detallecita detallecitaListDetallecita : servicioderelajacion.getDetallecitaList()) {
                Servicioderelajacion oldIdServicioDeRelajacionOfDetallecitaListDetallecita = detallecitaListDetallecita.getIdServicioDeRelajacion();
                detallecitaListDetallecita.setIdServicioDeRelajacion(servicioderelajacion);
                detallecitaListDetallecita = em.merge(detallecitaListDetallecita);
                if (oldIdServicioDeRelajacionOfDetallecitaListDetallecita != null) {
                    oldIdServicioDeRelajacionOfDetallecitaListDetallecita.getDetallecitaList().remove(detallecitaListDetallecita);
                    oldIdServicioDeRelajacionOfDetallecitaListDetallecita = em.merge(oldIdServicioDeRelajacionOfDetallecitaListDetallecita);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findServicioderelajacion(servicioderelajacion.getIdServicioDeRelajacion()) != null) {
                throw new PreexistingEntityException("Servicioderelajacion " + servicioderelajacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicioderelajacion servicioderelajacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicioderelajacion persistentServicioderelajacion = em.find(Servicioderelajacion.class, servicioderelajacion.getIdServicioDeRelajacion());
            List<Detallecita> detallecitaListOld = persistentServicioderelajacion.getDetallecitaList();
            List<Detallecita> detallecitaListNew = servicioderelajacion.getDetallecitaList();
            List<String> illegalOrphanMessages = null;
            for (Detallecita detallecitaListOldDetallecita : detallecitaListOld) {
                if (!detallecitaListNew.contains(detallecitaListOldDetallecita)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecita " + detallecitaListOldDetallecita + " since its idServicioDeRelajacion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Detallecita> attachedDetallecitaListNew = new ArrayList<Detallecita>();
            for (Detallecita detallecitaListNewDetallecitaToAttach : detallecitaListNew) {
                detallecitaListNewDetallecitaToAttach = em.getReference(detallecitaListNewDetallecitaToAttach.getClass(), detallecitaListNewDetallecitaToAttach.getIdDetalleCita());
                attachedDetallecitaListNew.add(detallecitaListNewDetallecitaToAttach);
            }
            detallecitaListNew = attachedDetallecitaListNew;
            servicioderelajacion.setDetallecitaList(detallecitaListNew);
            servicioderelajacion = em.merge(servicioderelajacion);
            for (Detallecita detallecitaListNewDetallecita : detallecitaListNew) {
                if (!detallecitaListOld.contains(detallecitaListNewDetallecita)) {
                    Servicioderelajacion oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita = detallecitaListNewDetallecita.getIdServicioDeRelajacion();
                    detallecitaListNewDetallecita.setIdServicioDeRelajacion(servicioderelajacion);
                    detallecitaListNewDetallecita = em.merge(detallecitaListNewDetallecita);
                    if (oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita != null && !oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita.equals(servicioderelajacion)) {
                        oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita.getDetallecitaList().remove(detallecitaListNewDetallecita);
                        oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita = em.merge(oldIdServicioDeRelajacionOfDetallecitaListNewDetallecita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = servicioderelajacion.getIdServicioDeRelajacion();
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Detallecita> detallecitaListOrphanCheck = servicioderelajacion.getDetallecitaList();
            for (Detallecita detallecitaListOrphanCheckDetallecita : detallecitaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicioderelajacion (" + servicioderelajacion + ") cannot be destroyed since the Detallecita " + detallecitaListOrphanCheckDetallecita + " in its detallecitaList field has a non-nullable idServicioDeRelajacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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

    public Servicioderelajacion findServicioderelajacion(String id) {
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
