package pr7;
public class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int ci;

    public Persona() {}

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ci = ci;
    }

    public void mostrar() {
        System.out.println(nombre + " " + apellidoPaterno + " " + apellidoMaterno + " | CI: " + ci);
    }
}