package iuswing;

import java.util.ArrayList;

import controladores.ControladorAdministrarMesa;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Administrador;
import vistas.VistaAdministrarMesas;
import vistas.formats.MesaListRenderer;

/**
 *
 * @author agust
 */
public class AdministrarMesas extends javax.swing.JFrame implements VistaAdministrarMesas {

  ControladorAdministrarMesa controladorAdministrarMesas;

  public AdministrarMesas(Administrador administrador) {
    initComponents();
    controladorAdministrarMesas = new ControladorAdministrarMesa(this, administrador);

    mostrarTodasLasMesas();
    mostrarRecaudacion(controladorAdministrarMesas.obtenerRecaudacionTotal());
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblMontoTotalRecaudado = new javax.swing.JLabel();
        listaMesas = new javax.swing.JList();
        btnSeleccionarMesa = new javax.swing.JButton();
        btnCrearMesa = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Bienvenido Admin");

        lblMontoTotalRecaudado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMontoTotalRecaudado.setText("Monto total recaudado: $ 999.999.00");

        listaMesas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnSeleccionarMesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeleccionarMesa.setText("Seleccionar Mesa");
        btnSeleccionarMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeleccionarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarMesaActionPerformed(evt);
            }
        });

        btnCrearMesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCrearMesa.setText("Crear nueva Mesa");
        btnCrearMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });

        lblErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("Aca va un mensaje de error");

        jLabel1.setText("Mesas del sistema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(btnSeleccionarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 141, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblMontoTotalRecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addComponent(lblMontoTotalRecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(listaMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btnSeleccionarMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSeleccionarMesaActionPerformed
    Object mesa = listaMesas.getSelectedValue();
    if (mesa instanceof Mesa) {
      MostrarRondas dialoMostrarRondas = new MostrarRondas(controladorAdministrarMesas.getAdministrador(), (Mesa) mesa);
      dialoMostrarRondas.setVisible(true);
      dialoMostrarRondas.setLocationRelativeTo(this);
    } else {
      mostrarMensajeError("Debe seleccionar una mesa");
    }
  }// GEN-LAST:event_btnSeleccionarMesaActionPerformed

  private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCrearMesaActionPerformed
    CrearMesa dialogCrearMesa = new CrearMesa(null, false, controladorAdministrarMesas.getAdministrador(), this);
    dialogCrearMesa.setVisible(true);
    dialogCrearMesa.setLocationRelativeTo(this);
  }// GEN-LAST:event_btnCrearMesaActionPerformed

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
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
          .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(AdministrarMesas.class.getName()).log(
          java.util.logging.Level.SEVERE,
          null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(AdministrarMesas.class.getName()).log(
          java.util.logging.Level.SEVERE,
          null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(AdministrarMesas.class.getName()).log(
          java.util.logging.Level.SEVERE,
          null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(AdministrarMesas.class.getName()).log(
          java.util.logging.Level.SEVERE,
          null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        Administrador admin = new Administrador("0", "0", "0");
        new AdministrarMesas(admin).setVisible(true);
      }
    });
  }

  public void mostrarRecaudacion(String recaudacion) {
    lblMontoTotalRecaudado.setText("Monto total recaudado: " + recaudacion);
  }

  @Override
  public void mostrarMensajeError(String mensajeError) {
    lblErrorMessage.setText(mensajeError);
  }

  @Override
  public void mostrarMensajeAviso(String mensajeAviso) {
    // No hay mensajes de aviso para mostrar
  }

  @SuppressWarnings("unchecked")
  @Override
  public void mostrarTodasLasMesas() {
    ArrayList<Mesa> mesasAbiertas = controladorAdministrarMesas.obtenerTodasLasMesas();

    if (mesasAbiertas.isEmpty())
      mostrarMensajeError("No hay mesas para mostrar");
    else {
      lblErrorMessage.setText("");
      listaMesas.setListData(new Mesa[0]);
      listaMesas.setListData(mesasAbiertas.toArray());
      listaMesas.setCellRenderer(new MesaListRenderer());
    }
  }

  @Override
  public void actualizarTitulo(String titulo) {
    setTitle(titulo);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JButton btnSeleccionarMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblMontoTotalRecaudado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList listaMesas;
    // End of variables declaration//GEN-END:variables
}
