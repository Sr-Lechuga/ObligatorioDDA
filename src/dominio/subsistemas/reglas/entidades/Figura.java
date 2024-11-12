package dominio.subsistemas.reglas.entidades;

public class Figura {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String nombre;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getNombre() {
        return nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public void analizarMano() {
        throw new UnsupportedOperationException("Método no implementado");
    }
    // </editor-fold>
}