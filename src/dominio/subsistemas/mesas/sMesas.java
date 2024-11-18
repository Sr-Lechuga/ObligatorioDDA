package dominio.subsistemas.mesas;

import java.util.ArrayList;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
import dominio.subsistemas.mesas.estados.EstadoMesa;
import dominio.subsistemas.usuarios.entidades.Jugador;
import java.util.concurrent.CopyOnWriteArrayList;

public class sMesas {

  ArrayList<Mesa> todasLasMesas = new ArrayList<>();

  /**
   * @param jugadoresRequeridos
   * @param apuestaBase
   * @param porcentajeComision
   * @throws ArgumentosMesaException
   */
  public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision)
      throws ArgumentosMesaException {
    Mesa mesaNueva = new Mesa(jugadoresRequeridos, apuestaBase, porcentajeComision);

    todasLasMesas.add(mesaNueva);
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
    return todasLasMesas.get(numeroMesa);
  }

  public ArrayList<Mesa> obtenerTodasLasMesas() {
    return this.todasLasMesas;
  }

  public ArrayList<Mesa> obtenerMesasAbiertas() {
    ArrayList<Mesa> mesasAbiertas = new ArrayList<>();
    for (Mesa unaMesa : todasLasMesas) {
      if (unaMesa.getEstado() == EstadoMesa.ABIERTA) {
        mesasAbiertas.add(unaMesa);
      }
    }
    return mesasAbiertas;
  }

  public ArrayList<Ronda> obtenerRondasDeMesa(Mesa mesa) {
    return mesa.getRondas();
  }

  public double obtenerRecaudacionTotal() {
    double recaudacionTotal = 0;
    for (Mesa unaMesa : todasLasMesas) {
      recaudacionTotal += unaMesa.calcularRecaudacion();
    }
    return recaudacionTotal;
  }

  public void inciarJuego(Mesa mesa) throws SaldoException {
    mesa.iniciarNuevaRonda();
  }

  public CopyOnWriteArrayList<Jugador> obtenerParticipantesDeRondaActualEnMesa(Mesa mesaActual) {
    Mesa mesaEncontrada = buscarMesa(mesaActual.getNumeroMesa());
    return mesaEncontrada.getParticipantesRondaActual();
  }

}
