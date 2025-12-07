package pr7;
public class Niño extends Persona {
    private int edad;
    private int peso;
    private String talla;

    public Niño() {}

    public Niño(String nombre, String apellidoPaterno, String apellidoMaterno, int ci,
                int edad, int peso, String talla) {
        super(nombre, apellidoPaterno, apellidoMaterno, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() { return edad; }
    public int getPeso() { return peso; }
    public String getTalla() { return talla; }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Edad: " + edad + "  Peso: " + peso + "  Talla: " + talla);
    }
}