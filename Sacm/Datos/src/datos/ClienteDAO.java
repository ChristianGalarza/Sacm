/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.ClienteJpaController;
import dominio.Cliente;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
