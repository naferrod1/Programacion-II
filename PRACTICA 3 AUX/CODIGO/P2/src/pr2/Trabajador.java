/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr2;
import java.io.Serializable;

public class Trabajador implements Serializable {
    private String nombre;
    private double salario;

    public Trabajador(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }

    @Override
    public String toString() {
        return nombre + " - Bs. " + salario;
    }
}

