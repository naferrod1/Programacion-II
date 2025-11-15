class Medicamento:
    def __init__(self, nombre, fabricante):
        self.nombre = nombre
        self.fabricante = fabricante


class Antibiotico(Medicamento):
    def __init__(self, nombre, fabricante, dosis):
        super().__init__(nombre, fabricante)
        self.dosis = dosis


class Analgesico(Medicamento):
    def __init__(self, nombre, fabricante, intensidad):
        super().__init__(nombre, fabricante)
        self.intensidad = intensidad


class Registro:
    def __init__(self, fecha, medicamento, cantidad):
        self.fecha = fecha
        self.medicamento = medicamento
        self.cantidad = cantidad


class Farmacia:
    def __init__(self, nombre, ubicacion):
        self.nombre = nombre
        self.ubicacion = ubicacion
        self.medicamentos = []

    def agregarMedicamento(self, med):
        self.medicamentos.append(med)

    def mostrarInventario(self):
        print(f"\nInventario de {self.nombre} ({self.ubicacion}):")
        if not self.medicamentos:
            print("  No hay medicamentos.")
        else:
            for m in self.medicamentos:
                info = f"{m.nombre} - Fabricante: {m.fabricante}"
                if isinstance(m, Antibiotico):
                    info += f" - Dosis: {m.dosis}"
                elif isinstance(m, Analgesico):
                    info += f" - Intensidad: {m.intensidad}"
                print(" ", info)


def main():
    # Crear medicamentos
    prod1 = Antibiotico("Amoxicilina", "Farmacia A", "500mg")
    prod2 = Analgesico("Ibuprofeno", "Farmacia B", "Media")
    prod3 = Antibiotico("Ciprofloxacino", "Farmacia C", "250mg")
    prod4 = Analgesico("Paracetamol", "Farmacia D", "Alta")
    prod5 = Medicamento("Alcohol Gel", "LimpiezaPlus")

    # Crear farmacia
    mi_farmacia = Farmacia("Farmacia Central", "Calle Principal")

    # Agregar medicamentos al inventario
    for prod in [prod1, prod2, prod3, prod4, prod5]:
        mi_farmacia.agregarMedicamento(prod)

    # Mostrar inventario
    mi_farmacia.mostrarInventario()

    # Registrar compras
    compra1 = Registro("15/11/2025", prod2, 2)  # Ibuprofeno
    compra2 = Registro("15/11/2025", prod5, 1)  # Alcohol Gel

    print("\n=== Compras realizadas ===")
    print(f"{compra1.cantidad} x {compra1.medicamento.nombre} - Fabricante: {compra1.medicamento.fabricante}")
    print(f"{compra2.cantidad} x {compra2.medicamento.nombre} - Fabricante: {compra2.medicamento.fabricante}")


if __name__ == "__main__":
    main()