/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.ClienteJpaController;
import controlJPA.exceptions.IllegalOrphanException;
import controlJPA.exceptions.NonexistentEntityException;
import dominio.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ClienteDAO extends DAOBase<Cliente>{

    private ClienteJpaController clienteJPA;
    
    public ClienteDAO() {
        this.clienteJPA = new ClienteJpaController();
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return this.clienteJPA.findClienteEntities();
    }

    @Override
    public void agregar(Cliente t) {
        this.clienteJPA.create(t);
    }

    @Override
    public void actualizar(Cliente t) {
        try {
            this.clienteJPA.edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            this.clienteJPA.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente obtener(int id) {
        return this.clienteJPA.findCliente(id);
    }
    
}
