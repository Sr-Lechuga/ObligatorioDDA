package utilidades.precarga;

import dominio.excepciones.reglas.FiguraArgumentoException;
import dominio.excepciones.usuarios.SaldoException;
import dominio.excepciones.usuarios.UsuarioInvalidoException;
import dominio.subsistemas.Fachada;

/**
 *
 * @author jlima
 */
public class Precarga {

    public void cargar(Fachada fachada) throws UsuarioInvalidoException, SaldoException, FiguraArgumentoException {
        cargarAdministradores(fachada);
        cargarJugadores(fachada);
        cargarFiguras(fachada);
    }

    private void cargarAdministradores(Fachada fachada) throws UsuarioInvalidoException, SaldoException {
        fachada.agregarAdministrador("100", "100", "A 100");
        fachada.agregarAdministrador("200", "200", "A 200");
    }

    private void cargarJugadores(Fachada fachada) throws UsuarioInvalidoException, SaldoException {
        fachada.agregarJugador(0, "0", "0", "J0");
        fachada.agregarJugador(1000, "1", "1", "J1");
        fachada.agregarJugador(2000, "2", "2", "J2");
        fachada.agregarJugador(3000, "3", "3", "J3");
        fachada.agregarJugador(4000, "4", "4", "J4");
        fachada.agregarJugador(5000, "5", "5", "J5");
        fachada.agregarJugador(6000, "6", "6", "J6");
        fachada.agregarJugador(7000, "7", "7", "J7");
        fachada.agregarJugador(8000, "8", "8", "J8");
        fachada.agregarJugador(9000, "9", "9", "J9");
    }

    private void cargarFiguras(Fachada fachada) throws FiguraArgumentoException {
        fachada.agregarFigura("Poker", "Cuatro cartas de igual valor sin importar el palo.");
        fachada.agregarFigura("Escalera", "Cinco carts dcuyo valor esta en escalera sin importar el palo.");
        fachada.agregarFigura("Pierna", "Tres cartas de igual valor sin importar el palo.");
        fachada.agregarFigura("Par", "Dos cartas de igual valor sin importar el palo.");
        fachada.agregarFigura("Sin Figura", "Las cartas no cumplen ninguno de los juegos anteriores.");
    }
}
