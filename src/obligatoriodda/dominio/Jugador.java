package obligatoriodda.dominio;

import obligatoriodda.dominio.excepciones.SaldoException;
import obligatoriodda.dominio.interfaces.IValidable;

/**
 *
 * @author jlima
 */
public class Jugador extends Usuario implements IValidable{
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public Jugador(double saldo, String cedula, String clave, String nombreCompleto) {
        super(cedula, clave, nombreCompleto);
        this.saldo = saldo;
    }

    @Override
    public void validar() throws Exception {
        super.validar();
        validarSaldo();
    }

    private void validarSaldo() throws SaldoException {
        if(this.saldo < 0){
            throw new SaldoException("El saldo no puede ser negativo.");
        }
    }


}
