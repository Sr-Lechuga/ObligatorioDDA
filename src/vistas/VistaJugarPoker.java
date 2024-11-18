
package vistas;

import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import panelCartasPoker.CartaPoker;

public interface VistaJugarPoker extends VistaIU {
    @Override
    public void mostrarMensajeError(String mensajeError);

    @Override
    public void mostrarMensajeAviso(String mensajeAviso);

    public void mostrarJugadores(CopyOnWriteArrayList<Jugador> participantes);

    public void mostrarFiguras(ArrayList<Figura> figuras);

    void cargarCartas(ArrayList<CartaPoker> cartas);

    public void mostrarPozoActual(String pozoRondaActual);

    public void mostrarFiguraActual(String string);
}
