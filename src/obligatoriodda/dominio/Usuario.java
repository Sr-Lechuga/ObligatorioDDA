package obligatoriodda.dominio;

import obligatoriodda.dominio.excepciones.UsuarioInvalidoException;
import obligatoriodda.dominio.interfaces.IValidable;

/**
 *
 * @author jlima
 */
public abstract class Usuario implements IValidable {

    private String cedula;
    private String clave;
    private boolean activo;
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Usuario(String cedula, String clave, String nombreCompleto) {
        this.cedula = cedula;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.activo = false;
    }

    public boolean validarCredenciales(String cedula, String clave) {
        return this.cedula.equals(cedula)
                && this.clave.equals(clave);
    }

    @Override
    public void validar() throws Exception {
        try {
            validarCedula();
            validarClave();
            validarNombreCompleto();
        } catch (UsuarioInvalidoException e) {
            throw e;
        }
    }

    private void validarCedula() throws UsuarioInvalidoException {
//        if (!this.cedula.matches("\\d{7,8}")) {
//            throw new UsuarioInvalidoException("Ingrese la cedula con el digito verificador. Sin puntos ni guiones.");
//        }
        if(this.cedula.isBlank()){
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

    public boolean estaActivo() {
        return this.activo;
    }

    public void ingresar() {
        this.activo = true;
    }
}
