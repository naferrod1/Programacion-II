class Ropa:
    def __init__(self, tipo, material):
        self.tipo = tipo
        self.material = material


class Ropero:
    def __init__(self, material):
        self.material = material
        self.ropa = []

    def agregarRopa(self, r):
        self.ropa.append(r)

    def eliminarPorMaterial(self, mat):
        self.ropa = [r for r in self.ropa if r.material != mat]

    def eliminarPorTipo(self, tipo):
        self.ropa = [r for r in self.ropa if r.tipo != tipo]

    def mostrarPorMaterial(self, mat):
        for r in self.ropa:
            if r.material == mat:
                print(r.tipo, r.material)

    def mostrarPorTipo(self, tipo):
        for r in self.ropa:
            if r.tipo == tipo:
                print(r.tipo, r.material)
def main():
 
    mi_ropero = Ropero("Madera")

    prendas = [
        Ropa("Camiseta", "Algodón"),
        Ropa("Pantalón", "Jean"),
        Ropa("Chaqueta", "Cuero"),
        Ropa("Falda", "Algodón"),
        Ropa("Camisa", "Seda"),
        Ropa("Short", "Algodón")
    ]

    for prenda in prendas:
        mi_ropero.agregarRopa(prenda)

    print("=== Todas las prendas agregadas ===")
    for r in mi_ropero.ropa:
        print(r.tipo, r.material)

    mi_ropero.eliminarPorMaterial("Algodón")
    print("\n=== Después de eliminar prendas de material 'Algodón' ===")
    for r in mi_ropero.ropa:
        print(r.tipo, r.material)


    mi_ropero.eliminarPorTipo("Camisa")
    print("\n=== Después de eliminar prendas de tipo 'Camisa' ===")
    for r in mi_ropero.ropa:
        print(r.tipo, r.material)

    print("\n=== Prendas de material 'Cuero' ===")
    mi_ropero.mostrarPorMaterial("Cuero")

    print("\n=== Prendas de tipo 'Pantalón' ===")
    mi_ropero.mostrarPorTipo("Pantalón")


if __name__ == "__main__":
    main()
