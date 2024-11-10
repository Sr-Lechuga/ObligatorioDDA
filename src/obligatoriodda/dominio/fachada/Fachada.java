package obligatoriodda.dominio.fachada;

import obligatoriodda.dominio.entidades.Usuario; // Asegúrate de que esto sea correcto
import obligatoriodda.dominio.excepciones.usuarios.CredencialesIncorrectasException;
import obligatoriodda.dominio.excepciones.usuarios.UsuarioEnSesionException;
import obligatoriodda.dominio.excepciones.usuarios.UsuarioNoRegistradoException;

/**
 *
 * @author jlima
 */
public class Fachada {

    private static Fachada instancia;
    private sUsuarios subUsuarios = new sUsuarios();

    // Para evitar que se pueda instanciar
    private Fachada() {}

    public static synchronized Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public void agregarAdministrador(String cedula, String clave, String nombreCompleto) throws Exception {
        subUsuarios.agregarAdministrador(cedula, clave, nombreCompleto);
    }

    public void agregarJugador(double saldo, String cedula, String clave, String nombreCompleto) throws Exception {
        subUsuarios.agregarJugador(saldo, cedula, clave, nombreCompleto);
    }

    public void ingresar(String cedula, String clave)
            throws UsuarioNoRegistradoException, UsuarioEnSesionException, CredencialesIncorrectasException {
        subUsuarios.ingresar(cedula, clave);
    }

    public Usuario buscarUsuario(String cedula) {
        return subUsuarios.buscarUsuario(cedula);
    }

    // Otros métodos que puedas necesitar...
}