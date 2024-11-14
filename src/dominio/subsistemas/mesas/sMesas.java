package dominio.subsistemas.mesas;

import java.util.HashMap;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class sMesas {

  HashMap<Integer,Mesa> mesasAbiertas = new HashMap<>();

  /**
   * @param jugadoresRequeridos
   * @param apuestaBase
   * @param porcentajeComision
   * @throws ArgumentosMesaException
   */
  public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) throws ArgumentosMesaException{
    Mesa mesaNueva = new Mesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
    mesasAbiertas.put(mesaNueva.getNumeroMesa(),mesaNueva);
  }

  /**
   * 
   * @param unaMesa
   * @param unJugador
   * @throws ArgumentosMesaException
   * @throws GestionMesasException
   */
  public void agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador) throws ArgumentosMesaException, GestionMesasException{
    unaMesa.agregarParticipante(unJugador);
  }

  /**
   * 
   * @param numeroMesa
   * @return
   * @throws GestionMesasException
   */
  public double calcularRecaudacion(int numeroMesa) throws GestionMesasException{
    Mesa mesaBuscada = buscarMesa(numeroMesa);

    //TODO: Completar segun letra

    if(!(mesaBuscada instanceof Mesa)){
      throw new GestionMesasException(
        String.format("La mesa %s no esta registarda en el sistema.", numeroMesa)
      );
    }
    
    return mesaBuscada.calcularRecaudacion();
  }
  
  /**
   * 
   * @param numeroMesa
   * @return
   */
  private Mesa buscarMesa(int numeroMesa){
    return mesasAbiertas.get(numeroMesa);
  }
}
