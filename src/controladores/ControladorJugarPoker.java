package controladores;

import java.util.ArrayList;

import controladores.Eventos.EventoJuego;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaJugarPoker;

public class ControladorJugarPoker implements Observador {

    Jugador jugadorEnSesion;
    VistaJugarPoker vistaJugarPoker;
    Fachada fachada;
    Mesa mesaActual;

    public Jugador getJugadorEnSesion() {
        return jugadorEnSesion;
    }

    public Mesa getMesaActual() {
        return mesaActual;
    }

    public ControladorJugarPoker(Jugador jugadorEnSesion, Mesa mesa, VistaJugarPoker vistaJugarPoker) {
        this.jugadorEnSesion = jugadorEnSesion;
        this.vistaJugarPoker = vistaJugarPoker;
        this.mesaActual = mesa;

        fachada = Fachada.getInstancia();
        fachada.agregar(this);
    }

    private void iniciarRonda() {
        try {
            fachada.iniciarJuego(mesaActual);
            Ronda rondaActual = mesaActual.getRondaActual();
            if (rondaActual.participa(jugadorEnSesion)) {
                vistaJugarPoker.cargarCartas(jugadorEnSesion.getManoCartasPoker());
                vistaJugarPoker.mostrarPozoActual(mesaActual.getPozoRondaActual());
                vistaJugarPoker.mostrarFiguraActual("Papitas Fritas con ketchup");
            }
        } catch (SaldoException e) {
            vistaJugarPoker.mostrarMensajeError(e.getMessage());
        }
    }

    private void actualizarParticipantes() {
        vistaJugarPoker.mostrarJugadores(fachada.obtenerParticipantesDeRondaActualEnMesa(mesaActual));
    }

    private void confirmarEstadoRonda() {
        EstadoRonda estadoActualRondaDeMesa = mesaActual.getEstadoRondaActual();
        if (estadoActualRondaDeMesa == EstadoRonda.TERMINADA) {
            vistaJugarPoker.mostrarMensajeAviso("La ronda ha finalizado");
        }
    }

    @Override
    public void actualizar(Observable unObservable, Object unEvento) {
        if (unEvento instanceof EventoJuego) {
            switch ((EventoJuego) unEvento) {
                case EventoJuego.JUGADOR_AGREGADO:
                    actualizarParticipantes();
                    break;
                case EventoJuego.JUEGO_INICIADO:
                    iniciarRonda();
                    break;
                case EventoJuego.JUGADOR_PASO:
                    confirmarEstadoRonda();
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayList<Figura> obtenerFigurasDisponibles() {
        return fachada.obtenerFigurasDisponibles();
    }

    public void pasar() {
        fachada.pasar(mesaActual, jugadorEnSesion);
        fachada.avisar(EventoJuego.JUGADOR_PASO);
    }

}
