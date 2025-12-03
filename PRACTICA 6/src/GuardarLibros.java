import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardarLibros {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        
        // Crear 3 libros
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 10));
        libros.add(new Libro("1984", "George Orwell", 5));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 7));
        
        // Crear Gson con formato bonito
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Guardar en libros.json
        try (FileWriter writer = new FileWriter("libros.json")) {
            gson.toJson(libros, writer);
            System.out.println("Libros guardados correctamente en libros.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
