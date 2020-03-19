/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import dominio.Cita;
import constantes.Constantes;
import dominio.Cliente;
import dominio.Servicioderelajacion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import negocio.IFacadadeNegocio;

/**
 *
 * @author pc
 */
public class PantallaCita extends javax.swing.JDialog {

    private static PantallaCita pantallaCita;
    private Cita cita;
    private int operacion;
    private float costoTotal;
    private Date duracion;
    private IFacadadeNegocio facadadeNegocio;
    private List<Servicioderelajacion> listaDeServicioDerelajacionDisponibles;
    private List<Servicioderelajacion> listaDeServicioDerelajacionResumen;
    private DefaultComboBoxModel<Servicioderelajacion> dcm;
    
    /**
     * Creates new form PantallaCita
     */
    private PantallaCita(java.awt.Frame parent, boolean modal, IFacadadeNegocio facadadeNegocio) {
        super(parent, modal);
        this.facadadeNegocio = facadadeNegocio;
        //Servicioderelajacion[] s = new Servicioderelajacion[this.facadadeNegocio.obtenerServiciosDeRelajacion().size()];
        
        this.dcm = new DefaultComboBoxModel<>();
        initComponents();
        this.listaDeServicioDerelajacionResumen = new ArrayList<>();
        
    }
    
    public static PantallaCita getInstancia(java.awt.Frame parent, boolean modal,IFacadadeNegocio facadadeNegocio) {
        if(pantallaCita == null) {
            pantallaCita = new PantallaCita(parent, modal, facadadeNegocio);
        }
        return pantallaCita;
    }
    
    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public int getOperacion() {
        return operacion;
    }

    public void actualizarPantalla(int operacion, Cita cita) {
        this.operacion = operacion;
        this.cita = cita;
        
        if(operacion == Constantes.AGREGAR) {
            this.jLabel_Titulo.setText("Agregar Cita");
            this.jButton_GuardarCita.setText("Guardar Cita");
        } else if (operacion == Constantes.ACTUALIZAR) {
            this.jLabel_Titulo.setText("Actualizar Cita");
            this.jButton_GuardarCita.setText("Actualizar Cita");
        } else if (operacion == Constantes.ELIMINAR) {
            this.jLabel_Titulo.setText("Eliminar Cita");
            this.jButton_GuardarCita.setText("Eliminar Cita");
            this.jPanel_DatosCita.setEnabled(false);
            this.jPanel_ResumenCita.setEnabled(false);
        }
        
        if (operacion == Constantes.ACTUALIZAR || operacion == Constantes.ELIMINAR) {
            
            this.jTextField_Nombre.setText(cita.getIdCliente().getNombre() + " " +cita.getIdCliente().getNombre());
            this.listaDeServicioDerelajacionResumen = this.cita.getServicioderelajacionList();
            this.jDateChooser_FechaCita.setDate(cita.getFecha());
            this.jSpinner_HoraCita.setValue(facadadeNegocio.obtenerHora(cita.getHora()));
            this.jSpinner_MinutosCita.setValue(facadadeNegocio.obtenerMinutos(cita.getHora()));
        }
        
        if(operacion == Constantes.ACTUALIZAR || operacion == Constantes.AGREGAR) {
            this.jPanel_DatosCita.setEnabled(true);
            this.jPanel_ResumenCita.setEnabled(true);
            this.cargarServicios();
        }
        this.cargarResumen();
        
    }
    
    public void cargarServicios() {
        Servicioderelajacion[] s = new Servicioderelajacion[this.facadadeNegocio.obtenerServiciosDeRelajacion().size()];
        this.dcm = new DefaultComboBoxModel<>(this.facadadeNegocio.obtenerServiciosDeRelajacion().toArray(s));
        this.jComboBox_Servicios.setModel(dcm);
    }
    
    public void cargarResumen() {
        String nombreColumnas [] = {"Nombre", "Duracion", "Costo"};
        String servicios[][]= new String[this.listaDeServicioDerelajacionResumen.size()][3];
        Servicioderelajacion servicioAuxiliar;
        //int saltosdeLinea = 1;
        for (int i = 0; i < this.listaDeServicioDerelajacionResumen.size(); i++) {
            servicioAuxiliar = this.listaDeServicioDerelajacionResumen.get(i);
            servicios[i][0] = servicioAuxiliar.getNombre();
            servicios[i][1] = this.facadadeNegocio.formatearHora(servicioAuxiliar.getDuracion());
            servicios[i][2] = String.valueOf(servicioAuxiliar.getCosto());
        }
        this.jTable_ResumenCita.setModel(new DefaultTableModel(servicios,nombreColumnas));
    }
    
    public void cerrarPantalla() {
        this.limpiarPantalla();
        this.setVisible(true);
    }
    
