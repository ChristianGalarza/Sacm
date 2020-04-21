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
import com.mxrck.autocompleter.*;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author pc
 */
public class PantallaCliente extends javax.swing.JDialog{

    private static PantallaCliente pantallaCliente;
    private Cliente cliente;
    private Cliente clienteRecomendador;
    private int operacion;
    private IFacadadeNegocio facadadeNegocio;
    private TextAutoCompleter textAutoCompleter;
    private Autocompletar autocompletar;
    
    /**
     * Creates new form PantallaCita
     */
    private PantallaCliente(java.awt.Frame parent, boolean modal, IFacadadeNegocio facadadeNegocio) {
        super(parent, modal);
        this.facadadeNegocio = facadadeNegocio;
        initComponents();
        
        this.autocompletar = new Autocompletar(this.jTextField4_Recomendador);
        this.textAutoCompleter = new TextAutoCompleter(jTextField4_Recomendador,this.autocompletar);
        this.textAutoCompleter.setMode(0);
        this.setLocationRelativeTo(null);
    }
    
    public static PantallaCliente getInstancia(java.awt.Frame parent, boolean modal,IFacadadeNegocio facadadeNegocio) {
        if(pantallaCliente == null) {
            pantallaCliente = new PantallaCliente(parent, modal, facadadeNegocio);
        }
        return pantallaCliente;
    }

    public void actualizarPantalla(int operacion, Cliente cliente) {
        this.operacion = operacion;
        this.cliente = cliente;
        if(operacion == Constantes.AGREGAR) {
            this.jLabel_Titulo.setText("Agregar Cliente");
            this.jButton_GuardarCliente.setText("Guardar Cliente");
        } else if (operacion == Constantes.MODIFICAR) {
            this.jLabel_Titulo.setText("Actualizar Cliente");
            this.jButton_GuardarCliente.setText("Actualizar Cliente");
            
        } else if (operacion == Constantes.ELIMINAR) {
            this.jLabel_Titulo.setText("Eliminar Cliente");
            this.jButton_GuardarCliente.setText("Eliminar Cliente");
            this.setEditableComponentes(false);
        }
        
        if (operacion == Constantes.MODIFICAR || operacion == Constantes.ELIMINAR) {
            this.jTextField_Nombre.setText(cliente.getNombre());
            this.jTextField1_Apellido.setText(cliente.getApellido());
            this.jTextField2_Correo.setText(cliente.getCorreo());
            this.jTextField3_Celular.setText(cliente.getCelular());
            this.jSpinner1_Edad.setValue(cliente.getEdad());
            if (cliente.getIdClienteRecomendador()==null) {
                this.jTextField4_Recomendador.setText("");
            }else{
                this.jTextField4_Recomendador.setText(cliente.getIdClienteRecomendador().getNombre());
            }
        }
        
        if(operacion == Constantes.MODIFICAR || operacion == Constantes.AGREGAR) {
            this.setEditableComponentes(true);
            this.cargarClientes();
        }
    }
    
    public void setEditableComponentes(boolean bln){
        this.jTextField_Nombre.setEditable(bln);
        this.jTextField2_Correo.setEditable(bln);
        this.jTextField1_Apellido.setEditable(bln);
        this.jSpinner1_Edad.setEnabled(bln);
        this.jTextField3_Celular.setEditable(bln);
        this.jTextField4_Recomendador.setEditable(bln);
    }
    
    public void cargarClientes() {
        this.textAutoCompleter.addItems(this.facadadeNegocio.obtenerClientes().toArray());
    }
    
    public void cerrarPantalla() {
        this.setVisible(false);     
    }
    
    public void limpiarPantalla() {
        this.jTextField_Nombre.setText("");
        this.textAutoCompleter.removeAllItems();        
        this.jTextField2_Correo.setText("");
        this.jTextField1_Apellido.setText("");
        this.jSpinner1_Edad.setValue(0);
        this.jTextField3_Celular.setText("");
        this.jTextField4_Recomendador.setText("");
    }
    
