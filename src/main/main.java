package main;

import iuswing.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import dominio.subsistemas.Fachada;
import utilidades.precarga.Precarga;

/**
 *
 * @author jlima
 */
public class main {

    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstancia();
        cargarSistema(fachada);

        Principal principal = new Principal();
        principal.setVisible(true);
    }

    private static void cargarSistema(Fachada fachada) {
        Precarga precarga = new Precarga();
        try {
            precarga.cargar(fachada);
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
