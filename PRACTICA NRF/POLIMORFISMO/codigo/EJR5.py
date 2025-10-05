class Celular:
    def __init__(self, nroTel, dueño, espacio: float, ram: float, nroApp: int):
        self.nroTel = nroTel
        self.dueño = dueño
        self.espacio = float(espacio)
        self.ram = float(ram)
        self.nroApp = nroApp

    def __str__(self):
        return (f"Celular({self.nroTel}, dueño: {self.dueño}, "
                f"espacio: {self.espacio}GB, RAM: {self.ram}GB, apps: {self.nroApp})")

    def __pos__(self):   #aumenta apps
        self.nroApp += 10
        return self

    def __neg__(self):   #reduce espacio
        self.espacio -= 5.0
        if self.espacio < 0:
            self.espacio = 0.0
        return self
#main

c1 = Celular("777-888", "Fabricio", 64.0, 6.0, 20)

print("Antes de operadores:")
print(c1)

+c1
print("\nDespués de aumenar apps :")
print(c1)

-c1
print("despues de reducir espacio")
print(c1)
