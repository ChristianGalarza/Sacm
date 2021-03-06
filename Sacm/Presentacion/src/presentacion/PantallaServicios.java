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
import dominio.Servicioderelajacion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class PantallaServicios extends javax.swing.JDialog {
    private int ESPACIO_ENTRE_LINEAS = 40;
    private IFacadadeNegocio facadadeNegocio;
    private List<Servicioderelajacion> listaDeServicios;
    /**
     * Creates new form Pantalla
     * @param parent
     * @param modal
     * @param facadadeNegocio
     */
    public PantallaServicios(java.awt.Frame parent, boolean modal, IFacadadeNegocio facadadeNegocio) {
        super(parent, modal);
        initComponents();
        this.facadadeNegocio = facadadeNegocio;
        this.setLocationRelativeTo(null);
    }
    
    public void cargarServicios() {
        this.listaDeServicios = facadadeNegocio.obtenerServiciosDeRelajacion();
        String nombreColumnas [] = {"ID","Nombre","Duracion","Costo","Descripción"};
        String servicio[][]= new String[this.listaDeServicios.size()][5];
        Servicioderelajacion servicioAuxiliar;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        int saltosdeLinea = 1;
        for (int i = 0; i < this.listaDeServicios.size(); i++) {
            servicioAuxiliar = this.listaDeServicios.get(i);
            servicio[i][0] = Integer.toString(servicioAuxiliar.getIdServicioDeRelajacion());
            servicio[i][1] = servicioAuxiliar.getNombre();
            String strDate=dateFormat.format(servicioAuxiliar.getDuracion());
            servicio[i][2] = strDate;
            servicio[i][3] = Float.toString(servicioAuxiliar.getCosto());
            servicio[i][4] = servicioAuxiliar.getDescripcion();
        }
        jTable_Servicio.setRowHeight(saltosdeLinea*this.ESPACIO_ENTRE_LINEAS);
        
        this.jTable_Servicio.setModel(new DefaultTableModel(servicio, nombreColumnas));
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
        jTable_Servicio = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jButton_AgregarServicio = new javax.swing.JButton();
        jButton_ModificarServicio = new javax.swing.JButton();
        jButton_EliminarServicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable_Servicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idCliente", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(jTable_Servicio);

        jButton_AgregarServicio.setText("Agregar Servicio");
        jButton_AgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarServicioActionPerformed(evt);
            }
        });

        jButton_ModificarServicio.setText("Modificar Servicio");
        jButton_ModificarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModificarServicioActionPerformed(evt);
            }
        });

        jButton_EliminarServicio.setText("Eliminar Servicio");
        jButton_EliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_EliminarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton_AgregarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_ModificarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton_AgregarServicio)
                .addGap(18, 18, 18)
                .addComponent(jButton_ModificarServicio)
                .addGap(18, 18, 18)
                .addComponent(jButton_EliminarServicio)
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

    private void jButton_AgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarServicioActionPerformed
        this.mostrarPantallaServicio(Constantes.AGREGAR, null);
    }//GEN-LAST:event_jButton_AgregarServicioActionPerformed

    private void jButton_ModificarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModificarServicioActionPerformed
        this.mostrarPantallaServicio(Constantes.MODIFICAR, null);
    }//GEN-LAST:event_jButton_ModificarServicioActionPerformed

    private void jButton_EliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarServicioActionPerformed
        this.mostrarPantallaServicio(Constantes.ELIMINAR, null);
    }//GEN-LAST:event_jButton_EliminarServicioActionPerformed

    public void mostrarPantallaServicio(int tipoDeOperacion, Servicioderelajacion servicio) {
        PantallaServicio pantallaServicio = PantallaServicio.getInstancia(null, true, this.facadadeNegocio);
        this.setVisible(false);
        if(tipoDeOperacion == Constantes.AGREGAR) {
            pantallaServicio.mostrarPantalla(tipoDeOperacion, servicio);
        } else {
            int fila = this.jTable_Servicio.getSelectedRow();
            if (fila != -1) {
                Servicioderelajacion servicioSeleccion = this.listaDeServicios.get(fila);
                pantallaServicio.mostrarPantalla(tipoDeOperacion, servicioSeleccion);
            } else {
                this.mostrarAdvertencia("Seleccione un servicio", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.cargarServicios();
        this.setVisible(true);
    }
    
    public void mostrarAdvertencia(String mensaje, int tipoDeMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AgregarServicio;
    private javax.swing.JButton jButton_EliminarServicio;
    private javax.swing.JButton jButton_ModificarServicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Servicio;
    // End of variables declaration//GEN-END:variables
}
