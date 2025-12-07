package pr5;
import java.util.ArrayList;
import java.util.Comparator;

public class Operaciones {

    // a) Mostrar medicamentos para la tos de la sucursal X
    public void mostrarTosSucursal(ArrayList<Farmacia> lista, int suc) {
        for (Farmacia f : lista) {
            if (f.getSucursal() == suc) {
                System.out.println("Medicamentos para la tos en sucursal " + suc);
                for (Medicamento m : f.getMedicamentos()) {
                    if (m.getTipo().equalsIgnoreCase("tos")) {
                        System.out.println(m);
                    }
                }
            }
        }
    }

    // b) Mostrar sucursal + dirección donde existe "Tapsin"
    public void sucursalesConTapsin(ArrayList<Farmacia> lista) {
        for (Farmacia f : lista) {
            Medicamento m = f.buscarMedicamento("Tapsin");
            if (m != null) {
                System.out.println("Sucursal: " + f.getSucursal() +
                        " | Dirección: " + f.getDireccion());
            }
        }
    }

    // c) Buscar medicamentos por tipo
    public void buscarPorTipo(ArrayList<Farmacia> lista, String tipo) {
        for (Farmacia f : lista) {
            for (Medicamento m : f.getMedicamentos()) {
                if (m.getTipo().equalsIgnoreCase(tipo)) {
                    System.out.println(f.getNombreFarmacia() + ": " + m);
                }
            }
        }
    }

    // d) Ordenar farmacias por dirección alfabéticamente
    public void ordenarPorDireccion(ArrayList<Farmacia> lista) {
        lista.sort(Comparator.comparing(Farmacia::getDireccion));
    }

    // e) Mover medicamentos de tipo X de farmacia Y -> farmacia Z
    public void moverTipo(ArrayList<Farmacia> lista,
                          int sucursalOrigen, int sucursalDestino, String tipo) {

        Farmacia origen = null, destino = null;

        for (Farmacia f : lista) {
            if (f.getSucursal() == sucursalOrigen) origen = f;
            if (f.getSucursal() == sucursalDestino) destino = f;
        }

        if (origen == null || destino == null) return;

        ArrayList<Medicamento> mover = new ArrayList<>();

        for (Medicamento m : origen.getMedicamentos()) {
            if (m.getTipo().equalsIgnoreCase(tipo))
                mover.add(m);
        }

        origen.getMedicamentos().removeAll(mover);
        destino.getMedicamentos().addAll(mover);

        System.out.println("Se movieron " + mover.size() + " medicamentos.");
    }
}
