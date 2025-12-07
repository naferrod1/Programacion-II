package pr9;
public class Animal {
    private String especie;
    private String nombre;
    private int cantidad;

    public Animal() {}

    public Animal(String especie, String nombre, int cantidad) {
        this.especie = especie;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getEspecie() { return especie; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }

    public void setEspecie(String especie) { this.especie = especie; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void mostrar() {
        System.out.println("  - " + nombre + " (" + especie + ") x" + cantidad);
    }
}