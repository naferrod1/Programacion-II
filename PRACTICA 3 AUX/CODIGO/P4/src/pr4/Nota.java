/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr4;
// Nota.java
public class Nota {
    private String materno; // nombre de la materia
    private double notaFinal;
    private Estudiante estudiante;

    public Nota(String materno, double notaFinal, Estudiante estudiante) {
        this.materno = materno;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
    }

    // Getters y setters
    public String getMaterno() { return materno; }
    public double getNotaFinal() { return notaFinal; }
    public Estudiante getEstudiante() { return estudiante; }
}
