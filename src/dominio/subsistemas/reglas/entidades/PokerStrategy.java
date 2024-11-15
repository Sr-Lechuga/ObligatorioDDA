package dominio.subsistemas.reglas.entidades;

import java.util.List;

public class PokerStrategy extends FigurasPokerStrategy implements FiguraStrategy{

  @Override
  public boolean analizarMano(List<Carta> mano) {
    return contarNCartasDeMismoValor(mano, 4);
  }
}
