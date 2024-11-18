package controladores;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import java.util.ArrayList;

import controladores.Eventos.EventoIngresarMesa;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.estados.EstadoMesa;
import dominio.subsistemas.usuarios.entidades.Jugador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaIngresarAUnaMesa;

public class ControladorIngresarMesa implements Observador {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private VistaIngresarAUnaMesa vistaIngresarAUnaMesa;
  private Fachada fachada;
  private Jugador jugadorEnSesion;
  // </editor-fold>

  public Jugador getJugadorEnSesion() {
    return jugadorEnSesion;
  }

  public ControladorIngresarMesa(VistaIngresarAUnaMesa vistaMenuMesa, Jugador jugador) {
    this.vistaIngresarAUnaMesa = vistaMenuMesa;
    this.fachada = Fachada.getInstancia();
    this.jugadorEnSesion = jugador;

    fachada.agregar(this); // Add Observador
    actualizarInformacion();
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos publicos">
  public ArrayList<Mesa> obtenerMesasAbiertas() {
    return fachada.obtenerMesasAbiertas();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos privados">
  private void actualizarInformacion() {
    vistaIngresarAUnaMesa.actualizarTitulo("Bienvenido " + jugadorEnSesion.getNombreCompleto());
    vistaIngresarAUnaMesa.actualizarInfoJugador("Tu saldo es: $" + ((Jugador) jugadorEnSesion).getSaldo());
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    if (unEvento instanceof EventoIngresarMesa) {
      // switch ((EventoIngresarMesa) unEvento) {
      // case :

      // break;

      // default:
      // break;
      // }
    }
  }
  // </editor-fold>

  public void ingresarMesa(Mesa mesaSeleccionada) {
    try {
      fachada.ingresarEnMesa(jugadorEnSesion, mesaSeleccionada);
      vistaIngresarAUnaMesa.ingresarEnMesa();
    } catch (ArgumentosMesaException | GestionMesasException | SaldoException ex) {
      vistaIngresarAUnaMesa.mostrarMensajeError(ex.getMessage());
    }
  }
}
