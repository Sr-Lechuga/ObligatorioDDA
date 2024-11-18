package vistas.formats;

import dominio.subsistemas.reglas.entidades.Figura;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import dominio.subsistemas.usuarios.entidades.Jugador;

public class FigurasListRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
      boolean cellHasFocus) {
    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    if (value instanceof Figura) {
      Figura figura = (Figura) value;
      label.setText(figura.getNombre());
      label.setToolTipText(figura.getDescripcion());
      label.setHorizontalTextPosition(CENTER);
    }
    return label;
  }

}
