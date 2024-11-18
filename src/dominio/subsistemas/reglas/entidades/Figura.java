package dominio.subsistemas.reglas.entidades;

import java.util.ArrayList;

import dominio.excepciones.reglas.FiguraArgumentoException;
import dominio.interfaces.IValidable;
import dominio.subsistemas.mesas.entidades.Carta;

public class Figura implements IValidable {

  // <editor-fold defaultstate="collapsed" desc="Atributos">
  private String nombre;
  private String descripcion;
  private FiguraStrategy estrategia;
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Setter">
  public void setEstrategia(FiguraStrategy estrategia) {
    this.estrategia = estrategia;
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Constructores">
  public Figura(String nombre, String descripcion) throws FiguraArgumentoException {
    this.nombre = nombre;
    this.descripcion = descripcion;
    validar();
  }
  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Getters">
  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  // </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="Métodos">
  public String analizarMano(ArrayList<Carta> mano) {
    return estrategia.analizarMano(mano);
  }

  @Override
  public void validar() throws FiguraArgumentoException {
    validarNombre();
    validarDescripcion();
  }

  // </editor-fold>

  public void validarNombre() throws FiguraArgumentoException {
    if (nombre == null) {
      throw new FiguraArgumentoException("El nombre de la figura no puede ser nulo o vacío");
    }

  }

  public void validarDescripcion() throws FiguraArgumentoException {
    if (descripcion == null) {
      throw new FiguraArgumentoException("La descripción de la figura no puede ser vacía");
    }
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}