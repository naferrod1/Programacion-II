import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LeerLibros {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Type listaTipo = new TypeToken<ArrayList<Libro>>() {}.getType();
        
        try (FileReader reader = new FileReader("libros.json")) {
            ArrayList<Libro> libros = gson.fromJson(reader, listaTipo);
            System.out.println("=== Libros leídos de libros.json ===");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo() + " | Autor: " + libro.getAutor() + " | Stock: " + libro.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
