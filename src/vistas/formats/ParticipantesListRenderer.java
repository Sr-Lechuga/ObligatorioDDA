package vistas.formats;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.estados.EstadoJugador;

public class ParticipantesListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
      boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof Jugador) {
      Jugador participante = (Jugador) value;
      label.setText(participante.getNombreCompleto() + " - ");
        switch (participante.getEstado()) {
            case EstadoJugador.ACCION_PENDIENTE:
                label.setText(label.getText() + "(Pendiente)");
                break;
            case EstadoJugador.APUESTA_INICIADA:
                label.setText(label.getText() + "(Aposto)");
                break;
            case EstadoJugador.APUESTA_PAGADA:
                label.setText(label.getText() + "(Pago)");
                break;
            case EstadoJugador.NO_PAGO_LA_APUESTA:
                label.setText(label.getText() + "(Se retiro)");
                break;
            default:
                throw new AssertionError();
        }
      label.setHorizontalAlignment(JLabel.CENTER);
    }

    return label;
  }

}
