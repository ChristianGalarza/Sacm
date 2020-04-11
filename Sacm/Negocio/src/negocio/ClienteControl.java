/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.FacadadeDatos;
import datos.IFacadadeDatos;
import dominio.Cliente;
import java.util.List;

/**
 *
 * @author pc
 */
public class ClienteControl {
    private IFacadadeDatos facadadeDatos;
    
    public ClienteControl(){
        this.facadadeDatos = new FacadadeDatos();
    }
    
    public List<Cliente> obtenerClientes(){
        return this.facadadeDatos.obtenerClientes();
    }
    
    public void agregarCliente(Cliente t) {
        this.facadadeDatos.agregarCliente(t);
    }

    public void actualizarCliente(Cliente t) {
        this.facadadeDatos.actualizarCliente(t);
    }

    public void eliminarCliente(int id) {
        this.facadadeDatos.eliminarCliente(id);
    }

    public Cliente obtenerCliente(int id) {
        return this.facadadeDatos.obtenerCliente(id);
    }
}
