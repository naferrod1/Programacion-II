class Pasajero:
    def __init__(self, nombre, edad, genero, nroHabitacion, costoPasaje):
        self.nombre = nombre
        self.edad = edad
        self.genero = genero  # "M" o "F"
        self.nroHabitacion = nroHabitacion
        self.costoPasaje = costoPasaje

    def __str__(self):
        return f"{self.nombre} ({self.genero}, {self.edad} años) - Hab: {self.nroHabitacion}, Bs.{self.costoPasaje}"


class Crucero:
    def __init__(self, nombre, paisOrigen, paisDestino):
        self.nombre = nombre
        self.paisOrigen = paisOrigen
        self.paisDestino = paisDestino
        self.pasajeros = []
        self.nroPasajeros = 0

    #agregar pasajero
    def __iadd__(self, pasajero):
        self.pasajeros.append(pasajero)
        self.nroPasajeros += 1
        return self

    #mostrar pasajeros
    def __isub__(self, value):
        print(f"Crucero {self.nombre} ({self.nroPasajeros} pasajeros):")
        for p in self.pasajeros:
            print(" -", p)
        return self

    #suma de pasajes
    def __eq__(self, other):
        total = sum(p.costoPasaje for p in self.pasajeros)
        return total

    #comparar nro pasajeros
    def __add__(self, other):
        if self.nroPasajeros == other.nroPasajeros:
            return "Ambos cruceros tienen la misma cantidad de pasajeros."
        else:
            return "Los cruceros tienen diferente cantidad de pasajeros."

    #contar hombres y mujeres
    def __sub__(self, value):
        hombres = sum(1 for p in self.pasajeros if p.genero == "M")
        mujeres = sum(1 for p in self.pasajeros if p.genero == "F")
        print(f"En {self.nombre} hay {hombres} hombres y {mujeres} mujeres.")
        return None


#main
# Crear cruceros
c1 = Crucero("Titanic", "UK", "NY")
c2 = Crucero("Caribbean", "Brasil", "Miami")

# Crear pasajeros
p1 = Pasajero("Juan Vargas", 30, "M", 502, 500)
p2 = Pasajero("Martina Vasques", 25, "F", 603, 1000)
p3 = Pasajero("Wilmer Montero", 40, "M", 401, 925)
p4 = Pasajero("Ana Lopez", 20, "F", 202, 700)
p5 = Pasajero("Luis Perez", 28, "M", 305, 800)

# Agregar pasajeros
c1 += p1
c1 += p2
c1 += p3

c2 += p4
c2 += p5

# Mostrar pasajeros 
c1 -= 1
c2 -= 1

# Suma total pasajes
print("Total pasajes c1:", c1 == c2)
print("Total pasajes c2:", c2 == c1)

# Comparar cantidad pasajeros
print(c1 + c2)

# Contar hombresy mujeres
c1 - 1
c2 - 1
