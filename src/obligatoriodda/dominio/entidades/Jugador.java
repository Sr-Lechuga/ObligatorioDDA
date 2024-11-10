package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.excepciones.usuarios.SaldoException;
import obligatoriodda.dominio.interfaces.IValidable;

public class Jugador extends Usuario implements IValidable {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private double saldo;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Jugador(double saldo, String cedula, String clave, String nombreCompleto) {
        super(cedula, clave, nombreCompleto);
        this.saldo = saldo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public double getSaldo() {
        return saldo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Validaciones">
    @Override
    public void validar() throws Exception {
        super.validar();
        validarSaldo();
    }

    private void validarSaldo() throws SaldoException {
        if (this.saldo < 0) {
            throw new SaldoException("El saldo no puede ser negativo.");
        }
    }
    // </editor-fold>
}