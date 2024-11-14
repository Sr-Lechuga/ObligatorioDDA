package dominio.subsistemas.reglas.entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FigurasPokerStrategy {
  protected boolean contarNCartasDeMismoValor(List<Carta> mano, int repeticiones) {
    HashMap<Integer,Integer> conjuntos = new HashMap<>();
    
    for (Carta carta : mano) {
      conjuntos.put(carta.getValorCarta(), conjuntos.getOrDefault(carta.getValorCarta(),0) + 1);
    }

    Set<Integer> keys = conjuntos.keySet();
    for(Integer key : keys) {
      if(conjuntos.get(key) == repeticiones){
        return true;
      }
    }

    return false;
  }
}
