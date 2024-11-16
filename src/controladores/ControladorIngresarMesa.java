package controladores;

import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Usuario;
import vistas.VistaMenuMesas;

public class ControladorIngresarMesa {

  private VistaMenuMesas vistaMenuMesa;
  private Fachada fachada;
  private Usuario usuarioEnSesion;

  public ControladorIngresarMesa(VistaMenuMesas vistaMenuMesa) {
    this.vistaMenuMesa = vistaMenuMesa;
    this.fachada = Fachada.getInstancia();
  }

  public void obtenerInfoJugador(Jugador jugador) {

    String nombreCompleto = jugador.getNombreCompleto();
    double saldoActual = jugador.getSaldo();

    vistaMenuMesa.actualizarInfoJugador(nombreCompleto, saldoActual);

  }
}
