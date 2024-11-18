package controladores;

import controladores.Eventos.EventoJuego;
import dominio.subsistemas.Fachada;
import dominio.subsistemas.usuarios.entidades.Jugador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;
import vistas.VistaJugarPoker;

public class ControladorJugarPoker implements Observador {

    Jugador jugadorEnSesion;
    VistaJugarPoker vistaJugarPoker;
    Fachada fachada;

    public ControladorJugarPoker(Jugador jugadorEnSesion, VistaJugarPoker vistaJugarPoker) {
        this.jugadorEnSesion = jugadorEnSesion;
        this.vistaJugarPoker = vistaJugarPoker;

        fachada = Fachada.getInstancia();
        fachada.agregar(this);
    }

    @Override
    public void actualizar(Observable unObservable, Object unEvento) {
        if (unEvento instanceof EventoJuego) {
            switch ((EventoJuego) unEvento) {
                case EventoJuego.JUEGO_INICIADO:

                    break;

                default:
                    break;
            }
        }
    }

}
