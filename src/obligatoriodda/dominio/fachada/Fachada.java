package obligatoriodda.dominio.fachada;

import obligatoriodda.dominio.excepciones.CredencialesIncorrectasException;
import obligatoriodda.dominio.excepciones.UsuarioEnSesionException;
import obligatoriodda.dominio.excepciones.UsuarioNoRegistradoException;

/**
 *
 * @author jlima
 */
public class Fachada {

    private static Fachada instancia;

    private sUsuarios subUsuarios = new sUsuarios();

    //Para evitar que se pueda instanciar
    private Fachada(){}
    
    public static synchronized Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public void agregarAdministrador(String cedula, String clave, String nombreCompleto) throws Exception{
        subUsuarios.agregarAdministrador(cedula, clave, nombreCompleto);
    }
    
    public void agregarJugador(double saldo, String cedula, String clave, String nombreCompleto) throws Exception {
        subUsuarios.agregarJugador(saldo, cedula, clave, nombreCompleto);
    }
    
    public void ingresar(String cedula, String clave)
            throws UsuarioNoRegistradoException, UsuarioEnSesionException, CredencialesIncorrectasException {
        subUsuarios.ingresar(cedula, clave);
    }
}
