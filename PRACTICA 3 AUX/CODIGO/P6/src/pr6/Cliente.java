package pr6;
public class Cliente {
    private int codCliente;
    private String nombre;
    private String apellido;

    public Cliente() {}

    public Cliente(int codCliente, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() { return codCliente; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    @Override
    public String toString() {
        return codCliente + " - " + nombre + " " + apellido;
    }
}
