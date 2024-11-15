
package vistas;


public interface VistaPoker extends VistaIU {
    @Override
    public void mostrarMensajeError(String mensajeError);

    @Override
    public void mostrarMensajeAviso(String mensajeAviso);
    
    public void mostrarJugadores();
    public void mostrarFiguras();
    
}
