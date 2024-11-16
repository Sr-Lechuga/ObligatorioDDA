package controladores;

import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Administrador;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Sesion;
import dominio.subsistemas.usuarios.entidades.Usuario;
import iuswing.LoginAdministrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaLogin;

public class ControladorAcceso implements Observador {

  private VistaLogin vistaLogin;
  private Fachada fachada = Fachada.getInstancia();
  private Usuario usuarioEnSesion;

  public ControladorAcceso(VistaLogin vistaLogin) {
    this.vistaLogin = vistaLogin;
  }

  public void ingresarSistema(String cedula, String clave) {
    try {
      Sesion sesion;
      if (this.vistaLogin instanceof LoginAdministrador)
        sesion = fachada.loginAdministrador(cedula, clave);
      else
        sesion = fachada.loginJugador(cedula, clave);

      usuarioEnSesion = sesion.getUsuario();
      vistaLogin.mostrarProximaInterfaz(sesion.getUsuario());
    } catch (UsuarioEnSesionException | CredencialesIncorrectasException e) {
      vistaLogin.mostrarMensajeError(e.getMessage());
    }
  }

  // <editor-fold defaultstate="collapsed" desc="Metodo de Observador">
  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    if (usuarioEnSesion instanceof Jugador) {
      throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }
    if (usuarioEnSesion instanceof Administrador) {
      throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }
  }
  // </editor-fold>
}
