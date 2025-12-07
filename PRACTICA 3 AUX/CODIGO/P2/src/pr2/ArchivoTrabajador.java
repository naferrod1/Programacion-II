/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr2;
import java.io.*;
import java.util.*;

public class ArchivoTrabajador {
    private String nombre;

    public ArchivoTrabajador(String nombre) {
        this.nombre = nombre;
    }

    // Leer lista completa desde el archivo
    private List<Trabajador> leer() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre))) {
            return (List<Trabajador>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Guardar lista completa al archivo
    private void guardarLista(List<Trabajador> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear archivo vacío
    public void crear() {
        guardarLista(new ArrayList<>());
    }

    // Guardar (agregar trabajador)
    public void guardar(Trabajador t) {
        List<Trabajador> lista = leer();
        lista.add(t);
        guardarLista(lista);
    }

    // Buscar trabajador por nombre
    public Trabajador buscar(String nombre) {
        for (Trabajador t : leer()) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return t;
            }
        }
        return null;
    }

    // Ordenar por salario
    public void ordenarPorSalario() {
        List<Trabajador> lista = leer();
        lista.sort(Comparator.comparingDouble(Trabajador::getSalario));
        guardarLista(lista);
    }

    // Mostrar
    public void listar() {
        leer().forEach(System.out::println);
    }
}
