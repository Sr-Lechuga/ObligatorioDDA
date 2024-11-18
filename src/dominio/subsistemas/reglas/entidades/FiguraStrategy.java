package dominio.subsistemas.reglas.entidades;

import java.util.List;

import dominio.subsistemas.mesas.entidades.Carta;

public interface FiguraStrategy {

  public boolean analizarMano(List<Carta> mano);

}
