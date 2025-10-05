class Animal:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def desplazarse(self):
        raise NotImplementedError("Este método debe implementarse en las subclases")


class Leon(Animal):
    def __init__(self, nombre, edad):
        super().__init__(nombre, edad)

    def desplazarse(self):
        return f"{self.nombre} (León) corre majestuosamente."


class Pinguino(Animal):
    def __init__(self, nombre, edad):
        super().__init__(nombre, edad)

    def desplazarse(self):
        return f"{self.nombre} (Pingüino) nada y luego camina torpemente."


class Canguro(Animal):
    def __init__(self, nombre, edad):
        super().__init__(nombre, edad)

    def desplazarse(self):
        return f"{self.nombre} (Canguro) salta con potentes zancadas."


if __name__ == "__main__":
    animales = [Leon("Simba",5), Pinguino("Pingo",2), Canguro("Roo",3)]
    for a in animales:
        print(a.desplazarse())
