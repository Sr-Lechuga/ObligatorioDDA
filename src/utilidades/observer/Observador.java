package utilidades.observer;

/**
 * Interface que define un observador en el patrón de diseño Observer.
 * Los observadores pueden ser notificados de eventos en un objeto observable.
 */
public interface Observador {

    /**
     * Método que se invoca para notificar al observador sobre un evento.
     *
     * @param observable el objeto observable que ha cambiado
     * @param objeto     el objeto que representa el evento o la información
     *                   relacionada
     */
    public void actualizar(Observable unObservable, Object unEvento);

}
