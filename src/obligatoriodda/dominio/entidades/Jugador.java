package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.excepciones.usuarios.SaldoException;
import obligatoriodda.dominio.entidades.EstadoJugador;
import obligatoriodda.dominio.interfaces.IValidable;

@SuppressWarnings("unused")
public class Jugador extends Usuario implements IValidable {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private double saldo;
    private EstadoJugador estado;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Jugador(double saldo, String cedula, String clave, String nombreCompleto, EstadoJugador estado) {
        super(cedula, clave, nombreCompleto);
        this.saldo = saldo;
        this.estado = estado;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public double getSaldo() {
        return saldo;
    }

    public EstadoJugador getEstado() {
        return estado; 
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