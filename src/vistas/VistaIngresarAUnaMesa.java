
package vistas;

import dominio.subsistemas.mesas.entidades.Mesa;

public interface VistaIngresarAUnaMesa extends VistaIU {

    void mostrarMesas();

    void actualizarInfoJugador(String informacionJugador);

    void actualizarTitulo(String string);

    void ingresarEnMesa(Mesa mesaSeleccionada);
}
