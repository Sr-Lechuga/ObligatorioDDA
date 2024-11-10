package obligatoriodda.dominio.entidades;

public class Carta {
    private String valor;
    private Palo palo;

    public Carta(String valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return valor + " de " + palo.getDescripcion(); // Utiliza la descripción del palo
    }
}