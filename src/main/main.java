package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import obligatoriodda.dominio.excepciones.CredencialesIncorrectasException;
import obligatoriodda.dominio.excepciones.UsuarioEnSesionException;
import obligatoriodda.dominio.excepciones.UsuarioNoRegistradoException;
import obligatoriodda.dominio.fachada.Fachada;
import utilidades.precarga.Precarga;

/**
 *
 * @author jlima
 */
public class main {
    
    public static void main(String[] args){
        Fachada fachada = Fachada.getInstancia();
        cargarSistema(fachada);
        
        try {
            fachada.ingresar("0", "0");
        } catch (UsuarioNoRegistradoException | UsuarioEnSesionException | CredencialesIncorrectasException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
