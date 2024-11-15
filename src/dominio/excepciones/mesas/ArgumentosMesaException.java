package dominio.excepciones.mesas;

public class ArgumentosMesaException extends Exception {
    public ArgumentosMesaException(String message) {
        super(message);
    }

    public ArgumentosMesaException(String message, Throwable cause) {
        super(message, cause);
    }
}