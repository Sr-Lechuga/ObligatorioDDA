package controladores;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Administrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaAdministrarMesas;
import vistas.VistaCrearMesa;

public class ControladorCrearMesa implements Observador {

  private VistaCrearMesa vistaCrearMesa;
  private VistaAdministrarMesas vistaParent;
  private Administrador administradorEnSesion;
  private Fachada fachada;

  public Administrador getAdministradorEnSesion() {
    return administradorEnSesion;
  }

  public ControladorCrearMesa(VistaCrearMesa vistaCrearMesa, Administrador administradorEnSesion,
      VistaAdministrarMesas parent) {
    this.vistaParent = parent;
    this.vistaCrearMesa = vistaCrearMesa;
    this.administradorEnSesion = administradorEnSesion;

    fachada = Fachada.getInstancia();
    fachada.agregar(this); // Add Observador
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos de Interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    if (unEvento instanceof EventoMesa) {
      if (((EventoMesa) unEvento) == EventoMesa.MESA_AGREGADA) {
        vistaParent.mostrarTodasLasMesas();
      }
    }
  }
  // </editor-fold>

  public void crearMesa(Integer cantidadMaximaJugadores, Double apuestaBase, Double comision) {
    vistaCrearMesa.mostrarMensajeError("");
    try {
      fachada.crearMesa(cantidadMaximaJugadores, apuestaBase, comision);
      fachada.avisar(EventoMesa.MESA_AGREGADA);
    } catch (ArgumentosMesaException e) {
      vistaCrearMesa.mostrarMensajeError(e.getMessage());
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
}
