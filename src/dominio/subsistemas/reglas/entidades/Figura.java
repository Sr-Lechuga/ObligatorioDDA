package dominio.subsistemas.reglas.entidades;

import java.util.List;

import dominio.subsistemas.mesas.entidades.Carta;

public class Figura {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String nombre;
    private String descripcion;
    private FiguraStrategy estrategia;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setEstrategia(FiguraStrategy estrategia) {
        this.estrategia = estrategia;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Figura(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getNombre() {
        return nombre;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public boolean analizarMano(List<Carta> mano) {
        return estrategia.analizarMano(mano);
    }

    // </editor-fold>
}