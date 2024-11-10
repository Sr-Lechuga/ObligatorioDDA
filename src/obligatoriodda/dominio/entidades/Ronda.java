package obligatoriodda.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static int contadorRondas = 1;
    private int numeroRonda;
    private double pozo;
    private Figura figuraGanadora;
    private EstadoRonda estado;
    private List<Jugador> participantes;
    private Jugador jugadorGanador;
    private Apuesta apuesta;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Ronda() {
        this.numeroRonda = contadorRondas++;
        this.pozo = 0.0;
        this.figuraGanadora = null;
        this.estado = EstadoRonda.ESPERANDO_APUESTA;
        this.participantes = new ArrayList<>();
        this.jugadorGanador = null;
        this.apuesta = null;
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

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    public void agregarParticipante(Jugador jugador) {
        participantes.add(jugador);
    }

    public void setPozo(double pozo) {
        this.pozo = pozo;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }

    public void setEstado(EstadoRonda estado) {
        this.estado = estado;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Sobreescritos">
    @Override
    public String toString() {
        return "Ronda{" +
                "numeroRonda=" + numeroRonda +
                ", pozo=" + pozo +
                ", figuraGanadora=" + figuraGanadora +
                ", estado=" + estado +
                ", participantes=" + participantes +
                ", jugadorGanador=" + jugadorGanador +
                ", apuesta=" + apuesta +
                '}';
    }
    // </editor-fold>
}