package dominio.subsistemas.mesas.entidades;

import java.util.ArrayList;
import java.util.List;

import dominio.excepciones.mesas.ArgumentosMesaException;
import dominio.subsistemas.mesas.estados.EstadoMesa;
import dominio.subsistemas.reglas.entidades.Mazo;
import dominio.subsistemas.usuarios.entidades.Jugador;

public class Mesa {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private static int contadorMesas = 1;
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Mesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) throws ArgumentosMesaException {
        this.numeroMesa = contadorMesas++;
        
        this.jugadoresRequeridos = jugadoresRequeridos;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;

        this.totalApostado = 0.0;
        this.pozoAcumulado = 0.0;

        this.participantes = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.mazo = new Mazo();
        this.estado = EstadoMesa.ABIERTA;
        validar();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getJugadoresRequeridos() {
        return jugadoresRequeridos;
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public void agregarParticipante(Jugador jugador) throws ArgumentosMesaException {
        if (participantes.size() < jugadoresRequeridos) {
            participantes.add(jugador);
        } else {
            throw new ArgumentosMesaException("No se pueden agregar más jugadores, la mesa está llena.");
        }
    }

    public void iniciarNuevaRonda() {
        Ronda nuevaRonda = new Ronda();
        rondas.add(nuevaRonda);
    }

    public double calcularRecaudacion() {
        return totalApostado * (porcentajeComision / 100);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Validaciones">
    private void validar() throws ArgumentosMesaException {
        validarJugadoresRequeridos();
        validarApuestaBase();
        validarComision();
    }

    private void validarJugadoresRequeridos() throws ArgumentosMesaException {
        if (jugadoresRequeridos < 2 || jugadoresRequeridos > 5) {
            throw new ArgumentosMesaException("Cantidad de jugadores no valida");
        }
    }

    private void validarApuestaBase() throws ArgumentosMesaException {
        if (apuestaBase < 1) {
            throw new ArgumentosMesaException("Apuesta base invalida");
        }
    }

    private void validarComision() throws ArgumentosMesaException {
        if (porcentajeComision < 1 || porcentajeComision > 50) {
            throw new ArgumentosMesaException("Comision invalida");
        }
    }
    // </editor-fold>
}