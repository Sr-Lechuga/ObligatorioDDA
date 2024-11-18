package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;

import dominio.subsistemas.mesas.entidades.Carta;

public class SinFiguraStrategy extends FigurasPokerStrategy implements FiguraStrategy {

  @Override
  public String analizarMano(ArrayList<Carta> mano) {
    return "Sin Figura";
  }

}
