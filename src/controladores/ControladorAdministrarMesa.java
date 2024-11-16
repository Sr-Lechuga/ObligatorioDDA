package controladores;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Usuario;

import java.util.ArrayList;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaCrearMesa;
import vistas.VistaMesa;

public class ControladorAdministrarMesa implements Observador {

  private Fachada fachada;
  private VistaMesa vistaMesa;
  private VistaCrearMesa vistaCrearMesa;
  private Usuario usuario; // Puede ser un jugador o un administrador

  // <editor-fold defaultstate="collapsed" desc="Setters">
  public void setVistaMesa(VistaMesa vistaMesa) {
    this.vistaMesa = vistaMesa;
  }

  public void setVistaCrearMesa(VistaCrearMesa vistaCrearMesa) {
    this.vistaCrearMesa = vistaCrearMesa;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructor">
  public ControladorAdministrarMesa(VistaMesa vistaMesa, Usuario usuarioEnSesion) {
    this.fachada = Fachada.getInstancia();
    this.vistaMesa = vistaMesa;
    this.usuario = usuarioEnSesion;

    this.fachada.agregar(this); // Add observador
    actualizarTitulo();
  }
  // </editor-fold>

  /**
   * Crea una nueva mesa de juego con los parámetros especificados.
   *
   * @param jugadoresRequeridos el número de jugadores que se requieren para
   *                            iniciar la mesa.
   * @param apuestaBase         la cantidad mínima de dinero que se puede apostar
   *                            en la mesa.
   * @param porcentajeComision  el porcentaje de comisión que se aplicará a las
   *                            apuestas realizadas en la mesa.
   * @return un mensaje que indica el resultado de la operación. Retorna "OK" si
   *         la mesa se creó exitosamente,
   *         o un mensaje de error si ocurrió un problema al intentar crear la
   *         mesa.
   * @throws ArgumentosMesaException si alguno de los argumentos proporcionados es
   *                                 inválido.
   */
  public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) {
    vistaCrearMesa.mostrarMensajeError("");
    try {
      fachada.crearMesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
      fachada.avisar(EventoMesa.MESA_AGREGADA);
    } catch (ArgumentosMesaException e) {
      vistaCrearMesa.mostrarMensajeError(e.getMessage());
    }
  }

  public ArrayList<Mesa> obtenerMesas() {
    return fachada.obtenerMesas();
  }

  public void agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador) {
    vistaCrearMesa.mostrarMensajeError("");
    try {
      fachada.agregarParticipanteEnMesa(unaMesa, unJugador);
      fachada.avisar(EventoMesa.PARTICIPANTE_AGREGADO);
    } catch (GestionMesasException | SaldoException | ArgumentosMesaException ex) {
      vistaCrearMesa.mostrarMensajeError(ex.getMessage());
    }
  }

  public void calcularRecaudacion(int numeroMesa) {
    vistaCrearMesa.mostrarMensajeError("");
    try {
      String recaudacion = String.valueOf(fachada.calcularRecaudacion(numeroMesa));
      vistaCrearMesa.mostrarMensajeError(recaudacion);
    } catch (GestionMesasException e) {
      vistaCrearMesa.mostrarMensajeError(e.getMessage());
    }
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos de Interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    if (unEvento.equals(EventoMesa.MESA_AGREGADA)) {
      vistaMesa.mostrarMesas();
    }
  }
  // </editor-fold>

  private void actualizarTitulo() {
    if (this.usuario instanceof Jugador jugador)
      vistaMesa.actualizarTitulo(jugador.getNombreCompleto() + " - " + jugador.getSaldo());
    else
      vistaMesa.actualizarTitulo(usuario.getNombreCompleto() + " - Administrar Mesas");
  }
}
