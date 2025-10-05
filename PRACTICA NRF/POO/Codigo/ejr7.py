class Mascota:
    def __init__(self, nombre: str, tipo: str):
        self.nombre = nombre
        self._tipo = tipo
        self._energia = 50  

    def mostrar(self) -> None:
        print(f"{self.nombre} ({self._tipo}) - Energía: {self._energia}")

    def alimentar(self) -> None:
        self._energia += 20
        if self._energia > 100:
            self._energia = 100
        print(f"{self.nombre} fue alimentado. Energía actual: {self._energia}")

    def jugar(self) -> None:
        self._energia -= 15
        if self._energia < 0:
            self._energia = 0
        print(f"{self.nombre} jugó. Energía actual: {self._energia}")


mascota1 = Mascota("pepa", "Perro")
mascota2 = Mascota("Misha", "Gato")

mascota1.mostrar()
mascota2.mostrar()

mascota1.alimentar()
mascota2.alimentar()

mascota1.jugar()
mascota2.jugar()

mascota1.mostrar()
mascota2.mostrar()
