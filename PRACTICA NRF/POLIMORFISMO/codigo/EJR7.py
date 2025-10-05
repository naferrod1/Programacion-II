class Parada:
    def __init__(self, nombreP="Desconocido"):
        self.admins = [None] * 10
        self.dueños = [[None, None, None] for _ in range(10)] 
        self.nombreP = nombreP
        self.nroAdmins = 0
        self.nroAutos = 0

    def mostrar(self):
        print(f"Parada: {self.nombreP}")
        print("Administradores:")
        for i in range(self.nroAdmins):
            print(f" - {self.admins[i]}")

        print("Autos:")
        for i in range(self.nroAutos):
            modelo, conductor, placa = self.dueños[i]
            print(f"  Modelo: {modelo}, Conductor: {conductor}, Placa: {placa}")
        print()

    # adicionar un admin
    def adicionar(self, *args):
        if len(args) == 1:
            if self.nroAdmins < 10:
                self.admins[self.nroAdmins] = args[0]
                self.nroAdmins += 1
            else:
                print("No hay espacio para más administradores.")
        
        # adicionar un auto
        elif len(args) == 3:
            if self.nroAutos < 10:
                self.dueños[self.nroAutos] = [args[0], args[1], args[2]]
                self.nroAutos += 1
            else:
                print("No hay espacio para más autos.")
        else:
            print("Error en parámetros para adicionar.")


p1 = Parada()
p1.adicionar("Carlos")  # admin
p1.adicionar("Toyota", "Juan Pérez", "1234ABC")  # auto
p1.mostrar()

p2 = Parada("Parada Central")
p2.adicionar("Lucía")
p2.adicionar("Nissan", "Ana Torres", "5678XYZ")
p2.mostrar()
