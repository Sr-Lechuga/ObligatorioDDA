package obligatoriodda.dominio.entidades;

public class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void analizarMano() {
        throw new UnsupportedOperationException("Método no implementado");
    }
}