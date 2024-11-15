package vistas;

import dominio.subsistemas.usuarios.entidades.Usuario;

public interface VistaLogin extends VistaIU {
  void login();

  void mostrarProximaInterfaz(Usuario user);

}