    public void mostrarPantalla(int operacion, Cliente cliente) {
        this.limpiarPantalla();
        this.actualizarPantalla(operacion, cliente);
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
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_Apellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSpinner1_Edad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jTextField2_Correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField3_Celular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField4_Recomendador = new javax.swing.JTextField();
        jButton_Cancelar = new javax.swing.JButton();
        jButton_GuardarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setToolTipText("");

        jTextField_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_NombreKeyPressed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel8.setText("Apellido:");

        jTextField1_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_ApellidoActionPerformed(evt);
            }
        });

        jLabel9.setText("Edad:");

        jLabel10.setText("Correo:");

        jTextField2_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2_CorreoActionPerformed(evt);
            }
        });

        jLabel11.setText("Celular:");

        jTextField3_Celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_CelularActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente Recomendador:");

        javax.swing.GroupLayout jPanel_DatosCitaLayout = new javax.swing.GroupLayout(jPanel_DatosCita);
        jPanel_DatosCita.setLayout(jPanel_DatosCitaLayout);
        jPanel_DatosCitaLayout.setHorizontalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DatosCitaLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4_Recomendador))
                    .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                        .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3_Celular)
                            .addComponent(jSpinner1_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1_Apellido)
                            .addComponent(jTextField2_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel_DatosCitaLayout.setVerticalGroup(
            jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DatosCitaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinner1_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_DatosCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4_Recomendador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Cancelar)
                        .addGap(35, 35, 35)
                        .addComponent(jButton_GuardarCliente)))
                .addGap(158, 158, 158))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 169, Short.MAX_VALUE)
                .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_DatosCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_GuardarCliente)
                    .addComponent(jButton_Cancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarClienteActionPerformed
        //VALIDAR CAMPOS
//        
        if (operacion == Constantes.AGREGAR) {
            if (this.validarCampos(Constantes.AGREGAR)) {
                if (this.mostrarMensajeDeConfirmacion("¿Desea guardar el cliente?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.cliente = new Cliente();
                    this.cliente.setNombre(this.jTextField_Nombre.getText());
                    this.cliente.setApellido(this.jTextField1_Apellido.getText());
                    this.cliente.setEdad((short)((int)this.jSpinner1_Edad.getValue()));
                    this.cliente.setCorreo(this.jTextField2_Correo.getText());
                    this.cliente.setCelular(this.jTextField3_Celular.getText());
                    if (verificarCliente(cliente)) {
                        this.facadadeNegocio.agregarCliente(cliente);
                        this.mostrarMensajeDeAdvertencia("Cliente guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (this.mostrarMensajeDeConfirmacion("Ya existe un cliente con el mismo nombre ¿Desea continuar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            this.facadadeNegocio.agregarCliente(cliente);
                            this.mostrarMensajeDeAdvertencia("Cliente guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            return;
                        }
                    }
                }
            } else {
                return;
            }
        } else if (operacion == Constantes.MODIFICAR) {
            if (this.validarCampos(Constantes.MODIFICAR)) {
                if (this.mostrarMensajeDeConfirmacion("¿Desea actualizar el cliente?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.cliente.setNombre(this.jTextField_Nombre.getText());
                    this.cliente.setApellido(this.jTextField1_Apellido.getText());
                    this.cliente.setEdad((short)this.jSpinner1_Edad.getValue());
                    this.cliente.setCorreo(this.jTextField2_Correo.getText());
                    this.cliente.setCelular(this.jTextField3_Celular.getText());
                    this.facadadeNegocio.actualizarCliente(cliente);
                }
            } else {
                return;
            }
        } else if (this.operacion == Constantes.ELIMINAR) {
            if(this.mostrarMensajeDeConfirmacion("¿Desea eliminar el cliente?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.facadadeNegocio.eliminarCliente(this.cliente.getIdCliente());
                this.mostrarMensajeDeAdvertencia("Cliente eliminada correctamente",JOptionPane.INFORMATION_MESSAGE);
            }
        }
//        
        this.cerrarPantalla();
    }//GEN-LAST:event_jButton_GuardarClienteActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        this.cerrarPantalla();
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jTextField_NombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombreKeyPressed
//        this.jTextField_Id.setText("0");
    }//GEN-LAST:event_jTextField_NombreKeyPressed

    private void jTextField1_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_ApellidoActionPerformed

    private void jTextField2_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_CorreoActionPerformed

    private void jTextField3_CelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_CelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_CelularActionPerformed

    public int mostrarMensajeDeConfirmacion(String mensaje,int tipoDeMensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }
    
    public void mostrarMensajeDeAdvertencia(String mensaje, int tipoDeMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", tipoDeMensaje);
    }
    
    public boolean validarCampos(int operacion) {
        if(this.jTextField_Nombre.getText().equals("")) {
            mostrarMensajeDeAdvertencia("Ingrese un nombre", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.jTextField1_Apellido.getText().equals("")) {
            mostrarMensajeDeAdvertencia("Ingrese un Apellido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (operacion==2) {
            if((int)((short)this.jSpinner1_Edad.getValue()) <= 0) {
            mostrarMensajeDeAdvertencia("Ingrese una edad correcta", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(operacion==1){
                if((int)this.jSpinner1_Edad.getValue() <= 0) {
                mostrarMensajeDeAdvertencia("Ingrese una edad correcta", JOptionPane.ERROR_MESSAGE);
                return false;
                }
            }
        }
        if(this.jTextField3_Celular.getText().equals("") && this.jTextField2_Correo.getText().equals("")){
            mostrarMensajeDeAdvertencia("Ingrese al menos un dato de contacto", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (this.jTextField3_Celular.getText().length()>10) {
            mostrarMensajeDeAdvertencia("Numero de al maximo 10 digitos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;   
    }
    
    public boolean verificarCliente(Cliente cliente){
        List<Cliente> listClientesAuxiliar = facadadeNegocio.obtenerClientes();
        for (Cliente clienteAux : listClientesAuxiliar) {
            if (clienteAux.getApellido().equalsIgnoreCase(cliente.getApellido())  && clienteAux.getNombre().equalsIgnoreCase(cliente.getNombre()) ) {
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JButton jButton_GuardarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JPanel jPanel_DatosCita;
    private javax.swing.JSpinner jSpinner1_Edad;
    private javax.swing.JTextField jTextField1_Apellido;
    private javax.swing.JTextField jTextField2_Correo;
    private javax.swing.JTextField jTextField3_Celular;
    private javax.swing.JTextField jTextField4_Recomendador;
    private javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables

private class Autocompletar implements AutoCompleterCallback {

        private JTextField id;
        
        public Autocompletar(JTextField id) {
            this.id = id;
        }

        @Override
        public void callback(Object o) {
            this.id.setText(((Cliente)o).getIdCliente()+"");
        }

        public JTextField getId() {
            return id;
        }

        public void setId(JTextField id) {
            this.id = id;
        }
    }
}
