/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr4;
// ArchiNota.java
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class ArchiNota {
    private String nombreArchi;
    private List<Nota> notas;

    public ArchiNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
        this.notas = new ArrayList<>();
        cargar();
    }

    // Guardar en JSON
    private void guardar() {
        try (Writer writer = new FileWriter(nombreArchi)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(notas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar desde JSON
    private void cargar() {
        try (Reader reader = new FileReader(nombreArchi)) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<List<Nota>>() {}.getType();
            notas = gson.fromJson(reader, tipoLista);
            if (notas == null) notas = new ArrayList<>();
        } catch (IOException e) {
            notas = new ArrayList<>();
        }
    }

    // Agregar varios estudiantes con sus notas
    public void agregarNotas(List<Nota> nuevasNotas) {
        notas.addAll(nuevasNotas);
        guardar();
    }

    // Obtener promedio de todas las notas
    public double promedioNotas() {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (Nota n : notas) {
            suma += n.getNotaFinal();
        }
        return suma / notas.size();
    }

    // Buscar estudiantes con la mejor nota
    public List<Nota> mejoresNotas() {
        List<Nota> mejores = new ArrayList<>();
        double max = -1;
        for (Nota n : notas) {
            if (n.getNotaFinal() > max) {
                max = n.getNotaFinal();
                mejores.clear();
                mejores.add(n);
            } else if (n.getNotaFinal() == max) {
                mejores.add(n);
            }
        }
        return mejores;
    }

    // Eliminar estudiantes de una materia específica
    public void eliminarPorMateria(String materia) {
        notas.removeIf(n -> n.getMaterno().equalsIgnoreCase(materia));
        guardar();
    }

    // Mostrar todas las notas (opcional para probar)
    public void mostrarNotas() {
        for (Nota n : notas) {
            System.out.println("Materia: " + n.getMaterno() + ", Nota: " + n.getNotaFinal() + 
                ", Estudiante: " + n.getEstudiante().getNombre());
        }
    }
}
