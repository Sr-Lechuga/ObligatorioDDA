package controladores;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
