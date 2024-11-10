package obligatoriodda.dominio.entidades;

import obligatoriodda.dominio.interfaces.IValidable;

public class Palo implements IValidable {
    private String codigo;      // Inicial del palo (C, D, T, P)
    private String descripcion;  // Nombre completo del palo (Corazones, Diamantes, Tréboles, Picas)

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Palo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        validar(); // Llamamos al método de validación al crear el objeto
    }

    @Override
    public void validar() {
        validarCodigo();
    }

    private void validarCodigo() {
      if (!codigo.equals("C") && !codigo.equals("D") && !codigo.equals("T") && !codigo.equals("P")) {
          throw new IllegalArgumentException("Código de palo inválido. Debe ser 'C', 'D', 'T' o 'P'.");
      }
    }

    @Override
    public String toString() {
        return descripcion; 
    }
}