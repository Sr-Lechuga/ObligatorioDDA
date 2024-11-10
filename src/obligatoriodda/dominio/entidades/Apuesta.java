package obligatoriodda.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

import obligatoriodda.dominio.interfaces.IValidable;

public class Apuesta implements IValidable {
    private double valor;
    private List<Jugador> participantes;
    private Jugador creador;

    public Apuesta(double valor, Jugador creador) {
        this.valor = valor;
        this.creador = creador;
        this.participantes = new ArrayList<>();
        validar();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        validar();
    }

    public Jugador getCreador() {
        return creador;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(Jugador jugador) {
        if (participantes.size() < 4) {
            participantes.add(jugador);
        } else {
            throw new IllegalStateException("No se pueden agregar más de 4 participantes");
        }
    }

    @Override
    public void validar() {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor de la apuesta debe ser mayor a 0");
        }
    }
}