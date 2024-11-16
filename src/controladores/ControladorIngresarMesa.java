package controladores;

import java.util.ArrayList;

import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaMenuMesas;

public class ControladorIngresarMesa implements Observador {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private VistaMenuMesas vistaMenuMesa;
  private Fachada fachada;
  private Jugador jugadorEnSesion;
  // </editor-fold>

  public ControladorIngresarMesa(VistaMenuMesas vistaMenuMesa, Jugador jugador) {
    this.vistaMenuMesa = vistaMenuMesa;
    this.fachada = Fachada.getInstancia();
    this.jugadorEnSesion = jugador;

    fachada.agregar(this); // Add Observador
    actualizarInformacion();
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos">
  public ArrayList<Mesa> obtenerMesasDisponibles() {
    return fachada.obtenerMesas();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos privados">
  private void actualizarInformacion() {
    vistaMenuMesa.actualizarTitulo("Bienvenido " + jugadorEnSesion.getNombreCompleto());
    vistaMenuMesa.actualizarInfoJugador("Tu saldo es: $" + ((Jugador) jugadorEnSesion).getSaldo());
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }
  // </editor-fold>
}
