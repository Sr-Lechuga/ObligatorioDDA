package iuswing;

import java.awt.Frame;

import controladores.ControladorUsuarios;
import dominio.subsistemas.usuarios.entidades.Administrador;
import dominio.subsistemas.usuarios.entidades.Usuario;

public class LoginAdministrador extends Login {
    ControladorUsuarios controladorUsuarios;

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
        this.controladorUsuarios = new ControladorUsuarios(this);
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
