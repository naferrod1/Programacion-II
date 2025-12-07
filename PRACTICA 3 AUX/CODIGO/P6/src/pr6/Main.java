
package pr6;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        ArchLibro archL = new ArchLibro();
        ArchCliente archC = new ArchCliente();
        ArchPrestamo archP = new ArchPrestamo();
        Operaciones op = new Operaciones();

        ArrayList<Libro> libros = archL.cargar();
        ArrayList<Cliente> clientes = archC.cargar();
        ArrayList<Prestamo> prestamos = archP.cargar();

        // Crear datos iniciales si los JSON están vacíos
        if (libros.isEmpty()) {
            libros.add(new Libro(1, "El Principito", 50));
            libros.add(new Libro(2, "Cien Años de Soledad", 80));
            libros.add(new Libro(3, "Don Quijote", 60));
            libros.add(new Libro(4, "Arte de la Guerra", 40));
            archL.guardar(libros);
        }

        if (clientes.isEmpty()) {
            clientes.add(new Cliente(1, "Franco", "Pérez"));
            clientes.add(new Cliente(2, "Gio", "García"));
            clientes.add(new Cliente(3, "María", "Flores"));
            archC.guardar(clientes);
        }

        if (prestamos.isEmpty()) {
            prestamos.add(new Prestamo(1, 1, "2024-04-01", 2));
            prestamos.add(new Prestamo(2, 3, "2024-04-02", 1));
            prestamos.add(new Prestamo(1, 2, "2024-04-03", 3));
            prestamos.add(new Prestamo(3, 1, "2024-04-05", 1));
            archP.guardar(prestamos);
        }

        // a
        op.listarPorPrecio(libros, 40, 70);

        // b
        System.out.println("\nIngreso total libro 1: Bs. " +
            op.ingresoPorLibro(prestamos, 1, libros));

        // c
        op.librosNoVendidos(libros, prestamos);

        // d
        op.clientesDelLibro(clientes, prestamos, 1);

        // e
        op.libroMasPrestado(libros, prestamos);

        // f
        op.clienteMasPrestamos(clientes, prestamos);
    }
}
