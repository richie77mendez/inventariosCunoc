/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ricardo
 */
public class encargadoDialog extends javax.swing.JDialog {

    /**
     * Creates new form infoDialog
     */
    public encargadoDialog() {
        initComponents();

    }
    
    public void informacionUsuario(String nombre,String apellido,String DPI,String fechaNacimiento,
                                   String cargo,String profesion,String divisionU,String moduloTrabajo,
                                   String tipoUsuario,String usuario){
        nombreText.setText(nombre); apellidoText.setText(apellido); dpiUText.setText(DPI);
        nacimientoText.setText(fechaNacimiento); cargoText.setText(cargo); profesionText.setText(profesion);
        divisionUText.setText(divisionU); moduloUText.setText(moduloTrabajo); usuarioText.setText(usuario);
        if (tipoUsuario.equals("1")) {
            tipoText.setText("Encargado");
        }else{
            tipoText.setText("Encargado Auxiliar");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cargoText = new javax.swing.JLabel();
        apellidoText = new javax.swing.JLabel();
        nacimientoText = new javax.swing.JLabel();
        divisionUText = new javax.swing.JLabel();
        moduloUText = new javax.swing.JLabel();
        profesionText = new javax.swing.JLabel();
        tipoText = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nombreText = new javax.swing.JLabel();
        dpiUText = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        usuarioText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INFORMACION DEL BIEN");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Informacion del Encargado");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel10.setText("Cargo:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel11.setText("Apellido:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel12.setText("Fecha Nacimiento:");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel13.setText("Modulo:");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel14.setText("Division:");

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel15.setText("Profesion:");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel16.setText("Tipo:");

        cargoText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        cargoText.setText("cargo");

        apellidoText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        apellidoText.setText("apellido");

        nacimientoText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nacimientoText.setText("fecha");

        divisionUText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        divisionUText.setText("division");

        moduloUText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        moduloUText.setText("modulo");

        profesionText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        profesionText.setText("profesion");

        tipoText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        tipoText.setText("tipo");

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel17.setText("Nombre:");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel18.setText("DPI:");

        nombreText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        nombreText.setText("nombre");

        dpiUText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        dpiUText.setText("dpi");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel19.setText("Usuario:");

        usuarioText.setFont(new java.awt.Font("URW Palladio L", 1, 15)); // NOI18N
        usuarioText.setText("estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tipoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cargoText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(divisionUText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dpiUText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nacimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profesionText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moduloUText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(apellidoText)
                    .addComponent(jLabel17)
                    .addComponent(nombreText))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nacimientoText)
                    .addComponent(jLabel18)
                    .addComponent(dpiUText)
                    .addComponent(jLabel12))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cargoText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(divisionUText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tipoText))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(profesionText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(moduloUText))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(usuarioText))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoText;
    private javax.swing.JLabel cargoText;
    private javax.swing.JLabel divisionUText;
    private javax.swing.JLabel dpiUText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel moduloUText;
    private javax.swing.JLabel nacimientoText;
    private javax.swing.JLabel nombreText;
    private javax.swing.JLabel profesionText;
    private javax.swing.JLabel tipoText;
    private javax.swing.JLabel usuarioText;
    // End of variables declaration//GEN-END:variables
}
