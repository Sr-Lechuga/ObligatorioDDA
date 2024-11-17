package controladores;

import dominio.subsistemas.usuarios.entidades.Jugador;
import utilidades.observer.Observable;
import utilidades.observer.Observador;

public class ControladorJugarPoker implements Observador{

    Jugador jugadorEnSesion;
    
    public ControladorJugarPoker(Jugador jugadorEnSesion) {
        this.jugadorEnSesion = jugadorEnSesion;
    }

    @Override
    public void actualizar(Observable unObservable, Object unEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
