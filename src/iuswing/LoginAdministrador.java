package iuswing;

import java.awt.Frame;

import controladores.ControladorAcceso;
import dominio.subsistemas.usuarios.entidades.Administrador;
import dominio.subsistemas.usuarios.entidades.Usuario;

public class LoginAdministrador extends Login {
    ControladorAcceso controladorUsuarios;

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
        this.controladorUsuarios = new ControladorAcceso(this);
    }

    @Override
    public void login(String cedula, String clave) {
        controladorUsuarios.ingresarSistema(cedula, clave);
    }

    @Override
    public void mostrarProximaInterfaz(Usuario user) {
        Administrador administrador = (Administrador) user;
        AdministrarMesas administrarMesas = new AdministrarMesas(administrador);
        administrarMesas.setVisible(true);
        dispose();
    }

}
