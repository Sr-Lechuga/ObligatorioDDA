package controladores;

import java.util.ArrayList;

import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
import dominio.subsistemas.usuarios.entidades.Administrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaMostrarRondas;

public class ControladorMostrarRondas implements Observador {

  private Fachada fachada;
  private VistaMostrarRondas vistaMostrarRondas;
  private Administrador administrador;
  private Mesa mesa;

  public Administrador getAdministrador() {
    return administrador;
  }

  public ControladorMostrarRondas(VistaMostrarRondas vistaMostrarRondas, Administrador administrador, Mesa mesa) {
    this.vistaMostrarRondas = vistaMostrarRondas;
    this.administrador = administrador;
    this.mesa = mesa;

    this.fachada = Fachada.getInstancia();
    fachada.agregar(this); // Add Observador
  }

  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }

  public void mostrarRondas() {
    ArrayList<Ronda> rondas = fachada.obtenerRondasDeMesa(this.mesa);
    if (rondas.isEmpty()) {
      vistaMostrarRondas.mostrarMensajeError("No hay rondas para mostrar");
    } else {
      vistaMostrarRondas.mostrarRondas(rondas);
    }
  }
}
