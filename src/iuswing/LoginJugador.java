package iuswing;

import java.awt.Frame;

import controladores.ControladorAcceso;
import dominio.subsistemas.usuarios.entidades.Usuario;

public class LoginJugador extends Login {
    ControladorAcceso controladorUsuarios;

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
        this.controladorUsuarios = new ControladorAcceso(this);
    }

    @Override
    public void login(String cedula, String clave) {
        controladorUsuarios.ingresarSistema(cedula, clave);
    }

    @Override
    public void mostrarProximaInterfaz(Usuario user) {
        IngresarAUnaMesa ingresarAUnaMesa = new IngresarAUnaMesa();
        ingresarAUnaMesa.setVisible(true);
        dispose();
    }
}
