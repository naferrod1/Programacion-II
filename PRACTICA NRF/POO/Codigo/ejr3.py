class Producto:
    def __init__(self, nombre: str, precio: float, stock: int):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock

    def vender(self, cantidad: int) -> None:
        if cantidad <= self.stock:
            self.stock -= cantidad
            print(f"Se vendieron {cantidad} {self.nombre}. Stock actual: {self.stock}")
        else:
            print(f"No hay suficiente stock para vender {cantidad}. Stock disponible: {self.stock}")

    def reabastecer(self, cantidad: int) -> None:
        self.stock += cantidad
        print(f"Se reabasteció {cantidad} {self.nombre}. Stock actual: {self.stock}")


# main
producto1 = Producto("celular", 3500.0, 10)

producto1.vender(3)       
producto1.vender(15)       
producto1.reabastecer(20) 
