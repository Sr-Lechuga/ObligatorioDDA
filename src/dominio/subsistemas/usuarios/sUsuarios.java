package dominio.subsistemas.usuarios;

import java.util.HashMap;

import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.excepciones.usuarios.UsuarioInvalidoException;
import dominio.excepciones.usuarios.UsuarioNoRegistradoException;
import dominio.subsistemas.usuarios.entidades.Administrador;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Usuario;

/**
 *
 * @author jlima
 */
public class sUsuarios {

    //<cedula,usuario>
    private HashMap<String, Administrador> administradores = new HashMap<>();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

    /**
     * Agrega un nuevo administrador al sistema.
     *
     * Este método verifica si el usuario ya está registrado. Si el usuario ya existe,
     * se lanza una excepción. Si no existe, se crea un nuevo objeto Administrador,
     * se valida y se agrega al sistema.
     *
     * @param cedula La cédula del administrador que se desea agregar. Debe ser única.
     * @param clave La clave de acceso del administrador.
     * @param nombreCompleto El nombre completo del administrador.
     * @throws UsuarioInvalidoException Si el usuario ya está registrado en el sistema.
     * @throws Exception Si ocurre un error durante la validación del administrador.
     */
    public void agregarAdministrador(String cedula, String clave, String nombreCompleto) throws Exception {
        if (buscarUsuario(cedula) != null) {
            throw new UsuarioInvalidoException(
                String.format("El usuario %s ya está registrado en el sistema.", cedula)
            );
        }
        Administrador administradorARegistrar = new Administrador(cedula, clave, nombreCompleto);
        administradorARegistrar.validar();
        administradores.put(cedula, administradorARegistrar);
    }

    public void agregarJugador(double saldo, String cedula, String clave, String nombreCompleto) throws Exception {
        if (buscarUsuario(cedula) != null) {
            throw new UsuarioInvalidoException(
                String.format("El usuario %s ya está registrado en el sistema.", cedula)
            );
        }
        
        Jugador jugadorARegistrar = new Jugador(saldo, cedula, clave, nombreCompleto, null);
        jugadorARegistrar.validar();
        jugadores.put(cedula, jugadorARegistrar);
    }

    public void ingresar(String cedula, String clave)
            throws UsuarioNoRegistradoException, UsuarioEnSesionException, CredencialesIncorrectasException {
        Usuario usuarioEncontrado = buscarUsuario(cedula);

        if (!(usuarioEncontrado instanceof Usuario)) {
            throw new UsuarioNoRegistradoException(
                String.format("El usuario %s no está registrado en el sistema.", cedula)
            );
        }

        if (estaUsuarioEnLinea(usuarioEncontrado)) {
            throw new UsuarioEnSesionException(
                "Acceso denegado. El usuario ya esta esta logueado."
            );
        }

        if (!usuarioEncontrado.verificarCredenciales(cedula, clave)) {
            throw new CredencialesIncorrectasException("Credenciales incorrectas.");
        }

        usuarioEncontrado.ingresar();
    }

    public Usuario buscarUsuario(String cedula) {

        Usuario usuarioEncontrado = jugadores.get(cedula);
        if (usuarioEncontrado instanceof Usuario) {
            return usuarioEncontrado;
        }

        usuarioEncontrado = administradores.get(cedula);

        return usuarioEncontrado;
    }

    private boolean estaUsuarioEnLinea(Usuario usuarioEncontrado) {
        return usuarioEncontrado.estaActivo();
    }

}
