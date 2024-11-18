package dominio.subsistemas.reglas;

import dominio.excepciones.reglas.FiguraArgumentoException;
import dominio.subsistemas.mesas.entidades.Carta;
import dominio.subsistemas.reglas.entidades.EscaleraStrategy;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.reglas.entidades.ParStrategy;
import dominio.subsistemas.reglas.entidades.PiernaStrategy;
import dominio.subsistemas.reglas.entidades.PokerStrategy;
import dominio.subsistemas.reglas.entidades.SinFiguraStrategy;
import panelCartasPoker.CartaPoker;

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

  public String analizarMano(ArrayList<Carta> cartas) {
    String figura = "";

    for (Figura unaFigura : this.figuras) {
      switch (unaFigura.getNombre()) {
        case "Poker":
          unaFigura.setEstrategia(new PokerStrategy());
          break;
        case "Escalera":
          unaFigura.setEstrategia(new EscaleraStrategy());
          break;
        case "Pierna":
          unaFigura.setEstrategia(new PiernaStrategy());
          break;
        case "Par":
          unaFigura.setEstrategia(new ParStrategy());
          break;
        default:
          unaFigura.setEstrategia(new SinFiguraStrategy());
          break;
      }
      figura = unaFigura.analizarMano(cartas);

      if (!figura.isEmpty()) {
        return figura;
      }
    }
    return "";
  }
}