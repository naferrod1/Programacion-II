class videojuego:
    def __init__(self, nombre="desconocido", plataforma="desconocido", jugadores=0):
        self.nombre=nombre if nombre else "desconocido"
        self.plataforma=plataforma if plataforma else "desconocido"
        self.cantidad_jugadores=jugadores
        print(f"videojuego: {self.nombre}, plataforma: {self.plataforma}, jugadores: {self.cantidad_jugadores}")

    def mostrar(self):
        print(f"{self.nombre} ({self.plataforma}) - Jugadores: {self.cantidad_jugadores}")

    def agregarJugadores(self, jugadores = None):
        if jugadores is None:
            self.cantidad_jugadores += 1
            print(f"se agrego 1 jugador, total de jugadores: {self.cantidad_jugadores}")
        else:
            self.cantidad_jugadores += jugadores
            print(f"total de jugadores: {self.cantidad_jugadores}")

v1=videojuego("sonic", "nintendo", 0)
v2=videojuego("gtaV", "rockstargames", 0)

v1.mostrar()
v2.mostrar()

v1.agregarJugadores()
cantidad = int(input("Ingresa número de jugadores a agregar para v2: "))
v2.agregarJugadores(cantidad)


        