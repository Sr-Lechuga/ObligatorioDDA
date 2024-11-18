package dominio.subsistemas.mesas.entidades;

import panelCartasPoker.CartaPoker;

public class Carta implements CartaPoker, Comparable<Carta> {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private int valor;
    private String palo;
    private boolean visible;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo.toUpperCase();
        visible = false;
        validar();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos de interfaz">
    @Override
    public int getValorCarta() {
        return valor;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        this.visible = b;
    }

    @Override
    public int compareTo(Carta o) {
        if (o == null) {
            throw new NullPointerException("La carta a comparar no puede ser nula");
        }
        return Integer.compare(this.valor, o.getValorCarta());
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Validaciones">
    public void validar() {
        validarPalo();
        validarValor();
    }

    private void validarPalo() {
        if (!palo.toUpperCase().matches("[CDTP]")) {
            throw new IllegalArgumentException("Código de palo inválido. Debe ser 'C', 'D', 'T' o 'P'.");
        }
    }

    private void validarValor() {
        if (valor < 1 || valor > 13) {
            throw new IllegalArgumentException("Valor de la carta inválido. Debe ser entre 1 y 13.");
        }
    }
    // </editor-fold>

}