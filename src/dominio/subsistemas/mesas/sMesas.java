package dominio.subsistemas.mesas;

import java.util.ArrayList;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class sMesas {

  ArrayList<Mesa> mesasAbiertas = new ArrayList<>();

  /**
   * @param jugadoresRequeridos
   * @param apuestaBase
   * @param porcentajeComision
   * @throws ArgumentosMesaException
   */
  public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision)
      throws ArgumentosMesaException {
    Mesa mesaNueva = new Mesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
    mesasAbiertas.add(mesaNueva);
  }

  /**
   * 
   * @param unaMesa
   * @param unJugador
   * @throws ArgumentosMesaException
   * @throws GestionMesasException
   * @throws SaldoException
   */
  public void agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador)
      throws ArgumentosMesaException, GestionMesasException, SaldoException {
    unaMesa.agregarParticipante(unJugador);
  }

  /**
   * 
   * @param numeroMesa
   * @return
   * @throws GestionMesasException
   */
  public double calcularRecaudacion(int numeroMesa) throws GestionMesasException {
    Mesa mesaBuscada = buscarMesa(numeroMesa);

    if (!(mesaBuscada instanceof Mesa)) {
      throw new GestionMesasException(
          String.format("La mesa %s no esta registarda en el sistema.", numeroMesa));
    }

    return mesaBuscada.calcularRecaudacion();
  }

  /**
   * 
   * @param numeroMesa
   * @return
   */
  private Mesa buscarMesa(int numeroMesa) {
    return mesasAbiertas.get(numeroMesa);
  }

  public ArrayList<Mesa> obtenerMesas() {
    return this.mesasAbiertas;
  }
}
