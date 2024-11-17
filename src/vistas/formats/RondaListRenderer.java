package vistas.formats;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import dominio.subsistemas.mesas.entidades.Ronda;

public class RondaListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
      boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof Ronda) {
      Ronda ronda = (Ronda) value;
      label.setText("[" + ronda.getNumeroRonda()
          + "] Participantes: " + ronda.getCantidadParticipantes()
          + " Total apostado: " + ronda.getPozo()
          + " Estado: " + ronda.getEstado()
          + " Nombre ganador: " + ronda.getNombreJugadorGanador()
          + " Figura ganadora: " + ronda.getNombreFiguraGanadora());
    }
    return label;
  }
}
