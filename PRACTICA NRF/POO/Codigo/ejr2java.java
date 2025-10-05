/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package producto;

/**
 *
 * @author NATALIA
 */
public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Método vender
    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Se vendieron " + cantidad + " " + nombre +
                               ". Stock actual: " + stock);
        } else {
            System.out.println("No hay suficiente stock para vender " + cantidad +
                               ". Stock disponible: " + stock);
        }
    }

    // Método reabastecer
    public void reabastecer(int cantidad) {
        stock += cantidad;
        System.out.println("Se reabasteció " + cantidad + " " + nombre +
                           ". Stock actual: " + stock);
    }
}
