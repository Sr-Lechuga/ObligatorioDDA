package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;

import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.estados.EstadoJugador;

import java.util.concurrent.CopyOnWriteArrayList;

public class Ronda {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private static int contadorRondas = 1;

  private int numeroRonda;
  private double pozo;
  private EstadoRonda estado;
  private int respuestas;

  private CopyOnWriteArrayList<Jugador> participantes;
  private ArrayList<Jugador> retirados;
  private Apuesta apuesta;
  private Jugador jugadorGanador;
  private Figura figuraGanadora;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Ronda(CopyOnWriteArrayList<Jugador> participantes) {
    this.numeroRonda = contadorRondas++;
    this.pozo = 0.0;
    this.figuraGanadora = null;
    this.jugadorGanador = null;
    this.apuesta = null;

    this.estado = EstadoRonda.ESPERANDO_APUESTA;

    this.participantes = participantes;
    this.retirados = new ArrayList<>();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public int getNumeroRonda() {
    return numeroRonda;
  }

  public double getPozo() {
    return pozo;
  }

  public Figura getFiguraGanadora() {
    return figuraGanadora;
  }

  public EstadoRonda getEstado() {
    return estado;
  }

  public CopyOnWriteArrayList<Jugador> getParticipantes() {
    return participantes;
  }

  public Jugador getJugadorGanador() {
    return jugadorGanador;
  }

  public Apuesta getApuesta() {
    return apuesta;
  }

  public String getCantidadParticipantes() {
    return String.valueOf(participantes.size());
  }

  public String getNombreJugadorGanador() {
    if (jugadorGanador == null) {
      return "No hay ganador";
    }
    return jugadorGanador.getNombreCompleto().isBlank() ? "No hay ganador" : jugadorGanador.getNombreCompleto();
  }

  public String getNombreFiguraGanadora() {
    if (figuraGanadora == null) {
      return "No hay figura ganadora";
    }
    return figuraGanadora.getNombre().isBlank() ? "No hay figura ganadora" : figuraGanadora.getNombre();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Setters">
  public void setEstado(EstadoRonda estado) {
    this.estado = estado;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos publicos">
  // DEPRECTED
  public void agregarParticipante(Jugador jugador) {
    if(!participa(jugador)){
    participantes.add(jugador);
    }
  }

  public void aumentarPozo(double apuesta) {
    this.pozo += apuesta;
  }

  public double obtenerPozoAcumulado() {
    if (!hayApuesta()) {
      getPozo();
    }
    return 0;
  }

  public void iniciarApuesta(Jugador jugador, double valorApuesta) throws SaldoException {
    jugador.removerSaldo(valorApuesta);
    aumentarPozo(valorApuesta);

    this.apuesta = new Apuesta(valorApuesta, jugador);

    for (Jugador retirado : retirados) {
      retirado.setEstado(EstadoJugador.ACCION_PENDIENTE);
      participantes.add(retirado);
    }
    retirados.clear();

    setEstado(EstadoRonda.APUESTA_INICIADA);
    this.respuestas = 1;
  }

  public void pasar(Jugador jugador) {
    participantes.remove(jugador);
    retirados.addLast(jugador);

    actualizarEstadoRonda();
  }

  public void pagarApuesta(Jugador apostador) throws SaldoException {
    this.apuesta.agregarApostador(apostador);
    if (!this.apuesta.getApostadores().contains(apostador)) { 
        apostador.removerSaldo(apuesta.getValor()); 
    } 
    aumentarPozo(apuesta.getValor()); 
    this.respuestas++;
  }

  public boolean participa(Jugador jugadorEnSesion) {
    return participantes.contains(jugadorEnSesion);
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos privados">
  private boolean hayApuesta() {
    return this.apuesta != null;
  }

  private void actualizarEstadoRonda() {
    if (participantes.isEmpty()) {
      setEstado(EstadoRonda.TERMINADA);
    } else if (this.respuestas == participantes.size() + retirados.size()) {
      if (participantes.size() == 1) {
        victoria();
      } else {
        pedirCartas();
      }
    }
  }

  private void pedirCartas() {
    setEstado(EstadoRonda.PIDIENDO_CARTAS);
  }

  private void victoria() {
    setEstado(EstadoRonda.TERMINADA);
  }

  // </editor-fold>

}