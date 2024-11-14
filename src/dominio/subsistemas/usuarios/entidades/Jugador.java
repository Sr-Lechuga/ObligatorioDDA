package dominio.subsistemas.usuarios.entidades;

import java.util.List;

import dominio.excepciones.usuarios.SaldoException;
import dominio.interfaces.IValidable;
import dominio.subsistemas.reglas.entidades.Carta;
import dominio.subsistemas.usuarios.estados.EstadoJugador;

@SuppressWarnings("unused")
public class Jugador extends Usuario implements IValidable {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private double saldo;
    private EstadoJugador estado;

    private List<Carta> mano;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Jugador(double saldo, String cedula, String clave, String nombreCompleto, EstadoJugador estado) {
        super(cedula, clave, nombreCompleto);
        this.saldo = saldo;
        this.estado = estado;

        this.mano = null;
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

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    public void validarSaldoMinimo(double saldoMinimo) throws SaldoException{
        if(Double.compare(this.saldo, saldoMinimo) < 0){
            throw new SaldoException("Saldo insuficiente");
        }
    }

    public void removerSaldo(double apuesta) throws SaldoException {
        validarSaldoMinimo(apuesta);
        this.saldo -= apuesta;
    }
    
    public void recibirCartas(List<Carta> cartas) {
        this.mano = cartas;
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
