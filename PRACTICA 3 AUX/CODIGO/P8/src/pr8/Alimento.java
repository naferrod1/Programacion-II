package pr8;
public class Alimento {
    String nombre;
    String fechaVencimiento; // formato: "2025-12-31"
    int cantidad;

    public void mostrar() {
        System.out.println("Nombre: " + nombre +
                " | Vence: " + fechaVencimiento +
                " | Cantidad: " + cantidad);
    }
}