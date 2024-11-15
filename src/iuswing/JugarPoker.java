/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuswing;

import panelCartasPoker.PanelCartasPoker;
import vistas.VistaPoker;

/**
 *
 * @author agust
 */
public class JugarPoker extends javax.swing.JFrame implements VistaPoker {

    /**
     * Creates new form JugarPoker
     */
    public JugarPoker() {
        initComponents();
        // Inicializar el panel de cartas de póker
        PanelCartasPoker panelCartas = new PanelCartasPoker();
        // Añadir el panel de cartas al JFrame
        add(panelCartas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartasPoker1 = new panelCartasPoker.PanelCartasPoker();
        lblMensaje = new javax.swing.JLabel();
        btnSeguir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listJugadores = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFiguras = new javax.swing.JList<>();
        lblJugadores = new javax.swing.JLabel();
        lblFiguras = new javax.swing.JLabel();
        checkBoxHabilitar = new javax.swing.JCheckBox();
        lblMontoBase = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        txtApostar = new javax.swing.JTextField();
        lblJugador = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        lblPozoActual = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblFiguraActual = new javax.swing.JLabel();
        txtPagar = new javax.swing.JTextField();
        lblCartasNuevas = new javax.swing.JLabel();
        btnPedirCartas = new javax.swing.JButton();
        btnFinalizarPedidoCartas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSeguir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeguir.setText("Continuar jugando");
        btnSeguir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalir.setText("Abandonar");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPasar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPasar.setText("Pasar");
        btnPasar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnApostar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnApostar.setText("Apostar");
        btnApostar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setViewportView(listJugadores);

        jScrollPane2.setViewportView(listFiguras);

        lblJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblJugadores.setText("Jugadores:");

        lblFiguras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFiguras.setText("Figuras:");

        checkBoxHabilitar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxHabilitar.setSelected(true);
        checkBoxHabilitar.setText("Habilitar panel");

        lblMontoBase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMontoBase.setText("Monto base: ");

        btnPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtApostar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblJugador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJugador.setText("Jugador: ");

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("Saldo: ");

        lblMesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMesa.setText("Mesa: ");

        lblPozoActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPozoActual.setText("Pozo actual: ");

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));

        lblFiguraActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFiguraActual.setText("La figura es:");

        txtPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblCartasNuevas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnPedirCartas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPedirCartas.setText("Pedir cartas");
        btnPedirCartas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnFinalizarPedidoCartas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinalizarPedidoCartas.setText("Finalizar pedido de cartas");
        btnFinalizarPedidoCartas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblFiguras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPasar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApostar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPagar)
                                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJugador)
                                    .addComponent(lblMesa)
                                    .addComponent(lblSaldo))
                                .addGap(146, 146, 146)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCartasNuevas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(panelCartasPoker1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPedirCartas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSeguir, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(checkBoxHabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnFinalizarPedidoCartas))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMontoBase)
                            .addComponent(lblPozoActual)
                            .addComponent(lblFiguraActual))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblJugador)
                        .addGap(18, 18, 18)
                        .addComponent(lblSaldo)
                        .addGap(18, 18, 18)
                        .addComponent(lblMesa)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCartasPoker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCartasNuevas, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeguir)
                    .addComponent(checkBoxHabilitar)
                    .addComponent(lblFiguraActual))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMontoBase)
                    .addComponent(btnPedirCartas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPozoActual)
                    .addComponent(btnFinalizarPedidoCartas))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugadores)
                    .addComponent(lblFiguras))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPasar)
                                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JugarPoker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnFinalizarPedidoCartas;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnPedirCartas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JCheckBox checkBoxHabilitar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCartasNuevas;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFiguraActual;
    private javax.swing.JLabel lblFiguras;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblJugadores;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblMontoBase;
    private javax.swing.JLabel lblPozoActual;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JList<String> listFiguras;
    private javax.swing.JList<String> listJugadores;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker1;
    private javax.swing.JTextField txtApostar;
    private javax.swing.JTextField txtPagar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMensajeError(String mensajeError) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMensajeAviso(String mensajeAviso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarFiguras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
