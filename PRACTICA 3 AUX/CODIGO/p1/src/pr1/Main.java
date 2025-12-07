/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1;
public class Main {
    public static void main(String[] args) {
        ArchivoCharango arch = new ArchivoCharango("charangos.json");

        boolean[] cuerdasOK = {true,true,true,true,true,true,true,true,true,true};
        boolean[] cuerdasMal = {true,false,false,false,false,false,false,false,false,false};

        arch.agregar(new Charango("Madera", 10, cuerdasOK));
        arch.agregar(new Charango("Roble", 10, cuerdasMal));

        System.out.println("=== LISTA ===");
        arch.listar();

        System.out.println("\n=== CHARANGOS CON 10 CUERDAS ===");
        arch.buscar10Cuerdas();

        System.out.println("\n=== ORDENADOS POR MATERIAL ===");
        arch.ordenarPorMaterial();
        arch.listar();
    }
}
