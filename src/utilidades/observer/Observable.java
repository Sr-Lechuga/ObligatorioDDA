
package utilidades.observer;

import java.util.*;

public class Observable {
    /**
     * Lista de observadores registrados.
    */
    private final List<Observador> observadores = new ArrayList<>();
    
    /**
     * Agrega un observador a la lista de observadores.
     *
     * @param observador El observador a agregar.
    */
    public void agregar(Observador observer){
        if(!observadores.contains(observer)){
            observadores.add(observer);
        }
    }

    /**
     * Quita un observador de la lista de observadores.
     *
     * @param observador El observador a quitar.
    */
    public void quitar(Observador observer){
        if(observadores.contains(observer)){
            observadores.remove(observer);
        }
    }

    /**
     * Notifica a todos los observadores registrados sobre un evento.
     * Este método recorre la lista de observadores y llama al método
     * de actualización de cada uno, pasando el evento correspondiente.
     *
     * @param evento El evento que ha ocurrido.
    */
    public void avisar(Object evento){
        for(Observador unObservador : this.observadores){
            unObservador.actualizar(this,evento);
        }
    }
}