    public void limpiarPantalla() {
        this.jTextField_Nombre.setText("");
        this.jDateChooser_FechaCita.setCalendar(Calendar.getInstance());
        this.jSpinner_HoraCita.setValue(0);
        this.jSpinner_MinutosCita.setValue(0);
        this.listaDeServicioDerelajacionResumen.clear();
    }
    
    public void mostrarPantalla() {
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
        jSpinner_MinutosCita = new javax.swing.JSpinner();
        jButton_AgregarServicio = new javax.swing.JButton();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_Servicios = new javax.swing.JComboBox<Servicioderelajacion>();
        jDateChooser_FechaCita = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_HoraCita = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel_ResumenCita = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ResumenCita = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_CostoTotal = new javax.swing.JLabel();
        jLabel_TiempoDeCita = new javax.swing.JLabel();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_GuardarCita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setToolTipText("");

        jSpinner_MinutosCita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jButton_AgregarServicio.setText("+");
        jButton_AgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AgregarServicioActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Servicio:");

        jLabel4.setText("Fecha:");

        jComboBox_Servicios.setModel(dcm);

        jLabel5.setText("Hora:");

        jSpinner_HoraCita.setModel(new javax.swing.SpinnerNumberModel(1, 0, 23, 1));

        jLabel7.setText("Id:");

        jTextField1.setText("1");
        jTextField1.setEnabled(false);

        javax.swing.GroupLayout jPanel_DatosCitaLayout = new javax.swing.GroupLayout(jPanel_DatosCita);
        jPanel_DatosCita.setLayout(jPanel_DatosCitaLayout);
        jPanel_DatosCitaLayout.setHorizontalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                        .addComponent(jSpinner_HoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_MinutosCita, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                        .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_Servicios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser_FechaCita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_AgregarServicio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_DatosCitaLayout.setVerticalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Servicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton_AgregarServicio))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser_FechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_HoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_MinutosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTable_ResumenCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_ResumenCita);

        jButton1.setText("Eliminar Servicio");

        jLabel1.setText("Costo Total:");

        jLabel6.setText("Tiempo estimado de la cita:");

        javax.swing.GroupLayout jPanel_ResumenCitaLayout = new javax.swing.GroupLayout(jPanel_ResumenCita);
        jPanel_ResumenCita.setLayout(jPanel_ResumenCitaLayout);
        jPanel_ResumenCitaLayout.setHorizontalGroup(
            jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResumenCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ResumenCitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_CostoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_TiempoDeCita, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel_ResumenCitaLayout.setVerticalGroup(
            jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ResumenCitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(20, 20, 20)
                .addGroup(jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_CostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel_ResumenCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_TiempoDeCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        jButton_Cancelar.setText("Cancelar");

        jButton_GuardarCita.setText("Guardar Cita");
        jButton_GuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(jPanel_ResumenCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Cancelar)
                .addGap(120, 120, 120)
                .addComponent(jButton_GuardarCita)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_ResumenCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Cancelar)
                    .addComponent(jButton_GuardarCita))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AgregarServicioActionPerformed
        this.listaDeServicioDerelajacionResumen.add((Servicioderelajacion)this.jComboBox_Servicios.getSelectedItem());
        this.cargarResumen();
        this.costoTotal = this.facadadeNegocio.calcularCostoTotalCita(listaDeServicioDerelajacionResumen);
        this.duracion = this.facadadeNegocio.calcularDuracionCita(listaDeServicioDerelajacionResumen).getTime();
        this.jLabel_TiempoDeCita.setText(this.facadadeNegocio.formatearHora(this.duracion));
        this.jLabel_CostoTotal.setText(costoTotal+"");
    }//GEN-LAST:event_jButton_AgregarServicioActionPerformed

    private void jButton_GuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarCitaActionPerformed
        this.cita = new Cita(0);
        this.cita.setIdCliente(new Cliente(1));
        this.cita.setCostoTotal(Float.parseFloat(this.jLabel_CostoTotal.getText()));
        this.cita.setDuracion(duracion);
        this.cita.setFecha(this.jDateChooser_FechaCita.getDate());
        this.cita.setHora(this.facadadeNegocio.convertirHoras((int)this.jSpinner_HoraCita.getValue(),(int)this.jSpinner_MinutosCita.getValue()));
        this.cita.setServicioderelajacionList(listaDeServicioDerelajacionResumen);
        this.facadadeNegocio.agregarCita(cita);
    }//GEN-LAST:event_jButton_GuardarCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_AgregarServicio;
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_GuardarCita;
    private javax.swing.JComboBox<Servicioderelajacion> jComboBox_Servicios;
    private com.toedter.calendar.JDateChooser jDateChooser_FechaCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_CostoTotal;
    private javax.swing.JLabel jLabel_TiempoDeCita;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JPanel jPanel_DatosCita;
    private javax.swing.JPanel jPanel_ResumenCita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_HoraCita;
    private javax.swing.JSpinner jSpinner_MinutosCita;
    private javax.swing.JTable jTable_ResumenCita;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables
}
