package controladores;

import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Sesion;
import iuswing.LoginAdministrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaLogin;

public class ControladorUsuarios implements Observador {
  private VistaLogin vistaLogin;
  private Fachada fachada = Fachada.getInstancia();

  public ControladorUsuarios(VistaLogin vistaLogin) {
    this.vistaLogin = vistaLogin;
  }

  public void ingresarSistema(String cedula, String clave) {
    try {
      Sesion sesion;
      if (this.vistaLogin instanceof LoginAdministrador)
        sesion = fachada.loginAdministrador(cedula, clave);
      else
        sesion = fachada.loginJugador(cedula, clave);

      vistaLogin.mostrarProximaInterfaz(sesion.getUsuario());
    } catch (UsuarioEnSesionException | CredencialesIncorrectasException e) {
      vistaLogin.mostrarMensajeError(e.getMessage());
    }
  }

  @Override
  public void actualizar(Observable unObservable, Object unEvento) {
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }

}
