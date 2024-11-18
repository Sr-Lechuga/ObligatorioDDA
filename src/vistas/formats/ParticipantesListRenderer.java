package vistas.formats;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class ParticipantesListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
      boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof Jugador) {
      Jugador participante = (Jugador) value;
      label.setText(participante.getNombreCompleto()
          + " - " + participante.getEstado());
    }
    return label;
  }

}
