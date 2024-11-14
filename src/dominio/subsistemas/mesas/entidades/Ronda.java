package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.List;

import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Ronda {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private static int contadorRondas = 1;
  private int numeroRonda;
  private double pozo;
  private EstadoRonda estado;

  private Figura figuraGanadora;
  private List<Jugador> participantes;
  private Jugador jugadorGanador;
  private Apuesta apuesta;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Ronda() {
    this.numeroRonda = contadorRondas++;
    this.pozo = 0.0;
    this.figuraGanadora = null;
    this.jugadorGanador = null;
    this.apuesta = null;

    this.estado = EstadoRonda.ESPERANDO_APUESTA;

    this.participantes = new ArrayList<>();
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

  public List<Jugador> getParticipantes() {
    return participantes;
  }

  public Jugador getJugadorGanador() {
    return jugadorGanador;
  }

  public Apuesta getApuesta() {
    return apuesta;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Setters">
  public void setEstado(EstadoRonda estado) {
    this.estado = estado;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos publicos">
  public void agregarParticipante(Jugador jugador) {
    participantes.add(jugador);
  }

  public void quitarParticipante(Jugador jugador) {
    participantes.remove(jugador);

    if (participantes.isEmpty()) {
      setEstado(EstadoRonda.TERMINADA);
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

  public void iniciarApuesta(Jugador jugador, double apuesta) throws SaldoException {
    jugador.removerSaldo(apuesta);
    aumentarPozo(apuesta);
    setEstado(EstadoRonda.APUESTA_INICIADA);
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos privados">
  private boolean hayApuesta() {
    return this.apuesta != null;
  }
  // </editor-fold>

}