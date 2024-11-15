package dominio.subsistemas.reglas.entidades;

import java.util.List;

public interface FiguraStrategy {

  public boolean analizarMano(List<Carta> mano);

}
