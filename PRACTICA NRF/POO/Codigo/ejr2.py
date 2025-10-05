class Bus:
    def __init__(self, capacidad):
        self.capacidad = capacidad        
        self.pasajeros = 0               
        self.costo_pasaje = 1.50        

    def Subirpasajeros(self, cantidad):
        if self.pasajeros + cantidad <= self.capacidad:
            self.pasajeros += cantidad
            print(f"Subieron {cantidad} pasajeros. Total ahora: {self.pasajeros}")
        else:
            espacioDisponible = self.capacidad - self.pasajeros
            print(f"No pueden subir {cantidad} pasajeros. Solo hay {espacioDisponible} asientos disponibles.")

    def CobrarPasajes(self):
        total = self.pasajeros * self.costo_pasaje
        print(f"Se cobraron Bs. {total:.2f} en total a {self.pasajeros} pasajeros.")
        return total

    def AsientosDisponibles(self):
        disponibles = self.capacidad - self.pasajeros
        print(f"Asientos disponibles: {disponibles}")
        return disponibles


mi_bus = Bus(capacidad=40)

#main
mi_bus.Subirpasajeros(25)       
mi_bus.AsientosDisponibles()  
mi_bus.CobrarPasajes()          

mi_bus.Subirpasajeros(20)     
mi_bus.AsientosDisponibles()
