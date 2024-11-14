package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.List;

import dominio.excepciones.usuarios.SaldoException;
import dominio.interfaces.IValidable;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Apuesta implements IValidable {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private double valor;
  private List<Jugador> apostadores;
  private Jugador creador;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Apuesta(double valor, Jugador creador) {
    this.valor = valor;
    this.creador = creador;

    this.apostadores = new ArrayList<>();
    validar();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public double getValor() {
    return valor;
  }

  public Jugador getCreador() {
    return creador;
  }

  public List<Jugador> getApostadores() {
    return apostadores;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos">
  public void agregarApostador(Jugador jugador) throws SaldoException {
    validarCantidadParticipantes();
    apostadores.add(jugador);
    jugador.removerSaldo(this.valor);
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Validaciones">
  @Override
  public void validar() {
    validarValor();
  }

  private void validarValor() {
    if (valor <= 0) {
      throw new IllegalArgumentException("El valor de la apuesta debe ser mayor a 0");
    }
  }

  private void validarCantidadParticipantes() {
    if (apostadores.size() >= 4) {
      throw new IllegalStateException("No se pueden agregar más de 4 participantes");
    }
  }
  // </editor-fold>
}