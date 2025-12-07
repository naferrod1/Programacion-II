
package pr6;
import java.util.ArrayList;
import java.util.HashMap;

public class Operaciones {

    // a) Listar los libros cuyo precio esté entre x e y
    public void listarPorPrecio(ArrayList<Libro> libros, double x, double y) {
        System.out.println("\nLibros entre Bs. " + x + " y Bs. " + y + ":");
        for (Libro l : libros) {
            if (l.getPrecio() >= x && l.getPrecio() <= y)
                System.out.println(l);
        }
    }

    // b) Calcular ingreso total generado por un libro específico
    public double ingresoPorLibro(ArrayList<Prestamo> prestamos, int codLibro, ArrayList<Libro> libros) {
        double precio = 0;

        for (Libro l : libros) {
            if (l.getCodLibro() == codLibro) {
                precio = l.getPrecio();
                break;
            }
        }

        int totalCant = 0;
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro)
                totalCant += p.getCantidad();
        }

        return totalCant * precio;
    }

    // c) Libros que nunca fueron vendidos
    public void librosNoVendidos(ArrayList<Libro> libros, ArrayList<Prestamo> prestamos) {
        System.out.println("\nLibros que nunca fueron prestados:");
        for (Libro l : libros) {
            boolean vendido = false;
            for (Prestamo p : prestamos) {
                if (p.getCodLibro() == l.getCodLibro()) {
                    vendido = true;
                    break;
                }
            }
            if (!vendido)
                System.out.println(l);
        }
    }

    // d) Clientes que compraron un libro específico
    public void clientesDelLibro(ArrayList<Cliente> clientes, ArrayList<Prestamo> prestamos, int codLibro) {
        System.out.println("\nClientes que prestaron el libro " + codLibro + ":");
        for (Prestamo p : prestamos) {
            if (p.getCodLibro() == codLibro) {
                for (Cliente c : clientes) {
                    if (c.getCodCliente() == p.getCodCliente()) {
                        System.out.println(c);
                    }
                }
            }
        }
    }

    // e) Libro más prestado
    public void libroMasPrestado(ArrayList<Libro> libros, ArrayList<Prestamo> prestamos) {
        HashMap<Integer, Integer> conteo = new HashMap<>();

        for (Prestamo p : prestamos) {
            conteo.put(p.getCodLibro(), conteo.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
        }

        int max = -1, codMax = -1;
        for (var x : conteo.entrySet()) {
            if (x.getValue() > max) {
                max = x.getValue();
                codMax = x.getKey();
            }
        }

        for (Libro l : libros) {
            if (l.getCodLibro() == codMax) {
                System.out.println("\nLibro más prestado: " + l + " (" + max + " préstamos)");
            }
        }
    }

    // f) Cliente con más préstamos
    public void clienteMasPrestamos(ArrayList<Cliente> clientes, ArrayList<Prestamo> prestamos) {
        HashMap<Integer, Integer> conteo = new HashMap<>();

        for (Prestamo p : prestamos) {
            conteo.put(p.getCodCliente(), conteo.getOrDefault(p.getCodCliente(), 0) + p.getCantidad());
        }

        int max = -1, codMax = -1;

        for (var x : conteo.entrySet()) {
            if (x.getValue() > max) {
                max = x.getValue();
                codMax = x.getKey();
            }
        }

        for (Cliente c : clientes) {
            if (c.getCodCliente() == codMax) {
                System.out.println("\nCliente con más préstamos: " + c + " (" + max +")");
            }
        }
    }
}
