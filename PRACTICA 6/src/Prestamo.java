import java.time.LocalDate;

public class Prestamo {
    private Estudiante estudiante;
    private Libro libro;
    private int cantidad;
    private LocalDate fechaPrestamo;

    public Prestamo(Estudiante estudiante, Libro libro, int cantidad) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.cantidad = cantidad;
        this.fechaPrestamo = LocalDate.now();
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Libro getLibro() { return libro; }
    public int getCantidad() { return cantidad; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }

    @Override
    public String toString() {
        return estudiante.getNombre() + " - " + libro.getTitulo() + " (" + fechaPrestamo + ")";
    }
}
