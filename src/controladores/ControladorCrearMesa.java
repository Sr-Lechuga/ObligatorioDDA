package controladores;

import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Administrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaCrearMesa;

public class ControladorCrearMesa implements Observador {

  private VistaCrearMesa vistaCrearMesa;
  private Administrador administradorEnSesion;
  private Fachada fachada;

  public Administrador getAdministradorEnSesion() {
    return administradorEnSesion;
  }

  public ControladorCrearMesa(VistaCrearMesa vistaCrearMesa, Administrador administradorEnSesion) {
    this.vistaCrearMesa = vistaCrearMesa;
    this.administradorEnSesion = administradorEnSesion;

    fachada = Fachada.getInstancia();
    fachada.agregar(this); // Add Observador
  }

  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }

  public void crearMesa(Integer cantidadMaximaJugadores, Double apuestaBase, Double comision) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'crearMesa'");
  }

}
