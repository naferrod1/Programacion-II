/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr4;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArchiNota archivo = new ArchiNota("notas.json");


        Estudiante e1 = new Estudiante("001", "Ana", "Lopez", "Perez", 20);
        Estudiante e2 = new Estudiante("002", "Luis", "Gomez", "Martinez", 21);


        Nota n1 = new Nota("Matematicas", 85, e1);
        Nota n2 = new Nota("Fisica", 90, e2);
        Nota n3 = new Nota("Matematicas", 90, e2);


        archivo.agregarNotas(Arrays.asList(n1, n2, n3));

    
        System.out.println("Promedio: " + archivo.promedioNotas());

        System.out.println("Mejores notas:");
        for (Nota n : archivo.mejoresNotas()) {
            System.out.println(n.getEstudiante().getNombre() + " - " + n.getNotaFinal());
        }

        archivo.eliminarPorMateria("Matematicas");

    
        archivo.mostrarNotas();
    }
}
