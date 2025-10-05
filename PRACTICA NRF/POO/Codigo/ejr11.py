class Producto:
    def __init__(self, nombre: str, precio: float):
        self._nombre = nombre
        self._precio = precio
        print(f"Producto: {self._nombre}")

    
    def get_nombre(self):
        return self._nombre

    def get_precio(self):
        return self._precio

    
    def set_nombre(self, nuevo_nombre):
        self._nombre = nuevo_nombre

    def set_precio(self, nuevo_precio):
        self._precio = nuevo_precio

    def __del__(self):
        print(f"Producto: {self._nombre} eliminado.")


class Pedido:
    def __init__(self, numero: int, estado: str):
        self._numero = numero
        self._estado = estado
        print(f"Pedido: {self._numero}")

  
    def get_numero(self):
        return self._numero

    def get_estado(self):
        return self._estado


    def set_numero(self, nuevo_numero):
        self._numero = nuevo_numero

    def set_estado(self, nuevo_estado):
        self._estado = nuevo_estado

    def __del__(self):
        print(f"Pedido {self._numero} eliminado.")


#CREAROBJ
producto1 = Producto("Café Latte", 4.50)
pedido1 = Pedido(101, "Registrado")

#MOSTRAR
print(f"Producto: {producto1.get_nombre()}, Precio: Bs. {producto1.get_precio()}")
print(f"Pedido: {pedido1.get_numero()}, Estado: {pedido1.get_estado()}")
