package dominio.subsistemas;

import java.util.ArrayList;
import java.util.List;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.excepciones.mesas.GestionMesasException;
import dominio.excepciones.reglas.FiguraArgumentoException;
import dominio.excepciones.usuarios.CredencialesIncorrectasException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.excepciones.usuarios.UsuarioEnSesionException;
import dominio.excepciones.usuarios.UsuarioInvalidoException;
import dominio.subsistemas.mesas.sMesas;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
import dominio.subsistemas.mesas.estados.EstadoMesa;
import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.reglas.sReglas;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.sUsuarios;
import dominio.subsistemas.usuarios.entidades.Jugador;
import dominio.subsistemas.usuarios.entidades.Sesion;
import dominio.subsistemas.usuarios.entidades.Usuario;
import java.util.concurrent.CopyOnWriteArrayList;
import utilidades.observer.Observable;
import utilidades.observer.Observador;

/**
 *
 * @author jlima
 */
public class Fachada implements Observable {
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static Fachada instancia;
    private sUsuarios subUsuarios = new sUsuarios();
    private sMesas subMesas = new sMesas();
    private sReglas subReglas = new sReglas();

    // Lista de observadores del dominio
    private final List<Observador> observadores = new ArrayList<>();

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

    public void agregarAdministrador(String cedula, String clave, String nombreCompleto)
            throws UsuarioInvalidoException, SaldoException {
        subUsuarios.agregarAdministrador(cedula, clave, nombreCompleto);
    }

    public void agregarJugador(double saldo, String cedula, String clave, String nombreCompleto)
            throws UsuarioInvalidoException, SaldoException {
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

    public void ingresarEnMesa(Jugador jugadorEnSesion, Mesa mesaSeleccionada)
            throws ArgumentosMesaException, GestionMesasException, SaldoException {
        subMesas.agregarParticipanteEnMesa(mesaSeleccionada, jugadorEnSesion);
    }

    public double calcularRecaudacion(int numeroMesa) throws GestionMesasException {
        return subMesas.calcularRecaudacion(numeroMesa);
    }

    public ArrayList<Mesa> obtenerTodasLasMesas() {
        return subMesas.obtenerTodasLasMesas();
    }

    public ArrayList<Mesa> obtenerMesasAbiertas() {
        return subMesas.obtenerMesasAbiertas();
    }

    public ArrayList<Ronda> obtenerRondasDeMesa(Mesa mesa) {
        return subMesas.obtenerRondasDeMesa(mesa);
    }

    public double obtenerRecaudacionTotal() {
        return subMesas.obtenerRecaudacionTotal();
    }

    public void iniciarJuego(Mesa mesa) throws SaldoException {
        subMesas.inciarJuego(mesa);
    }

    public CopyOnWriteArrayList<Jugador> obtenerParticipantesDeRondaActualEnMesa(Mesa mesaActual) {
        return subMesas.obtenerParticipantesDeRondaActualEnMesa(mesaActual);
    }

    public void pasar(Mesa mesaActual, Jugador jugadorEnSesion) {
        subMesas.pasar(mesaActual, jugadorEnSesion);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Reglas">

    public void agregarFigura(String nombre, String descripcion) throws FiguraArgumentoException {
        subReglas.agregarFigura(nombre, descripcion);
    }

    public ArrayList<Figura> obtenerFigurasDisponibles() {
        return subReglas.obtenerFigurasDisponibles();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Inteface Observable">
    @Override
    public void agregar(Observador observer) {

        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }

    @Override
    public void quitar(Observador observer) {
        if (observadores.contains(observer)) {
            observadores.remove(observer);
        }
    }

    @Override
    public void avisar(Object evento) {
        for (Observador unObservador : this.observadores) {
            unObservador.actualizar(this, evento);
        }
    }
    // </editor-fold>

    public EstadoMesa obtenerEstadoMesa(Mesa mesaActual) {
        return subMesas.obtenerEstadoMesa(mesaActual);
    }

    public EstadoRonda obtenerEstadoRondaActualMesa(Mesa mesaActual) {
        return subMesas.obtenerEstadoRondaActualMesa(mesaActual);
    }

}