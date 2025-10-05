class Persona:
    def __init__(self, nombre, apellido, ci):
        self.nombre = nombre
        self.apellido = apellido
        self.ci = ci

    def mostrar(self):
        return f"Persona: {self.nombre} {self.apellido} (CI: {self.ci})"


class Cliente(Persona):
    def __init__(self, nombre, apellido, ci, nroCompra, idCliente):
        super().__init__(nombre, apellido, ci)
        self.nroCompra = nroCompra
        self.idCliente = idCliente

    def mostrar(self):
        base = super().mostrar()
        return f"{base} | Cliente id:{self.idCliente} nroCompra:{self.nroCompra}"


class Jefe(Persona):
    def __init__(self, nombre, apellido, ci, sucursal, tipo):
        super().__init__(nombre, apellido, ci)
        self.sucursal = sucursal
        self.tipo = tipo

    def mostrar(self):
        base = super().mostrar()
        return f"{base} | Jefe sucursal:{self.sucursal} tipo:{self.tipo}"


# Demo
if __name__ == "__main__":
    p = Persona("Ana","Gomez","123456")
    c = Cliente("Luis","Perez","987654", 10, "C-01")
    j = Jefe("María","Lopez","555333", "Centro", "Regional")
    print(p.mostrar())
    print(c.mostrar())
    print(j.mostrar())
