package dominio.subsistemas.usuarios.entidades;

import dominio.excepciones.usuarios.SaldoException;
import dominio.excepciones.usuarios.UsuarioInvalidoException;
import dominio.interfaces.IValidable;

/**
 *
 * @author jlima
 */
public abstract class Usuario implements IValidable {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private String cedula;
  private String clave;
  private String nombreCompleto;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Usuario(String cedula, String clave, String nombreCompleto) {
    this.cedula = cedula;
    this.clave = clave;
    this.nombreCompleto = nombreCompleto;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public String getCedula() {
    return cedula;
  }

  public String getClave() {
    return clave;
  }

  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Validaciones">

  @Override
  public void validar() throws UsuarioInvalidoException, SaldoException {

    validarCedula();
    validarClave();
    validarNombreCompleto();

  }

  private void validarCedula() throws UsuarioInvalidoException {
    if (this.cedula.isBlank()) {
      throw new UsuarioInvalidoException("La cedula no puede ser vacia.");
    }
  }

  private void validarClave() throws UsuarioInvalidoException {
    if (this.clave.isBlank()) {
      throw new UsuarioInvalidoException("La clave no puede ser vacia.");
    }
  }

  private void validarNombreCompleto() throws UsuarioInvalidoException {
    if (this.nombreCompleto.isBlank()) {
      throw new UsuarioInvalidoException("El nombre completo no puede ser vacio.");
    }
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Metodos">
  public boolean verificarCredenciales(String cedula, String clave) {
    return this.cedula.equals(cedula) && this.clave.equals(clave);
  }
  // </editor-fold>

}