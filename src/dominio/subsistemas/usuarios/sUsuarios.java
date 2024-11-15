package dominio.subsistemas.usuarios;

import java.util.HashMap;

import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.excepciones.usuarios.UsuarioInvalidoException;
import dominio.subsistemas.usuarios.entidades.Administrador;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Sesion;
import dominio.subsistemas.usuarios.entidades.Usuario;

/**
 *
 * @author jlima
 */
public class sUsuarios {

    // <cedula,usuario>
    private HashMap<String, Administrador> administradores = new HashMap<>();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

    private HashMap<String, Sesion> logueados = new HashMap<>();

    /**
     * Agrega un nuevo administrador al sistema.
     *
     * Este método verifica si el usuario ya está registrado. Si el usuario ya
     * existe,
     * se lanza una excepción. Si no existe, se crea un nuevo objeto Administrador,
     * se valida y se agrega al sistema.
     *
     * @param cedula         La cédula del administrador que se desea agregar. Debe
     *                       ser única.
     * @param clave          La clave de acceso del administrador.
     * @param nombreCompleto El nombre completo del administrador.
     * @throws UsuarioInvalidoException Si el usuario ya está registrado en el
     *                                  sistema.
     * @throws Exception                Si ocurre un error durante la validación del
     *                                  administrador.
     */
    public void agregarAdministrador(String cedula, String clave, String nombreCompleto) throws Exception {
        if (buscarUsuario(cedula) != null) {
            throw new UsuarioInvalidoException(
                    String.format("El usuario %s ya está registrado en el sistema.", cedula));
        }
        Administrador administradorARegistrar = new Administrador(cedula, clave, nombreCompleto);
        administradorARegistrar.validar();
        administradores.put(cedula, administradorARegistrar);
    }

    /**
     * 
     * @param saldo
     * @param cedula
     * @param clave
     * @param nombreCompleto
     * @throws Exception
     */
    public void agregarJugador(double saldo, String cedula, String clave, String nombreCompleto) throws Exception {
        if (buscarUsuario(cedula) != null) {
            throw new UsuarioInvalidoException(
                    String.format("El usuario %s ya está registrado en el sistema.", cedula));
        }

        Jugador jugadorARegistrar = new Jugador(saldo, cedula, clave, nombreCompleto, null);
        jugadorARegistrar.validar();
        jugadores.put(cedula, jugadorARegistrar);
    }

    /**
     * 
     * @param cedula
     * @param clave
     * @return
     * @throws UsuarioEnSesionException
     * @throws CredencialesIncorrectasException
     */
    public Sesion loginAdministrador(String cedula, String clave)
            throws UsuarioEnSesionException, CredencialesIncorrectasException {

        Administrador administrador = buscarAdministrtrador(cedula);
        return ingresar(cedula, clave, administrador);
    }

    /**
     * 
     * @param cedula
     * @param clave
     * @return
     * @throws UsuarioEnSesionException
     * @throws CredencialesIncorrectasException
     */
    public Sesion loginJugador(String cedula, String clave)
            throws UsuarioEnSesionException, CredencialesIncorrectasException {

        Jugador jugador = buscarJugador(cedula);
        return ingresar(cedula, clave, jugador);
    }

    /**
     * 
     * @param cedula
     * @param clave
     * @param usuarioEncontrado
     * @return
     * @throws UsuarioEnSesionException
     * @throws CredencialesIncorrectasException
     */
    public Sesion ingresar(String cedula, String clave, Usuario usuarioEncontrado)
            throws UsuarioEnSesionException, CredencialesIncorrectasException {

        if (!(usuarioEncontrado instanceof Usuario)) {
            throw new CredencialesIncorrectasException("Credenciales incorrectas.");
        }

        if (!usuarioEncontrado.verificarCredenciales(cedula, clave)) {
            throw new CredencialesIncorrectasException("Credenciales incorrectas.");
        }

        if (estaUsuarioEnLinea(usuarioEncontrado)) {
            throw new UsuarioEnSesionException(
                    "Acceso denegado. El usuario ya esta esta logueado.");
        }

        Sesion sesion = new Sesion(usuarioEncontrado);
        logueados.put(cedula, sesion);
        return sesion;
    }

    /**
     * 
     * @param cedula
     * @return
     */
    public Usuario buscarUsuario(String cedula) {

        Usuario usuarioEncontrado = buscarJugador(cedula);
        if (usuarioEncontrado instanceof Usuario) {
            return usuarioEncontrado;
        }

        usuarioEncontrado = buscarAdministrtrador(cedula);

        return usuarioEncontrado;
    }

    /**
     * 
     * @param cedula
     * @return
     */
    private Administrador buscarAdministrtrador(String cedula) {
        return administradores.get(cedula);
    }

    /**
     * 
     * @param cedula
     * @return
     */
    private Jugador buscarJugador(String cedula) {
        return jugadores.get(cedula);
    }

    /**
     * 
     * @param usuarioEncontrado
     * @return
     */
    private boolean estaUsuarioEnLinea(Usuario usuarioEncontrado) {
        return logueados.get(usuarioEncontrado.getCedula()) != null;
    }

}
