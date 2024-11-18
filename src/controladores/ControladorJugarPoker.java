package controladores;

import java.util.ArrayList;

import controladores.Eventos.EventoJuego;
import dominio.excepciones.usuarios.SaldoException;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.mesas.entidades.Mesa;
import dominio.subsistemas.mesas.entidades.Ronda;
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
            }
        } catch (SaldoException e) {
            vistaJugarPoker.mostrarMensajeError(e.getMessage());
        }
    }

    private void actualizarParticipantes() {
        vistaJugarPoker.mostrarJugadores(fachada.obtenerParticipantesDeRondaActualEnMesa(mesaActual));
    }

    @Override
    public void actualizar(Observable unObservable, Object unEvento) {
        if (unEvento instanceof EventoJuego) {
            switch ((EventoJuego) unEvento) {
                case EventoJuego.JUEGO_INICIADO:
                    iniciarRonda();
                    break;
                case EventoJuego.JUGADOR_AGREGADO:
                    actualizarParticipantes();
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayList<Figura> obtenerFigurasDisponibles() {
        return fachada.obtenerFigurasDisponibles();
    }

}
