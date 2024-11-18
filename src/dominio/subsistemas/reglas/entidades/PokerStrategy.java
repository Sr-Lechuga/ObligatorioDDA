package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;

import dominio.subsistemas.mesas.entidades.Carta;

public class PokerStrategy extends FigurasPokerStrategy implements FiguraStrategy {

  @Override
  public String analizarMano(ArrayList<Carta> mano) {
    if (contarNCartasDeMismoValor(mano, 4)) {
      return "Poker";
    }
    return "";
  }
}
