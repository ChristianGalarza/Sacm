/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import controlJPA.CitaJpaController;
import controlJPA.ProductoJpaController;
import controlJPA.exceptions.NonexistentEntityException;
import dominio.Producto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ProductoDAO extends DAOBase<Producto>{

    private ProductoJpaController productoJPA;

    public ProductoDAO() {
        this.productoJPA = new ProductoJpaController();
    }
    
    @Override
    public List<Producto> obtenerTodos() {
        return this.productoJPA.findProductoEntities();
    }

    @Override
    public void agregar(Producto t) {
        try {
            this.productoJPA.create(t);
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Producto t) {
        try {
            this.productoJPA.edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            this.productoJPA.destroy(String.valueOf(id));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Producto obtener(int id) {
        return this.productoJPA.findProducto(String.valueOf(id));
    }
    
}
