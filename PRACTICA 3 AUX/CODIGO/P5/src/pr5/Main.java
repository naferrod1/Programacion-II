package pr5;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        ArchFarmacia arch = new ArchFarmacia();
        Operaciones op = new Operaciones();

        ArrayList<Farmacia> lista = arch.cargar();

        // Si no existe JSON, crear farmacias iniciales
        if (lista.isEmpty()) {
            Farmacia f1 = new Farmacia("Cruz Azul", 1, "Av. Siempre Viva 123");
            f1.agregarMedicamento(new Medicamento("Tapsin", 101, "resfrio", 12));
            f1.agregarMedicamento(new Medicamento("Jarabe Miel", 102, "tos", 20));

            Farmacia f2 = new Farmacia("BoliviaPharma", 2, "Calle Bolivar 45");
            f2.agregarMedicamento(new Medicamento("Antigripal", 201, "resfrio", 10));
            f2.agregarMedicamento(new Medicamento("Broncolin", 202, "tos", 18));

            lista.add(f1);
            lista.add(f2);

            arch.guardar(lista);
        }

        // --- PRUEBAS DE LOS INCISOS ---
        System.out.println("\n(a) Mostrar medicamentos para la tos de sucursal 1:");
        op.mostrarTosSucursal(lista, 1);

        System.out.println("\n(b) Sucursales con Tapsin:");
        op.sucursalesConTapsin(lista);

        System.out.println("\n(c) Buscar medicamentos por tipo 'resfrio':");
        op.buscarPorTipo(lista, "resfrio");

        System.out.println("\n(d) Ordenar farmacias por dirección:");
        op.ordenarPorDireccion(lista);
        for (Farmacia f : lista) System.out.println(f.getDireccion());

        System.out.println("\n(e) Mover medicamentos de tipo 'tos' de 1 → 2:");
        op.moverTipo(lista, 1, 2, "tos");

        // Guardar cambios en JSON
        arch.guardar(lista);
    }
}
