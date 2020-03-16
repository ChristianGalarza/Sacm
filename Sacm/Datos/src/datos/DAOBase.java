/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;


/**
 *
 * @author pc
 * @param <T>
 */
public abstract class DAOBase<T> {
    
    public abstract List<T> obtenerTodos();
    
    public abstract void agregar(T t);
    
    public abstract void actualizar(T t);
    
    public abstract void eliminar (String id);
    
    public abstract T obtener (String id);
    
}
