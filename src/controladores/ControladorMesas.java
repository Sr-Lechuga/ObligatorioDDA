package controladores;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Usuario;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaMesa;

public class ControladorMesas implements Observador {

  private Fachada fachada = Fachada.getInstancia();
  private VistaMesa vistaMesa;
  private Usuario usuario; // Puede ser un jugador o un administrador
  private Mesa mesa;

  public ControladorMesas(VistaMesa vistaMesa, Usuario usuario) {
    this.vistaMesa = vistaMesa;
    this.usuario = usuario;
    this.fachada.agregar(this); // Add observador
    actualizarTitulo();
  }

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
  public String crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) {
    try {
      fachada.crearMesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
      fachada.avisar("Mesa Agregada");
      return "OK";
    } catch (ArgumentosMesaException e) {
      return e.getMessage();
    }
  }

  public HashMap<Integer, Mesa> obtenerMesas() {
    return fachada.obtenerMesas();
  }

  public String agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador) {
    try {
      try {
        fachada.agregarParticipanteEnMesa(unaMesa, unJugador);
      } catch (GestionMesasException ex) {
        Logger.getLogger(ControladorMesas.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SaldoException ex) {
        Logger.getLogger(ControladorMesas.class.getName()).log(Level.SEVERE, null, ex);
      }
      fachada.avisar("Participante Agregado");
      return "OK";
    } catch (ArgumentosMesaException e) {
      return e.getMessage();
    }
  }

  public String calcularRecaudacion(int numeroMesa) {
    try {
      String recuadacion = String.valueOf(fachada.calcularRecaudacion(numeroMesa));
      fachada.avisar("Recaudacion");
      return recuadacion;
    } catch (GestionMesasException e) {
      return e.getMessage();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos de Interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }
  // </editor-fold>

  private void actualizarTitulo() {
    if (this.usuario instanceof Jugador jugador)
      vistaMesa.actualizarTitulo(jugador.getNombreCompleto() + " - " + jugador.getSaldo());
    else
      vistaMesa.actualizarTitulo(usuario.getNombreCompleto() + " - Administrar Mesas");
  }

}
