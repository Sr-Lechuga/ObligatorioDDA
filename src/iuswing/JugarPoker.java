package iuswing;

import controladores.ControladorJugarPoker;
import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.entidades.Apuesta;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPoker;
import panelCartasPoker.PanelCartasPokerException;
import vistas.VistaJugarPoker;
import vistas.formats.FigurasListRenderer;
import vistas.formats.ParticipantesListRenderer;

/**
 *
 * @author agust
 */
public class JugarPoker extends javax.swing.JFrame implements PanelCartasListener, VistaJugarPoker {

    ControladorJugarPoker controladorJugarPoker;
    private Jugador jugadorEnSesion;
    private Mesa mesa;

    public JugarPoker(Jugador jugadorEnSesion, Mesa mesa) {
        initComponents();
        mostrarMensajeAviso("");
        controladorJugarPoker = new ControladorJugarPoker(jugadorEnSesion, mesa, this);
        this.jugadorEnSesion = jugadorEnSesion;
        this.mesa = mesa;
        // Inicializar el panel de cartas de póker
        PanelCartasPoker panelCartas = new PanelCartasPoker();
        // Añadir el panel de cartas al JFrame
        add(panelCartas);

        setTitle("Mesa - " + mesa.getNumeroMesa());
        lblJugador.setText(lblJugador.getText() + " " + jugadorEnSesion.getNombreCompleto());
        lblSaldo.setText(lblSaldo.getText() + " " + jugadorEnSesion.getSaldo());
        lblMesa.setText(lblMesa.getText() + " " + mesa.getNumeroMesa());
        lblMontoBase.setText(lblMontoBase.getText() + " " + mesa.getApuestaBase());

        mostrarJugadores(mesa.getParticipantes());
        mostrarFiguras(controladorJugarPoker.obtenerFigurasDisponibles());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartas = new panelCartasPoker.PanelCartasPoker();
        lblMensaje = new javax.swing.JLabel();
        btnSeguir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listJugadores = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listFiguras = new javax.swing.JList();
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
        btnPedirCartas = new javax.swing.JButton();
        btnFinalizarPedidoCartas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMensaje.setBackground(new java.awt.Color(255, 0, 0));
        lblMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMensaje.setText("Mensaje de confirmacion");

        btnSeguir.setBackground(new java.awt.Color(204, 204, 204));
        btnSeguir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeguir.setText("Continuar jugando");
        btnSeguir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalir.setBackground(new java.awt.Color(204, 0, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Abandonar");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnPasar.setBackground(new java.awt.Color(0, 0, 153));
        btnPasar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPasar.setForeground(new java.awt.Color(255, 255, 255));
        btnPasar.setText("Pasar");
        btnPasar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnApostar.setBackground(new java.awt.Color(204, 102, 0));
        btnApostar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnApostar.setForeground(new java.awt.Color(255, 255, 255));
        btnApostar.setText("Apostar");
        btnApostar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        listJugadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listJugadores);

        listFiguras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listFiguras);

        lblJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblJugadores.setText("Jugadores");

        lblFiguras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFiguras.setText("Figuras");

        checkBoxHabilitar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxHabilitar.setSelected(true);
        checkBoxHabilitar.setText("Habilitar panel");
        checkBoxHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxHabilitarActionPerformed(evt);
            }
        });

        lblMontoBase.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMontoBase.setText("Monto base: ");

        btnPagar.setBackground(new java.awt.Color(0, 153, 0));
        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        txtApostar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblJugador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJugador.setText("Jugador: ");

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("Saldo: ");

        lblMesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMesa.setText("Mesa: ");

        lblPozoActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPozoActual.setText("Pozo actual: ");

        lblError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Error");

        lblFiguraActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFiguraActual.setText("La figura es:");

        btnPedirCartas.setBackground(new java.awt.Color(204, 204, 204));
        btnPedirCartas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPedirCartas.setText("Pedir cartas");
        btnPedirCartas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnFinalizarPedidoCartas.setBackground(new java.awt.Color(204, 204, 204));
        btnFinalizarPedidoCartas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinalizarPedidoCartas.setText("Finalizar pedido de cartas");
        btnFinalizarPedidoCartas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblJugadores)
                                .addGap(260, 260, 260)
                                .addComponent(lblFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSeguir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPedirCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinalizarPedidoCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblJugador)
                                        .addGap(172, 172, 172)
                                        .addComponent(lblSaldo)
                                        .addGap(195, 195, 195)
                                        .addComponent(lblMesa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMontoBase)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPozoActual))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFiguraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(370, 370, 370)
                                    .addComponent(checkBoxHabilitar))))
                        .addGap(179, 179, 179))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPasar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador)
                    .addComponent(lblSaldo)
                    .addComponent(lblMesa))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPozoActual, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMontoBase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(checkBoxHabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFiguraActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizarPedidoCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeguir)
                        .addComponent(btnPedirCartas)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnPasar)
                                .addGap(7, 7, 7)
                                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApostar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblJugadores)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        controladorJugarPoker.pasar();
    }//GEN-LAST:event_btnPasarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        try {
            controladorJugarPoker.pagar();
        } catch (SaldoException | ArgumentosMesaException ex) {
            lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        try {
            String cantidadTexto = txtApostar.getText();
            double cantidadApostada = Double.parseDouble(cantidadTexto);
            controladorJugarPoker.apostar(cantidadApostada);
        }catch (NumberFormatException | SaldoException | ArgumentosMesaException ex) {
            lblError.setText(ex.getMessage());
        }        
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    

    private void checkBoxHabilitarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkBoxHabilitarActionPerformed
        panelCartas.setEnabled(checkBoxHabilitar.isSelected());
    }// GEN-LAST:event_checkBoxHabilitarActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JugarPoker.class.getName()).log(
                    java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JugarPoker(null, null).setVisible(true);
            }
        });
    }

    @Override
    public void mostrarMensajeError(String mensajeError) {
        lblError.setText(mensajeError);
    }

    @Override
    public void mostrarMensajeAviso(String mensajeAviso) {
        lblMensaje.setText(mensajeAviso);
    }

    @Override
    public void mostrarJugadores(CopyOnWriteArrayList<Jugador> participantes) {

        if (participantes.isEmpty())
            mostrarMensajeError("No hay participantes para mostrar");
        else {
            mostrarMensajeError("");
            listJugadores.setListData(new Jugador[0]);
            listJugadores.setListData(participantes.toArray());
            listJugadores.setCellRenderer(new ParticipantesListRenderer());
        }
    }

    @Override
    public void mostrarFiguras(ArrayList<Figura> figurasDisponibles) {

        if (figurasDisponibles.isEmpty())
            mostrarMensajeError("No hay figuras para mostrar");
        else {
            mostrarMensajeError("");
            listFiguras.setListData(new Jugador[0]);
            listFiguras.setListData(figurasDisponibles.toArray());
            listFiguras.setCellRenderer(new FigurasListRenderer());
        }
    }

    @Override
    public void clickEnCarta(CartaPoker carta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void cargarCartas(ArrayList<CartaPoker> cartas) {
        try {
            panelCartas.cargarCartas(cartas);
        } catch (PanelCartasPokerException ex) {
            lblError.setText(ex.getMessage());
        }
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
    private javax.swing.JList listFiguras;
    private javax.swing.JList listJugadores;
    private panelCartasPoker.PanelCartasPoker panelCartas;
    private javax.swing.JTextField txtApostar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarPozoActual(String pozoRondaActual) {
        lblPozoActual
                .setText(lblPozoActual.getText() + " " + pozoRondaActual);
    }

    @Override
    public void mostrarFiguraActual(String figuraActual) {
        lblFiguraActual.setText(lblFiguraActual.getText() + " " + figuraActual);
    }

    @Override
    public void actualizarSaldo(double saldoActualizado) {
        lblSaldo.setText("Saldo: $" + saldoActualizado);
    }

    @Override
    public void actualizarPozo(String pozoActualizado) {
        lblPozoActual.setText(pozoActualizado);
    }

}
