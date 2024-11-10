package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.excepciones.mesas.ArgumentosMesaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jlima
 */
public class Mesa {
    private static int contadorMesas = 0; // Contador para llevar el número de mesas
    private int numeroMesa;
    private int jugadoresRequeridos;
    private double apuestaBase;
    private double totalApostado;
    private double porcentajeComision;
    private double pozoAcumulado;
    
    private List<Jugador> participantes; // Lista de jugadores
    private List<Ronda> rondas; // Lista de rondas
    private Mazo mazo; // Mazo de cartas
    private EstadoMesa estado; // Estado de la mesa

    public Mesa(int jugadoresRequeridos, double apuestaBase, double porcentajeComision) {
        this.numeroMesa = ++contadorMesas; // Incrementa y asigna el número de mesa
        setJugadoresRequeridos(jugadoresRequeridos);
        setApuestaBase(apuestaBase);
        setPorcentajeComision(porcentajeComision);
        
        this.totalApostado = 0.0; // Inicialmente no hay apuestas
        this.pozoAcumulado = 0.0; // Inicialmente el pozo acumulado es cero
        
        this.participantes = new ArrayList<>(); // Inicializa la lista de jugadores
        this.rondas = new ArrayList<>(); // Inicializa la lista de rondas
        this.mazo = new Mazo(); // Inicializa el mazo (asumiendo que Mazo tiene un constructor por defecto)
        this.estado = EstadoMesa.ABIERTO; // Estado inicial de la mesa
    }

    // Getters y Setters
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getJugadoresRequeridos() {
        return jugadoresRequeridos;
    }

    public void setJugadoresRequeridos(int jugadoresRequeridos) {
        this.jugadoresRequeridos = jugadoresRequeridos;
        validar(); // Llamar a validar después de establecer el valor
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(double apuestaBase) {
        this.apuestaBase = apuestaBase;
        validar(); // Llamar a validar después de establecer el valor
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
        validar(); // Llamar a validar después de establecer el valor
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
        return participantes.size(); // Retorna la cantidad de jugadores actuales
    }

    public int getNumeroRondaActual() {
        return rondas.size(); // Retorna el número de la ronda actual (suponiendo que el número de rondas es el número actual)
    }

    public double calcularRecaudacion() {
        return totalApostado * (porcentajeComision / 100); // Calcula la recaudación
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