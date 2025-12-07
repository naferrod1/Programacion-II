package pr9;
import java.util.ArrayList;

public class Zoologico {

    private int id;
    private String nombre;
    private ArrayList<Animal> animales;

    public Zoologico() {
        animales = new ArrayList<>();
    }

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.animales = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public ArrayList<Animal> getAnimales() { return animales; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void agregarAnimal(Animal a) {
        animales.add(a);
    }

    public int cantidadVariedades() {
        return animales.size();
    }

    public boolean estaVacio() {
        return animales.isEmpty();
    }

    public void mostrar() {
        System.out.println("\nZOO #" + id + ": " + nombre);
        if (animales.isEmpty()) {
            System.out.println("  (Sin animales)");
        } else {
            for (Animal a : animales) a.mostrar();
        }
    }
}