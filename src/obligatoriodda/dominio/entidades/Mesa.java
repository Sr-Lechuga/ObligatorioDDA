package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.excepciones.mesas.ArgumentosMesaException;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private static int contadorMesas = 0;
    private int numeroMesa;
    private int jugadoresRequeridos;
    private double apuestaBase;
    private double totalApostado;
    private double porcentajeComision;
    private double pozoAcumulado;

    private List<Jugador> participantes;
    private List<Ronda> rondas;
    private Mazo mazo;
    private EstadoMesa estado;

    public Mesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) {
        this.numeroMesa = ++contadorMesas;
        setJugadoresRequeridos(jugadoresRequeridos);
        setApuestaBase(apuestaBase);
        setPorcentajeComision(porcentajeComision);

        this.totalApostado = 0.0;
        this.pozoAcumulado = 0.0;

        this.participantes = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.mazo = new Mazo();
        this.estado = EstadoMesa.ABIERTA;
        validar();
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getJugadoresRequeridos() {
        return jugadoresRequeridos;
    }

    public void setJugadoresRequeridos(int jugadoresRequeridos) {
        this.jugadoresRequeridos = jugadoresRequeridos;
        validar();
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(double apuestaBase) {
        this.apuestaBase = apuestaBase;
        validar();
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
        validar();
    }

    public double getPozoAcumulado() {
        return pozoAcumulado;
    }

    public List<Jugador> getParticipantes() {
        return participantes;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public int getCantidadJugadores() {
        return participantes.size();
    }

    public int getNumeroRondaActual() {
        return rondas.size();
    }

    public double calcularRecaudacion() {
        return totalApostado * (porcentajeComision / 100);
    }

    public void agregarParticipante(Jugador jugador) {
        if (participantes.size() < jugadoresRequeridos) {
            participantes.add(jugador);
        } else {
            throw new ArgumentosMesaException("No se pueden agregar más jugadores, la mesa está llena.");
        }
    }

    public void agregarRonda(Ronda ronda) {
        rondas.add(ronda);
    }

    private void validar() {
        validarJugadoresRequeridos();
        validarApuestaBase();
        validarComision();
    }

    private void validarJugadoresRequeridos() {
        if (jugadoresRequeridos < 2 || jugadoresRequeridos > 5) {
            throw new ArgumentosMesaException("La cantidad de jugadores requeridos debe estar entre 2 y 5.");
        }
    }

    private void validarApuestaBase() {
        if (apuestaBase < 1) {
            throw new ArgumentosMesaException("La apuesta base debe ser al menos 1.");
        }
    }

    private void validarComision() {
        if (porcentajeComision < 1 || porcentajeComision > 50) {
            throw new ArgumentosMesaException("El porcentaje de comisión debe estar entre 1 y 50 inclusive.");
        }
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "numeroMesa=" + numeroMesa +
                ", jugadoresRequeridos=" + jugadoresRequeridos +
                ", apuestaBase=" + apuestaBase +
                ", totalApostado=" + totalApostado +
                ", porcentajeComision=" + porcentajeComision +
                ", pozoAcumulado=" + pozoAcumulado +
                ", cantidadJugadores=" + getCantidadJugadores() +
                ", estado=" + estado +
                '}';
    }
}