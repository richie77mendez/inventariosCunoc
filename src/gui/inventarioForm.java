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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import main.Conectar;
import manejadores.manejadorBienes;
import manejadores.manejadorInventario;

/**
 *
 * @author ricardo
 */
public class inventarioForm extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    DefaultTableModel modelo = new DefaultTableModel();
    manejadorInventario manejadorInventario;
    manejadorBienes manejadorBien;
    public inventarioForm() {
        this.manejadorInventario = new manejadorInventario();
        this.manejadorBien = new manejadorBienes();
        this.setContentPane(fondo);
        initComponents();
        cargarDatosBien();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableGerente = new javax.swing.JTable();
        busquedaEncargadoLabel = new javax.swing.JLabel();
        busquedaEncargadoComboBox = new javax.swing.JComboBox<>();
        busquedaEncargadoText = new javax.swing.JTextField();
        filtroBienComboBox = new javax.swing.JComboBox<>();
        buscarBienButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INVENTARIO CUNOC");

        tableGerente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Unidad Academica", "Codigo Bien", "Adquisicion", "Costo", "Estado", "Cuenta", "Tarjeta R", "Tarjeta RA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableGerente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGerenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGerente);

        busquedaEncargadoLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        busquedaEncargadoLabel.setText("Busqueda por:");

        busquedaEncargadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Nombre", "Tarjeta R", "Tarjeta RA", "Estado", "Cuenta" }));
        busquedaEncargadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaEncargadoComboBoxActionPerformed(evt);
            }
        });

        busquedaEncargadoText.setEnabled(false);

        filtroBienComboBox.setEnabled(false);

        buscarBienButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        buscarBienButton.setBorder(null);
        buscarBienButton.setBorderPainted(false);
        buscarBienButton.setContentAreaFilled(false);
        buscarBienButton.setFocusPainted(false);
        buscarBienButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/searchPressed.png"))); // NOI18N
        buscarBienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBienButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busquedaEncargadoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busquedaEncargadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busquedaEncargadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtroBienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarBienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(busquedaEncargadoLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(busquedaEncargadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(busquedaEncargadoText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filtroBienComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscarBienButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableGerenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGerenteMouseClicked
        if (tableGerente.getSelectedColumn()==7) {
            int Fila = tableGerente.getSelectedRow();
            String codigoTarjeta = "A";
            codigoTarjeta += tableGerente.getValueAt(Fila, 7).toString();
            manejadorInventario.verInfo(codigoTarjeta);
        }else if(tableGerente.getSelectedColumn()==8){
            int Fila = tableGerente.getSelectedRow();
            String codigoTarjetaAux = "B";
            codigoTarjetaAux += tableGerente.getValueAt(Fila, 8).toString();
            manejadorInventario.verInfo(codigoTarjetaAux);
        }
    }//GEN-LAST:event_tableGerenteMouseClicked

    private void busquedaEncargadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaEncargadoComboBoxActionPerformed
        switch (busquedaEncargadoComboBox.getSelectedIndex()) {
            case 0:
            busquedaEncargadoText.setEnabled(false);
            filtroBienComboBox.setEnabled(false);
            break;
            case 1:
            case 2:
            case 3:
            busquedaEncargadoText.setEnabled(true);
            filtroBienComboBox.setEnabled(false);
            break;
            case 4:
            busquedaEncargadoText.setEnabled(false);
            filtroBienComboBox.setEnabled(true);
            filtroBienComboBox.removeAllItems();
            filtroBienComboBox.addItem("ACTIVO");
            filtroBienComboBox.addItem("INACTIVO");
            break;
            case 5:
            busquedaEncargadoText.setEnabled(false);
            filtroBienComboBox.setEnabled(true);
            filtroBienComboBox.removeAllItems();
            filtroBienComboBox.addItem("Mercancia");
            filtroBienComboBox.addItem("Terrenos");
            filtroBienComboBox.addItem("Edificios");
            filtroBienComboBox.addItem("Mobiliario y Equipo");
            filtroBienComboBox.addItem("Maquinaria");
            filtroBienComboBox.addItem("Papeleria y Utiles");
            filtroBienComboBox.addItem("Arquitectura");
            filtroBienComboBox.addItem("Publicidad");
            break;
            default:
            break;
        }
    }//GEN-LAST:event_busquedaEncargadoComboBoxActionPerformed

    private void buscarBienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBienButtonActionPerformed
        switch (busquedaEncargadoComboBox.getSelectedIndex()) {
            case 0:
                cargarDatosBien();
            break;
            case 1:
                manejadorBien.filtraciones(tableGerente, modelo, busquedaEncargadoComboBox.getSelectedItem().toString(), busquedaEncargadoText.getText());
                busquedaEncargadoText.setText("");
                busquedaEncargadoText.setEnabled(true);
                break;
            case 2:
                manejadorBien.filtraciones(tableGerente, modelo, "Tarjeta_codigoCorrelativo", busquedaEncargadoText.getText());
                busquedaEncargadoText.setText("");
                busquedaEncargadoText.setEnabled(true);
                break;
            case 3:
                manejadorBien.filtraciones(tableGerente, modelo, "TarjetaAuxiliar_codigoCorrelativo", busquedaEncargadoText.getText());
                busquedaEncargadoText.setText("");
                busquedaEncargadoText.setEnabled(true);
            break;
            case 4:
            case 5:
            manejadorBien.filtraciones(tableGerente, modelo, busquedaEncargadoComboBox.getSelectedItem().toString(), filtroBienComboBox.getSelectedItem().toString());
            break;
            
        }
    }//GEN-LAST:event_buscarBienButtonActionPerformed

     private void cargarDatosBien(){
    try{
            modelo = new DefaultTableModel();
            tableGerente.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conectar conn = new Conectar();
            Connection con = conn.conectarDB();
            
            String sql = "SELECT * FROM Bien";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Nombre");
            modelo.addColumn("Unidad Academica");
            modelo.addColumn("Codigo Bien");
            modelo.addColumn("Adquisicion");
            modelo.addColumn("Costo");
            modelo.addColumn("Estado");
            modelo.addColumn("Cuenta");
            modelo.addColumn("Tarjeta R");
            modelo.addColumn("Tarjeta RA");
                while(rs.next()){
                    Object[] filas  = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }
                    modelo.addRow(filas);
                }
        }catch(SQLException e){
            
        }
    }   

     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBienButton;
    private javax.swing.JComboBox<String> busquedaEncargadoComboBox;
    private javax.swing.JLabel busquedaEncargadoLabel;
    private javax.swing.JTextField busquedaEncargadoText;
    private javax.swing.JComboBox<String> filtroBienComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGerente;
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
