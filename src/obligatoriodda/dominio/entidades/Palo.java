package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.interfaces.IValidable;

public class Palo implements IValidable {
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private String codigo;
    private String descripcion;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Palo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        validar(); // Llamamos al método de validación al crear el objeto
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Overridden">
    @Override
    public void validar() {
        validarCodigo();
    }

    @Override
    public String toString() {
        return descripcion; 
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos Privados">
    private void validarCodigo() {
        if (
            !codigo.equals("C") 
            || !codigo.equals("D") 
            || !codigo.equals("T") 
            || !codigo.equals("P")) {
            throw new IllegalArgumentException("Código de palo inválido. Debe ser 'C', 'D', 'T' o 'P'.");
        }
    }
    // </editor-fold>
}