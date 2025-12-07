/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

public class ArchivoCharango {
    private String nombre;
    private Gson gson = new Gson();

    public ArchivoCharango(String nombre) {
        this.nombre = nombre;
    }

    private List<Charango> leer() {
        try (Reader r = new FileReader(nombre)) {
            return gson.fromJson(r, new TypeToken<List<Charango>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardar(List<Charango> lista) {
        try (Writer w = new FileWriter(nombre)) {
            gson.toJson(lista, w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void agregar(Charango c) {
        List<Charango> lista = leer();
        lista.add(c);
        guardar(lista);
    }

    // a) Listar
    public void listar() {
        leer().forEach(System.out::println);
    }

    // b) Eliminar los charangos con más de 6 cuerdas en estado false
    public void eliminarCuerdasRotas() {
        List<Charango> lista = leer();
        lista.removeIf(ch -> ch.contarCuerdasRotas() > 6);
        guardar(lista);
    }

    // c) Listar por material
    public void listarPorMaterial(String m) {
        leer().stream()
            .filter(ch -> ch.getMaterial().equalsIgnoreCase(m))
            .forEach(System.out::println);
    }

    // d) Buscar los charangos con 10 cuerdas
    public void buscar10Cuerdas() {
        leer().stream()
            .filter(ch -> ch.getNroCuerdas() == 10)
            .forEach(System.out::println);
    }

    // e) Ordenar por material
    public void ordenarPorMaterial() {
        List<Charango> lista = leer();
        lista.sort(Comparator.comparing(Charango::getMaterial));
        guardar(lista);
    }
}
