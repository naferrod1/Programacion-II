/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr2;
public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador arch = new ArchivoTrabajador("trabajadores.dat");

        arch.crear();
        arch.guardar(new Trabajador("Gio", 3000));
        arch.guardar(new Trabajador("Franco", 2500));
        arch.guardar(new Trabajador("Armando", 4000));

        System.out.println("=== LISTA ===");
        arch.listar();

        System.out.println("\n=== BUSCAR: Luis ===");
        Trabajador t = arch.buscar("Luis");
        System.out.println(t != null ? t : "No encontrado");

        System.out.println("\n=== ORDENADOS POR SALARIO ===");
        arch.ordenarPorSalario();
        arch.listar();
    }
}
