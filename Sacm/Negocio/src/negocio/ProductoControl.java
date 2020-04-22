/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.FacadadeDatos;
import datos.IFacadadeDatos;
import dominio.Producto;
import java.util.List;

/**
 *
 * @author pc
 */
public class ProductoControl {
    
    private IFacadadeDatos facadadeDatos;
    
    public ProductoControl() {
        this.facadadeDatos = new FacadadeDatos();
    }
    
    public List<Producto> obtenerProductos() {
        return this.facadadeDatos.obtenerProductos();
    }

    public void agregarProducto(Producto t) {
        this.facadadeDatos.agregarProducto(t);
    }
    
    public void actualizarProducto(Producto t) {
        this.facadadeDatos.actualizarProducto(t);
    }

    public void eliminarProducto(int id) {
        this.facadadeDatos.eliminarProducto(id);
    }

    public Producto obtenerProducto(int id) {
        return this.facadadeDatos.obtenerProducto(id);
    }
}
