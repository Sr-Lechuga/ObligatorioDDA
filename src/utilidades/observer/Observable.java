
package utilidades.observer;

public interface Observable {

    /**
     * Agrega un observador a la lista de observadores.
     *
     * @param observador El observador a agregar.
     */
    public void agregar(Observador observer);

    /**
     * Quita un observador de la lista de observadores.
     *
     * @param observador El observador a quitar.
     */
    public void quitar(Observador observer);

    /**
     * Notifica a todos los observadores registrados sobre un evento.
     * Este método recorre la lista de observadores y llama al método
     * de actualización de cada uno, pasando el evento correspondiente.
     *
     * @param evento El evento que ha ocurrido.
     */
    public void avisar(Object evento);
}
