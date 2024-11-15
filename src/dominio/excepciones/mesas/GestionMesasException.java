package dominio.excepciones.mesas;

public class GestionMesasException extends Exception{
  public GestionMesasException(String message) {
    super(message);
  }

  public GestionMesasException(String message, Throwable cause) {
      super(message, cause);
  }

}
