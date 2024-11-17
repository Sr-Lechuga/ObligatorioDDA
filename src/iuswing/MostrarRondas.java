/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuswing;

import java.util.ArrayList;

import controladores.ControladorMostrarRondas;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
import dominio.subsistemas.usuarios.entidades.Administrador;
import vistas.VistaMostrarRondas;
import vistas.formats.MesaListRenderer;
import vistas.formats.RondaListRenderer;

/**
 *
 * @author agust
 */
public class MostrarRondas extends javax.swing.JFrame implements VistaMostrarRondas {

  ControladorMostrarRondas controladorMostrarRondas;

  /**
   * Creates new form MostrarRondas
   */
  public MostrarRondas(Administrador administradorEnSesion, Mesa mesaSeleccionada) {
    initComponents();
    controladorMostrarRondas = new ControladorMostrarRondas(this, administradorEnSesion, mesaSeleccionada);
    controladorMostrarRondas.mostrarRondas();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblManosJugadas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listInfoRondas = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblManosJugadas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblManosJugadas.setText("Lista de rondas/manos jugadas:");

        jScrollPane1.setViewportView(listInfoRondas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManosJugadas))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblManosJugadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
      java.util.logging.Logger.getLogger(MostrarRondas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MostrarRondas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MostrarRondas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MostrarRondas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MostrarRondas(null, null).setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManosJugadas;
    private javax.swing.JList listInfoRondas;
    // End of variables declaration//GEN-END:variables

  @Override
  public void mostrarMensajeError(String mensajeError) {
    // nothing
  }

  @Override
  public void mostrarMensajeAviso(String mensajeAviso) {
    // nothing
  }

  @Override
  public void mostrarRondas(ArrayList<Ronda> rondas) {

    if (rondas.isEmpty())
      mostrarMensajeError("No hay mesas para mostrar");
    else {
      listInfoRondas.setListData(new Mesa[0]);
      listInfoRondas.setListData(rondas.toArray());
      listInfoRondas.setCellRenderer(new RondaListRenderer());
    }
  }

}
