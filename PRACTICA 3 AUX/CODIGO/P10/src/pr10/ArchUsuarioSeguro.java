/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr10;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchUsuarioSeguro {

    private final String archivo = "usuarios_seguro.txt";
    private Gson gson = new Gson();

    public void guardar(ArrayList<UsuarioSeguro> lista) {
        try (FileWriter w = new FileWriter(archivo)) {
            gson.toJson(lista, w);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<UsuarioSeguro> cargar() {
        try (FileReader r = new FileReader(archivo)) {
            return gson.fromJson(r, new TypeToken<ArrayList<UsuarioSeguro>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Mostrar todos
    public void mostrarTodo() {
        for (UsuarioSeguro u : cargar()) u.mostrar();
    }

    // Buscar por nombre
    public void buscar(String nombre) {
        for (UsuarioSeguro u : cargar()) {
            if (u.getUsername().equalsIgnoreCase(nombre)) {
                u.mostrar();
                return;
            }
        }
        System.out.println("No encontrado.");
    }
}