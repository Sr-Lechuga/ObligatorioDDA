package dominio.subsistemas;

import java.util.ArrayList;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.subsistemas.mesas.sMesas;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.reglas.sReglas;
import dominio.subsistemas.usuarios.sUsuarios;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Sesion;
import dominio.subsistemas.usuarios.entidades.Usuario;
import utilidades.observer.Observable;

/**
 *
 * @author jlima
 */
public class Fachada extends Observable {
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static Fachada instancia;
    private sUsuarios subUsuarios = new sUsuarios();
    private sMesas subMesas = new sMesas();
    private sReglas subReglas = new sReglas();
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">

    // Para evitar que se pueda instanciar
    private Fachada() {
    }

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

    public Sesion loginAdministrador(String cedula, String clave)
            throws UsuarioEnSesionException, CredencialesIncorrectasException {
        return subUsuarios.loginAdministrador(cedula, clave);
    }

    public Sesion loginJugador(String cedula, String clave)
            throws UsuarioEnSesionException, CredencialesIncorrectasException {
        return subUsuarios.loginJugador(cedula, clave);
    }

    public Usuario buscarUsuario(String cedula) {
        return subUsuarios.buscarUsuario(cedula);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Mesas">
    public void crearMesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision)
            throws ArgumentosMesaException {
        subMesas.crearMesa(jugadoresRequeridos, apuestaBase, porcentajeComision);
    }

    public void agregarParticipanteEnMesa(Mesa unaMesa, Jugador unJugador)
            throws ArgumentosMesaException, GestionMesasException, SaldoException {
        subMesas.agregarParticipanteEnMesa(unaMesa, unJugador);
    }

    public double calcularRecaudacion(int numeroMesa) throws GestionMesasException {
        return subMesas.calcularRecaudacion(numeroMesa);
    }

    public ArrayList<Mesa> obtenerMesas() {
        return subMesas.obtenerMesas();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Reglas">
    // </editor-fold>

}