package pr9;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class ArchZoo {

    private String nombreArchivo;
    private ArrayList<Zoologico> lista;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchZoo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargar();
    }

    // ------------------ PERSISTENCIA ------------------

    private void cargar() {
        try (Reader reader = new FileReader(nombreArchivo)) {
            lista = gson.fromJson(reader, new TypeToken<ArrayList<Zoologico>>(){}.getType());
            if (lista == null) lista = new ArrayList<>();
        } catch (Exception e) {
            lista = new ArrayList<>();
        }
    }

    private void guardar() {
        try (Writer writer = new FileWriter(nombreArchivo)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar JSON.");
        }
    }

    // ------------------ CRUD ------------------

    public void crear(Zoologico z) {
        lista.add(z);
        guardar();
        System.out.println("Creado correctamente.");
    }

    public void modificar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Zoologico z : lista) {
            if (z.getId() == id) {
                System.out.print("Nuevo nombre: ");
                z.setNombre(sc.nextLine());
                guardar();
                System.out.println("Modificado.");
                return;
            }
        }
        System.out.println("No encontrado.");
    }

    public void eliminar(int id) {
        lista.removeIf(z -> z.getId() == id);
        guardar();
        System.out.println("Eliminado (si existía).");
    }

    // ------------------ b) VARIEDAD ------------------

    public void listarMayoresVariedades() {
        if (lista.isEmpty()) return;

        int max = lista.stream()
                .mapToInt(Zoologico::cantidadVariedades)
                .max()
                .orElse(0);

        System.out.println("\nZoológicos con mayor variedad (" + max + " especies):");

        for (Zoologico z : lista) {
            if (z.cantidadVariedades() == max) {
                z.mostrar();
            }
        }
    }

    // ------------------ c) VACÍOS ------------------

    public void eliminarVacios() {
        lista.removeIf(Zoologico::estaVacio);
        guardar();
        System.out.println("Zoológicos vacíos eliminados.");
    }

    // ------------------ d) ESPECIE X ------------------

    public void mostrarEspecie(String especie) {
        System.out.println("\nBuscando especie: " + especie);
        for (Zoologico z : lista) {
            for (Animal a : z.getAnimales()) {
                if (a.getEspecie().equalsIgnoreCase(especie)) {
                    System.out.println("En zoo: " + z.getNombre());
                    a.mostrar();
                }
            }
        }
    }

    // ------------------ e) MOVER X → Y ------------------

    public void mover(int idOrigen, int idDestino) {

        Zoologico ori = null, des = null;

        for (Zoologico z : lista) {
            if (z.getId() == idOrigen) ori = z;
            if (z.getId() == idDestino) des = z;
        }

        if (ori == null || des == null) {
            System.out.println("ID incorrecto.");
            return;
        }

        des.getAnimales().addAll(ori.getAnimales());
        ori.getAnimales().clear();

        guardar();
        System.out.println("Animales movidos.");
    }
}