package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.List;

import dominio.interfaces.IValidable;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Apuesta implements IValidable {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private double valor;
    private List<Jugador> participantes;
    private Jugador creador;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Apuesta(double valor, Jugador creador) {
        this.valor = valor;
        this.creador = creador;
        this.participantes = new ArrayList<>();
        validar();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Jugador getCreador() {
        return creador;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    public void agregarParticipante(Jugador jugador) {
      validarCantidadParticipantes();
      participantes.add(jugador);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Validaciones">
    @Override
    public void validar() {
        validarValor();
    }

    private void validarValor() {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor de la apuesta debe ser mayor a 0");
        }
    }

    private void validarCantidadParticipantes() {
        if (participantes.size() >= 4) {
            throw new IllegalStateException("No se pueden agregar más de 4 participantes");
        }
    }
    // </editor-fold>
}