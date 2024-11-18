package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;

import dominio.subsistemas.mesas.entidades.Carta;

public class ParStrategy extends FigurasPokerStrategy implements FiguraStrategy {

  @Override
  public String analizarMano(ArrayList<Carta> mano) {
    if (contarNCartasDeMismoValor(mano, 2)) {
      return "Par";
    }
    return "";
  }

}
