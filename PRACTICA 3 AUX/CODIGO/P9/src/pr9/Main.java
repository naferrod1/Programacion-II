/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr9;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArchZoo archivo = new ArchZoo("zoologicos.json");
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n===== MENU ZOOLOGICOS =====");
            System.out.println("1. Crear zoologico");
            System.out.println("2. Modificar zoologico");
            System.out.println("3. Eliminar zoologico");
            System.out.println("4. Listar zoologicos con mayor variedad");
            System.out.println("5. Eliminar zoologicos vacios");
            System.out.println("6. Mostrar animales de especie X");
            System.out.println("7. Mover animales entre zoologicos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            op = sc.nextInt();

            switch(op) {

                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    archivo.crear(new Zoologico(id, nombre));
                }

                case 2 -> archivo.modificar();

                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    archivo.eliminar(id);
                }

                case 4 -> archivo.listarMayoresVariedades();

                case 5 -> archivo.eliminarVacios();

                case 6 -> {
                    sc.nextLine();
                    System.out.print("Especie: ");
                    String especie = sc.nextLine();
                    archivo.mostrarEspecie(especie);
                }

                case 7 -> {
                    System.out.print("ID origen: ");
                    int o = sc.nextInt();
                    System.out.print("ID destino: ");
                    int d = sc.nextInt();
                    archivo.mover(o, d);
                }
            }

        } while (op !=0);
    }
}