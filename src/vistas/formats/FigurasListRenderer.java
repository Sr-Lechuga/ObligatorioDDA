package vistas.formats;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import dominio.subsistemas.mesas.entidades.Mesa;

public class MesaListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
      boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof Mesa) {
      Mesa mesa = (Mesa) value;
      label.setText("[" + mesa.getNumeroMesa()
          + "] Requeridos: " + mesa.getJugadoresRequeridos()
          + " Ciega: " + mesa.getApuestaBase()
          + " Jugadores: " + mesa.getCantidadJugadores()
          + " Ronda actual: " + mesa.getNumeroRondaActual()
          + " Total apostado: " + mesa.getTotalApostado()
          + " Comision: " + mesa.getPorcentajeComision()
          + " Recaudacion: " + mesa.calcularRecaudacion()
          + " Estado " + mesa.getEstado());
    }
    return label;
  }

}
