package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.List;

import dominio.subsistemas.mesas.estados.EstadoRonda;
import dominio.subsistemas.reglas.entidades.Figura;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Ronda {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static int contadorRondas = 1;
    private int numeroRonda;
    private double pozo;
    private EstadoRonda estado;

    private Figura figuraGanadora;
    private List<Jugador> participantes;
    private Jugador jugadorGanador;
    private Apuesta apuesta;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Ronda() {
        this.numeroRonda = contadorRondas++;
        this.pozo = 0.0;
        this.figuraGanadora = null;
        this.jugadorGanador = null;
        this.apuesta = null;
        
        this.estado = EstadoRonda.ESPERANDO_APUESTA;

        this.participantes = new ArrayList<>();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumeroRonda() {
        return numeroRonda;
    }

    public double getPozo() {
        return pozo;
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public EstadoRonda getEstado() {
        return estado;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setEstado(EstadoRonda estado) {
        this.estado = estado;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    public void agregarParticipante(Jugador jugador) {
        participantes.add(jugador);
    }
    // </editor-fold>
}