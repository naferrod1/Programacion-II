
package pr7;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArchNiño archivo = new ArchNiño();
    static ArrayList<Niño> lista = new ArrayList<>();

    public static void main(String[] args) {
        lista = archivo.cargar();

        int op;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("\n--- ELIJA UNA OPCIÓN ---");
            System.out.println("1. Crear Niño");
            System.out.println("2. Listar Niños");
            System.out.println("3. Peso adecuado (b)");
            System.out.println("4. Mostrar peso/talla NO adecuados (c)");
            System.out.println("5. Promedio edad (d)");
            System.out.println("6. Buscar por CI (e)");
            System.out.println("7. Mostrar niños con talla más alta (f)");
            System.out.println("0. Salir");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> crearNiño();
                case 2 -> listar();
                case 3 -> pesoAdecuado();
                case 4 -> noAdecuados();
                case 5 -> promedioEdad();
                case 6 -> buscarPorCI();
                case 7 -> tallaMasAlta();
            }

            archivo.guardar(lista);
        } while (op != 0);
    }

    // a) Crear, leer, listar, mostrar
    public static void crearNiño() {
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Apellido Paterno: ");
        String ap = sc.nextLine();
        System.out.print("Apellido Materno: ");
        String am = sc.nextLine();
        System.out.print("CI: ");
        int ci = sc.nextInt();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Peso: ");
        int peso = sc.nextInt();
        sc.nextLine();
        System.out.print("Talla: ");
        String talla = sc.nextLine();

        lista.add(new Niño(n, ap, am, ci, edad, peso, talla));
    }

    public static void listar() {
        for (Niño n : lista) {
            n.mostrar();
            System.out.println("---------------------");
        }
    }

    // b) Cuántos niños tienen el peso adecuado según su talla y edad
    public static void pesoAdecuado() {
        int count = 0;
        for (Niño n : lista) {
            if (n.getPeso() >= n.getEdad() * 2 && n.getPeso() <= n.getEdad() * 4) {
                count++;
            }
        }
        System.out.println("Niños con peso adecuado: " + count);
    }

    // c) Mostrar niños no adecuados
    public static void noAdecuados() {
        for (Niño n : lista) {
            if (!(n.getPeso() >= n.getEdad() * 2 && n.getPeso() <= n.getEdad() * 4)) {
                n.mostrar();
                System.out.println("-------------------");
            }
        }
    }

    // d) Promedio edad
    public static void promedioEdad() {
        if (lista.isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }

        int sum = 0;
        for (Niño n : lista) sum += n.getEdad();
        System.out.println("Promedio edad: " + (sum / lista.size()));
    }

    // e) Buscar por CI
    public static void buscarPorCI() {
        System.out.print("Ingrese CI: ");
        int ci = sc.nextInt();

        for (Niño n : lista) {
            if (n.ci == ci) {
                n.mostrar();
                return;
            }
        }
        System.out.println("No encontrado");
    }

    // f) Niños con la talla más alta
    public static void tallaMasAlta() {
        if (lista.isEmpty()) return;

        String maxTalla = lista.get(0).getTalla();

        for (Niño n : lista) {
            if (n.getTalla().compareTo(maxTalla) > 0)
                maxTalla = n.getTalla();
        }

        System.out.println("Niños con la talla más alta (" + maxTalla + "):");
        for (Niño n : lista) {
            if (n.getTalla().equals(maxTalla))
                n.mostrar();
        }
    }
}