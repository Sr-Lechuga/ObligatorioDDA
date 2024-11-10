package obligatoriodda.dominio.fachada;

import java.util.HashMap;

import obligatoriodda.dominio.entidades.Administrador;
import obligatoriodda.dominio.entidades.Jugador;
import obligatoriodda.dominio.entidades.Usuario;
import obligatoriodda.dominio.excepciones.usuarios.CredencialesIncorrectasException;
import obligatoriodda.dominio.excepciones.usuarios.UsuarioEnSesionException;
import obligatoriodda.dominio.excepciones.usuarios.UsuarioInvalidoException;
import obligatoriodda.dominio.excepciones.usuarios.UsuarioNoRegistradoException;

/**
 *
 * @author jlima
 */
class sUsuarios {

    //<cedula,usuario>
//    private HashMap<Integer, Usuario> usuariosActivos = new HashMap<>();
    private HashMap<String, Administrador> administradores = new HashMap<>();
    private HashMap<String, Jugador> jugadores = new HashMap<>();

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
        
        Jugador jugadorARegistrar = new Jugador(saldo, cedula, clave, nombreCompleto);
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

        if (!usuarioEncontrado.validarCredenciales(cedula, clave)) {
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
