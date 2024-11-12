package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private List<Carta> cartas;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Mazo() {
        cartas = new ArrayList<>();
        crearMazo();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    private void crearMazo() {
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Palo[] palos = {
            new Palo("C", "Corazones"),
            new Palo("D", "Diamantes"),
            new Palo("T", "Tréboles"),
            new Palo("P", "Picas")
        };

        for (Palo palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public void mezclar() {
        Collections.shuffle(cartas);
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

    public List<Carta> getCartas() {
        return cartas;
    }
    // </editor-fold>
}