package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.mesas.estados.EstadoMesa;
import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Mesa {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private static int contadorMesas = 1;
  private int numeroMesa;
  private int jugadoresRequeridos;
  private double apuestaBase;
  private double totalApostado;
  private double porcentajeComision;
  private double pozoAcumulado;
  private Ronda rondaActual;

  private EstadoMesa estado;
  private Mazo mazo;

  private CopyOnWriteArrayList<Jugador> participantes;
  private ArrayList<Ronda> rondas;

  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Mesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) throws ArgumentosMesaException {
    this.numeroMesa = contadorMesas++;

    this.jugadoresRequeridos = jugadoresRequeridos;
    this.apuestaBase = apuestaBase;
    this.porcentajeComision = porcentajeComision;

    this.totalApostado = 0.0;
    this.pozoAcumulado = 0.0;
    this.rondaActual = null;

    this.participantes = new CopyOnWriteArrayList<>();
    this.rondas = new ArrayList<>();
    this.mazo = new Mazo();
    this.estado = EstadoMesa.ABIERTA;
    validar();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public int getNumeroMesa() {
    return numeroMesa;
  }

  public int getJugadoresRequeridos() {
    return jugadoresRequeridos;
  }

  public double getApuestaBase() {
    return apuestaBase;
  }

  public double getTotalApostado() {
    return totalApostado;
  }

  public double getPorcentajeComision() {
    return porcentajeComision;
  }

  public double getPozoAcumulado() {
    return pozoAcumulado;
  }

  public CopyOnWriteArrayList<Jugador> getParticipantes() {
    return participantes;
  }

  public ArrayList<Ronda> getRondas() {
    return rondas;
  }

  public Ronda getRondaActual() {
    return this.rondaActual;
  }

  public Mazo getMazo() {
    return mazo;
  }

  public EstadoMesa getEstado() {
    return estado;
  }

  public int getCantidadJugadores() {
    return participantes.size();
  }

  public int getNumeroRondaActual() {
    return rondas.size();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Métodos">
  public void agregarParticipante(Jugador jugador)
      throws ArgumentosMesaException, GestionMesasException, SaldoException {
    if (participantes.size() > jugadoresRequeridos) {
      throw new ArgumentosMesaException("No se pueden agregar más jugadores, la mesa está llena.");
    }
    if (this.estado != EstadoMesa.ABIERTA) {
      throw new GestionMesasException("La mesa no esta abierta para recibir jugadores.");
    }
    if (jugador.getSaldo() < this.apuestaBase * 10) {
      throw new SaldoException("Saldo insuficiente");
    }
    if (participantes.contains(jugador)) {
      throw new GestionMesasException("El participante ya esta en la mesa, no puede volver a ingresar");
    }

    participantes.add(jugador);

    if (this.participantes.size() == jugadoresRequeridos) {
      iniciarMesa();
    }
  }

  public void quitarParticipante(Jugador jugador) {
    participantes.remove(jugador);
  }

  private void iniciarMesa() throws SaldoException {
    this.estado = EstadoMesa.INICIADA;
  }

  public void iniciarNuevaRonda() throws SaldoException {
    if (this.rondas.size() > 0) {
      this.pozoAcumulado = this.rondas.get(this.rondas.size() - 1).obtenerPozoAcumulado();
    }

    this.rondaActual = new Ronda(participantes);

    rondaActual.aumentarPozo(this.pozoAcumulado);
    this.pozoAcumulado = 0;

    mazo.barajar();

    for (Jugador jugador : participantes) {
      jugador.removerSaldo(apuestaBase);
      rondaActual.aumentarPozo(apuestaBase);

      rondaActual.agregarParticipante(jugador);
      jugador.recibirCartas(mazo.repartirCartas(5));
    }

  }

  public double calcularRecaudacion() {
    return totalApostado * (porcentajeComision / 100);
  }

  public void pedirCartas(Jugador jugador, int cantidadDeCartas) {
    jugador.recibirCartas(mazo.repartirCartas(cantidadDeCartas));
  }

  public void terminarRonda() {
    this.rondas.add(rondaActual);
    rondaActual = null;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Validaciones">
  private void validar() throws ArgumentosMesaException {
    validarJugadoresRequeridos();
    validarApuestaBase();
    validarComision();
  }

  private void validarJugadoresRequeridos() throws ArgumentosMesaException {
    if (jugadoresRequeridos < 1 || jugadoresRequeridos > 5) {
      throw new ArgumentosMesaException("Cantidad de jugadores no valida");
    }
  }

  private void validarApuestaBase() throws ArgumentosMesaException {
    if (apuestaBase < 1) {
      throw new ArgumentosMesaException("Apuesta base invalida");
    }
  }

  private void validarComision() throws ArgumentosMesaException {
    if (porcentajeComision < 1 || porcentajeComision > 50) {
      throw new ArgumentosMesaException("Comision invalida");
    }
  }
  // </editor-fold>

  public CopyOnWriteArrayList<Jugador> getParticipantesRondaActual() {
    return getRondaActual().getParticipantes();
  }

  public String getPozoRondaActual() {
    return String.valueOf(getRondaActual().getPozo());
  }

  public void pasarTurno(Jugador jugadorEnSesion) {
    Ronda rondaActual = getRondaActual();
    rondaActual.pasar(jugadorEnSesion);

  }

  public EstadoRonda getEstadoRondaActual() {
    Ronda rondaActual = getRondaActual();
    return rondaActual.getEstado();
  }

}