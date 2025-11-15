class CodigoDuplicadoException(Exception):
    pass

class ProductoNoEncontradoException(Exception):
    pass

class StockInsuficienteException(Exception):
    pass


class Producto:
    def __init__(self, codigo, nombre, precio, stock):
        self.codigo = codigo
        self.nombre = nombre
        self.precio = precio
        self.stock = stock


class Inventario:
    def __init__(self):
        self.productos = []

    def agregarProducto(self, p: Producto):
        # Verificar si existe código
        for prod in self.productos:
            if prod.codigo == p.codigo:
                raise CodigoDuplicadoException("Código duplicado o stock negativo.")

        if p.stock < 0 or p.precio < 0:
            raise CodigoDuplicadoException("Código duplicado o stock negativo.")

        self.productos.append(p)

    def buscarProducto(self, codigo):
        for prod in self.productos:
            if prod.codigo == codigo:
                return prod
        raise ProductoNoEncontradoException("El producto no existe.")

    def venderProducto(self, codigo, cantidad):
        producto = self.buscarProducto(codigo)

        if producto.stock < cantidad:
            raise StockInsuficienteException("Stock insuficiente.")

        producto.stock -= cantidad
        print(f"Venta realizada. Nuevo stock de {producto.nombre}: {producto.stock}")


def main():
    print("=== PRUEBAS DEL INVENTARIO ===")
    inv = Inventario()

    try:
        inv.agregarProducto(Producto("A1", "Galletas", 5, 20))
        print("Producto agregado correctamente.")
    except Exception as e:
        print("Error:", e)


    try:
        inv.agregarProducto(Producto("A1", "Refresco", 8, 10))
    except Exception as e:
        print("Error esperado:", e)


    try:
        inv.venderProducto("A1", 5)
    except Exception as e:
        print("Error:", e)

    try:
        inv.venderProducto("A1", 100)
    except Exception as e:
        print("Error esperado:", e)


    try:
        inv.venderProducto("XX", 1)
    except Exception as e:
        print("Error esperado:", e)


if __name__ == "__main__":
    main()
