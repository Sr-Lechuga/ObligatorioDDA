package dominio.subsistemas.usuarios.entidades;

import java.util.Date;

public class Sesion {
  private Usuario usuario;
  private Date fechaIngreso = new Date();

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Sesion(Usuario usuario) {
    this.usuario = usuario;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public Usuario getUsuario() {
    return usuario;
  }

  public Date getFechaIngreso() {
    return fechaIngreso;
  }
  // </editor-fold>

}
