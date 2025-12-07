package pr5;
import java.util.ArrayList;

public class Farmacia {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private ArrayList<Medicamento> medicamentos;

    public Farmacia() {
        medicamentos = new ArrayList<>();
    }

    public Farmacia(String nombre, int sucursal, String direccion) {
        this.nombreFarmacia = nombre;
        this.sucursal = sucursal;
        this.direccion = direccion;
        medicamentos = new ArrayList<>();
    }

    public int getSucursal() { return sucursal; }
    public String getDireccion() { return direccion; }
    public String getNombreFarmacia() { return nombreFarmacia; }
    public ArrayList<Medicamento> getMedicamentos() { return medicamentos; }

    public void agregarMedicamento(Medicamento m){
        medicamentos.add(m);
    }

    public Medicamento buscarMedicamento(String nombre) {
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombre))
                return m;
        }
        return null;
    }
}
