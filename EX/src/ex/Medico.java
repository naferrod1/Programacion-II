/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex;
public class Medico {
    int idMed;
    String nombreMed;
    String apellidoMed;
    int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    // Getters
    public int getIdMed() {
        return idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public String getApellidoMed() {
        return apellidoMed;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
}

