package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Mazo {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private List<Carta> cartas;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public List<Carta> getCartas() {
        return cartas;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Mazo() {
        cartas = new CopyOnWriteArrayList<>();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Privados">
    private void crearMazo() {
        cartas = new ArrayList<>();
        int[] valores = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        String[] palos = { "C", "D", "T", "P" };

        for (String palo : palos) {
            for (int valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    private void mezclar() {
        Collections.shuffle(cartas);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Publicos">
    public void barajar() {
        crearMazo();
        mezclar();
    }

    public List<Carta> repartirCartas(int cantidad) {
        if (cantidad > cartas.size()) {
            throw new IllegalArgumentException("No hay suficientes cartas en el mazo.");
        }

        List<Carta> cartasRepartidas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            cartasRepartidas.add(cartas.remove(cartas.size() - 1)); // Reparte la última carta
        }
        return cartasRepartidas;
    }
    // </editor-fold>
}