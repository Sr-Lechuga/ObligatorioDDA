package dominio.subsistemas.reglas.entidades;

import java.util.List;

public class SinFiguraStrategy extends FigurasPokerStrategy implements FiguraStrategy{

  @Override
  public boolean analizarMano(List<Carta> mano) {
    return true;
  }

}
