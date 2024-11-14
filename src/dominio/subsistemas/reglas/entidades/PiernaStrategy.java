package dominio.subsistemas.reglas.entidades;

import java.util.List;

public class PiernaStrategy implements FiguraStrategy{

  @Override
  public boolean analizarMano(List<Carta> mano) {
    throw new UnsupportedOperationException("Unimplemented method 'analizarMano'");
  }

}
