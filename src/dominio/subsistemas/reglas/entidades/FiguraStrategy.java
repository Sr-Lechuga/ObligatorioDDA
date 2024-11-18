package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;

import dominio.subsistemas.mesas.entidades.Carta;

public interface FiguraStrategy {

  public String analizarMano(ArrayList<Carta> mano);

}
