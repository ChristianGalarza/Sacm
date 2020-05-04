/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import constantes.Constantes;
import dominio.Cliente;
import java.util.List;
import negocio.IFacadadeNegocio;
import com.mxrck.autocompleter.*;
import dominio.Producto;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class PantallaProducto extends javax.swing.JDialog{

    private static PantallaProducto pantallaProducto;
    private Producto producto;
    private int operacion;
    private IFacadadeNegocio facadadeNegocio;
    //private Autocompletar autocompletar;
    /**
     * Creates new form PantallaCita
     */
    private PantallaProducto(java.awt.Frame parent, boolean modal, IFacadadeNegocio facadadeNegocio) {
        super(parent, modal);
        this.facadadeNegocio = facadadeNegocio;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static PantallaProducto getInstancia(java.awt.Frame parent, boolean modal,IFacadadeNegocio facadadeNegocio) {
        if(pantallaProducto == null) {
            pantallaProducto = new PantallaProducto(parent, modal, facadadeNegocio);
        }
        return pantallaProducto;
    }

    public void actualizarPantalla(int operacion, Producto producto) {
        this.operacion = operacion;
        this.producto = producto;
        if(operacion == Constantes.AGREGAR) {
            this.jLabel_Titulo.setText("Agregar Producto");
            this.jButton_GuardarCliente.setText("Guardar Producto");
        } else if (operacion == Constantes.MODIFICAR) {
            this.jLabel_Titulo.setText("Actualizar Producto");
            this.jButton_GuardarCliente.setText("Actualizar Producto");
            
        } else if (operacion == Constantes.ELIMINAR) {
            this.jLabel_Titulo.setText("Eliminar Producto");
            this.jButton_GuardarCliente.setText("Eliminar Producto");
            this.setEditableComponentes(false);
        }
        
        if (operacion == Constantes.MODIFICAR || operacion == Constantes.ELIMINAR) {
            this.jTextField_Id.setText(producto.getIdProducto());
            this.jTextField1_Nombre.setText(producto.getNombre());
            this.jSpinner1_cost.setValue(producto.getCosto());
            this.jTextArea_Descripcion.setText(producto.getDescripcion());
        }
        
        if(operacion == Constantes.MODIFICAR || operacion == Constantes.AGREGAR) {
            this.setEditableComponentes(true);
        }
    }
    
    public void setEditableComponentes(boolean bln){
        this.jTextField_Id.setEditable(false);
        this.jTextField1_Nombre.setEditable(bln);
        this.jSpinner1_cost.setEnabled(bln);
        this.jTextArea_Descripcion.setEditable(bln);
    }
    
    public void cerrarPantalla() {
        this.setVisible(false);     
    }
    
    public void limpiarPantalla() {
        this.jTextField_Id.setText("");
        this.jTextField1_Nombre.setText("");
        this.jSpinner1_cost.setValue(0);
        this.jTextArea_Descripcion.setText("");
    }
    
    public void mostrarPantalla(int operacion, Producto producto) {
        this.limpiarPantalla();
        this.actualizarPantalla(operacion, producto);
        this.setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        jPanel_DatosCita = new javax.swing.JPanel();
        jTextField_Id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_Nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSpinner1_cost = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Descripcion = new javax.swing.JTextArea();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_GuardarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setToolTipText("");

        jTextField_Id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_IdKeyPressed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel8.setText("Nombre:");

        jTextField1_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_NombreActionPerformed(evt);
            }
        });

        jLabel9.setText("Costo:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Descripcion:");

        jTextArea_Descripcion.setColumns(20);
        jTextArea_Descripcion.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Descripcion);

        javax.swing.GroupLayout jPanel_DatosCitaLayout = new javax.swing.GroupLayout(jPanel_DatosCita);
        jPanel_DatosCita.setLayout(jPanel_DatosCitaLayout);
        jPanel_DatosCitaLayout.setHorizontalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DatosCitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_DatosCitaLayout.setVerticalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinner1_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });

        jButton_GuardarCliente.setText("Guardar Cliente");
        jButton_GuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_Cancelar)
                                .addGap(63, 63, 63)
                                .addComponent(jButton_GuardarCliente)
                                .addGap(158, 158, 158))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_GuardarCliente)
                    .addComponent(jButton_Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarClienteActionPerformed
        //VALIDAR CAMPOS
        if (operacion == Constantes.AGREGAR) {
            if (this.validarCampos(Constantes.AGREGAR)) {
                if (this.mostrarMensajeDeConfirmacion("¿Desea guardar el producto?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.producto = new Producto();
                    this.producto.setIdProducto(this.jTextField_Id.getText());
                    this.producto.setNombre(this.jTextField1_Nombre.getText());
                    this.producto.setCosto((float)(int)this.jSpinner1_cost.getValue());
                    this.producto.setDescripcion(this.jTextArea_Descripcion.getText());
                    if (verificarProducto(producto)) {
                        this.facadadeNegocio.agregarProducto(producto);
                        this.mostrarMensajeDeAdvertencia("Producto guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        this.mostrarMensajeDeAdvertencia("Ya existe un producto con el mismo id", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            } else {
                return;
            }
        } else if (operacion == Constantes.MODIFICAR) {
            if (this.validarCampos(Constantes.MODIFICAR)) {
                if (this.mostrarMensajeDeConfirmacion("¿Desea actualizar el producto?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.producto.setIdProducto(this.jTextField_Id.getText());
                    this.producto.setNombre(this.jTextField1_Nombre.getText());
                    this.producto.setCosto((float)(int)this.jSpinner1_cost.getValue());
                    this.producto.setDescripcion(this.jTextArea_Descripcion.getText());
                    this.facadadeNegocio.actualizarProducto(producto);
                }
            } else {
                return;
            }
        } else if (this.operacion == Constantes.ELIMINAR) {
            if(this.mostrarMensajeDeConfirmacion("¿Desea eliminar el producto?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.facadadeNegocio.eliminarProducto(Integer.parseInt(this.producto.getIdProducto()));
                this.mostrarMensajeDeAdvertencia("Producto eliminada correctamente",JOptionPane.INFORMATION_MESSAGE);
            }
        }
//        
        this.cerrarPantalla();
    }//GEN-LAST:event_jButton_GuardarClienteActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        this.cerrarPantalla();
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jTextField_IdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IdKeyPressed
//        this.jTextField_Id.setText("0");
    }//GEN-LAST:event_jTextField_IdKeyPressed

    private void jTextField1_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NombreActionPerformed

    public int mostrarMensajeDeConfirmacion(String mensaje,int tipoDeMensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }
    
    public void mostrarMensajeDeAdvertencia(String mensaje, int tipoDeMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }
    
    public boolean validarCampos(int operacion) {
        if(this.jTextField_Id.getText().equals("")) {
            mostrarMensajeDeAdvertencia("Ingrese un id", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.jTextField1_Nombre.getText().equals("")) {
            mostrarMensajeDeAdvertencia("Ingrese un Nombre", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (operacion==2) {
            if((float)(int)this.jSpinner1_cost.getValue()<= 0) {
            mostrarMensajeDeAdvertencia("Ingrese un precio correcto", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(operacion==1){
                if((float)(int)this.jSpinner1_cost.getValue() <= 0) {
                mostrarMensajeDeAdvertencia("Ingrese un precio correcto", JOptionPane.ERROR_MESSAGE);
                return false;
                }
            }
        }
        return true;   
    }
    
    public boolean verificarProducto(Producto producto){
        List<Producto> listProductoAuxiliar = facadadeNegocio.obtenerProductos();
        for (Producto productoAux : listProductoAuxiliar) {
            if (productoAux.getIdProducto().equalsIgnoreCase(producto.getIdProducto())) {
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_GuardarCliente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JPanel jPanel_DatosCita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1_cost;
    private javax.swing.JTextArea jTextArea_Descripcion;
    private javax.swing.JTextField jTextField1_Nombre;
    private javax.swing.JTextField jTextField_Id;
    // End of variables declaration//GEN-END:variables


}