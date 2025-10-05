class Vehiculo:
    def __init__(self, conductor, placa, id):
        self.conductor = conductor
        self.placa = placa
        self.id = id

    def mostrar_placa_conductor(self):
        return f"Placa: {self.placa} | Conductor: {self.conductor}"

    def cambiar_conductor(self, nuevo):
        old = self.conductor
        self.conductor = nuevo
        return f"Conductor cambiado de {old} a {self.conductor}"


class Bus(Vehiculo):
    def __init__(self, conductor, placa, id, capacidad, sindicato):
        super().__init__(conductor, placa, id)
        self.capacidad = capacidad
        self.sindicato = sindicato


class Auto(Vehiculo):
    def __init__(self, conductor, placa, id, caballosFuerza, descapotable):
        super().__init__(conductor, placa, id)
        self.caballosFuerza = caballosFuerza
        self.descapotable = descapotable


class Moto(Vehiculo):
    def __init__(self, conductor, placa, id, cilindrada, casco):
        super().__init__(conductor, placa, id)
        self.cilindrada = cilindrada
        self.casco = casco


if __name__ == "main":
    bus = Bus("Carlos","BUS-100",1,50,"S1")
    auto = Auto("Lucia","AUTO-55",2,120,False)
    moto = Moto("Pablo","MOTO-9",3,150,True)

    for v in (bus, auto, moto):
        print(v.mostrar_placa_conductor())

    print(bus.cambiar_conductor("Miguel"))
    print(bus.mostrar_placa_conductor())
