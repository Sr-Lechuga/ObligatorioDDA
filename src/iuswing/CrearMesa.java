/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package iuswing;

import controladores.ControladorAdministrarMesa;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import vistas.VistaCrearMesa;

/**
 *
 * @author agust
 */
public class CrearMesa extends javax.swing.JDialog implements VistaCrearMesa {

    private ControladorAdministrarMesa controladorMesas;

    public CrearMesa(java.awt.Frame parent, boolean modal, ControladorAdministrarMesa controladorMesas) {
        super(parent, modal);
        initComponents();

        // Los inputs solo reciben numeros
        setOnlyNumberInputs();

        this.controladorMesas = controladorMesas;
        controladorMesas.setVistaCrearMesa(this);

        limpiarCampos();
    }

    private void setOnlyNumberInputs() {
        txtCantidadJugadores.setInputVerifier(new NumericInputVerifier());
        txtMontoApuestaBase.setInputVerifier(new NumericInputVerifier());
        txtComision.setInputVerifier(new NumericInputVerifier());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCrearMesa = new javax.swing.JLabel();
        lblCantidadJugadores = new javax.swing.JLabel();
        txtCantidadJugadores = new javax.swing.JTextField();
        lblMontoApuestaBase = new javax.swing.JLabel();
        txtMontoApuestaBase = new javax.swing.JTextField();
        lblPorcentajeComision = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        lblErrorMesa = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnCrearMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCrearMesa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCrearMesa.setText("Crear Mesa");

        lblCantidadJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCantidadJugadores.setText("Ingrese cantidad de jugadores:");

        txtCantidadJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblMontoApuestaBase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMontoApuestaBase.setText("Ingrese monto de la apuesta base:");

        txtMontoApuestaBase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblPorcentajeComision.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPorcentajeComision.setText("Ingrese porcentaje de comision de mesa:");

        txtComision.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblErrorMesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErrorMesa.setForeground(new java.awt.Color(255, 51, 51));

        btnLimpiar.setBackground(new java.awt.Color(102, 153, 255));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCrearMesa.setBackground(new java.awt.Color(0, 153, 0));
        btnCrearMesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrearMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearMesa.setText("Crear");
        btnCrearMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(lblCantidadJugadores,
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lblMontoApuestaBase)
                                                                        .addGap(82, 82, 82)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblPorcentajeComision)
                                                                .addGap(41, 41, 41)))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtComision, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                90, Short.MAX_VALUE)
                                                        .addComponent(txtMontoApuestaBase)
                                                        .addComponent(txtCantidadJugadores)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCrearMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(200, 200, 200)
                                                .addComponent(lblCrearMesa))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(lblErrorMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 537,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblCrearMesa)
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCantidadJugadores)
                                        .addComponent(txtCantidadJugadores, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblMontoApuestaBase)
                                        .addComponent(txtMontoApuestaBase, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPorcentajeComision)
                                        .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLimpiar)
                                        .addComponent(btnCrearMesa))
                                .addContainerGap(44, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCrearMesaActionPerformed
        crearMesa();
    }// GEN-LAST:event_btnCrearMesaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }// GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearMesa dialog = new CrearMesa(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Override
    public void crearMesa() {
        Integer cantidadMaximaJugadores = Integer.parseInt(txtCantidadJugadores.getText());
        Double comision = Double.parseDouble(txtComision.getText());
        Double apuestaBase = Double.parseDouble(txtMontoApuestaBase.getText());

        this.controladorMesas.crearMesa(cantidadMaximaJugadores, apuestaBase, comision);
        limpiarCampos();
    }

    @Override
    public void mostrarMensajeError(String mensajeError) {
        lblErrorMesa.setText(mensajeError);
    }

    @Override
    public void mostrarMensajeAviso(String mensajeAviso) {
        // nothing
    }

    public void limpiarCampos() {
        txtCantidadJugadores.setText("");
        txtComision.setText("");
        txtMontoApuestaBase.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel lblCantidadJugadores;
    private javax.swing.JLabel lblCrearMesa;
    private javax.swing.JLabel lblErrorMesa;
    private javax.swing.JLabel lblMontoApuestaBase;
    private javax.swing.JLabel lblPorcentajeComision;
    private javax.swing.JTextField txtCantidadJugadores;
    private javax.swing.JTextField txtComision;
    private javax.swing.JTextField txtMontoApuestaBase;
    // End of variables declaration//GEN-END:variables

    // Clase interna
    class NumericInputVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            if (input instanceof JTextField jTextField) {
                String text = jTextField.getText();
                if (!text.matches("\\d*")) {
                    mostrarMensajeError("El valor del campo debe ser numerico");
                    return false;
                }
            }
            return true;
        }
    }
}