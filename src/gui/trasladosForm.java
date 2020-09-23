/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import main.Conectar;
import manejadores.manejadorInventario;

/**
 *
 * @author ricardo
 */
public class trasladosForm extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloAux = new DefaultTableModel();
    manejadorInventario manejadorInventario;
    
    public trasladosForm() {
        this.manejadorInventario = new manejadorInventario();
        this.setContentPane(fondo);
        initComponents();
        cargarDatosTarjeta();
        cargarDatosTarjetaAux();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTarjeta = new javax.swing.JTable();
        panelTarjeta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dpiLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        nombreNuevoLabel = new javax.swing.JLabel();
        dpiNuevoText = new javax.swing.JTextField();
        buscarEncargadoButton2 = new javax.swing.JButton();
        trasladoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTarjetaAux = new javax.swing.JTable();
        panelTarjetaAux = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dpiAuxLabel = new javax.swing.JLabel();
        nombreAuxLabel = new javax.swing.JLabel();
        nombreNuevoLabel1 = new javax.swing.JLabel();
        dpiNuevoAuxText = new javax.swing.JTextField();
        buscarEncargadoAuxButton = new javax.swing.JButton();
        trasladoAuxButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INVENTARIO CUNOC");

        tableTarjeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DPI", "Codigo Tarjeta", "Divison", "Modulo", "Salon", "Fecha Impresion", "Estado", "Bien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTarjetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTarjeta);

        panelTarjeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTarjeta.setFocusable(false);
        panelTarjeta.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Traslado de Tarjetas");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("DPI:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Datos Actuales");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Datos Nuevos");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("DPI:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Nombre:");

        dpiLabel.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        dpiLabel.setForeground(new java.awt.Color(254, 254, 254));

        nombreLabel.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(254, 254, 254));

        nombreNuevoLabel.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nombreNuevoLabel.setForeground(new java.awt.Color(254, 254, 254));

        dpiNuevoText.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        buscarEncargadoButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        buscarEncargadoButton2.setBorder(null);
        buscarEncargadoButton2.setBorderPainted(false);
        buscarEncargadoButton2.setContentAreaFilled(false);
        buscarEncargadoButton2.setFocusPainted(false);
        buscarEncargadoButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchPressed.png"))); // NOI18N
        buscarEncargadoButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEncargadoButton2ActionPerformed(evt);
            }
        });

        trasladoButton.setText("Realizar Traslado");
        trasladoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trasladoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTarjetaLayout = new javax.swing.GroupLayout(panelTarjeta);
        panelTarjeta.setLayout(panelTarjetaLayout);
        panelTarjetaLayout.setHorizontalGroup(
            panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarjetaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(trasladoButton)
                .addGap(49, 49, 49))
            .addGroup(panelTarjetaLayout.createSequentialGroup()
                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(panelTarjetaLayout.createSequentialGroup()
                                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreNuevoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpiNuevoText))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarEncargadoButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTarjetaLayout.setVerticalGroup(
            panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTarjetaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dpiNuevoText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarjetaLayout.createSequentialGroup()
                        .addComponent(buscarEncargadoButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreNuevoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(trasladoButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tableTarjetaAux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DPI", "Codigo Tarjeta", "Divison", "Modulo", "Salon", "Fecha Impresion", "Estado", "Bien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTarjetaAux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTarjetaAuxMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTarjetaAux);

        panelTarjetaAux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTarjetaAux.setFocusable(false);
        panelTarjetaAux.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Traslado de Tarjetas Aux");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("DPI:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Nombre:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Datos Actuales");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Datos Nuevos");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("DPI:");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setText("Nombre:");

        dpiAuxLabel.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        dpiAuxLabel.setForeground(new java.awt.Color(254, 254, 254));

        nombreAuxLabel.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nombreAuxLabel.setForeground(new java.awt.Color(254, 254, 254));

        nombreNuevoLabel1.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nombreNuevoLabel1.setForeground(new java.awt.Color(254, 254, 254));

        dpiNuevoAuxText.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        buscarEncargadoAuxButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        buscarEncargadoAuxButton.setBorder(null);
        buscarEncargadoAuxButton.setBorderPainted(false);
        buscarEncargadoAuxButton.setContentAreaFilled(false);
        buscarEncargadoAuxButton.setFocusPainted(false);
        buscarEncargadoAuxButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchPressed.png"))); // NOI18N
        buscarEncargadoAuxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEncargadoAuxButtonActionPerformed(evt);
            }
        });

        trasladoAuxButton.setText("Realizar Traslado");
        trasladoAuxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trasladoAuxButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTarjetaAuxLayout = new javax.swing.GroupLayout(panelTarjetaAux);
        panelTarjetaAux.setLayout(panelTarjetaAuxLayout);
        panelTarjetaAuxLayout.setHorizontalGroup(
            panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9))
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpiAuxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreAuxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreNuevoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpiNuevoAuxText))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarEncargadoAuxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarjetaAuxLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(trasladoAuxButton)
                .addGap(46, 46, 46))
        );
        panelTarjetaAuxLayout.setVerticalGroup(
            panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpiAuxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreAuxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTarjetaAuxLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(dpiNuevoAuxText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarjetaAuxLayout.createSequentialGroup()
                        .addComponent(buscarEncargadoAuxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelTarjetaAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreNuevoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trasladoAuxButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTarjetaAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTarjetaAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTarjetaMouseClicked
        if (tableTarjeta.getSelectedColumn()==0) {
            int Fila = tableTarjeta.getSelectedRow();
            String DPI = tableTarjeta.getValueAt(Fila, 0).toString();
            try {
                manejadorInventario.verInfoEncargado(DPI);
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(tableTarjeta.getSelectedColumn()==1){
            int Fila = tableTarjeta.getSelectedRow();
            String codigoTarjetas = tableTarjeta.getValueAt(Fila, 1).toString();
            try {
                manejadorInventario.verInfoBien(codigoTarjetas);
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableTarjetaMouseClicked

    private void tableTarjetaAuxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTarjetaAuxMouseClicked
        if (tableTarjetaAux.getSelectedColumn()==0) {
            int Fila = tableTarjetaAux.getSelectedRow();
            String DPI = tableTarjetaAux.getValueAt(Fila, 0).toString();
            try {
                manejadorInventario.verInfoEncargado(DPI);
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(tableTarjetaAux.getSelectedColumn()==1){
            int Fila = tableTarjetaAux.getSelectedRow();
            String codigoTarjetaAux = tableTarjetaAux.getValueAt(Fila, 1).toString();
            try {
                manejadorInventario.verInfoBien(codigoTarjetaAux);
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableTarjetaAuxMouseClicked

    private void buscarEncargadoButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEncargadoButton2ActionPerformed
        try {
            manejadorInventario.buscarEncargado(dpiNuevoText.getText());
        } catch (SQLException ex) {
           
        }
    }//GEN-LAST:event_buscarEncargadoButton2ActionPerformed

    private void buscarEncargadoAuxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEncargadoAuxButtonActionPerformed
        try {
            manejadorInventario.buscarEncargadoAux(dpiNuevoAuxText.getText());
        } catch (SQLException ex) {
           
        }
    }//GEN-LAST:event_buscarEncargadoAuxButtonActionPerformed

    private void trasladoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trasladoButtonActionPerformed
        if (dpiLabel.getText().isEmpty() || nombreLabel.getText().isEmpty() || 
            dpiNuevoText.getText().isEmpty() || nombreNuevoLabel.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Datos inconsistentes, porfavor verifique los datos.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                int Fila = tableTarjeta.getSelectedRow();
                String codigoTarjetas = tableTarjeta.getValueAt(Fila, 1).toString();
                manejadorInventario.trasladoEncargado(dpiLabel.getText(),dpiNuevoText.getText(),codigoTarjetas,1);
                cargarDatosTarjeta();
                limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_trasladoButtonActionPerformed

    private void trasladoAuxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trasladoAuxButtonActionPerformed
        if (dpiAuxLabel.getText().isEmpty() || nombreAuxLabel.getText().isEmpty() || 
            dpiNuevoAuxText.getText().isEmpty() || nombreNuevoLabel1.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Datos inconsistentes, porfavor verifique los datos.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                int Fila = tableTarjetaAux.getSelectedRow();
                String codigoTarjetas = tableTarjetaAux.getValueAt(Fila, 1).toString();
                manejadorInventario.trasladoEncargado(dpiAuxLabel.getText(),dpiNuevoAuxText.getText(),codigoTarjetas,2);
                cargarDatosTarjetaAux();
                limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(trasladosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_trasladoAuxButtonActionPerformed

     private void cargarDatosTarjeta(){
    try{
            modelo = new DefaultTableModel();
            tableTarjeta.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conectar conn = new Conectar();
            Connection con = conn.conectarDB();
            
            String sql = "SELECT * FROM Tarjeta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("DPI");
            modelo.addColumn("Codigo Tarjeta");
            modelo.addColumn("Divison");
            modelo.addColumn("Modulo");
            modelo.addColumn("Salon");
            modelo.addColumn("Fecha Impresion");
            modelo.addColumn("Estado");
                while(rs.next()){
                    Object[] filas  = new Object[cantidadColumnas+1];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }
                    modelo.addRow(filas);
                }
                
             
           
        }catch(SQLException e){
            
        }
    }   

     private void cargarDatosTarjetaAux(){
    try{
            modeloAux = new DefaultTableModel();
            tableTarjetaAux.setModel(modeloAux);
            
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conectar conn = new Conectar();
            Connection con = conn.conectarDB();
            
            String sql = "SELECT * FROM TarjetaAuxiliar";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modeloAux.addColumn("DPI");
            modeloAux.addColumn("Codigo Tarjeta");
            modeloAux.addColumn("Divison");
            modeloAux.addColumn("Modulo");
            modeloAux.addColumn("Salon");
            modeloAux.addColumn("Fecha Impresion");
            modeloAux.addColumn("Estado");
                while(rs.next()){
                    Object[] filas  = new Object[cantidadColumnas+1];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }
                    modeloAux.addRow(filas);
                }
                
             
           
        }catch(SQLException e){
            
        }
    } 
     
     private void limpiar(){
         dpiLabel.setText("");
         nombreLabel.setText("");
         dpiNuevoText.setText("");
         nombreNuevoLabel.setText("");
         
         dpiAuxLabel.setText("");
         nombreAuxLabel.setText("");
         dpiNuevoAuxText.setText("");
         nombreNuevoLabel1.setText("");
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarEncargadoAuxButton;
    private javax.swing.JButton buscarEncargadoButton2;
    public static javax.swing.JLabel dpiAuxLabel;
    public static javax.swing.JLabel dpiLabel;
    public static javax.swing.JTextField dpiNuevoAuxText;
    public static javax.swing.JTextField dpiNuevoText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel nombreAuxLabel;
    public static javax.swing.JLabel nombreLabel;
    public static javax.swing.JLabel nombreNuevoLabel;
    public static javax.swing.JLabel nombreNuevoLabel1;
    private javax.swing.JPanel panelTarjeta;
    private javax.swing.JPanel panelTarjetaAux;
    private javax.swing.JTable tableTarjeta;
    private javax.swing.JTable tableTarjetaAux;
    private javax.swing.JButton trasladoAuxButton;
    private javax.swing.JButton trasladoButton;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Images/fondoGeneral.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}
