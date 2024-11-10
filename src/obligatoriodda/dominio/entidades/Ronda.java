package obligatoriodda.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private static int contadorRondas = 0;
    private int numeroRonda;
    private double pozo;
    private Figura figuraGanadora;
    private EstadoRonda estado;
    private List<Jugador> participantes;
    private Jugador jugadorGanador;
    private Apuesta apuesta;

    public Ronda() {
        this.numeroRonda = ++contadorRondas;
        this.pozo = 0.0;
        this.figuraGanadora = null;
        this.estado = EstadoRonda.ESPERANDO_APUESTA;
        this.participantes = new ArrayList<>();
        this.jugadorGanador = null;
        this.apuesta = null;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public double getPozo() {
        return pozo;
    }

    public void setPozo(double pozo) {
        this.pozo = pozo;
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }

    public EstadoRonda getEstado() {
        return estado;
    }

    public void setEstado(EstadoRonda estado) {
        this.estado = estado;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(Jugador jugador) {
        participantes.add(jugador);
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    // Nuevos métodos

    public int obtenerCantidadDeParticipantes() {
        return participantes.size();
    }

    public String obtenerNombreDelGanador() {
        return (jugadorGanador != null) ? jugadorGanador.getNombreCompleto() : "No hay ganador";
    }

    public String obtenerNombreDeLaFiguraGanadora() {
        return (figuraGanadora != null) ? figuraGanadora.getNombre() : "No hay figura ganadora";
    }

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
}