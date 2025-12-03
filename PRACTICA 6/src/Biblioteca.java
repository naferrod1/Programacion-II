import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private LinkedList<Libro> libros = new LinkedList<>();
    private LinkedList<Estudiante> estudiantes = new LinkedList<>();
    private LinkedList<Prestamo> prestamos = new LinkedList<>();

    private static final String ARCHIVO_BIBLIOTECA = "biblioteca.json";
    private static final String ARCHIVO_LIBROS = "libros.json";

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        cargarDatos();
    }

    private Gson crearGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(src.toString());
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        return LocalDate.parse(json.getAsString());
                    }
                })
                .create();
    }

    public void guardarDatos() {
        try (Writer writer = new FileWriter(ARCHIVO_BIBLIOTECA)) {
            Gson gson = crearGson();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        guardarLibrosSeparados();
    }

    public void cargarDatos() {
        File file = new File(ARCHIVO_BIBLIOTECA);
        if (!file.exists()) return;

        try (Reader reader = new FileReader(ARCHIVO_BIBLIOTECA)) {
            Gson gson = crearGson();
            Biblioteca datos = gson.fromJson(reader, Biblioteca.class);
            if (datos != null) {
                this.libros = datos.libros != null ? datos.libros : new LinkedList<>();
                this.estudiantes = datos.estudiantes != null ? datos.estudiantes : new LinkedList<>();
                this.prestamos = datos.prestamos != null ? datos.prestamos : new LinkedList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarLibrosSeparados() {
        ArrayList<Libro> listaLibros = new ArrayList<>(libros);
        try (Writer writer = new FileWriter(ARCHIVO_LIBROS)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaLibros, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarDatos();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        guardarDatos();
    }

    public void realizarPrestamo(Estudiante estudiante, Libro libro, int cantidad) {
        if (libro.getStock() >= cantidad) {
            libro.setStock(libro.getStock() - cantidad);
            prestamos.add(new Prestamo(estudiante, libro, cantidad));
            guardarDatos();
        }
    }

    public void registrarDevolucion(Prestamo prestamo) {
        prestamos.remove(prestamo);
        prestamo.getLibro().setStock(prestamo.getLibro().getStock() + prestamo.getCantidad());
        guardarDatos();
    }

    public LinkedList<Libro> getLibrosDisponibles() { return libros; }
    public LinkedList<Estudiante> getEstudiantesRegistrados() { return estudiantes; }
    public LinkedList<Prestamo> getPrestamosActivos() { return prestamos; }
}
