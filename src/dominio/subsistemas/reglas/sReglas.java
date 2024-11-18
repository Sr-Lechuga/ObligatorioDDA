package dominio.subsistemas.reglas;

import dominio.excepciones.reglas.FiguraArgumentoException;
import dominio.subsistemas.reglas.entidades.Figura;
import java.util.ArrayList;

public class sReglas {

  private ArrayList<Figura> figuras;

  public sReglas() {
    this.figuras = new ArrayList<>();
  }

  public void agregarFigura(String nombre, String descripcion) throws FiguraArgumentoException {
    figuras.add(new Figura(nombre, descripcion));
  }

  public ArrayList<Figura> obtenerFigurasDisponibles() {
    return this.figuras;
  }
}
