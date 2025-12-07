/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr3;
import java.io.*;
import java.util.*;

public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String nomA) {
        this.nomA = nomA;
    }

    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(new ArrayList<Producto>());
            System.out.println("Archivo creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardaProducto(Producto p) {
        List<Producto> lista = leerProductos();
        lista.add(p);
        escribirProductos(lista);
    }

    public Producto buscaProducto(int c) {
        for (Producto p : leerProductos()) {
            if (p.getCodigo() == c) {
                return p;
            }
        }
        return null;
    }

    public float promedioPrecios() {
        List<Producto> lista = leerProductos();
        if (lista.isEmpty()) return 0;
        float suma = 0;
        for (Producto p : lista) {
            suma += p.getPrecio();
        }
        return suma / lista.size();
    }

    public Producto productoMasCaro() {
        List<Producto> lista = leerProductos();
        return lista.stream().max(Comparator.comparing(Producto::getPrecio)).orElse(null);
    }

    private List<Producto> leerProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (List<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void escribirProductos(List<Producto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}