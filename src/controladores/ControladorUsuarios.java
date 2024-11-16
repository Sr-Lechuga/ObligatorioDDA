package controladores;

import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Sesion;
import dominio.subsistemas.usuarios.estados.EstadoJugador;
import iuswing.LoginAdministrador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaIngresarAMesa;
import vistas.VistaLogin;

public class ControladorUsuarios implements Observador {
    
  private Jugador jugadorTest;
  private VistaLogin vistaLogin;
  private VistaIngresarAMesa vistaIngresarAMesa;
  private Fachada fachada = Fachada.getInstancia();

  public ControladorUsuarios(VistaLogin vistaLogin) {
    this.vistaLogin = vistaLogin;
  }

  public ControladorUsuarios(VistaIngresarAMesa vistaIngresarAMesa) {
      this.vistaIngresarAMesa = vistaIngresarAMesa;
      this.jugadorTest = new Jugador(100, "52923064", "asd", "Agustina Sanchez", EstadoJugador.APUESTA_INICIADA);
      
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

  public void obtenerInfoJugador(Jugador jugador) {
      
    String nombreCompleto = jugador.getNombreCompleto();
    double saldoActual = jugador.getSaldo();
     
    vistaIngresarAMesa.actualizarInfoJugador(nombreCompleto, saldoActual);
      
  }
}
