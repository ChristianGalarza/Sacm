/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.ServicioderelajacionJpaController;
import controlJPA.exceptions.NonexistentEntityException;
import java.util.List;
import dominio.Servicioderelajacion;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pc
 */
public class ServicioDeRelajacionDAO extends DAOBase<Servicioderelajacion>{

    private ServicioderelajacionJpaController serviciosJPA;

    public ServicioDeRelajacionDAO() {
        this.serviciosJPA = new ServicioderelajacionJpaController();
    }

    @Override
    public List<Servicioderelajacion> obtenerTodos() {
        return this.serviciosJPA.findServicioderelajacionEntities();
    }

    @Override
    public void agregar(Servicioderelajacion t) {
        this.serviciosJPA.create(t);
    }

    @Override
    public void actualizar(Servicioderelajacion t) {
        try {
            this.serviciosJPA.edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServicioDeRelajacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            this.serviciosJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServicioDeRelajacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Servicioderelajacion obtener(int id) {
        return this.serviciosJPA.findServicioderelajacion(id);
    }

    
    
}
