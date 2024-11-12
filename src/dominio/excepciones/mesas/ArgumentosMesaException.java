package dominio.excepciones.mesas;

public class ArgumentosMesaException extends RuntimeException {
    public ArgumentosMesaException(String message) {
        super(message);
    }

    public ArgumentosMesaException(String message, Throwable cause) {
        super(message, cause);
    }
}