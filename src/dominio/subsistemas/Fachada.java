package dominio.subsistemas;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.excepciones.usuarios.UsuarioNoRegistradoException;
import dominio.subsistemas.mesas.sMesas;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.reglas.sReglas;
import dominio.subsistemas.usuarios.sUsuarios;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Usuario;
import utilidades.observer.Observable;

/**
 *
 * @author jlima
 */
public class Fachada extends Observable{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static Fachada instancia;
    private sUsuarios subUsuarios = new sUsuarios();
    private sMesas submesas = new sMesas();
    private sReglas subReglas = new sReglas();
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">    
    
    // Para evitar que se pueda instanciar
    private Fachada() {}

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Usuario">
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Usuario">

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
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Métodos Mesas">
    public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision)
            throws ArgumentosMesaException {
        submesas.crearMesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
    }

    public void agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador) throws ArgumentosMesaException, GestionMesasException {
        submesas.agregarParticipanteEnMesa(unaMesa, unJugador);
    }

    public double calcularRecaudacion(int numeroMesa) throws GestionMesasException {
        return submesas.calcularRecaudacion(numeroMesa);
    }

    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Reglas">
    // </editor-fold>

}