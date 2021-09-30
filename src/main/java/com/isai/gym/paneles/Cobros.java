/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isai.gym.paneles;

import com.isai.gym.clases.Huella;
import com.isai.gym.clases.OperacionesDB;
import com.isai.gym.clases.Utilerias;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author isai_
 */
public class Cobros extends javax.swing.JPanel {
    
    OperacionesDB operDB=new OperacionesDB();
    Utilerias util=new Utilerias();
    String[][] datosClientes;
    String[][] datosPaquetes;
    String idCliente,idPaquete;
    String idUsuario=""+1;
    public Huella huella;
    
    
    
    // ############################################################### //
    
    
    
    /**
     * Creates new form Cobros
     */
    public Cobros() {
        initComponents();
        llenarComboClientes();
        llenarComboPaquetes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblPlanes = new javax.swing.JLabel();
        lblCreacion = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelInvi = new javax.swing.JPanel();
        lblInvi1 = new javax.swing.JLabel();
        lblInvi2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInvi1 = new javax.swing.JTextArea();
        lblTerminacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblNombre = new javax.swing.JTextArea();
        lblDias = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jcbPaquetes = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        lblClienteR = new javax.swing.JLabel();
        lblPaqueteR = new javax.swing.JLabel();
        lblTotalR = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnCobrar = new javax.swing.JButton();
        panelMsg = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        setBackground(Color.decode(util.colorFondo)
        );
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        jPanel4.setBackground(Color.decode(util.colorFondo));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(Color.decode(util.colorFondo)
        );
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Cliente: ");
        jPanel7.add(jLabel2, new java.awt.GridBagConstraints());

        jcbClientes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jcbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientesActionPerformed(evt);
            }
        });
        jPanel7.add(jcbClientes, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setBackground(Color.decode(util.colorFondo)
        );
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(Color.decode(util.colorFondo));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 17))); // NOI18N
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        lblPlanes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblPlanes.setText("Planes activos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel9.add(lblPlanes, gridBagConstraints);

        lblCreacion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCreacion.setText("Miembro desde:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel9.add(lblCreacion, gridBagConstraints);

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(Color.decode(util.colorFondo)
        );
        jPanel14.setForeground(Color.decode(util.colorFondo)
        );
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        jLabel12.setText("Coloque dedo de cliente para Identificación");
        jPanel14.add(jLabel12, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel14, java.awt.BorderLayout.CENTER);

        lblInvi1.setText("jLabel13");

        lblInvi2.setText("jLabel14");

        txtAreaInvi1.setColumns(20);
        txtAreaInvi1.setRows(5);
        jScrollPane1.setViewportView(txtAreaInvi1);

        lblTerminacion.setText("jLabel13");

        lblNombre.setColumns(20);
        lblNombre.setRows(5);
        jScrollPane2.setViewportView(lblNombre);

        lblDias.setText("jLabel13");

        lblContador.setText("jLabel13");

        javax.swing.GroupLayout panelInviLayout = new javax.swing.GroupLayout(panelInvi);
        panelInvi.setLayout(panelInviLayout);
        panelInviLayout.setHorizontalGroup(
            panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInviLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInviLayout.createSequentialGroup()
                        .addComponent(lblInvi1)
                        .addGap(18, 18, 18)
                        .addComponent(lblInvi2))
                    .addGroup(panelInviLayout.createSequentialGroup()
                        .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDias)
                            .addGroup(panelInviLayout.createSequentialGroup()
                                .addComponent(lblContador)
                                .addGap(34, 34, 34)
                                .addComponent(lblTerminacion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelInviLayout.setVerticalGroup(
            panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInviLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInviLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelInviLayout.createSequentialGroup()
                        .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInvi1)
                            .addComponent(lblInvi2))
                        .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInviLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDias)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelInviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTerminacion)
                                    .addComponent(lblContador))
                                .addGap(23, 23, 23))
                            .addGroup(panelInviLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))))))
        );

        jPanel8.add(panelInvi, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setBackground(Color.decode(util.colorFondo)
        );
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de paquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(Color.decode(util.colorFondo));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Paquete: ");
        jPanel1.add(jLabel6, new java.awt.GridBagConstraints());

        jcbPaquetes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jcbPaquetes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaquetesActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPaquetes, new java.awt.GridBagConstraints());

        jPanel5.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(Color.decode(util.colorFondo));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 17))); // NOI18N
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Duracion: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Periodo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("Costo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jLabel9, gridBagConstraints);

        jdcInicio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jdcInicio.setMinimumSize(new java.awt.Dimension(50, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jdcInicio, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setText("Inicio de plan: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(jLabel10, gridBagConstraints);

        lblDuracion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDuracion.setText("...");
        jPanel10.add(lblDuracion, new java.awt.GridBagConstraints());

        lblPeriodo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblPeriodo.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel10.add(lblPeriodo, gridBagConstraints);

        lblCosto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCosto.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel10.add(lblCosto, gridBagConstraints);

        jPanel6.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel11.setBackground(Color.decode(util.colorFondo)
        );
        jPanel11.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(Color.decode(util.colorFondo)
        );
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(Color.decode(util.colorFondo)
        );
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jLabel1.setText("Cliente: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Paquete: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 19)); // NOI18N
        jLabel4.setText("Total: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("Importe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(jLabel5, gridBagConstraints);

        txtImporte.setColumns(10);
        txtImporte.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(txtImporte, gridBagConstraints);

        lblClienteR.setBackground(Color.decode(util.colorDark)
        );
        lblClienteR.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        lblClienteR.setForeground(Color.decode(util.colorDark)
        );
        lblClienteR.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel12.add(lblClienteR, gridBagConstraints);

        lblPaqueteR.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblPaqueteR.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel12.add(lblPaqueteR, gridBagConstraints);

        lblTotalR.setFont(new java.awt.Font("Dialog", 1, 19)); // NOI18N
        lblTotalR.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel12.add(lblTotalR, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setText("Cambio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel12.add(jLabel11, gridBagConstraints);

        txtCambio.setEditable(false);
        txtCambio.setColumns(10);
        txtCambio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel12.add(txtCambio, gridBagConstraints);

        jPanel3.add(jPanel12);

        jPanel13.setBackground(Color.decode(util.colorFondo)
        );
        jPanel13.setLayout(new java.awt.BorderLayout());

        btnCobrar.setFont(new java.awt.Font("Dialog", 1, 19)); // NOI18N
        btnCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic_32/ic_cobro.png"))); // NOI18N
        btnCobrar.setText("Cobrar");
        btnCobrar.setEnabled(false);
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        jPanel13.add(btnCobrar, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel13);

        panelMsg.setPreferredSize(new java.awt.Dimension(247, 10));

        javax.swing.GroupLayout panelMsgLayout = new javax.swing.GroupLayout(panelMsg);
        panelMsg.setLayout(panelMsgLayout);
        panelMsgLayout.setHorizontalGroup(
            panelMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        panelMsgLayout.setVerticalGroup(
            panelMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(panelMsg);

        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientesActionPerformed
        // TODO add your handling code here:
        llenarDatosClientes();
    }//GEN-LAST:event_jcbClientesActionPerformed

    private void jcbPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaquetesActionPerformed
        // TODO add your handling code here:
        llenarDatosPaquetes();
    }//GEN-LAST:event_jcbPaquetesActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        // TODO add your handling code here:
        
        if(jdcInicio.getDate()!=null){
            int conf=JOptionPane.showConfirmDialog(this, "¿Desea realizar el cobro?");
            if(conf==0){
            operacionVender();
            }
        
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha de inicio", "Error de fecha", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
        // TODO add your handling code here:
        Double importe=0.0;
         if(txtImporte.getText().isEmpty()){
            importe=0.0;
        }else{
            try{
        importe=Double.parseDouble(txtImporte.getText());
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Verifique el valor de Importe", "Error de valor", JOptionPane.WARNING_MESSAGE);
    }
      
         }
          
        
        
        
        validarCompra(importe);
    }//GEN-LAST:event_txtImporteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobrar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> jcbClientes;
    private javax.swing.JComboBox<String> jcbPaquetes;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JLabel lblClienteR;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCreacion;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblInvi1;
    private javax.swing.JLabel lblInvi2;
    private javax.swing.JTextArea lblNombre;
    private javax.swing.JLabel lblPaqueteR;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblPlanes;
    private javax.swing.JLabel lblTerminacion;
    private javax.swing.JLabel lblTotalR;
    private javax.swing.JPanel panelInvi;
    private javax.swing.JPanel panelMsg;
    private javax.swing.JTextArea txtAreaInvi1;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables


public void llenarComboClientes(){
    String[] campos={"idcliente","concat(nombre,' ',apellidos)"};
 datosClientes=operDB.datosArreglosCombos("clientes", campos);
    util.llenarCombo(jcbClientes, datosClientes);
}

public void llenarComboPaquetes(){
    String[] campos={"idpaquetes","nombre"};
 datosPaquetes=operDB.datosArreglosCombos("paquetes", campos);
    util.llenarCombo(jcbPaquetes, datosPaquetes);
}

public void llenarDatosClientes(){
    int index;
    if(jcbClientes.getSelectedIndex()>0){
        index=jcbClientes.getSelectedIndex();
    }else{
        index=0;
    }
        
        String[] datos={"Codigo",datosClientes[index][0]};
    String [] datoCliente=operDB.datosRow("vistadatosclientes", datos);
    
    String[] corte=datoCliente[4].split(" ");
    SimpleDateFormat formatoE=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoS=new SimpleDateFormat("dd/MM/yyyy");
    
    lblClienteR.setText(datoCliente[1]+" "+datoCliente[2]);
    
    idCliente=datoCliente[0];
    lblPlanes.setText("Planes Activos: "+datoCliente[5]);
        try {
            Date date=formatoE.parse(corte[0]);
            lblCreacion.setText("Miembro desde: "+formatoS.format(date));
        } catch (ParseException ex) {
            Logger.getLogger(Cobros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

public void llenarDatosPaquetes(){
    int index;
    if(jcbPaquetes.getSelectedIndex()>0){
        index=jcbPaquetes.getSelectedIndex();
    }else{
        index=0;
    }
    
    String[] dato={"idpaquetes",datosPaquetes[index][0]};
    String[] datoPaquete=operDB.datosRow("paquetes", dato);
    
    lblPaqueteR.setText(datoPaquete[1]);
    lblTotalR.setText(datoPaquete[6]);
    
    idPaquete=datoPaquete[0];
    lblDuracion.setText(datoPaquete[3]);
    lblPeriodo.setText(datoPaquete[2]);
    lblCosto.setText(datoPaquete[6]);
}

public void validarCompra( Double importe){
    Double cambio,costo=0.00;
    
    try{
        
         costo=Double.parseDouble(lblTotalR.getText());
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Verifique el valor de costo", "Error de valor", JOptionPane.WARNING_MESSAGE);
    }
   
    cambio=importe-costo;
    
    if(cambio<0){
        txtCambio.setText(""+cambio);
        txtCambio.setBackground(Color.decode(util.colorMal));
        btnCobrar.setEnabled(false);
    }else{
        txtCambio.setText(""+cambio);
        txtCambio.setBackground(Color.decode(util.colorBien));
        btnCobrar.setEnabled(true);
    }
}

    public boolean operacionVender(){
        boolean dev;
        Date hoy=new Date();
        Calendar calendar=Calendar.getInstance();
        
        calendar.setTime(hoy);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
       
        if(jdcInicio.getDate().after(calendar.getTime())){
          
            
            String[][] datos={{"clienteidcliente",idCliente},
                               {"fechaInicio",util.formatoFechaHora(jdcInicio.getDate())},
                               {"fechaFin",util.sumarFecha(jdcInicio.getDate(), lblPeriodo.getText(), Integer.parseInt(lblDuracion.getText()))},
                               {"estado","ACTIVO"},
                               {"usuariosIdUsuarios",idUsuario},
                               {"paqueteIdPaquete",idPaquete}};
            if(operDB.guardarRegresandoId(datos,"planes")>0){
                limpiarCampos();
                panelMsg.setBackground(Color.decode(util.colorBien));
                return true;
            }else{
                panelMsg.setBackground(Color.decode(util.colorMal));
                return false;
            }
            
            
            
        }else{
            JOptionPane.showMessageDialog(this, "Verifique la fecha", "Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
                    dev=false;
            panelMsg.setBackground(Color.decode(util.colorMal));
            return false;
        }
        
   
    }
    public void limpiarCampos(){
        txtImporte.setText("");
        txtCambio.setText("");
        btnCobrar.setEnabled(false);
        jcbClientes.setSelectedIndex(0);
        jcbPaquetes.setSelectedIndex(0);
    }
    
    public void valorHuella(Huella huella){
        this.huella=huella;
        iniciarSensor();
    }
    public void iniciarSensor(){
        
        huella.reclutador.clear();
        huella.stop();
        huella.start();
        huella.setLabel(lblInvi1, lblInvi2, txtAreaInvi1, panelInvi);
        huella.setBandera(true, lblNombre,lblTerminacion,lblDias,this,lblContador);
        panelInvi.setVisible(false);
        huella.ComboNombre(jcbClientes);
        
    }
    
}
