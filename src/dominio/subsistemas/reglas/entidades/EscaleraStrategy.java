package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;
import java.util.Collections;

import dominio.subsistemas.mesas.entidades.Carta;

public class EscaleraStrategy extends FigurasPokerStrategy implements FiguraStrategy {

  @Override
  public String analizarMano(ArrayList<Carta> mano) {

    Collections.sort(mano);

    for (int i = 1; i < mano.size(); i++) {
      if (mano.get(i - 1).getValorCarta() != mano.get(i).getValorCarta() - 1) {
        return "";
      }
    }

    return "Escalera";
  }

}
