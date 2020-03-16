/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlesJPA;

import controlesJPA.exceptions.IllegalOrphanException;
import controlesJPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import dominio.Cita;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pc
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getClienteList() == null) {
            cliente.setClienteList(new ArrayList<Cliente>());
        }
        if (cliente.getCitaList() == null) {
            cliente.setCitaList(new ArrayList<Cita>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idClienteRecomendador = cliente.getIdClienteRecomendador();
            if (idClienteRecomendador != null) {
                idClienteRecomendador = em.getReference(idClienteRecomendador.getClass(), idClienteRecomendador.getIdCliente());
                cliente.setIdClienteRecomendador(idClienteRecomendador);
            }
            List<Cliente> attachedClienteList = new ArrayList<Cliente>();
            for (Cliente clienteListClienteToAttach : cliente.getClienteList()) {
                clienteListClienteToAttach = em.getReference(clienteListClienteToAttach.getClass(), clienteListClienteToAttach.getIdCliente());
                attachedClienteList.add(clienteListClienteToAttach);
            }
            cliente.setClienteList(attachedClienteList);
            List<Cita> attachedCitaList = new ArrayList<Cita>();
            for (Cita citaListCitaToAttach : cliente.getCitaList()) {
                citaListCitaToAttach = em.getReference(citaListCitaToAttach.getClass(), citaListCitaToAttach.getIdCita());
                attachedCitaList.add(citaListCitaToAttach);
            }
            cliente.setCitaList(attachedCitaList);
            em.persist(cliente);
            if (idClienteRecomendador != null) {
                idClienteRecomendador.getClienteList().add(cliente);
                idClienteRecomendador = em.merge(idClienteRecomendador);
            }
            for (Cliente clienteListCliente : cliente.getClienteList()) {
                Cliente oldIdClienteRecomendadorOfClienteListCliente = clienteListCliente.getIdClienteRecomendador();
                clienteListCliente.setIdClienteRecomendador(cliente);
                clienteListCliente = em.merge(clienteListCliente);
                if (oldIdClienteRecomendadorOfClienteListCliente != null) {
                    oldIdClienteRecomendadorOfClienteListCliente.getClienteList().remove(clienteListCliente);
                    oldIdClienteRecomendadorOfClienteListCliente = em.merge(oldIdClienteRecomendadorOfClienteListCliente);
                }
            }
            for (Cita citaListCita : cliente.getCitaList()) {
                Cliente oldIdClienteOfCitaListCita = citaListCita.getIdCliente();
                citaListCita.setIdCliente(cliente);
                citaListCita = em.merge(citaListCita);
                if (oldIdClienteOfCitaListCita != null) {
                    oldIdClienteOfCitaListCita.getCitaList().remove(citaListCita);
                    oldIdClienteOfCitaListCita = em.merge(oldIdClienteOfCitaListCita);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdCliente());
            Cliente idClienteRecomendadorOld = persistentCliente.getIdClienteRecomendador();
            Cliente idClienteRecomendadorNew = cliente.getIdClienteRecomendador();
            List<Cliente> clienteListOld = persistentCliente.getClienteList();
            List<Cliente> clienteListNew = cliente.getClienteList();
            List<Cita> citaListOld = persistentCliente.getCitaList();
            List<Cita> citaListNew = cliente.getCitaList();
            List<String> illegalOrphanMessages = null;
            for (Cita citaListOldCita : citaListOld) {
                if (!citaListNew.contains(citaListOldCita)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cita " + citaListOldCita + " since its idCliente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClienteRecomendadorNew != null) {
                idClienteRecomendadorNew = em.getReference(idClienteRecomendadorNew.getClass(), idClienteRecomendadorNew.getIdCliente());
                cliente.setIdClienteRecomendador(idClienteRecomendadorNew);
            }
            List<Cliente> attachedClienteListNew = new ArrayList<Cliente>();
            for (Cliente clienteListNewClienteToAttach : clienteListNew) {
                clienteListNewClienteToAttach = em.getReference(clienteListNewClienteToAttach.getClass(), clienteListNewClienteToAttach.getIdCliente());
                attachedClienteListNew.add(clienteListNewClienteToAttach);
            }
            clienteListNew = attachedClienteListNew;
            cliente.setClienteList(clienteListNew);
            List<Cita> attachedCitaListNew = new ArrayList<Cita>();
            for (Cita citaListNewCitaToAttach : citaListNew) {
                citaListNewCitaToAttach = em.getReference(citaListNewCitaToAttach.getClass(), citaListNewCitaToAttach.getIdCita());
                attachedCitaListNew.add(citaListNewCitaToAttach);
            }
            citaListNew = attachedCitaListNew;
            cliente.setCitaList(citaListNew);
            cliente = em.merge(cliente);
            if (idClienteRecomendadorOld != null && !idClienteRecomendadorOld.equals(idClienteRecomendadorNew)) {
                idClienteRecomendadorOld.getClienteList().remove(cliente);
                idClienteRecomendadorOld = em.merge(idClienteRecomendadorOld);
            }
            if (idClienteRecomendadorNew != null && !idClienteRecomendadorNew.equals(idClienteRecomendadorOld)) {
                idClienteRecomendadorNew.getClienteList().add(cliente);
                idClienteRecomendadorNew = em.merge(idClienteRecomendadorNew);
            }
            for (Cliente clienteListOldCliente : clienteListOld) {
                if (!clienteListNew.contains(clienteListOldCliente)) {
                    clienteListOldCliente.setIdClienteRecomendador(null);
                    clienteListOldCliente = em.merge(clienteListOldCliente);
                }
            }
            for (Cliente clienteListNewCliente : clienteListNew) {
                if (!clienteListOld.contains(clienteListNewCliente)) {
                    Cliente oldIdClienteRecomendadorOfClienteListNewCliente = clienteListNewCliente.getIdClienteRecomendador();
                    clienteListNewCliente.setIdClienteRecomendador(cliente);
                    clienteListNewCliente = em.merge(clienteListNewCliente);
                    if (oldIdClienteRecomendadorOfClienteListNewCliente != null && !oldIdClienteRecomendadorOfClienteListNewCliente.equals(cliente)) {
                        oldIdClienteRecomendadorOfClienteListNewCliente.getClienteList().remove(clienteListNewCliente);
                        oldIdClienteRecomendadorOfClienteListNewCliente = em.merge(oldIdClienteRecomendadorOfClienteListNewCliente);
                    }
                }
            }
            for (Cita citaListNewCita : citaListNew) {
                if (!citaListOld.contains(citaListNewCita)) {
                    Cliente oldIdClienteOfCitaListNewCita = citaListNewCita.getIdCliente();
                    citaListNewCita.setIdCliente(cliente);
                    citaListNewCita = em.merge(citaListNewCita);
                    if (oldIdClienteOfCitaListNewCita != null && !oldIdClienteOfCitaListNewCita.equals(cliente)) {
                        oldIdClienteOfCitaListNewCita.getCitaList().remove(citaListNewCita);
                        oldIdClienteOfCitaListNewCita = em.merge(oldIdClienteOfCitaListNewCita);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Cita> citaListOrphanCheck = cliente.getCitaList();
            for (Cita citaListOrphanCheckCita : citaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Cita " + citaListOrphanCheckCita + " in its citaList field has a non-nullable idCliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente idClienteRecomendador = cliente.getIdClienteRecomendador();
            if (idClienteRecomendador != null) {
                idClienteRecomendador.getClienteList().remove(cliente);
                idClienteRecomendador = em.merge(idClienteRecomendador);
            }
            List<Cliente> clienteList = cliente.getClienteList();
            for (Cliente clienteListCliente : clienteList) {
                clienteListCliente.setIdClienteRecomendador(null);
                clienteListCliente = em.merge(clienteListCliente);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
