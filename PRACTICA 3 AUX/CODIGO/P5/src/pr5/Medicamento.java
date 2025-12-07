package pr5;
public class Medicamento {
    private String nombre;
    private int codMedicamento;
    private String tipo;   // "tos", "resfrio", etc.
    private double precio;

    public Medicamento() {}

    public Medicamento(String nombre, int cod, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = cod;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " ("+tipo+") Bs." + precio;
    }
}
