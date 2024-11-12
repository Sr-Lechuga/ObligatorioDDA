package dominio.subsistemas.reglas.entidades;

public class Carta {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String valor;
    private Palo palo;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Carta(String valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos overrided">
    @Override
    public String toString() {
        return valor + " de " + palo.getDescripcion(); // Utiliza la descripción del palo
    }
    // </editor-fold>
}