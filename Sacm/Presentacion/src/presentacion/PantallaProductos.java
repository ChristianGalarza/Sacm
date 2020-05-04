/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cita;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.IFacadadeNegocio;
import constantes.Constantes;
import dominio.Producto;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class PantallaProductos extends javax.swing.JDialog {
    private int ESPACIO_ENTRE_LINEAS = 40;
    private IFacadadeNegocio facadadeNegocio;
    private List<Producto> listaDeProductos;
    /**
     * Creates new form Pantalla
     * @param parent
     * @param modal
     * @param facadadeNegocio
     */
    public PantallaProductos(java.awt.Frame parent, boolean modal, IFacadadeNegocio facadadeNegocio) {
        super(parent, modal);
        initComponents();
        this.facadadeNegocio = facadadeNegocio;
        this.setLocationRelativeTo(null);
    }
    
    public void cargarProductos() {
        this.listaDeProductos = facadadeNegocio.obtenerProductos();
        String nombreColumnas [] = {"ID","Nombre","Costo","Descripcion"};
        String producto[][]= new String[this.listaDeProductos.size()][4];
        Producto productoAuxiliar;
        int saltosdeLinea = 1;
        for (int i = 0; i < this.listaDeProductos.size(); i++) {
            productoAuxiliar = this.listaDeProductos.get(i);
            producto[i][0] = productoAuxiliar.getIdProducto();
            producto[i][1] = productoAuxiliar.getNombre();
            producto[i][2] = Float.toString(productoAuxiliar.getCosto());
            producto[i][3] = productoAuxiliar.getDescripcion();
        }
        jTable_Producto.setRowHeight(saltosdeLinea*this.ESPACIO_ENTRE_LINEAS);
        
        this.jTable_Producto.setModel(new DefaultTableModel(producto, nombreColumnas));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Producto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jButton_AgregarProducto = new javax.swing.JButton();
        jButton_ModificarProducto = new javax.swing.JButton();
        jButton_EliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable_Producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idCliente", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_Producto);

        jButton_AgregarProducto.setText("Agregar Productos");
        jButton_AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarProductoActionPerformed(evt);
            }
        });

        jButton_ModificarProducto.setText("Modificar Productos");
        jButton_ModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModificarProductoActionPerformed(evt);
            }
        });

        jButton_EliminarProducto.setText("Eliminar Producto");
        jButton_EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_EliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_ModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_AgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton_AgregarProducto)
                .addGap(18, 18, 18)
                .addComponent(jButton_ModificarProducto)
                .addGap(18, 18, 18)
                .addComponent(jButton_EliminarProducto)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarProductoActionPerformed
        this.mostrarPantallaProducto(Constantes.AGREGAR, null);
    }//GEN-LAST:event_jButton_AgregarProductoActionPerformed

    private void jButton_ModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModificarProductoActionPerformed
        this.mostrarPantallaProducto(Constantes.MODIFICAR, null);
    }//GEN-LAST:event_jButton_ModificarProductoActionPerformed

    private void jButton_EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarProductoActionPerformed
        this.mostrarPantallaProducto(Constantes.ELIMINAR, null);
    }//GEN-LAST:event_jButton_EliminarProductoActionPerformed

    public void mostrarPantallaProducto(int tipoDeOperacion, Producto producto) {
        PantallaProducto pantallaProducto = PantallaProducto.getInstancia(null, true, this.facadadeNegocio);
        this.setVisible(false);
        if(tipoDeOperacion == Constantes.AGREGAR) {
            pantallaProducto.mostrarPantalla(tipoDeOperacion, producto);
        } else {
            int fila = this.jTable_Producto.getSelectedRow();
            if (fila != -1) {
                Producto productoSeleccion = this.listaDeProductos.get(fila);
                pantallaProducto.mostrarPantalla(tipoDeOperacion, productoSeleccion);
            } else {
                this.mostrarAdvertencia("Seleccione un producto", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.cargarProductos();
        this.setVisible(true);
    }
    
    public void mostrarAdvertencia(String mensaje, int tipoDeMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AgregarProducto;
    private javax.swing.JButton jButton_EliminarProducto;
    private javax.swing.JButton jButton_ModificarProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Producto;
    // End of variables declaration//GEN-END:variables
}
