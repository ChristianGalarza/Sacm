/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.exceptions.IllegalOrphanException;
import datos.exceptions.NonexistentEntityException;
import datos.exceptions.PreexistingEntityException;
import dominio.Cita;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cliente;
import dominio.Detallecita;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pc
 */
public class CitaJpaController implements Serializable {

    public CitaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cita cita) throws PreexistingEntityException, Exception {
        if (cita.getDetallecitaList() == null) {
            cita.setDetallecitaList(new ArrayList<Detallecita>());
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
            List<Detallecita> attachedDetallecitaList = new ArrayList<Detallecita>();
            for (Detallecita detallecitaListDetallecitaToAttach : cita.getDetallecitaList()) {
                detallecitaListDetallecitaToAttach = em.getReference(detallecitaListDetallecitaToAttach.getClass(), detallecitaListDetallecitaToAttach.getIdDetalleCita());
                attachedDetallecitaList.add(detallecitaListDetallecitaToAttach);
            }
            cita.setDetallecitaList(attachedDetallecitaList);
            em.persist(cita);
            if (idCliente != null) {
                idCliente.getCitaList().add(cita);
                idCliente = em.merge(idCliente);
            }
            for (Detallecita detallecitaListDetallecita : cita.getDetallecitaList()) {
                Cita oldIdCitaOfDetallecitaListDetallecita = detallecitaListDetallecita.getIdCita();
                detallecitaListDetallecita.setIdCita(cita);
                detallecitaListDetallecita = em.merge(detallecitaListDetallecita);
                if (oldIdCitaOfDetallecitaListDetallecita != null) {
                    oldIdCitaOfDetallecitaListDetallecita.getDetallecitaList().remove(detallecitaListDetallecita);
                    oldIdCitaOfDetallecitaListDetallecita = em.merge(oldIdCitaOfDetallecitaListDetallecita);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCita(cita.getIdCita()) != null) {
                throw new PreexistingEntityException("Cita " + cita + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cita cita) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cita persistentCita = em.find(Cita.class, cita.getIdCita());
            Cliente idClienteOld = persistentCita.getIdCliente();
            Cliente idClienteNew = cita.getIdCliente();
            List<Detallecita> detallecitaListOld = persistentCita.getDetallecitaList();
            List<Detallecita> detallecitaListNew = cita.getDetallecitaList();
            List<String> illegalOrphanMessages = null;
            for (Detallecita detallecitaListOldDetallecita : detallecitaListOld) {
                if (!detallecitaListNew.contains(detallecitaListOldDetallecita)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecita " + detallecitaListOldDetallecita + " since its idCita field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                cita.setIdCliente(idClienteNew);
            }
            List<Detallecita> attachedDetallecitaListNew = new ArrayList<Detallecita>();
            for (Detallecita detallecitaListNewDetallecitaToAttach : detallecitaListNew) {
                detallecitaListNewDetallecitaToAttach = em.getReference(detallecitaListNewDetallecitaToAttach.getClass(), detallecitaListNewDetallecitaToAttach.getIdDetalleCita());
                attachedDetallecitaListNew.add(detallecitaListNewDetallecitaToAttach);
            }
            detallecitaListNew = attachedDetallecitaListNew;
            cita.setDetallecitaList(detallecitaListNew);
            cita = em.merge(cita);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getCitaList().remove(cita);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getCitaList().add(cita);
                idClienteNew = em.merge(idClienteNew);
            }
            for (Detallecita detallecitaListNewDetallecita : detallecitaListNew) {
                if (!detallecitaListOld.contains(detallecitaListNewDetallecita)) {
                    Cita oldIdCitaOfDetallecitaListNewDetallecita = detallecitaListNewDetallecita.getIdCita();
                    detallecitaListNewDetallecita.setIdCita(cita);
                    detallecitaListNewDetallecita = em.merge(detallecitaListNewDetallecita);
                    if (oldIdCitaOfDetallecitaListNewDetallecita != null && !oldIdCitaOfDetallecitaListNewDetallecita.equals(cita)) {
                        oldIdCitaOfDetallecitaListNewDetallecita.getDetallecitaList().remove(detallecitaListNewDetallecita);
                        oldIdCitaOfDetallecitaListNewDetallecita = em.merge(oldIdCitaOfDetallecitaListNewDetallecita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cita.getIdCita();
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

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Detallecita> detallecitaListOrphanCheck = cita.getDetallecitaList();
            for (Detallecita detallecitaListOrphanCheckDetallecita : detallecitaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cita (" + cita + ") cannot be destroyed since the Detallecita " + detallecitaListOrphanCheckDetallecita + " in its detallecitaList field has a non-nullable idCita field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente idCliente = cita.getIdCliente();
            if (idCliente != null) {
                idCliente.getCitaList().remove(cita);
                idCliente = em.merge(idCliente);
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

    public Cita findCita(String id) {
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
