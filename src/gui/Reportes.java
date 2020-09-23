/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import manejadores.manejadorInventario;
import manejadores.manejadorReportes;

/**
 *
 * @author ricardo
 */
public class Reportes extends javax.swing.JFrame {

     FondoPanel fondo = new FondoPanel();
      DefaultTableModel modelo = new DefaultTableModel();
     manejadorReportes repo;
     manejadorInventario manejadorInventario;
     public Reportes() {
        this.setContentPane(fondo);
        this.manejadorInventario = new manejadorInventario();
        this.repo  = new manejadorReportes();
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGerente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        trasladosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFocusable(false);
        jPanel1.setOpaque(false);

        tableGerente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tableGerente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGerenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGerente);

        jPanel2.setFocusable(false);
        jPanel2.setOpaque(false);

        trasladosButton.setText("Historial Traslados Internos");
        trasladosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trasladosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(trasladosButton)
                .addContainerGap(615, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trasladosButton)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableGerenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGerenteMouseClicked
         switch (tableGerente.getSelectedColumn()) {
             case 1:
                 {
                     int Fila = tableGerente.getSelectedRow();
                     String antiguoEncargado = tableGerente.getValueAt(Fila, 1).toString();
                     try {
                         repo.verInfoEncargado(antiguoEncargado);
                     } catch (SQLException ex) {
                         Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                     }        break;
                 }
             case 2:
                 {
                     int Fila = tableGerente.getSelectedRow();
                     String nuevoEncargado = tableGerente.getValueAt(Fila, 2).toString();
                     try {
                         repo.verInfoEncargado(nuevoEncargado);
                     } catch (SQLException ex) {
                         Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                     }        break;
                 }
             case 4:
                 {
                     int Fila = tableGerente.getSelectedRow();
                     String codigoTarjeta = tableGerente.getValueAt(Fila, 4).toString();
                     try {
                         manejadorInventario.verInfoBien(codigoTarjeta);
                     } catch (SQLException ex) {
                         Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                     }        break;
                 }
             default:
                 break;
         }
    }//GEN-LAST:event_tableGerenteMouseClicked

    private void trasladosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trasladosButtonActionPerformed
       repo.logTraslados(tableGerente, modelo);
    }//GEN-LAST:event_trasladosButtonActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGerente;
    private javax.swing.JButton trasladosButton;
    // End of variables declaration//GEN-END:variables
}
