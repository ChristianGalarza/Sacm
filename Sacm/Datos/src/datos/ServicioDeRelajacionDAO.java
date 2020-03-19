/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.ServicioderelajacionJpaController;
import java.util.List;
import dominio.Servicioderelajacion;
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
        
    }

    @Override
    public void actualizar(Servicioderelajacion t) {
        
    }

    @Override
    public void eliminar(int id) {
        
    }

    @Override
    public Servicioderelajacion obtener(int id) {
        return null;
    }

    
    
}
