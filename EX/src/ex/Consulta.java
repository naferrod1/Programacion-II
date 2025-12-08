/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex;
public class Consulta {
    private int id;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int dia;
    private int mes;
    private int anio;
    private int idMed;  // Relación con Médico

    public Consulta(int id, String nombrePaciente, String apellidoPaciente,
                    int dia, int mes, int anio, int idMed) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.idMed = idMed;
    }

    public int getIdMed() { return idMed; }
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    public void setDia(int dia) { this.dia = dia; }
    public void setMes(int mes) { this.mes = mes; }
}
