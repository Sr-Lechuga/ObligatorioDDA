package controladores;

import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.usuarios.entidades.Administrador;

import java.util.ArrayList;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaAdministrarMesas;

public class ControladorAdministrarMesa implements Observador {

  private Fachada fachada;
  private VistaAdministrarMesas vistaAdministrarMesa;
  private Administrador administradorEnSesion; // Un administrador

  // <editor-fold defaultstate="collapsed" desc="Getters">

  public Administrador getAdministrador() {
    return this.administradorEnSesion;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructor">
  public ControladorAdministrarMesa(VistaAdministrarMesas vistaAdministrarMesa, Administrador administradorEnSesion) {
    this.fachada = Fachada.getInstancia();
    this.vistaAdministrarMesa = vistaAdministrarMesa;
    this.administradorEnSesion = administradorEnSesion;

    this.fachada.agregar(this); // Add observador
    actualizarTitulo();
  }
  // </editor-fold>

  public ArrayList<Mesa> obtenerTodasLasMesas() {
    return fachada.obtenerTodasLasMesas();
  }

  // <editor-fold defaultstate="collapsed" desc="Metodos de Interfaz">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    if (unEvento.equals(EventoMesa.MESA_AGREGADA)) {
      vistaAdministrarMesa.mostrarTodasLasMesas();
    }
  }
  // </editor-fold>

  private void actualizarTitulo() {
    vistaAdministrarMesa.actualizarTitulo(administradorEnSesion.getNombreCompleto() + " - Administrar Mesas");
  }

}
